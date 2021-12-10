package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class SubscribeView extends JFrame {
    
    // variable declaration
    private JLabel notifLabel, subStatLabel; // for labels
    
    // variables for JTable
    private JTable notifs;
    private String notifData[][] = null; //{{"1", "123 ABC Road"}}; // holds data to be shown on JTable
    private String columns[] = {"Property ID", "Address"}; // headers for JTable
    private DefaultTableModel notifModel;
    private JScrollPane tableScroll;
    
    private JComboBox subscribe;
    private String subStatus[] = {"Subscribed", "Unsubscribed"};
    private JFrame f;
    private JButton back;
    private JButton submit, clearNotify;

    public SubscribeView() {

        // creation of JFrame of certain size
        f = new JFrame("Notifications Page");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLayout(null);

        // creation of JLabels of certain size and position
        notifLabel = new JLabel("Notifications:");
        notifLabel.setBounds(50, 25, 100, 40);
        subStatLabel = new JLabel("Subscription Status:");
        subStatLabel.setBounds(50, 350, 150, 40);        
        
        // creation of JTable of certain size and position
        notifModel = new DefaultTableModel(notifData, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        notifs = new JTable(notifData, columns);
        notifs.setBounds(50, 60, 400, 240);
        notifs.setModel(notifModel);
        notifs.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableScroll = new JScrollPane(notifs);
        tableScroll.setBounds(50, 60, 400, 275);

        // creation of JComboBox of certain size and position
        subscribe = new JComboBox(subStatus);
        subscribe.setBounds(175, 360, 275, 20);

        // creation of JButtons of certain size and position
        back = new JButton("Back");
        back.setBounds(275, 410, 150, 40);
        clearNotify = new JButton("Clear Notifications");
        clearNotify.setBounds(75, 410, 150, 40);

        // addition of components to JFrame
        f.add(notifLabel); f.add(tableScroll);
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

    public void setTableData(String[][] newData){
        notifModel.setRowCount(0);
        for(int i=0; i<newData.length; i++)
        {
            notifModel.addRow(newData[i]);
        }
  
          notifs.revalidate();
      }

    public JButton getBackButton()
    {
            return back;
    }

    public JButton getClearNotify() {
        return clearNotify;
    }
    
    public JComboBox getSubStatBox() {
        return subscribe;
    }

    public String getSubStatus() {
        return subscribe.getSelectedItem().toString();
    }

    public void setSubStatus(int status) {
        subscribe.setSelectedIndex(status);
    }

    public void addBackListener(ActionListener listenForBack){
        System.out.println("DONE");
        this.back.addActionListener(listenForBack);
    }

    public void addClearListener(ActionListener listenForReport){
        System.out.println("CLEAR");
        this.clearNotify.addActionListener(listenForReport);
    }

    public void addItemListener(ItemListener listenForItem){
        subscribe.addItemListener(listenForItem);
    }

    // **for testing purposes**
    // public static void main(String [] args) {
    //     new SubscribeView().turnOn();;
    // }

}
