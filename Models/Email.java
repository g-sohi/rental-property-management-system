package Models;

public class Email {
    private String subject;
    private String message;
    private String recip;
    private String date;

    /**
     * Constructor for the Email class
     */
    public Email(String subject, String message, String recip, String date) 
    {
        this.subject = subject;
        this.message = message;
        this.recip = recip;
        this.date = date;
    }

    public String getSubject()              //getter method for the subject
    {
        return this.subject;
    }

    public void setSubject(String subject)  //setter method for the subject
    {
        this.subject = subject;
    }

    public String getMessage()              //getter method for the message
    {
        return this.message;
    }

    public void setMessage(String message)  //setter method for the message
    {
        this.message = message;
    }
    
    public String getRecip()                //getter method for the recip
    {
        return this.recip;
    }

    public void setRecip(String recip)      //setter method for the recip
    {
        this.recip = recip;
    }

    public String getDate()                 //getter method for the date
    {
        return this.date;
    }

    public void setDate(String date)        //setter method for the date
    {
        this.date = date;
    }

}
