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

public class Fees {
    private double amount;
    private int feePeriod;
    private String feesPaid;
    private String feeStartDate;
    private String feeEndDate;

    /**
     * Constructor for the Fees class
     */
    public Fees(){
        this.amount = 0.0;
        this.feePeriod = 0;
        this.feesPaid = "No";
        this.feeStartDate = "";
        this.feeEndDate = "";
    }

    public Fees(double amount, int feePeriod, String feesPaid, String feeStartDate,String feeEndDate)
    {
        this.amount = amount;
        this.feePeriod = feePeriod;
        this.feesPaid = feesPaid;
        this.feeStartDate = feeStartDate;
        this.feeEndDate =feeEndDate;
    }

    public double getAmount()              //getter method for the amount
    {
        return this.amount;
    }

    public void setAmount(double amount)  //setter method for the amount
    {
        this.amount = amount;
    }

    public int getFeePeriod()              //getter method for the feePeriod
    {
        return feePeriod;
    }

    public void setFeePeriod(int feePeriod)  //setter method for the feePeriod
    {
        this.feePeriod = feePeriod;
    }

    public String getFeesPaid(){
        return this.feesPaid;
    }

    public void setFeesPaid(String paid){
        this.feesPaid = paid;
    }

    public String getFeeStartDate()              //getter method for the feeStartDate
    {
        return feeStartDate;
    }

    public void setFeeStartDate(String feeStartDate)  //setter method for the feeStartDate
    {
        this.feeStartDate = feeStartDate;
    }

    public String getFeeEndDate()              //getter method for the feeEndDate
    {
        return feeEndDate;
    }

    public void setFeeEndDate(String feeEndDate)  //setter method for the feeEndDate
    {
        this.feeEndDate = feeEndDate;
    }
}
