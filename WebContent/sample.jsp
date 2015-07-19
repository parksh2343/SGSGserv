<%@page import="java.util.ArrayList"%>
<%@page import="cama.dto.CamaDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<CamaDto> al = (ArrayList<CamaDto>)request.getAttribute("CamaTestList"); 
   CamaDto dto;

   for(int i = 0 ; i < al.size() ; i++) {
	   dto = al.get(i);
%>
<br />
<%=dto.getAge()%>
<br />
<%=dto.getName()%>
<br />
<%=dto.getPersonId()%>
<br />
<% } %>
<br />

샘플 페이지

</body>
</html>