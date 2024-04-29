package com.ecommerce.control;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveOrder", value = "/remove-order")
public class RemoveOrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the id of the order that need to remove from request.
        int orderId = Integer.parseInt(request.getParameter("product-id"));
        // Remove order from database.
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrder(orderId);
        orderDao.removeOrder(order);

        response.sendRedirect("order-management");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
