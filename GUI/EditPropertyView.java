package GUI;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

public class EditPropertyView extends JFrame implements ActionListener{
    private JComboBox status;
    private String stat[] = {"Active", "Rented", "Cancelled", "Suspended"};
    private JButton save;
    private JButton remove;
    private JTextField idProperty;
    private Container ctr;

    public EditPropertyView()
    {
        setTitle("Edit Property");
        setBounds(200, 50, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        ctr = getContentPane();
        ctr.setLayout(null);
        getContentPane().setBackground(new Color(200, 200, 250));
        JLabel title = new JLabel("Edit Property");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        ctr.add(title);
        JLabel stat = new JLabel("Status: ");
		stat.setFont(new Font("Arial", Font.PLAIN, 15));
		stat.setSize(200, 40);
        stat.setLocation(200, 170);
		ctr.add(stat);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args)
    {
        new EditPropertyView();
    }


}

//*****IMPORTANT: Correct Class Name from EditPropetyView to EditPropertyView*****