package solution.proj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
	private static final String USER = "root";
	private static final String PWD = "piyush";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connectToDB() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Unsuccessful" + e.getMessage());
		}
		return con;
	}

	public static void closeResources(PreparedStatement ps, ResultSet rs,
			Connection con) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBUtil.connectToDB();
	}
}
