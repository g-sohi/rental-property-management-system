package Models;

public class User {
    private String username;
    private String fName;
    private String lName;
    private int id;
    private String password;
    private String userType;

     
    /**
     * Constructor for the User class
     */
    public User()
    {
        this.username = "";
        this.fName = "arr";
        this.lName = "ss";
        this.id = -1222;
        this.password = "";
        this.userType = "none";
    }
    public User(String username,String fName, String lName, int id, String password, String userType ){
        this.username = username;
        this.fName = fName;
        this.lName =lName;
        this.id = id;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername()                     //getter method for the username   
    {
        return this.username;
    }

    public void setUsername(String username)        //setter method for the username
    {
        this.username = username;
    }

    public String getFName()                //getter method for the fName  
    {
        return this.fName;
    }

    public void setFName(String fName)      //setter method for the fName
    {
        this.fName = fName;
    }

    
    public String getLName()            //getter method for the lName  
    {
        return this.lName;
    }

    public void setLName(String lName)      //setter method for the lName
    {
        this.lName = lName;
    }

    public int getId()              //getter method for the id  
    {
        return this.id;
    }

    public void setId(int id)       //setter method for the id
    {
        this.id = id;
    }

    public String getPassword()     //getter method for the password  
    {
        return this.password;
    }

    public void setPassword(String password)        //setter method for the password
    {
        this.password = password;
    }

    public String getUserType()     //getter method for the userType  
    {
        return this.userType;
    }

    public void setUserType(String userType)        //setter method for the userType
    {
        this.userType = userType;
    }


}

