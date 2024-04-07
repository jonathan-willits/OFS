package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private DatabaseManager db;

    public UserManager(DatabaseManager db) {
        this.db = db;
    }

    /**
     * Queries database, returns all data columns for user with name n
     * 
     * @param n user name
     * @return User object matching given name
     */
    public User get_user(String n) {
        try {
            ResultSet rs = db.query_all_from_id("user", db.get_single_id_from_value("user", "name", n));
            if (!rs.next()) {   // empty ResultSet -> user not found in db
                return null;
            }
            
            return new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * adds user object to database, prints error message if user already in db (name should be unique)
     * @param u User obj to add to db
     * @return returns 1 if success, else -1
     */
    public int add_user_to_db(User u){
        if (get_user(u.get_name()) == null) {
            db.add_user_to_db(u.get_name(), u.get_password(), u.get_email(), u.get_type());
            return 1;
        }
        else {
            System.out.println("User " + u.get_name() + " already exists in db");
            return -1;
    }
    }
}
