package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dao.Teacherdao;
import dto.Teacher;

@WebServlet("/signupteacher")

public class Teachersignup extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Teacherdao dao = new Teacherdao();
	Studentdao studentdao = new Studentdao();
	String email = req.getParameter("email");
	long mobile=Long.parseLong(req.getParameter("mobile"));

	
	if (dao.find(email) == null && dao.find(mobile)==null && studentdao.find(email)== null&&studentdao.find(mobile)== null)
	
	
	{
Teacher teacher = new Teacher();
teacher.setName(req.getParameter("first"));
teacher.setEmail(req.getParameter("email"));
teacher.setMobile(Long.parseLong(req.getParameter("mobile")));
teacher.setPassword(req.getParameter("psw"));
teacher.setSubject(req.getParameter("subject"));

dao.update(teacher);


Teacher  teacher2  = dao.find(teacher.getEmail());

int reg1 = teacher2.getEmployeid();
resp.getWriter().print("<h1>ACCOUNT CREATED SUCCESSFULLY UR EMPLOYENUMBER IS :-"+reg1+ "</h1>");

req.getRequestDispatcher("loginpage.html").include(req, resp);

	} else {
		resp.getWriter().print("<h1>Account Already Exists Check and try again</h1>");
		req.getRequestDispatcher("signupteacher.html").include(req, resp);
	}
}
}

