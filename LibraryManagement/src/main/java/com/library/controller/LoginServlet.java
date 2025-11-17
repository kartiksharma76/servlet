package com.library.controller;

import com.library.util.DBUtil;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?"
            );

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                res.sendRedirect("index.jsp");
            } else {
                res.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}