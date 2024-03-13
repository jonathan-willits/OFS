package backend;

import java.sql.*;
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
    public void createTables(){
        // String to create password table
		String initPassword = "CREATE TABLE IF NOT EXISTS password (\nid integer PRIMARY KEY, \n key text NOT NULL);";

		// String to set default password
		// String defPassword = "INSERT INTO password(key) VALUES ('p')";

        // String to create table for user data
        String initUser = "CREATE TABLE IF NOT EXISTS user (id integer PRIMARY KEY, name text NOT NULL, type ENUM('emp', 'cust') NOT NULL DEFAULT 'cust')";
        
        // String to insert new user
        // String defUser = "INSERT INTO user(name, type) VALUES(?, ?)";

        // String to create table for item data
        String initItem = "CREATE TABLE IF NOT EXISTS item(id integer PRIMARY KEY, name text NOT NULL, price REAL NOT NULL, description text)";

        // String to insert new item
        // String defItem = "INSERT INTO item(name, price, description) VALUES(?, ?, ?)";

        // create tables
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(initPassword);
            stmt.execute(initUser);
            stmt.execute(initItem);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        
    }

    public static void main (String[] args) throws ClassNotFoundException{
        Database db = new Database("jdbc:sqlite:OFS.db");
        db.connect();
    }
}