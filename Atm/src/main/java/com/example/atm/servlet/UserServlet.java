package com.example.atm.servlet;

import com.example.atm.util.DBUtil;
import com.example.atm.util.PasswordUtil;
import com.example.atm.util.PinGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("register".equals(action)) {
            String name = request.getParameter("name");
            String account_no = "ACC" + (1000 + new Random().nextInt(9000));
            String pin = PinGenerator.generatePin();
            String pinHash = PasswordUtil.hashPin(pin);

            try(Connection conn = DBUtil.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO users(account_no,name,pin_hash,balance) VALUES(?,?,?,?)"
                );
                ps.setString(1, account_no);
                ps.setString(2, name);
                ps.setString(3, pinHash);
                ps.setDouble(4, 0.0);
                ps.executeUpdate();

                request.setAttribute("account_no", account_no);
                request.setAttribute("pin", pin);
                request.getRequestDispatcher("register_success.jsp").forward(request, response);

            } catch(SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error: "+e.getMessage());
            }

        } else if("login".equals(action)) {
            String account_no = request.getParameter("account_no");
            String pin = request.getParameter("pin");

            try(Connection conn = DBUtil.getConnection()) {
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE account_no=?");
                ps.setString(1, account_no);
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    String storedHash = rs.getString("pin_hash");
                    if(PasswordUtil.verifyPin(pin, storedHash)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userId", rs.getInt("id"));
                        session.setAttribute("name", rs.getString("name"));
                        session.setAttribute("balance", rs.getDouble("balance"));
                        response.sendRedirect("dashboard.jsp");
                        return;
                    }
                }

                request.setAttribute("msg", "Invalid credentials");
                request.getRequestDispatcher("login.jsp").forward(request,response);

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
