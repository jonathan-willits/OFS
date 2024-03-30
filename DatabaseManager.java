package controller;
import backend.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class DatabaseManager {
    private Database db;
    private Connection conn;

    public DatabaseManager(){
        this.db = new Database("jdbc:sqlite:OFS.db");       // create database
        db.createTables();                                    // create tables
        // db.init_tables();
        conn = db.connect();
    }
    /**
     * method to add new user to user table
     * @param username  must be not null
     * @param password  must be not null
     * @param email     must be not null
     * @param type      0 = customer, 1 = employee
     */
    public void add_user_to_db(String username, String password, String email, int type){
        String s = "INSERT INTO USER (username, password, email, type) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, type);
            pstmt.executeUpdate();
        }   catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * method to query database table and column using id value
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
        }   catch (SQLException e) {
            return e.getMessage();
        }
    }

    /**
     * method to query database table and column using a column value
     * @param table     target table
     * @param out_col   output column
     * @param in_col    input column
     * @param value     input value
     * @return
     */
    public String query_from_value(String table, String out_col, String in_col, String value) {
        String s = "SELECT " + out_col + " FROM " + table + " WHERE " + in_col + " = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            return rs.getString(1);
        }   catch (SQLException e) {
            return e.getMessage();
        }
    }

    /**
     * method to get values of all columns from table matching a given id
     * @param table
     * @param id
     * @return
     */
    public ResultSet query_all_from_id(String table, int id) {
        String s = "SELECT * FROM " + table + " WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, id);
            return pstmt.executeQuery();
        }   catch (SQLException e) {
            return null;
        }
    }

    public int get_id_from_value(String table, String column, String value){
        String s = "SELECT id FROM " + table + " WHERE " + column + " = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(1);
        }   catch (SQLException e) {
            return -1;
        }
    }
}
