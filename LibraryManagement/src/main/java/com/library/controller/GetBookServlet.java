package com.library.controller;

import com.library.util.DBUtil;
import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            req.setAttribute("rs", rs);
            RequestDispatcher rd = req.getRequestDispatcher("edit_book.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
