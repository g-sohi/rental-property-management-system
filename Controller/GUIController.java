package Controller;
import GUI.*;
import Database.*;
import Models.*;


import java.awt.event.*;

public class GUIController implements ActionListener {

private MainPageGUI mainpage;
private LoginController login;
private Database db;

public GUIController()
{
    mainpage = new MainPageGUI();
    this.setDatabase(db);
    this.mainpage.addLoginListener(this);
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
        login = new LoginController(db);
    }
    
}
}
