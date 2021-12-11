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

public class Address {
    private int streetNo;
    private String streetName;
    private String city;
    private String postalCode;
    private String quadrant;
    private int aptNo;

    /**
     * Constructor for the Address class
     */
    public Address(){
        this.streetNo = 0;
        this.streetName = "";
        this.city = "";
        this.postalCode = "";
        this.quadrant = "";
        this.aptNo = 0;
    }

    public Address(int streetNo, String streetName, String city, String postalCode, String quadrant,int aptNo )
    {
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.quadrant = quadrant;
        this.aptNo = aptNo;
        
    }

    public int getStreetNo()                    //getter method for the streetNo
    {
        return this.streetNo;
    }

    public void setStreetNo(int streetNo)       //setter method for the streetNo
    {
        this.streetNo = streetNo;
    }

    public String getStreetName()               //getter method for the streetName
    {
        return this.streetName;
    }

    public void setStreetName(String streetName)    //setter method for the streetName
    {
        this.streetName = streetName;
    }

    public String getCity()                     //getter method for the city   
    {
        return this.city;
    }

    public void setCity(String city)            //setter method for the city
    {
        this.city = city;
    }
    public String getPostalCode()               //getter method for the postalCode
    {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode)    //setter method for the postalCode
    {
        this.postalCode = postalCode;
    }
    
    public String getQuadrant()                 //getter method for the quadrant
    {
        return this.quadrant;
    }

    public void setQuadrant(String quadrant)    //setter method for the quadrant
    {
        this.quadrant = quadrant;
    }
    public int getAptNo()                       //getter method for the aptNo
    {
        return this.aptNo;
    }

    public void setAptNo(int aptNo)             //setter method for the aptNo
    {
        this.aptNo = aptNo;
    }
    
}