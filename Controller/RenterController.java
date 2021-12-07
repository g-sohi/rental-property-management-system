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

    public RenterController()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    public void enableView(ActionListener logoutListener)
    {
        RenterView = new RenterView();
        this.getRenterView().addLogoutListener(logoutListener);
    }

    
}
