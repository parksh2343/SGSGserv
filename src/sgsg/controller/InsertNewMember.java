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
@WebServlet("/InsertNewMember")
public class InsertNewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertNewMember() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().log("InsertNewMember get 호출");
		
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		int result = 0;
		SgsgBiz biz = new SgsgBiz();
		
		//String query = "select name, age, person_id from test where name = 'sungho'";
		String query = "INSERT INTO tb_user VALUES ('testKakaoId1', '박성호', '28', '서울시', '마포구')";
		
		try {
			result = biz.updateDBdata(query);
		
			//결과처리부분
			HashMap<String, String> resultMap = new HashMap<String, String>();
			
			resultMap.put("1", result+"건 insert");
			
			out.print("======================<br/>");
			out.print(resultMap.toString());
	
			request.setAttribute( "resultMap" , resultMap);

		} catch (Exception e) {

			getServletContext().log("error : " + e.toString());
			
		}//pama = personId
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().log("InsertNewMember post 호출");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		int result;
		SgsgBiz biz = new SgsgBiz();
		
		//String query = "select name, age, person_id from test where name = 'sungho'";
		String query = "INSERT INTO tb_user VALUES ('testKakaoId1', '박성호', '28', '서울시', '마포구')";
		
		try {
			result = biz.updateDBdata(query);
		
			//결과처리부분
			HashMap<String, String> resultMap = new HashMap<String, String>();
			
			resultMap.put("1", result+"건 insert");
			
			out.print("======================<br/>");
			out.print(resultMap.toString());
	
			request.setAttribute( "resultMap" , resultMap);

		} catch (Exception e) {
			getServletContext().log("error : " + e.toString());
			
		}//pama = personId
			
	}
	
	

}