package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/monitorWater.do")
public class WaterServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String source = request.getParameter("source");
        String supplyTime = request.getParameter("supplyTime");
        String status = request.getParameter("status");
        String message = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hostel", "root", "Kartik@2005");

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO water_monitoring (source, supply_time, status) VALUES (?, ?, ?)");
            ps.setString(1, source);
            ps.setString(2, supplyTime);
            ps.setString(3, status);
            ps.executeUpdate();

            message = "Water monitoring entry saved successfully!";
            conn.close();
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
        }

        request.setAttribute("waterMessage", message);
        request.getRequestDispatcher("water_monitor.jsp").forward(request, response);
    }
}
