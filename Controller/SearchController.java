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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
import java.beans.BeanDescriptor;

public class SearchController implements ActionListener{


    private SearchView sView;
    private User users;
    private ArrayList<Property> listings;
    private Database db;

    public SearchController() 
    {

    }


    public void enableView(ActionListener searchListener)
    {
        this.sView = new SearchView(); 
        this.sView.addSearchListener(searchListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(sView.getSearchButton()))
        {
            System.out.println("COMPLETED");
            Property prop1 = new Property(17, "5 Street NW", "Home", 3, 2, "Yes", null, "Active");
            Property prop2 = new Property(17, "100 Heights SW", "Condo", 2, 1, "No", null, "Active");
            Property input[] = {prop1, prop2};
            String[] columnNames = { "Property ID: #", "Address", "Furnished", "Fees"};
            String results[][] = displayProperty(input, columnNames);
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
    }

    // public void makeSearch()
    // {
    //     ArrayList<Property> filteredProperties = filterAll();
    //     displayAll(filteredProperties);
    // }
    public String[][] displayProperty(Property obj[], String headers[])
    {
        
        String displayMessages[][] = new String[obj.length][headers.length];
        for(int i = 0; i < displayMessages.length; i++)
        {
            for(int j = 0; j < displayMessages[i].length; j++)
            {
                if(headers[j].equals("Property ID: #"))
                {
                    displayMessages[i][j] = String.valueOf(obj[i].getID());
                }
                else if(headers[j].equals("Address"))
                {
                    displayMessages[i][j] = obj[i].getAddress() + "\n";
                }
                else if(headers[j].equals("Furnished"))
                {
                    if(obj[i].getFurnished() == "Yes")
                    {
                        displayMessages[i][j] = "Yes" + "\n";
                    }
                    else
                    {
                        displayMessages[i][j] = "No" + "\n";
                    }
                }
                else if(headers[j].equals("Fees"))
                {
                    if(obj[i].getPropertyFees() == null)
                    {
                        displayMessages[i][j] = "N/A Property Fees" + "\n";
                    }
                    else
                    {
                        displayMessages[i][j] = "Fees: $" + "\n";
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
}
