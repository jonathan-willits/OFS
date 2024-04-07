package controller;

public class Item {
    private String name, quantity, description, imageURL;
    private double price;

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
    
    @Override
    public String toString() {
        return "Item [name=" + name + ", quantity=" + quantity + ", description=" + description + ", imageURL="
                + imageURL + ", price=" + price + "]";
    }
}
