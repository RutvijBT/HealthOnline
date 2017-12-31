package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBean.CategoryBean;
import javaBean.HealthGuidelineBean;
import javaBean.LoginBean;
import javaBean.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import userdata.User;

import DAO.Query;

@WebServlet("/DoctorList")
public class DoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Query query=Query.getInstance();		
		
		User user=new User();
		ArrayList<CategoryBean> list;
		try {
			list = user.getCategory();
			request.setAttribute("s2", list);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			request.getRequestDispatcher("jsp/AvailableDoctors.jsp").forward(request, response);
	
} 
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Query query=Query.getInstance();		
		
		List<Register> s1 = new ArrayList<Register>();
		

		String catid=(request.getParameter("val"));
	
		ResultSet rs = null;
		if(catid==null){
			
			rs=query.getDoctorlist(1);}
		else{
			
			int cat=Integer.parseInt(catid);
		
			rs=query.getDoctorlist(cat);}
		try{
			while(rs.next()){
				Register s=new Register();
				
			    s.setId(rs.getInt("user_id"));
			    System.out.println("mmmmmmssssaaaaaaaa"+s.getId());
			    s.setCatname(rs.getString("category_name"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
                s.setState(rs.getString("state"));
                s.setEmail(rs.getString("email"));
               s.setDegree(rs.getString("degree"));
               ResultSet res=query.viewShedule(s.getId());
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
				
				s.setSchedule(schedule);

				s1.add(s);
					
				request.setAttribute("s1", s1);
				System.out.println("manisha");
				/*RequestDispatcher rd=request.getRequestDispatcher("/HealthOnlineProject/jsp/ListOfDoctor.jsp");
				rd.forward(request, response);*/
				request.getRequestDispatcher("jsp/ListOfDoctor.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
