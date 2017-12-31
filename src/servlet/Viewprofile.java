package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

public class Viewprofile extends HttpServlet{

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
	     ResultSet rs=query.getUserProfile(userId);
	     Register profile=new Register();
	while(rs.next())
      {
    	   
    	  profile.setName(rs.getString(1));
    	  profile.setAddress(rs.getString(2));
    	  profile.setCity(rs.getString(3));
    	  profile.setState(rs.getString(4));
    	  profile.setMobile(rs.getString(5));
    	  profile.setEmail(rs.getString(6));
    	  profile.setPassword(rs.getString(7));
      }
	if(Integer.parseInt(request.getSession().getAttribute("role").toString())==2){
		
			ResultSet res=query.viewShedule(userId);
			String schedule="";
			while(res.next()){
				int i=res.getInt(2);
				
				
				if(res.getInt(2)==1) schedule=" Monday";
				if(res.getInt(3)==1) schedule+=" Tuesday";
				if(res.getInt(4)==1) schedule+=" Wednesday";
				if(res.getInt(5)==1) schedule+=" Thursday";
				if(res.getInt(6)==1) schedule+="  Friday";
				if(res.getInt(7)==1) schedule+="  Saturday";
				if(res.getInt(8)==1) schedule+="  Sunday";
				
			}
			
			profile.setSchedule(schedule);
	}
		list.add(profile);
		request.setAttribute("List", list);
  }  
  catch (Exception e) {
	  System.out.print(e);
  }

  }
}