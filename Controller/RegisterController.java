package Controller;

import Database.*;
import GUI.*;
import Models.*;

import java.util.*;
import java.awt.event.*;


/**
 * RegisterController class controls the functionality registering new properties 
 */
public class RegisterController implements ActionListener{
    
    private CreatePropertyView createProp;
    private ArrayList<Property> listings;
    private Database db;
    private int landLordID;
    private LandlordView landView;

    //Default constructor
    public RegisterController(){
        this.listings = new ArrayList<Property>();
        this.landLordID = -1;
    }

    //Constructor with database connection
    public RegisterController(Database db) {
        this.setDb(db);
    }

    //Constructor with database connection and landlord ID
    public RegisterController(Database db, int lordID) {
        this.setDb(db);
        this.landLordID = lordID;
    }

    //getters and setters
    public int getLandlordID()
    {
        return landLordID;
    }

    public void setLandlordID(int id)
    {
        this.landLordID = id;
    }

    public CreatePropertyView getCreateProp() {
        return createProp;
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

    //Enable landlord main page
    public void enableView(LandlordView landlordView){
        createProp = new CreatePropertyView();
        this.landView = landlordView;
        this.getCreateProp().addRegisterPropertyListener(this);
        this.getCreateProp().addBackPropertyListener(this);
    }

    //Add property 
    public void add(Property p) {
        db.initializeConnection();
        db.addProperty(p.getAddress(), p.getQuadarnt(), p.getType(), p.getNumOfBedrooms(), p.getNumOfBathrooms(), p.getFurnished(), 0, p.getPropertyStatus(), landLordID, "null", "null");
        db.close();
    }
    
    //Handle property registrations
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(createProp.getRegister()))
        {
            if(!createProp.getStreetNoInput().equals("") && !createProp.getStreetNameInput().equals("") && !createProp.getCityInput().equals("") && !createProp.getPostalCodeInput().equals(""))
            {;
                String address = createProp.getStreetNoInput() +", " + createProp.getStreetNameInput() +", " + createProp.getCityInput() + ", " + createProp.getPostalCodeInput();
                Property p = new Property(landLordID, address, createProp.getQuadrantInput(), createProp.getTypeInput(), createProp.getNoOfBedInput(), createProp.getNoOfBathInput(), createProp.getFurnishedInput(), null, "Suspended");
                this.add(p);
                createProp.showDialog();
                createProp.destroyFrame();
                landView.turnOn();
            }
            else{
                createProp.showErrorDialog();
            }
        }

}
}
