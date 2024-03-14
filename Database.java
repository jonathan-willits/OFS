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
    public void create_tables(){
        // String to create table for user data
        String initUser = "CREATE TABLE IF NOT EXISTS user (id integer PRIMARY KEY, username text NOT NULL UNIQUE, password text NOT NULL, first_name text, last_name text, email text NOT NULL, type int CHECK (type in (0, 1)))";

        // String to create table for item data
        String initItem = "CREATE TABLE IF NOT EXISTS item (id integer PRIMARY KEY, name text NOT NULL, price REAL NOT NULL, description text)";

        // create tables
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(initUser);
            stmt.execute(initItem);
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }       
    }

    /*
     * Populates tables with initial data
     */
    public void init_tables(){

    }

}