package com.hostelmanagement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ComplainServlet")
public class ComplainServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollment = request.getParameter("enrollment");
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO complaints (enrollment_no, category, description) VALUES (?, ?, ?)");
                ps.setString(1, enrollment);
                ps.setString(2, category);
                ps.setString(3, description);

                int result = ps.executeUpdate();

                if (result > 0) {
                    request.setAttribute("message", "Complaint submitted successfully!");
                } else {
                    request.setAttribute("message", "Failed to submit complaint.");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Server error occurred while submitting.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
}
