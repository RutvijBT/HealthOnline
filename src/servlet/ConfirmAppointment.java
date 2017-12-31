package servlet;

import java.io.IOException;
import javaBean.AppointmentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/confirm.appointment")
public class ConfirmAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentBean ob=new AppointmentBean();
		ob.setAppointment(Integer.parseInt(request.getParameter("appintment_id")));
		ob.setTime(request.getParameter("time"));
		ob.setPatient(Integer.parseInt(request.getParameter("patient_id")));
		ob.setDoctor(Integer.parseInt((request.getSession().getAttribute("user_id")).toString()));
		Query query=Query.getInstance();
		try {
			query.confirmAppointment(ob);
			response.sendRedirect("DoctorHome");
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
