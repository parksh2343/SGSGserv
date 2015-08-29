package sgsg.biz;

import java.sql.Connection;
import java.sql.ResultSet;

import sgsg.dao.SgsgDao;

import common.JdbcTemplate;


public class SgsgBiz {
	
	public ResultSet getDBdata(String query) throws Exception{
		
		ResultSet rs;
		Connection conn = JdbcTemplate.getConnection();
		SgsgDao dao = new SgsgDao(conn);
		rs = dao.getDBdataDao(query);
		JdbcTemplate.close(conn);
		
		return rs;
		
	}
	
	public int updateDBdata(String query) throws Exception{
		
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		SgsgDao dao = new SgsgDao(conn);
		result = dao.updateDBdataDao(query);
		JdbcTemplate.close(conn);
		
		return result;
		
	}

}
