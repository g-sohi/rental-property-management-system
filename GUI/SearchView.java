
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
    //Private members for Normal View
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

    //Private members for Landlord/Manager Search View
    private JButton displayButton;
    private JButton backButton2;
    private JTable DisplayTable1;
    private DefaultTableModel displayTable1Model;
    private JTable DisplayTable2;
    private DefaultTableModel displayTable2Model;
    private JTable DisplayTable3;
    private DefaultTableModel displayTable3Model;
    private JTable DisplayTable4;
    private DefaultTableModel displayTable4Model;
    private JLabel LandlordIdLabel;
    private JLabel LandlordLabel;
    private JLabel LandlordPropertiesTitle;
    private JScrollPane LandlordPropertyList;
    private JList<String> jList2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JTable jTable1;

    // added here for external use from constructor
    private JLabel noBedsLabel, noBathsLabel, typeLabel, furnishedLabel, quadrantLabel;
    private JPanel searchPanel1, searchPanel2, results;

    // mgrF variable declaration
    private JFrame mgrF, llrdF;
    private JLabel propStatLabel, resultsLabel;
    private String propStats[] = {"Active", "Rented", "Cancelled", "Suspended"};
    private JComboBox propStat;

    public SearchView()
    {   
        setSize(500, 500);

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

        //propertiesView = new JList();

        //Set up the GUI components of the Search Frame, including textfields, buttons, and panels
        noBedsLabel = new JLabel("Beds: ");
        noBeds = new JTextField("Enter number of beds...");

        noBathsLabel = new JLabel("Baths: ");
        noBaths = new JTextField("Enter number of baths...");

        typeLabel = new JLabel("Type: ");
        String type_dropdown[] = {"", "Detached", "Attached", "Townhouse", "Apartment"};
        type = new JComboBox<>(type_dropdown);

        furnishedLabel = new JLabel("Furnished: ");
        // Initialization of object of "JRadioButton" class.
        furnishedYesButton = new JRadioButton("Yes");
        furnishedYesButton.setActionCommand("yes");
        furnishedNoButton = new JRadioButton("No");
        furnishedNoButton.setActionCommand("no");

        group = new ButtonGroup();
        group.add(furnishedYesButton);
        group.add(furnishedNoButton);


        quadrantLabel = new JLabel("Quadrant: ");
        String quadrant_dropdown[] = {"", "NW", "NE", "SW", "SE"};
        quadrant = new JComboBox<>(quadrant_dropdown);

        search = new JButton("Search");
        displayButton = new JButton();
        jList2 = new JList<>();
        //search.setForeground(Color.BLACK);
        reset = new JButton("Reset");
        reset.setForeground(Color.GRAY);

        backButton = new JButton("Back");

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
        backButton.setBounds(5, 5, 60, 20);

        search.setBackground(new Color(99, 182, 255));

        setLayout(null);
        setVisible(false);
    }
    
    // function for showing the search view for managers
    public void mgr() {
        // mgr() before using a new JFrame:
        // remove(noBedsLabel); remove(noBeds);
        // remove(noBathsLabel); remove(noBaths);
        // remove(furnishedLabel); remove(furnishedYesButton); remove(furnishedNoButton);
        // remove(typeLabel); remove(type);
        // remove(quadrantLabel); remove(quadrant);
        // remove(searchPanel1); remove(searchPanel2); // panels were blocking components being added.  did not know how to bring it backwards.
        
        setVisible(false); // existing frame no longer visible

        // JFrame creation of certain size for Manager User Type
        mgrF = new JFrame("Manager Search Page"); 
        mgrF.setSize(530,600);
        //mgrF.setLayout(null);
        
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jPanel1 = new JPanel();
        LandlordPropertyList = new JScrollPane();
        jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        DisplayTable1 = new JTable();
        jScrollPane5 = new JScrollPane();
        DisplayTable2 = new JTable();
        jScrollPane6 = new JScrollPane();
        DisplayTable3 = new JTable();
        jScrollPane7 = new JScrollPane();
        DisplayTable4 = new JTable();
        LandlordPropertiesTitle = new JLabel();
        LandlordLabel = new JLabel();
        LandlordIdLabel = new JLabel();


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LandlordPropertyList.setViewportView(jList2);

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
        LandlordPropertiesTitle.setText("Manager Properties View");

        displayButton.setText("Display Properties");
        backButton.setText("Back");

        LandlordLabel.setText("Manager");

        //LandlordIdLabel.setText("#");

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        displayTable1Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
            },
            new String [] {
                "Property ID", "Address", "Quadrant"
            }
        );
        DisplayTable1.setModel(displayTable1Model);
        DisplayTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane3.setViewportView(DisplayTable1);


        displayTable2Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
            },
            new String [] {
                "Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"
            }
        );
        DisplayTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable2.setModel(displayTable2Model);

        DisplayTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable2.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable2.setShowGrid(true);
        jScrollPane5.setViewportView(DisplayTable2);

        displayTable3Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fees", "Fees Paid", "Status"
            }
        );
        DisplayTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable3.setModel(displayTable3Model);

        DisplayTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable3.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable3.setShowGrid(true);
        jScrollPane6.setViewportView(DisplayTable3);

        displayTable4Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Registration Date", "Listing End Date", "Start Rent Date"
            }
        );
        DisplayTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable4.setModel(displayTable4Model);
        DisplayTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable4.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable4.setShowGrid(true);
        jScrollPane7.setViewportView(DisplayTable4);

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
                        .addComponent(LandlordPropertiesTitle))
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mgrFLayout.createSequentialGroup()
                                .addComponent(LandlordLabel)
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
                .addComponent(LandlordPropertiesTitle)
                .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayButton)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(mgrFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mgrFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        mgrF.setVisible(false); // Manager frame set to appear

    }

    // function for showing search view for landlords
    public void llrd() {
    
        setVisible(false); // existing frame no longer visible
        llrdF = new JFrame("Landlord Frame");
        llrdF.setSize(530,600);
        //llrdF.setLayout(null);
        
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jPanel1 = new JPanel();
        LandlordPropertyList = new JScrollPane();
        jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        DisplayTable1 = new JTable();
        jScrollPane5 = new JScrollPane();
        DisplayTable2 = new JTable();
        jScrollPane6 = new JScrollPane();
        DisplayTable3 = new JTable();
        jScrollPane7 = new JScrollPane();
        DisplayTable4 = new JTable();
        LandlordPropertiesTitle = new JLabel();
        LandlordLabel = new JLabel();
        LandlordIdLabel = new JLabel();


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LandlordPropertyList.setViewportView(jList2);

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
                "Property ID", "Address", "Quadrant"
            }
        );
        DisplayTable1.setModel(displayTable1Model);
        DisplayTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane3.setViewportView(DisplayTable1);


        displayTable2Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
            },
            new String [] {
                "Type", "Number of Bedrooms", "Number of Bathrooms", "Furnished"
            }
        );
        DisplayTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable2.setModel(displayTable2Model);

        DisplayTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable2.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable2.setShowGrid(true);
        jScrollPane5.setViewportView(DisplayTable2);

        displayTable3Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fees", "Fees Paid", "Status"
            }
        );
        DisplayTable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable3.setModel(displayTable3Model);

        DisplayTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable3.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable3.setShowGrid(true);
        jScrollPane6.setViewportView(DisplayTable3);

        displayTable4Model = new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Registration Date", "Listing End Date", "Start Rent Date"
            }
        );
        DisplayTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DisplayTable4.setModel(displayTable4Model);
        DisplayTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DisplayTable4.setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        DisplayTable4.setShowGrid(true);
        jScrollPane7.setViewportView(DisplayTable4);

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

        llrdF.setVisible(false); // Landlord frame set to appear

    }

    //Getter functions to get the users inputted value from the text fields
    //This method returns the number of beds the user inputted
    public void turnOn()
    {
        setVisible(true);

    }

    public void turnOnForManager(){
        mgr();
        mgrF.setVisible(true);
    }

    public void turnOnForLandlord(){
        llrd();
        llrdF.setVisible(true);
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

    public JButton getBackButton()
    {
        return backButton;
    }
    public JButton getResetButton()
    {
        return this.reset;
    }

    public JButton getDisplayButton()
    {
        return this.displayButton;
    }

    public JList getJList2()
    {
        return this.jList2;
    }

    public String getPropStat() {
        return propStat.getSelectedItem().toString();
    }

    public JTable getJTable1()
    {
        return this.DisplayTable1;
    }

    public JTable getJTable2()
    {
        return this.DisplayTable2;
    }
    public JTable getJTable3()
    {
        return this.DisplayTable3;
    }
    public JTable getJTable4()
    {
        return this.DisplayTable4;
    }

    public DefaultTableModel getJTableModel1()
    {
        return this.displayTable1Model;
    }

    public DefaultTableModel getJTableModel2()
    {
        return this.displayTable2Model;
    }
    public DefaultTableModel getJTableModel3()
    {
        return this.displayTable3Model;
    }
    public DefaultTableModel getJTableModel4()
    {
        return this.displayTable4Model;
    }

    public JLabel getLandlordIdLabel()
    {
        return this.LandlordIdLabel;
    }
    public void addBackButtonListener(ActionListener listenForBackButton){
        backButton.addActionListener(listenForBackButton);  
    }

    public void addResetListener(ActionListener listenForReset){
        reset.addActionListener(listenForReset);  
    }

    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);  
    }

    public void addDisplayListener(ActionListener listenForDisplay){
        displayButton.addActionListener(listenForDisplay);  
        System.out.println("Added display listener");
    }

    public void addSelectListener(ListSelectionListener listenForSelection)
    {
        jList2.addListSelectionListener(listenForSelection);
    }

    public void destroyFrameRenterGuest()
    {
        setVisible(false);
    }
    public static void main(String [] args) {
        SearchView test =  new SearchView();
        test.turnOn();;
        test.turnOnForLandlord();
    }
    
}

