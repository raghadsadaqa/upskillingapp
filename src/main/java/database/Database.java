package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Database {
	
	 public Connection getConnection() throws Exception {
	        Context cx = null;
	        try {
	            Connection conn = null;
	            DataSource ds = null;
	            cx = new InitialContext();
	            ds = (DataSource) cx.lookup("java:/ScottDS");
	            //ds = (DataSource) cx.lookup("jdbc/SisConnDevDS");
	            conn = ds.getConnection();
	            return conn;
	        } finally {
	            cx.close();
	        }
	    }
	
	

	/*public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}*/
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(CallableStatement cs) {
		try {
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
