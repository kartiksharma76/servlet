package com.fooddelivery;
import java.sql.*;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery","root","Kartik@2005"
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
