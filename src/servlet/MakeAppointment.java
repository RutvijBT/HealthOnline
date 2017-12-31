package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.AppointmentBean;
import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.Appointment;
import userdata.User;

import DAO.Query;
@WebServlet("/my.appointment")
public class MakeAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		Appointment a=new Appointment();
		ArrayList<Register> list;
		ArrayList<AppointmentBean> list1,list2;
		int uid=(Integer)request.getSession().getAttribute("user_id");
		int role=(Integer)request.getSession().getAttribute("role");
		try {System.out.println("aaaaaaaaaaaaaaaaaa");
			list=u.getDoctorName();
			System.out.println("bbbbbbbbbbbbbbbbbbbb");
			request.setAttribute("list", list);
			list1=a.getPendingAppintment(uid, role);
			request.setAttribute("list1", list1);
			list2=a.getConfirmedAppintment(uid, role);
			request.setAttribute("list2",list2);
			System.out.println("cccccccccccccccccccccccc");
			request.getRequestDispatcher("jsp/PatientAppointment.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		AppointmentBean app=new AppointmentBean();
		app.setPatient((Integer) request.getSession().getAttribute("user_id"));
		app.setDoctor(Integer.parseInt(request.getParameter("doctor")));
		app.setDate(request.getParameter("date"));
		app.setComment(request.getParameter("comment"));
		Query query=Query.getInstance();
		try {
			query.makeAppintment(app);
		} catch (SQLException e) {
			System.out.println(e);
		}
		response.sendRedirect("my.appointment");
	}

}
