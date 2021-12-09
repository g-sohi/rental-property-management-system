package Controller;

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

public class SearchController implements ActionListener, ListSelectionListener{

    private SearchView sView;
    private User users;
    private int landlordID;
    private ArrayList<Property> listings;
    private Database db;
    private boolean rentSearch, managerSearch, landLordSearch;

    public SearchController(Database db) 
    {
        rentSearch = false;
        managerSearch = false;
        landLordSearch = false;
        this.db = db;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource().equals(sView.getDisplayButton()))
        {
            System.out.println("Display working");
            ArrayList<Property> landlordProperties = db.getLandlordProperties(landlordID);
            this.listings = landlordProperties;
            setListings(landlordProperties);
            String llproperties[] = new String[landlordProperties.size()];
            int IDs[] = new int[landlordProperties.size()];
            for(int i = 0; i < landlordProperties.size(); i++)
            {
                llproperties[i] = landlordProperties.get(i).getAddress();
                IDs[i] = landlordProperties.get(i).getID();
            }
            sView.getJList2().setListData(llproperties);
        }

        if(e.getSource().equals(sView.getResetButton()))
        {
            sView.setBedsInput("");
            sView.setBathsInput("");
            sView.getQuadrants().setSelectedIndex(0);
            sView.getTypes().setSelectedIndex(0);
            sView.getGroup().clearSelection();
        }

        if(sView.getSearchButton() != null)
        {
            if(e.getSource().equals(sView.getSearchButton()))
            { 
                db.initializeConnection();
                if(rentSearch){
                Property requestedPropertyType = new Property(null,sView.getQuadrantInput(), sView.getTypeInput(), sView.getBedsInput(), sView.getBathsInput(), sView.getFurnishedInput(), null, "Active");
                ArrayList<Property> input = db.getSearchProperties(requestedPropertyType);
                String[] columnNames = { "Property ID: #", "Address", "Furnished", "Fees"};
                String results[][] = displayProperty(input, columnNames);

                System.out.println("PRINTING RESULTS: ");
                for(int i = 0; i < results.length; i++)
                {
                    for(int j = 0; j < results[i].length; j++)
                    {
                        System.out.print(results[i][j]);
                    }
                    System.out.println();
                }

                System.out.println("PRINTING INPUT: ");
                for(int i = 0; i < input.size(); i++)
                {
                    System.out.print(input.get(i).getAddress());
                }
                //sView.setPropertiesList(input);
                // JList<String> test2 = new JList<String>(results);
                // test2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                // test2.setLayoutOrientation(JList.VERTICAL_WRAP);
                // test2.setVisibleRowCount(1);
                // sView.add(test2);

                JTable test2 = new JTable(results, columnNames);
                // test2.getColumnModel().getColumn(0).setPreferredWidth(10);
                // test2.getColumnModel().getColumn(1).setPreferredWidth(30);
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
                //JButton test2 = new JButton("Something happened");
                //sView.add(test2);
                sView.add(scrollPane);

            }
            else if(landLordSearch){
                System.out.println("Landlord search");
                System.out.println("This is the Landlord ID in Search Controller " + this.landlordID);
            }
            else if(managerSearch){
                System.out.println("Manager search");
            }
        }
    }
    }
    // public static void main(String [] args)
    // {

    //     SearchController testView = new SearchController();
        
    // }

    // public void makeSearch()
    // {
    //     ArrayList<Property> filteredProperties = filterAll();
    //     displayAll(filteredProperties);
    // }
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
                else if(headers[j].equals("Fees"))
                {
                    if(obj.get(i).getPropertyFees() == null)
                    {
                        displayMessages[i][j] = "N/A Property Fees";
                    }
                    else
                    {
                        displayMessages[i][j] = "Fees: $";
                    }
                }
            }
        }
        
        return (displayMessages);
    }
    public void displayAll(ArrayList<Property> listings) 
    {
        
    }

    public void filterAll() 
    {

    }

    public void update(ArrayList<Property> listings) 
    {
        
    }

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

    public void enableView() {
        rentSearch = true;
        sView = new SearchView(); 
        this.sView.addSearchListener(this);
        this.sView.addResetListener(this);
        sView.turnOn();
    }

    public void resetSearchType(){
        rentSearch = false;
        managerSearch = false;
        landLordSearch = false;
        System.out.println("Search reset");
    }

    public void enableMGrView()
    {
        managerSearch = true;
        sView = new SearchView(); 
        this.sView.addSearchListener(this);
        sView.turnOnForManager();
        //sView.mgr();
    }

    public void enableLlrdView(){
        landLordSearch = true;
        sView = new SearchView();
        this.sView.addDisplayListener(this);
        sView.turnOnForLandlord();
        this.sView.addSelectListener(this);
        System.out.println("This is the Landlord ID in Search Controller " + this.landlordID);
        //sView.llrd();
    }

    public void displayPropertyInfo(Property p)
    {
        Vector<String> tableInputs = new Vector<String>();
        tableInputs.add(String.valueOf(p.getID()));
        tableInputs.add(p.getAddress());
        tableInputs.add(p.getQuadrant());
        this.sView.getJTableModel1().getDataVector().removeAllElements();
        this.sView.getJTableModel1().addRow(tableInputs);
        this.sView.getJTable1().revalidate();

        tableInputs.clear();
        tableInputs.add(p.getType());
        tableInputs.add(String.valueOf(p.getNumOfBedrooms()));
        tableInputs.add(String.valueOf(p.getNumOfBathrooms()));
        tableInputs.add(p.getFurnished());
        this.sView.getJTableModel2().getDataVector().removeAllElements();
        this.sView.getJTableModel2().addRow(tableInputs);
        this.sView.getJTable2().revalidate();

        tableInputs.clear();
        tableInputs.add(String.valueOf(p.getPropertyFees().getAmount()));
        tableInputs.add("YES");
        tableInputs.add(p.getPropertyStatus());
        this.sView.getJTableModel3().getDataVector().removeAllElements();
        this.sView.getJTableModel3().addRow(tableInputs);
        this.sView.getJTable3().revalidate();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource().equals(this.sView.getJList2()))
        {
            Property p = new Property(getListings().get(this.sView.getJList2().getSelectedIndex()).getID(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getAddress(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getQuadrant(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getType(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getNumOfBedrooms(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getNumOfBathrooms(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getFurnished(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getPropertyFees(), 
                getListings().get(this.sView.getJList2().getSelectedIndex()).getPropertyStatus());
            displayPropertyInfo(p);
            //System.out.println("item selected: " + this.sView.getJList2().getSelectedValue());
            //System.out.println("Bedrroms: " + getListings().get(this.sView.getJList2().getSelectedIndex()).getNumOfBedrooms());
        }
        
    }
}

