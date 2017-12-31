package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/unlike.it")
public class UnLikeAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentId=Integer.parseInt(request.getParameter("id"));
		int userId=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		try{
			Query query=Query.getInstance();
			query.unLikeAnswer(userId, contentId);;
			int role=Integer.parseInt(request.getSession().getAttribute("role").toString());
			switch(role){
				case 1:response.sendRedirect("jsp/DoctorQuestionaries.jsp");
					break;
				case 2:response.sendRedirect("jsp/DoctorQuestionaries.jsp");
					break;
				case 3:response.sendRedirect("jsp/PatientHome.jsp");
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
