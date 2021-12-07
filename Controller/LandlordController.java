package Controller;

import Models.*;
import GUI.*;

//Landlord Controller
public class LandlordController {
    private Landlord landlord;
    private LandlordView landlordV;
    private PaymentController pay;
    private PropertyController prop;
    private RegisterController regProp;

    //Default constructor to create instances of member variables
    LandlordController(){
        this.landlord = new Landlord();
        this.pay = new PaymentController();
        this.prop = new PropertyController();
        this.regProp = new RegisterController();
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

    public void enableView()
    {
        landlordV = new LandlordView();
    }
}