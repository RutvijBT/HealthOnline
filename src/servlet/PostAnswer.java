package servlet;

import java.io.IOException;
import javaBean.AnswerBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/post.answer")
public class PostAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnswerBean ans=new AnswerBean();
		String a=request.getParameter("id");
		
		System.out.print(a);
		ans.setQuestion_id(Integer.parseInt(a));
		ans.setAnswer(request.getParameter("answer"));
		ans.setDoctor(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		Query query=Query.getInstance();
		try{
			query.postAnswer(ans);
			response.sendRedirect("/HealthOnlineProject/jsp/DoctorQuestionaries.jsp");
		}catch(Exception e){
			System.out.print(e);
			
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnswerBean ans=new AnswerBean();
		String a=request.getParameter("id");
		
		System.out.print(a);
		ans.setQuestion_id(Integer.parseInt(a));
		ans.setAnswer(request.getParameter("answer"));
		ans.setDoctor(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		Query query=Query.getInstance();
		try{
			query.postAnswer(ans);
			response.sendRedirect("DoctorHome");
		}catch(Exception e){
			System.out.print(e);
			
		}
	}

}
