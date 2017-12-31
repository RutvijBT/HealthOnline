package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;
import javaBean.*;
public class PatientSelfDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		PatientSelfDescriptionBean ob=new PatientSelfDescriptionBean();
		ob.setUser((Integer)request.getSession().getAttribute("user_id"));
		ob.setDescription(request.getParameter("description"));
		
		Query query=Query.getInstance();
		try {
			query.savePatientDescription(ob);
			response.sendRedirect("jsp/MedicalHistory.jsp");
			//response.sendRedirect(request.getRequestedSessionId());
		} catch (SQLException e) {
			System.out.print(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
