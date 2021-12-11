package GUI;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;


public class ManagerView extends JFrame{
    private JButton generateReport, editFees, updateProperty, viewInformation, search, logout;

    public ManagerView()
    {
        setSize(500, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JPanels for Background
        JPanel panel1 = new JPanel();  
        JPanel panel2 = new JPanel();  
        //Header that Displays Manager Homepage
        JLabel header = new JLabel("Manager Homepage");
        //Edit the Font and Size of the Header text
        header.setFont(new Font("Lucida Grande", Font.BOLD, 36));

        //Create the GUI components needed for the Frame
        generateReport = new JButton("Generate Report");
        editFees = new JButton("Edit Fees");
        updateProperty = new JButton("Update Status");
        search = new JButton("Search");
        viewInformation = new JButton("View Information");
        logout = new JButton("Logout");

        //Add the GUI components to the frame
        add(generateReport);
        add(editFees);
        add(updateProperty);
        add(search);
        add(viewInformation);
        add(logout);
        add(header);
        add(panel1);
        add(panel2);

        //Set the x and y coordinates of the GUI components
        header.setBounds(57, 20, 400, 50);
        generateReport.setBounds(60, 90, 370, 50);
        editFees.setBounds(60, 150, 370, 50);
        updateProperty.setBounds(60, 210, 370, 50);
        search.setBounds(60, 270, 370, 50);
        viewInformation.setBounds(60, 330, 370, 50);
        logout.setBounds(60, 390, 370, 50);
        panel1.setBounds(50, 80, 390, 370);     //set the x, y coordinates for the panel as well as the width the height 
        panel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray
        panel2.setBounds(45, 85, 390, 370);     //set the x, y coordinates for the panel as well as the width the height 
        panel2.setBackground(Color.GRAY);       //set the background color to light gray

        setLayout(null);                //Set the frame layout to null
        setLocationRelativeTo(null);    //Set the frame to be set center to users screen
        setVisible(true);               //Set the frame to visible
    }

    //Method to get the JButton for the logout button
    public JButton getLogout()
    {
        return this.logout;
    }

    //Listener Method to listen for the logout button
    public void addLogoutListener(ActionListener listenForLogout){
        this.logout.addActionListener(listenForLogout);
    }

    //Listener Method to listen for the Search button
    public void addSearchListener(ActionListener listenForSearch){
        //Listener Method to listen for the logout button
        this.search.addActionListener(listenForSearch);
    }

    //Listener Method to listen for the Update button
    public void addUpdateListener(ActionListener listenForUpdate){
        this.updateProperty.addActionListener(listenForUpdate);
    }

    //Listener Method to listen for the Report button
    public void addReportListener(ActionListener listenForReport){
        this.generateReport.addActionListener(listenForReport);
    }

    //Listener Method to listen for the Edit Fees button
    public void addFeesListener(ActionListener listenForReport){
        this.editFees.addActionListener(listenForReport);
    }

    //Listener Method to listen for the View button
    public void addViewListener(ActionListener listenForView){
        this.viewInformation.addActionListener(listenForView);
    }

    //Method to get the JButton for the Search button
    public JButton getSearch()
    { 
        return this.search;
    }

    //Method to get the JButton for the Update button
    public JButton getUpdateButton()
    {
        return this.updateProperty;
    }

    //Method to get the JButton for the Report button
    public JButton getReportButton()
    {
        return this.generateReport;
    }

    //Method to get the JButton for the Edit Fee button
    public JButton getEditFeeButton()
    {
        return this.editFees;
    }

    //Method to get the JButton for the View Data button
    public JButton getViewDataButton()
    {
        return this.viewInformation;
    }

    //Method to get the JFrame of the class
    public JFrame getFrame()
    {
        return this;
    }

    //Method to set the frame of class ManagerView to not be visible
    public void destroyFrame()
    {   
        setVisible(false);
    }

    //Method to set the frame of class ManagerView to be visible
    public void turnOn()
    {
        setVisible(true);
    }    

    // public static void main(String [] args) {
    //     ManagerView test =  new ManagerView();
    //     test.turnOn();
    // }
}