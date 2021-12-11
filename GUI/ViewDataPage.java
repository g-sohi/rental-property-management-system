package GUI;
import Database.Database;
import javax.swing.JFrame;
import java.sql.*;
import java.awt.event.*;

import java.util.ArrayList;

//import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Models.*;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewDataPage extends JFrame {
    
    // variable declaration
    private JButton renterInfo, propertyInfo, landlordInfo, back;
    private JTable dataPage;
    private String data[][];
    private String userColumns[] = {"Username", "First Name", "Last Name", "ID", "User Type"};
    private String propertyColumns[] = {"Property ID", "Address", "Quadrant", "Type", "#ofBeds", "#ofBaths", "Furnished", "Fees", "Fees Paid", "Status", "Landlord ID", "Start Date", "End Date", "Fee Period", "Rent Date"};
    private DefaultTableModel model;
    private JScrollPane tableScroll;

    // constructor - sets up GUI components
    public ViewDataPage()
    {
        // configures JFrame
        setSize(1500, 700);
        setLayout(null);
        setTitle("View Information");

        // creates JButtons with particular text
        renterInfo = new JButton("Renter Info");
        propertyInfo = new JButton("Property Info");
        landlordInfo = new JButton("LandLord Info");
        back = new JButton("Back");

        // adds JButtons to JFrame
        add(renterInfo);
        add(propertyInfo);
        add(landlordInfo);
        add(back);
        
        // sets size and position of JButtons
        renterInfo.setBounds(450,10,150,30);
        propertyInfo.setBounds(675,10,150,30);
        landlordInfo.setBounds(900,10,150,30);
        back.setBounds(40, 10, 80, 30);
        
        setLocationRelativeTo(null);

        setVisible(false); // ensures JFrame is not visible for proper function of other methods
    }

    // sets up JTable with columns particularly for users (i.e., renter, landlord)
    public void user(String[][] users) {
        
        // model to be used for table - sets all cells in table as uneditable
        model = new DefaultTableModel(users, userColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // creates a table using given data and appropriate column headers
        dataPage = new JTable(users, userColumns);
        dataPage.setModel(model);
        tableScroll = new JScrollPane(dataPage); // for scroll feature to accomodate for more rows
        tableScroll.setBounds(25, 50, 1450, 600); // size and position configuration
        add(tableScroll);
        turnOn(); // sets the particular view for users to appear
    }

    // sets up JTable with columns particularly for properties
    public void prop(String[][] properties) {

        // model to be used for table - sets all cells in table as uneditable
        model = new DefaultTableModel(properties, propertyColumns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // creates a table using given data and appropriate column headers
        dataPage = new JTable(properties, propertyColumns);
        dataPage.setModel(model);
        dataPage.getColumnModel().getColumn(1).setPreferredWidth(150); // accomodates for length of Address strings
        tableScroll = new JScrollPane(dataPage); // for scroll feature to accomodate for more rows
        tableScroll.setBounds(25, 50, 1450, 600); // size and position configuration
        add(tableScroll);
        turnOn(); // sets the particular view for properties to appear
    }

    // methods for getting button components
    public JButton getRenterInfoButton()
    {
        return renterInfo;
    }

    public JButton getLandlordInfoButton()
    {
        return landlordInfo;
    }

    public JButton getPropertyInfoButton()
    {
        return propertyInfo;
    }

    public JButton getBackButton()
    {
        return back;
    }

    // methods that check for button presses
    public void addBackListener(ActionListener listenForBack){
        this.back.addActionListener(listenForBack);
    }

    public void addRenterInfoListener(ActionListener listenForRenterInfo){
        this.renterInfo.addActionListener(listenForRenterInfo);
    }

    public void addLandlordInfoListener(ActionListener listenForRenterInfo){
        this.landlordInfo.addActionListener(listenForRenterInfo);
    }
    public void addPropertyInfoListener(ActionListener listenForRenterInfo){
        this.propertyInfo.addActionListener(listenForRenterInfo);
    }

    // sets current component/frame to appear
    public void turnOn()
    {
        setVisible(true);
    }

    // sets current component/frame to disappear
    public void destroyFrame()
    {
        setVisible(false);
    }


    // methods to populate table with appropriate data for each row and column

    // data organization for properties 
    public String[][] copyProperties(ArrayList<Property> properties){
        String[][] props = new String[properties.size()][15];
        for(int i = 0; i < properties.size(); i++){
            props[i][0] = String.valueOf(properties.get(i).getID());
            props[i][1] = properties.get(i).getAddress();
            props[i][2] = properties.get(i).getQuadarnt();
            props[i][3] = properties.get(i).getType();
            props[i][4] = String.valueOf(properties.get(i).getNumOfBedrooms());
            props[i][5] = String.valueOf(properties.get(i).getNumOfBathrooms());
            props[i][6] = properties.get(i).getFurnished();
            props[i][7] = String.valueOf(properties.get(i).getPropertyFees().getAmount());
            props[i][8] = properties.get(i).getPropertyFees().getFeesPaid();
            props[i][9] = properties.get(i).getPropertyStatus();
            props[i][10] = String.valueOf(properties.get(i).getLandlordID());
            props[i][11] = properties.get(i).getStartDate();
            props[i][12] = properties.get(i).getEndDate();
            props[i][13] = String.valueOf(properties.get(i).getPropertyFees().getFeePeriod());
            props[i][14] = properties.get(i).getRentDate();
        }
        return props;
    }

    // data organization for renters
    public String[][] copyRenters(ArrayList<Renter> rents){
        String[][] renters = new String[rents.size()][15];
        for(int i = 0; i < rents.size(); i++){
            renters[i][0] = rents.get(i).getUsername();
            renters[i][1] = rents.get(i).getFName();
            renters[i][2] = rents.get(i).getLName();
            renters[i][3] = String.valueOf(rents.get(i).getId());
            renters[i][4] = rents.get(i).getUserType();
        }
        return renters;
    }

    // data organization for landlords
    public String[][] copyLandlords(ArrayList<Landlord> lands){
        String[][] landlords = new String[lands.size()][15];
        for(int i = 0; i < lands.size(); i++){
            landlords[i][0] = lands.get(i).getUsername();
            landlords[i][1] = lands.get(i).getFName();
            landlords[i][2] = lands.get(i).getLName();
            landlords[i][3] = String.valueOf(lands.get(i).getId());
            landlords[i][4] = lands.get(i).getUserType();
        }
        return landlords;
    }

}
