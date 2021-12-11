package Controller;

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

import GUI.*;
import Database.*;
import Models.*;


import java.awt.event.*;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * GUIController class controls the functionality for the main GUI page 
 */
public class GUIController implements ActionListener {

    private MainPageGUI mainpage;
    private LoginController login;
    private SearchController search;
    private Database db;
    private RegisterView rView;
    private EmailView emailV;

    //Default Constructor
    public GUIController(){
        this.login = new LoginController();
        this.search = new SearchController();
    }

    /**
     * Constructor for the GUI Controller
     * Initializes mainage Object,login object, search object
     * rView object, and add the Action Listener for all
     * MainPageGUI buttons and also set the Database
     *  
     * @param db
     * @throws IOException
     */
    public GUIController(Database db) throws IOException
    {
        mainpage = new MainPageGUI();
        this.setDatabase(db);
        login = new LoginController(this.db);
        search = new SearchController(this.db);
        rView = new RegisterView();
        this.mainpage.addLoginListener(this);
        this.mainpage.addGuestListener(this);
        this.mainpage.addRegisterListener(this);
        this.mainpage.addSendEmailListener(this);
    }
    /**
     * set the the database to db;
     * @param db
     */
    public void setDatabase(Database db)
    {
        this.db = db;
    }

    /**
     * Handle events on the main GUI view
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mainpage.getLog()))  //Login button is pressed, mainpage GUI turns off and login window turns on
        {
            mainpage.setOff();
            login.enableView();
            login.getView().turnOn();
            login.getView().addGoBackListener(this);
        }
        else if(e.getSource().equals(mainpage.getGuest())) //Guest button is pressed, mainpage GUI turns off and search window turns on
        {
            mainpage.setOff();
            search.enableView();
            search.getView().turnOn();
            search.getView().addBackButtonListener(this);
        }
        else if(e.getSource().equals(mainpage.getRegister()))//Create New login button is pressed, mainpage GUI turns off and register window turns on
        {
            mainpage.setOff();
            rView.turnOn();
            this.rView.addRegisterListener(this);
            this.rView.addBackListener(this);

        }
        else if(e.getSource().equals(mainpage.getSendEmailButton())) //Send Email button is pressed, mainpage GUI turns off and Email window turns on
        {
            mainpage.setOff();
            emailV = new EmailView(true);
            emailV.turnOn();
            emailV.addBackListener(this);
            emailV.addSendEmailListener(this);
        }

        if(emailV != null) //Email window is opened
        {
            if(e.getSource().equals(emailV.getSendButton()))  //Send button is pressed
            {
                /**
                 * If Send button is pressed and all the fields are filled, then email would be sent
                 * and email window turns off and mainPage GUI window turns on
                 */
                if(!emailV.getSub().equals("") && !emailV.getBody().equals("") && !emailV.getFrom().equals("") && !emailV.getPID().equals(""))
                {
                emailV.showDialog();
                emailV.destroyFrame();
                mainpage.turnOn();
                }
                else{
                    emailV.showErrorDialog();
                }

            } 

            if(e.getSource().equals(emailV.getBackButton())) //back button is pressed then email window turns off and mainPage GUI window turns on
            {
                emailV.destroyFrame();
                mainpage.turnOn();
            }
        }


    if(e.getSource().equals(rView.getRegisterButton())) //register button is pressed on Register View GUI
    {
            /**
             * If register button is pressed and all the fields are filled and user name is unique, then registeration would be done
             * and register window turns off and mainPage GUI window turns on
             */
            
            if(!rView.getUsername().equals("") && !rView.getPassword().equals("") && !rView.getFName().equals("") && !rView.getLName().equals(""))
            {
                boolean userNameExists = db.usernameExists(rView.getUsername());
                if(userNameExists == false) //if user name is unique and doesnt exist in database
                {
                    rView.showDialog();
                    rView.destroyFrame();
                    mainpage.turnOn();
                    db.initializeConnection();
                    db.addUser(rView.getUsername(), rView.getFName(), rView.getLName(), rView.getPassword(), rView.getUserType());    
                }
                else // User name already exist
                {
                    JOptionPane.showMessageDialog(null, "Username is taken.");
                }
            }
            else
            {
                rView.showErrorDialog();
            }
    }
    
    
    if(login.getView() != null) // login window is opened
    {
            /* If back button is pressed 
            * login window turns off and mainPage GUI window turns on
            */
        if(e.getSource().equals(login.getView().getGoBackButton()))   
        {
            login.getView().destroyFrame();
            mainpage.turnOn();
        }
    }

    if(search.getView() != null) // search window is opened
    {
            /* If back button is pressed 
            * search window turns off and mainPage GUI window turns on
            */
        if(e.getSource().equals(search.getView().getBackButton()))   
        {
            search.getView().destroyFrameRenterGuest();
            mainpage.turnOn();
        }
    }
        if(this.rView != null) // register window is opened
        {
            /* If back button is pressed 
            * register window turns off and mainPage GUI window turns on
            */
            if(e.getSource().equals(rView.getBackButton()))   
            {
                rView.destroyFrame();
                mainpage.turnOn();
            }
        }
    }
}
