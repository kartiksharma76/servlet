package com.hostelmanagement;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Kartik@2005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollment = request.getParameter("enrollment");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                 PreparedStatement stmt = conn.prepareStatement(
                     "SELECT name FROM student WHERE enrollment_no = ? AND password = ?")) {

                stmt.setString(1, enrollment);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("enrollment", enrollment);
                    session.setAttribute("name", rs.getString("name"));
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=Invalid+Credentials");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Server+Error");
        }
    }
}
