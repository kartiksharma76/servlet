package com.library.controller;

import com.library.util.DBUtil;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String color = req.getParameter("color");
        String category = req.getParameter("category");
        double cost = Double.parseDouble(req.getParameter("cost"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(title, author, color, category, cost) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, color);
            ps.setString(4, category);
            ps.setDouble(5, cost);

            ps.executeUpdate();
            res.sendRedirect("success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
