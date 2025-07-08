package com.hm.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.hm.service.LoginServiceImpl;

@WebServlet("/portal/*")
public class HostelManagementController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else if (pathInfo.equals("/login")) {
            boolean validated = new LoginServiceImpl().validateUser(request, response);
            if (validated) {
                request.getSession().setAttribute("enrollment", request.getParameter("enrollment"));
                RequestDispatcher rd = request.getRequestDispatcher("/portal/dashboard.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp?error=Invalid credentials");
            }
        }
    }
}
