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
            String password = "Gurpartap12";
    
            try {

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to obtain mySQL login credentials. Please restart the program.");
                System.exit(1);
            }
            
            this.DBUSER = username;
            this.DBPASS = password;
    
            this.initializeConnection();
            System.out.println("test");
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

        public String getUserType(String username, String password)
        {
            String userTypeVal = "";
            try {
                String query = String.format("SELECT user.UserType FROM user WHERE UserName = ? && Password = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                line = stmt.executeQuery();
                line.next();
                userTypeVal = line.getString("UserType");
                System.out.println(userTypeVal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return userTypeVal;
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

        public ArrayList<Property> getSearchProperties(Property p) {
            ArrayList<Property> properties = new ArrayList<Property>();
            List<String> inputs = new ArrayList<String>();

            try {
                String unformattedQuery = "SELECT * FROM property WHERE ";

                if(!p.getType().equals("null")){
                    unformattedQuery += "Type = ?" + " AND ";
                    inputs.add(p.getType());
                }
                else{
                    unformattedQuery += "Type = Type" + " AND ";
                }

                if(p.getNumOfBedrooms() != -1){
                    unformattedQuery += "NoOfBedrooms = ?" + " AND ";
                    inputs.add(String.valueOf(p.getNumOfBedrooms()));
                }
                else{
                    unformattedQuery += "NoOfBedrooms = NoOfBedrooms" + " AND ";
                }

                if(p.getNumOfBathrooms() != -1){
                    unformattedQuery += "NoOfBathrooms = ?" + " AND ";
                    inputs.add(String.valueOf(p.getNumOfBathrooms()));
                }
                else{
                    unformattedQuery += "NoOfBathrooms = NoOfBathrooms" + " AND ";
                }

                if(p.getFurnished().equalsIgnoreCase("yes")){
                    unformattedQuery += "Furnished = ?" + " AND ";
                    inputs.add(p.getFurnished());
                }
                else{
                    unformattedQuery += "Furnished = Furnished" + " AND ";
                }

                unformattedQuery += "Status = ?";
                inputs.add("Available");
                System.out.println(unformattedQuery);

                String query = String.format(unformattedQuery);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                for(int i = 0; i < inputs.size(); i++){
                    if(Character.isDigit(inputs.get(i).charAt(0))){
                        System.out.println(Integer.parseInt(inputs.get(i)));
                        stmt.setInt(i+1, Integer.parseInt(inputs.get(i)));
                    }
                    else{
                        System.out.println(inputs.get(i));
                        stmt.setString(i+1, inputs.get(i));
                    }
                }
                System.out.println(stmt.toString());
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    String address = line.getString("Address");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");

                    Property prop = new Property(ID, address, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(50.00, 0, "null", "null"), status);
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
                    String status = line.getString("Status");

                    Property prop = new Property(ID, address, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(50.00, 0, "null", "null"), status);
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
            ArrayList<Property> props = new ArrayList<Property>(db.getSearchProperties(new Property(0,"null", "Detached", 4, -1, "null", new Fees(50.00, 0, "null", "null"), "Available")));
            GUIController ctrl = new GUIController(db);
            //ctrl.setDatabase(db);
            //SearchController srh = new SearchController();
            /*int id = 3;
            Landlord land = new Landlord("Robin", "Robin", "Sio", id, "ensf480", "Manager", new Email("null", "null", "null", "null"), db.getLandlordProperties(id));
            */
            /*System.out.println("Address: " + props.get(0).getAddress() + "\nType: " + props.get(0).getType());*/
            //db.addUser();
            
        }
}
