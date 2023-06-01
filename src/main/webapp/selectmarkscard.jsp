<%@page import="dto.MarksCard"%>
<%@page import="java.util.List"%>
<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Student student=(Student)session.getAttribute("student");
List<MarksCard> list=student.getCards();
%>

<form action="markscard.jsp">
<select name="std">
<%for(MarksCard card:list){
	if(card.isStatus())
	{%>
<option><%=card.getStandard()%></option>
<%} %>
<%} %>
</select><br><br>
<button>submit</button>
</form>
</body>
</html>