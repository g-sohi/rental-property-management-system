package Controller;
import GUI.*;
import Database.*;
import Models.*;


import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.sound.midi.MidiSystem;
import javax.swing.JOptionPane;
 
/**
 * LoginController class controls the functionality for the login page
 */
public class LoginController implements ActionListener{
    private LoginView view;
    private Database db;
    private User user;
    private RenterController rtCtrl;
    private ManagerController mgCtrl;
    private LandlordController ldCtrl;

    //Default constructor to create instances of member variables
    public LoginController(){
        this.user = new User();
        this.rtCtrl = new RenterController();
        this.mgCtrl = new ManagerController();
        this.ldCtrl = new LandlordController();
    }

    //LoginController constructor with database connection
    public LoginController(Database db){
        this.db = db;
        this.user = new User();
        this.mgCtrl = new ManagerController(db);
        this.rtCtrl = new RenterController(db);
        this.ldCtrl = new LandlordController(db);
    }

    //Handle login page events
    @Override
    public void actionPerformed(ActionEvent e)
    {
        db.initializeConnection();

        if(e.getSource().equals(view.getButton())) //user attemps to login
        {
            boolean loggedIn = this.verifyLogin(); //verify user login
            if(loggedIn == true)
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
                LocalDateTime current = LocalDateTime.now();
                this.user = new User(db.getUserInformation(this.user.getUsername()));
                db.updateLastLogin(dtf.format(current).toString(), this.user.getId());
                view.destroyFrame();
                JOptionPane.showMessageDialog(null, "You Have Successfully logged In.");

                if(user.getUserType().equals("Renter")) //user logs in as renter
                {
                    Renter tempRent = new Renter(this.user);
                    rtCtrl.setRenter(tempRent);
                    rtCtrl.enableView(this);
                    rtCtrl.getRenterView().turnOn();
                }
                else if(user.getUserType().equals("Landlord")) //user logs in as landlord
                {
                    Landlord tempLand = new Landlord(this.user);
                    ldCtrl.setLandlord(tempLand);
                    ldCtrl.setRegisterControllerId(ldCtrl.getLandlord().getId());
                    ldCtrl.setSearchControllerID(ldCtrl.getLandlord().getId());
                    ldCtrl.enableView(this, ldCtrl.getLandlord().getId(), this.user.getUserType());
                    ldCtrl.getLandlordView().turnOn();
                }
                else if(user.getUserType().equals("Manager")) //user logs in as manager
                {
                    Manager tempMngr = new Manager(this.user);
                    mgCtrl.setManager(tempMngr);
                    mgCtrl.enableView(this, this.user.getId(),this.user.getUserType());
                    mgCtrl.getView().turnOn();
                }
            }
            else //user login not authenticated 
            {
                JOptionPane.showMessageDialog(null, "Username and/or Password are Incorrect.");
            }
        }
        if(rtCtrl.getRenterView() != null) //user logs out as renter
        {
            if(e.getSource().equals(rtCtrl.getRenterView().getLogout()))
            {
                rtCtrl.getSearch().resetSearchType();
                rtCtrl.getRenterView().destroyFrame();
                view.turnOn();
            }
        }
        
        if(ldCtrl.getLandlordView() != null) //user logs out as landlord
        {
            if(e.getSource().equals(ldCtrl.getLandlordView().getLogout()))
            {
                ldCtrl.getSearch().resetSearchType();
                ldCtrl.getLandlordView().destroyFrame();
                view.turnOn();
            }
        }

        if(mgCtrl.getView() != null) //user logs out as manager
        {
            if(e.getSource().equals(mgCtrl.getView().getLogout()))
            {
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

        db.initializeConnection();
        boolean loggenIn = db.verifyUser(user.getUsername(), user.getPassword());

        if(loggenIn == true)
        {
            user.setUserType(db.getUserType(user.getUsername(), user.getPassword()));
            return(true);
        }
        db.close();
        return(false);
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

    //enable login view
    public void enableView()
    {
        view = new LoginView();
        this.view.addLoginListener(this);
    }
}
