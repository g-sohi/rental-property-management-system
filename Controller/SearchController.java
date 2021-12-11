package Controller;

/**
 * @author Curtis Silva <a href="mailto:curtis.silva@ucalgary.ca">
 *         curtis.silva@ucalgary.ca</a>
 * 
 * @author Gurpartap Sohi <a href="mailto:gurpartap.sohi@ucalgary.ca">
 *         gurpartap.sohi@ucalgary.ca</a>
 * 
 * @author Ivan Suyat<a href="mailto:ivan.suyat@ucalgary.ca">
 *         ivan.suyat@ucalgary.ca/a>
 * 
 * @author Manpreet Singh<a href="mailto:manpreet.singh2@ucalgary.ca">
 *         manpreet.singh2@ucalgary.ca</a>
 * 
 */

import Models.*;
import GUI.*;
import Database.*;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
import java.beans.BeanDescriptor;

/**
 * SearchController class controls the functionality for searching properties
 */
public class SearchController implements ActionListener, ListSelectionListener{
    //Private members for the SearchController class
    private SearchView sView;
    private User users;
    private int landlordID;
    private ArrayList<Property> listings;
    private Database db;
    private boolean rentSearch, managerSearch, landLordSearch;

    public SearchController(){
        this.users = new User();
        this.landlordID = -1;
        this.listings = new ArrayList<Property>();
        this.rentSearch = false;
        this.managerSearch = false;
        this.landLordSearch = false;
    }
    //SearchController constructor takes in an arugment of Database
    public SearchController(Database db) 
    {
        //Set all the booleans for the searchView for the different users (Renter, Landlord, Manager)
        //to false
        this.rentSearch = false;
        this.managerSearch = false;
        this.landLordSearch = false;
        //set private Database member db to the passed in argument Database variable
        this.db = db;
    }

    //actionPerformed function to do something if a components addListener is triggered
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        db.initializeConnection();  //initialize the private memeber Database db connection
        //Enter statement below if the display button for the searchView frame is triggered and landlordSearch boolean equals true
        if(e.getSource().equals(sView.getDisplayButton()) && landLordSearch == true)
        {
            //Call function getLandLordProperties in the Database class and pass in the member variable landlord ID
            //getLandlordProperties returns an ArrayList of type Properties, that returns all the Properties in the database
            //with the ladnlord ID that was passed in as an argument
            ArrayList<Property> landlordProperties = db.getLandlordProperties(landlordID);
            //set the memeber variable listings to landlordProperties
            setListings(landlordProperties);
            //Make a string array the same size as ArrayList landlordProperties size.
            String llproperties[] = new String[landlordProperties.size()];
            int IDs[] = new int[landlordProperties.size()];
            for(int i = 0; i < landlordProperties.size(); i++)
            {
                llproperties[i] = landlordProperties.get(i).getAddress();
                IDs[i] = landlordProperties.get(i).getID();
            }
            sView.getLandlordIdLabel().setText(String.valueOf(this.landlordID));
            sView.getAddressList().setListData(llproperties);
        }
        //Enter statment below if the display button for the searchView frame is triggered and managerSearch boolean equals true
        if(e.getSource().equals(sView.getDisplayButton()) && managerSearch == true)
        {
            ArrayList<Property> managerProperties = db.getManagerProperties();
            setListings(managerProperties);
            String allProperties[] = new String[managerProperties.size()];
            for(int i = 0; i < managerProperties.size(); i++)
            {
                allProperties[i] = managerProperties.get(i).getAddress();   //landlordProperties.get(i).getAddress();
            }
            sView.getAddressList().setListData(allProperties);
        }
        //Enter statement below if the reset button for the searchView frame is triggered
        if(e.getSource().equals(sView.getResetButton()))
        {
            //Reset all the input fields to be blank or empty
            sView.setBedsInput("");
            sView.setBathsInput("");
            sView.getQuadrants().setSelectedIndex(0);
            sView.getTypes().setSelectedIndex(0);
            sView.getGroup().clearSelection();
        }

        if(sView.getSearchButton() != null)
        {
            //Enter if the search button in the searchView frame is not null
            if(e.getSource().equals(sView.getSearchButton()))
            { 
                //initialize the database connection
                db.initializeConnection();
                //Enter if statement below if the rentSearch boolean is set to true
                if(rentSearch)
                {
                    //Set and display searchView frame here for the Renter user
                    //Take the input entries the user put in and use it to initialize a Property object using the constructo
                    Property requestedPropertyType = new Property(-1, null,sView.getQuadrantInput(), sView.getTypeInput(), sView.getBedsInput(), sView.getBathsInput(), sView.getFurnishedInput(), null, "Active");
                    //Send the property you made with user specifications to the method getSearchProperties in the Database
                    //class to search the database for properties with the exact same specification
                    //The method will return an arrayList of type Property with properties that are a match
                    ArrayList<Property> input = db.getSearchProperties(requestedPropertyType);
                    //Set the headers for the display table in searchView
                    String[] columnNames = { "Property ID: #", "Address", "Furnished", "Type"};
                    //Make a 2D String array for the JTable in the searchView which will contain the data
                    String results[][] = displayProperty(input, columnNames);

                    JTable test2 = new JTable(results, columnNames);

                    final TableColumnModel columnModel = test2.getColumnModel();
                    columnModel.getColumn(0).setPreferredWidth(7);
                    columnModel.getColumn(1).setPreferredWidth(20);
                    columnModel.getColumn(2).setPreferredWidth(7);
                    columnModel.getColumn(3).setPreferredWidth(20);
                    test2.setRowHeight(25);
                    test2.getTableHeader().setBackground(Color.LIGHT_GRAY);
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setViewportView(test2);
                    scrollPane.setBounds(30, 325, 440, 115);

                    sView.add(scrollPane);  
                }
                else if(landLordSearch)
                {

                }
                else if(managerSearch)
                {

                }   
            }
        }
    }

    //Display properties in table
    public String[][] displayProperty(ArrayList<Property> obj, String headers[])
    {
        
        String displayMessages[][] = new String[obj.size()][headers.length];
        for(int i = 0; i < displayMessages.length; i++)
        {
            for(int j = 0; j < displayMessages[i].length; j++)
            {
                if(headers[j].equals("Property ID: #"))
                {
                    displayMessages[i][j] = String.valueOf(obj.get(i).getID());
                }
                else if(headers[j].equals("Address"))
                {
                    displayMessages[i][j] = obj.get(i).getAddress();
                }
                else if(headers[j].equals("Furnished"))
                {
                        displayMessages[i][j] = obj.get(i).getFurnished();
                }
                else if(headers[j].equals("Type"))
                {
                    displayMessages[i][j] = obj.get(i).getType();
                }
            }
        }
        
        return (displayMessages);
    }

    //getters and setters
    public void setLandlordID(int id){
        this.landlordID = id;
    }

    
    public SearchView getView() {
        return sView;
    }

    public void setsView(SearchView sView) {
        this.sView = sView;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
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

    //enable renter search view
    public void enableView() {
        rentSearch = true;
        sView = new SearchView(); 
        this.sView.addSearchListener(this);
        this.sView.addResetListener(this);
        sView.turnOn();
    }

    //reset user type for search view
    public void resetSearchType(){
        rentSearch = false;
        managerSearch = false;
        landLordSearch = false;
    }

    //enable search view for manager
    public void enableMGrView()
    {
        managerSearch = true;
        sView = new SearchView(); 
        this.sView.addDisplayListener(this);
        sView.turnOnForManager();
        this.sView.addSelectListener(this);
    }

    //enable landlord search view
    public void enableLlrdView(){
        landLordSearch = true;
        sView = new SearchView();
        this.sView.addDisplayListener(this);
        sView.turnOnForLandlord();
        this.sView.addSelectListener(this);
    }

    //display properties 
    public void displayPropertyInfo(Property p)
    {
        Vector<String> tableInputs = new Vector<String>();
        tableInputs.add(String.valueOf(p.getID()));
        tableInputs.add(p.getAddress());
        tableInputs.add(p.getQuadrant());
        this.sView.getJTableModel1().setRowCount(0);
        this.sView.getJTableModel1().addRow(tableInputs);
        this.sView.getJTable1().revalidate();

        Vector<String> tableInputs2 = new Vector<String>();
        tableInputs2.add(p.getType());
        tableInputs2.add(String.valueOf(p.getNumOfBedrooms()));
        tableInputs2.add(String.valueOf(p.getNumOfBathrooms()));
        tableInputs2.add(p.getFurnished());
        this.sView.getJTableModel2().setRowCount(0);
        this.sView.getJTableModel2().addRow(tableInputs2);
        this.sView.getJTable2().revalidate();

        Vector<String> tableInputs3 = new Vector<String>();
        tableInputs3.add(String.valueOf(p.getPropertyFees().getAmount()));
        tableInputs3.add("YES");
        tableInputs3.add(p.getPropertyStatus());
        this.sView.getJTableModel3().setRowCount(0);
        this.sView.getJTableModel3().addRow(tableInputs3);
        this.sView.getJTable3().revalidate();

        Vector<String> tableInputs4 = new Vector<String>();
        tableInputs4.add(p.getStartDate());
        tableInputs4.add(p.getEndDate());
        tableInputs4.add(p.getRentDate());
        this.sView.getJTableModel4().setRowCount(0);
        this.sView.getJTableModel4().addRow(tableInputs4);
        this.sView.getJTable4().revalidate();
    }

    //listen for property selection
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource().equals(this.sView.getAddressList()))
        {
            Property p = new Property(getListings().get(this.sView.getAddressList().getSelectedIndex()).getID(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getAddress(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getQuadrant(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getType(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getNumOfBedrooms(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getNumOfBathrooms(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getFurnished(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getPropertyFees(), 
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getPropertyStatus(),
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getStartDate(),
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getEndDate(),
                getListings().get(this.sView.getAddressList().getSelectedIndex()).getRentDate());
            displayPropertyInfo(p);
        }       
    }
}

