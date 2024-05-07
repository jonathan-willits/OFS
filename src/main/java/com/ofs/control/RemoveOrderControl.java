package com.ofs.control;

import com.ofs.dao.OrderDao;
import com.ofs.entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveOrder", value = "/remove-order")
public class RemoveOrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the id of the order that need to remove from request.
        int orderId = Integer.parseInt(request.getParameter("order-id"));
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
