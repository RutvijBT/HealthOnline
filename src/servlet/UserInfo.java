package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaBean.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdata.User;

import DAO.Query;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Query query=Query.getInstance();
		User user=new User();
		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<Register> list;
		//int did=Integer.parseInt(request.getParameter("did"));
		try {
			int role=query.getRoleid(id);
			System.out.print("role"+role);
			if(role==2){
				System.out.print("userinfo");
				list=user.getDoctorInfo(id);
				ResultSet res=query.viewShedule(id);
				Register profile=new Register();
				String schedule="";
				while(res.next()){
					int i=res.getInt(2);
					
					
					if(res.getInt(2)==1) schedule=" Monday";
					if(res.getInt(3)==1) schedule+=" Tuesday";
					if(res.getInt(4)==1) schedule+=" Wednesday";
					if(res.getInt(5)==1) schedule+=" Thursday";
					if(res.getInt(6)==1) schedule+="  Friday";
					if(res.getInt(7)==1) schedule+="  Saturday";
					if(res.getInt(8)==1) schedule+="  Sunday";
					
				}
				
				profile.setSchedule(schedule);
		String day=profile.getSchedule();
			
				request.setAttribute("l",day);
				request.setAttribute("list", list);
				System.out.print("userinfo");
			}
            if(role==3){
            	list=user.getPatientInfo(id);
				request.setAttribute("list", list);
			}
			request.getRequestDispatcher("jsp/UserInfo.jsp?role="+role).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
