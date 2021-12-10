package Controller;

import Models.*;
import GUI.*;
import Database.Database;

import java.awt.event.*;

//Landlord Controller
public class LandlordController implements ActionListener{
    private Landlord landlord;
    private LandlordView landlordV;
    private PaymentController pay;
    private PropertyController prop;
    private RegisterController regProp;
    private SearchController search;
    private int Id;
    private Database db;


    //Default constructor to create instances of member variables
    LandlordController(Database db){
        //this.landLordID =  landID;
        this.db = db;
        this.landlord = new Landlord();
        this.pay = new PaymentController(db);
        this.prop = new PropertyController(db);
        this.regProp = new RegisterController(db);
        this.search = new SearchController(db);
    }

    LandlordController()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(landlordV.getSearch()))
        {
            System.out.println("Search");
            landlordV.destroyFrame();
            search.enableLlrdView();
            search.getView().addBackButtonListener(this);
        }

        if(e.getSource().equals(landlordV.getRegister()))
        {
            System.out.println("Register");
            landlordV.destroyFrame();
            regProp.enableView(this.landlordV);
            this.regProp.getCreateProp().addBackPropertyListener(this);
        }

        if(e.getSource().equals(landlordV.getUpdate()))
        {
            System.out.println("Update");
            landlordV.destroyFrame();
            prop.enableView();
            prop.getEditView().turnOn();
            prop.getEditView().addBackListener(this);
            prop.getEditView().addSaveListener(this);
        }

        if(e.getSource().equals(landlordV.getPay()))
        {
            System.out.println("Pay");
            landlordV.destroyFrame();
            pay.enableView(false);
            pay.getFeesView().turnOnForLandlord();
            pay.getFeesView().addBackListener(this);
            pay.getFeesView().addPayFeeListener(this);
        }
        if(regProp.getCreateProp() != null)
        {
        if(e.getSource().equals(regProp.getCreateProp().getBack()))
        {
            regProp.getCreateProp().destroyFrame();
            landlordV.turnOn();
        }
        }

        if(prop.getEditView() != null)
        {
            if(e.getSource().equals(prop.getEditView().getBackButton()))
            {
                
                prop.getEditView().destroyFrame();
                landlordV.turnOn();
            }
        }

        if(prop.getEditView() != null)
        {
            if(e.getSource().equals(prop.getEditView().getSaveButton()))
            {
                if(!prop.getEditView().getPropertyIDStringInput().equals(""))
                {
                prop.getEditView().showDialog();
                prop.getEditView().destroyFrame();
                landlordV.turnOn();
                }
                else{
                    prop.getEditView().showErrorDialog();
                }
            }
        }

        if(pay.getFeesView() != null)
        {
            if(e.getSource().equals(pay.getFeesView().getBackButton()))
            {
                pay.getFeesView().destroyFrameForLandlord();
                landlordV.turnOn();
            }
        }

        if(pay.getFeesView() != null)
        {
            if(e.getSource().equals(pay.getFeesView().getPayFeesButton()))
            {
                pay.getFeesView().destroyFrameForLandlord();
                landlordV.turnOn();
            }
        }

        if(search.getView() != null)
        {
            if(e.getSource().equals(search.getView().getBackButton()))
            {
                search.getView().destroyFrameForLandLord();
                landlordV.turnOn();
            }
        }
    }
    public void setRegisterControllerId(int id)
    {
        this.regProp.setLandlordID(id);
    }

    public void setSearchControllerID(int id)
    {
        this.search.setLandlordID(id);
    }
    
    //update 
    public void update(){

    }

    //getter for landlord
    public Landlord getLandlord(){
        return this.landlord;
    }

    //setter for landlord
    public void setLandlord(Landlord ld){
        this.landlord = ld;
    }

    //getter for landlord view 
    public LandlordView getLandlordView(){
        return this.landlordV;
    }
    
    //setter for landlord view
    public void setLandLordV(LandlordView ldView){
        this.landlordV = ldView;
    }

    //getter for payment controller
    public PaymentController getPay(){
        return this.pay;
    }

    //setter for payment controller
    public void setPay(PaymentController payC){
        this.pay = payC;
    }

    //getter for property controller
    public PropertyController getProp(){
        return this.prop;
    }

    //setter for property controller
    public void setProp(PropertyController propC){
        this.prop = propC;
    }

    //getter for register controller
    public RegisterController getRegProp(){
        return this.regProp;
    }

    //setter for register controller
    public void setRegProp(RegisterController regC){
        this.regProp = regC;
    }

    public SearchController getSearch(){
        return this.search;
    }

    public void enableView(ActionListener logoutListener, int id, String type)
    {
        this.Id = id;
        landlordV = new LandlordView();
        prop = new PropertyController(this.db,this.Id, type);
        this.getLandlordView().addLogoutListener(logoutListener);
        this.getLandlordView().addRegisterPropertyListener(this);
        this.getLandlordView().addUpdatePropertyListener(this);
        this.getLandlordView().addPayFeeListener(this);
        this.getLandlordView().addSearchListener(this);
    }
}