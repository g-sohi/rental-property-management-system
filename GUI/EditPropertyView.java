package GUI;


import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

public class EditPropertyView extends JFrame{
    private JComboBox status;
    private String stat_prop[] = {"Active", "Rented", "Cancelled", "Suspended"};
    private JButton save;
    private JButton remove;
    private JTextField idProperty;
    private Container ctr;
	private JTextField idProperty2;

    public EditPropertyView()
    {
        setTitle("Edit Property");
        setBounds(100, 50, 900, 600);
        setResizable(false);
        setSize(500, 500);
        ctr = getContentPane();
        ctr.setLayout(null);
        getContentPane().setBackground(new Color(200, 200, 250));
        JLabel title = new JLabel("Edit Property");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        ctr.add(title);
		JLabel id = new JLabel("Property ID: ");
		id.setFont(new Font("Arial", Font.PLAIN, 15));
		id.setSize(200, 40);
        id.setLocation(100, 70);
		ctr.add(id);
		idProperty = new JTextField();
		idProperty.setFont(new Font("Arial", Font.PLAIN, 15));
		idProperty.setSize(100, 20);
        idProperty.setLocation(200, 80);
		ctr.add(idProperty);
        JLabel stat = new JLabel("Status: ");
		stat.setFont(new Font("Arial", Font.PLAIN, 15));
		stat.setSize(200, 40);
        stat.setLocation(100, 100);
		ctr.add(stat);
		status = new JComboBox<>(stat_prop);
		status.setFont(new Font("Arial", Font.PLAIN, 15));
        status.setSize(100, 20);
        status.setLocation(200, 110);
        ctr.add(status);
		save = new JButton("Save");
		save.setFont(new Font("Arial", Font.PLAIN, 15));
        save.setSize(100, 20);
        save.setLocation(180, 150);
        ctr.add(save);
		JLabel title2 = new JLabel("Remove Property");
		title2.setFont(new Font("Arial", Font.PLAIN, 30));
        title2.setSize(300, 30);
        title2.setLocation(150, 250);
        ctr.add(title2);
		JLabel id2 = new JLabel("Property ID: ");
		id2.setFont(new Font("Arial", Font.PLAIN, 15));
		id2.setSize(200, 40);
        id2.setLocation(100, 290);
		ctr.add(id2);
		idProperty2 = new JTextField();
		idProperty2.setFont(new Font("Arial", Font.PLAIN, 15));
		idProperty2.setSize(100, 20);
        idProperty2.setLocation(200, 300);
		ctr.add(idProperty2);
		remove = new JButton("Remove");
		remove.setFont(new Font("Arial", Font.PLAIN, 15));
        remove.setSize(100, 20);
        remove.setLocation(180, 340);
        ctr.add(remove);
        setVisible(true);

    }

    public void destroyFrame()
    {   
        setVisible(false);
    }

    public void turnOn()
    {
        setVisible(true);
    } 

    public JButton getSaveButton()
    {
        return save;
    }

    public JButton getRemoveButton()
    {
        return remove;
    }
    public void addSaveListener(ActionListener listenForSave){
        System.out.println("DONE");
        this.save.addActionListener(listenForSave);
    }

    public void addRemoveListener(ActionListener listenForRemove){
        System.out.println("DONE");
        this.remove.addActionListener(listenForRemove);
    }

    public String getStatusInput()
    {
        return status.getSelectedItem().toString();
    }

    public int getPropetyIdInput()
    {
        return Integer.valueOf(idProperty.getText());
    }

    public int getPropetyId2Input()
    {
        return Integer.valueOf(idProperty2.getText());
    }



}

//*****IMPORTANT: Correct Class Name from EditPropetyView to EditPropertyView*****