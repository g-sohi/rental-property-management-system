package Models;
import java.util.ArrayList;

public class Landlord extends User{
    private Email email;
    private ArrayList<Property> properties;
    
    /**
     * Constructor for the Landlord class
     */
    public Landlord(Email email){
        this.email = email;
        this.properties = new ArrayList<Property>();
    }

    public Email getEmail()              //getter method for the email  
    {
        return email;
    }

    public void setEmail(Email email)      //setter method for the email
    {
        this.email = email; 
    }

    public void addProperty(Property p)         //add a property
    {
        properties.add(p);
    }

    public void removeProperty(Property p)   //remove a property
    {
        properties.remove(p);
    }
}
