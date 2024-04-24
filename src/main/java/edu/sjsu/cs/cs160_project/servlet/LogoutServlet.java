package edu.sjsu.cs.cs160_project.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", value = "/logoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process the action only for GET requests
        HttpSession session = request.getSession(false); // gets current session
        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("login.jsp"); // send back to login
    }
}
