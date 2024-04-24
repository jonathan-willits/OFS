package edu.sjsu.cs.cs160_project.controller;

import edu.sjsu.cs.cs160_project.database.Database;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseManager {
    private final Database db;
    private final Connection conn;

    public DatabaseManager() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.db = new Database("jdbc:sqlite:database.db"); // create database
        this.conn = db.connect();
        db.create_tables(); // create tables
        if (get_count("user") == 0) {   // if no default data added, add default data
            db.init_tables();
        }
    }

    public DatabaseManager(String url) {
        this.db = new Database(url); // create database
        this.conn = db.connect();
        db.create_tables(); // create tables
        if (get_count("user") == 0) {
            db.init_tables();
        }
    }

    /**
     * method to add new user to user table
     * 
     * @param username must be not null
     * @param password must be not null
     * @param email    must be not null
     * @param type     0 = customer, 1 = employee
     */
    public void add_user_to_db(String username, String password, String email, int type) {
        String s = "INSERT INTO USER (name, password, email, type) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add_item_to_db(String itemname, String quantity, String description, double price, String img) {
        String s = "INSERT INTO ITEM(name, quantity, price, description, image) VALUES(?,?,?,?,?,?)";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, itemname);
            pstmt.setString(2, quantity);
            pstmt.setDouble(3, price);
            pstmt.setString(4, description);
            pstmt.setString(5, img);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * method to query database table and column using id value
     * 
     * @param table target table
     * @param col   target column
     * @param id    target id
     * @return      value of (table,column) matching input id
     */
    public String query_from_id(String table, String col, int id) {
        String s = "SELECT " + col + " FROM " + table + " WHERE id = ?";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            return rs.getString(1);
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    /**
     * method to query database table for column using a column value
     * 
     * @param table   target table
     * @param out_col output column
     * @param in_col  input column
     * @param value   input value
     * @return may be >1 item (if value is not unique)
     */
    public String query_from_value(String table, String out_col, String in_col, String value) {
        String s = "SELECT " + out_col + " FROM " + table + " WHERE " + in_col + " = ?";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            return rs.getString(1);
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    /**
     * method to get values of all columns from table matching a given id
     * 
     * @param table target table
     * @param id    target id
     * @return may be >1 tuple (if value is not unique)
     */
    public ResultSet get_all_from_id(String table, int id) {
        String s = "SELECT * FROM " + table + " WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, id);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet get_all_tuples(String table) {
        String s = "SELECT * FROM " + table;
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(s);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to query database for all columns from table matching a given column value
     * @param table     target table
     * @param column    target column
     * @param value     target value
     * @return          ResultSet containing all columns with column = value
     */
        public ResultSet get_all_from_value(String table, String column, Object value) {
        String s = "SELECT * FROM " + table + " WHERE " + column + " = ?";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setObject(1, value);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * method to query database table for tuple id from column value
     * 
     * @param table  target table
     * @param column target column (in target table)
     * @param value  desired value from (table, column)
     * @return ids of tuple matching column value (may be null)
     */
    public List<Integer> get_ids_from_value(String table, String column, Object value) {
        String s = "SELECT id FROM " + table + " WHERE " + column + " = ?";
        List<Integer> nums = new ArrayList<Integer>();
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setObject(1, value);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                nums.add(rs.getInt("id"));
            }
            return nums;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return nums;
        }
    }

    /**
     * method to query database table for single tuple id from column value
     * assumes value is unique, else use method DatabaseManager.get_ids_from_value()
     * 
     * @param table  target table
     * @param column target column (in target table)
     * @param value  desired value from (table, column)
     * @return ids of tuple matching column value (may be )
     */
    public int get_single_id_from_value(String table, String column, Object value) {
        String s = "SELECT id FROM " + table + " WHERE " + column + " = ?";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setObject(1, value);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt("id");
        } catch (SQLException e) {
            return -1;
        }
    }

     /**
     * method to query database for count of entries in database (table, column)
     * @param table     target table
     * @param column    target column
     * @return          number of entries in column, table
     */
    public int get_count(String table, String column){
        String s = "SELECT COUNT(" + column + ") FROM " + table;
        try (Connection conn = db.connect();){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            return rs.getInt(1);
        } catch(SQLException e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    /**
     * method to query database for count of entries in database table
     * @param table     target table
     * @return          number of entries in column, table
     */
    public int get_count(String table){
        String s = "SELECT COUNT(*) FROM " + table;
        try (Connection conn = db.connect();){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            return rs.getInt(1);
        } catch(SQLException e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    /**
     * method to update value of db for (table, column) for given id to given value
     * @param table     // target db table
     * @param column    // target db column
     * @param id        // id of target db tuple
     * @param value     // value to insert
     * @return
     */
    public void update_value_from_id(String table, String column, int id, Object value){
        String s = "UPDATE " + table + " SET " + column + " = ? WHERE id = ?";
        try (Connection conn = db.connect();){
            PreparedStatement pstmt = conn.prepareStatement(s); // create PreparedStatement
            pstmt.setObject(1, value);           // set parameters
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}