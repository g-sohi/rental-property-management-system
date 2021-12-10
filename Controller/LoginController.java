package Controller;
import GUI.*;
import Database.*;
import Models.*;


import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.sound.midi.MidiSystem;
import javax.swing.JOptionPane;
 
//Login Controller
public class LoginController implements ActionListener{
    private LoginView view;
    private Database db;
    private User user;
    private RenterController rtCtrl;
    private ManagerController mgCtrl;
    private LandlordController ldCtrl;

    //Default constructor to create instances of member variables
    public LoginController(Database db){
        this.db = db;
        this.user = new User();
        mgCtrl = new ManagerController(db);
        rtCtrl = new RenterController(db);
        ldCtrl = new LandlordController(db);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        //addListener();
        boolean loggedIn = this.verifyLogin();
        //this.verifyLogin();
        db.initializeConnection();

        if(e.getSource().equals(view.getButton()))
        {
            if(loggedIn == true)
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH-mm-ss");
                LocalDateTime current = LocalDateTime.now();
                System.out.println(dtf.format(current));
                this.user = new User(db.getUserInformation(this.user.getUsername()));
                db.updateLastLogin(dtf.format(current).toString(), this.user.getId());
                System.out.println("User Name: " + this.user.getFName());
                view.destroyFrame();
                JOptionPane.showMessageDialog(null, "You Have Successfully logged In.");
                System.out.println("userType in user is: " + user.getUserType());
            if(user.getUserType().equals("Renter"))
            {
                Renter tempRent = new Renter(this.user);
                rtCtrl.setRenter(tempRent);
                System.out.println("Renter Name: " + rtCtrl.getRenter().getFName() + "\nID: " + rtCtrl.getRenter().getId() + "\n");
                rtCtrl.enableView(this);
                rtCtrl.getRenterView().turnOn();
            }
            else if(user.getUserType().equals("Landlord"))
            {
                Landlord tempLand = new Landlord(this.user);
                ldCtrl.setLandlord(tempLand);
                ldCtrl.setRegisterControllerId(ldCtrl.getLandlord().getId());
                ldCtrl.setSearchControllerID(ldCtrl.getLandlord().getId());
                System.out.println("Landlord Name: " + ldCtrl.getLandlord().getFName() + "\nID: " + ldCtrl.getLandlord().getId() + "\n");
                ldCtrl.enableView(this, ldCtrl.getLandlord().getId());
                ldCtrl.getLandlordView().turnOn();
            }
            else if(user.getUserType().equals("Manager"))
            {
                Manager tempMngr = new Manager(this.user);
                mgCtrl.setManager(tempMngr);
                System.out.println("Manager Name: " + mgCtrl.getManager().getFName() + "\nID: " + mgCtrl.getManager().getId() + "\n");
                mgCtrl.enableView(this);
                mgCtrl.getView().turnOn();
            }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username and/or Password are Incorrect.");
                // view.destroyFrame();
                // view = new LoginView();
            }
        }
        if(rtCtrl.getRenterView() != null)
        {
            if(e.getSource().equals(rtCtrl.getRenterView().getLogout()))
            {
                System.out.println("hello");
                rtCtrl.getSearch().resetSearchType();
                rtCtrl.getRenterView().destroyFrame();
                view.turnOn();
            }
        }
        
        if(ldCtrl.getLandlordView() != null)
        {
            if(e.getSource().equals(ldCtrl.getLandlordView().getLogout()))
            {
                System.out.println("finish");
                ldCtrl.getSearch().resetSearchType();
                ldCtrl.getLandlordView().destroyFrame();
                view.turnOn();
            }
        }

        if(mgCtrl.getView() != null)
        {
            if(e.getSource().equals(mgCtrl.getView().getLogout()))
            {
                System.out.println("done");
                mgCtrl.getSearch().resetSearchType();
                mgCtrl.getView().destroyFrame();
                view.turnOn();
            }
        }
    }
    
    
    //Verify user login credentials and return a boolean indicating its status
    public boolean verifyLogin(){
        user.setUsername(view.getUsername());
        user.setPassword(view.getPassword());

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        db.initializeConnection();
        boolean loggenIn = db.verifyUser(user.getUsername(), user.getPassword());
        //db.verifyUser(user.getUsername(), user.getPassword());
        if(loggenIn == true)
        {
            user.setUserType(db.getUserType(user.getUsername(), user.getPassword()));
            return(true);
        }
        db.close();
        return(false);
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
    public void enableView()
    {
        view = new LoginView();
        this.view.addLoginListener(this);
        
    }

    //getter for register view
}
