package edu.sjsu.cs.cs160_project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class OrderManager {
    private final DatabaseManager db;

    public OrderManager(DatabaseManager db) {
        this.db = db;
    }

    /**
     * Method to query database for order data
     * @param name  name of target user
     * @param n     number of orders desired
     * @return      List containing up to n orders from user
     */
    public List<Order> get_orders(String name, int n){
        List<Order> order_list = new ArrayList<Order>();
        UserManager um = new UserManager(db);               // UserManager instance to query db for user id
        User u = um.get_user(name);
        ItemManager im = new ItemManager(db);               // ItemManager instance to query db for Item List
        try {
            // get set of tuples from order table where customer_id = id of target user (ie all orders by that user)
            ResultSet rs = db.get_all_from_value("orders", "customer_id", u.get_id());
            while(rs.next() && order_list.size() <= n){
                order_list.add(new Order(u, get_cart(rs.getInt("order_id")), db.query_from_id("address", "location", rs.getInt("address_id"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return order_list;
    }

    /**
     * method to get all items in order
     * @param id    order id of target order
     * @return      list of items in order with order_id = id
     */
    public List<Item> get_cart(int id){
        List<Item> item_list = new ArrayList<Item>();
        ResultSet rs = db.get_all_from_value("cart", "order_id", id);   // get RS with all items in cart (as item_id)
        try{
            while(rs.next()){
                ResultSet item_rs = db.get_all_from_id("item", rs.getInt("id"));
                item_list.add(new Item(rs.getString("name"), rs.getString("quantity"), rs.getString("description"), rs.getDouble("price"), rs.getDouble("weight"), rs.getString("imageURL"), rs.getInt("id")));
                item_rs.close();
            }
            rs.close();
        }   catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return item_list;
    }
}
