package common;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class JdbcTemplate {

	/**
	 * Connention을 연결한 후 멤버 attribute인 conn에 Connection 객체를 세팅한 후 리턴한다.
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			//여기는 마리아디비에 맞게 수정 필요
            Context envCtx = (Context)initContext.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/camaDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("getConnection " + e.getMessage());
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * DB와 connect 여부 return
	 */
	public static boolean isConnected(Connection conn) {
		
		boolean validConnection = true;
		
		try {
			if (conn == null || conn.isClosed())
				validConnection = false;
			
		} catch (Exception e) {
			validConnection = false;
			e.printStackTrace();
			
		}
		return validConnection;
		
	}
	
	/**
	 * Connection 객체를 시스템에 반환
	 */
	public static void close(Connection conn) {
		
		if(isConnected(conn)) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Statement 를 close
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt != null) 
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * resultset 을 close
	 */
	public static void close(ResultSet rset) {
		try {
			if(rset != null) 
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 트랜잭션을 커밋한다
	 */
	public static void commit(Connection conn) {
		
		try {
			if(isConnected(conn)) {
				conn.commit();
				System.out.println("commit");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  트랜잭션을 롤백한다
	 */
	public static void rollback(Connection conn) {
		
		try {
			if(isConnected(conn)) {
				conn.rollback();
				System.out.println("rollback");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
