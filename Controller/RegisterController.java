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

    public RegisterController() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(createProp.getRegister())){
            System.out.println("Register Property");
            //this.add(p);
        }
    }

    public CreatePropertyView getCreateProp() {
        return createProp;
    }

    public void add(Property p) {
        //db.initializeConnection();
        //db.addProperty(id, address, type, numBedrooms, numBathrooms, furnished, fees, status, landID, startD, endD);
        //db.close();
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
