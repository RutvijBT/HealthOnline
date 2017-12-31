package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javaBean.UserPlanBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.User;

/**
 * Servlet implementation class RegPlan
 */
@WebServlet("/RegPlan")
public class RegPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User u=new User();
		ArrayList<UserPlanBean> list;
		try {
			list=u.getUserPlan(2);
			request.setAttribute("s1", list);
			list=u.getUserPlan(3);
			request.setAttribute("s2", list);
			request.getRequestDispatcher("jsp/RegistrationPlan.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
