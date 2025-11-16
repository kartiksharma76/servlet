package com.example.atm.servlet;

import com.example.atm.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("userId") == null) {
            resp.sendRedirect("login");
            return;
        }
        int userId = (int) s.getAttribute("userId");
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT balance FROM users WHERE id = ?")) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    req.setAttribute("balance", rs.getBigDecimal(1));
                } else {
                    req.setAttribute("error", "Account not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Could not fetch balance.");
        }
        req.getRequestDispatcher("balance.jsp").forward(req, resp);
    }
}
