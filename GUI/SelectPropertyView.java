package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SelectPropertyView extends JFrame {
    
    // variable declaration
    private JFrame frame;
    private JButton select, email, back;
    private JTextArea pDetails;
    private JTextField pID;

    private String type, streetName, city, quadrant;
    private int streetNo, noBeds, noBaths;
    private boolean furnished;

    // constructor - sets up GUI components
    public SelectPropertyView() {

        // creation of JFrame of certain size
        this.frame = new JFrame("Selection Page");
        frame.setSize(500, 500);
        frame.setLayout(null); // layout set to null

        // creation of JLabels of certain size and position
        JLabel pIDLabel = new JLabel("Property ID:");
        pIDLabel.setBounds(50, 25, 100, 40);
        JLabel areaTitle = new JLabel("Property Details:");
        areaTitle.setBounds(50, 125, 100, 40);

        // creation of JButtons of certain size and position
         select = new JButton("Select");
        select.setBounds(200, 75, 100, 20);
         email = new JButton("Contact Landlord");
        email.setBounds(75, 410, 150, 40);
         back = new JButton("Back");
        back.setBounds(275, 410, 150, 40);

        // creation of JTextField and JTextArea of certain size and position
        pID = new JTextField();
        pID.setBounds(140, 35, 310, 20);
        pDetails = new JTextArea();
        pDetails.setBounds(50, 160, 400, 240);
        pDetails.setEditable(false); // pDetails will not be editable

        // addition of components to JFrame
        frame.add(pIDLabel);
        frame.add(areaTitle);
        frame.add(select);
        frame.add(email);
        frame.add(back);
        frame.add(pID);
        frame.add(pDetails);

        // pertains to postion of frame on screen
        frame.setLocationRelativeTo(null);

    }

    // methods for getting components or their values
    public String getPropertyID() {
        return pID.getText();
    }

    public JTextArea getPropertyInfoTextArea() {
        return pDetails;
    }
    
    public JTextField getPropertyIdTextField()
    {
        return pID;
    }

    // methods for setting frame visibility
    public void turnOn()
    {
        frame.setVisible(true);
    }

    public void destroyFrame()
    {
        frame.setVisible(false);
    }

    // more methods for getting components and their values
    public JButton getEmailButton()
    {
        return email;
    }

    public JButton getCloseButton()
    {
        return back;
    }

    public JButton getSelectButton()
    {
        return select;
    }

    public String getPropertyInput()
    {
       return pDetails.getText();
    }

    // methods that allow for the checking of button presses    
    public void addSelectListener(ActionListener listenForLogout){
        select.addActionListener(listenForLogout);
    }

    public void addBackListener(ActionListener listenForLogout){
        back.addActionListener(listenForLogout);
    }

    public void addEmailListener(ActionListener listenForLogout){
        email.addActionListener(listenForLogout);
    }

}


