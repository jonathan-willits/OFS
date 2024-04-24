package edu.sjsu.cs.cs160_project.database;

import java.sql.*;
import java.util.List;

import edu.sjsu.cs.cs160_project.controller.DatabaseManager;
import edu.sjsu.cs.cs160_project.controller.ItemManager;
import edu.sjsu.cs.cs160_project.controller.UserManager;
import edu.sjsu.cs.cs160_project.controller.Item;
import edu.sjsu.cs.cs160_project.controller.User;
import edu.sjsu.cs.cs160_project.controller.Order;

/**
 * Database
 */
public class Database {
    private final String url;

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
    public void create_tables() {
        // String to create table for user data
        String initUser = "CREATE TABLE IF NOT EXISTS user (id integer PRIMARY KEY, name text NOT NULL UNIQUE, password text NOT NULL, email text NOT NULL, type integer NOT NULL DEFAULT 0, default_addr_id integer)";

        // String to create table for item data
        String initItem = "CREATE TABLE IF NOT EXISTS item(id integer PRIMARY KEY, name text NOT NULL UNIQUE, quantity text NOT NULL, price REAL NOT NULL, weight REAL NOT NULL, description text, imageURL text UNIQUE)";

        // String to create table for address data
        String initAddress = "CREATE TABLE IF NOT EXISTS address(id integer PRIMARY KEY, customer_id integer NOT NULL, location text NOT NULL, FOREIGN KEY(customer_id) REFERENCES user(id))";

        // String to create table for order data
        String initOrder = "CREATE TABLE IF NOT EXISTS orders(id integer PRIMARY KEY, customer_id integer NOT NULL, tot_price REAL NOT NULL, tot_weight REAL NOT NULL, address_id integer NOT NULL, FOREIGN KEY(customer_id) REFERENCES user(id), FOREIGN KEY(address_id) REFERENCES address(id))";

        // String to create table for cart data (i.e. items in each order)
        String initCart = "CREATE TABLE IF NOT EXISTS cart(id integer PRIMARY KEY, order_id integer NOT NULL, item_id integer NOT NULL, FOREIGN KEY(order_id) REFERENCES orders(id), FOREIGN KEY(item_id) REFERENCES item(id))";

        // create tables
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(initUser);
            stmt.execute(initAddress);
            stmt.execute(initItem);
            stmt.execute(initOrder);
            stmt.execute(initCart);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Fill tables with default data
     */
    public void init_tables() {
        // insert data for default user
        String insertUser = "INSERT INTO USER(name, password, email, type) VALUES (?,?,?,?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
            pstmt.setString(1, "admin");
            pstmt.setString(2, "password");
            pstmt.setString(3, "admin@OFS.com");
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }

        // insert default item data
        String insertItem = "INSERT INTO ITEM(name, quantity, price, weight, description, imageURL) VALUES (?,?,?,?,?,?)";
        String[] item_names = {"Bananas", "Avocado", "Strawberries", "Wheat Bread", "Broccoli", "Green Beans",
                "Shitake Mushrooms", "Lettuce"};
        String[] item_quantities = {"3 LB", "1 CT", "2 LB", "1 LOAF", "1 LB", "1 LB", "1 LB", "1 CT"};
        double[] item_prices = {2.29, 1.59, 12.99, 3.99, 3.99, 2.99, 13.99, 1.99};
        double[] item_weights = {3, 0.5, 2, 1, 1, 1, 1, 0.5};
        String[] item_descriptions = {"Organic bananas for anyone to enjoy. Perfect for a healthy breakfast.",
                "A healthy source of high-density lipoprotein.",
                "Fresh, sweet strawberries.", "Baked fresh from our ovens.", "A healthy dose of fiber and vitamins,",
                "Another great source of fiber and vitamins.",
                "Harvested and imported from Japan.", "Fresh, green,  and leafy."};
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(insertItem);
            for (int i = 0; i < item_names.length; i++) {
                System.out.println("adding item " + i);
                pstmt.setString(1, item_names[i]);
                pstmt.setString(2, item_quantities[i]);
                pstmt.setDouble(3, item_prices[i]);
                pstmt.setDouble(4, item_weights[i]);
                pstmt.setString(5, item_descriptions[i]);
                pstmt.setString(6, (i + 1) + ".png");
                pstmt.executeUpdate();
            }
            conn.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    // main method for testing
    public static void main(String[] args) throws ClassNotFoundException {
        DatabaseManager dbm = new DatabaseManager();
        ItemManager im = new ItemManager(dbm);
        List<Item> ilist = im.get_all_items();
        System.out.println(ilist);
        UserManager um = new UserManager(dbm);
        User u = um.get_user("admin");
        if (u != null) {
            System.out.println(u);
        } else {
            System.out.println("user not found");
        }
        User u1 = new User("Jonathan", "pw", "jonathan.willits@sjsu.edu", 0);
        um.save_user(u1);
    }
}