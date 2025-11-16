package com.hm.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.hm.service.LoginServiceImpl;
import com.hm.service.RegistrationService;
import com.hm.service.RegistrationServiceImpl;

@WebServlet("/portal/*")
public class HostelManagementController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        System.out.println("Path Info: " + pathInfo);

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } 
        else if (pathInfo.equals("/login")) {
            boolean validated = new LoginServiceImpl().validateUser(request, response);
            if (validated) {
                String enrollment = request.getParameter("enrollment");
                request.getSession().setAttribute("enrollment", enrollment);
                request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=Invalid credentials");
            }
        }
        else if ("/newUser".equals(pathInfo)) {
            request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
        else if ("/registration".equals(pathInfo)) {
            RegistrationService service = new RegistrationServiceImpl();
            boolean success = service.registerUser(request, response);
            if (success) {
                // Set success message and redirect to login
                response.sendRedirect(request.getContextPath() + "/login.jsp?message=Registration Successful! Please login.");
            } else {
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
            }
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
        }
    }
}