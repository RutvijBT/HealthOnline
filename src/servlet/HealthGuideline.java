package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javaBean.CategoryBean;
import javaBean.HealthGuidelineBean;
import javaBean.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdata.User;

import DAO.Query;

@WebServlet("/HealthGuideline")
public class HealthGuideline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthGuideline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user=new User();
		ArrayList<CategoryBean> list;
		try {
			list = user.getCategory();
			request.setAttribute("s2", list);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String catid=(request.getParameter("category"));
		List<HealthGuidelineBean> s =null ;
		if(catid==null){
			try {
				s=user.getGuideline(1);
				
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			int cat=Integer.parseInt(catid);
		
			try {
				s=user.getGuideline(cat);
				
				//out.print("<br>"+u.getuserid()+" "+u.getusername()+" "+u.getpassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}		
		request.setAttribute("s", s);
		
		HttpSession s1=request.getSession();
		RequestDispatcher rd;
		Integer id=(Integer)s1.getAttribute("user_id");
		
		System.out.println(id);
		if(id==null){
			rd=request.getRequestDispatcher("jsp/GuestHealthGuideline.jsp");
			rd.forward(request, response);
		}
		else{
	    rd=request.getRequestDispatcher("jsp/DoctorHealthGuideline.jsp");
		rd.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Query query=Query.getInstance();
		
		ResultSet r=query.getCategory();
		
		HealthGuidelineBean h=new HealthGuidelineBean();
		int category=Integer.parseInt(request.getParameter("category"));
		String content=request.getParameter("content");
		System.out.println(category);
		System.out.println(content);
		 HttpSession s=request.getSession();
			
			Integer id=(Integer)s.getAttribute("user_id");
			Date date = new Date();
			System.out.println(id);
			h.setDoctorid(id);
			h.setGuideline(content);
			h.setDate(date);
			h.setCategory_id(category);
			query.addGuideline(h);
			doGet(request, response);
	
	}

}
