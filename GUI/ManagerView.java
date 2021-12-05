package GUI;

import javax.swing.*;

public class ManagerView {
    private JButton generateReport, editFees, updateProperty, viewInformation, search;
    private JFrame f;

    public ManagerView()
    {
        f=  new JFrame("Manager Page");
        f.setSize(500, 500);
        generateReport = new JButton("Generate Report");
        editFees = new JButton("Edit Fees");
        updateProperty = new JButton("Update Status");
        search = new JButton("Search");
        viewInformation = new JButton("View Information");
        f.add(generateReport);
        f.add(editFees);
        f.add(updateProperty);
        f.add(search);
        f.add(viewInformation);
        generateReport.setBounds(30,100,150,30);
        editFees.setBounds(300,100,150,30);
        updateProperty.setBounds(40,170,130,30);
        search.setBounds(330,170,100,30);
        viewInformation.setBounds(180, 220, 150, 30);

        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String [] args)
    {
        new ManagerView();
    }
}