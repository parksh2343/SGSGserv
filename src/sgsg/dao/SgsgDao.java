package sgsg.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JdbcTemplate;

public class SgsgDao {
	private Connection conn;
	
	public SgsgDao() {
		
	}
	
	public SgsgDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet getDBdataDao(String query) throws Exception {

		String stackTrace = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
		} catch (Exception e) {
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			stackTrace = sw.toString();
			
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
		if(stackTrace != null) {
			throw new Exception(stackTrace);
		}
		
		return rs;
	}
	
	public int updateDBdataDao(String query) throws Exception {
		
		String stackTrace = null;
		
		PreparedStatement stmt = null;
		int result = 0;
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			stackTrace = sw.toString();
			
		} finally {
			JdbcTemplate.close(stmt);
		}
		
		if(stackTrace != null) {
			throw new Exception(stackTrace);
		}
		
		return result;
	}
}
