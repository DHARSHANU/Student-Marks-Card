<%@page import="dto.MarksCard"%>
<%@page import="dao.Markscarddao"%>
<%@page import="dto.Student"%>
<%@page import="dao.Studentdao"%>
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
int regno=Integer.parseInt(request.getParameter("reg")); 
Studentdao dao=new Studentdao();
Student student=dao.find(regno);
int id=Integer.parseInt(request.getParameter("id")); 
Markscarddao cardDao=new Markscarddao();
MarksCard card=cardDao.find(id);
%>
<h1>Enter Updated Details</h1>

<form action="updateMarks" method="post">

Name:<input type="text" name="name" value=<%=student.getName()%> readonly="readonly"><br>
Register Number:<input type="text" name="reg" value=<%=student.getRegno()%> readonly="readonly"><br>
Marks Id:<input type="text" name="id" value=<%=card.getId()%> readonly="readonly"><br>
Class:<input type="text" name="std" value=<%=card.getStandard()%> readonly="readonly"><br>
Mathematics Marks:<input type="number" name="maths" value="<%=card.getMathematics()%>"><br>
English :<input type="number" name="english" value="<%=card.getEnglish()%>"><br>
Science :<input type="number" name="science" value="<%=card.getScience()%>"><br>
Kannada :<input type="number" name="kannada" value="<%=card.getKannada()%>"><br>
Hindi :<input type="number" name="hindi" value="<%=card.getHindi()%>"><br>
Social Science :<input type="number" name="socialscience" value="<%=card.getSocialscience()%>"><br>
<br>
<button type="reset">Cancel</button>
<button>Update</button>
</form>

</body>
i</html>