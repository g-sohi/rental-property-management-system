package Controller;

import Models.*;
import GUI.*;
import Database.*;

import java.util.*;

public class RenterController {
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
}
