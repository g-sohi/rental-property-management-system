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
        f.setLocationRelativeTo(null);
        f.setVisible(false);
    }

    public JButton getLogout()
    {
        return this.logout;
    }

    public void addLogoutListener(ActionListener listenForLogout){
        System.out.println("DONE1");
        this.logout.addActionListener(listenForLogout);
    }

    public void addSearchListener(ActionListener listenForSearch){
        System.out.println("DONE");
        this.search.addActionListener(listenForSearch);
    }

    public void addUpdateListener(ActionListener listenForUpdate){
        System.out.println("DONE");
        this.updateProperty.addActionListener(listenForUpdate);
    }

    public void addReportListener(ActionListener listenForReport){
        System.out.println("DONE");
        this.generateReport.addActionListener(listenForReport);
    }

    public void addFeesListener(ActionListener listenForReport){
        System.out.println("DONE");
        this.editFees.addActionListener(listenForReport);
    }

    public void addViewListener(ActionListener listenForView){
        System.out.println("DONE");
        this.viewInformation.addActionListener(listenForView);
    }


    public JButton getSearch()
    {
        return this.search;
    }

    public JButton getUpdateButton()
    {
        return this.updateProperty;
    }

    public JButton getReportButton()
    {
        return this.generateReport;
    }

    public JButton getEditFeeButton()
    {
        return this.editFees;
    }

    public JButton getViewDataButton()
    {
        return this.viewInformation;
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