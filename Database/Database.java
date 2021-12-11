package Database;

/**
 * @author Curtis Silva <a href="mailto:curtis.silva@ucalgary.ca">
 *         curtis.silva@ucalgary.ca</a>
 * 
 * @author Gurpartap Sohi <a href="mailto:gurpartap.sohi@ucalgary.ca">
 *         gurpartap.sohi@ucalgary.ca</a>
 * 
 * @author Ivan Suyat<a href="mailto:ivan.suyat@ucalgary.ca">
 *         ivan.suyat@ucalgary.ca/a>
 * 
 * @author Manpreet Singh<a href="mailto:manpreet.singh2@ucalgary.ca">
 *         manpreet.singh2@ucalgary.ca</a>
 * 
 */

import Controller.*;
import Models.*;
import GUI.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Database class communicates with the MySQL Server to read
 * and write data to the database
 */
public class Database {

        private final String DBUSER;
        private final String DBPASS;
        private final String DBURL = "jdbc:mysql://localhost/rpms";
    
        private Connection dbConnect; 

        private ResultSet line;

        /**
         * Database Constructor reads user password and establishes connection to database
         */
        public Database() {
            String username = "root";
            String password = readPassword();
    
            try {

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to obtain MySQL login credentials. Please restart the program.");
                System.exit(1);
            }
            
            this.DBUSER = username;
            this.DBPASS = password;
    
            this.initializeConnection();
        }
    
        /**
         * initializeConnection() establishes a connection between the program and the database
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

        /**
         * Adds a user into the user table in the database
         * @param username
         * @param FName
         * @param LName
         * @param Password
         * @param UserType
         */
        public void addUser(String username, String FName, String LName, String Password, String UserType) {
            try {
                String query = "INSERT INTO user(UserName, FName,LName, Password, UserType) ";
                query += "VALUES ('%s', '%s', '%s','%s', '%s')";
                query = String.format(query, username, FName,LName, Password, UserType);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       /**
        * Checks if a username is already taken in the user table in the database
        * @param username
        * @return true if username is exists, otherwise false
        */ 
        public boolean usernameExists(String username){
            try {
                String query = String.format("SELECT user.UserName FROM user WHERE UserName = '%s'", username);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                if(!line.isBeforeFirst()){
                    stmt.close();
                    return false;
                }
                else{
                    stmt.close();
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        /**
         * Retrieves the user's last login information
         * @param id
         * @return String containing the user's last login info
         */
        public String getLastLogin(int id){
            String lastLogin = "";
            try {
                String query = String.format("SELECT * FROM user WHERE ID = %d", id);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                line.next();
                lastLogin = line.getString("LastLogin");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lastLogin;
        }

        /**
         * Updates the user's last login information in the user table
         * @param lastLogin
         * @param id
         */
        public void updateLastLogin(String lastLogin, int id){
            try {
                String query = String.format("UPDATE user SET LastLogin = '%s' WHERE ID = %d", lastLogin, id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Retrieves the user's information from the user table in the database
         * @param username
         * @return User object containing user information from the databse
         */
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

        /**
         * Retrieves the user's type after they log in
         * @param username
         * @param password
         * @return String containing the user's type
         */
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return userTypeVal;
        }

        /**
         * Verifies that the user's login information exists in the database
         * @param username
         * @param password
         * @return true if the user's login information exists, false otherwise
         */
        public boolean verifyUser(String username, String password){
            boolean authenticate = false;
            try {
                String query = String.format("SELECT user.ID FROM user WHERE UserName = ? && Password = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                line = stmt.executeQuery();
                if(!line.isBeforeFirst()){
                    authenticate = false;
                    return authenticate;
                }
                else{
                    line.next();
                    authenticate = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return authenticate;
        }

        /**
         * Adds a property into the property table in the database
         * @param address
         * @param quadrant
         * @param type
         * @param numBedrooms
         * @param numBathrooms
         * @param furnished
         * @param fees
         * @param status
         * @param landID
         * @param startD
         * @param endD
         */
        public void addProperty(String address,String quadrant, String type, int numBedrooms, int numBathrooms, String furnished, double fees, String status, int landID, String startD, String endD){
            try {
                String query = "INSERT INTO property(Address, quadrant, Type, NoOfBedrooms, NoOfBathrooms, Furnished, Fees, FeesPaid, Status, Landlord_ID, StartDate, EndDate) ";
                query += "VALUES ('%s', '%s','%s', %d, %d, '%s', %f, 'No', '%s', %d, '%s', '%s')";
                query = String.format(query,address,quadrant, type, numBedrooms, numBathrooms, furnished, fees, status, landID, startD, endD);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Removes a property from the property table in the database
         * @param id
         */
        public void removeProperty(int id){
            try {
                String query = String.format("DELETE FROM property WHERE Property_ID = %d", id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Retrieves property information for a specific property from the database
         * @param propertyID
         * @return Property object containing the requested property's information
         */
        public Property getProperty(int propertyID){
            Property prop = new Property();
            try {
                String query = String.format("SELECT * FROM property WHERE Property_ID = %d AND Status = 'Active'", propertyID);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                line.next();
                int ID = line.getInt("Property_ID");
                int landlordID = line.getInt("Landlord_ID");
                String address = line.getString("Address");
                String quadrant = line.getString("quadrant");
                String type = line.getString("Type");
                int numOfBedrooms = line.getInt("NoOfBedrooms");
                int numOfBathrooms = line.getInt("NoOfBathrooms");
                String furnished = line.getString("Furnished");
                String status = line.getString("Status");
                prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(0.00, 0, "No", "NULL", "NULL"), status);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return prop;
        }

        /**
         * Retrieves the requested property's maximum listing period from the database
         * @param id
         * @return listing period set by manager
         */
        public int getPeriod(int id){
            int period = 0;
            try{
                String query = String.format("SELECT * FROM property WHERE Property_ID = %d", id);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                line.next();
                period = line.getInt("FeePeriod");
            } catch (SQLException e) {
                //e.printStackTrace();
            }
            return period;
        }

        /**
         * Retrieve the fees amount required for the requested property to be listed 
         * @param id
         * @return fees amount
         */
        public double getFees(int id){
            double amount = 0.0;
            try{
                String query = String.format("SELECT * FROM property WHERE Property_ID = %d", id);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                line.next();
                amount = line.getInt("Fees");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return amount;
        }

        /**
         * Update property status in the property table in the database
         * @param id
         */  
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

        /**
         * Update requested property's period and fees in the database
         * @param id
         * @param amount
         * @param period
         */
        public void updatePeriodStatus(int id, double amount, int period)
        {
            try {
                String query = String.format("UPDATE property SET Fees = %f, FeePeriod = %d Where Property_ID = %d", amount, period, id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Update the listed property's info in the database after fees has been paid
         * @param id
         * @param startDate
         * @param endDate
         */
        public void updatePaidProperty(int id, String startDate, String endDate){
            try {
                String query = String.format("UPDATE property SET Status = 'Active', StartDate = '%s', EndDate = '%s' Where Property_ID = %d", startDate, endDate, id);
                Statement stmt = dbConnect.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Allow the landlord to update the status of an owned property in the database
         * @param id
         * @param status
         * @param rentDate
         * @param landID
         */
        public void updatePropertyLandLord(int id, String status, String rentDate, int landID){
            try {
                if(!status.equalsIgnoreCase("rented")){
                    String query = String.format("UPDATE property SET Status = '%s', RentDate = 'Null' Where Property_ID = %d AND Landlord_ID = %d", status, id, landID);
                    Statement stmt = dbConnect.createStatement();
                    stmt.executeUpdate(query);
                }
                else{
                    String query = String.format("UPDATE property SET Status = '%s', RentDate = '%s' Where Property_ID = %d AND Landlord_ID = %d", status, rentDate, id, landID);
                    Statement stmt = dbConnect.createStatement();
                    stmt.executeUpdate(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * 
         * @param id
         * @param status
         * @param rentDate
         */
        public void updateProperty(int id, String status, String rentDate){
            try {
                if(!status.equalsIgnoreCase("rented")){
                    String query = String.format("UPDATE property SET Status = '%s', RentDate = 'Null' Where Property_ID = %d", status, id);
                    Statement stmt = dbConnect.createStatement();
                    stmt.executeUpdate(query);
                }
                else{
                    String query = String.format("UPDATE property SET Status = '%s', RentDate = '%s' Where Property_ID = %d", status, rentDate, id);
                    Statement stmt = dbConnect.createStatement();
                    stmt.executeUpdate(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Retrieve list of searched properties from the database
         * @param p
         * @return ArrayList of Properties
         */
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

                String query = String.format(unformattedQuery);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                for(int i = 0; i < inputs.size(); i++){
                    if(Character.isDigit(inputs.get(i).charAt(0))){
                        stmt.setInt(i+1, Integer.parseInt(inputs.get(i)));
                    }
                    else{
                        stmt.setString(i+1, inputs.get(i));
                    }
                }
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    int landlordID = line.getInt("Landlord_ID");
                    String address = line.getString("Address");
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");

                    Property prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(50.00, 0, "No", "N/A", "N/A"), status);
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

        /**
         * Retrieve landlord name from the database based on the ID
         * @param landlordID
         * @return landlord name
         */
        public String getLandlordName(int landlordID){
            String name = "";
            try {
                String query = String.format("SELECT user.FName FROM user WHERE ID = %d", landlordID);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                line.next();
                name = line.getString("FName");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return name;
        }

        /**
         * Retrieve list of all landlords within the database
         * @return ArrayList containing Landlords
         */
        public ArrayList<Landlord> getAllLandlords(){
            ArrayList<Landlord> landlords = new ArrayList<>();
            try {
                String query = String.format("SELECT * FROM user WHERE UserType = '%s'", "Landlord");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    String username = line.getString("UserName");
                    String fName = line.getString("FName");
                    String lName = line.getString("LName");
                    String password = line.getString("Password");
                    int id = line.getInt("ID");
                    String userType = line.getString("UserType");
                    User use = new User(username, fName, lName, id, password, userType);
                    Landlord temp = new Landlord(use);
                    landlords.add(temp);
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error.Exiting program.");
                System.exit(1);
            }
            return landlords;
        }

        /**
         * Retrieve the list of all properties owned by a landlord
         * @param landLordID
         * @return ArrayList of properties that are under the requested landlord
         */
        public ArrayList<Property> getLandlordProperties(int landLordID) {
            ArrayList<Property> properties = new ArrayList<Property>();
            try {
                String query = String.format("SELECT * FROM property WHERE Landlord_ID = ?");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                stmt.setInt(1, landLordID);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    int landlordID = line.getInt("Landlord_ID");
                    String address = line.getString("Address");
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");
                    String startDate = line.getString("StartDate");
                    String endDate = line.getString("EndDate");
                    String rentDate = line.getString("RentDate");
                    Fees fee = new Fees(line.getDouble("Fees"), line.getInt("FeePeriod"), line.getString("FeesPaid"), startDate, endDate);
                    Property prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, fee, status, startDate, endDate, rentDate);
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

        /**
         * Retrieve a list of all the renters within the database
         * @return ArrayList containing all renters
         */
        public ArrayList<Renter> getAllRenters(){
            ArrayList<Renter> renters = new ArrayList<>();
            try {
                String query = String.format("SELECT * FROM user WHERE UserType = '%s'", "Renter");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    String username = line.getString("UserName");
                    String fName = line.getString("FName");
                    String lName = line.getString("LName");
                    String password = line.getString("Password");
                    int id = line.getInt("ID");
                    String userType = line.getString("UserType");
                    User use = new User(username, fName, lName, id, password, userType);
                    Renter temp = new Renter(use);
                    renters.add(temp);
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error.Exiting program.");
                System.exit(1);
            }
            return renters;
        }

        /**
         * Retrieve a list of all of the properties within the database
         * @return ArrayList of all properties 
         */
        public ArrayList<Property> getManagerProperties() {
            ArrayList<Property> properties = new ArrayList<Property>();
            try {
                String query = String.format("SELECT * FROM property");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    int landlordID = line.getInt("Landlord_ID");
                    String address = line.getString("Address");
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");
                    String startDate = line.getString("StartDate");
                    String endDate = line.getString("EndDate");
                    String rentDate = line.getString("RentDate");
                    Fees fee = new Fees(line.getDouble("Fees"), line.getInt("FeePeriod"), line.getString("FeesPaid"), startDate, endDate);
                    Property prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, fee, status, startDate, endDate, rentDate);
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

        /**
         * Retrieve a list of all of the properties that were added after the user last logged in
         * @param lastLogin
         * @return ArrayList containing new properties
         */
        public ArrayList<Property> getNewProperties(String lastLogin){
            ArrayList<Property> properties = new ArrayList<Property>();
            try {
                String query = String.format("SELECT * FROM property WHERE StartDate > ? AND Status = 'Active'");
                PreparedStatement stmt = dbConnect.prepareStatement(query);
    
                stmt.setString(1, lastLogin);
    
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    int landlordID = line.getInt("Landlord_ID");
                    String address = line.getString("Address");
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");
                    Property prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, new Fees(0.00, 0, "No", "N/A", "N/A"), status);
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

        /**
         * Count the number of properties based on different input queries
         * @param type
         * @param periodStart
         * @param periodEnd
         * @return total number of properties that satisfy a certain input query
         */
        public int countListings(String type, String periodStart, String periodEnd){
            int count = 0;
            try {
                String query = "";
                if(type.equalsIgnoreCase("listed")){
                    query = String.format("SELECT COUNT(StartDate) AS result_count FROM property WHERE StartDate BETWEEN '%s' AND '%s'", periodStart, periodEnd);
                }
                else if(type.equalsIgnoreCase("rented")){
                    query = String.format("SELECT COUNT(RentDate) AS result_count FROM property WHERE RentDate BETWEEN '%s' AND '%s'", periodStart, periodEnd);
                }
                else if(type.equalsIgnoreCase("active")){
                    query = String.format("SELECT COUNT(StartDate) AS result_count FROM property WHERE StartDate BETWEEN '%s' AND '%s' AND Status = 'Active'", periodStart, periodEnd);

                }
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                if(line.next()){
                    count = line.getInt("result_count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
        }

        /**
         * Retrieve a list of all of the properties that were rented after a certain date
         * @param periodStart
         * @param periodEnd
         * @return ArrayList containing all rented properties after a certain date
         */
        public ArrayList<Property> getRentedProperties(String periodStart, String periodEnd){
            ArrayList<Property> properties = new ArrayList<Property>();
            try {
                String query = String.format("SELECT * FROM property WHERE RentDate BETWEEN '%s' AND '%s'", periodStart, periodEnd);
                PreparedStatement stmt = dbConnect.prepareStatement(query);
                line = stmt.executeQuery();
                while (line.next()) {
                    int ID = line.getInt("Property_ID");
                    int landlordID = line.getInt("Landlord_ID");
                    String address = line.getString("Address");
                    String quadrant = line.getString("quadrant");
                    String type = line.getString("Type");
                    int numOfBedrooms = line.getInt("NoOfBedrooms");
                    int numOfBathrooms = line.getInt("NoOfBathrooms");
                    String furnished = line.getString("Furnished");
                    String status = line.getString("Status");
                    String startDate = line.getString("StartDate");
                    String endDate = line.getString("EndDate");
                    String rentDate = line.getString("RentDate");
                    Fees fee = new Fees(line.getDouble("Fees"), line.getInt("FeePeriod"), line.getString("FeesPaid"), startDate, endDate);
                    Property prop = new Property(ID, landlordID, address,quadrant, type, numOfBedrooms, numOfBathrooms, furnished, fee, status, startDate, endDate, rentDate);
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

        /**
         * Close connection to the database
         */
        public void close() {
            try {
                this.dbConnect.close();
            } catch (Exception e) {
                System.out.println("Error closing the Connection and ResultSet objects.");
                e.printStackTrace();
            }
        }

        /**
         * Read the user's password info to log into the MySQL Server
         * @return user's MySQL server password
         */
        public String readPassword(){
            System.out.println("Please enter the password to your MySQL Server.");
            Scanner read = new Scanner(System.in);
            String passwordInput = read.nextLine();
            read.close();
            System.out.println("Authenticating login credentials...");
            return passwordInput;
        }
}
