package GUI;

import javax.swing.JFrame;
//import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewDataPage extends JFrame {
    private JButton renterInfo, propertyInfo, landlordInfo;
    //private JTextArea area;

    private JTable dataPage;
    private String data[][];
    private String userData[][] = {{"mouss man", "Moussavi", "Moussavi", "7711230", "Manager", "2021-12-09 18-21-23"}};
    private String userColumns[] = {"Username", "First Name", "Last Name", "ID", "User Type", "Last Login"};
    private String propertyData[][] = {{"1", "1055 Kensington Place", "NE", "Townhouse", "1", "1", "No", "100", "Yes", "Active", "1", "2021-12-08", "2021-12-09", "1 Day", "2021-12-09"}};
    private String propertyColumns[] = {"Property ID", "Address", "Quadrant", "Type", "#ofBeds", "#ofBaths", "Furnished", "Fees", "Fees Paid", "Status", "Landlord ID", "Start Date", "End Date", "Fee Period", "Rent Date"};
    private DefaultTableModel model;
    private JScrollPane tableScroll;


    public ViewDataPage()
    {
        setSize(1500, 700);
        setLayout(null);
        setTitle("View Information");
        renterInfo = new JButton("Renter Info");
        propertyInfo = new JButton("Landlord Info");
        landlordInfo = new JButton("Property Info");
        //area = new JTextArea();
        add(renterInfo);
        add(propertyInfo);
        add(landlordInfo);
        //add(area);
     
        renterInfo.setBounds(450,10,150,30);
        propertyInfo.setBounds(675,10,150,30);
        landlordInfo.setBounds(900,10,150,30);
        //area.setBounds(5,50,680,600);

        setVisible(false);
    }

    public void user() {
        //userData, userColumns propertyData, propertyColumns
        // creation of JTable for data page
        model = new DefaultTableModel(data, userColumns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataPage = new JTable(data, userColumns);
        dataPage.setModel(model);
        tableScroll = new JScrollPane(dataPage);
        tableScroll.setBounds(25, 50, 1450, 600);
        add(tableScroll);
        turnOn();
    }

    public void prop() {
        //userData, userColumns propertyData, propertyColumns
        // creation of JTable for data page
        model = new DefaultTableModel(propertyData, propertyColumns) { // sets all cells in table as uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataPage = new JTable(propertyData, propertyColumns);
        dataPage.setModel(model);
        dataPage.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableScroll = new JScrollPane(dataPage);
        tableScroll.setBounds(25, 50, 1450, 600);
        add(tableScroll);
        turnOn();
    }

    public void turnOn()
    {
        setVisible(true);
    }

    public void destroyFrame()
    {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewDataPage().prop();
    }

}
