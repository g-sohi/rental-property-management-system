package Controller;

import Models.*;
import Database.*;
import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PropertyController implements ActionListener {
    //Member variables for class PropertyController
    private EditPropertyView edit;
    private ArrayList<Property> listing;
    private LandlordController landlord;
    private ManagerController manager;
    private Database db;
    private int iD;
    private String userType;

    /*public PropertyController(Database db, int id){
        this.setDb(db);
        this.landLordID = id;
    }*/

    public PropertyController(Database db){
        this.setDb(db);
    
    }
    public PropertyController(Database db, int id, String type) {
        this.setDb(db);
        this.iD = id;
        this.userType = type;

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

    public EditPropertyView getEditView() {
        return edit;
    }
    
    public void setEdit(EditPropertyView edit) {
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

    public void enableView()
    {
        edit = new EditPropertyView();
        this.edit.addSaveListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.edit!= null)
        {
            db.initializeConnection();
            System.out.println("ID is:" +iD);
            System.out.println("UserType is: " + userType);
            String rentDate = edit.getRentYearInput() + "-"+edit.getRentMonthInput()+"-"+ edit.getRentDayInput();
            if(e.getSource().equals(edit.getSaveButton()))
            {
                if(userType.equals("Landlord"))
                {
                System.out.println("Landlord");
                db.updatePropertyLandLord(edit.getPropetyIdInput(), edit.getStatusInput(), rentDate, iD);
                System.out.println("New Information Saved");
                edit.destroyFrame();
                }
                else
                {
                db.updateProperty(edit.getPropetyIdInput(), edit.getStatusInput(), rentDate);
                System.out.println("New Information Saved");
                edit.destroyFrame();
                }
            }
            }
        }

}
