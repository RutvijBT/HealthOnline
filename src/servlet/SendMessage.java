package servlet;

import java.io.IOException;

import javaBean.MessageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/send.message")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageBean msg=new MessageBean();
		msg.setMessage(request.getParameter("message"));
		msg.setReceiver(Integer.parseInt(request.getParameter("sendTo")));
		msg.setSender(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
		try{
			Query query=Query.getInstance();
			query.sendMessage(msg);
			response.sendRedirect("jsp/chat.jsp");
			
		}catch(Exception e){
			
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
