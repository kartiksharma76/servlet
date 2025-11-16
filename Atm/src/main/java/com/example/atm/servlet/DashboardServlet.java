package com.example.atm.servlet;

import com.example.atm.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("userId") == null) {
            resp.sendRedirect("login");
            return;
        }
        // fetch balance to show on dashboard
        int userId = (int) s.getAttribute("userId");
        String sql = "SELECT balance FROM users WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    req.setAttribute("balance", rs.getBigDecimal("balance"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}
