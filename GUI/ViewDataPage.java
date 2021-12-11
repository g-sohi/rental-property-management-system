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
    private JButton renterInfo, propertyInfo, landlordInfo, back;
    //private JTextArea area;

    private JTable dataPage;
    private String data[][];
    private String userData[][] = {{"mouss man", "Moussavi", "Moussavi", "7711230", "Manager"},
    {"mouss man", "Moussavi", "Moussavi", "7711230", "Manager", "2021-12-09 18-21-23"}};
    private String userColumns[] = {"Username", "First Name", "Last Name", "ID", "User Type"};
    private String propertyData[][] = {{"1", "1055 Kensington Place", "NE", "Townhouse", "1", "1", "No", "100", "Yes", "Active", "1", "2021-12-08", "2021-12-09", "1 Day", "2021-12-09"}};
    private String propertyColumns[] = {"Property ID", "Address", "Quadrant", "Type", "#ofBeds", "#ofBaths", "Furnished", "Fees", "Fees Paid", "Status", "Landlord ID", "Start Date", "End Date", "Fee Period", "Rent Date"};
    private DefaultTableModel model;
    private JScrollPane tableScroll;


    public ViewDataPage()
    {
        setSize(1500, 700);
        setLayout(null);
        setTitle("View Information");
        renterInfo = new JButton("Renter Info");
        propertyInfo = new JButton("Property Info");
        landlordInfo = new JButton("LandLord Info");
        back = new JButton("Back");
        //area = new JTextArea();
        add(renterInfo);
        add(propertyInfo);
        add(landlordInfo);
        add(back);
        //add(area);
     
        renterInfo.setBounds(450,10,150,30);
        propertyInfo.setBounds(675,10,150,30);
        landlordInfo.setBounds(900,10,150,30);
        back.setBounds(40, 10, 80, 30);
        //area.setBounds(5,50,680,600);
        setLocationRelativeTo(null);

        setVisible(false);
    }

    public void user(String[][] users) {
        //userData, userColumns propertyData, propertyColumns
        // creation of JTable for data page
        model = new DefaultTableModel(users, userColumns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataPage = new JTable(users, userColumns);
        dataPage.setModel(model);
        tableScroll = new JScrollPane(dataPage);
        tableScroll.setBounds(25, 50, 1450, 600);
        add(tableScroll);
        turnOn();
    }

    public void prop(String[][] properties) {
        //userData, userColumns propertyData, propertyColumns
        // creation of JTable for data page
        model = new DefaultTableModel(properties, propertyColumns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataPage = new JTable(properties, propertyColumns);
        dataPage.setModel(model);
        dataPage.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableScroll = new JScrollPane(dataPage);
        tableScroll.setBounds(25, 50, 1450, 600);
        add(tableScroll);
        turnOn();
    }
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

    public void addBackListener(ActionListener listenForBack){
        System.out.println("DONE1");
        this.back.addActionListener(listenForBack);
    }

    public void addRenterInfoListener(ActionListener listenForRenterInfo){
        System.out.println("DONE1");
        this.renterInfo.addActionListener(listenForRenterInfo);
    }

    public void addLandlordInfoListener(ActionListener listenForRenterInfo){
        System.out.println("DONE1");
        this.landlordInfo.addActionListener(listenForRenterInfo);
    }
    public void addPropertyInfoListener(ActionListener listenForRenterInfo){
        System.out.println("DONE1");
        this.propertyInfo.addActionListener(listenForRenterInfo);
    }


    public void turnOn()
    {
        setVisible(true);
    }

    public void destroyFrame()
    {
        setVisible(false);
    }

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

    /*public static void main(String[] args) {
        //new ViewDataPage().prop();
    }*/

}
