package GUI;

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
    private JButton login, guest, register;
    private JFrame frame;

    public MainPageGUI() throws IOException {

        // creation of JFrame of certain size
        frame = new JFrame("Main Page");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel searchPanel1 = new JPanel();  
        searchPanel1.setBounds(100, 30, 300, 360);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel1.setBackground(Color.LIGHT_GRAY); //set the background color to light gray

        JPanel searchPanel2 = new JPanel();  
        searchPanel2.setBounds(90, 40, 300, 360);     //set the x, y coordinates for the panel as well as the width the height 
        searchPanel2.setBackground(Color.GRAY); //set the background color to light gray

        Image background = null;
        File file = new File("Images/UserLogin2.png");
        background = ImageIO.read(file).getScaledInstance(170, 160, Image.SCALE_FAST);
        ImageIcon icon = new ImageIcon(background);
        JLabel userPNG = new JLabel(icon);

        frame.setLayout(null); // layout set to null

        // creation of JButtons
        login = new JButton("Login");
        guest = new JButton("Continue as Guest");
        register = new JButton("Create New Login");

        // sets the position and size of JButtons within JFrame
        userPNG.setBounds(160, 30, 200, 200);
        login.setBounds(100, 230, 100, 40);
        guest.setBounds(150, 290, 200, 40);
        register.setBounds(250, 230, 150, 40);

        // adds JButtons to JFrame
        frame.add(userPNG);
        frame.add(login);
        frame.add(guest);
        frame.add(register);

        frame.add(searchPanel1);
        frame.add(searchPanel2);

        frame.setVisible(true); // JFrame is set to appear

    }
    public void addLoginListener(ActionListener listenForLogin){
        login.addActionListener(listenForLogin);
        /*this.setVisible(false);
        ManagerView vw = new ManagerView();
        vw.setVisible(true);
        actionPerformed();*/
        
    }

    public void addGuestListener(ActionListener listenForGuest)
    {
        guest.addActionListener(listenForGuest);
    }

    public void addRegisterListener(ActionListener listenForRegister)
    {
        register.addActionListener(listenForRegister);
    }
    @Override // checks if any buttons have been pressed
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public JButton getLog()
    {
        return login;
    }

    public JButton getRegister()
    {
        return register;
    }

    public JButton getGuest()
    {
        return guest;
    }

    public void setOff()
    {
        frame.setVisible(false);
    }

    public void turnOn()
    {
        frame.setVisible(true);
    }
    // **for testing purposes**
    public static void main(String [] args) throws IOException {
        new MainPageGUI();
    }
}
