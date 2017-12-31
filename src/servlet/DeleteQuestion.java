package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/delete.question")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		try{
			Query quey=Query.getInstance();
			quey.deleteContent(id);
			int role=Integer.parseInt(request.getSession().getAttribute("role").toString());
			switch(role){
				case 1:response.sendRedirect("/HealthOnlineProject/jsp/AdminQuestionaries.jsp");
					break;
				case 2:response.sendRedirect("/HealthOnlineProject/jsp/DoctorQuestionaries.jsp");
					break;
				case 3:response.sendRedirect("Post.question");
				//case 3:response.sendRedirect("../HealthOnlineProject/Home.Patient");
					break;
			}
		}catch(Exception e){
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
