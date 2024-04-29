package com.ecommerce.database;

import java.sql.*;
import java.util.Random;
import java.io.*;

public class Database {
    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:OFS.db");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void create_tables(){
        String account = "CREATE TABLE IF NOT EXISTS `account` (\n" +
                "  `account_id` INTEGER PRIMARY KEY,\n" +
                "  `account_name` varchar(255) DEFAULT NULL,\n" +
                "  `account_password` varchar(255) DEFAULT NULL,\n" +
                "  `account_is_seller` int DEFAULT NULL,\n" +
                "  `account_is_admin` int DEFAULT NULL,\n" +
                "  `account_image` longblob,\n" +
                "  `account_address` varchar(255) DEFAULT NULL,\n" +
                "  `account_first_name` varchar(255) DEFAULT NULL,\n" +
                "  `account_last_name` varchar(255) DEFAULT NULL,\n" +
                "  `account_email` varchar(255) DEFAULT NULL,\n" +
                "  `account_phone` varchar(10) DEFAULT NULL\n" +
                ");";
        String category = "CREATE TABLE IF NOT EXISTS `category` (\n" +
                "  `category_id` INTEGER PRIMARY KEY,\n" +
                "  `category_name` varchar(255) DEFAULT NULL,\n" +
                "  `category_number_product` int DEFAULT NULL\n" +
                ");";
        String order = "CREATE TABLE  IF NOT EXISTS `order` (\n" +
                "  `order_id` INTEGER PRIMARY KEY,\n" +
                "  `fk_account_id` int DEFAULT NULL,\n" +
                "  `order_total` float DEFAULT NULL,\n" +
                "  `order_date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`fk_account_id`) REFERENCES `account` (`account_id`)\n" +
                ");";
        String order_detail = "CREATE TABLE  IF NOT EXISTS `order_detail` (\n" +
                "  `fk_product_id` int DEFAULT NULL,\n" +
                "  `fk_order_id` int DEFAULT NULL,\n" +
                "  `product_quantity` int DEFAULT NULL,\n" +
                "  `product_price` float DEFAULT NULL,\n" +
                "  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`fk_product_id`) REFERENCES `product` (`product_id`),\n" +
                "  CONSTRAINT `order_detail_ibfk_3` FOREIGN KEY (`fk_order_id`) REFERENCES `order` (`order_id`)\n" +
                ");";
        String product = "CREATE TABLE  IF NOT EXISTS `product` (\n" +
                "  `product_id` INTEGER PRIMARY KEY,\n" +
                "  `product_name` varchar(255) DEFAULT NULL,\n" +
                "  `product_image` longblob,\n" +
                "  `product_price` float DEFAULT NULL,\n" +
                "  `product_description` varchar(3000) DEFAULT NULL,\n" +
                "  `fk_category_id` int DEFAULT NULL,\n" +
                "  `fk_account_id` int DEFAULT NULL,\n" +
                "  `product_is_deleted` tinyint(1) DEFAULT NULL,\n" +
                "  `product_amount` int DEFAULT NULL,\n" +
                "  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`fk_category_id`) REFERENCES `category` (`category_id`),\n" +
                "  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`fk_account_id`) REFERENCES `account` (`account_id`)\n" +
                ");";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(account);
            stmt.executeUpdate(category);
            stmt.executeUpdate(order);
            stmt.executeUpdate(order_detail);
            stmt.executeUpdate(product);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * Fill tables with default data
     */
    public void init_tables() {
        // insert data for default user
        String insertUser = "INSERT INTO account(account_name, account_password, account_email, account_is_seller, account_is_admin) VALUES (?,?,?,?,?)";
        try (Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
            pstmt.setString(1, "admin");
            pstmt.setString(2, "password");
            pstmt.setString(3, "admin@OFS.com");
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }

        // insert default item data
        String insertItem = "INSERT INTO product(product_name, product_image, product_price, product_description, product_amount) values (?,?,?,?,?)";
        String[] item_names = {"Bananas", "Avocado", "Strawberries", "Wheat Bread", "Broccoli", "Green Beans",
                "Shiitake Mushrooms", "Lettuce"};
        String[] item_quantities = {"3 LB", "1 CT", "2 LB", "1 LOAF", "1 LB", "1 LB", "1 LB", "1 CT"};
        double[] item_prices = {2.29, 1.59, 12.99, 3.99, 3.99, 2.99, 13.99, 1.99};
        double[] item_weights = {3, 0.5, 2, 1, 1, 1, 1, 0.5};
        String[] item_descriptions = {"Organic bananas for anyone to enjoy. Perfect for a healthy breakfast.",
                "A healthy source of high-density lipoprotein.",
                "Fresh, sweet strawberries.", "Baked fresh from our ovens.", "A healthy dose of fiber and vitamins,",
                "Another great source of fiber and vitamins.",
                "Harvested and imported from Japan.", "Fresh, green,  and leafy."};
        Random rn = new Random();
        try (Connection conn = this.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertItem)) {
            for (int i = 0; i < item_names.length; i++) {
                System.out.println("adding " + item_names[i]);
                pstmt.setString(1, item_names[i]);
                pstmt.setDouble(3, item_prices[i]);
                pstmt.setString(4, item_descriptions[i]);
                pstmt.setInt(5, rn.nextInt(30) + 1);
                int n = i + 1;
                var file = new File("src/main/webapp/images/" + n + ".png");
                try (FileInputStream input = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    var bos = new ByteArrayOutputStream();
                    for (int len; (len = input.read(buffer)) != -1; ) {
                        bos.write(buffer, 0, len);
                    }
                    }   catch(IOException f){
                        throw new RuntimeException(f.getMessage());
                    }
                    pstmt.executeUpdate();
                }
            } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }

        public void empty_tables () {
            String delete = "DELETE FROM ?";
            String[] tables = {"account", "category", "order", "order_detail", "product"};
            try (Connection connection = this.getConnection()) {
                PreparedStatement pstmt = connection.prepareStatement(delete);
                for (String t : tables) {
                    pstmt.setString(1, t);
                    pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        public static void main (String[]args){
            Database d = new Database();
            d.create_tables();
            d.init_tables();
        }
    }
