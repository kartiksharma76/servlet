package com.hostelmanagement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hostel.do")
public class HostelServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

                if ("allocate".equals(action)) {
                    // Room Allocation Block
                    String studentId = request.getParameter("studentId");
                    String roomNumber = request.getParameter("roomNumber");
                    String allocationDate = request.getParameter("allocationDate");

                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO room_allocation (student_id, room_number, allocation_date) VALUES (?, ?, ?)");
                    ps.setString(1, studentId);
                    ps.setString(2, roomNumber);
                    ps.setString(3, allocationDate);

                    int result = ps.executeUpdate();

                    if (result > 0) {
                        request.setAttribute("roomMessage", "Room allocated successfully!");
                    } else {
                        request.setAttribute("roomMessage", "Room allocation failed.");
                    }

                } else if ("feedback".equals(action)) {
                    // Food Feedback Block
                    String studentId = request.getParameter("studentId");
                    String menuDate = request.getParameter("menuDate");
                    String menuItems = request.getParameter("menuItems");
                    String feedback = request.getParameter("feedback");

                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO food_menu_feedback (student_id, menu_date, menu_items, feedback) VALUES (?, ?, ?, ?)");
                    ps.setString(1, studentId);
                    ps.setString(2, menuDate);
                    ps.setString(3, menuItems);
                    ps.setString(4, feedback);

                    int result = ps.executeUpdate();

                    if (result > 0) {
                        request.setAttribute("feedbackMessage", "Feedback submitted successfully!");
                    } else {
                        request.setAttribute("feedbackMessage", "Feedback submission failed.");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("roomMessage", "Server error occurred.");
            request.setAttribute("feedbackMessage", "Server error occurred.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("hostel.jsp");
        rd.forward(request, response);
    }
}
