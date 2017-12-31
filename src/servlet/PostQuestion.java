package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.AnswerBean;
import javaBean.CategoryBean;
import javaBean.QuestionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdata.Questions;
import userdata.User;

import DAO.Query;
@WebServlet("/Post.question")
/**
 * Servlet implementation class PostQuestion
 */
public class PostQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s=request.getSession();
		int pId=(Integer)s.getAttribute("user_id");
		
		Query query=Query.getInstance();
		User user=new User();
		
		Questions q=new Questions();
		ArrayList<CategoryBean> list;
		ArrayList<QuestionBean> list1;
		ArrayList<AnswerBean> list3;
		ArrayList<QuestionBean> list2=new ArrayList<QuestionBean>();
		try {
			int n=user.NumberOfUnreadNotification(pId);
			request.setAttribute("n", n);
			list = user.getCategory();
			request.setAttribute("s", list);
			list1=q.getUnansweredPatientQuestion(pId);
			request.setAttribute("s1", list1);
			//list4=q.getPatientAnsweredQuestion(pId);
			//request.setAttribute("s4", list4);
			ResultSet result=query.getPatientQuestion(pId);
			QuestionBean ob=new QuestionBean();
			while(result.next()){
				
				ob.setQuestion_id(result.getInt(1));
				ob.setQuestion(result.getString(2));
				list2.add(ob);
				request.setAttribute("s2", list2);
			}
			int questionId=ob.getQuestion_id();
			System.out.println(questionId);
			list3=q.getAnswer(questionId);
			request.setAttribute("s3", list3);
			boolean b=q.isAnswereLiked(pId,3);
			request.setAttribute("bool", b);
			request.getRequestDispatcher("jsp/PatientHome.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Query query=Query.getInstance();
		try {
			int userId=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
			query.postQuestion(request, response,userId);
			
		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (SQLException e) {
			System.out.print(e);
		}
		finally{
			response.sendRedirect("Post.question");
		}
	}

}
