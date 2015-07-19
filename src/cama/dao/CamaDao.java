package cama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;

import cama.dto.CamaDto;

public class CamaDao {
	private Connection conn;
	
	public CamaDao() {
		
	}
	
	public CamaDao(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<CamaDto> getCamaSample() {
		ArrayList<CamaDto> camaSampleList = new ArrayList<CamaDto>();
		String query = "select * from test";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			CamaDto dto = null;
			
			while(rs.next()) {
				dto = new CamaDto(rs.getString(1),rs.getString(2), rs.getString(3));
				camaSampleList.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
		return camaSampleList;
	}
	
}
