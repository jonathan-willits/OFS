package edu.sjsu.cs.cs160_project.controller;

public class Item {
    private String name, quantity, description, imageURL;
    private double price;
    private int id;

    /**
     * default constructor
     */
    public Item(String name, String quantity, String description, double price, String imageURL) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
    }

    /**
     * Item Constructor with id -- use ONLY for returns from db queries: ItemManager.get_item()
     * @param name
     * @param quantity
     * @param description
     * @param price
     * @param imageURL
     * @param id
     */
    public Item(String name, String quantity, String description, double price, String imageURL, int id) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
        this.id = id;
    }

    public String get_name() {
        return name;
    }

    public String get_quantity() {
        return quantity;
    }

    public String get_description() {
        return description;
    }

    public double get_price() {
        return price;
    }

    public String get_imageURL() {
        return imageURL;
    }

    public int get_id(){
        return id;
    }
    
    public void set_name(String name) {
        this.name = name;
    }

    public void set_quantity(String quantity) {
        this.quantity = quantity;
    }

    public void set_description(String description) {
        this.description = description;
    }

    public void set_imageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void set_price(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", quantity=" + quantity + ", description=" + description + ", imageURL="
                + imageURL + ", price=" + price + "]";
    }
}
