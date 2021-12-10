package GUI;

import Models.*;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
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
    private JComboBox periodSelect;
    private String periods[] = {"09/21", "10/21", "11/21", "12/21"}; // I guess have periods from the date of first period listing to the current date
    private JTextField numListed, numRented, numActive; // add Curtis's List/Table thing
    private JTable housesRented;
    private String housesRentedData[][] = {{"Han", "1", "1055 Kensington Place"}, {"Jaba", "2", "23 Tatooine Manor"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}, {"Han", "1", "1055 Kensington Place"}}; // temporary; for testing purposes
    private String columns[] = {"Landlord Name", "Property ID", "Address"};
    private DefaultTableModel hrModel;
    private JScrollPane tableScroll;
    private JButton close;

    public SummaryReportView() {
        
        // creation of JFrame of certain size
        frame = new JFrame("Summary Report");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // do we delete this?
        frame.setLayout(null); // layout set to null

        // creation of JLabel and JComboBox for period selection
        period = new JLabel("Period:");
        period.setBounds(50, 25, 100, 40);
        frame.add(period);
        periodSelect = new JComboBox(periods);
        periodSelect.setBounds(175, 35, 275, 20);
        frame.add(periodSelect);

        // creation of JLabels and JTextFields for statistics
        numListedLabel = new JLabel("Number of Houses Listed During Period:");
        numListedLabel.setBounds(50, 75, 250, 40);
        frame.add(numListedLabel);
        numListed = new JTextField();
        numListed.setBounds(325, 85, 125, 20);
        numListed.setEditable(true);
        frame.add(numListed);

        numRentedLabel = new JLabel("Number of Houses Rented During Period:");
        numRentedLabel.setBounds(50, 100, 250, 40);
        frame.add(numRentedLabel);
        numRented = new JTextField();
        numRented.setBounds(325, 110, 125, 20);
        numRented.setEditable(true);
        frame.add(numRented);        

        numActiveLabel = new JLabel("Number of Active Houses During Period:");
        numActiveLabel.setBounds(50, 125, 250, 40);
        frame.add(numActiveLabel);
        numActive = new JTextField();
        numActive.setBounds(325, 135, 125, 20);
        numActive.setEditable(true);
        frame.add(numActive);

        housesRentedLabel = new JLabel("Houses Rented During Period:");
        housesRentedLabel.setBounds(50, 175, 250, 40);
        frame.add(housesRentedLabel);

        // creation of JTable for list of houses rented during selected period
        hrModel = new DefaultTableModel(housesRentedData, columns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        housesRented = new JTable(housesRentedData, columns);
        housesRented.setBounds(50, 210, 400, 175);
        housesRented.setModel(hrModel);
        tableScroll = new JScrollPane(housesRented);
        tableScroll.setBounds(50, 210, 400, 175);
        frame.add(tableScroll);

        // creation of JButton of certain size and position
        close = new JButton("Close");
        close.setBounds(200, 400, 100, 50);
        frame.add(close);

        frame.setVisible(false);

    }
    public void addCloseListener(ActionListener listenForReport){
        System.out.println("DONE");
        this.close.addActionListener(listenForReport);
    }

    public String getPeriodSelection() {
        return periodSelect.getSelectedItem().toString();
    }

    public void setNumListed(String out) {
        numListed.setText(out);
    }

    public void setNumRented(String out) {
        numRented.setText(out);
    }

    public void setNumActive(String out) {
        numActive.setText(out);
    }

    public JButton getCloseButton()
    {
        return close;
    }

    public void turnOn()
    {
        frame.setVisible(true);
    } 

    public void destroyFrame()
    {   
        frame.setVisible(false);
    }

    public void addItemListener(ItemListener listenForItem){
        periodSelect.addItemListener(listenForItem);
    }

    public JComboBox getPeriodSelect(){
        return this.periodSelect;
    }

    public void setTableData(String[][] rentedData){
      hrModel.setRowCount(0);
      for(int i=0; i<rentedData.length; i++)
      {
          hrModel.addRow(rentedData[i]);
      }

    //housesRented = new JTable(rentedData, columns);
        housesRented.revalidate();
    }

    
    /*public static void main(String[] args) {
        new SummaryReportView().turnOn();
    }*/
}
