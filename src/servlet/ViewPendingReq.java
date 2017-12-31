package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

public class ViewPendingReq extends HttpServlet{

private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,
  HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  ResultSet rs = null;
  try {
	  ArrayList<Register> list = new ArrayList<Register>();
	  //out.print("<p> You are in servlet </p>");
	 
	     Query query=Query.getInstance();
	      rs=query.getPendingUserReq();
	     
	while(rs.next())
      {
		  Register userVO=new Register();
    	  userVO.setName(rs.getString(1));
    	  userVO.setCertificateNumber(rs.getString(2));
    	  userVO.setCertificateFile(rs.getString(3));
    	  userVO.setAuthority(rs.getString(4));
    	  userVO.setUserid(rs.getInt(5));
    	  list.add(userVO);
      }	
		
		request.setAttribute("List", list);
  }  
  catch (Exception e) {
	  System.out.print(e);
  }

  finally{
	  
	  try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  }
}