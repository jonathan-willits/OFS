package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManager {
    private DatabaseManager db;
    
    public ItemManager(DatabaseManager db) {
        this.db = db;
    }

    /**
     * returns item object based on db data with name matching search string
     * @param n name of sought item
     * @return  item obj containing db data of sought item, null if name not in db
     */
    public Item get_item(String n) {
        try {
            ResultSet rs = db.query_all_from_id("item", db.get_single_id_from_value("item", "name", n));
            if (!rs.next()) {   // ResultSet is empty -> no matching item found
                return null;
            }
            return new Item(rs.getString(2), rs.getString(3), rs.getString(5), rs.getDouble(4), rs.getString(6));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}
