package com.example.atm.servlet;

import com.example.atm.util.DBUtil;
import com.example.atm.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNo = req.getParameter("account_no");
        String pin = req.getParameter("pin");
        if (accountNo == null || pin == null) {
            req.setAttribute("error", "Provide account number and pin.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        String sql = "SELECT id, pin_hash, name FROM users WHERE account_no = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, accountNo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String stored = rs.getString("pin_hash");
                    if (PasswordUtil.verifyPin(pin, stored)) {
                        HttpSession session = req.getSession(true);
                        session.setAttribute("userId", rs.getInt("id"));
                        session.setAttribute("accountNo", accountNo);
                        session.setAttribute("userName", rs.getString("name"));
                        resp.sendRedirect("dashboard");
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        req.setAttribute("error", "Invalid credentials.");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
