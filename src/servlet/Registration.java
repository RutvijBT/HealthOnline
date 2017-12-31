package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javaBean.Register;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Register reg=new Register();
		reg.setName(request.getParameter("fname")+" "+request.getParameter("lname"));
		reg.setAddress(request.getParameter("address"));
		reg.setCity(request.getParameter("city"));
		reg.setState(request.getParameter("state"));
		reg.setMobile(request.getParameter("mobile"));
		reg.setEmail(request.getParameter("email"));
		reg.setGender(request.getParameter("gen"));
		reg.setBdate(request.getParameter("bdate"));
		reg.setBloodGroup(request.getParameter("bgroup"));
		reg.setPassword(request.getParameter("password"));
		reg.setCategory(request.getParameter("category"));
		
		Query query=Query.getInstance();
		/*try {
			if(query.isUserWithSameEmailExist(reg.getEmail())) {
				out.print("<script>alert('User with same Email-id already exists');</script>");
			//	if(request.getParameter("role").equalsIgnoreCase("doctor")){
				out.print("<script>window.location.href='RegPlan'</script>");
			}*/
			//else{	
				if(request.getParameter("role").equalsIgnoreCase("doctor")){
					reg.setCertificateNumber(request.getParameter("Certificate_no"));
					reg.setAuthority(request.getParameter("Authority_name"));
					String[] degree=request.getParameterValues("degree");
					String str="";    
					for(String item : degree)
					     str+=" "+item;
					reg.setDegree(str);
					getServletConfig().getServletContext().setAttribute("doctor", reg);
					response.sendRedirect("jsp/CerificateUpload.jsp");
				}
				else if(request.getParameter("role").equalsIgnoreCase("patient")){
						int i;
						try {
							i = query.registerUser(reg,3);
							request.getSession().setAttribute("user_id", i);
							response.sendRedirect("jsp/pay.jsp");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					//	out.print("<script>alert('Registration successfully, Please login to use services');</script>");
					//	out.print("<script>window.location.href='../HomePage.jsp'</script>");
						
					} 
				}
	//}
		/*catch (SQLException e) {
			System.out.print(e);
		}*/
//}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
