package GUI;

/**
 * @author Curtis Silva <a href="mailto:curtis.silva@ucalgary.ca">
 *         curtis.silva@ucalgary.ca</a>
 * 
 * @author Gurpartap Sohi <a href="mailto:gurpartap.sohi@ucalgary.ca">
 *         gurpartap.sohi@ucalgary.ca</a>
 * 
 * @author Ivan Suyat<a href="mailto:ivan.suyat@ucalgary.ca">
 *         ivan.suyat@ucalgary.ca/a>
 * 
 * @author Manpreet Singh<a href="mailto:manpreet.singh2@ucalgary.ca">
 *         manpreet.singh2@ucalgary.ca</a>
 * 
 */

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

import java.awt.event.*;
import java.awt.*;

public class MainPageGUI extends JFrame implements ActionListener {
    
    // variable declaration
    private JButton login, guest, register, sendEmail;
    private JFrame frame;

    public MainPageGUI() throws IOException {

        //Set the frame size to 500 by 500
        setSize(500, 500);
        //When the user initiates a close on this frame, Exit the application using the System exit method.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Making the GUI components for the frame
        //Background panels
        JPanel panel1 = new JPanel();  
        JPanel panel2 = new JPanel();  

        //Image for login icon
        Image background = null;
        File file = new File("Images/UserLogin2.png"); 
        //read the image from the file location
        background = ImageIO.read(file).getScaledInstance(170, 160, Image.SCALE_FAST);
        //set the ImageIcon using the read file
        ImageIcon icon = new ImageIcon(background);
        //set the JLabel to the ImageIcon of the login icon
        JLabel userPNG = new JLabel(icon);

        setLayout(null); // layout set to null

        // creation of JButtons
        login = new JButton("Login");
        guest = new JButton("Continue as Guest");
        register = new JButton("Register");
        sendEmail = new JButton("Send Email");

        // sets the position and size of JButtons within JFrame
        userPNG.setBounds(160, 30, 200, 200);
        login.setBounds(150, 210, 200, 40);
        guest.setBounds(150, 290, 200, 40);
        register.setBounds(150, 250, 200, 40);
        sendEmail.setBounds(150, 330, 200, 40);
        panel1.setBounds(100, 30, 300, 360);     //set the x, y coordinates for the panel as well as the width the height 
        panel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray
        panel2.setBounds(90, 40, 300, 360);     //set the x, y coordinates for the panel as well as the width the height 
        panel2.setBackground(Color.GRAY);       //set the background color to light gray

        // adds JButtons to JFrame
        add(userPNG);
        add(login);
        add(guest);
        add(register);
        add(sendEmail);

        add(panel1);
        add(panel2);
        setLocationRelativeTo(null);
        setVisible(true); // JFrame is set to appear

    }

    //Listener method to Listen for the Login button
    public void addLoginListener(ActionListener listenForLogin){
        login.addActionListener(listenForLogin);
    }


    //Listener method to Listen for the Send Email button
    public void addSendEmailListener(ActionListener listenForSendEmail){
        sendEmail.addActionListener(listenForSendEmail);
    }

    //Listener method to Listen for the Continue as Guest button
    public void addGuestListener(ActionListener listenForGuest)
    {
        guest.addActionListener(listenForGuest);
    }


    //Listener method to Listen for the Register button
    public void addRegisterListener(ActionListener listenForRegister)
    {
        register.addActionListener(listenForRegister);
    }

    //Method to get the JButton for the Login Button
    public JButton getLog()
    {
        return login;
    }

    //Method to get the JButton for the Register Button
    public JButton getRegister()
    {
        return register;
    }

    //Method to get the JButton for the Send Email Button
    public JButton getSendEmailButton()
    {
        return sendEmail;
    }

    //Method to get the JButton for the Continue as Guest Button
    public JButton getGuest()
    {
        return guest;
    }

    //Method to turn the visibility of the frame to of
    public void setOff()
    {
        setVisible(false);
    }

    //Method to turn the visibility of the frame to on
    public void turnOn()
    {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
