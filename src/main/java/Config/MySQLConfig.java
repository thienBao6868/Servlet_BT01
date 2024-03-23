package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConfig {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// connect to the MySQL database
			String url = "jdbc:mysql://localhost:3307/btqlsanpham";
			String username = "root";
			String password = "bao123";
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Lỗi rồi bé ơi");
		}
		return connection;
	}

}
