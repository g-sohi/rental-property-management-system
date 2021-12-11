package Models;

public class Property {
    //Member varables for the class Property
    private int id;                     //Property ID
    private int landlordID;             //Landlord ID        
    private String address;             //Property Address
    private String type;                //Property type [Detattached, Attached, Town House, Apartment]
    private int numOfBedrooms;          //Number of Bedrooms
    private int numOfBathrooms;         //Number of Bathrooms
    private String furnished;           //Furnished: Yes or No
    private Fees propertyFees;          //Object of Fees for Property fees
    private String propertyStatus;      //Property Status [Active, Rented, Cancelled, Suspeneded]
    private String quadrant;            //Property Quadrant [NW, NE, SW, SE]
    private String rentDate;            //Property Start Rent Date
    private String startDate;           //Property Start Date when it becomes Active
    private String endDate;             //Property End Date when property is removed from the application

    
    /**
     * Constructor for the Property class
     */
    //Default constructor for Property
    public Property()
    {
        //Set all the variables to null, -1 or "".
        this.id = -1;
        this.landlordID = -1;
        this.address = "";
        this.quadrant = "";
        this.type = "";
        this.numOfBathrooms = -1;
        this.numOfBedrooms = -1;
        this.furnished = "";
        this.propertyFees = new Fees();
        this.propertyStatus = "Suspended";
        this.startDate = "";
        this.endDate = "";
        this.rentDate = "";
    }
    
    //Property constructor take in: Landlord ID, Address of property, Quadrant of the City the proerpty is in [NW, NE, SW, SE],
    //the type of the property [Deattached, Attached, Town House, Apartment], the number of bedrooms, the number of bathrooms, 
    //whether or not the property is furnished, a Fees object, and the property status [Active, Rented, Cancelled, Suspended]
    public Property(int landlordID, String address, String quadrant,String type, int numOfBedrooms, int numOfBathrooms, String furnished, Fees propertyFees, String propertyStatus)
    {
        this.id = -1;
        this.landlordID = landlordID;
        this.address = address;
        this.quadrant = quadrant;
        this.type = type;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.furnished = furnished;
        this.propertyFees = propertyFees;
        this.propertyStatus = propertyStatus;
        this.startDate = "";
        this.endDate = "";
        this.rentDate = "";
    }

    //Property constructor take in: Property ID, Landlord ID, Address of property, Quadrant of the City the proerpty is in [NW, NE, SW, SE],
    //the type of the property [Deattached, Attached, Town House, Apartment], the number of bedrooms, the number of bathrooms, 
    //whether or not the property is furnished, a Fees object, and the property status [Active, Rented, Cancelled, Suspended],
    public Property(int id, int landlordID, String address, String quadrant,String type, int numOfBedrooms, int numOfBathrooms, String furnished, Fees propertyFees, String propertyStatus)
    {
        this.id = id;
        this.landlordID = landlordID;
        this.address = address;
        this.quadrant = quadrant;
        this.type = type;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.furnished = furnished;
        this.propertyFees = propertyFees;
        this.propertyStatus = propertyStatus;
        this.startDate = "";
        this.endDate = "";
        this.rentDate = "";
    }

    //Property constructor take in: Property ID, Address of property, Quadrant of the City the proerpty is in [NW, NE, SW, SE],
    //the type of the property [Deattached, Attached, Town House, Apartment], the number of bedrooms, the number of bathrooms, 
    //whether or not the property is furnished, a Fees object, and the property status [Active, Rented, Cancelled, Suspended],
    //the Start date the property became active, end date for property listing, start date for when the property becomes rented
    public Property(int id, String address, String quadrant,String type, int numOfBedrooms, int numOfBathrooms, String furnished, Fees propertyFees, String propertyStatus, String startDate, String endDate, String rentDate)
    {
        this.id = id;
        this.address = address;
        this.quadrant = quadrant;
        this.type = type;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.furnished = furnished;
        this.propertyFees = propertyFees;
        this.propertyStatus = propertyStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentDate = rentDate;
    }

    //Property constructor take in: Property ID, Landlord ID, Address of property, Quadrant of the City the proerpty is in [NW, NE, SW, SE],
    //the type of the property [Deattached, Attached, Town House, Apartment], the number of bedrooms, the number of bathrooms, 
    //whether or not the property is furnished, a Fees object, and the property status [Active, Rented, Cancelled, Suspended],
    //the Start date the property became active, end date for property listing, start date for when the property becomes rented
    public Property(int id, int landlordID, String address, String quadrant,String type, int numOfBedrooms, int numOfBathrooms, String furnished, Fees propertyFees, String propertyStatus, String startDate, String endDate, String rentDate)
    {
        this.id = id;
        this.landlordID = landlordID;
        this.address = address;
        this.quadrant = quadrant;
        this.type = type;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.furnished = furnished;
        this.propertyFees = propertyFees;
        this.propertyStatus = propertyStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentDate = rentDate;
    }
  
    public int getLandlordID()                          //getter method for the id    
    {
        return this.landlordID;
    }

    public void setLandlordID(int id)                   //setter method for the id
    {
        this.landlordID = id;
    }

    public int getID()                          //getter method for the id    
    {
        return this.id;
    }

    public void setID(int id)                   //setter method for the id
    {
        this.id = id;
    }

    public String getAddress()                 //getter method for the address  
    {
        return this.address;
    }

    public void setAddress(String address)     //setter method for the address
    {
        this.address = address;
    }

    public String getQuadrant()                     //getter method for the type  
    {
        return this.quadrant;
    }

    public void getQuadrant(String quadrant)                     //getter method for the type  
    {
        this.quadrant = quadrant;
    }

    public String getType()                     //getter method for the type  
    {
        return this.type;
    }

    public void setType(String type)            //setter method for the type
    {   
        this.type = type;
    }

    public int getNumOfBedrooms()               //getter method for the numOfBedrooms  
    {
        return this.numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) //setter method for the numOfBedrooms
    {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getNumOfBathrooms()              //getter method for the numOfBathrooms  
    {
        return this.numOfBathrooms;
    }

    public void setNumOfBathrooms(int numOfBathrooms)   //setter method for the numOfBathrooms
    {
        this.numOfBathrooms = numOfBathrooms;
    }

    public String getFurnished()               //getter method for the furnished  
    {
        return this.furnished;
    }

    public void setFurnished(String furnished) //setter method for the furnished
    {
        this.furnished = furnished;
    }

    
    public Fees getPropertyFees()               //getter method for the propertyFees  
    {
        return this.propertyFees;
    }

    public void setPropertyFees(Fees propertyFees)  //setter method for the propertyFees
    {
        this.propertyFees = propertyFees;
    }

    public String getPropertyStatus()           //getter method for the propertyStatus  
    {
        return this.propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus)    //setter method for the propertyStatus
    {
        this.propertyStatus = propertyStatus;
    }
    public String getQuadarnt()           //getter method for the quadrant  
    {
        return this.quadrant;
    }

    public void setQuadrant(String quadrant)    //setter method for the quadrant
    {
        this.quadrant = quadrant;
    }

    public String getStartDate()           //getter method for the startDate  
    {
        return this.startDate;
    }

    public void setStartDate(String startDate)  //setter method for the startDate
    {
        this.startDate = startDate;
    }

    public String getEndDate()           //getter method for the endDate  
    {
        return this.endDate;
    }

    public void setEndDate(String endDate)  //setter method for the endDate
    {
        this.endDate = endDate;
    }
    
    public String getRentDate()           //getter method for the rentDate  
    {
        return this.rentDate;
    }

    public void setRentDate(String rentDate)  //setter method for the rentDate
    {
        this.rentDate = rentDate;
    }
}

