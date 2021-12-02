package Models;

public class Address {
    private int streetNo;
    private String streetName;
    private String city;
    private String postalCode;
    private String quadrant;
    private int aptNo;

    public Address(int streetNo, String streetName, String city, String postalCode, String quadrant,int aptNo )
    {
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.quadrant = quadrant;
        this.aptNo = aptNo;
        
    }

    public int getStreetNo()
    {
        return this.streetNo;
    }

    public void setStreetNo(int streetNo)
    {
        this.streetNo = streetNo;
    }

    public String getStreetName()
    {
        return this.streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
    public String getPostalCode()
    {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }
    
    public String getQuadrant()
    {
        return this.quadrant;
    }

    public void setQuadrant(String quadrant)
    {
        this.quadrant = quadrant;
    }
    public int getAptNo()
    {
        return this.aptNo;
    }

    public void setAptNo(int aptNo)
    {
        this.aptNo = aptNo;
    }
    
}