package com.fooddelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Connection conn = DBConnection.getConnection();

        try {
            if ("register".equals(action)) {
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO user(username,email,password) VALUES(?,?,?)"
                );
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.executeUpdate();
                response.sendRedirect("login.jsp");

            } else if ("login".equals(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM user WHERE email=? AND password=?"
                );
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", rs.getInt("id"));
                    session.setAttribute("username", rs.getString("username"));
                    response.sendRedirect("FoodServlet");
                } else {
                    response.sendRedirect("login.jsp?error=invalid");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
