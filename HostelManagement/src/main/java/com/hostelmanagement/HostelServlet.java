package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hostel.do")
public class HostelServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String message = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hostel", "root", "Kartik@2005");

            if ("allocate".equals(action)) {
                String studentId = request.getParameter("studentId");
                String roomNumber = request.getParameter("roomNumber");
                String allocationDate = request.getParameter("allocationDate");

                PreparedStatement check = conn.prepareStatement(
                    "SELECT COUNT(*) AS count FROM room_allocation WHERE room_number = ? AND status = 'Active'");
                check.setString(1, roomNumber);
                ResultSet rs = check.executeQuery();
                rs.next();

                if (rs.getInt("count") >= 2) {
                    message = "Room already full (Max 2 students).";
                } else {
                    PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO room_allocation (student_id, room_number, allocation_date, status) VALUES (?, ?, ?, 'Active')");
                    ps.setString(1, studentId);
                    ps.setString(2, roomNumber);
                    ps.setString(3, allocationDate);
                    ps.executeUpdate();
                    message = "Room allocated successfully!";
                }

                request.setAttribute("roomMessage", message);
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

                message = "Thank you! Your feedback is submitted.";
                request.setAttribute("feedbackMessage", message);
                request.getRequestDispatcher("hostel.jsp").forward(request, response);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            message = "Error: " + e.getMessage();
            request.setAttribute("feedbackMessage", message);
            request.getRequestDispatcher("hostel.jsp").forward(request, response);
        }
    }
}
