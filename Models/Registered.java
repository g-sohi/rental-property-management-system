package Models;

public class Registered extends Renter{
    private boolean isSubscribed;
    
    /**
     * Constructor for the Registered class
     * ******
     */
    public Registered(){
        super();
        this.isSubscribed = false;
    }

    public Registered(String username,String fName, String lName, int id, String password, String userType ,boolean isRegistered, Property preferredProperty, Email email,boolean isSubscribed){
        super(username, fName, lName, id, password, userType, isRegistered, preferredProperty, email);
        this.isSubscribed = isSubscribed;
    }
}
