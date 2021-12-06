package GUI;

import javax.swing.*;
import java.awt.event.*;

public class RenterView extends JFrame implements ActionListener {

    // variable declaration
    private static JButton search, select, sendEmail;
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
        sendEmail = new JButton("Send Email");
        logout = new JButton("Logout");

        // sets the position and size of JButtons within JFrame
        search.setBounds(100, 100, 100, 40);
        select.setBounds(300, 100, 100, 40);
        sendEmail.setBounds(200, 200, 100, 40);
        logout.setBounds(200, 400, 100, 40);

        // adds JButtons to JFrame
        frame.add(search);
        frame.add(select);
        frame.add(sendEmail);
        frame.add(logout);

        frame.setVisible(true); // JFrame is set to appear

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    // **for testing purposes**

    /* 
    public static void main(String [] args) {
        new RenterView();
    }
    */
}
