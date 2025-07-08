package com.hm.controller;

import com.hm.dto.Registration;
import com.hm.service.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Registration r = new Registration();
        r.setEnrollmentNumber(request.getParameter("enrollment"));
        r.setName(request.getParameter("name"));
        r.setEmail(request.getParameter("email"));
        r.setPassword(request.getParameter("password"));
        r.setBranch(request.getParameter("branch"));
        r.setYear(request.getParameter("year"));
        r.setDob(request.getParameter("dob"));
        r.setBloodGroup(request.getParameter("blood_group"));
        r.setMobile(request.getParameter("mobile"));
        r.setFatherName(request.getParameter("father_name"));
        r.setFatherMobile(request.getParameter("father_mobile"));
        r.setRoomId(request.getParameter("room_id"));

        boolean success = new RegistrationServiceImpl().registerUser(r);

        if (success) {
            response.sendRedirect("index.jsp?message=Registered successfully");
        } else {
            response.sendRedirect("registration.jsp?error=Registration failed");
        }
    }
}
