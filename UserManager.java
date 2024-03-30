package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private DatabaseManager db;

    public UserManager() {
        db = new DatabaseManager();
    }

    /**
     * Queries database, returns all column data for user with name n
     * 
     * @param n String with user name
     * @return User object matching given name
     */
    public User get_user(String n) {
        try {
            ResultSet rs = db.query_all_from_id("user", db.get_id_from_value("user", "name", n));
            if (rs.wasNull()) {
                return null;
            }
            return new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void add_user_to_db(User u){
        db.add_user_to_db(u.get_name(), u.get_password(), u.get_email(), u.get_type());
    }
}
