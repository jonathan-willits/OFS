package com.ofs.control;

import com.ofs.dao.OrderDao;
import com.ofs.entity.Account;
import com.ofs.entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderHistoryControl", value = "/order-history")
public class OrderHistoryControl extends HttpServlet {
    // Call DAO class to access with database.
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get account from session.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        // Get order history of account from database.
        List<Order> orderList = orderDao.getOrderHistory(account.getId());

        request.setAttribute("order_list", orderList);
        // Set attribute active for order management tab.
        request.setAttribute("order_history_active", "active");
        // Get request dispatcher and render to order-management page.
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order-history.jsp");
        requestDispatcher.forward(request, response);
    }
}
