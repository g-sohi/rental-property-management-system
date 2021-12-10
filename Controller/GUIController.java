package Controller;
import GUI.*;
import Database.*;
import Models.*;


import java.awt.event.*;
import java.io.IOException;

public class GUIController implements ActionListener {

private MainPageGUI mainpage;
private LoginController login;
private SearchController search;
private Database db;
private RegisterView rView;
private EmailView emailV;
public GUIController(Database db) throws IOException
{
    mainpage = new MainPageGUI();
    this.setDatabase(db);
    login = new LoginController(this.db);
    search = new SearchController(this.db);
    rView = new RegisterView();
    this.mainpage.addLoginListener(this);
    this.mainpage.addGuestListener(this);
    this.mainpage.addRegisterListener(this);
    this.mainpage.addSendEmailListener(this);
}

public void setDatabase(Database db)
{
    this.db = db;
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(mainpage.getLog()))
    {
        mainpage.setOff();
        login.enableView();
        login.getView().turnOn();
        login.getView().addGoBackListener(this);
    }
    else if(e.getSource().equals(mainpage.getGuest()))
    {
        mainpage.setOff();
        search.enableView();
        search.getView().turnOn();
        search.getView().addBackButtonListener(this);
    }
    else if(e.getSource().equals(mainpage.getRegister()))
    {
        mainpage.setOff();
        rView.turnOn();
        this.rView.addRegisterListener(this);
        this.rView.addBackListener(this);

    }
    else if(e.getSource().equals(mainpage.getSendEmailButton()))
    {
        mainpage.setOff();
        emailV = new EmailView(true);
        emailV.turnOnForGuest();
        emailV.addBackListener(this);
        emailV.addSendEmailListener(this);
    }

    if(emailV != null)
    {
        if(e.getSource().equals(emailV.getSendButton()))
        {
            //
        }
    }


    if(e.getSource().equals(rView.getRegisterButton()))   
        {
            if(!rView.getUsername().equals("") && !rView.getPassword().equals("") && !rView.getFName().equals("") && !rView.getLName().equals(""))
            {
            System.out.print("not vsiisble");
            rView.showDialog();
            rView.destroyFrame();
            mainpage.turnOn();
            db.initializeConnection();
            db.addUser(rView.getUsername(), rView.getFName(), rView.getLName(), rView.getPassword(), rView.getUserType());
            }
            else
            {
                rView.showErrorDialog();
            }
    }
    
    
    if(login.getView() != null)
    {
     if(e.getSource().equals(login.getView().getGoBackButton()))   
    {
        System.out.print(" vsiisble");
        login.getView().destroyFrame();
        mainpage.turnOn();
    }
    }

    if(search.getView() != null)
    {
     if(e.getSource().equals(search.getView().getBackButton()))   
    {
        System.out.print(" vsiisble");
        search.getView().destroyFrameRenterGuest();
        mainpage.turnOn();
    }
    }
    if(this.rView != null)
    {
        if(e.getSource().equals(rView.getBackButton()))   
        {
            System.out.print(" vsiisble");
            rView.destroyFrame();
            mainpage.turnOn();
        }
    }


}
}
