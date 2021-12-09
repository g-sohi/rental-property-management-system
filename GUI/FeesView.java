package GUI;

import javax.swing.*;
import java.awt.event.*;

import Models.*;

public class FeesView extends JFrame {
    
    // variable declaration
    private JTextField changeFeeAmount, startDate, endDate, pID, fName, lName, country, postalCode, ccn, mmExp, yyExp, cvv;
    private JButton save, payFees;
    private JLabel pIDLabel, feeLabel, periodLabel, dateLabel, billingTitle, fNLabel, lNLabel, cLabel, pcLabel, creditTitle, ccnLabel, expLabel, expDivideLabel, cvvLabel; 
    private JFrame fMgr, fLlrd;

    public FeesView(boolean isMgrPlaceholder) {

        // creation of JFrames of certain size for Manager and Landlord User Types
        fMgr = new JFrame("Fees Management Page");
        fLlrd = new JFrame("Fees Payment Page");

        fMgr.setSize(500, 500); fLlrd.setSize(500, 500);
        //fMgr.setDefaultCloseOperation(EXIT_ON_CLOSE); fLlrd.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fMgr.setLayout(null); fLlrd.setLayout(null);// layout set to null

        // creation of JLabels of certain size and position        
        pIDLabel = new JLabel("Property ID:");
        pIDLabel.setBounds(50, 25, 100, 40);
        feeLabel = new JLabel("Amount Owed:");
        feeLabel.setBounds(50, 50, 100, 40);
        periodLabel = new JLabel("Listing Period:");
        periodLabel.setBounds(50, 75, 100, 40);
        dateLabel = new JLabel("To");
        dateLabel.setBounds(285, 75, 395, 40);

        billingTitle = new JLabel("BILLING INFORMATION");
        billingTitle.setBounds(50, 125, 150, 40);
        fNLabel = new JLabel("First Name:");
        fNLabel.setBounds(50, 150, 100, 40);
        lNLabel = new JLabel("Last Name:");
        lNLabel.setBounds(250, 150, 100, 40);
        cLabel = new JLabel("Country:");
        cLabel.setBounds(50, 175, 100, 40);
        pcLabel = new JLabel("Postal Code:");
        pcLabel.setBounds(250, 175, 100, 40);


        creditTitle = new JLabel("CREDIT CARD INFORMATION");
        creditTitle.setBounds(50, 225, 200, 40);
        ccnLabel = new JLabel("CCN:");
        ccnLabel.setBounds(50, 250, 100, 40);
        expLabel = new JLabel("Expiry Date (MM/YY):");
        expLabel.setBounds(200, 250, 150, 40);
        expDivideLabel = new JLabel("/");
        expDivideLabel.setBounds(250, 270, 150, 40);
        cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(350, 250, 100, 40);

        // creation of JTextFields of certain size and position
        pID = new JTextField();
        pID.setBounds(140, 35, 310, 20);
        changeFeeAmount = new JTextField();
        changeFeeAmount.setBounds(140, 60, 310, 20);
        startDate = new JTextField();
        startDate.setBounds(140, 85, 135, 20);
        endDate = new JTextField();
        endDate.setBounds(315, 85, 135, 20);

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
            fMgr.add(feeLabel); fMgr.add(changeFeeAmount); changeFeeAmount.setEditable(true);
            fMgr.add(periodLabel); fMgr.add(startDate); fMgr.add(endDate); startDate.setEditable(true); endDate.setEditable(true);
            fMgr.add(dateLabel);

            fMgr.add(save);

            //fLlrd.setVisible(false);
            //fMgr.setVisible(true);
        }

        else {
            fLlrd.add(pIDLabel); fLlrd.add(pID);
            fLlrd.add(feeLabel); fLlrd.add(changeFeeAmount); changeFeeAmount.setEditable(false);
            fLlrd.add(periodLabel); fLlrd.add(startDate); fLlrd.add(endDate); startDate.setEditable(false); endDate.setEditable(false);
            fLlrd.add(dateLabel);

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

    // public static void main(String [] args)
    // {

    //     new FeesView(false).turnOnForLanLord();
        
    // }

    // sets frame for landlord user type to appear
    public void turnOnForLandlord()
    {
        fLlrd.setVisible(true);
    }   

    // sets frame for manager user type to appear
    public void turnOnForManager()
    {
        fMgr.setVisible(true);
    }  

    // returns input for property ID
    public String getPID() {
        return pID.getText();
    }

    // returns input for amount owed
    public String getFee() {
        return changeFeeAmount.getText();
    }

    // sets value for amount owed
    public void setFee(String amount) {
        changeFeeAmount.setText(amount);
    }

    // returns input for start date
    public String getStart() {
        return startDate.getText();
    }

    // sets value for start date
    public void setStart(String sD) {
        startDate.setText(sD);
    }

    // returns input for end date
    public String getEnd() {
        return endDate.getText();
    }

    // sets value for end date
    public void setEnd(String eD) {
        endDate.setText(eD);
    }

    // returns input for first name
    public String getFName() {
        return fName.getText();
    }

    // returns input for last name
    public String getLName() {
        return lName.getText();
    }

    // returns input for country
    public String getCountry() {
        return country.getText();
    }
    
    // returns input for postal code
    public String getPCode() {
        return postalCode.getText();
    }

    // returns input for credit card number
    public String getCCN() {
        return ccn.getText();
    }

    // returns input for month of expiry date
    public String getMMExp() {
        return mmExp.getText();
    }

    // returns input for year of expiry date
    public String getYYExp() {
        return yyExp.getText();
    }

    // returns input for CVV
    public String getCVV() {
        return cvv.getText();
    }
}
