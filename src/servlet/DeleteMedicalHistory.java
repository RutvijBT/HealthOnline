package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

public class DeleteMedicalHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		System.out.println("1111111111111111111111"+request.getParameter("id"));
		if((request.getParameter("id"))!=null){
			try {
					int id=Integer.parseInt(request.getParameter("id"));
					System.out.println("111111111111110"+id);
					Query query=Query.getInstance();
				//	query.deleteMedicalHistory(id);
					query.deleteMedicalHistory(id);
					response.sendRedirect("jsp/MedicalHistory.jsp");
			} catch(Exception e) {
				System.out.print(e);
			}
		}
		else response.sendRedirect("jsp/MedicalHistory.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
