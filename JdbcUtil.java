package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection 관리클래스
 *
 */
public class JdbcUtil {
	public static Connection getConnection() {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "SCOTT";
		String pw = "tiger";
		
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
		
		return con;
	}
	public static void close(ResultSet rs, Statement st, Connection con) {
		
		try {
			if(rs != null) rs.close();
			if(st  != null) st.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
