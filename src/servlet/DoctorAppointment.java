package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javaBean.AppointmentBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.Appointment;


@WebServlet("/Appointment")
public class DoctorAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Appointment app=new Appointment();
		ArrayList<AppointmentBean> list,list1;
		int userId=(Integer)request.getSession().getAttribute("user_id");
		System.out.print("user"+userId);
		int role=(Integer)request.getSession().getAttribute("role");
		try{
			list=app.getConfirmedAppintment(userId,role);
			request.setAttribute("appointment", list);
			list1=app.getTodayAppintment(userId, role);
			request.setAttribute("appointmen", list1);
			System.out.print("g");
			
			RequestDispatcher disp=request.getRequestDispatcher("jsp/DoctorAppointment.jsp");
			disp.forward(request, response);
		}catch(Exception e){
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
