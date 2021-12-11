package GUI;


import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

public class EditPropertyView extends JFrame{
    //Private member variables for the class
    private JComboBox status;
    private String stat_prop[] = {"Active", "Rented", "Cancelled", "Suspended"};
    private JButton save;
    private JButton remove;
    private JButton back;
    private JTextField idProperty;
    private JLabel rentDate;
    private Container ctr;
	private JTextField idProperty2;
    private JComboBox<String> rentDay;
    private JComboBox<String> rentMonth;
    private JComboBox<String> rentYear;
    private JLabel stat;

    public EditPropertyView()
    {
        //Initialize the GUI componenets that will be used for the frame
        JLabel EditPropertyTitle;
        JLabel id;
        JLabel jLabel1;
        JLabel jLabel3;
        JLabel jLabel4;
        JPanel jPanel1;
        JPanel jPanel3;
        JPanel jPanel5;
        JPanel jPanel6;
        JPanel jPanel7;
        JPanel jPanel8;

        //Create the components for the GUI components
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        idProperty = new javax.swing.JTextField();
        stat = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        EditPropertyTitle = new javax.swing.JLabel();
        rentDate = new javax.swing.JLabel();
        rentDay = new javax.swing.JComboBox<>();
        rentMonth = new javax.swing.JComboBox<>();
        rentYear = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        //Group Layout for Panel6
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)    //Add a gap for the GroupLayout with the max value
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)  //Add a gap for the GroupLayout with the max value  
        );

        //Group Layout for Panel7
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)     //Add a gap for the GroupLayout with the max value  
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)     //Add a gap for the GroupLayout with the max value  
        );
        
        //Will exits the application if the default window is close
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0)); //Set colour to black

        //Set the background colours
        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        //Set the text for the JLabels
        id.setText("Property ID:");
        stat.setText("Status:");

        //Set the Model for the JComboBox status
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Rented", "Canceled", "Suspended" }));

        //Set the font and text for the JButtons
        save.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        save.setText("Save");

        //Set the font and text for the JLabels
        EditPropertyTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        EditPropertyTitle.setText("Edit Property");

        rentDate.setText("Rented Date:");

        //Set the Model for the JComboBox rentDay
        rentDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        //Set the Model for the JComboBox rentMonth
        rentMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        //Set the Model for the JComboBox rentYear
        rentYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" }));

        jLabel3.setText("/");

        jLabel4.setText("/");

        //Set the font and text of the back button
        back.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        back.setText("Back");

        //Set the GroupLayout for jPanel3
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idProperty, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(id)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(stat))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(EditPropertyTitle))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(rentDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rentDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rentMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );  //Set a vertical layout group for the internal componenets to follow
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EditPropertyTitle)
                .addGap(25, 25, 25)
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentDate)
                    .addComponent(rentDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(back))
                .addGap(19, 19, 19))
        );

        //Set the Group Layout for jPanel1
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup( //Set a vertical layout group for the internal componenets to follow
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        //Set the background for JPanel5
        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        //Set the font and text of jLabel1
        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adjust Property");

        //Set the Group Layout for jPanel5
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(//Set a vertical layout group for the internal componenets to follow
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        //Set the background for jPanel5
        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        //Set the GroupLayout for jPanel8
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(//Set a vertical layout group for the internal componenets to follow
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        //Set the GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(//Set a vertical layout group for the internal componenets to follow
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();

        setLocationRelativeTo(null);    //Set the frame to be set center to users screen
        setVisible(true);               //Set the frame to visible
    }

    //Method to set the frame of class EditPropertyView to not be visible
    public void destroyFrame()
    {   
        setVisible(false);
    }

    //Method to set the frame of class EditPropertyView to be visible
    public void turnOn()
    {
        setVisible(true);
    } 

    //Method to get the JButton for the save button
    public JButton getSaveButton()
    {
        return save;
    }

    //Method to get the JButton for the Back button
    public JButton getBackButton()
    {
        return back;
    }

    //Listener for the Save button which hecks if "Subscribe" button is triggered
    public void addSaveListener(ActionListener listenForSave){
        System.out.println("DONE");
        this.save.addActionListener(listenForSave);
    }

    //Listener for the Back button which hecks if "Subscribe" button is triggered
    public void addBackListener(ActionListener listenForBack){
        System.out.println("DONE");
        this.back.addActionListener(listenForBack);
    }

    //Method to get the Status Input
    public String getStatusInput()
    {
        return status.getSelectedItem().toString();
    }

    //Method to get the inputted Property ID
    public int getPropetyIdInput()
    {
        return Integer.valueOf(idProperty.getText());
    }

    //Method to get the inputted Property ID as a string
    public String getPropertyIDStringInput()
    {
        return idProperty.getText();
    }

    //Method to get the inputted Property ID2 for the second JTextField
    public int getPropetyId2Input()
    {
        return Integer.valueOf(idProperty2.getText());
    }

    //Method to get the inputted rentDate
    public String getRentDateInput()
    {
        return rentDate.getText();
    }

    //Method to get the inputted rent Date day
    public String getRentDayInput()
    {
        return rentDay.getSelectedItem().toString();
    }

    //Method to get the inputted rent Date Month
    public String getRentMonthInput()
    {
        return rentMonth.getSelectedItem().toString();
    }

    //Method to get the inputted rent Date year
    public String getRentYearInput()
    {
        return rentYear.getSelectedItem().toString();
    }

    //Method to get a update Message for the user which informs them that the Property is updated
    public void showDialog()
    {
        JOptionPane.showMessageDialog(this,"Property Updated");
    }

    //Method to get a update Message for the user which informs them that they need to fill in all required fields
    public void showErrorDialog()
    {
        JOptionPane.showMessageDialog(this,"Fill All Fields");
    }

    // public static void main(String [] args) {
    //     new EditPropertyView();
    // }
}

//*****IMPORTANT: Correct Class Name from EditPropetyView to EditPropertyView*****