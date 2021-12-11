package GUI;



import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LandlordView extends JFrame{
    //Private member variables for LandlordView
    private JButton registerProperty, updateProperty, payFee, search, logout; //change UML; registerProperties to registerProperty
    public LandlordView()
    {
        //Set the size of the frame to 500 by 500
        setSize(500, 500);

        //JPanels for Background
        JPanel panel1 = new JPanel();  
        JPanel panel2 = new JPanel();  
        //Header that Displays Landlord Homepage
        JLabel header = new JLabel("Landlord Homepage");
        //Edit the Font and Size of the Header text
        header.setFont(new Font("Lucida Grande", Font.BOLD, 36));

        //Create the GUI components needed for the frame
        registerProperty = new JButton("Register Property");
        updateProperty = new JButton("Update Property");
        payFee = new JButton("Pay Fee");
        search = new JButton("Search");
        logout = new JButton("Logout");

        //Add the GUI components to the frame
        add(header);
        add(registerProperty);
        add(updateProperty);
        add(payFee);
        add(search);
        add(logout);
        add(panel1);
        add(panel2);

        //Set the x and y coordinates of the GUI components
        header.setBounds(55, 20, 400, 50);
        registerProperty.setBounds(60, 90, 370, 50);
        updateProperty.setBounds(60, 150, 370, 50);
        payFee.setBounds(60, 210, 370, 50);
        search.setBounds(60, 270, 370, 50);
        logout.setBounds(60, 330, 370, 50);
        panel1.setBounds(50, 80, 390, 310);     //set the x, y coordinates for the panel as well as the width the height 
        panel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray
        panel2.setBounds(45, 85, 390, 310);     //set the x, y coordinates for the panel as well as the width the height 
        panel2.setBackground(Color.GRAY);       //set the background color to light gray

        setLayout(null);                //Set the frame layout to null
        setLocationRelativeTo(null);    //Set the frame to be set center to users screen
        setVisible(true);               //Set the frame to visible
    }

    //Method to get the JButton for the logout button
    public JButton getLogout()
    {
        return logout;
    }

    //Method to get the JButton for the Register button
    public JButton getRegister(){
        return registerProperty;
    }

    //Method to get the JButton for the Update Property button
    public JButton getUpdate(){
        return updateProperty;
    }

    //Method to get the JButton for the Pay Fee button
    public JButton getPay(){
        return payFee;
    }

    //Method to get the JButton for the Search button
    public JButton getSearch(){
        return search;
    }

    //Method to set the frame of class LandlordView to not be visible
    public void destroyFrame()
    {   
        setVisible(false);
    }

    //Method to set the frame of class LandlordView to be visible
    public void turnOn()
    {
        setVisible(true);
    } 

    //Listener Method to listen for the logout button
    public void addLogoutListener(ActionListener listenForLogout){
        logout.addActionListener(listenForLogout);
    }

    //Listener Method to listen for the Register button
    public void addRegisterPropertyListener(ActionListener listenForRegister){
        registerProperty.addActionListener(listenForRegister);
    }

    //Listener Method to listen for the Update Property button
    public void addUpdatePropertyListener(ActionListener listenForUpdate){
        updateProperty.addActionListener(listenForUpdate);
    }

    //Listener Method to listen for the Pay Fee button
    public void addPayFeeListener(ActionListener listenForPay){
        payFee.addActionListener(listenForPay);
    }

    //Listener Method to listen for the Search button
    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);
    }

    // public static void main(String [] args) {
    //     LandlordView test =  new LandlordView();
    //     test.turnOn();
    // }
}

