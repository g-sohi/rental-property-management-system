package Database;

import Controller.*;
import Models.*;

import java.io.IOException;
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

        public void addUser(String username, String FName, String LName, String Password, String UserType) {
            try {
                String query = "INSERT INTO user(UserName, FName,LName, Password, UserType) ";
                query += "VALUES ('%s', '%s', '%s','%s', '%s')";
                query = String.format(query, username, FName,LName, Password, UserType);
                System.out.println(query);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public User getUserInformation(String username){
            User use = new User();
            try {
                String query = String.format("SELECT * FROM user WHERE UserName = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                stmt.setString(1, username);
                line = stmt.executeQuery();
                line.next();
                String fName = line.getString("FName");
                String lName = line.getString("LName");
                String password = line.getString("Password");
                int id = line.getInt("ID");
                String userType = line.getString("UserType");
                use = new User(username, fName, lName, id, password, userType);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return use;
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

        public void addProperty(String address,String quadrant, String type, int numBedrooms, int numBathrooms, String furnished, double fees, String status, int landID, String startD, String endD){
            try {
                String query = "INSERT INTO property(Address, quadrant, Type, NoOfBedrooms, NoOfBathrooms, Furnished, Fees, FeesPaid, Status, Landlord_ID, StartDate, EndDate) ";
                query += "VALUES ('%s', '%s','%s', %d, %d, '%s', %f, 'No', '%s', %d, '%s', '%s')";
                query = String.format(query,address,quadrant, type, numBedrooms, numBathrooms, furnished, fees, status, landID, startD, endD);
                System.out.println(query);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void removeProperty(int id){
            try {
                String query = String.format("DELETE FROM property WHERE Property_ID = %d", id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateFeeStatus(int id)
        {
            try {
                String query = String.format("UPDATE property SET Status = 'Active', FeesPaid = 'yes' Where Property_ID = %d", id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateProperty(int id, String status){
            try {
                String query = String.format("UPDATE property SET Status = '%s' Where Property_ID = %d", status, id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Property> getSearchProperties(Property p) {
            ArrayList<Property> properties = new ArrayList<Property>();
            List<String> inputs = new ArrayList<String>();

            try {
                String unformattedQuery = "SELECT * FROM property WHERE ";
                if(p.getQuadarnt() != null){
                    unformattedQuery += "quadrant = ?" + " AND ";
                    inputs.add(p.getQuadarnt());
                }
                else{
                    unformattedQuery += "quadrant = quadrant" + " AND ";
                }

                if(p.getType() != null){
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
                if(p.getFurnished() != null)
                {
                if(p.getFurnished().equalsIgnoreCase("yes")){
                    unformattedQuery += "Furnished = ?" + " AND ";
                    inputs.add(p.getFurnished());
                }
            }
                else{
                    unformattedQuery += "Furnished = Furnished" + " AND ";
                }

                unformattedQuery += "Status = ?";
                inputs.add("Active");
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
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");

                    Property prop = new Property(ID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(50.00, 0, "null", "null"), status);
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
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");

                    Property prop = new Property(ID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(50.00, 0, "null", "null"), status);
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

        public static void main(String[] args) throws IOException {
            Database db = new Database();
            
            /*db.addProperty(2, "333 VansRoad, Calgary", "Townhouse", 2, 1, "No", 101.1, "Available", 4, "21 Aug, 2021", "23 Dec, 2021");
            db.removeProperty(2);*/


            //ArrayList<Property> props = new ArrayList<Property>(db.getSearchProperties(new Property(0,"null", "Detached", 4, -1, "null", new Fees(50.00, 0, "null", "null"), "Available")));
            GUIController ctrl = new GUIController(db);
            ctrl.setDatabase(db);
            //SearchController srh = new SearchController();
            /*int id = 3;
            Landlord land = new Landlord("Robin", "Robin", "Sio", id, "ensf480", "Manager", new Email("null", "null", "null", "null"), db.getLandlordProperties(id));
            */
            /*System.out.println("Address: " + props.get(0).getAddress() + "\nType: " + props.get(0).getType());*/
            //db.addUser();
            
        }
}
