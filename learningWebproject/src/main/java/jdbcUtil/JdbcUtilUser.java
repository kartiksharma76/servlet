package jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilUser {
	// 1.load the driver
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	//2. Establish the connection between JDBC and database
		public static Connection getMysqlConnection() {
			String url = "jdbc:mysql://localhost:3306/register ";
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(url, "root", "Kartik@2005");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	//3.close the sources
		public static void closeResource(Statement st, Connection con) {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public static void closeResource(Statement st, Connection con, ResultSet rs) {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
