package cama.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cama.biz.CamaBiz;
import cama.dto.CamaDto;

/**
 * Servlet implementation class CamaServlet
 */
@WebServlet("/CamaServlet")
public class CamaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CamaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		ArrayList<CamaDto> camaList = new ArrayList<CamaDto>();
		CamaBiz biz = new CamaBiz();
		camaList = biz.getTestList("");//pama = personId
		if(camaList != null) {
			request.setAttribute( "CamaTestList" , camaList);
//			request.setAttribute( "CamaDto" , camaList.get(0));
			//RequestDispatcher rd = request.getRequestDispatcher("sample.jsp");
			//rd.forward(request, response);
			
			ArrayList<CamaDto> al = (ArrayList<CamaDto>)request.getAttribute("CamaTestList"); 
			CamaDto dto;
			
			out.print("<br/>");
			for(int i = 0 ; i < al.size() ; i++) {
				dto = al.get(i);
				out.print("<br/>");
				out.print(dto.getAge());
				out.print("<br/>");
				out.print(dto.getName());
				out.print("<br/>");
				out.print(dto.getPersonId());
				out.print("<br/>");
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//String location = request.getParameter("personId");
		ArrayList<CamaDto> camaList = new ArrayList<CamaDto>();
		CamaBiz biz = new CamaBiz();
		camaList = biz.getTestList("");//pama = personId
		if(camaList != null) {
			request.setAttribute( "CamaTestList" , camaList);
//					request.setAttribute( "CamaDto" , camaList.get(0));
			//RequestDispatcher rd = request.getRequestDispatcher("sample.jsp");
			//rd.forward(request, response);
			
			ArrayList<CamaDto> al = (ArrayList<CamaDto>)request.getAttribute("CamaTestList"); 
			CamaDto dto;
			
			out.print("<br/>");
			for(int i = 0 ; i < al.size() ; i++) {
				dto = al.get(i);
				out.print("<br/>");
				out.print(dto.getAge());
				out.print("<br/>");
				out.print(dto.getName());
				out.print("<br/>");
				out.print(dto.getPersonId());
				out.print("<br/>");
			}
		}
			
	}

}