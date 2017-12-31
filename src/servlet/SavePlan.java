package servlet;

import java.io.IOException;

import javaBean.UserPlanBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/save.plan")
public class SavePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		UserPlanBean plan=new UserPlanBean();
		plan.setPlan(request.getParameter("plan"));
		plan.setDuration(request.getParameter("duration"));
		plan.setAmount(Integer.parseInt(request.getParameter("amount")));
		plan.setPeriod_id(Integer.parseInt(request.getParameter("period")));
		plan.setRole(Integer.parseInt(request.getParameter("role")));
		plan.setStatus_id(Integer.parseInt(request.getParameter("status")));
		try{
			Query query=Query.getInstance();
			if (operation.equalsIgnoreCase("update")) {
				plan.setPlan_id(Integer.parseInt(request.getParameter("plan_id")));
				query.updatePlan(plan);
			}
			else{
				query.insertPlan(plan);
			}
			
		}catch(Exception e){
			System.out.print(e);
			
		}
		
		
		response.sendRedirect("jsp/Plan.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
