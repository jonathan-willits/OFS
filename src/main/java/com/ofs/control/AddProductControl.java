package com.ofs.control;

import com.ofs.dao.ProductDao;
import com.ofs.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "AddProductControl", value = "/add-product")
@MultipartConfig
public class AddProductControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get product information from request.
        String productName = request.getParameter("product-name");
        double productPrice = Double.parseDouble((request.getParameter("product-price")));
        String productDescription = request.getParameter("product-description");
        int productCategory = Integer.parseInt(request.getParameter("product-category"));
        int productAmount = Integer.parseInt(request.getParameter("product-amount"));
        double productWeight = Double.parseDouble((request.getParameter("product-weight")));

        // Get upload image.
        Part part = request.getPart("product-image");
        InputStream inputStream = part.getInputStream();

        // Get the seller id for product.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int sellerId = account.getId();

        // Add product to database.
        ProductDao productDao = new ProductDao();
        productDao.addProduct(productName, inputStream, productPrice, productDescription, productCategory, sellerId, productAmount, productWeight);
        response.sendRedirect("product-management");
    }
}
