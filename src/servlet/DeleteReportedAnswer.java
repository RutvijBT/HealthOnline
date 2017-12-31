package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;
@WebServlet("/DeleteReportedAns")
public class DeleteReportedAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ansId=Integer.parseInt(request.getParameter("id1"));
		try{
			Query query=Query.getInstance();
			query.deleteAns(ansId);
			response.sendRedirect("jsp/AdminHome.jsp");
		}catch(Exception e){
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
