package GUI;



import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LandlordView {
    private JButton registerProperty, updateProperty, payFee, search; //change UML; registerProperties to registerProperty
    private JFrame f;
    public LandlordView()
    {
        f=  new JFrame("LandLord Page");
        f.setSize(500, 500);
        registerProperty = new JButton("RegisterProperty");
        updateProperty = new JButton("UpdateProperty");
        payFee = new JButton("PayFee");
        search = new JButton("Search");
        f.add(registerProperty);
        f.add(updateProperty);
        f.add(payFee);
        f.add(search);
        registerProperty.setBounds(30,100,150,30);
        updateProperty.setBounds(300,100,150,30);
        payFee.setBounds(50,170,100,30);
        search.setBounds(330,170,100,30);

        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String [] args)
    {
        new LandlordView();
    }
}

