package GUI;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JComboBox;
public class CreatePropertyView extends JFrame {
    private String types[] = {"Detached", "Semi-Detached", "TownHouse", "Condo"};
    private String quadrants[] = {"NE", "NW", "SE", "SW"};
    private String fur[] = {"Yes", "No"};
    private JComboBox type;
    private JComboBox quadrant;
    private JTextField noBeds;
    private JTextField noBaths;
    private JTextField streetNo;
    private JTextField streetName;
    private JTextField city;
    private JTextField postalCode;
    private JComboBox furnished;
    private JTextField landlordName;
    private JButton register;

    public CreatePropertyView()
    {
        setSize(500, 500);
        getContentPane().setBackground(new Color(200, 200, 250));
        setTitle("Create New Property");
        type = new JComboBox<>(types);
        quadrant = new JComboBox<>(quadrants);
        noBaths = new JTextField();
        noBeds = new JTextField();
        streetNo = new JTextField();
        streetName = new JTextField();
        city = new JTextField();
        postalCode = new JTextField();
        furnished = new JComboBox<>(fur);
        landlordName = new JTextField();
        register = new JButton();



    }
}
