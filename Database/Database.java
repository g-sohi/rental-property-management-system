package Database;

import Controller.*;
import Models.*;

import java.sql.*;
import java.util.*;

public class Database {

        private final String DBUSER;
        private final String DBPASS;
        private final String DBURL = "jdbc:mysql://localhost/rpms";
    
        private Connection dbConnect; // connection between database and program

        private ResultSet line;

        public Database() {
            String username = "root";
            String password = "singh123";
    
            try {

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to obtain mySQL login credentials. Please restart the program.");
                System.exit(1);
            }
            
            this.DBUSER = username;
            this.DBPASS = password;
    
            this.initializeConnection();
        }
    
        /**
         * initializeConnection() is a helper method called by the constructor. The
         * connection to the mySQL database is attempted using the user inputs. If the
         * login fails, an SQLException is caught and the program exits. 
         * No arguments taken, no return value.
         */
        public void initializeConnection() {
            try {
                this.dbConnect = DriverManager.getConnection(this.DBURL, this.DBUSER, this.DBPASS);
                System.out.println("Connection successful!\n\n");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Unable to Connect to mySQL. Check if the login credentials are correct.");
                System.exit(1);
            }
        }

        public void addUser() {
            try {
                String query = String.format("INSERT INTO user(UserName, Password, ID) VALUES ('David', 'ensf480', '3')");
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void verifyUser(String username, String password){
            try {
                String query = String.format("SELECT user.ID FROM user WHERE UserName = ? && Password = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                line = stmt.executeQuery();
                line.next();
                System.out.println(line.getInt("ID"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Property> getLandlordProperties(int landLordID) {
            ArrayList<Property> properties = new ArrayList<Property>();
            try {
                String query = String.format("SELECT * FROM property WHERE Landlord_ID = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                stmt.setInt(1, landLordID);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    String address = line.getString("Address");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    boolean isFurnished = false;
                    if(furnished.equalsIgnoreCase("yes")){
                        isFurnished = true;
                    }
                    String status = line.getString("Status");

                    Property prop = new Property(ID, address, type, numOfBedrooms, numOfBathrooms, isFurnished, new Fees(50.00, 0, "null", "null"), status);
                    properties.add(prop);
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error.Exiting program.");
                System.exit(1);
            }
            return properties;
        }



        public void close() {
            try {
                this.dbConnect.close();
            } catch (Exception e) {
                System.out.println("Error closing the Connection and ResultSet objects.");
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            Database db = new Database();
            int id = 3;
            Landlord land = new Landlord("Robin", "Robin", "Sio", id, "ensf480", "Manager", new Email("null", "null", "null", "null"), db.getLandlordProperties(id));
            System.out.println("Address: " + land.getProperties().get(0).getAddress() + "\nType: " + land.getProperties().get(0).getType());
            //db.addUser();
        }
}
