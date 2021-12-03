package Controller;

import Models.*;
import GUI.*;
import Database.*;

import java.util.*;

public class SearchController {

    /*  
        SearchController UML:
            Attributes:
                -sView: SearchView
                -users: User
                -listings: ArrayList<Property>
                -db: Database
            Functions:
                +displayAll(listings: ArrayList<Property>): void
                +filterAll(): void
                +update(listings: ArrayList<Property>): void
    */

    private SearchView sView;
    private User users;
    private ArrayList<Property> listings;
    private Database db;

    public SearchController() {

    }

    public void displayAll(ArrayList<Property> listings) {
        
    }

    public void filterAll() {

    }

    public void update(ArrayList<Property> listings) {
        
    }

    
    public SearchView getsView() {
        return sView;
    }

    public void setsView(SearchView sView) {
        this.sView = sView;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public ArrayList<Property> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Property> listings) {
        this.listings = listings;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }
}
