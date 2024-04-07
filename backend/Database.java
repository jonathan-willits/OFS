package backend;

import java.sql.*;

import controller.DatabaseManager;
import controller.ItemManager;
import controller.UserManager;
import controller.Item;
import controller.User;
/**
 * Database
 */
public class Database {
    private String url;

    /*
     * @param u Database connection url
     */
    public Database(String u) {
        this.url = u;
    }

    /*
     * create jdbc connection
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /*
     * Create tables for data storage
     */
    public void create_tables(){
        // String to create table for user data
        String initUser = "CREATE TABLE IF NOT EXISTS user (id integer PRIMARY KEY, name text NOT NULL UNIQUE, password text NOT NULL, email text NOT NULL, type int NOT NULL DEFAULT 0, default_addr text)";

        // String to create table for item data
        String initItem = "CREATE TABLE IF NOT EXISTS item(id integer PRIMARY KEY, name text NOT NULL UNIQUE, quantity text NOT NULL, price REAL NOT NULL, description text, imageURL text UNIQUE)";

        // create tables
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(initUser);
            stmt.execute(initItem);
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        
    }

    /**
     * Fill tables with default data
     */
    public void init_tables(){
        // insert default user values
        String insertUser = "INSERT INTO USER(name, password, email, type) VALUES (?,?,?,?)";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(insertUser)){
            pstmt.setString(1, "admin");
            pstmt.setString(2, "password");
            pstmt.setString(3, "admin@OFS.com");
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // insert default item data
        String insertItem = "INSERT INTO ITEM(name, quantity, price, description, imageURL) VALUES (?,?,?,?,?)";
        String[] item_names = {"Bananas", "Avocado", "Strawberries", "Wheat Bread", "Broccoli", "Green Beans", "Shitake Mushrooms", "Lettuce"};
        String[] item_quantities = {"3 LB", "1 CT", "2 LB", "1 LOAF", "1 LB", "1 LB", "1 LB", "1 CT"};
        double[] item_prices = {2.29, 1.59, 12.99, 3.99, 3.99, 2.99, 13.99, 1.99};
        String[] item_descriptions = {"Organic bananas for anyone to enjoy. Perfect for a healthy breakfast.", "A healthy source of high-density lipoprotein.", 
        "Fresh, sweet strawberries.", "Baked fresh from our ovens.", "A healthy dose of fiber and vitamins,", "Another great source of fiber and vitamins.", 
        "Harvested and imported from Japan.", "Fresh, green,  and leafy."};
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(insertItem);
            for (int i = 0; i < item_names.length; i++){
                System.out.println("adding item "  + i);
                pstmt.setString(1, item_names[i]);
                pstmt.setString(2, item_quantities[i]);
                pstmt.setDouble(3, item_prices[i]);
                pstmt.setString(4, item_descriptions[i]);
                pstmt.setString(5, (i + 1) + ".png");
                pstmt.executeUpdate();
            }
            conn.close();
        }   catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // main method for testing
    // public static void main (String[] args) throws ClassNotFoundException{
    //     DatabaseManager dbm = new DatabaseManager("jdbc:sqlite:test.db");
    //     ItemManager im = new ItemManager(dbm);
    //     Item i = im.get_item("Bananas");
    //     if (i != null) {
    //         System.out.println(i.toString());
    //     }
    //     else {System.out.println("item not found");}
    //     UserManager um = new UserManager(dbm);
    //     User u = um.get_user("admin");
    //     if (u != null) {
    //         System.out.println(u.toString());
    //     }
    //     else {System.out.println("user not found");}
    //     System.out.println(dbm.get_ids_from_value("item", "quantity", "1 LB"));
    // }
}