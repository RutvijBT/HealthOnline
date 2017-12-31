package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet(description = "Delete appointment By appointment Id", urlPatterns = { "/DeleteAppoinment" })
public class DeleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appointmentId=Integer.parseInt(request.getParameter("id"));
		Query query=Query.getInstance();
		try {
			query.deleteAppointment(appointmentId);
			Integer role=Integer.parseInt((request.getSession().getAttribute("role")).toString());
			switch(role){
			case 1: response.sendRedirect("");
				break;
			case 2: 
				
				response.sendRedirect("DoctorHome");
				break;
			case 3: response.sendRedirect("my.appointment");
				break;
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
