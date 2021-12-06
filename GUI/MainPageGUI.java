package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

public class MainPageGUI extends JFrame implements ActionListener{
    
    // variable declaration
    private JButton login, guest;
    private JFrame frame;

    public MainPageGUI() {

        // creation of JFrame of certain size
        frame = new JFrame("Main Page");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setLayout(null); // layout set to null

        // creation of JButtons
        login = new JButton("Login");
        guest = new JButton("Continue as Guest");

        // sets the position and size of JButtons within JFrame
        login.setBounds(200, 100, 100, 40);
        guest.setBounds(150, 190, 200, 40);

        // adds JButtons to JFrame
        frame.add(login);
        frame.add(guest);

        frame.setVisible(true); // JFrame is set to appear

    }

    @Override // checks if any buttons have been pressed
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    // **for testing purposes**
    public static void main(String [] args) {
        new MainPageGUI();
    }
}
