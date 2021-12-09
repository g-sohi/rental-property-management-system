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
    private int landLordID;

    public RegisterController(Database db) {
        this.setDb(db);
    }

    public RegisterController(Database db, int lordID) {
        this.setDb(db);
        this.landLordID = lordID;
    }

    public int getLandlordID()
    {
        return landLordID;
    }

    public void setLandlordID(int id)
    {
        this.landLordID = id;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(createProp.getRegister())){
            System.out.println("Register Property");
            String address = createProp.getStreetNoInput() +", " + createProp.getStreetNameInput() +", " + createProp.getCityInput() + ", " + createProp.getPostalCodeInput();
            Property p = new Property(address, createProp.getQuadrantInput(), createProp.getTypeInput(), createProp.getNoOfBedInput(), createProp.getNoOfBathInput(), createProp.getFurnishedInput(), null, "Suspended");
            this.add(p);
        }
    }

    public CreatePropertyView getCreateProp() {
        return createProp;
    }

    public void add(Property p) {
        db.initializeConnection();
        db.addProperty(p.getAddress(), p.getQuadarnt(), p.getType(), p.getNumOfBedrooms(), p.getNumOfBathrooms(), p.getFurnished(), 0, p.getPropertyStatus(), landLordID, "null", "null");
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


    public void enableView(){
        createProp = new CreatePropertyView();
        this.getCreateProp().addRegisterPropertyListener(this);
    }
}
