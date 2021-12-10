package Controller;

import Models.*;
import GUI.*;
import Database.*;

import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class PaymentController implements ActionListener {
    
    private FeesView fees;
    private Fees fee;
    private Database db;
    private LandlordController landlord;
    private ManagerController manager;
  
    public PaymentController(Database db) {
        this.db = db;

    }


    public void updateFees(int fee) {
        
    }

    public void payFees() {
        
    }

    public ManagerController getManager() {
        return manager;
    }
    public FeesView getFeesView() {
        return fees;
    }
    public void setFees(FeesView fees) {
        this.fees = fees;
    }
    public Fees getFee() {
        return fee;
    }
    public void setFee(Fees fee) {
        this.fee = fee;
    }
    public Database getDb() {
        return db;
    }
    public void setDb(Database db) {
        this.db = db;
    }
    public LandlordController getLandlord() {
        return landlord;
    }
    public void setLandlord(LandlordController landlord) {
        this.landlord = landlord;
    }
    public void setManager(ManagerController manager) {
        this.manager = manager;
    }

    public void enableView(boolean isMgrPlaceholder) {
        fees = new FeesView(isMgrPlaceholder); 
        fees.addPayFeeListener(this);
        fees.addSaveListener(this);
        fees.addSelectListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.fees != null)
        {
            db.initializeConnection();
        if(!fees.getPID().equals(""))
        {
        if(e.getSource().equals(fees.getPayFeesButton()))
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
                LocalDateTime current = LocalDateTime.now();
                LocalDateTime end = current.plusMonths(db.getPeriod(Integer.valueOf(fees.getPID())));
                db.updatePaidProperty(Integer.valueOf(fees.getPID()), dtf.format(current).toString(), dtf.format(end).toString());
                db.updateFeeStatus(Integer.valueOf(fees.getPID()));

                System.out.println("Payment Done");
                //fees.destroyFrameForLandlord();
            }
        }
        if(!fees.getFee().equals("") && !fees.getPID().equals("")) 
        {
        if(e.getSource().equals(fees.getSaveButton()))
            {
                //String startDate = fees.getStartYearInput() + "-"+fees.getStartMonthInput()+"-"+ fees.getStartDayInput();
                //String endDate = fees.getEndYearInput() + "-"+fees.getEndMonthInput()+"-"+ fees.getEndDayInput();
                String periodString = fees.getPeriod().substring(0, fees.getPeriod().indexOf(' '));
                int period = Integer.valueOf(periodString);
                db.updatePeriodStatus(Integer.valueOf(fees.getPID()), Double.valueOf(fees.getFee()), period);
                System.out.println("Fee period updated");
                //fees.destroyFrameForManager();
            }
        }

        if(e.getSource().equals(fees.getSelectButton()))
        {
            fees.setFee(String.valueOf(db.getFees(Integer.valueOf(fees.getPID()))));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
            LocalDateTime current = LocalDateTime.now();
            String line = dtf.format(current).toString();
            String day = line.substring(line.indexOf('-') + 4, line.indexOf('-')+6);
            String month = line.substring(line.indexOf('-') + 1, line.indexOf('-') + 3);
            String year = line.substring(0, line.indexOf('-'));
            fees.setStartD(day);
            fees.setStartM(month);
            fees.setStartY(year);
            System.out.println(line);
            LocalDateTime end = current.plusMonths(db.getPeriod(Integer.valueOf(fees.getPID())));
            line = dtf.format(end).toString();
            day = line.substring(line.indexOf('-') + 4, line.indexOf('-')+6);
            month = line.substring(line.indexOf('-') + 1, line.indexOf('-') + 3);
            year = line.substring(0, line.indexOf('-'));
            fees.setEndD(day);
            fees.setEndM(month);
            fees.setEndY(year);
        }
        
        }  
    }
}
