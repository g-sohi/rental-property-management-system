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

}