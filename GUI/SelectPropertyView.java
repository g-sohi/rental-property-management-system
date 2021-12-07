package GUI;

import javax.swing.*;

public class SelectPropertyView extends JFrame {
    
    // variable declaration (MAJOR UML CHANGE, LOOK THROUGH CONSTRUCTOR)
    private JFrame frame; //change UML; fram to frame
    private String type, streetName, city, quadrant;
    private int streetNo, noBeds, noBaths; //change UML; noOfBedroon to noBeds; noOfBathroom to noBaths
    private boolean furnished; //change UML; Furnished to furnished

    public SelectPropertyView() {

        // creation of JFrame of certain size
        JFrame frame = new JFrame("Selection Page");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null); // layout set to null

        // creation of JLabels of certain size and position
        JLabel pIDLabel = new JLabel("Property ID:");
        pIDLabel.setBounds(50, 25, 100, 40);
        JLabel areaTitle = new JLabel("Property Details:");
        areaTitle.setBounds(50, 125, 100, 40);

        // creation of JButtons of certain size and position
        JButton select = new JButton("Select");
        select.setBounds(200, 75, 100, 20);
        JButton email = new JButton("Contact Landlord");
        email.setBounds(75, 410, 150, 40);
        JButton back = new JButton("Back");
        back.setBounds(275, 410, 150, 40);

        // creation of JTextField and JTextArea of certain size and position
        JTextField pID = new JTextField();
        pID.setBounds(140, 35, 310, 20);
        JTextArea pDetails = new JTextArea();
        pDetails.setBounds(50, 160, 400, 240);
        pDetails.setEditable(false); // pDetails will not be editable

        // addition of components to JFrame
        frame.add(pIDLabel);
        frame.add(areaTitle);
        frame.add(select);
        frame.add(email);
        frame.add(back);
        frame.add(pID);
        frame.add(pDetails);

        frame.setVisible(true); // JFrame is set to appear

    }

    // **for testing purposes**
    public static void main(String [] args) {
        new SelectPropertyView();
    }

}


