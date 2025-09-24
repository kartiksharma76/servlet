package com.example.servlet;

import com.example.model.User;
import com.example.util.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", UserStorage.getUsers());
        request.getRequestDispatcher("/guestbook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        // Basic Validation
        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty()) {

            request.setAttribute("error", "Name, Email, and Phone are required!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        User user = new User(name.trim(), email.trim(), phone.trim(), address.trim(), gender, dob);
        UserStorage.addUser(user);

        response.sendRedirect(request.getContextPath() + "/guestbook");
    }
}