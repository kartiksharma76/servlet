package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hostel.do")
public class HostelServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {

                if ("allocate".equals(action)) {
                    String studentId = request.getParameter("studentId");
                    String roomNumber = request.getParameter("roomNumber");
                    String allocationDate = request.getParameter("allocationDate");

                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO room_allocation (student_id, room_number, allocation_date, status) VALUES (?, ?, ?, 'Active')");
                    ps.setString(1, studentId);
                    ps.setString(2, roomNumber);
                    ps.setString(3, allocationDate);
                    ps.executeUpdate();

                    request.setAttribute("roomMessage", "Room allocated successfully!");
                    request.getRequestDispatcher("hostel.jsp").forward(request, response);

                } else if ("feedback".equals(action)) {
                    String studentId = request.getParameter("studentId");
                    String menuDate = request.getParameter("menuDate");
                    String menuItems = request.getParameter("menuItems");
                    String feedback = request.getParameter("feedback");

                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO food_menu_feedback (menu_date, menu_items, student_id, feedback) VALUES (?, ?, ?, ?)");
                    ps.setDate(1, Date.valueOf(menuDate));
                    ps.setString(2, menuItems);
                    ps.setString(3, studentId);
                    ps.setString(4, feedback);
                    ps.executeUpdate();

                    request.setAttribute("feedbackMessage", "Thanks! Your feedback is submitted.");
                    request.getRequestDispatcher("hostel.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("feedbackMessage", "Error: " + e.getMessage());
            request.getRequestDispatcher("hostel.jsp").forward(request, response);
        }
    }
}
