package com.library.controller;

import com.library.util.DBUtil;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            res.sendRedirect("ViewBooksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
