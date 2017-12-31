package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.Questions;
import DAO.Query;


@WebServlet("/likeStatus")
public class getLikeOrUnlike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		int user=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		try{
			Questions ob=new Questions();
			if(ob.isAnswereLiked(user, 2))
				out.print("<a href='../unlike.it?id=${ans.getAnswer_id() }' style='background-color:#0055FF;color:white'>UNLIKE</a>");
			else
				out.print("<a href='../like.it?id=${ans.getAnswer_id() }' style='background-color:#0055FF;color:white'>LIKE</a>");
		}catch(Exception e){
			
			System.out.print(e);
		}
		//out.print(message);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
