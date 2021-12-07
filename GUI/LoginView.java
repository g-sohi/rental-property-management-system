package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LoginView extends JFrame {
    private static JTextField inputUsername; //change UML; InputUserName to inputUsername
    private static JPasswordField inputPassword;
    private String username; //change UML; userName to username
    private String password;
    private JButton submit;
    private JLabel message;
    private JFrame f;
    private JLabel user_label, password_label;

    public LoginView()
    {
		f=  new JFrame("Manager Page");
        f.setSize(500, 500);
		user_label = new JLabel("UserName: ");
        password_label = new JLabel("Password: ");
        inputUsername = new JTextField();
        inputPassword = new JPasswordField();
        submit = new JButton("Submit");
        f.add(user_label);
        f.add(password_label);
        f.add(inputUsername);
        f.add(inputPassword);
        f.add(submit);
        user_label.setBounds(100,100,150,30);
        password_label.setBounds(100,150,150,30);
        inputUsername.setBounds(200,100,130,30);
        inputPassword.setBounds(200,150,100,30);
        submit.setBounds(300, 400, 150, 30);

        f.setLayout(null);
        f.setVisible(false);
    }



     
    public void addLoginListener(ActionListener listenForLogin){
        submit.addActionListener(listenForLogin);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/
        
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

    public String getUsername()
    {
        return inputUsername.getText();
    }

    public String getPassword()
    {
        return String.valueOf(inputPassword.getPassword());
    }

    public JButton getButton()
    {
        return this.submit;
    }
	
	public static void main(String[] args)
	{
		new LoginView();
	}

    public void destroyFrame()
    {
        f.setVisible(false);
    }   
    
    public void turnOn()
    {
        f.setVisible(true);
        inputUsername.setText("");
        inputPassword.setText("");
    }    

}
