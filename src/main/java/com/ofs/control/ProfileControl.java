package com.ofs.control;

import com.ofs.dao.AccountDao;
import com.ofs.entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ProfileControl", value = "/profile-page")
@MultipartConfig
public class ProfileControl extends HttpServlet {
    // Call DAO class to access with the database.
    AccountDao accountDao = new AccountDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile-page.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        int accountId = account.getId();
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String creditCard = request.getParameter("credit_card");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String cvv = request.getParameter("cvv");
        String zipCode = request.getParameter("zip_code");

        // Set default profile image for account.
        Part part = request.getPart("profile-image");
        InputStream inputStream = part.getInputStream();

        System.out.println(accountId + " " + firstName + " " + lastName + " " + address + " " + email + " " + phone + " " + creditCard + " " + month + " " + year + " " + cvv + " " + zipCode);

        accountDao.editProfileInformation(accountId, firstName, lastName, address, email, phone, inputStream, Long.parseLong(creditCard), Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(cvv), Integer.parseInt(zipCode));
        response.sendRedirect("login");
    }
}
