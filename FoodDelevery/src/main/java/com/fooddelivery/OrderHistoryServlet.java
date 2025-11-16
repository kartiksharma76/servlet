package com.fooddelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class OrderHistoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        List<Map<String,Object>> orders = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT o.id, f.name, o.quantity, o.total, o.order_date " +
                "FROM orders o JOIN food f ON o.food_id=f.id WHERE o.user_id=?"
            );
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Map<String,Object> order = new HashMap<>();
                order.put("id", rs.getInt("id"));
                order.put("name", rs.getString("name"));
                order.put("quantity", rs.getInt("quantity"));
                order.put("total", rs.getDouble("total"));
                order.put("order_date", rs.getTimestamp("order_date"));
                orders.add(order);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
