package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Markscarddao;
import dto.MarksCard;


@WebServlet("/changeStatus")
public class Changestatus extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int id=Integer.parseInt(req.getParameter("id"));
		Markscarddao markscarddao = new Markscarddao();
		MarksCard card=markscarddao.find(id);
		if(card.isStatus())
		{
			card.setStatus(false);
		}
		else {
			card.setStatus(true);
		}
		
		markscarddao.update(card);
		
		resp.getWriter().print("<h1>Status Updated</h1>");
		req.getRequestDispatcher("approvemarks.jsp").include(req, resp);
		
		
	}
	}

