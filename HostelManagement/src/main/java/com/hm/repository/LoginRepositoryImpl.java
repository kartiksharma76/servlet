package com.hm.repository;

import java.sql.*;
import com.hm.dto.Login;
import com.hm.jdbc.utils.JdbcUtils;

public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public Login fetchLoginDetails(String enrollmentNumber, String password) {
        String query = "SELECT * FROM student WHERE enrollment_no = ? AND password = ?";
        Login login = null;

        try (Connection conn = JdbcUtils.getMysqlConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, enrollmentNumber);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setEnrollmentNumber(rs.getString("enrollment_no"));
                login.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }
}