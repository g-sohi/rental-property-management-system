package Controller;
import Models.*;
import GUI.*;
import Database.*;
import java.awt.event.*;

public class ManagerController implements ActionListener {
    private Manager manager;
    private ManagerView managerv;
    private SummaryReportView report;
    private ViewDataPage viewInfo;
    private PropertyController prop;
    private PaymentController pay;
    private Report reportR;
    private Database db;
    private SearchController search;

    public ManagerController(Database db){

        search = new SearchController(db);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(managerv.getSearch()))
    {
        System.out.println("COMPLETE");
        managerv.destroyFrame();
        search.enableView();
        search.getView().turnOn();
    }
        
    }

    public void update()
    {

    }

    public void retrieveReport()
    {

    }

    public void retrieveRenter()
    {

    }

    public void retrieveLandlord()
    {

    }

    public void retrieveProperties()
    {

    }
    
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

    public void enableView(ActionListener logoutListener)
    {
        managerv = new ManagerView();
        this.managerv.addLogoutListener(logoutListener);
        this.managerv.addSearchListener(this);
    }

   
}
