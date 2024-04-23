package edu.sjsu.cs.cs160_project.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private DatabaseManager db;

    public UserManager(DatabaseManager db) {
        this.db = db;
    }

    /** TODO -- update to new address schema
     * Queries database, returns all data columns for user with name n
     * 
     * @param n user name
     * @return User object matching given name
     */
    public User get_user(String n) {
        try {
            ResultSet rs = db.query_all_from_id("user", db.get_single_id_from_value("user", "name", n));
            if (!rs.next()) { // empty ResultSet -> user not found in db
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
     * adds user object to database if not present, updates if present (if necessary)
     * (name should be unique)
     * 
     * @param u User obj to add to db
     * @return returns 1 if success, else -1
     */
    public void save_user(User u) {
        User curr = get_user(u.get_name());
        if (curr == null) { // user not in db
            db.add_user_to_db(u.get_name(), u.get_password(), u.get_email(), u.get_type());
        } else {    // user in db, so compare values and update if needed 
                    //(don't need to compare name as that was search term, type as that shouldn't need to change)
            if (curr.get_password() != u.get_password()){   // check pw, update if needed
                db.update_value_from_id("user", "password", curr.get_id(), u.get_password());
            }
            if (curr.get_email() != u.get_email()) {        // check email, update if needed
                db.update_value_from_id("user", "email", curr.get_id(), u.get_email());
            }
            if (curr.get_address() != u.get_address()){     // check address, update default address id if needed (using query of address table)
                db.update_value_from_id("user", "address_id", curr.get_id(), db.query_from_value("address", "id", "location", u.get_address()));
            }
        }
    }
}
