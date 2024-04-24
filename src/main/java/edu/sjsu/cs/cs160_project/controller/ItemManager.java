package edu.sjsu.cs.cs160_project.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ItemManager {
    private DatabaseManager db;

    public ItemManager(DatabaseManager db) {
        this.db = db;
    }

    /**
     * returns item object based on db data with name matching search string
     *
     * @param n name of sought item
     * @return item obj containing db data of sought item, null if name not in db
     */
    public Item get_item(String n) {
        try {
            ResultSet rs = db.get_all_from_id("item", db.get_single_id_from_value("item", "name", n));
            if (!rs.next()) { // ResultSet is empty -> no matching item found
                return null;
            }
            return new Item(rs.getString("name"), rs.getString("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getDouble("weight"), rs.getString("imageURL"), rs.getInt("id"));
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    /**
     * adds or updates item in database
     *
     * @param i item object to save to db
     */
    public void save_item(Item i) {
        Item curr = get_item(i.get_name());
        if (curr == null) {    // if no item matching i.name is in database, add to db
            db.add_item_to_db(i.get_name(), i.get_quantity(), i.get_description(), i.get_price(), i.get_imageURL());
        } else {                // item in db, so compare values and update if needed; already checked item name, so skip that
            if (!curr.get_quantity().equals(i.get_quantity())) {   // check quantity, update if needed
                System.out.println("updating weight");
                db.update_value_from_id("item", "quantity", curr.get_id(), i.get_quantity());
            }
            if (!curr.get_description().equals(i.get_description())) { // check description, update if needed
                db.update_value_from_id("item", "description", curr.get_id(), i.get_description());
            }
            if (curr.get_price() != i.get_price()) { // check price, update if needed
                db.update_value_from_id("item", "price", curr.get_id(), i.get_price());
            }
            if (curr.get_weight() != i.get_weight()) { // check weight, update if needed
                db.update_value_from_id("item", "weight", curr.get_id(), i.get_weight());
            }
            if (!curr.get_imageURL().equals(i.get_imageURL())) {   // check image link, update if needed
                db.update_value_from_id("item", "imageURL", curr.get_id(), i.get_imageURL());
            }
        }
    }

    /**
     * method to get all items in database
     *
     * @return ArrayList with all items from db
     */
    public List<Item> get_all_items() {
        int count_items = db.get_count("item");
        List<Item> i_list = new ArrayList<>();
        ResultSet rs = db.get_all_tuples("item");
        try {
            while (rs.next()) {
                i_list.add(new Item(rs.getString("name"), rs.getString("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getDouble("weight"), rs.getString("imageURL"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i_list;
    }
}
