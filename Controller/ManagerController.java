package Controller;
import Models.*;
import GUI.*;
import Database.*;

import java.util.*;
import java.awt.event.*;
import java.time.LocalDate;

public class ManagerController implements ActionListener, ItemListener {
    private Manager manager;
    private ManagerView managerv;
    private SummaryReportView report;
    private ViewDataPage viewInfo;
    private PropertyController prop;
    private PaymentController pay;
    private Report reportR;
    private Database db;
    private SearchController search;

    //Default ManagerController constructor
    public ManagerController(){
        this.manager = new Manager();
        this.prop = new PropertyController();
        this.pay = new PaymentController();
        this.reportR = new Report();
        this.search = new SearchController();
    }

    //ManagerController connection with database
    public ManagerController(Database db){
        this.db = db;
        this.prop = new PropertyController(db);
        this.search = new SearchController(db);
        this.pay = new PaymentController(db);

    }

    //Handle events for manager main page 
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(managerv.getSearch())) //manager clicks search button
    {
        managerv.destroyFrame();
        search.enableMGrView();
        search.getView().addBackButtonListener(this);
    }

    if(e.getSource().equals(managerv.getUpdateButton())) //manager clicks update button
    {
        managerv.destroyFrame();
        prop.enableView();
        prop.getEditView().turnOn();
        prop.getEditView().addBackListener(this);
        prop.getEditView().addSaveListener(this);
    }

    if(e.getSource().equals(managerv.getReportButton())) //manager clicks get report button
    {
        managerv.destroyFrame();
        report = new SummaryReportView();
        report.addItemListener(this);
        report.turnOn();
        report.addCloseListener(this);
    }

    if(e.getSource().equals(managerv.getViewDataButton())) //manager clicks view data button
    {
        managerv.destroyFrame();
        viewInfo = new ViewDataPage();
        viewInfo.turnOn();
        viewInfo.addRenterInfoListener(this);
        viewInfo.addLandlordInfoListener(this);
        viewInfo.addPropertyInfoListener(this);
        viewInfo.addBackListener(this);

    }

    if(e.getSource().equals(managerv.getEditFeeButton())) //manager clicks edit fee button
    {
        managerv.destroyFrame();
        pay.enableView(true);
        pay.getFeesView().turnOnForManager();
        pay.getFeesView().addBackListener(this);
        pay.getFeesView().addSaveListener(this);
    }

    if(pay.getFeesView() != null)
    {
        if(e.getSource().equals(pay.getFeesView().getBackButton())) //manager clicks back button in edit fees view
        {
            pay.getFeesView().destroyFrameForManager();
            managerv.turnOn();
        }
        if(e.getSource().equals(pay.getFeesView().getSaveButton())) //manager clicks save in edit fees view
        {
            if(!pay.getFeesView().getPID().equals("") && !pay.getFeesView().getFee().equals("")) //empty field
            {
                 pay.getFeesView().showDialogManager();
                pay.getFeesView().destroyFrameForManager();
                managerv.turnOn();
            }
            else
            {
                pay.getFeesView().showErrorDialogManager();
            }
        }
    }
    if(this.report != null)
    {
    if(e.getSource().equals(report.getCloseButton())) //manager clicks close 
    {
        report.destroyFrame();
        managerv.turnOn();
    }
    }

    if(prop.getEditView() != null)
    {
        if(e.getSource().equals(prop.getEditView().getSaveButton())) //manager clicks save in edit property view
        {
            prop.getEditView().destroyFrame();
            managerv.turnOn();
        }
    }

    if(this.search.getView() != null)
    {
        if(e.getSource().equals(search.getView().getBackButton())) //manager clicks back in search view 
        {
            search.getView().destroyFrameForManager();
            managerv.turnOn();
        }
    }

    if(this.viewInfo != null)
    {
        if(e.getSource().equals(viewInfo.getRenterInfoButton())) //manager requests renter info
        {
            viewInfo.user(viewInfo.copyRenters(db.getAllRenters()));
        }
        else if(e.getSource().equals(viewInfo.getLandlordInfoButton())) //manager requests landlord info
        {
            viewInfo.user(viewInfo.copyLandlords(db.getAllLandlords()));
        }
        else if(e.getSource().equals(viewInfo.getPropertyInfoButton())) //manager requests property info
        {
            viewInfo.prop(viewInfo.copyProperties(db.getManagerProperties())); 
        }
        else if(e.getSource().equals(viewInfo.getBackButton())) //manager goes back
        {
            viewInfo.destroyFrame();
            managerv.turnOn();
        }
    }
        
    }
    
    //getters and setters
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public ManagerView getManagerv() {
        return managerv;
    }


    public void setManagerv(ManagerView managerv) {
        this.managerv = managerv;
    }


    public SummaryReportView getReport() {
        return report;
    }


    public void setReport(SummaryReportView report) {
        this.report = report;
    }


    public ViewDataPage getViewInfo() {
        return viewInfo;
    }


    public void setViewInfo(ViewDataPage viewInfo) {
        this.viewInfo = viewInfo;
    }


    public PropertyController getProp() {
        return prop;
    }
    public void setProp(PropertyController prop) {
        this.prop = prop;
    }
    public PaymentController getPay() {
        return pay;
    }
    public void setPay(PaymentController pay) {
        this.pay = pay;
    }
    public Report getReportR() {
        return reportR;
    }

    public void setReportR(Report reportR) {
        this.reportR = reportR;
    }

    public Database getDb() {
        return db;
    }
    
    public void setDb(Database db) {
        this.db = db;
    }
    
    public ManagerView getView()
    {
        return managerv;
    }

    public SearchController getSearch(){
        return this.search;
    }

    //enable mananger main page
    public void enableView(ActionListener logoutListener, int id,  String type)
    {
        managerv = new ManagerView();
        prop = new PropertyController(db, id, type);
        this.managerv.addLogoutListener(logoutListener);
        this.managerv.addSearchListener(this);
        this.managerv.addUpdateListener(this);
        this.managerv.addReportListener(this);
        this.managerv.addFeesListener(this);
        this.managerv.addViewListener(this);
    }


    //Copy properties from array list to 2d array to be displayed in table
    public String[][] copyProperties(ArrayList<Property> properties){
        String[][] props = new String[properties.size()][3];
        for(int i = 0; i < properties.size(); i++){
        System.out.println("propID: " +properties.get(i).getID());
        System.out.println("LandID: " +properties.get(i).getLandlordID());
        props[i][0] = db.getLandlordName(properties.get(i).getLandlordID());
        props[i][1] = String.valueOf(properties.get(i).getID());
        props[i][2] = properties.get(i).getAddress();
        }
        return props;
    }

    //Period is selected in summary report view
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(e.getSource().equals(report.getPeriodSelect())){
                String line = report.getPeriodSelect().getSelectedItem().toString();
                String month = line.substring(0, line.indexOf('/'));
                String year = line.substring(line.indexOf('/') + 1);
                LocalDate date = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), 01);
                int days = date.lengthOfMonth();
                String start = "20" + year + "-" + month + "-" + "01";
                String end = "20" + year + "-" + month + "-" + String.valueOf(days);
                db.initializeConnection();
                report.setNumListed(String.valueOf(db.countListings("Listed", start, end)));
                report.setNumActive(String.valueOf(db.countListings("Active", start, end)));
                report.setNumRented(String.valueOf(db.countListings("Rented", start, end)));
                report.setTableData(copyProperties(db.getRentedProperties(start, end)));
                
            }
        }
        
    }

   
}
