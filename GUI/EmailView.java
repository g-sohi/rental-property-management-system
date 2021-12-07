package GUI;

import javax.swing.*;
import java.awt.event.*;

public class EmailView extends JFrame {
    
    // variable declaration
    private JTextField subject, from, to, body;
    private JButton send;

    public EmailView() {

        // creation of JFrame of certain size
        JFrame frame = new JFrame("Email Page");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setLayout(null); // layout set to null

        // creation of JLabels of certain size and position
        JLabel subLabel = new JLabel("Subject:");
        subLabel.setBounds(50, 100, 100, 40);
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 25, 100, 40);
        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 50, 100, 40);
        
        // creation of JTextFields of certain size and position
        subject = new JTextField();
        subject.setBounds(140, 110, 310, 20);
        from = new JTextField();
        from.setBounds(140, 35, 310, 20);
        to = new JTextField();
        to.setBounds(140, 60, 310, 20);
        body = new JTextField();
        body.setBounds(50, 160, 400, 200);

        // creation of JButton of certain size and position
        send = new JButton("Send");
        send.setBounds(200, 410, 100, 40);

        // addition of components to JFrame
        frame.add(subLabel); frame.add(fromLabel); frame.add(toLabel);
        frame.add(subject); frame.add(from); frame.add(to); frame.add(body);
        frame.add(send);

        frame.setVisible(true); // JFrame is set to appear

    }

    // **for testing purposes**

    // public static void main(String [] args) {
    //     new EmailView();
    // }

}
