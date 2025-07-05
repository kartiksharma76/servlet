package com.hostelmanagement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // don’t create if it doesn’t exist

        if (session != null) {
            session.invalidate(); // clear session
        }

        response.sendRedirect("login.jsp"); // go back to login
    }
}
