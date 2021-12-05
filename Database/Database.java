package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

        private final String DBUSER;
        private final String DBPASS;
        private final String DBURL = "jdbc:mysql://localhost/rpms";
    
        private Connection dbConnect; // connection between database and program

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
            db.initializeConnection();
            db.addUser();
            db.close();
        }
}
