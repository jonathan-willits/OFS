package com.ofs.control;

import com.ofs.dao.CategoryDao;
import com.ofs.dao.ProductDao;
import com.ofs.entity.Category;
import com.ofs.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "EditProductControl", value = "/edit-product")
@MultipartConfig
public class EditProductControl extends HttpServlet {
    // Call DAO class to access with database.
    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get request product from database.
        int productId = Integer.parseInt(request.getParameter("product-id"));
        // Get product from database.
        Product product = productDao.getProduct(productId);
        // Get category for product.
        List<Category> categoryList = categoryDao.getAllCategories();

        request.setAttribute("product", product);
        request.setAttribute("category_list", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the product id from request.
        int productId = Integer.parseInt(request.getParameter("product-id"));
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

        // Add product to database.
        ProductDao productDao = new ProductDao();
        productDao.editProduct(productId, productName, inputStream, productPrice, productDescription, productCategory, productAmount, productWeight);
        response.sendRedirect("product-management");
    }
}
