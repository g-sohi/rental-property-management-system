package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SubscribeView extends JFrame {
    
    // variable declaration
    private JComboBox subscribe;
    private String subStatus[] = {"Subscribed", "Unsubscribed"};
    private JFrame f;
    private JButton back;
    private JButton submit, clearNotify; //change UML; remove submit?
    private JList notifs;

    public SubscribeView() {

        // creation of JFrame of certain size
        f = new JFrame("Notifications Page");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLayout(null);

        // creation of JLabels of certain size and position
        JLabel notifLabel = new JLabel("Notifications:");
        notifLabel.setBounds(50, 25, 100, 40);
        JLabel subStatLabel = new JLabel("Subscription Status:");
        subStatLabel.setBounds(50, 350, 150, 40);        
        
        // creation of JTextArea of certain size and position
        notifs = new JList<>();
        notifs.setBounds(50, 60, 400, 240);
        

        // creation of JComboBox of certain size and position
        subscribe = new JComboBox(subStatus);
        subscribe.setBounds(175, 360, 275, 20);

        // creation of JButtons of certain size and position
        back = new JButton("Back");
        back.setBounds(275, 410, 150, 40);
        clearNotify = new JButton("Clear Notifications");
        clearNotify.setBounds(75, 410, 150, 40);

        // addition of components to JFrame
        f.add(notifLabel); f.add(notifs);
        f.add(subStatLabel); f.add(subscribe);
        f.add(back);
        f.add(clearNotify);

        f.setVisible(false); // JFrame is set to appear

    }

    public void turnOn()
    {
        f.setVisible(true);
    }

    
    public void destroyFrame()
    {
        f.setVisible(false);
    }

    public JButton getBackButton()
    {
            return back;
    }
    
    public String getSubStatus() {
        return subscribe.getSelectedItem().toString();
    }

    public void addBackListener(ActionListener listenForBack){
        System.out.println("DONE");
        this.back.addActionListener(listenForBack);
    }

    // **for testing purposes**
    // public static void main(String [] args) {
    //     new SubscribeView();
    // }

}
