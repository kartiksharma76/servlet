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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
System.out.println("context path "+request.getContextPath());
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect("index.jsp");
        } else if (pathInfo.equals("/login")) {
            boolean validated = new LoginServiceImpl().validateUser(request, response);
            if (validated) {
                request.getSession().setAttribute("enrollment", request.getParameter("enrollment"));
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/dashboard.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp?error=Invalid credentials");
            }
        }
        else if("/newUser".equals(pathInfo)) {
        	 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
             rd.forward(request, response);
        }
        else if("/registration".equals(pathInfo)) {
        	//send to  registration service
        	RegistrationService service=new RegistrationServiceImpl();
        	boolean success = service.registerUser(request, response);
        	if(success) {
        		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/success.jsp");
                rd.forward(request, response);	
        	}else {
        		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
                 rd.forward(request, response);
        	}
        	 
        }
    }
}