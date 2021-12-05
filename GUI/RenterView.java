package GUI;

import javax.swing.*;

public class RenterView {

    // variable declaration
    private static JButton search, select, sendEmail;
    private JFrame frame;

    public RenterView() {
        // creation of JFrame of certain size
        frame = new JFrame("Renter Page");
        frame.setSize(500, 500);

        frame.setLayout(null); // layout set to null

        // creation of JButtons
        search = new JButton("Search");
        select = new JButton("Select");
        sendEmail = new JButton("Send Email");

        // sets the position and size of JButtons within JFrame
        search.setBounds(100, 100, 100, 40);
        select.setBounds(300, 100, 100, 40);
        sendEmail.setBounds(200, 200, 100, 40);

        // adds JButtons to JFrame
        frame.add(search);
        frame.add(select);
        frame.add(sendEmail);

        frame.setVisible(true); // JFrame is set to appear

    }

    // **for testing purposes**

    // public static void main(String [] args) {
    //     new RenterView();
    // }
}
