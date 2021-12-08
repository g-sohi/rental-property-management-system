
package GUI;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import Models.Property;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

public class SearchView extends JFrame{
    private JComboBox typeBox, quadrantBox, furnished; //change UML; type to typeBox; quadrant to quadrantBox
    private JTextField noBeds, noBaths, streetNo, streetName, city, postalCode, landlordName;
    private JButton register;
    //added in private members
    private JButton search;
    private JButton reset;
    private ButtonGroup group;
    JRadioButton furnishedYesButton;
    JRadioButton furnishedNoButton;
    JComboBox type;
    JComboBox quadrant;

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

        JLabel typeLabel = new JLabel("Type: ");
        String type_dropdown[] = {"", "Detached", "Attached", "Townhouse", "Apartment"};
        type = new JComboBox<>(type_dropdown);

        JLabel furnishedLabel = new JLabel("Furnished: ");
        // Initialization of object of "JRadioButton" class.
        furnishedYesButton = new JRadioButton("Yes");
        furnishedYesButton.setActionCommand("yes");
        furnishedNoButton = new JRadioButton("No");
        furnishedNoButton.setActionCommand("no");

        group = new ButtonGroup();
        group.add(furnishedYesButton);
        group.add(furnishedNoButton);


        JLabel quadrantLabel = new JLabel("Quadrant: ");
        String quadrant_dropdown[] = {"", "NW", "NE", "SW", "SE"};
        quadrant = new JComboBox<>(quadrant_dropdown);

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

        add(furnishedLabel);
        add(furnishedYesButton);
        add(furnishedNoButton);

        add(typeLabel);
        add(type);

        add(quadrantLabel);
        add(quadrant);

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

        furnishedLabel.setBounds(70, 100, 240, 30);
        furnishedYesButton.setBounds(190, 100, 240, 30);
        furnishedNoButton.setBounds(190, 130, 240, 30);

        quadrantLabel.setBounds(70, 160, 240, 30);
        quadrant.setBounds(190, 160, 240, 30);

        typeLabel.setBounds(70, 190, 240, 30);
        type.setBounds(190, 190, 240, 30);

        search.setBounds(370, 260, 80, 30);
        reset.setBounds(300, 260, 80, 30);

        search.setBackground(new Color(99, 182, 255));

        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String [] args)
    {

        SearchView testView = new SearchView();
        while(true)
        {
            testView.getFurnishedInput();
        }
        
    }
    //Getter functions to get the users inputted value from the text fields
    //This method returns the number of beds the user inputted
    public void turnOn()
    {
        setVisible(true);

    }
    public int getBedsInput()
    {
        if(!noBeds.getText().equals(""))
        {
            return Integer.valueOf(noBeds.getText());
        }
        return(-1);
    }

    public void setBedsInput(String value)
    {
        noBeds.setText(value);
    }

    //This method returns the number of baths the user inputted
    public int getBathsInput()
    {
        if(!noBaths.getText().equals(""))
        {
            return Integer.valueOf(noBaths.getText());
        }
        return(-1);
    }

    public void setBathsInput(String value)
    {
        noBaths.setText(value);
    }

    public String getFurnishedInput()
    {
        //System.out.println("button choice selected is: " + group.getSelection().getActionCommand());
        if(group.getSelection() != null)
        {
        if(group.getSelection().getActionCommand() != null)
        {
            String buttonChoice = group.getSelection().getActionCommand();
            return buttonChoice;
        }
    }
        return null;
    }

    public JComboBox getQuadrants()
    {
        return this.quadrant;
    }

    public JComboBox getTypes()
    {
        return this.type;
    }

    public String getQuadrantInput()
    {
        if(!getQuadrants().getSelectedItem().toString().equals(""))
        {
            return getQuadrants().getSelectedItem().toString();
        }
        return null;
    }

    public String getTypeInput()
    {
        if(!getTypes().getSelectedItem().toString().equals(""))
        {
            return getTypes().getSelectedItem().toString();
        }
        return null;
    }

    public ButtonGroup getGroup()
    {
        return this.group;
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

