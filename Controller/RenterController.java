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
    private RenterView RenterView;
    private SearchController search;
    private String id;

    public RenterController(Database db)
    {
        search = new SearchController(db);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(RenterView.getSearch()))
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
        if(e.getSource().equals(RenterView.getSelect()))
        {
            RenterView.destroyFrame();
            selectProp = new SelectPropertyView();
            selectProp.addSelectListener(this);
            selectProp.addEmailListener(this);
            selectProp.addBackListener(this);
            selectProp.turnOn();
        }
        if(selectProp != null)
        {
        if(e.getSource().equals(selectProp.getSelectButton()))
        {
                id = selectProp.getPropertyID();
                System.out.println("ID: " + id);
        }
        if(e.getSource().equals(selectProp.getEmailButton()))
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
            if(e.getSource().equals(emailv.getSendButton()))
            {
                System.out.println(emailv.getBody());
                System.out.println(emailv.getFrom());
                if(!emailv.getBody().equals("") && !emailv.getFrom().equals("") && !emailv.getSub().equals(""))
                {
                emailv.showDialog(); 
                emailv.destroyFrame();
                RenterView.turnOn();
                    
                }
                else
                {
                    System.out.println("Error");
                    emailv.showErrorDialog();
                }
            }
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

    public SearchController getSearch(){
        return this.search;
    }

    public void enableView(ActionListener logoutListener)
    {
        RenterView = new RenterView();
        RenterView.addLogoutListener(logoutListener);
        RenterView.addSearchListener(this);
        RenterView.addSelectListener(this);
    }

    
}
