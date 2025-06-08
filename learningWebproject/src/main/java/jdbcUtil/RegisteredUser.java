package jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisteredUser {
	public static boolean verifyUser(String username, String phone, String email, String gender, String course,
			String timing) {
		String query = "SELECT * FROM login  WHERE username=? AND phone=? AND email=? AND gender=? AND course=? AND timing=?";

		try (Connection connection = JdbcUtilUser.getMysqlConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setString(5, course);
			ps.setString(6, timing);
			ResultSet rs = ps.executeQuery();

			return rs.next(); // returns true if a matching user is found
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void insert(String username, String phone, String email, String gender, String course,
			String timing) {
		String query = "INSERT INTO login  (username, phone, email, gender, course, timing) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = JdbcUtilUser.getMysqlConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setString(5, course);
			ps.setString(6, timing);
			int record = ps.executeUpdate();
			if (record == 1) {
				System.out.println("Record inserted");
			} else {
				System.out.println("Record not inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Student> getAll() {
		String query = "SELECT * FROM login";
		List<Student> list = new ArrayList<>();
		try (Connection connection = JdbcUtilUser.getMysqlConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				/*
				 * phone VARCHAR(50) PRIMARY KEY, username VARCHAR(100), email VARCHAR(100),
				 * gender VARCHAR(10), course VARCHAR(100), timing VARCHAR(100)
				 */
				Student stu = new Student();
				stu.setPhone(rs.getString(1));
				stu.setUsername(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setGender(rs.getString(4));
				stu.setCourse(rs.getString(5));
				stu.setTiming(rs.getString(6));
				list.add(stu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
