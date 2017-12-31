package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaBean.CategoryBean;
import javaBean.HealthGuidelineBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdata.User;

@WebServlet("/AHealthGuideline")
public class AHealthGuideline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AHealthGuideline() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
	    request.getRequestDispatcher("jsp/AHealthGuideline.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
