package com.ofs.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://db:3306/ofs", "root", "password");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {


        System.out.println(new Database().getConnection());
    }
}
