package edu.sjsu.cs.cs160_project.controller;

import backend.Database;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseManager {
    private Database db;
    private Connection conn;

    public DatabaseManager() {
        this.db = new Database("jdbc:sqlite:OFS.db"); // create database
        db.create_tables(); // create tables
        db.init_tables();
        conn = db.connect();
    }

    public DatabaseManager(String url) {
        this.db = new Database(url); // create database
        db.create_tables(); // create tables
        db.init_tables();
        conn = db.connect();
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
            e.getMessage();
        }
    }

    public void add_item_to_db(String itemname, String quantity, String description, double price, String img) {
        String s = "INSERT INTO ITEM(name, quantity, price, description, image) VALUES(?,?,?,?)";
        try {
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
     * @param table
     * @param col
     * @param id
     * @return
     */
    public String query_from_id(String table, String col, int id) {
        String s = "SELECT " + col + " FROM " + table + " WHERE id = ?";
        try {
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
        try {
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
     * @param table
     * @param id
     * @return may be >1 tuple (if value is not unique)
     */
    public ResultSet query_all_from_id(String table, int id) {
        String s = "SELECT * FROM " + table + " WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, id);
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
        try {
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
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setObject(1, value);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
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
    public int update_value_from_id(String table, String column, int id, Object value){
        String s = "UPDATE " + table + " SET " + column + " = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s); // create PreparedStatement
            pstmt.setObject(1, value);           // set parameters
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();                              // execute
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return e.getErrorCode();
        }
    }
}
