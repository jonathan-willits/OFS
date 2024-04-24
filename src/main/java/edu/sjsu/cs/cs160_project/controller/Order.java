package edu.sjsu.cs.cs160_project.controller;

import java.util.List;

public class Order {
    private User user;
    private List<Item> item_list;
    private double tot_price = 0, tot_weight = 0;
    private String address;

    private static final double max_capacity = 20;

    /**
     * Constructor for Order class
     * @param u         user tied to Order
     * @param item_list Items in order
     * @param address   delivery address for order (validated in frontend)
     */
    public Order(User u, List<Item> item_list, String address){
        this.user = u;
        this.address = address;
        this.item_list = item_list;
        for (Item item : item_list) { // add price, weight of each item to accumulator
            tot_price += item.get_price();
            tot_weight += item.get_weight();
            if (tot_weight > max_capacity) {         // if weight exceeds capacity, throw error
                throw new IllegalArgumentException("weight exceeds max capacity for delivery");
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItem_list() {
        return item_list;
    }

    public void setItem_list(List<Item> item_list) {
        this.item_list = item_list;
    }

    public double getTot_price() {
        return tot_price;
    }

    public void setTot_price(double tot_price) {
        this.tot_price = tot_price;
    }

    public double getTot_weight() {
        return tot_weight;
    }

    public void setTot_weight(double tot_weight) {
        this.tot_weight = tot_weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("Order{user= " + user + "Items= ");
        for (Item i : item_list) {
            ret.append(i.get_name()).append(", ");
        }
        ret.append("Total price=").append(tot_price).append(", Total weight=").append(tot_weight).append("Delivery address=").append(address);
        return ret.toString();
    }
}