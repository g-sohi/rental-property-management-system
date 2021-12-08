package GUI;

import javax.swing.*;
import java.awt.event.*;

public class RenterView extends JFrame {

    // variable declaration
    private static JButton search, select, subscribe;
    private JFrame frame;
    private JButton logout;

    public RenterView() {
        // creation of JFrame of certain size
        frame = new JFrame("Renter Page");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setLayout(null); // layout set to null

        // creation of JButtons
        search = new JButton("Search");
        select = new JButton("Select");
        subscribe = new JButton("Subsribe");
        logout = new JButton("Logout");

        // sets the position and size of JButtons within JFrame
        search.setBounds(100, 100, 100, 40);
        select.setBounds(300, 100, 100, 40);
        subscribe.setBounds(200, 200, 100, 40);
        logout.setBounds(200, 400, 100, 40);

        // adds JButtons to JFrame
        frame.add(search);
        frame.add(select);
        frame.add(subscribe);
        frame.add(logout);

        frame.setVisible(true); // JFrame is set to appear

    }

    public void addLogoutListener(ActionListener listenForLogout){
        logout.addActionListener(listenForLogout);
    }

    public void addSearchListener(ActionListener listenForLogout){
        search.addActionListener(listenForLogout);
    }

    public void addSelectListener(ActionListener listenForLogout){
        select.addActionListener(listenForLogout);
    }

    

    public void destroyFrame()
    {   
        frame.setVisible(false);
    }

    public void turnOn()
    {
        frame.setVisible(true);
    } 

    public JButton getLogout()
    {
        return logout;
    }
    public JButton getSearch()
    {
        return search;
    }

    public JButton getSelect()
    {
        return select;
    }

    // **for testing purposes**

    /* 
    public static void main(String [] args) {
        new RenterView();
    }
    */
}
