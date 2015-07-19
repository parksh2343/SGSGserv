package cama.biz;

import java.sql.Connection;
import java.util.ArrayList;

import common.JdbcTemplate;

import cama.dao.CamaDao;
import cama.dto.CamaDto;


public class CamaBiz {
	
	public ArrayList<CamaDto> getTestList(String personId){
		
		ArrayList<CamaDto> camaList = new ArrayList<CamaDto>();
		Connection conn = JdbcTemplate.getConnection();
		CamaDao dao = new CamaDao(conn);
		camaList = dao.getCamaSample();
		JdbcTemplate.close(conn);
		
		return camaList;
		
	}

}
