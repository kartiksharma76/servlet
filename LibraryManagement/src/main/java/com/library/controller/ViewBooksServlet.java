package com.library.controller;

import com.library.util.DBUtil;
import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewBooksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Connection con = DBUtil.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            req.setAttribute("bookList", rs);
            RequestDispatcher rd = req.getRequestDispatcher("view_books.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
