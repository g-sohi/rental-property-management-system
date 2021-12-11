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

public class Report {
    private int totalHouseListed;
    private int totalHouseRented;
    private int totalActiveListing;
    private ArrayList<Property> rented;
    private String startDate;
    private String endDate;

    
    /**
     * Constructor for the Report class
     */
    public Report(){
        this.totalHouseListed = 0;
        this.totalHouseRented = 0;
        this.totalActiveListing  = 0;
        this.startDate = "";
        this.endDate = "";
        this.rented = new ArrayList<Property>();
    }

    public Report(int totalHouseListed, int totalHouseRented, int totalActiveListing , String startDate, String endDate, ArrayList<Property> rented){
        this.totalHouseListed = totalHouseRented;
        this.totalHouseRented = totalHouseRented;
        this.totalActiveListing  = totalActiveListing;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rented = new ArrayList<Property>();
        this.rented.forEach(x->this.rented.add(x));
    }

    public int getTotalHouseListed()             //getter method for the totalHouseListed 
    {
        return this.totalHouseListed;
    }

    public void setTotalHouseListed(int totalHouseListed)    //setter method for the totalHouseListed
    {
        this.totalHouseListed = totalHouseListed;
    }

    public int getTotalHouseRented()             //getter method for the totalHouseRented 
    {
        return this.totalHouseRented;
    }

    public void setTotalHouseRented(int totalHouseRented)    //setter method for the totalHouseRented
    {
        this.totalHouseRented = totalHouseRented;
    }

    public int getTotalActiveListing()           //getter method for the totalActiveListing 
    {
        return this.totalActiveListing;
    }

    public void setTotalActiveListing(int totalActiveListing)    //setter method for the totalActiveListing
    {
        this.totalActiveListing = totalActiveListing;
    }

    public String getStartDate()  //getter method for the startDate 
    {
        return this.startDate;
    }

    public void setStartDate(String startDate)       //setter method for the startDate
    {
        this.startDate = startDate;
    }

    public String getEndDate()     //getter method for the endDate 
    {
        return this.endDate;
    }

    public void setEndDate(String endDate)       //setter method for the endDate
    {
        this.endDate = endDate;
    }
}
