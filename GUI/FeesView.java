package GUI;

import javax.swing.*;
import java.awt.event.*;

import Models.*;

public class FeesView extends JFrame {
    
    // variable declaration
    private JTextField changeFeeAmount, pID, fName, lName, country, postalCode, ccn, mmExp, yyExp, cvv;
    private JButton save, payFees;
    private JLabel pIDLabel, feeLabel, periodLabel, dateLabel, billingTitle, fNLabel, lNLabel, cLabel, pcLabel, creditTitle, ccnLabel, expLabel, expDivideLabel, cvvLabel; 
    private JFrame fMgr, fLlrd;
    private JComboBox startDay;
    private JComboBox startMonth;
    private JComboBox startYear;
    private JComboBox endDay;
    private JComboBox endMonth;
    private JComboBox endYear;

    public FeesView(boolean isMgrPlaceholder) {

        // creation of JFrames of certain size for Manager and Landlord User Types
        fMgr = new JFrame("Fees Management Page");
        fLlrd = new JFrame("Fees Payment Page");

        fMgr.setSize(500, 500); fLlrd.setSize(500, 500);
        //fMgr.setDefaultCloseOperation(EXIT_ON_CLOSE); fLlrd.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fMgr.setLayout(null); fLlrd.setLayout(null);// layout set to null
        String days_list[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        String months_list[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String year_list[] = {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" };
        startDay = new JComboBox<>(days_list);
        startMonth = new JComboBox<>(months_list);
        startYear = new JComboBox<>(year_list);

        endDay = new JComboBox<>(days_list);
        endMonth = new JComboBox<>(months_list);
        endYear = new JComboBox<>(year_list);
        // creation of JLabels of certain size and position        
        pIDLabel = new JLabel("Property ID:");
        pIDLabel.setBounds(50, 25, 100, 40);
        feeLabel = new JLabel("Amount Owed:");
        feeLabel.setBounds(50, 50, 100, 40);
        periodLabel = new JLabel("Listing Period:");
        periodLabel.setBounds(50, 75, 100, 40);
        dateLabel = new JLabel("To:");
        dateLabel.setBounds(50, 115, 395, 40);

        billingTitle = new JLabel("BILLING INFORMATION");
        billingTitle.setBounds(50, 165, 150, 40);
        fNLabel = new JLabel("First Name:");
        fNLabel.setBounds(50, 190, 100, 40);
        lNLabel = new JLabel("Last Name:");
        lNLabel.setBounds(250, 190, 100, 40);
        cLabel = new JLabel("Country:");
        cLabel.setBounds(50, 215, 100, 40);
        pcLabel = new JLabel("Postal Code:");
        pcLabel.setBounds(250, 215, 100, 40);


        creditTitle = new JLabel("CREDIT CARD INFORMATION");
        creditTitle.setBounds(50, 265, 200, 40);
        ccnLabel = new JLabel("CCN:");
        ccnLabel.setBounds(50, 290, 100, 40);
        expLabel = new JLabel("Expiry Date (MM/YY):");
        expLabel.setBounds(200, 290, 150, 40);
        expDivideLabel = new JLabel("/");
        expDivideLabel.setBounds(250, 310, 150, 40);
        cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(350, 290, 100, 40);

        // creation of JTextFields of certain size and position
        pID = new JTextField();
        pID.setBounds(145, 35, 310, 20);
        changeFeeAmount = new JTextField();
        changeFeeAmount.setBounds(145, 60, 310, 20);
        
        startDay.setBounds(140, 85, 70, 20);
        JLabel slash1 = new JLabel("/");
        slash1.setBounds(215, 85, 10, 20);

        endDay.setBounds(140, 125, 70, 20);
        JLabel slash2 = new JLabel("/");
        slash2.setBounds(215, 125, 10, 20);

        startMonth.setBounds(230, 85, 120, 20);
        JLabel slash3 = new JLabel("/");
        slash3.setBounds(355, 85, 10, 20);

        endMonth.setBounds(230, 125, 120, 20);
        JLabel slash4 = new JLabel("/");
        slash4.setBounds(355, 125, 10, 20);

        startYear.setBounds(370, 85, 90, 20);
        endYear.setBounds(370, 125, 90, 20);


        fName = new JTextField();
        fName.setBounds(140, 200, 85, 20);
        lName = new JTextField();
        lName.setBounds(340, 200, 85, 20);
        country = new JTextField();
        country.setBounds(140, 225, 85, 20);
        postalCode = new JTextField();
        postalCode.setBounds(340, 225, 85, 20);

        ccn = new JTextField();
        ccn.setBounds(50, 320, 125, 20);
        mmExp = new JTextField();
        mmExp.setBounds(200, 320, 40, 20);
        yyExp = new JTextField();
        yyExp.setBounds(265, 320, 40, 20);
        cvv = new JTextField();
        cvv.setBounds(350, 320, 40, 20);

        // creation of JButtons of certain size and position
        save = new JButton("Apply Changes");
        save.setBounds(175, 410, 150, 40);
        payFees = new JButton("Confirm Payment");
        payFees.setBounds(175, 410, 150, 40);

        // add components to JFrames dependent on User Type
        if(isMgrPlaceholder) {
            fMgr.add(pIDLabel); fMgr.add(pID);
            fMgr.add(feeLabel); fMgr.add(changeFeeAmount); changeFeeAmount.setEditable(true);
            fMgr.add(periodLabel); 
            
            fMgr.add(startDay);
            fMgr.add(endDay); 
            fMgr.add(startMonth);
            fMgr.add(endMonth); 
            fMgr.add(startYear);
            fMgr.add(endYear); 

            fMgr.add(slash1);
            fMgr.add(slash2);
            fMgr.add(slash3);
            fMgr.add(slash4);

            fMgr.add(dateLabel);

            fMgr.add(save);

            //fLlrd.setVisible(false);
            //fMgr.setVisible(true);
        }

        else {
            fLlrd.add(pIDLabel); fLlrd.add(pID);
            fLlrd.add(feeLabel); fLlrd.add(changeFeeAmount); changeFeeAmount.setEditable(false);
            fLlrd.add(periodLabel); 
            
            fLlrd.add(startDay);
            fLlrd.add(endDay); 
            fLlrd.add(startMonth);
            fLlrd.add(endMonth); 
            fLlrd.add(startYear);
            fLlrd.add(endYear); 

            fLlrd.add(slash1);
            fLlrd.add(slash2);
            fLlrd.add(slash3);
            fLlrd.add(slash4);
            
            
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

    public void destroyFrameForLandlord()
    {
        fLlrd.setVisible(false);
    }   

    // sets frame for manager user type to appear
    public void turnOnForManager()
    {
        fMgr.setVisible(true);
    }  

    public JButton getPayFeesButton()
    {
        return payFees;
    }

    public void destroyFrameForManager()
    {
        fMgr.setVisible(false);
    }

    public JButton getSaveButton()
    {
        return save;
    }

    public void addPayFeeListener(ActionListener listenForPayFee){
        System.out.println("DONE1");
        this.payFees.addActionListener(listenForPayFee);
    }

    public void addSaveListener(ActionListener listenForSave){
        System.out.println("DONE1");
        this.save.addActionListener(listenForSave);
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

    public String getStartDayInput()
    {
        return startDay.getSelectedItem().toString();
    }

    public String getStartMonthInput()
    {
        return startMonth.getSelectedItem().toString();
    }
    public String getStartYearInput()
    {
        return startYear.getSelectedItem().toString();
    }
    public String getEndDayInput()
    {
        return endDay.getSelectedItem().toString();
    }

    public String getEndMonthInput()
    {
        return endMonth.getSelectedItem().toString();
    }
    public String getEndYearInput()
    {
        return endYear.getSelectedItem().toString();
    }
    // // returns input for start date
    // public String getStart() {
    //     return startDate.getText();
    // }

    // // sets value for start date
    // public void setStart(String sD) {
    //     startDate.setText(sD);
    // }

    // // returns input for end date
    // public String getEnd() {
    //     return endDate.getText();
    // }

    // // sets value for end date
    // public void setEnd(String eD) {
    //     endDate.setText(eD);
    // }

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
    public static void main(String [] args) {
        FeesView test =  new FeesView(false);
        test.turnOnForLandlord();
        //test.turnOnForManager();
    }
}
