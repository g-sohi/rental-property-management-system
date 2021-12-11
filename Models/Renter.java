package Models;

/**
 * @author Curtis Silva <a href="mailto:curtis.silva@ucalgary.ca">
 *         curtis.silva@ucalgary.ca</a>
 * 
 * @author Gurpartap Sohi <a href="mailto:gurpartap.sohi@ucalgary.ca">
 *         gurpartap.sohi@ucalgary.ca</a>
 * 
 * @author Ivan Suyat<a href="mailto:ivan.suyat@ucalgary.ca">
 *         ivan.suyat@ucalgary.ca/a>
 * 
 * @author Manpreet Singh<a href="mailto:manpreet.singh2@ucalgary.ca">
 *         manpreet.singh2@ucalgary.ca</a>
 * 
 */

import java.util.ArrayList;

public class Renter extends User{
    private boolean isRegistered;
    private ArrayList<Property> favouriteProperties;
    private Property preferredProperty;
    private Email email;

    
  /**
     * Constructor for the Renter class
     */
    public Renter(){
        super();
        this.favouriteProperties = new ArrayList<Property>();
        this.preferredProperty = new Property();

    }

    public Renter(String username,String fName, String lName, int id, String password, String userType ,boolean isRegistered, Property preferredProperty, Email email){
        super(username, fName, lName, id, password, userType);
        this.favouriteProperties = new ArrayList<Property>();
        this.isRegistered = isRegistered;
        this.preferredProperty = preferredProperty;
        this.email = email;
    }

    public Renter(User u){
        super(u);
        favouriteProperties = new ArrayList<Property>();
        this.isRegistered = true;
        this.preferredProperty = new Property();
        this.email = new Email();
    }

    public boolean getIsRegistered()            //getter method for the isRegistered  
    {
        return this.isRegistered;
    }

    public void setIsRegistered(boolean isRegistered)       //setter method for the isRegistered
    {
        this.isRegistered = isRegistered;
    }

    public void addProperty(Property p)         //add a property
    {
        favouriteProperties.add(p);
    }

    public void removeProperty(Property p)   //remove a property
    {
        favouriteProperties.remove(p);
    }

    public Property getPreferredProperty()      //getter method for the preferredProperty   
    {
        return this.preferredProperty;
    }

    public void setPreferredProperty(Property preferredProperty) //setter method for the preferredProperty
    {
        this.preferredProperty = preferredProperty;
    }

    public Email getEmail()                 //getter method for the email   
    {
        return this.email;
    }

    public void setEmail(Email email)    //setter method for the email
    {
        this.email = email;
    }
    public void updateFavourite(){

    }

    public void createRenter(){
        
    }
}
