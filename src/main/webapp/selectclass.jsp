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
<% Student  student= (Student)session.getAttribute("student");
int std = student.getStandard();

%>

<h1>SELECT CLASS FOR WHICH YOU WANT TO ADD MARKS</h1>

<form action="addmarks.jsp" method="post">
Select Class:
<select name="standard">
<option>8</option>
<%if(std>8) {%>
<option>9</option>
<% }%>
<%if(std>9) {%>.
<option>10</option>
<% }%>
</select>
<br>
<button type="submit">Submit</button>
</form>
<br><br>
<a href="studenthomepage.html"><button>Home</button></a>
</body>
</select>

</form>


</body>
</html>