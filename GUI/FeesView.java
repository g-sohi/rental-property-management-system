package GUI;

import javax.swing.*;
import java.awt.event.*;

import Models.*;

public class FeesView extends JFrame {
    
    // variable declaration
    private JTextField changeFeeAmount, changePeriod, pID, fName, lName, country, postalCode, ccn, mmExp, yyExp, cvv;
    private JButton save, payFees; //change UML; submit to save
    private JFrame fMgr;
    private JFrame fLlrd;

    public FeesView(boolean isMgrPlaceholder) {

        // creation of JFrames of certain size for Manager and Landlord User Types
        fMgr = new JFrame("Fees Management Page");
        fLlrd = new JFrame("Fees Payment Page");

        fMgr.setSize(500, 500); fLlrd.setSize(500, 500);
        //fMgr.setDefaultCloseOperation(EXIT_ON_CLOSE); fLlrd.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fMgr.setLayout(null); fLlrd.setLayout(null);// layout set to null

        // creation of JLabels of certain size and position        
        JLabel pIDLabel = new JLabel("Property ID:");
        pIDLabel.setBounds(50, 25, 100, 40);
        JLabel feeLabel = new JLabel("Amount Owed:");
        feeLabel.setBounds(50, 50, 100, 40);
        JLabel periodLabel = new JLabel("Listing Period:");
        periodLabel.setBounds(50, 75, 100, 40);
        JLabel daysText = new JLabel("days", SwingConstants.RIGHT);
        daysText.setBounds(50, 75, 395, 40);

        JLabel billingTitle = new JLabel("BILLING INFORMATION");
        billingTitle.setBounds(50, 125, 150, 40);
        JLabel fNLabel = new JLabel("First Name:");
        fNLabel.setBounds(50, 150, 100, 40);
        JLabel lNLabel = new JLabel("Last Name:");
        lNLabel.setBounds(250, 150, 100, 40);
        JLabel cLabel = new JLabel("Country:");
        cLabel.setBounds(50, 175, 100, 40);
        JLabel pcLabel = new JLabel("Postal Code:");
        pcLabel.setBounds(250, 175, 100, 40);


        JLabel creditTitle = new JLabel("CREDIT CARD INFORMATION");
        creditTitle.setBounds(50, 225, 200, 40);
        JLabel ccnLabel = new JLabel("CCN:");
        ccnLabel.setBounds(50, 250, 100, 40);
        JLabel expLabel = new JLabel("Expiry Date (MM/YY):");
        expLabel.setBounds(200, 250, 150, 40);
        JLabel expDivideLabel = new JLabel("/");
        expDivideLabel.setBounds(250, 270, 150, 40);
        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(350, 250, 100, 40);

        // creation of JTextFields of certain size and position
        pID = new JTextField();
        pID.setBounds(140, 35, 310, 20);
        changeFeeAmount = new JTextField();
        changeFeeAmount.setBounds(140, 60, 310, 20);
        changePeriod = new JTextField();
        changePeriod.setBounds(360, 85, 50, 20);

        fName = new JTextField();
        fName.setBounds(140, 160, 85, 20);
        lName = new JTextField();
        lName.setBounds(340, 160, 85, 20);
        country = new JTextField();
        country.setBounds(140, 185, 85, 20);
        postalCode = new JTextField();
        postalCode.setBounds(340, 185, 85, 20);

        ccn = new JTextField();
        ccn.setBounds(50, 280, 125, 20);
        mmExp = new JTextField();
        mmExp.setBounds(200, 280, 40, 20);
        yyExp = new JTextField();
        yyExp.setBounds(265, 280, 40, 20);
        cvv = new JTextField();
        cvv.setBounds(350, 280, 40, 20);

        // creation of JButtons of certain size and position
        save = new JButton("Apply Changes");
        save.setBounds(175, 410, 150, 40);
        payFees = new JButton("Confirm Payment");
        payFees.setBounds(175, 410, 150, 40);

        // add components to JFrames dependent on User Type
        if(isMgrPlaceholder) {
            fMgr.add(pIDLabel); fMgr.add(pID);
            fMgr.add(feeLabel); fMgr.add(changeFeeAmount);
            fMgr.add(periodLabel); fMgr.add(changePeriod);
            fMgr.add(daysText);

            fMgr.add(save);

            //fLlrd.setVisible(false);
            //fMgr.setVisible(true);
        }

        else {
            fLlrd.add(pIDLabel); fLlrd.add(pID);
            fLlrd.add(feeLabel); fLlrd.add(changeFeeAmount);
            fLlrd.add(periodLabel); fLlrd.add(changePeriod);
            fLlrd.add(daysText);

            fLlrd.add(billingTitle);
            fLlrd.add(fNLabel); fLlrd.add(fName);
            fLlrd.add(lNLabel); fLlrd.add(lName);
            fLlrd.add(cLabel); fLlrd.add(country);
            fLlrd.add(pcLabel); fLlrd.add(postalCode);

            fLlrd.add(creditTitle);
            fLlrd.add(ccnLabel); fLlrd.add(ccn);
            fLlrd.add(expLabel); fLlrd.add(expDivideLabel); fLlrd.add(mmExp); fLlrd.add(yyExp); fLlrd.add(cvv);
            fLlrd.add(cvvLabel);

            fLlrd.add(payFees);

            //fMgr.setVisible(false);
            //fLlrd.setVisible(true);

        }
    }

    public void turnOnForLanLord()
    {
        fLlrd.setVisible(true);
    }   

    public void turnOnForManager()
    {
        fMgr.setVisible(true);
    }  

    public String getPID() {
        return pID.getText();
    }

    public String getFee() {
        return changeFeeAmount.getText();
    }

    public String getPeriod() {
        return changePeriod.getText();
    }

    public String getFName() {
        return fName.getText();
    }

    public String getLName() {
        return lName.getText();
    }

    public String getCountry() {
        return country.getText();
    }

    public String getPCode() {
        return postalCode.getText();
    }

    public String getCCN() {
        return ccn.getText();
    }

    public String getMMExp() {
        return mmExp.getText();
    }

    public String getYYExp() {
        return yyExp.getText();
    }

    public String getCVV() {
        return cvv.getText();
    }
}
