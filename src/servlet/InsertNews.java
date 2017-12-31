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

public class InsertNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			try{
				Register reg=new Register();
			    Query query=Query.getInstance();
				
				String[] abc=request.getParameterValues("news");
				for(String txt:abc){
					query.insertNews(txt);
					
				}
			//	query.updateUserProfile(userId,reg);
				response.sendRedirect("jsp/AdminHome.jsp");
	}
	
	catch (Exception e) {
		  System.out.print(e);
	  }
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
