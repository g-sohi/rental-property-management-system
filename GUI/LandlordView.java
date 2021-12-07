package GUI;



import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;

public class LandlordView extends JFrame{
    private JButton registerProperty, updateProperty, payFee, search, logout; //change UML; registerProperties to registerProperty
    private JFrame f;
    public LandlordView()
    {
        f=  new JFrame("LandLord Page");
        f.setSize(500, 500);
        registerProperty = new JButton("RegisterProperty");
        updateProperty = new JButton("UpdateProperty");
        payFee = new JButton("PayFee");
        search = new JButton("Search");
        logout = new JButton("Logout");
        f.add(registerProperty);
        f.add(updateProperty);
        f.add(payFee);
        f.add(search);
        f.add(logout);
        registerProperty.setBounds(30,100,150,30);
        updateProperty.setBounds(300,100,150,30);
        payFee.setBounds(50,170,100,30);
        search.setBounds(330,170,100,30);
        logout.setBounds(250, 300, 100, 30);

        f.setLayout(null);
        f.setVisible(true);
    }


    public JButton getLogout()
    {
        return logout;
    }

    public JButton getRegister(){
        return registerProperty;
    }

    public JButton getUpdate(){
        return updateProperty;
    }

    public JButton getPay(){
        return payFee;
    }

    public JButton getSearch(){
        return search;
    }

    public void destroyFrame()
    {   
        f.setVisible(false);
    }

    public void turnOn()
    {
        f.setVisible(true);
    } 

    public void addLogoutListener(ActionListener listenForLogout){
        logout.addActionListener(listenForLogout);
    }

    public void addRegisterPropertyListener(ActionListener listenForRegister){
        registerProperty.addActionListener(listenForRegister);
    }

    public void addUpdatePropertyListener(ActionListener listenForUpdate){
        updateProperty.addActionListener(listenForUpdate);
    }

    public void addPayFeeListener(ActionListener listenForPay){
        payFee.addActionListener(listenForPay);
    }

    public void addSearchListener(ActionListener listenForSearch){
        search.addActionListener(listenForSearch);
    }

    

}

