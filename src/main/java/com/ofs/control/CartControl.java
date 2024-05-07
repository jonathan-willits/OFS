package com.ofs.control;

import com.ofs.dao.ProductDao;
import com.ofs.entity.CartProduct;
import com.ofs.entity.Order;
import com.ofs.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CartControl", value = "/cart")
public class CartControl extends HttpServlet {
    // Call DAO class to access with database.
    ProductDao productDao = new ProductDao();

    // Method to remove a product from cart.
    private void removeCartProduct(HttpSession session, int productId, Order order, double subtotal, double totalWeight, double totalTax, double total) {

        // Get list of products from the existing order.
        List<CartProduct> list = order.getCartProducts();

        // Iterator.remove is the only safe way to modify a collection during iteration
        for (Iterator<CartProduct> iterator = list.iterator(); iterator.hasNext();) {
            // Get the cart product object from list.
            CartProduct cartProduct = iterator.next();

            // Delete the product if its id equals the id of deleting product.
            if (cartProduct.getProduct().getId() == productId) {
                NumberFormat formatter = new DecimalFormat("#0.00");
                // Remove price of deleting product from total price.
                subtotal -= Double.parseDouble(formatter.format((cartProduct.getPrice() * cartProduct.getQuantity())));
                totalWeight -= Double.parseDouble(formatter.format(((cartProduct.getWeight() * cartProduct.getQuantity()))));
                // Tax is 9.375%
                totalTax = Double.parseDouble(formatter.format((subtotal * 0.09375)));
                total = Double.parseDouble(formatter.format((subtotal + totalTax)));

                session.setAttribute("subtotal", subtotal);
                session.setAttribute("total_weight", totalWeight);
                session.setAttribute("total_tax", totalTax);
                session.setAttribute("total", total);

                // Remove product from cart.
                iterator.remove();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if request is remove product from cart or not.
        if (request.getParameter("remove-product-id") != null) {
            Order order = (Order) session.getAttribute("order");
            double subtotal = (double) session.getAttribute("subtotal");
            double totalWeight = (double) session.getAttribute("total_weight");
            double totalTax = (double) session.getAttribute("total_tax");
            double total = (double) session.getAttribute("total");
            int productId = Integer.parseInt(request.getParameter("remove-product-id"));
            removeCartProduct(session, productId, order, subtotal, totalWeight, totalTax, total);
            response.sendRedirect("cart.jsp");
            return;
        }

        // Initialize default value for quantity and productId.
        int quantity = 1;
        int productId;
        // Check is the total price of order exist or not.
        double subtotal;
        double totalWeight;
        double totalTax;
        double total;
        if (session.getAttribute("total") == null) {
            subtotal = 0;
            totalWeight = 0;
            totalTax = 0;
            total = 0;
        } else {
            NumberFormat formatter = new DecimalFormat("#0.00");
//            subtotal = (double) session.getAttribute("subtotal");
//            totalWeight = (double) session.getAttribute("total_weight");
//            totalTax = (double) session.getAttribute("total_tax");
//            total = subtotal + totalTax;
            subtotal = Double.parseDouble(formatter.format(String.valueOf((double) session.getAttribute("subtotal"))));
            totalWeight = Double.parseDouble(formatter.format(String.valueOf((double) session.getAttribute("total_weight"))));
            totalTax = Double.parseDouble(formatter.format(String.valueOf((double) session.getAttribute("total_tax"))));
            total = Double.parseDouble(formatter.format(String.valueOf(subtotal + totalTax)));
        }

        // Generate if product exist in database.
        if (request.getParameter("product-id") != null) {
            // Get the id of product from request.
            productId = Integer.parseInt(request.getParameter("product-id"));

            // Get product information from database.
            Product product = productDao.getProduct(productId);
            if (product != null) {
                // Get the quantity of the adding product.
                if (request.getParameter("quantity") != null) {
                    // Get the quantity of the product if the quantity is more than 1.
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                    // Check if the request quantity is more than the number of products left or not.
                    if (product.getAmount() - quantity < 0) {
                        response.sendRedirect("product-detail?id="+product.getId()+"&invalid-quantity=1");
                        return;
                    }
                }
                // Check the product has been added to cart yet.
                if (session.getAttribute("order") == null) {
                    // Create an order and list of product for it.
                    Order order = new Order();
                    List<CartProduct> list = new ArrayList<>();

                    // Create a product and its quantity for the order.
                    CartProduct cartProduct = new CartProduct();
                    cartProduct.setQuantity(quantity);
                    cartProduct.setProduct(product);
                    cartProduct.setPrice(product.getPrice());
                    cartProduct.setWeight(product.getWeight());

                    // Count the total price of the order.
                    NumberFormat formatter = new DecimalFormat("#0.00");

                    subtotal += Double.parseDouble(formatter.format((product.getPrice() * quantity)));
                    totalWeight += Double.parseDouble(formatter.format((product.getWeight() * quantity)));

                    // Tax is 9.375%
                    totalTax = Double.parseDouble(formatter.format((subtotal * 0.09375)));

                    // Cart total
                    total = Double.parseDouble(formatter.format((subtotal + totalTax)));

                    // Add product to list.
                    list.add(cartProduct);

                    // Add list of cart products to order.
                    order.setCartProducts(list);

                    session.setAttribute("subtotal", subtotal);
                    session.setAttribute("total_weight", totalWeight);
                    session.setAttribute("total_tax", totalTax);
                    session.setAttribute("total", total);
                    session.setAttribute("order", order);
                } else {
                    // Get exist order from session.
                    Order order = (Order) session.getAttribute("order");
                    // Get the list of products from order.
                    List<CartProduct> list = order.getCartProducts();

                    // Increase the product quantity if it is already exist in cart.
                    boolean flag = false;
                    for (CartProduct cartProduct : list) {
                        if (cartProduct.getProduct().getId() == product.getId()) {
                            cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
                            subtotal += product.getPrice() * quantity;
                            totalWeight += product.getWeight() * quantity;
                            totalTax = subtotal * 0.09375;
                            total = subtotal + totalTax;
                            flag = true;
                        }
                    }

                    // Add new product to existing cart.
                    if (!flag) {
                        CartProduct cartProduct = new CartProduct();
                        cartProduct.setQuantity(quantity);
                        cartProduct.setProduct(product);
                        cartProduct.setPrice(product.getPrice());
                        subtotal += product.getPrice() * quantity;
                        totalWeight += product.getWeight() * quantity;
                        totalTax = subtotal * 0.09375;
                        total = subtotal + totalTax;
                        list.add(cartProduct);
                    }

                    session.setAttribute("subtotal", subtotal);
                    session.setAttribute("total_weight", totalWeight);
                    session.setAttribute("total_tax", totalTax);
                    session.setAttribute("total", total);
                    session.setAttribute("order", order);
                }
            }
            response.sendRedirect("product-detail?id=" + productId);
        }
    }
}
