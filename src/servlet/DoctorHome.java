package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.AppointmentBean;
import javaBean.QuestionBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.Appointment;
import userdata.Questions;
import userdata.User;

@WebServlet("/DoctorHome")
public class DoctorHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Appointment app=new Appointment();
		Questions ques=new Questions();
		int userId=(Integer)request.getSession().getAttribute("user_id");
		int role=(Integer)request.getSession().getAttribute("role");
		int categoryId=(Integer)request.getSession().getAttribute("category_id");
       
		System.out.println("cat"+categoryId);
		ArrayList<AppointmentBean> list1=new ArrayList<AppointmentBean>();
		ArrayList<AppointmentBean> list2=new ArrayList<AppointmentBean>();
		ArrayList<QuestionBean> list3=new ArrayList<QuestionBean>();
		
		try {
			
			list1=app.getTodayAppintment(userId, role);
			list2=app.getPendingAppintment(userId, role);
			list3=ques.getUnansweredCategoryQuestion(categoryId);
			request.setAttribute("today", list1);
			request.setAttribute("pending", list2);
			request.setAttribute("questions", list3);
			
			RequestDispatcher disp=request.getRequestDispatcher("jsp/DoctorHome.jsp");
			disp.forward(request, response);
			
		} catch (SQLException e) {
			System.out.print(e);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
