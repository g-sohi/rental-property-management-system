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
