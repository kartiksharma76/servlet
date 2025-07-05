package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/monitorWater.do")
public class WaterServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String source = request.getParameter("source");
        String supplyTime = request.getParameter("supplyTime");
        String status = request.getParameter("status");

        // Basic validation
        if (source == null || source.trim().isEmpty() ||
            supplyTime == null || supplyTime.trim().isEmpty() ||
            status == null || status.trim().isEmpty()) {
            
            request.setAttribute("message", "All fields are required.");
            request.getRequestDispatcher("water_monitor.jsp").forward(request, response);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                 PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO water_monitoring (source, supply_time, status) VALUES (?, ?, ?)")) {

                stmt.setString(1, source);
                stmt.setString(2, supplyTime);
                stmt.setString(3, status);

                int result = stmt.executeUpdate();

                if (result > 0) {
                    request.setAttribute("message", "Water supply data logged successfully ✅");
                } else {
                    request.setAttribute("message", "Failed to log water data ❌");
                }

                request.getRequestDispatcher("water_monitor.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Server error: " + e.getMessage());
            request.getRequestDispatcher("water_monitor.jsp").forward(request, response);
        }
    }
}
