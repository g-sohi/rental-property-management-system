
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
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
    //Private members for Normal Renter/Non-Renter View
    private JComboBox typeBox, quadrantBox, furnished; //change UML; type to typeBox; quadrant to quadrantBox
    private JTextField noBeds, noBaths, streetNo, streetName, city, postalCode, landlordName;
    private JButton register;
    private JButton search;
    private JButton reset;
    private ButtonGroup group;
    private JRadioButton furnishedYesButton;
    private JRadioButton furnishedNoButton;
    private JComboBox type;
    private JComboBox quadrant;
    private JButton backButton;
    private JLabel noBedsLabel, noBathsLabel, typeLabel, furnishedLabel, quadrantLabel;
    private JPanel searchPanel1, searchPanel2, results;

    //Private members for Landlord/Manager Search View
    private JButton displayButton;
    private JButton backButton2;
    private JTable displayTable1;
    private DefaultTableModel displayTable1Model;
    private JTable displayTable2;
    private DefaultTableModel displayTable2Model;
    private JTable displayTable3;
    private DefaultTableModel displayTable3Model;
    private JTable displayTable4;
    private DefaultTableModel displayTable4Model;
    private JLabel LandlordIdLabel;
    private JList<String> addressList;

    //Manager and Landlord frame variable declaration
    private JFrame mgrF, llrdF;
    private JLabel propStatLabel, resultsLabel;
    private String propStats[] = {"Active", "Rented", "Cancelled", "Suspended"};
    private JComboBox propStat;

    public SearchView()
    {   
        setSize(500, 500);  //Set the frame size to 500 by 500 pixels

        //Make a JPanel for the search boxes
        searchPanel1 = new JPanel();  
        searchPanel1.setBounds(50, 30, 400, 260);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray

        searchPanel2 = new JPanel();  
        searchPanel2.setBounds(45, 35, 400, 260);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel2.setBackground(Color.GRAY); //set the background color to light gray

        results = new JPanel();
        results.setBounds(20, 315, 460, 135);     //set the x, y coordinates for the panel as well as the width the height 
        results.setBackground(Color.LIGHT_GRAY);


        //Set up the GUI components of the Search Frame, including textfields, buttons, and panels
        noBedsLabel = new JLabel("Beds: ");
        //JTextfield for the Number of beds Input
        noBeds = new JTextField("Enter number of beds...");

        noBathsLabel = new JLabel("Baths: ");
        //JTextfield for the Number of baths Input
        noBaths = new JTextField("Enter number of baths...");

        typeLabel = new JLabel("Type: ");
        //Dropdown values for the Type
        String type_dropdown[] = {"", "Detached", "Attached", "Townhouse", "Apartment"};
        type = new JComboBox<>(type_dropdown);

        furnishedLabel = new JLabel("Furnished: ");
        // Initialization of JRadioButton for Furnished Input: "Yes" and "No"
        furnishedYesButton = new JRadioButton("Yes");
        furnishedYesButton.setActionCommand("yes");
        furnishedNoButton = new JRadioButton("No");
        furnishedNoButton.setActionCommand("no");

        //Add the JardioButtons for "Yes" and "No" to a Button Group
        group = new ButtonGroup();
        group.add(furnishedYesButton);
        group.add(furnishedNoButton);


        quadrantLabel = new JLabel("Quadrant: ");
        //Quadrant dropdown values
        String quadrant_dropdown[] = {"", "NW", "NE", "SW", "SE"};
        quadrant = new JComboBox<>(quadrant_dropdown);

        //Button ins the frame include, search, display and back
        search = new JButton("Search");
        displayButton = new JButton();
        backButton = new JButton("Back");

        addressList = new JList<>();
        //search.setForeground(Color.BLACK);
        reset = new JButton("Reset");
        //Set the color for the foreground in the back button to grey
        reset.setForeground(Color.GRAY);


        //Add all the GUI components created above to the JFrame which is the object itself
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
        add(backButton);

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
        backButton.setBounds(5, 5, 100, 20);

        //Change the background colour of the search button to the RGB code below
        search.setBackground(new Color(99, 182, 255));

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(false);  //Set frame to not be visible
    }
    
    //Method for displaying the Manager SearchView frame
    public void mgr() {    
        //Initialize the components for the JFrame 
        JPanel jPanel1;
        JPanel jPanel2;
        JScrollPane jScrollPane2;
        JScrollPane jScrollPane3;
        JScrollPane jScrollPane5;
        JScrollPane jScrollPane6;
        JScrollPane jScrollPane7;
        JLabel ManagerLabel;
        JLabel ManagerPropertiesTitle;
        JScrollPane PropertiesList;
        
        setVisible(false); // existing frame no longer visible

        // JFrame creation of certain size for Manager User Type
        mgrF = new JFrame("Manager Search Page"); 
        mgrF.setSize(530,600);  //Set the JFrame size to 530 by 600 pixels
        //mgrF.setLayout(null);

        //Create new components for the JFrame
        jScrollPane2 = new JScrollPane();
        jPanel1 = new JPanel();
        PropertiesList = new JScrollPane();
        addressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        displayTable1 = new JTable();
        jScrollPane5 = new JScrollPane();
        displayTable2 = new JTable();
        jScrollPane6 = new JScrollPane();
        displayTable3 = new JTable();
        jScrollPane7 = new JScrollPane();
        displayTable4 = new JTable();
        ManagerPropertiesTitle = new JLabel();
        ManagerLabel = new JLabel();
        LandlordIdLabel = new JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        addressList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        PropertiesList.setViewportView(addressList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PropertiesList, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PropertiesList, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        ManagerPropertiesTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        ManagerPropertiesTitle.setText("Manager Properties View");

        displayButton.setText("Display Properties");
        backButton.setText("Back");

        ManagerLabel.setText("Manager");

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        displayTable1Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
            },
            new String [] {
                "Property ID", "Address", "Quadrant"    //Header for JTable1
            }
        );
        displayTable1.setModel(displayTable1Model);
        displayTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane3.setViewportView(displayTable1); //Set the displayTable1Model to displayTable1's model


        displayTable2Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
            },
            new String [] {
                "Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"    //Header for JTable2
            }
        );
        displayTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable2.setModel(displayTable2Model); //Set the displayTable2Model to displayTable2's model

        displayTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable2.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable2.setShowGrid(true);
        jScrollPane5.setViewportView(displayTable2);

        displayTable3Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fees", "Fees Paid", "Status"   //Header for JTable3
            }
        );
        displayTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable3.setModel(displayTable3Model); //Set the displayTable3Model to displayTable3's model

        displayTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable3.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable3.setShowGrid(true);
        jScrollPane6.setViewportView(displayTable3);

        displayTable4Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Registration Date", "Listing End Date", "Start Rent Date"  //Header for JTable4
            }
        );
        displayTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable4.setModel(displayTable4Model); //Set the displayTable4Model to displayTable4's model
        displayTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable4.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable4.setShowGrid(true);
        jScrollPane7.setViewportView(displayTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mgrFLayout = new javax.swing.GroupLayout(mgrF.getContentPane());
        mgrF.getContentPane().setLayout(mgrFLayout);
        mgrFLayout.setHorizontalGroup(
            mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mgrFLayout.createSequentialGroup()
                .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(ManagerPropertiesTitle))
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mgrFLayout.createSequentialGroup()
                                .addComponent(ManagerLabel)
                                .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mgrFLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(displayButton)
                                        .addGap(125, 125, 125)
                                        .addComponent(backButton)
                                        .addGap(125, 125, 125))
                                    .addGroup(mgrFLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LandlordIdLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        mgrFLayout.setVerticalGroup(
            mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mgrFLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ManagerPropertiesTitle)
                .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayButton)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ManagerLabel)
                            .addComponent(LandlordIdLabel))
                        .addGap(3, 3, 3)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
        mgrF.setLocationRelativeTo(null);
        mgrF.setVisible(false); // Manager frame set to appear

    }

    // Method for showing search view for landlords
    public void llrd() {
        //Initialize the components for the JFrame 
        JPanel jPanel1;
        JPanel jPanel2;
        JScrollPane jScrollPane2;
        JScrollPane jScrollPane3;
        JScrollPane jScrollPane5;
        JScrollPane jScrollPane6;
        JScrollPane jScrollPane7;
        JLabel LandlordLabel;
        JLabel LandlordPropertiesTitle;
        JScrollPane LandlordPropertyList;

        setVisible(false); // existing frame no longer visible
        llrdF = new JFrame("Landlord Frame");
        llrdF.setSize(530,600);
        //llrdF.setLayout(null);
        
        //Create new components for the JFrame
        jScrollPane2 = new JScrollPane();
        jPanel1 = new JPanel();
        LandlordPropertyList = new JScrollPane();
        addressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        displayTable1 = new JTable();
        jScrollPane5 = new JScrollPane();
        displayTable2 = new JTable();
        jScrollPane6 = new JScrollPane();
        displayTable3 = new JTable();
        jScrollPane7 = new JScrollPane();
        displayTable4 = new JTable();
        LandlordPropertiesTitle = new JLabel();
        LandlordLabel = new JLabel();
        LandlordIdLabel = new JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        addressList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LandlordPropertyList.setViewportView(addressList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LandlordPropertyList, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LandlordPropertyList, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        LandlordPropertiesTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        LandlordPropertiesTitle.setText("LandLord Properties View");

        displayButton.setText("Display My Properties");
        backButton.setText("Back");

        LandlordLabel.setText("Landlord ID:");

        LandlordIdLabel.setText("#");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        displayTable1Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
            },
            new String [] {
                "Property ID", "Address", "Quadrant"    //  Header for the JTable1
            }
        );
        displayTable1.setModel(displayTable1Model);
        displayTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane3.setViewportView(displayTable1); //Set the displayTable1Model to displayTable1's model


        displayTable2Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
            },
            new String [] {
                "Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"    //Header for the JTable2
            }
        );
        displayTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable2.setModel(displayTable2Model); //Set the displayTable2Model to displayTable2's model

        displayTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable2.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable2.setShowGrid(true);
        jScrollPane5.setViewportView(displayTable2);

        displayTable3Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fees", "Fees Paid", "Status"   //Header for the JTable3
            }
        );
        displayTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable3.setModel(displayTable3Model); //Set the displayTable3Model to displayTable3's model

        displayTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable3.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable3.setShowGrid(true);
        jScrollPane6.setViewportView(displayTable3);

        displayTable4Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Registration Date", "Listing End Date", "Start Rent Date"  //Header for JTable4
            }
        );
        displayTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayTable4.setModel(displayTable4Model);
        displayTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        displayTable4.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        displayTable4.setShowGrid(true);
        jScrollPane7.setViewportView(displayTable4);    //Set the displayTable4Model to displayTable4's model

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout llrdFLayout = new javax.swing.GroupLayout(llrdF.getContentPane());
        llrdF.getContentPane().setLayout(llrdFLayout);
        llrdFLayout.setHorizontalGroup(
            llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(llrdFLayout.createSequentialGroup()
                .addGroup(llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(llrdFLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(LandlordPropertiesTitle))
                    .addGroup(llrdFLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, llrdFLayout.createSequentialGroup()
                                .addComponent(LandlordLabel)
                                .addGroup(llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(llrdFLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(displayButton)
                                        .addGap(125, 125, 125)
                                        .addComponent(backButton)
                                        .addGap(125, 125, 125))
                                    .addGroup(llrdFLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LandlordIdLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        llrdFLayout.setVerticalGroup(
            llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(llrdFLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LandlordPropertiesTitle)
                .addGroup(llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(llrdFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayButton)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(llrdFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(llrdFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LandlordLabel)
                            .addComponent(LandlordIdLabel))
                        .addGap(3, 3, 3)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
        llrdF.setLocationRelativeTo(null);
        llrdF.setVisible(false); // Landlord frame set to appear

    }

    //Method to make the Renter/Non-renter SearchView frame visible
    public void turnOn()
    {
        setVisible(true);

    }

    //Method to make the Manager SearchView frame visible
    public void turnOnForManager(){
        mgr();
        mgrF.setVisible(true);
    }

    //Method to make the Landlord SearchView frame visible
    public void turnOnForLandlord(){
        llrd();
        llrdF.setVisible(true);
    }

    //Method to get the users inputted value for the Number of Beds they would like in the JTextField
    public int getBedsInput()
    {
        if(!noBeds.getText().equals(""))
        {
            return Integer.valueOf(noBeds.getText());
        }
        return(-1);
    }

    //Method to set the text in the JTextField for the Number of Beds
    public void setBedsInput(String value)
    {
        noBeds.setText(value);
    }

    //Method to get the users inputted value for the Number of Baths they would like in the JTextField
    public int getBathsInput()
    {
        if(!noBaths.getText().equals(""))
        {
            return Integer.valueOf(noBaths.getText());
        }
        return(-1);
    }

    //Method to set the text in the JTextField for the Number of Baths
    public void setBathsInput(String value)
    {
        noBaths.setText(value);
    }

    //Method to get the users selection between "Yes" and "No" for Furnished RadioButtons
    public String getFurnishedInput()
    {
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

    //Method to get the JComboBox used for Quadrants [NW, NE, SW, SE]
    public JComboBox getQuadrants()
    {
        return this.quadrant;
    }

    //Method to get the JComboBox used for Types
    public JComboBox getTypes()
    {
        return this.type;
    }

    //Method to get the selection (String) that the user made from the Quadrants dropdown
    public String getQuadrantInput()
    {
        if(!getQuadrants().getSelectedItem().toString().equals(""))
        {
            return getQuadrants().getSelectedItem().toString();
        }
        return null;
    }

    //Method to get the selection (String) that the user made from the Quadrants dropdown
    public String getTypeInput()
    {
        if(!getTypes().getSelectedItem().toString().equals(""))
        {
            return getTypes().getSelectedItem().toString();
        }
        return null;
    }

    //Method to get the ButtonGroup of the JRadioButtons for Furnished ["Yes", "No"]
    public ButtonGroup getGroup()
    {
        return this.group;
    }

    //Method to get the JButton for Search button
    public JButton getSearchButton()
    {
        return this.search; 
    }

    //Method to get the JButton for the Back button
    public JButton getBackButton()
    {
        return backButton;
    }

    //Method to get the JButton for the Reset Button
    public JButton getResetButton()
    {
        return this.reset;
    }

    //Method to get the JButton for the Display Button
    public JButton getDisplayButton()
    {
        return this.displayButton;
    }

    //Method to get the JList used for displaying the addresses
    public JList getAddressList()
    {
        return this.addressList;
    }

    //Method to get the user input of the Property Type ["Active", "Rented", "Cancelled", "Suspended"] as a String
    public String getPropStat() 
    {
        return propStat.getSelectedItem().toString();
    }

    //Method to get the JTable with headers ["Property ID", "Address", "Quadrant"]
    public JTable getJTable1()
    {
        return this.displayTable1;
    }

    //Method to get the JTable with headers ["Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"]
    public JTable getJTable2()
    {
        return this.displayTable2;
    }

    //Method to get the JTable with headers ["Fees", "Fees Paid", "Status"]
    public JTable getJTable3()
    {
        return this.displayTable3;
    }

    //Method to get the JTable with headers ["Registration Date", "Listing End Date", "Start Rent Date"]
    public JTable getJTable4()
    {
        return this.displayTable4;
    }

    //Method to get the Table Model with the JTable with headers ["Property ID", "Address", "Quadrant"]
    public DefaultTableModel getJTableModel1()
    {
        return this.displayTable1Model;
    }

    //Method to get the Table Model with the JTable with headers ["Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"]
    public DefaultTableModel getJTableModel2() 
    {
        return this.displayTable2Model;
    }

    //Method to get the Table Model with the JTable with headers ["Fees", "Fees Paid", "Status"]
    public DefaultTableModel getJTableModel3()
    {
        return this.displayTable3Model;
    }

    //Method to get the Table Model with the JTable with headers ["Registration Date", "Listing End Date", "Start Rent Date"]
    public DefaultTableModel getJTableModel4()
    {
        return this.displayTable4Model;
    }

    //Method to get the JLabel for the Landlord ID label
    public JLabel getLandlordIdLabel()
    {
        return this.LandlordIdLabel;
    }

    //Listerner Method for the back button
    public void addBackButtonListener(ActionListener listenForBackButton){
        backButton.addActionListener(listenForBackButton);  
    }

    //Listerner Method for the reset button
    public void addResetListener(ActionListener listenForReset){
        reset.addActionListener(listenForReset);  
    }

    //Listerner Method for the search button
    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);  
    }

    //Listerner Method for the display button
    public void addDisplayListener(ActionListener listenForDisplay){
        displayButton.addActionListener(listenForDisplay);  
    }

    //Listerner Method for the select button
    public void addSelectListener(ListSelectionListener listenForSelection)
    {
        addressList.addListSelectionListener(listenForSelection);
    }

    //Method to make the Renter SearchView frame not visible
    public void destroyFrameRenterGuest()
    {
        setVisible(false);
    }

    //Method to make the Manager SearchView frame not visible
    public void destroyFrameForManager()
    {
        mgrF.setVisible(false);
    }

    //Method to make the Landlord SearchView frame not visible
    public void destroyFrameForLandLord()
    {
        llrdF.setVisible(false);
    }

    // public static void main(String [] args) {
    //     SearchView test =  new SearchView();
    //     test.turnOn();
    // }
}

