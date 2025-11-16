package com.fooddelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class FoodServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Map<String, Object>> foodList = new ArrayList<>();
        int page = 1;
        int recordsPerPage = 20; // 20 items per page

        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int start = (page-1)*recordsPerPage;

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM food LIMIT ?,?");
            ps.setInt(1, start);
            ps.setInt(2, recordsPerPage);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Map<String,Object> food = new HashMap<>();
                food.put("id", rs.getInt("id"));
                food.put("name", rs.getString("name"));
                food.put("price", rs.getDouble("price"));
                food.put("description", rs.getString("description"));
                foodList.add(food);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("foodList", foodList);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}
