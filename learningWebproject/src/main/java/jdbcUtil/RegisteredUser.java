package jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisteredUser {
	public static boolean verifyUser(String username, String phone ,String email,String gender,String course,String timing) {
		  String query = "SELECT * FROM login  WHERE username=? AND phone=? AND email=? AND gender=? AND course=? AND timing=?";

		try (Connection connection = JdbcUtilUser.getMysqlConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5 ,course);
			ps.setString(6,timing);
			ResultSet rs = ps.executeQuery();

			return rs.next(); // returns true if a matching user is found
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static void insert(String username, String phone ,String email,String gender,String course,String timing) {
		 String query = "INSERT INTO login  (username, phone, email, gender, course, timing) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = JdbcUtilUser.getMysqlConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5 ,course);
			ps.setString(6,timing);
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

}
