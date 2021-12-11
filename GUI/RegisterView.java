package GUI;

import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JFrame {

    // variable declaration
    private JTextField username, fName, lName, password; // change UML; userrName to username
    private JComboBox type; // change UML; JTextField to JComboBox
    private String types[] = {"Renter", "Landlord", "Manager"}; // add to UML?
    private JButton register;
    private JButton back;
    private JFrame f; // add to UML?
    int check;

    public RegisterView() {
        check = 0;
        // creation of JFrame of certain size
        f = new JFrame("Register Page");
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
        back = new JButton("Back to Main");
        back.setBounds(40, 10, 150, 25);


        // addition of components to JFrame
        f.add(userNLabel); f.add(pwLabel);
        f.add(fNLabel); f.add(lNLabel);
        f.add(typeLabel);
        f.add(back);

        f.add(username);
        f.add(fName);
        f.add(lName);
        f.add(password);

        f.add(type);

        f.add(register);
        f.setLocationRelativeTo(null);
        f.setVisible(false); // JFrame is set to appear

    }
    public void turnOn()
    {
        f.setVisible(true);
        username.setText("");
        password.setText("");
        fName.setText("");
        lName.setText("");
        check = 1;
    }

    public void destroyFrame()
    {
        f.setVisible(false);
        check = 0;
    }

    public JButton getRegisterButton()
    {
        return register;
    }
    public JButton getBackButton()
    {
        return back;
    }

    public void addRegisterListener(ActionListener listenForRegister)
    {
        register.addActionListener(listenForRegister);
    }

    public void addBackListener(ActionListener listenForRegister)
    {
        back.addActionListener(listenForRegister);
    }


    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getFName() {
        return fName.getText();
    }

    public String getLName() {
        return lName.getText();
    }

    public String getUserType() {
        return type.getSelectedItem().toString();
    }


    // **for testing purposes**

    public void showDialog()
    {
        //JFrame frame = new JFrame("Registration Done");
            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(f,"Registeration is successful");
            //f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    
    public void showErrorDialog()
    {
        JOptionPane.showMessageDialog(f,"Fill All Fields");
    }

}
