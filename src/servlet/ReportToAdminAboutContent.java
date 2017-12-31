package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;


@WebServlet("/report.it")
public class ReportToAdminAboutContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contentId=Integer.parseInt(request.getParameter("id"));
		int userId=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		try{
			Query query=Query.getInstance();
			query.reportAnswerToAdmin(userId, contentId);
			response.sendRedirect("jsp/DoctorQuestionaries.jsp");
			
		}catch(Exception e){
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
