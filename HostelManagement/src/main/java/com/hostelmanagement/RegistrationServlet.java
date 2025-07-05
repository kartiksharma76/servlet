package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String enroll = request.getParameter("enrollment");
        String email = request.getParameter("email");
        String branch = request.getParameter("branch");
        String year = request.getParameter("year");
        String dob = request.getParameter("dob");
        String blood = request.getParameter("blood_group");
        String mobile = request.getParameter("mobile");
        String father = request.getParameter("father_name");
        String fatherMob = request.getParameter("father_mobile");
        String room = request.getParameter("room_id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                 PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO student (name, enrollment_no, email, branch, year, dob, blood_group, mobile_no, father_name, father_mobile, room_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                stmt.setString(1, name);
                stmt.setString(2, enroll);
                stmt.setString(3, email);
                stmt.setString(4, branch);
                stmt.setString(5, year);
                stmt.setString(6, dob);
                stmt.setString(7, blood);
                stmt.setString(8, mobile);
                stmt.setString(9, father);
                stmt.setString(10, fatherMob);
                stmt.setString(11, room);

                int result = stmt.executeUpdate();

                if (result > 0) {
                    request.setAttribute("enrollment", enroll);
                    request.getRequestDispatcher("setPassword.jsp").forward(request, response);
                } else {
                    response.sendRedirect("registration.jsp?error=Registration+Failed");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registration.jsp?error=Server+Error");
        }
    }
}
