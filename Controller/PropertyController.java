package Controller;

import Models.*;
import Database.*;
import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * PropertyController class controls the functionality for editing properties
 */
public class PropertyController implements ActionListener {
    //Member variables for class PropertyController
    private EditPropertyView edit;
    private ArrayList<Property> listing;
    private LandlordController landlord;
    private ManagerController manager;
    private Database db;
    private int iD;
    private String userType;

    //Default Constructor
    public PropertyController(){
        this.listing = new ArrayList<Property>();
        this.landlord = new LandlordController();
        this.manager = new ManagerController();
        this.iD = -1;
        this.userType = "";
    }

    //Constructor with database connection
    public PropertyController(Database db){
        this.setDb(db);
    
    }
    //Constructor with database connection and user info
    public PropertyController(Database db, int id, String type) {
        this.setDb(db);
        this.iD = id;
        this.userType = type;

    }

    //getters and setters
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

    //Handle events for updating property information
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.edit!= null)
        {
            db.initializeConnection();
            String rentDate = edit.getRentYearInput() + "-"+edit.getRentMonthInput()+"-"+ edit.getRentDayInput();
            if(e.getSource().equals(edit.getSaveButton()))
            {
                if(!edit.getPropertyIDStringInput().equals("")) //
                {
                    if(userType.equals("Landlord"))
                    {
                        db.updatePropertyLandLord(edit.getPropetyIdInput(), edit.getStatusInput(), rentDate, iD);
                        edit.destroyFrame();
                    }
                    else
                    {
                        db.updateProperty(edit.getPropetyIdInput(), edit.getStatusInput(), rentDate);
                        edit.destroyFrame();
                    }
                }
            }
        }
    }

}
