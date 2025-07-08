package com.hm.jdbc.utils;

import java.sql.*;

public class JdbcUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConnection() {
        String url = "jdbc:mysql://localhost:3306/hostel"; // change if needed
        try {
            return DriverManager.getConnection(url, "root", "Kartik@2005"); // update password if needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeResource(Statement st, Connection con, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
