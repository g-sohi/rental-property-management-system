package Controller;

import Database.*;
import GUI.*;
import Models.*;

import java.util.*;
import java.awt.event.*;


public class RegisterController implements ActionListener{
    
    private CreatePropertyView createProp;
    private ArrayList<Property> listings;
    private Database db;
    private LandlordController landLord;
    private static int propID;

    public RegisterController(Database db) {
        this.setDb(db);
        this.propID = 3;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(createProp.getRegister())){
            System.out.println("Register Property");
            String address = createProp.getStreetNoInput() + createProp.getStreetNameInput() + createProp.getCityInput() +createProp.getPostalCodeInput();
            this.propID++;
            Property p = new Property(propID ,address, createProp.getQuadrantInput(), createProp.getTypeInput(), createProp.getNoOfBedInput(), createProp.getNoOfBathInput(), createProp.getFurnishedInput(), null, "Suspended");
            this.add(p);
        }
    }

    public CreatePropertyView getCreateProp() {
        return createProp;
    }

    public void add(Property p) {
        db.initializeConnection();
        db.addProperty(p.getID(), p.getAddress(), p.getQuadarnt(), p.getType(), p.getNumOfBedrooms(), p.getNumOfBathrooms(), p.getFurnished(), 100.50, p.getPropertyStatus(), 10, "null", "null");
        db.close();
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

    public void enableView(){
        createProp = new CreatePropertyView();
        this.getCreateProp().addRegisterPropertyListener(this);
    }
}
