package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame {
    //Member Varaibles used for the LoginView JFrame display
    private static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private JButton submit;
    private JButton goBack;
    private JLabel message;
    private JLabel user_label, password_label;

    public LoginView()
    {
        setSize(500, 500); //Set the frame of the class to 500 by 500


        JPanel panel1 = new JPanel();  
        JPanel panel2 = new JPanel();  

        //Username and Password labels for the Frame
		user_label = new JLabel("UserName: ");
        password_label = new JLabel("Password: ");

        //Username and Password JTextFields for taking in user inputs for the Frame
        inputUsername = new JTextField();
        inputPassword = new JPasswordField();

        //Submit and Go Back buttons
        submit = new JButton("Submit");
        goBack = new JButton("Go Back to Main");

        //Add all the components to the Frame of the class
        add(user_label);
        add(password_label);
        add(inputUsername);
        add(inputPassword);
        add(submit);
        add(goBack);
        add(panel1);
        add(panel2);

        //Set the x and y coordinates along with the Width and height of each GUI component
        user_label.setBounds(100,150,150,30);
        password_label.setBounds(100,200,150,30);
        inputUsername.setBounds(200,150,130,30);
        inputPassword.setBounds(200,200,130,30);
        submit.setBounds(175, 320, 150, 30);
        goBack.setBounds(10, 10, 150, 30);
        panel1.setBounds(50, 80, 390, 300);     //set the x, y coordinates for the panel as well as the width the height 
        panel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray
        panel2.setBounds(45, 85, 390, 300);     //set the x, y coordinates for the panel as well as the width the height 
        panel2.setBackground(Color.GRAY); //set the background color to light gray

        //Set the Layout to null and make the frame not visible
        setLayout(null);
        setVisible(false);
    }


    //Listener method for the Login button
    public void addLoginListener(ActionListener listenForLogin){
        submit.addActionListener(listenForLogin);
    }

    //Listener method for the Back button
    public void addGoBackListener(ActionListener listenForLogin){
        goBack.addActionListener(listenForLogin);
        
    }

    //public void actionPerformed(ActionEvent e) {
        // username = inputUsername.getText();
            //password = String.valueOf(inputPassword.getPassword());
        /*
        if (username.trim().equals("admin") && password.trim().equals("admin")) {
            ManagerView vw = new ManagerView();
        vw.setVisible(true);

            message.setText(" Hello " + username + "");
         } else {
            message.setText(" Invalid user.. ");
    }
        this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);

    }*/

    //Method to get the username the user inputs into the Username JTextField
    public String getUsername()
    {
        return inputUsername.getText();
    }

    //Method to get the password the user inputs into the password JTextField
    public String getPassword()
    {
        return String.valueOf(inputPassword.getPassword());
    }

    //Method to get the JButton for the submit button
    public JButton getButton()
    {
        return this.submit;
    }

    //Method to get the JButton for the back button
	public JButton getGoBackButton()
    {
        return this.goBack;
    }

    //Method to set the frame to not be visible
    public void destroyFrame()
    {
        setVisible(false);
    }   
    
    //Method to set the frame to be visible and clear the JTextFields for username and password
    public void turnOn()
    {
        setVisible(true);
        inputUsername.setText("");
        inputPassword.setText("");
    }    

    public static void main(String [] args) {
        LoginView test =  new LoginView();
        test.turnOn();
    }

}
