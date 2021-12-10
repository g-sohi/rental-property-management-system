import GUI.*;
import Database.*;

import java.io.IOException;

import Controller.*;
public class MainClass {

    /**
     *  MainClass run the program. It initailises
     * the Database and GUI controller
     * and set the Database in the GUIController object ctrl
     * */ 


    public static void main(String[] args) throws IOException {
        Database db = new Database();
        GUIController ctrl = new GUIController(db);
        ctrl.setDatabase(db);
        
    }
    
}