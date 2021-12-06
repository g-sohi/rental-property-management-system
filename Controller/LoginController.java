package Controller;
import GUI.*;
import Database.*;
import Models.*;

import java.awt.event.*;

//Login Controller
public class LoginController implements ActionListener{
    private LoginView view;
    private Database db;
    private User user;
    private RegisterView rView;

    //Default constructor to create instances of member variables
    public LoginController(Database db){
        this.view = new LoginView();
        this.db = db;
        this.user = new User();
        this.rView = new RegisterView();

        this.view.addLoginListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.verifyLogin();
        if(e.getSource().equals(view.getButton()))
        {
            view.dispose();
            RenterView vw = new RenterView();
            vw.setVisible(true);
            
        }
    }
    
    //Verify user login credentials and return a boolean indicating its status
    public void verifyLogin(){
        user.setUsername(view.getUsername());
        user.setPassword(view.getPassword());

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        db.initializeConnection();
        db.verifyUser(user.getUsername(), user.getPassword());
        db.close();
    }

    //Register new user
    public void registerUser(){

    }

    //getter for login view
    public LoginView getView(){
        return this.view;
    }

    //setter for login view
    public void setView(LoginView lv){
        this.view = lv;
    }

    //getter for database 
    public Database getDb(){
        return this.db;
    }

    //setter for database
    public void setDb(Database d){
        this.db = d;
    }

    //getter for user
    public User getUser(){
        return this.user;
    }

    //setter for user
    public void setUser(User u){
        this.user = u;
    }

    //getter for register view
    public RegisterView getRView(){
        return this.rView;
    }

    //setter for register view
    public void setRView(RegisterView rv){
        this.rView = rv;
    }
}
