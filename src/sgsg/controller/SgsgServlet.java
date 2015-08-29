package sgsg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sgsg.biz.SgsgBiz;

/**
 * Servlet implementation class CamaServlet
 */
@WebServlet("/SgsgServlet")
public class SgsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SgsgServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().log("SgsgServlet get 호출");
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		// 크로스도메인 해결
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		ResultSet rs;
		SgsgBiz biz = new SgsgBiz();
		
		//String query = "select name, age, person_id from test where name = 'sungho'";
		String query = "select kakao_id, name, age, region1, region2 from tb_user";
		
		try {
			rs = biz.getDBdata(query);
		
			//결과처리부분
			HashMap<String, HashMap> resultMap = new HashMap<String, HashMap>();
			if(rs != null) {
				try {
					for(int i = 0 ; rs.next() ; i++) {
						HashMap<String, String> singleResult = new HashMap<String, String>();
	
						singleResult.put("kakaoId", rs.getString(1));
						singleResult.put("name", rs.getString(2));
						singleResult.put("age", rs.getString(3));
						singleResult.put("region1", rs.getString(4));
						singleResult.put("region2", rs.getString(5));
						
						resultMap.put(Integer.toString(i), singleResult);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			out.print("======================<br/>");
			out.print(resultMap.toString());
	
			request.setAttribute( "resultMap" , resultMap);
		} catch (Exception e1) {
			getServletContext().log("error : " + e1.toString());
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().log("SgsgServlet post 호출");
		
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		ResultSet rs;
		SgsgBiz biz = new SgsgBiz();
		
		//String query = "select name, age, person_id from test where name = 'sungho'";
		String query = "select kakao_id, name, age, region1, region2 from tb_user";
		
		try {
			rs = biz.getDBdata(query);
		
			//결과처리부분
			HashMap<String, HashMap> resultMap = new HashMap<String, HashMap>();
			if(rs != null) {
				try {
					for(int i = 0 ; rs.next() ; i++) {
						HashMap<String, String> singleResult = new HashMap<String, String>();
	
						singleResult.put("kakaoId", rs.getString(1));
						singleResult.put("name", rs.getString(2));
						singleResult.put("age", rs.getString(3));
						singleResult.put("region1", rs.getString(4));
						singleResult.put("region2", rs.getString(5));
						
						resultMap.put(Integer.toString(i), singleResult);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			out.print("======================<br/>");
			out.print(resultMap.toString());
	
			request.setAttribute( "resultMap" , resultMap);
		
		} catch (Exception e1) {
			getServletContext().log("error : " + e1.toString());
			
		}
		
			
	}

}