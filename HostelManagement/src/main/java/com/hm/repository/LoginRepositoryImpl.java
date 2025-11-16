package com.hm.repository;

import java.sql.*;
import com.hm.dto.Login;
import com.hm.jdbc.utils.JdbcUtils;
import com.hm.util.PasswordUtil; // ← Import utility

public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public Login fetchLoginDetails(String enrollmentNumber, String plainPassword) {
        String query = "SELECT enrollment_no, password FROM student WHERE enrollment_no = ?";

        try (Connection conn = JdbcUtils.getMysqlConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, enrollmentNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                // ✅ Verify by hashing input password
                if (PasswordUtil.verifyPassword(plainPassword, storedHashedPassword)) {
                    Login login = new Login();
                    login.setEnrollmentNumber(enrollmentNumber);
                    return login;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Invalid credentials
    }
}