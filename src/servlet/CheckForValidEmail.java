package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/isEmailExist")
public class CheckForValidEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		System.out.print("1111111111111111111111000");
		String email=request.getParameter("id");
		try{
			Query ob=Query.getInstance();
			if(ob.isUserWithSameEmailExist(email)){
				System.out.print("trytrytry1111111111111111111111000");
				out.print(email+ " already exist");
			}
			else {
				out.print("");
				out.print("<script>	document.getElementById(\"email\").value=\"\"; </script>");
			}
		}catch(Exception e){
			out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
