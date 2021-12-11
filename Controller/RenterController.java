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

import Models.*;
import GUI.*;
import Database.*;

import java.util.*;

import javax.swing.JOptionPane;

import java.awt.event.*;

/**
 * RenterController class controls the functionality for the renter main page 
 */
public class RenterController implements ActionListener, ItemListener{
    private SelectPropertyView selectProp;
    private ArrayList<Property> listings;
    private Renter renter;
    private Database db;
    private Email email;
    private EmailView emailv;
    private RenterView RenterView;
    private SearchController search;
    private String id;
    private SubscribeView subscribe;

    //Default constructor
    public RenterController(){
        this.listings = new ArrayList<Property>();
        this.renter = new Renter();
        this.email = new Email();
        this.id = "";
        this.search = new SearchController();
    }

    //Constructor with database connection
    public RenterController(Database db)
    {
        this.search = new SearchController(db);
        this.db = db;
    }

    //Handle renter actions
    @Override
    public void actionPerformed(ActionEvent e) {
        db.initializeConnection();
        if(e.getSource().equals(RenterView.getSearch())) //renter chooses to search
        {
            RenterView.destroyFrame();
            search.enableView();
            search.getView().turnOn();
            search.getView().addBackButtonListener(this);
        }
        if(search.getView() != null)
        { 
            if(e.getSource().equals(search.getView().getBackButton())) 
            {
                search.getView().destroyFrameRenterGuest();
                RenterView.turnOn();
            }
        }
        if(e.getSource().equals(RenterView.getSelect())) //renters choose to select property
        {
            RenterView.destroyFrame();
            selectProp = new SelectPropertyView();
            selectProp.addSelectListener(this);
            selectProp.addEmailListener(this);
            selectProp.addBackListener(this);
            selectProp.turnOn();
        }
        if(e.getSource().equals(RenterView.getSubscribeButton())) //renter chooses to view new properties
        {
            RenterView.destroyFrame();
            subscribe = new SubscribeView();
            subscribe.addItemListener(this);
            subscribe.turnOn();
            subscribe.addBackListener(this);
            subscribe.addClearListener(this);
            subscribe.setTableData(copyProperties(db.getNewProperties(db.getLastLogin(this.renter.getId()))));
        }
        if(subscribe != null)
        {
            if(e.getSource().equals(subscribe.getBackButton()))
            {
                subscribe.destroyFrame();
                RenterView.turnOn();
            }
            if(e.getSource().equals(subscribe.getClearNotify()))
            {
                subscribe.setTableData();
            }
        }
        if(selectProp != null)
        {
            if(e.getSource().equals(selectProp.getSelectButton())) //renters selects property
            {
                if(selectProp.getPropertyID().equals(null) || selectProp.getPropertyID().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You have not entered an ID.");
                }
                else
                {
                    
                    id = selectProp.getPropertyID();
                    Property p = db.getProperty(Integer.valueOf(id));
                    if(p.getPropertyStatus().equals("Active"))
                    {
                        String allPropertyInfo = "";
                        allPropertyInfo += "Property ID: " + p.getID() + "\n";
                        allPropertyInfo += "Address: " + p.getAddress() + "\n";
                        allPropertyInfo += "Quadrant: " + p.getQuadrant() + "\n";
                        allPropertyInfo += "Type: " + p.getType() + "\n";
                        allPropertyInfo += "Number of Bedrooms: " + p.getNumOfBedrooms() + "\n";
                        allPropertyInfo += "Number of Bathrooms: " + p.getNumOfBathrooms() + "\n";
                        allPropertyInfo += "Furnished: " + p.getFurnished() + "\n";
                        allPropertyInfo += "\n";
                        selectProp.getPropertyInfoTextArea().setText(allPropertyInfo);
                        selectProp.getPropertyInfoTextArea().setFont(selectProp.getPropertyInfoTextArea().getFont().deriveFont(12f)); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Inputted Property ID is not currently Available.");
                        selectProp.getPropertyIdTextField().setText("");
                    }
                }
            }
            if(e.getSource().equals(selectProp.getEmailButton())) //renter chooses to send email
            {
                selectProp.destroyFrame();
                emailv = new EmailView(id);
                emailv.turnOn();
                emailv.addSendEmailListener(this);
            }
            if(e.getSource().equals(selectProp.getCloseButton()))
            {
                selectProp.destroyFrame();
                RenterView.turnOn();
            }
        }
        if(emailv != null)
        {
            if(e.getSource().equals(emailv.getSendButton())) //renter sends email
            {
                if(!emailv.getBody().equals("") && !emailv.getFrom().equals("") && !emailv.getSub().equals(""))
                {
                emailv.showDialog(); 
                emailv.destroyFrame();
                RenterView.turnOn();
                    
                }
                else
                {
                    emailv.showErrorDialog();
                }
            }
        }
    }

    //set listings
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

    //getters and setters
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
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
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

    public SearchController getSearch(){
        return this.search;
    }

    //copy arraylist of properties into 2d array
    public String[][] copyProperties(ArrayList<Property> properties){
        String[][] props = new String[properties.size()][2];
        for(int i = 0; i < properties.size(); i++){
            props[i][0] = String.valueOf(properties.get(i).getID());
            props[i][1] = properties.get(i).getAddress();
        }
        return props;
    }

    //enable renter homepage
    public void enableView(ActionListener logoutListener)
    {
        RenterView = new RenterView();
        RenterView.addLogoutListener(logoutListener);
        RenterView.addSearchListener(this);
        RenterView.addSelectListener(this);
        RenterView.addSubscribeListener(this);
    }

    //Listen for subscription select
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(e.getSource().equals(subscribe.getSubStatBox()))
            {
                subscribe.setTableData();
            }
        
    }
}

    
}
