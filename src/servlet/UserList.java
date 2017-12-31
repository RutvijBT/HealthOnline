package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBean.CategoryBean;
import javaBean.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.User;
import DAO.Query;

@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		System.out.println("login");
		User user=new User();
		ArrayList<CategoryBean> list;
		ArrayList<Register> list1;
		try {
			System.out.println();
			System.out.println("login");
			list = user.getCategory();
			request.setAttribute("s2", list);
			list1=user.getPatientname();
			request.setAttribute("s3", list1);
			request.getRequestDispatcher("jsp/UserList.jsp").forward(request, response);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
Query query=Query.getInstance();		
		
		List<Register> s1 = new ArrayList<Register>();
		
        User u=new User();
		String catid=(request.getParameter("val"));
		ResultSet rs = null;
		if(catid==null || Integer.parseInt(catid)==0){
			
			try {
				s1=u.getAllDoctor();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		else{
			int cat=Integer.parseInt(catid);
		
			rs=query.getDoctorlist(cat);
		try{
			while(rs.next()){
				Register s=new Register();
				
			
				s.setName(rs.getString("name"));
				
				s1.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		request.setAttribute("s1", s1);
		
		RequestDispatcher rd=request.getRequestDispatcher("jsp/ADoctorList.jsp");
		rd.forward(request, response);
	}

}
