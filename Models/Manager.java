package Models;

public class Manager extends User{
    private int managerCode;

    /**
     * Constructor for the Manager class
     */
    public Manager(){
        super();
        this.managerCode = -1;
    }

    public Manager(String username,String fName, String lName, int id, String password, String userType ,int managerCode){
        super(username, fName, lName, id, password, userType);
        this.managerCode = managerCode;

    }

    public Manager(User u){
        super(u);
        this.managerCode = this.getId();
    }

    public int getManagerCode()                 //getter method for the ManagerCode
    {
        return this.managerCode;
    }

    
    public void setManagerCode(int managerCode) //setter method for the ManagerCode
    {
        this.managerCode = managerCode;
    }
}
