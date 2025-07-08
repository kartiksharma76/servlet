// RegistrationRepositoryImpl.java
package com.hm.repository;

import java.sql.*;
import com.hm.dto.Registration;
import com.hm.jdbc.utils.JdbcUtils;

public class RegistrationRepositoryImpl implements RegistrationRepository {
    public boolean saveStudentDetails(Registration r) {
        String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = JdbcUtils.getMysqlConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, r.getEnrollmentNumber());
            ps.setString(2, r.getName());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getPassword());
            ps.setString(5, r.getBranch());
            ps.setString(6, r.getYear());
            ps.setString(7, r.getDob());
            ps.setString(8, r.getBloodGroup());
            ps.setString(9, r.getMobile());
            ps.setString(10, r.getFatherName());
            ps.setString(11, r.getFatherMobile());
            ps.setString(12, r.getRoomId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Registration failed:");
            e.printStackTrace();
            return false;
        }
    }
}
