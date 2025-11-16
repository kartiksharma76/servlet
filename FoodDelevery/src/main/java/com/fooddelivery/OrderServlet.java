package com.fooddelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if(userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String foodIdStr = request.getParameter("foodId");
        String quantityStr = request.getParameter("quantity");

        if(foodIdStr == null || foodIdStr.trim().isEmpty() ||
           quantityStr == null || quantityStr.trim().isEmpty()) {
            response.sendRedirect("FoodServlet");
            return;
        }

        try {
            int foodId = Integer.parseInt(foodIdStr.trim());
            int quantity = Integer.parseInt(quantityStr.trim());
            if(quantity <= 0) quantity = 1;

            Connection conn = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("SELECT price FROM food WHERE id=?");
            ps1.setInt(1, foodId);
            ResultSet rs = ps1.executeQuery();

            if(rs.next()) {
                double price = rs.getDouble("price");
                double total = price * quantity;

                PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO orders(user_id, food_id, quantity, total) VALUES(?,?,?,?)"
                );
                ps2.setInt(1, userId);
                ps2.setInt(2, foodId);
                ps2.setInt(3, quantity);
                ps2.setDouble(4, total);
                ps2.executeUpdate();

                // Order successful
                response.sendRedirect("OrderHistoryServlet");
            } else {
                // Invalid foodId
                response.sendRedirect("FoodServlet");
            }
        } catch(NumberFormatException e) {
            response.sendRedirect("FoodServlet");
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("FoodServlet");
        }
    }
}
