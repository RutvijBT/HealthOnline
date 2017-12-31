package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javaBean.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		LoginBean log=new LoginBean();
		log.setUsername(request.getParameter("username"));
		log.setPassword(request.getParameter("password"));
		Query query=Query.getInstance();
		request.getSession().removeAttribute("role");
		try {
			int userId=query.authenticateUser(log);
			
			if(userId!=0){
				ResultSet rs= query.getUserSessionDetail(userId);
				if(rs.next()){
					HttpSession session=request.getSession();
				//	session.invalidate();
					System.out.print(rs.getInt(5));
					int status=rs.getInt(5);
					switch(status){
						case 1:
							session.setAttribute("user_id", rs.getInt(1));
							session .setAttribute("role", rs.getInt(4));
							session.setAttribute("name", (rs.getString(2)));
							session.setAttribute("category_id", (rs.getInt(3)));
							session .setAttribute("role_id", rs.getInt(4));
							int role=rs.getInt(4);
							switch(role){
								case 1:response.sendRedirect("jsp/AdminHome.jsp");
									break;
								case 2:response.sendRedirect("/HealthOnlineProject/DoctorHome");
									break;
								case 3:response.sendRedirect("jsp/PatientHome.jsp");
									break;
							}
							break;	
						case 2: //Account is in Inactive mode
							//System.out.print("case 2");
							request.setAttribute("message", "Your account is in Inactive mode. \n For activate account again contact to Admin.<br /> If any query then please contact Admin.");
							RequestDispatcher d1=request.getRequestDispatcher("jsp/Contact.jsp");
							d1.forward(request, response);
							break;
						case 3: //Account is in padding mode
							//System.out.print("case 3");
							request.setAttribute("message", "Your request is pedding <br /> For more detail, Please contact to Admin.");
							RequestDispatcher d2=request.getRequestDispatcher("jsp/Contact.jsp");
							d2.forward(request, response);
							break;
						
						case 11: //No payment
							//System.out.print("case 11");
							session.setAttribute("user_id", rs.getInt(1));
							session .setAttribute("role_id", rs.getInt(4));
							request.setAttribute("message1", "Your plan is not active  May be expired or you not pay even once.<br /> If any query then please contact Admin.<br />"
									+ "<span style='color:blue;'>You can pay just now by using your credi</span>");
							RequestDispatcher d=request.getRequestDispatcher("jsp/pay.jsp");
							d.forward(request, response);
							break;
						
						default  :
							response.sendRedirect("HomePage.jsp");
					}
					
				}
			}
			else{
				request.setAttribute("message2", "Invalid username Or Password");
				RequestDispatcher d3=request.getRequestDispatcher("HomePage.jsp");
				d3.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
