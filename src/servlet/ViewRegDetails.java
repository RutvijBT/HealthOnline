package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javaBean.Register;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

public class ViewRegDetails extends HttpServlet{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,
  HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();

  try {
	  ArrayList<Register> list = new ArrayList<Register>();
	  //out.print("<p> You are in servlet </p>");
	 
	  HttpSession session=request.getSession(false); 
	     int userId=(Integer) session.getAttribute("user_id");
	     Query query=Query.getInstance();
	     ResultSet rs=query.getUserRegDetail(userId);
	     
	while(rs.next())
      {
    	  Register UserVO=new Register(); 
    	  UserVO.setRegPlanName(rs.getString(1));
    	  UserVO.setRegPlanDuration(rs.getString(2));
    	  UserVO.setRegPlanAmount(rs.getString(3));
    	  UserVO.setRegExpDate(rs.getString(4));
    	  
    	  list.add(UserVO);
    	  request.setAttribute("List", list);
      }
     request.getRequestDispatcher("jsp/PatientRegDetails.jsp").forward(request, response);
      
  }  
  catch (Exception e) {
	  System.out.print(e);
  }

  }

  
}