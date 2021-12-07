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

    public PropertyController(Database db){
        this.setDb(db);
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
        this.edit.addRemoveListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.edit!= null)
        {
            db.initializeConnection();
            if(e.getSource().equals(edit.getSaveButton()))
            {
                db.updateProperty(10, "Cancelled");
                System.out.println("New Information Saved");
                edit.destroyFrame();
            }
            else if(e.getSource().equals(edit.getRemoveButton())){
                db.removeProperty(10);
                System.out.println("Property Removed");
                edit.destroyFrame();
            }
          }
        }

}
