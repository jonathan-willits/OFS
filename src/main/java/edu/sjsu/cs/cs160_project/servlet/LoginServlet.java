package edu.sjsu.cs.cs160_project.servlet;

import edu.sjsu.cs.cs160_project.database.*;
import edu.sjsu.cs.cs160_project.controller.*;

import java.io.*;
import java.util.Objects;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    public void init() {
        // connect to database

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();


        DatabaseManager db = null;
        User user = null;
        try {
            db = new DatabaseManager();
            UserManager u = new UserManager(db);
            user = u.get_user(username);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // search database for username and password
        // if found, redirect to user profile page
        // else alert user that username or password is incorrect

        writer.println(user.get_name() + " " + user.get_password() + " " + user.get_email());
        writer.println("<html> username: " + username + ", password: " + password + "</html>");

        if (Objects.equals(user.get_name(), username) && Objects.equals(user.get_password(), password)){
//            response.sendRedirect("profile.jsp");
            writer.println("<html> username or password is correct </html>");
            writer.flush();
        } else {
            writer.println("<html><body><script>alert('Hello World!');</script></body></html>");
            writer.println("<script type=\"text/javascript\">");
            writer.println("window.alert('User or password incorrect');");
            writer.println("location='login.jsp';");
            writer.println("</script>");
//            writer.println("<html> username or password is incorrect </html>");
            writer.flush();

            // alert user that username or password is incorrect
        }
    }

    public void destroy() {
        // close database connection

    }
}
