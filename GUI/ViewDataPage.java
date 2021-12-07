package GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ViewDataPage extends JFrame {
    private JButton renterInfo, propertyInfo, landlordInfo;
    private JTextArea area;


    public ViewDataPage()
    {
        setSize(700, 700);
        setTitle("View Information");
        renterInfo = new JButton("Renter Info");
        propertyInfo = new JButton("Landlord Info");
        landlordInfo = new JButton("Property Info");
        area = new JTextArea();
        add(renterInfo);
        add(propertyInfo);
        add(landlordInfo);
        add(area);
     
        renterInfo.setBounds(30,10,150,30);
        propertyInfo.setBounds(250,10,150,30);
        landlordInfo.setBounds(500,10,150,30);
        area.setBounds(5,50,680,600);

        setLayout(null);
        setVisible(false);
    }

    public void turnOn()
    {
        setVisible(true);
    }

    public void destroyFrame()
    {
        setVisible(false);
    }

}
