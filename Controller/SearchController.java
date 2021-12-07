
package GUI;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import Models.Property;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

public class SearchView extends JFrame{
    private String type[], quadrant[];
    private JComboBox typeBox, quadrantBox, furnished; //change UML; type to typeBox; quadrant to quadrantBox
    private JTextField noBeds, noBaths, streetNo, streetName, city, postalCode, landlordName;
    private JButton register;
    //added in private members
    private JButton search;
    JList propertiesView;

    public SearchView()
    {   
        setSize(500, 500);

        //Make a JPanel for the search boxes
        JPanel searchPanel1 = new JPanel();  
        searchPanel1.setBounds(50, 90, 400, 210);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray

        JPanel searchPanel2 = new JPanel();  
        searchPanel2.setBounds(45, 95, 400, 210);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel2.setBackground(Color.GRAY); //set the background color to light gray

        JPanel results = new JPanel();
        results.setBounds(20, 315, 460, 135);     //set the x, y coordinates for the panel as well as the width the height 
        results.setBackground(Color.LIGHT_GRAY);

        //propertiesView = new JList();

        //Set up the GUI components of the Search Frame, including textfields, buttons, and panels
        JLabel noBedsLabel = new JLabel("Beds: ");
        noBeds = new JTextField("Enter number of beds...");

        JLabel noBathsLabel = new JLabel("Baths: ");
        noBaths = new JTextField("Enter number of baths...");

        JLabel streetNoLabel = new JLabel("Street Number: ");
        streetNo = new JTextField("Enter Street Number...");

        JLabel streetNameLabel = new JLabel("Street Name: ");
        streetName = new JTextField("Enter Street Name...");

        JLabel cityLabel = new JLabel("City: ");
        city = new JTextField("Enter City...");

        JLabel postalCodeLabel = new JLabel("Postal Code: ");
        postalCode = new JTextField("Enter Postal Code if applicable...");

        JLabel landlordLabel = new JLabel("Landlord: ");
        landlordName = new JTextField("Enter landlord name if applicable...");

        search = new JButton("Search");

        //search.setForeground(Color.BLACK);
        JButton reset = new JButton("Reset");
        reset.setForeground(Color.GRAY);

        //Add all the GUI components created above to the JFrame called searchFrame
        //add(propertiesView);

        add(noBedsLabel);
        add(noBeds);

        add(noBathsLabel);
        add(noBaths);

        add(streetNoLabel);
        add(streetNo);

        add(streetNameLabel);
        add(streetName);

        add(cityLabel);
        add(city);

        add(postalCodeLabel);
        add(postalCode);

        add(landlordLabel);
        add(landlordName);

        add(search);
        add(reset);

        add(searchPanel1);
        add(searchPanel2);
        add(results);

        
        //set the coordinates of the GUI components in the JFrame
        streetNoLabel.setBounds(70, 100, 240, 30);
        streetNo.setBounds(190, 100, 240, 30);

        streetNameLabel.setBounds(70, 130, 240, 30);
        streetName.setBounds(190, 130, 240, 30);

        cityLabel.setBounds(70, 160, 240, 30);
        city.setBounds(190, 160, 240, 30);

        postalCodeLabel.setBounds(70, 190, 240, 30);
        postalCode.setBounds(190, 190, 240, 30);

        landlordLabel.setBounds(70, 220, 240, 30);
        landlordName.setBounds(190, 220, 240, 30);

        search.setBounds(370, 270, 80, 30);
        reset.setBounds(300, 270, 80, 30);

        search.setBackground(new Color(99, 182, 255));

        setLayout(null);
        setVisible(true);
    }

    //Getter functions to get the users inputted value from the text fields
    //This method returns the number of beds the user inputted
    public String getBedsInput()
    {
        return noBeds.getText();
    }

    //This method returns the number of baths the user inputted
    public String getBathInput()
    {
        return noBaths.getText();
    }

    //This method returns the Street Number the user inputted
    public String getStreetNoInput()
    {
        return streetNo.getText();
    }

    //This method returns the Street Name the user inputted
    public String getStreetNameInput()
    {
        return streetName.getText();
    }

    //This method returns the City the user inputted
    public String getCityInput()
    {
        return city.getText();
    }

    //This method returns the PostalCode the user inputted
    public String getPostalCodeInput()
    {
        return postalCode.getText();
    }

    //This methods returns the landlord name the user inputted
    public String getLandlordInput()
    {
        return landlordName.getText();
    }

    // public JList getPropertiesList()
    // {
    //     return propertiesView;
    // }

    // public void setPropertiesList(Property databaseProperties[])
    // {
    //     JList<Property> propertiesView = new JList<Property>(databaseProperties);
    //     propertiesView.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    //     propertiesView.setLayoutOrientation(JList.VERTICAL);
    //     propertiesView.setVisibleRowCount(-1);
    //     add(propertiesView);
    //     //JList<Property> propertiesView = new JList<Property>(databaseProperties.toArray(new Property[databaseProperties.size()]));
    // }

    public JButton getSearchButton()
    {
        return this.search;
    }

    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/   
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     // TODO Auto-generated method stub
        
    // // }
    // public static void main(String [] args)
    // {
    //     Property test = new Property(17, "5 Street NW", "Home", 3, 2, true, null, "Active");
    //     SearchView testView = new SearchView();
    //     Property input[] = {test};
    //     testView.setPropertiesList(input);
    // }
}




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

    public SearchController(Database db) 
    {
        this.db = db;
        sView = new SearchView(); 
        this.sView.addSearchListener(this);
        this.sView.addResetListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(sView.getResetButton()))
        {
            sView.setBedsInput("");
            sView.setBathsInput("");
            sView.setStreetNoInput("");
            sView.setStreetNameInput("");
            sView.setCityInput("");
            sView.setPostalCodeInput("");
            sView.setLandlordInput("");
        }
        if(e.getSource().equals(sView.getSearchButton()))
        {
            System.out.println("StreeNo is: " + sView.getStreetNoInput() + " and StreetAddress is: " + sView.getStreetNameInput());
            String complete_Address = sView.getStreetNoInput() + ", " + sView.getStreetNameInput();
            Property requestedPropertyType = new Property(1, "240 ENGZ, University of Calgary", "Detached", -1, -1, null, null, "Available");
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
                System.out.print(input.get(i));
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

    
    public SearchView getsView() {
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

