package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Query;

@WebServlet("/CancelRegn")
public class CancelRegn extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CancelRegn() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reason");
		String reason=(request.getParameter("val"));
		System.out.println("Reason"+reason);
		
		HttpSession session=request.getSession();
		int uId=(Integer)session.getAttribute("user_id");
		Query query=Query.getInstance();
		try {
			query.cancelMembership(uId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
