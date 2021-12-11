package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.*;

public class SummaryReportView extends JFrame {
    
    // variable declaration
    private JFrame frame;
    private JLabel period, numListedLabel, numRentedLabel, numActiveLabel, housesRentedLabel;
    private JTextField numListed, numRented, numActive;

    // combo box for managers to select a period for which they want a summary report for
    private JComboBox periodSelect;
    private String periods[] = {"01/21", "02/21", "03/21", "04/21", "05/21", "06/21", "07/21", "08/21","09/21", "10/21", "11/21", "12/21"};
    
    // variables concerning the table to display data
    private JTable housesRented;
    private String housesRentedData[][] = null;
    private String columns[] = {"Landlord Name", "Property ID", "Address"};
    private DefaultTableModel hrModel;
    private JScrollPane tableScroll;

    private JButton close; // button to close frame/view

    // constructor - sets up GUI components
    public SummaryReportView() {
        
        // creation of JFrame of certain size
        frame = new JFrame("Summary Report");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null); // layout set to null

        // creation of JLabel and JComboBox for period selection
        period = new JLabel("Period:");
        period.setBounds(50, 25, 100, 40);
        frame.add(period);

        periodSelect = new JComboBox(periods);
        periodSelect.setSelectedIndex(-1); // sets combo box to not have anything selected upon initial view of page
        periodSelect.setBounds(175, 35, 275, 20);
        frame.add(periodSelect);

        // creation of JLabels and JTextFields for statistics
        // for number of houses listed in a period
        numListedLabel = new JLabel("Number of Houses Listed During Period:");
        numListedLabel.setBounds(50, 75, 250, 40);
        frame.add(numListedLabel);
        numListed = new JTextField();
        numListed.setBounds(325, 85, 125, 20);
        numListed.setEditable(false);
        frame.add(numListed);

        // for number of houses rented in a period
        numRentedLabel = new JLabel("Number of Houses Rented During Period:");
        numRentedLabel.setBounds(50, 100, 250, 40);
        frame.add(numRentedLabel);
        numRented = new JTextField();
        numRented.setBounds(325, 110, 125, 20);
        numRented.setEditable(false);
        frame.add(numRented);        

        // for number of active listings in a period
        numActiveLabel = new JLabel("Number of Active Houses During Period:");
        numActiveLabel.setBounds(50, 125, 250, 40);
        frame.add(numActiveLabel);
        numActive = new JTextField();
        numActive.setBounds(325, 135, 125, 20);
        numActive.setEditable(false);
        frame.add(numActive);

        // label for table
        housesRentedLabel = new JLabel("Houses Rented During Period:");
        housesRentedLabel.setBounds(50, 175, 250, 40);
        frame.add(housesRentedLabel);

        // creation of JTable for list of houses rented during selected period
        hrModel = new DefaultTableModel(housesRentedData, columns) { // model that sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        housesRented = new JTable(housesRentedData, columns); // creates a new JTable using appropriate columns for the selected data
        housesRented.setBounds(50, 210, 400, 175);
        housesRented.setModel(hrModel); // used to apply the uneditable cells status to the whole table
        tableScroll = new JScrollPane(housesRented); // allows for scrolling in the event of large number of entries/rows
        tableScroll.setBounds(50, 210, 400, 175);
        frame.add(tableScroll);

        // creation of JButton of certain size and position
        close = new JButton("Close");
        close.setBounds(200, 400, 100, 50);
        frame.add(close);
        
        frame.setLocationRelativeTo(null); // pertains to positioning of frame on screen
        frame.setVisible(false); // sets frame to not appear for the proper functioning of methods

    }

    // checks if the "Close" button is pressed
    public void addCloseListener(ActionListener listenForReport){
        System.out.println("DONE");
        this.close.addActionListener(listenForReport);
    }

    // methods for getting and setting values of components
    public String getPeriodSelection() {
        return periodSelect.getSelectedItem().toString();
    }

    public JTextField getNumListed() {
        return numListed;
    }

    public void setNumListed(String out) {
        numListed.setText(out);
    }

    public JTextField getNumRented() {
        return numRented;
    }

    public void setNumRented(String out) {
        numRented.setText(out);
    }

    public JTextField getNumActive() {
        return numActive;
    }

    public void setNumActive(String out) {
        numActive.setText(out);
    }

    public JButton getCloseButton()
    {
        return close;
    }

    // method for making frame visible
    public void turnOn()
    {
        frame.setVisible(true);
    } 

    // opposite of turnOn(), and functions to remove the current frame from view
    public void destroyFrame()
    {   
        frame.setVisible(false);
    }

    // checks if the combo box is used
    public void addItemListener(ItemListener listenForItem){
        periodSelect.addItemListener(listenForItem);
    }

    // gets the JComboBox
    public JComboBox getPeriodSelect(){
        return this.periodSelect;
    }

    // method for organizing the appropriate data for the table
    public void setTableData(String[][] rentedData){
      hrModel.setRowCount(0); // removes any existing data
      for(int i=0; i<rentedData.length; i++) // adds data to cells
      {
          hrModel.addRow(rentedData[i]);
      }
        housesRented.revalidate(); // acts to refresh changes
    }

}
