package Controller;

import Database.*;
import GUI.*;
import Models.*;

import java.util.*;

public class RegisterController {
    
    private CreatePropertyView createProp;
    private ArrayList<Property> listings;
    private Database db;
    private LandlordController landLord;

    public RegisterController() {
        
    }

    public CreatePropertyView getCreateProp() {
        return createProp;
    }

    public void add(Property p) {

    }

    public void setCreateProp(CreatePropertyView createProp) {
        this.createProp = createProp;
    }

    public ArrayList<Property> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Property> listings) {
        this.listings = listings;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public LandlordController getLandLord() {
        return landLord;
    }

    public void setLandLord(LandlordController landLord) {
        this.landLord = landLord;
    }
}
