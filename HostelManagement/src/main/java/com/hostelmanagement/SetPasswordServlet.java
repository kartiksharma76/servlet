package com.hostelmanagement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SetPasswordServlet")
public class SetPasswordServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollment = request.getParameter("enrollment");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        if (!password.equals(confirm_password)) {
            response.sendRedirect("setPassword.jsp?error=Passwords do not match");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                PreparedStatement ps = conn.prepareStatement(
                    "UPDATE student SET password = ? WHERE enrollment_no = ?");
                ps.setString(1, password);
                ps.setString(2, enrollment);

                int result = ps.executeUpdate();

                if (result > 0) {
                    request.setAttribute("success", "Password set successfully! Now you can log in.");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("setPassword.jsp?error=Student not found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("setPassword.jsp?error=Server error");
        }
    }
}
