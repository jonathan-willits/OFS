package edu.sjsu.cs.cs160_project.servlet;

import java.io.*;

import edu.sjsu.cs.cs160_project.controller.DatabaseManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet{
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("psw");

        PrintWriter writer = response.getWriter();
        writer.println("<html> email: " + email + ", username: " + username + ", password: " + password + "</html>");
        writer.flush();
    }

    public void destroy() {
    }
}
