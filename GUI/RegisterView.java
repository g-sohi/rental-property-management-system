package GUI;

import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JFrame {

    // variable declaration
    private JTextField username, fName, lName, password; // change UML; userrName to username
    private JComboBox type; // change UML; JTextField to JComboBox
    private String types[] = {"Renter", "Landlord", "Manager"}; // add to UML?
    private JButton register;
    private JFrame f; // add to UML?

    public RegisterView() {
        // creation of JFrame of certain size
        f = new JFrame("Register View");
        f.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        f.setLayout(null); // layout set to null

        // creation of JLabels of certain size and position
        JLabel userNLabel = new JLabel("Username:");
        userNLabel.setBounds(100, 50, 100, 40);
        JLabel pwLabel = new JLabel("Password:");
        pwLabel.setBounds(100, 75, 100, 40);
        JLabel fNLabel = new JLabel("First Name:");
        fNLabel.setBounds(100, 125, 100, 40);
        JLabel lNLabel = new JLabel("Last Name:");
        lNLabel.setBounds(100, 150, 100, 40);
        JLabel typeLabel = new JLabel("User Type:");
        typeLabel.setBounds(100, 200, 100, 40);

        // creation of JTextFields of certain size and position
        username = new JTextField();
        username.setBounds(190, 60, 210, 20);
        password = new JTextField();
        password.setBounds(190, 85, 210, 20);
        fName = new JTextField();
        fName.setBounds(190, 135, 210, 20);
        lName = new JTextField();
        lName.setBounds(190, 160, 210, 20);

        // creation of JComboBoxes of certain size and position
        type = new JComboBox(types);
        type.setBounds(190, 210, 210, 20);

        // creation of JButton of certain size and position
        register = new JButton("Register");
        register.setBounds(200, 300, 100, 40);

        // addition of components to JFrame
        f.add(userNLabel); f.add(pwLabel);
        f.add(fNLabel); f.add(lNLabel);
        f.add(typeLabel);

        f.add(username);
        f.add(fName);
        f.add(lName);
        f.add(password);

        f.add(type);

        f.add(register);

        f.setVisible(true); // JFrame is set to appear

    }

    // **for testing purposes**

    // public static void main(String [] args) {
    //     new RegisterView();
    // }

}
