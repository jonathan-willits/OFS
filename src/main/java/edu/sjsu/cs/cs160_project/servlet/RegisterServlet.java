package edu.sjsu.cs.cs160_project.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet{
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("psw");

        PrintWriter writer = response.getWriter();
        writer.println("<html> email: " + email + ", username: " + username + ", password: " + password + "</html>");
        writer.flush();
    }

    public void destroy() {}
}