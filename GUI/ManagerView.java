package GUI;

import javax.swing.*;
import java.awt.event.*;

public class ManagerView extends JFrame{
    private JButton generateReport, editFees, updateProperty, viewInformation, search, logout;
    private JFrame f;

    public ManagerView()
    {
        f=  new JFrame("Manager Page");
        f.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        generateReport = new JButton("Generate Report");
        editFees = new JButton("Edit Fees");
        updateProperty = new JButton("Update Status");
        search = new JButton("Search");
        viewInformation = new JButton("View Information");
        logout = new JButton("Logout");
        f.add(generateReport);
        f.add(editFees);
        f.add(updateProperty);
        f.add(search);
        f.add(viewInformation);
        f.add(logout);
        generateReport.setBounds(30,100,150,30);
        editFees.setBounds(300,100,150,30);
        updateProperty.setBounds(40,170,130,30);
        search.setBounds(330,170,100,30);
        viewInformation.setBounds(180, 220, 150, 30);
        logout.setBounds(180, 300, 150, 30);

        f.setLayout(null);
        f.setVisible(false);
    }

    public JButton getLogout()
    {
        return logout;
    }

    public void addLogoutListener(ActionListener listenForLogout){
        logout.addActionListener(listenForLogout);
    }

    public JFrame getFrame()
    {
        return this.f;
    }

    public void destroyFrame()
    {   
        f.setVisible(false);
    }

    public void turnOn()
    {
        f.setVisible(true);
    }    
}