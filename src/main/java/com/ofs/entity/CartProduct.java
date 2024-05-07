package com.ofs.entity;

public class CartProduct {
    private Product product;
    private int quantity;
    private double price;
    private double weight;
    private double tax;

    public CartProduct() {
    }

    public CartProduct(Product product, int quantity, double price, double weight, double tax) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.tax = tax;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() { return this.weight; }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTax() {
        return this.tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", weight=" + this.weight +
                ", tax=" + this.tax +
                '}';
    }
}
