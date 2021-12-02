package Controller;
import Models.*;
import GUI.*;
import Database.*;

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
        this.landlordV = new LandlordView();
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
    public void setLandLordView(LandlordView ldView){
        this.landlordV = ldView;
    }

    //getter for payment controller
    public PaymentController getPaymentController(){
        return this.pay;
    }

    //setter for payment controller
    public void setPaymentController(PaymentController payC){
        this.pay = payC;
    }

    //getter for property controller
    public PropertyController getPropertyController(){
        return this.prop;
    }

    //setter for property controller
    public void setPropertyController(PropertyController propC){
        this.prop = propC;
    }

    //getter for register controller
    public RegisterController getRegisterController(){
        return this.regProp;
    }

    //setter for register controller
    public void setRegisterController(RegisterController regC){
        this.regProp = regC;
    }
}
