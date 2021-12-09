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
    this.rView.addRegisterListener(this);

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
    }
    else if(e.getSource().equals(mainpage.getRegister()))
    {
        mainpage.setOff();
        rView.turnOn();
        this.rView.addRegisterListener(this);
    }

    if(e.getSource().equals(rView.getRegisterButton()))   
        {
            System.out.print("not vsiisble");
            rView.showDialog();
            rView.destroyFrame();
            mainpage.turnOn();
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


}
}
