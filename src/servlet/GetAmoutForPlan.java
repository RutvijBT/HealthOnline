package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/GetAmoutForPlan")
public class GetAmoutForPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetAmoutForPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int amount;
		int planId=Integer.parseInt(request.getParameter("id"));
		Query query=Query.getInstance();
		try {
			amount=query.getAmoutByPlanId(planId);
			if(amount==0)
				out.print("");
			else
				out.print(amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
