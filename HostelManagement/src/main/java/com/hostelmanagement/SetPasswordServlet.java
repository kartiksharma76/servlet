package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SetPasswordServlet")
public class SetPasswordServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String enrollment = request.getParameter("enrollment");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm_password");

        if (!password.equals(confirm)) {
            response.sendRedirect("setPassword.jsp?enrollment=" + enrollment + "&error=Passwords+do+not+match");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                 PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE student SET password = ? WHERE enrollment_no = ?")) {

                stmt.setString(1, password);
                stmt.setString(2, enrollment);

                int updated = stmt.executeUpdate();

                if (updated > 0) {
                    request.setAttribute("success", "Password set successfully. Please login.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    response.sendRedirect("setPassword.jsp?error=Enrollment+Not+Found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("setPassword.jsp?error=Server+Error");
        }
    }
}
