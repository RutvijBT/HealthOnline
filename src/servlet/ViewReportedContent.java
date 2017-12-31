package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.AdminInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.Query;
@WebServlet("/ViewReportedContent")
public class ViewReportedContent extends HttpServlet{

private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,
  HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  ResultSet rs = null;
  try {
	  ArrayList<AdminInfo> list = new ArrayList<AdminInfo>();
	  //out.print("<p> You are in servlet </p>");
	 
	     Query query=Query.getInstance();
	      rs=query.getReportedAns();
	     
	while(rs.next())
      {
		 ResultSet rs1;
		// int ansId=rs.getInt(1);
		  AdminInfo VO=new AdminInfo();
    	  VO.setAns_id(rs.getInt(1));
    	  VO.setNews(rs.getString(2));
    	  
    	  //rs1=query.getReportedQue(ansId);
    	  //VO.setQue(rs1.getString(1));
    	  list.add(VO);
      }	
		
		request.setAttribute("List1", list);
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