package com.hostelmanagement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String enrollment = request.getParameter("enrollment");
        String email = request.getParameter("email");
        String branch = request.getParameter("branch");
        String year = request.getParameter("year");
        String dob = request.getParameter("dob");
        String blood_group = request.getParameter("blood_group");
        String mobile = request.getParameter("mobile");
        String father_name = request.getParameter("father_name");
        String father_mobile = request.getParameter("father_mobile");
        String room_id = request.getParameter("room_id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO student (enrollment_no, name, email, branch, year, dob, blood_group, mobile_no, father_name, father_mobile, room_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                ps.setString(1, enrollment);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setString(4, branch);
                ps.setString(5, year);
                ps.setString(6, dob);
                ps.setString(7, blood_group);
                ps.setString(8, mobile);
                ps.setString(9, father_name);
                ps.setString(10, father_mobile);
                ps.setString(11, room_id);

                int result = ps.executeUpdate();

                if (result > 0) {
                    request.setAttribute("enrollment", enrollment);
                    RequestDispatcher rd = request.getRequestDispatcher("setPassword.jsp");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("registration.jsp?error=Registration failed");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registration.jsp?error=Server error");
        }
    }
}
