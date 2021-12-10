import GUI.*;
import Database.*;

import java.io.IOException;

import Controller.*;
public class MainClass {

    public static void main(String[] args) throws IOException {
        Database db = new Database();
        GUIController ctrl = new GUIController(db);
        ctrl.setDatabase(db);
        
    }
    
}