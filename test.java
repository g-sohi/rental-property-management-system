public class test {
    
}
package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame {
    private static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private JButton submit;
    private JLabel message;
    private JPanel panel;
    private JLabel user_label, password_label;

    public LoginView()
    {
        user_label = new JLabel();
        user_label.setText("User Name :");
        inputUsername = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        inputPassword = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(inputUsername);
        panel.add(password_label);
        panel.add(inputPassword);
        message = new JLabel();
      panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        //submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("User Login Page");
        setSize(450,350);
        setVisible(true);
    }

     
    public void addLoginListener(ActionListener listenForLogin){
        submit.addActionListener(listenForLogin);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/
        
    }

    public void addLogoutListener(ActionListener listenForLogout){
        
    }

    //public void actionPerformed(ActionEvent e) {
        // username = inputUsername.getText();
            //password = String.valueOf(inputPassword.getPassword());
        /*
        if (username.trim().equals("admin") && password.trim().equals("admin")) {
            ManagerView vw = new ManagerView();
        vw.setVisible(true);

            message.setText(" Hello " + username + "");
         } else {
            message.setText(" Invalid user.. ");
    }
        this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);

    }*/

    public String getUsername()
    {
        return inputUsername.getText();
    }

    public String getPassword()
    {
        return String.valueOf(inputPassword.getPassword());
    }

    public JButton getSubmit()
    {
        return this.submit;
    }
        

}

package Controller;
import GUI.*;
import Database.*;
import Models.*;

import java.awt.event.*;
 
//Login Controller
public class LoginController implements ActionListener{
    private LoginView view;
    private Database db;
    private User user;
    private RegisterView rView;


    //Default constructor to create instances of member variables
    public LoginController(Database db){
        this.view = new LoginView();
        this.db = db;
        this.user = new User();
        //this.rView = new RegisterView();

        this.view.addLoginListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(view.getSubmit()))
        {
            this.verifyLogin();
            view.dispose();
            System.out.println("userType in user is: " + user.getUserType());
            if(user.getUserType().equals("Renter"))
            {
                RenterView vw = new RenterView();
                vw.setVisible(true);

            }
            else if(user.getUserType().equals("Landlord"))
            {
                LandlordView vw = new LandlordView();
                vw.setVisible(true);
            }
            else if(user.getUserType().equals("Manager"))
            {
                ManagerView vw = new ManagerView();
                vw.setVisible(true);
            }
        }
    }
    
    //Verify user login credentials and return a boolean indicating its status
    public void verifyLogin(){
        user.setUsername(view.getUsername());
        user.setPassword(view.getPassword());

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        db.initializeConnection();
        db.verifyUser(user.getUsername(), user.getPassword());
        user.setUserType(db.getUserType(user.getUsername(), user.getPassword()));
        db.close();
    }

    //Register new user
    public void registerUser(){

    }

    //getter for login view
    public LoginView getView(){
        return this.view;
    }

    //setter for login view
    public void setView(LoginView lv){
        this.view = lv;
    }

    //getter for database 
    public Database getDb(){
        return this.db;
    }

    //setter for database
    public void setDb(Database d){
        this.db = d;
    }

    //getter for user
    public User getUser(){
        return this.user;
    }

    //setter for user
    public void setUser(User u){
        this.user = u;
    }

    //getter for register view
    public RegisterView getRView(){
        return this.rView;
    }

    //setter for register view
    public void setRView(RegisterView rv){
        this.rView = rv;
    }
}

package Controller;

import Models.*;
import GUI.*;
import Database.*;

import java.util.*;
import java.awt.event.*;

public class RenterController implements ActionListener{
    private SelectPropertyView selectProp;
    private ArrayList<Property> listings;
    private Renter renter;
    private Database db;
    private Email Email;
    private EmailView emailv;
    private RenterView rentView;

    public RenterController()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(rentView.getSearch())){

        }
        else if(e.getSource().equals(rentView.getSelect())){

        }
        else if(e.getSource().equals(rentView.getSendEmail())){

        }
    }

    public void SelectProperty(ArrayList<Property> listings)
    {
        this.listings = listings;
    }

    public void addFavourite(Property p)
    {   
        //check if the ArrayList listing is empty
        if(listings.isEmpty())
        {
            //Create an ArrayList Property type
            this.listings = new ArrayList<Property>();
            //add Property p to the listings
            this.listings.add(p);
        }
        else
        {   
            //if the Arraylist listings is not empty, add Porperty p to list.
            this.listings.add(p);
        }
    }

    public void sendEmail()
    {

    }

    public void createEmail()
    {

    }

    public SelectPropertyView getSelectProp() {
        return selectProp;
    }

    public void setSelectProp(SelectPropertyView selectProp) {
        this.selectProp = selectProp;
    }

    public ArrayList<Property> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Property> listings) {
        this.listings = listings;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public Email getEmail() {
        return Email;
    }

    public void setEmail(Email email) {
        this.Email = email;
    }

    public EmailView getEmailv() {
        return emailv;
    }

    public void setEmailv(EmailView emailv) {
        this.emailv = emailv;
    }

    public RenterView getRenterView() {
        return RenterView;
    }

    public void setRenterView(RenterView renterView) {
        this.RenterView = renterView;
    }
    
}

package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame {
    private static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private JButton submit;
    private JLabel message;
    private JPanel panel;
    private JLabel user_label, password_label;

    public LoginView()
    {
        user_label = new JLabel();
        user_label.setText("User Name :");
        inputUsername = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        inputPassword = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(inputUsername);
        panel.add(password_label);
        panel.add(inputPassword);
        message = new JLabel();
      panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        //submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("User Login Page");
        setSize(450,350);
        setVisible(true);
    }

     
    public void addLoginListener(ActionListener listenForLogin){
        submit.addActionListener(listenForLogin);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/
        
    }

    public void addLogoutListener(ActionListener listenForLogout){
        
    }

    //public void actionPerformed(ActionEvent e) {
        // username = inputUsername.getText();
            //password = String.valueOf(inputPassword.getPassword());
        /*
        if (username.trim().equals("admin") && password.trim().equals("admin")) {
            ManagerView vw = new ManagerView();
        vw.setVisible(true);

            message.setText(" Hello " + username + "");
         } else {
            message.setText(" Invalid user.. ");
    }
        this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);

    }*/

    public String getUsername()
    {
        return inputUsername.getText();
    }

    public String getPassword()
    {
        return String.valueOf(inputPassword.getPassword());
    }

    public JButton getSubmit()
    {
        return this.submit;
    }
        

}

package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame {
    private static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private JButton submit;
    private JLabel message;
    private JPanel panel;
    private JLabel user_label, password_label;
    private JFrame f;

    public LoginView(JFrame f)
    {
        /*f = new JFrame("Login Page");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        //f.setLayout(null);
        user_label = new JLabel();
        user_label.setText("User Name :");
        inputUsername = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        inputPassword = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        user_label.setBounds(100,100,100,100);
        panel.add(inputUsername);
        panel.add(password_label);
        panel.add(inputPassword);
        //message = new JLabel();
        //panel.add(message);
        panel.add(submit);
        user_label.setBounds(100,100,150,30);
        password_label.setBounds(100,150,150,30);
        inputUsername.setBounds(200,100,130,30);
        inputPassword.setBounds(200,150,100,30);
        submit.setBounds(300, 400, 150, 30);
        f.getContentPane().add(panel, BorderLayout.CENTER);

        // Adding the listeners to components..
        //submit.addActionListener(this);
        //add(panel, BorderLayout.CENTER);
        f.setVisible(true);
    }

     
    public void addLoginListener(ActionListener listenForLogin){
        submit.addActionListener(listenForLogin);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/
        
    }

    //public void actionPerformed(ActionEvent e) {
        // username = inputUsername.getText();
            //password = String.valueOf(inputPassword.getPassword());
        /*
        if (username.trim().equals("admin") && password.trim().equals("admin")) {
            ManagerView vw = new ManagerView();
        vw.setVisible(true);

            message.setText(" Hello " + username + "");
         } else {
            message.setText(" Invalid user.. ");
    }
        this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);

    }*/

    public String getUsername()
    {
        return inputUsername.getText();
    }

    public String getPassword()
    {
        return String.valueOf(inputPassword.getPassword());
    }

    public JButton getButton()
    {
        return this.submit;
    }
}

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
            boolean type = false;
            boolean bathrooms = false;
            boolean bedrooms = false;
            int count = 0;

            try {
                String unformattedQuery = "SELECT * FROM property WHERE ";

                if(!p.getType().equals("null")){
                    unformattedQuery += "Type = " + p.getType() + "&";
                }

                if(p.getNumOfBathrooms() != -1){
                    unformattedQuery += "NoOfBathrooms = " + p.getNumOfBathrooms() + "&";
                }

                if(p.getNumOfBathrooms() != -1){
                    unformattedQuery += "NoOfBathrooms = " + p.getNumOfBathrooms() + "&";
                }

                int pos = unformattedQuery.length() - 1;

                if(unformattedQuery.charAt(pos) == '&'){

                }

                String query = String.format(unformattedQuery);
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
            LoginController ctrl = new LoginController(db);
            //SearchController srh = new SearchController();
            int id = 3;
            Landlord land = new Landlord("Robin", "Robin", "Sio", id, "ensf480", "Manager", new Email("null", "null", "null", "null"), db.getLandlordProperties(id));
            System.out.println("Address: " + land.getProperties().get(0).getAddress() + "\nType: " + land.getProperties().get(0).getType());
            //db.addUser();
        }
}

package Controller;
import GUI.*;
import Database.*;
import Models.*;

import java.awt.event.*;
 
//Login Controller
public class LoginController implements ActionListener{
    private LoginView view;
    private Database db;
    private User user;
    private RegisterView rView;
    private ManagerController mgControl;

    //Default constructor to create instances of member variables
    public LoginController(Database db){
        this.view = new LoginView();
        this.db = db;
        this.user = new User();
        this.rView = new RegisterView();

        this.view.addLoginListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.verifyLogin();

        if(e.getSource().equals(view.getButton()))
        {
            view.destroyFrame();
            System.out.println("userType in user is: " + user.getUserType());
            if(user.getUserType().equals("Renter"))
            {
                RenterView vw = new RenterView();
                vw.setVisible(true);
            }
            else if(user.getUserType().equals("Landlord"))
            {
                LandlordView vw = new LandlordView();
                vw.setVisible(true);
            }
            else if(user.getUserType().equals("Manager"))
            {
                this.mgControl = new ManagerController();
                this.mgControl.addLogoutListener(this);
                mgControl.turnOn();
            }
        }
        if(e.getSource().equals(mgVw.getLogout()))
        {
            System.out.println("hello");
            mgVw.destroyFrame();
            view.turnOn();
        }
    }
    
    //Verify user login credentials and return a boolean indicating its status
    public void verifyLogin(){
        user.setUsername(view.getUsername());
        user.setPassword(view.getPassword());

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        db.initializeConnection();
        db.verifyUser(user.getUsername(), user.getPassword());
        user.setUserType(db.getUserType(user.getUsername(), user.getPassword()));
        db.close();
    }

    //Register new user
    public void registerUser(){

    }

    //getter for login view
    public LoginView getView(){
        return this.view;
    }

    //setter for login view
    public void setView(LoginView lv){
        this.view = lv;
    }

    //getter for database 
    public Database getDb(){
        return this.db;
    }

    //setter for database
    public void setDb(Database d){
        this.db = d;
    }

    //getter for user
    public User getUser(){
        return this.user;
    }

    //setter for user
    public void setUser(User u){
        this.user = u;
    }

    //getter for register view
    public RegisterView getRView(){
        return this.rView;
    }

    //setter for register view
    public void setRView(RegisterView rv){
        this.rView = rv;

    }
}

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
            ArrayList<Property> props = new ArrayList<Property>(db.getSearchProperties(new Property(0,"null", "Detached", -1, -1, "null", new Fees(50.00, 0, "null", "null"), "Available")));
            /*GUIController ctrl = new GUIController();
            ctrl.setDatabase(db);
            //SearchController srh = new SearchController();
            int id = 3;
            Landlord land = new Landlord("Robin", "Robin", "Sio", id, "ensf480", "Manager", new Email("null", "null", "null", "null"), db.getLandlordProperties(id));
            */
            System.out.println("Address: " + props.get(0).getAddress() + "\nType: " + props.get(0).getType());
            //db.addUser();
            
        }
}
