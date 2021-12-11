package GUI;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RenterView extends JFrame {
    // variable declaration
    private static JButton search, select, subscribe;
    private JFrame frame;
    private JButton logout;

    public RenterView() {
        // creation of JFrame of certain size
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // layout set to null
        //JPanels for Background
        JPanel panel1 = new JPanel();  
        JPanel panel2 = new JPanel();  
        //Header that Displays Renter Homepage
        JLabel header = new JLabel("Renter Homepage");
        //Edit the Font and Size of the Header text
        header.setFont(new Font("Lucida Grande", Font.BOLD, 36));

        //Create the GUI components needed for the Frame
        search = new JButton("Search");
        select = new JButton("Select");
        subscribe = new JButton("Subscribe");
        logout = new JButton("Log Out");

        //Add the GUI components to the frame
        add(search);
        add(select);
        add(subscribe);
        add(logout);
        add(header);
        add(panel1);
        add(panel2);

        //Set the x and y coordinates of the GUI components
        header.setBounds(75, 20, 400, 50);
        search.setBounds(60, 90, 370, 50);
        select.setBounds(60, 150, 370, 50);
        subscribe.setBounds(60, 210, 370, 50);
        logout.setBounds(60, 270, 370, 50);
        panel1.setBounds(50, 80, 390, 250);     //set the x, y coordinates for the panel as well as the width the height 
        panel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray
        panel2.setBounds(45, 85, 390, 250);     //set the x, y coordinates for the panel as well as the width the height 
        panel2.setBackground(Color.GRAY);       //set the background color to light gray

        setLocationRelativeTo(null);    //Set the frame to be set center to users screen
        setVisible(true);               //Set the frame to visible
    }

    // checks if "Log Out" button is pressed
    public void addLogoutListener(ActionListener listenForLogout) {
        logout.addActionListener(listenForLogout);
    }

    // checks if "Search" button is pressed
    public void addSearchListener(ActionListener listenForSearch) {
        search.addActionListener(listenForSearch);
    }

    // checks if "Select" button is pressed
    public void addSelectListener(ActionListener listenForSelect) {
        select.addActionListener(listenForSelect);
    }

    // checks if "Subscribe" button is pressed
    public void addSubscribeListener(ActionListener listenForSubscribe) {
        subscribe.addActionListener(listenForSubscribe);
    }

    
    //Method to set the frame of class RenterView to not be visible
    public void destroyFrame()
    {   
        setVisible(false);
    }

    //Method to set the frame of class RenterView to be visible
    public void turnOn()
    {
        setVisible(true);
    } 

    //Method to get the JButton for the Logout button
    public JButton getLogout()
    {
        return logout;
    }

    //Method to get the JButton for the Search button
    public JButton getSearch()
    {
        return search;
    }

    //Method to get the JButton for the Select button
    public JButton getSelect()
    {
        return select;
    }

    //Method to get the JButton for the Subscribe button
    public JButton getSubscribeButton()
    {
        return subscribe;
    }

    // **for testing purposes**

    public static void main(String [] args) {
        RenterView test =  new RenterView();
        test.turnOn();
    }
}
