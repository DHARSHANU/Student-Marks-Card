package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dao.Teacherdao;
import dto.Student;
import dto.Teacher;

@WebServlet("/login")
public class Loginpage  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      int emph =Integer.parseInt(req.getParameter("text"));
	      String password = req.getParameter("pass");
	      
	      RequestDispatcher dispatcher = req.getRequestDispatcher("loginpage.html");
	      
	      Studentdao studentdao = new Studentdao();
	      
	      Teacherdao  teacherdao = new  Teacherdao();
	      
	      
	      
	      Teacher teacher = teacherdao.find(emph);
	      
	      if(teacher==null){
	    	  Student student = studentdao.find(emph);
	    	  if(student==null){
	    		  resp.getWriter().print("<h1>INCORRECT REGISTER NUMBER OR EMPLOE NUMBER</h1>");
	    	         dispatcher.include(req, resp);
	    	         
	    	  }else{
	    	  if(student.getPassword().equals(password)){
	    		  req.getSession().setAttribute("student", student);
	    		  resp.getWriter().print("<h1>STUDENT LOGIN SUCCESS</h1>");
	    	  req.getRequestDispatcher("studenthomepage.html").include(req, resp);
	    	  }else{
                    resp.getWriter().print("<h1>INCORRECT PASSWORD</h1>");	    	  
	    	  dispatcher.include(req, resp);
	    	  
	    	  }
	    	  }
	      }else{
	    	  if(teacher.getPassword().equals(password)){
	    	  resp.getWriter().print("<h1>TEACHER LOGIN SUCCESS</h1>");
	    	 req.getRequestDispatcher("teacherhomepage.html").include(req, resp);
	    	  
	    	  }else{
	    		  
	    		  resp.getWriter().print("<h1>INCORRECT PASSWORD</h1>");
	    	dispatcher.include(req, resp);
	    	  }
	      }
		
		
	}
	
	
	
}