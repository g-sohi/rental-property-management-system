package GUI;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;
public class CreatePropertyView extends JFrame{
    private String types[] = {"Detached", "Semi-Detached", "TownHouse", "Condo"};
    private String quadrants[] = {"NE", "NW", "SE", "SW"};
    private String fur[] = {"Yes", "No"};
	private String number[] = {"1","2","3","4","5","6"};
    private JComboBox type;
    private JComboBox quadrant;
    private JComboBox noBeds;
    private JComboBox noBaths;
    private JTextField streetNo;
    private JTextField streetName;
    private JTextField city;
    private JTextField postalCode;
    private JComboBox furnished;
    private JTextField landlordName;
    private JButton register;
    private Container ctr;
    private JLabel title;
    private JButton back;

    public CreatePropertyView()
    {
        setTitle("Create New Property");
        setBounds(250, 90, 900, 600);
        setResizable(false);
        setSize(1000, 800);
        ctr = getContentPane();
        ctr.setLayout(null);
        getContentPane().setBackground(new Color(200, 200, 250));
        title = new JLabel("Create New Property");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        ctr.add(title);
        type = new JComboBox<>(types);
        type.setFont(new Font("Arial", Font.PLAIN, 15));
        type.setSize(150, 40);
        type.setLocation(300, 90);
        ctr.add(type);
        quadrant = new JComboBox<>(quadrants);
		quadrant.setFont(new Font("Arial", Font.PLAIN, 15));
        quadrant.setSize(150, 40);
        quadrant.setLocation(600, 90);
        ctr.add(quadrant);
		JLabel bed = new JLabel("Number Of Bedrooms: ");
		bed.setFont(new Font("Arial", Font.PLAIN, 15));
		bed.setSize(200, 40);
        bed.setLocation(300, 170);
		ctr.add(bed);
        noBeds = new JComboBox<>(number);
		noBeds.setFont(new Font("Arial", Font.PLAIN, 15));
        noBeds.setSize(150, 40);
        noBeds.setLocation(480, 170);
        ctr.add(noBeds);
		JLabel bath = new JLabel("Number Of Bathrooms: ");
		bath.setFont(new Font("Arial", Font.PLAIN, 15));
		bath.setSize(200, 40);
        bath.setLocation(300, 230);
		ctr.add(bath);
        noBaths = new JComboBox<>(number);
		noBaths.setFont(new Font("Arial", Font.PLAIN, 15));
        noBaths.setSize(150, 40);
        noBaths.setLocation(480, 230);
        ctr.add(noBaths);
		JLabel street = new JLabel("Street No: ");
		street.setFont(new Font("Arial", Font.PLAIN, 15));
		street.setSize(200, 40);
        street.setLocation(300, 280);
		ctr.add(street);
        streetNo = new JTextField();
		streetNo.setFont(new Font("Arial", Font.PLAIN, 15));
        streetNo.setSize(150, 40);
        streetNo.setLocation(480, 280);
        ctr.add(streetNo);
		JLabel streetN = new JLabel("Street Name: ");
		streetN.setFont(new Font("Arial", Font.PLAIN, 15));
		streetN.setSize(200, 40);
        streetN.setLocation(300, 330);
		ctr.add(streetN);
        streetName = new JTextField();
		streetName.setFont(new Font("Arial", Font.PLAIN, 15));
		streetName.setSize(150, 40);
        streetName.setLocation(480, 330);
		ctr.add(streetName);
		JLabel cityN = new JLabel("City: ");
		cityN.setFont(new Font("Arial", Font.PLAIN, 15));
		cityN.setSize(200, 40);
        cityN.setLocation(300, 380);
		ctr.add(cityN);
        city = new JTextField();
		city.setFont(new Font("Arial", Font.PLAIN, 15));
		city.setSize(150, 40);
        city.setLocation(480, 380);
		ctr.add(city);
		JLabel post = new JLabel("Postal Code: ");
		post.setFont(new Font("Arial", Font.PLAIN, 15));
		post.setSize(200, 40);
        post.setLocation(300, 430);
		ctr.add(post);
        postalCode = new JTextField();
		postalCode.setFont(new Font("Arial", Font.PLAIN, 15));
		postalCode.setSize(150, 40);
        postalCode.setLocation(480, 430);
		ctr.add(postalCode);
		JLabel furnish = new JLabel("Furnished: ");
		furnish.setFont(new Font("Arial", Font.PLAIN, 15));
		furnish.setSize(200, 40);
        furnish.setLocation(300, 480);
		ctr.add(furnish);
        furnished = new JComboBox<>(fur);
		furnished.setFont(new Font("Arial", Font.PLAIN, 15));
		furnished.setSize(150, 40);
        furnished.setLocation(480, 480);
		ctr.add(furnished); 
		/*JLabel lName = new JLabel("Landlord ID: ");
		lName.setFont(new Font("Arial", Font.PLAIN, 15));
		lName.setSize(200, 40);
        lName.setLocation(300, 530);
		ctr.add(lName);*/
        /*landlordName = new JTextField();
		landlordName.setFont(new Font("Arial", Font.PLAIN, 15));
		landlordName.setSize(150, 40);
        landlordName.setLocation(480, 530);
		ctr.add(landlordName);*/
        register = new JButton("Submit");
		register.setFont(new Font("Arial", Font.PLAIN, 15));
		register.setSize(200, 60);
        register.setLocation(400, 600);
		ctr.add(register);
        back = new JButton("Back");
		back.setFont(new Font("Arial", Font.PLAIN, 15));
		back.setSize(100, 60);
        back.setLocation(40, 40);
		ctr.add(back);
        setLocationRelativeTo(null);
		setVisible(true);
    }

    public JButton getRegister(){
        return this.register;
    }

    public JButton getBack(){
        return this.back;
    }

    public void addRegisterPropertyListener(ActionListener listenForRegister){
        this.register.addActionListener(listenForRegister);
    }

    public void addBackPropertyListener(ActionListener listenForRegister){
        this.back.addActionListener(listenForRegister);
    }
    public String getTypeInput()
    {
        return type.getSelectedItem().toString();
    }

    public String getQuadrantInput()
    {
        return quadrant.getSelectedItem().toString();
    }

    public int getNoOfBedInput()
    {
        return Integer.valueOf(noBeds.getSelectedItem().toString());
    }
    public int getNoOfBathInput()
    {
        return Integer.valueOf(noBaths.getSelectedItem().toString());
    }
    public String getStreetNoInput()
    {
        return streetNo.getText();
    }

    public String getStreetNameInput()
    {
        return streetName.getText();
    }

    public String getCityInput()
    {
        return city.getText();
    }

    public String getPostalCodeInput()
    {
        return postalCode.getText();
    }

    public String getFurnishedInput()
    {
        return furnished.getSelectedItem().toString();
    }

    public int getLandlordInput()
    {
        return Integer.valueOf(landlordName.getText());
    }

    public void showErrorDialog()
    {
        
            JOptionPane.showMessageDialog(this, "Fill All fields");
    }

    public void showDialog()
    {
        
            JOptionPane.showMessageDialog(this, "Registration form is completed");
    }
    public void destroyFrame()
    {
        setVisible(false);
    }

}