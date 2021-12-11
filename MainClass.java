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