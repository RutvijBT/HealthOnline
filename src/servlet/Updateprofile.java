package servlet;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileItemFactory;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

import DAO.Query;

public class Updateprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//reg.setName(request.getParameter("fname")+" "+request.getParameter("mname")+" "+request.getParameter("lname"));
			try{
				Register reg=new Register();
				reg.setName(request.getParameter("name"));
				reg.setAddress(request.getParameter("address"));
				reg.setCity(request.getParameter("city"));
				reg.setState(request.getParameter("state"));
				reg.setMobile(request.getParameter("mobile"));
				reg.setPassword(request.getParameter("password"));

				HttpSession session=request.getSession(false);
				int userId=(Integer) session.getAttribute("user_id");
				Query query=Query.getInstance();
				query.updateUserProfile(userId,reg);
				int role=Integer.parseInt(request.getSession().getAttribute("role").toString());
				switch(role){
				case 1:response.sendRedirect("jsp/DoctorProfile.jsp");
					break;
				case 2:response.sendRedirect("jsp/DoctorProfile.jsp");
					break;
				case 3:response.sendRedirect("jsp/PatientProfile.jsp");
				//case 3:response.sendRedirect("../HealthOnlineProject/Home.Patient");
					break;
			}	
	}
	
	catch (Exception e) {
		  System.out.print(e);
	  }
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
