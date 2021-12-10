package GUI;

import javax.swing.*;
import java.awt.event.*;

public class EmailView extends JFrame {
    
    // variable declaration
    private JTextField subject, from, pID;
    private JTextArea body;
    private JLabel subLabel, pIDLabel, fromLabel;
    private JButton send;
    private JFrame frame;
    private JFrame gFrame;
    private String id;
    private JButton back;

    public EmailView(String id) {

        this.id = id;

        // creation of JFrame of certain size
        frame = new JFrame("Email Page");
        frame.setSize(500, 500);
        frame.setLayout(null); // layout set to null

        //setDefaultCloseOperation(EXIT_ON_CLOSE);        

        // creation of JLabels of certain size and position
        subLabel = new JLabel("Subject:");
        subLabel.setBounds(50, 100, 100, 40);
        fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 25, 100, 40);
        pIDLabel = new JLabel("Property ID:   " + id);
        pIDLabel.setBounds(50, 50, 100, 40);
        
        // creation of JTextFields and JTextArea of certain size and position
        subject = new JTextField();
        subject.setBounds(140, 110, 310, 20);
        from = new JTextField();
        from.setBounds(140, 35, 310, 20);
        body = new JTextArea();
        body.setBounds(50, 160, 400, 225);

        // creation of JButton of certain size and position
        send = new JButton("Send");
        send.setBounds(200, 410, 100, 40);

        // addition of components to JFrame
        frame.add(subLabel); frame.add(fromLabel); frame.add(pIDLabel);
        frame.add(subject); frame.add(from);  frame.add(body);
        frame.add(send);

        frame.setVisible(false); // JFrame is set to appear

    }

    public EmailView(Boolean Guest) {
        if(Guest == true)
        {


        // creation of JFrame of certain size
        gFrame = new JFrame("Email Page For Guest");
        gFrame.setSize(500, 500);
        gFrame.setLayout(null); // layout set to null

        //setDefaultCloseOperation(EXIT_ON_CLOSE);        

        // creation of JLabels of certain size and position
        subLabel = new JLabel("Subject:");
        subLabel.setBounds(50, 100, 100, 40);
        fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 25, 100, 40);
        pIDLabel = new JLabel("Property ID:" );
        pIDLabel.setBounds(50, 50, 100, 40);
        
        // creation of JTextFields and JTextArea of certain size and position
        subject = new JTextField();
        subject.setBounds(140, 110, 310, 20);
        from = new JTextField();
        from.setBounds(140, 35, 310, 20);
        pID = new JTextField();
        pID.setBounds(140, 60, 50, 20);
        body = new JTextArea();
        body.setBounds(50, 160, 400, 225);

        // creation of JButton of certain size and position
        send = new JButton("Send");
        send.setBounds(200, 410, 100, 40);
        back = new JButton("Back");
        back.setBounds(50, 410, 100, 40);

        // addition of components to JFrame
        gFrame.add(subLabel); gFrame.add(fromLabel); gFrame.add(pIDLabel);
        gFrame.add(subject); gFrame.add(from);  gFrame.add(body);
        gFrame.add(send); 
        gFrame.add(pID);
        gFrame.add(back);

        gFrame.setVisible(false); // JFrame is set to appear

    }
}
    public void addSendEmailListener(ActionListener listenForSendEmail){
        System.out.println("DONE1");
        this.send.addActionListener(listenForSendEmail);
    }

    public void addBackListener(ActionListener listenForBack){
        System.out.println("DONE1");
        this.back.addActionListener(listenForBack);
    }

    public JButton getSendButton()
    {
        return send;
    }

    public JButton getBackButton()
    {
        return back;
    }
    // returns input for Subject JTextfield
    public String getSub() {
        return subject.getText();
    }

    // returns input for From JTextfield
    public String getFrom() {
        return from.getText();
    }

    // returns input for To JTextfield
    public String getPID() {
        return pID.getText();
    }

    // returns input for Body JTextfield
    public String getBody() {
        return body.getText();
    }

    // sets frame to appear
    public void turnOn()
    {
        frame.setVisible(true);
    }

    public void turnOnForGuest()
    {
        gFrame.setVisible(true);
    }

    // sets frame to not appear
    public void destroyFrameForGuest()
    {
        gFrame.setVisible(false);
    }

    public void destroyFrame()
    {
        frame.setVisible(false);
    }

    // **for testing purposes**
    // public static void main(String [] args) {
    //     new EmailView().turnOn();
    // }
    public void showDialog()
    {
        //JFrame frame = new JFrame("Registration Done");
            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame,"Email is sent successfully");
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //System.out.println("working");
    }

    public void showErrorDialog()
    {
        
            JOptionPane.showMessageDialog(frame,"Fill All fields");
    }

}
