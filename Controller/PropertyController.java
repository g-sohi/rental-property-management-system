package Controller;

import Models.*;
import Database.*;
import GUI.*;

import java.util.*;

public class PropertyController {
    //Member variables for class PropertyController
    private EditPropetyView edit;
    private ArrayList<Property> listing;
    private LandlordController landlord;
    private ManagerController manager;
    private Database db;

    public PropertyController(){

    }

    public void editProperty(Property p)
    {

    }

    public void removeProperty(Property p)
    {

    }

    public void updateListing(Property p)
    {

    }

    public EditPropetyView getEdit() {
        return edit;
    }
    
    public void setEdit(EditPropetyView edit) {
        this.edit = edit;
    }
    
    public ArrayList<Property> getListing() {
        return listing;
    }

    public void setListing(ArrayList<Property> listing) {
        this.listing = listing;
    }

    public LandlordController getLandlord() {
        return landlord;
    }

    public void setLandlord(LandlordController landlord) {
        this.landlord = landlord;
    }

    public ManagerController getManager() {
        return manager;
    }

    public void setManager(ManagerController manager) {
        this.manager = manager;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }


}
