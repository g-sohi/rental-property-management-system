package Models;

public class Email {
    private String subject;
    private String message;
    private String recip;
    private String date;

    public Email(String subject, String message, String recip, String date)
    {
        this.subject = subject;
        this.message = message;
        this.recip = recip;
        this.date = date;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public String getRecip()
    {
        return this.recip;
    }

    public void setRecip(String recip)
    {
        this.recip = recip;
    }

    public String getDate()
    {
        return this.date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

}
