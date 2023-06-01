<%@page import="dto.MarksCard"%>
<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="dao.Studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve marks</title>
</head>
<body>

<%Studentdao studentdao= new  Studentdao();
List<Student> list= studentdao.fetchall();
%>



<table border="1">

<tr>
<th>register number</th>
<th>name</th>
<th>standard</th>
<th>mathematic</th>
<th>science</th>
<th>kannada</th>
<th>hindi</th>
<th>english</th>
<th>social science</th>
<th>percentage</th>
<th>result</th>
<th>status</th>
<th>change status</th>
<th>edit</th>
</tr>


<%for(Student  student:list){
	List<MarksCard> list2 = student.getCards();
	%>
<% for (MarksCard  card: list2){ %>

<tr>
<th><%= student.getRegno() %></th>
<th><%= student.getName() %></th>
<th><%=card.getStandard() %></th>
<th><%=card.getMathematics() %></th>
<th><%=card.getScience() %></th>
<th><%=card.getKannada() %></th>
<th><%=card.getHindi() %></th>
<th><%=card.getEnglish() %></th>
<th><%=card.getSocialscience() %></th>
<th><%=card.getPercentage() %></th>
<th><%=card.getResult() %></th> 
<th><%=card.isStatus() %></th>
<th><a href="changeStatus?id=<%=card.getId()%>"><button>Change Status</button></a></th>
<th><a href="edit.jsp?reg=<%=student.getRegno()%>&id=<%=card.getId()%>"><button>Edit</button></a></th>
</tr>
<%} %>
<%} %>

</table>


<br><br>
<a href="teacherhomepage.html"><button>Home</button></a>
</body>
</html>