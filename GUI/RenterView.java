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
        subscribe = new JButton("Subscribe");
        logout = new JButton("Log Out");

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

    // checks if "Log Out" button is pressed
    public void addLogoutListener(ActionListener listenForLogout) {
        logout.addActionListener(listenForLogout);
    }

    // checks if "Search" button is pressed
    public void addSearchListener(ActionListener listenForSearch) {
        search.addActionListener(listenForSearch);
    }

    // checks if "Select" button is pressed
    public void addSelectListener(ActionListener listenForSelect) {
        select.addActionListener(listenForSelect);
    }

    // checks if "Subscribe" button is pressed
    public void addSubscribeListener(ActionListener listenForSubscribe) {
        subscribe.addActionListener(listenForSubscribe);
    }

    
    // causes frame to not be visible
    public void destroyFrame()
    {   
        frame.setVisible(false);
    }

    // sets frame to appear
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

    public JButton getSubscribeButton()
    {
        return subscribe;
    }

    // **for testing purposes**

     
    
}
