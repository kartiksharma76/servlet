package com.example.atm.servlet;

import com.example.atm.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session==null || session.getAttribute("userId")==null){
            request.setAttribute("msg","Please login first");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        int userId = (Integer) session.getAttribute("userId");
        double amount = Double.parseDouble(request.getParameter("amount"));

        try(Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET balance = balance + ? WHERE id=?");
            ps.setDouble(1, amount);
            ps.setInt(2, userId);
            ps.executeUpdate();

            // Update session balance
            PreparedStatement ps2 = conn.prepareStatement("SELECT balance FROM users WHERE id=?");
            ps2.setInt(1, userId);
            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                session.setAttribute("balance", rs.getDouble("balance"));
            }

            response.sendRedirect("dashboard.jsp");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
