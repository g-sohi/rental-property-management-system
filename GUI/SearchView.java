
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
    private JButton reset;
    JList propertiesView;

    public SearchView()
    {   
        setSize(500, 500);

        //Make a JPanel for the search boxes
        JPanel searchPanel1 = new JPanel();  
        searchPanel1.setBounds(50, 30, 400, 260);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray

        JPanel searchPanel2 = new JPanel();  
        searchPanel2.setBounds(45, 35, 400, 260);     //set the x, y coordinates for the panel as well as the width the height 
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
        reset = new JButton("Reset");
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
        noBedsLabel.setBounds(70, 40, 240, 30);
        noBeds.setBounds(190, 40, 240, 30);

        noBathsLabel.setBounds(70, 70, 240, 30);
        noBaths.setBounds(190, 70, 240, 30);

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

        search.setBounds(370, 260, 80, 30);
        reset.setBounds(300, 260, 80, 30);

        search.setBackground(new Color(99, 182, 255));

        setLayout(null);
        setVisible(true);
    }

    //Getter functions to get the users inputted value from the text fields
    //This method returns the number of beds the user inputted
    public int getBedsInput()
    {
        return Integer.valueOf(noBeds.getText());
    }

    public void setBedsInput(String value)
    {
        noBeds.setText(value);
    }

    //This method returns the number of baths the user inputted
    public int getBathsInput()
    {
        return Integer.valueOf(noBaths.getText());
    }

    public void setBathsInput(String value)
    {
        noBaths.setText(value);
    }

    //This method returns the Street Number the user inputted
    public String getStreetNoInput()
    {
        return streetNo.getText();
    }

    public void setStreetNoInput(String value)
    {
        streetNo.setText(value);
    }

    //This method returns the Street Name the user inputted
    public String getStreetNameInput()
    {
        return streetName.getText();
    }

    public void setStreetNameInput(String value)
    {
        streetName.setText(value);
    }

    //This method returns the City the user inputted
    public String getCityInput()
    {
        return city.getText();
    }

    public void setCityInput(String value)
    {
        city.setText(value);
    }

    //This method returns the PostalCode the user inputted
    public String getPostalCodeInput()
    {
        return postalCode.getText();
    }

    public void setPostalCodeInput(String value)
    {
        postalCode.setText(value);
    }

    //This methods returns the landlord name the user inputted
    public String getLandlordInput()
    {
        return landlordName.getText();
    }

    public void setLandlordInput(String value)
    {
        landlordName.setText(value);
    }

    public JButton getSearchButton()
    {
        return this.search; 
    }

    public JButton getResetButton()
    {
        return this.reset;
    }

    public void addResetListener(ActionListener listenForReset){
        reset.addActionListener(listenForReset);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/   
    }

    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/   
    }

}

