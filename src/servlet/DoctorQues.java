package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBean.AnswerBean;
import javaBean.CategoryBean;
import javaBean.HealthGuidelineBean;
import javaBean.QuestionBean;
import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdata.Questions;
import userdata.User;
import DAO.Query;

@WebServlet("/DoctorQues")
public class DoctorQues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorQues() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String catid=(request.getParameter("category"));
		System.out.print(catid);
		int role=(Integer)session.getAttribute("role");
		if(role==2)
		request.getRequestDispatcher("jsp/DoctorQuestionaries.jsp?val="+catid).forward(request, response);
		if(role==3)
			request.getRequestDispatcher("jsp/PatientQuestionaries.jsp?val="+catid).forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
