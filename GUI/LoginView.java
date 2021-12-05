package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame implements ActionListener{
    private  static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private static JButton submit;
    private static JLabel message;
    private JPanel panel;
    private JLabel user_label, password_label;

    public LoginView()
    {
        user_label = new JLabel();
        user_label.setText("User Name :");
        inputUsername = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        inputPassword = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(inputUsername);
        panel.add(password_label);
        panel.add(inputPassword);
        message = new JLabel();
      panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("User Login Page");
        setSize(450,350);
        setVisible(true);
    }

     
    

    @Override
    public void actionPerformed(ActionEvent e) {
        username = inputUsername.getText();
        password = String.valueOf(inputPassword.getPassword());

        if (username.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText(" Hello " + username + "");
         } else {
            message.setText(" Invalid user.. ");
         
        
    }
    }
}
