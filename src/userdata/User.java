package userdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBean.*;
import DAO.Connect;
import DAO.Query;

public class User {
	
	public ArrayList<UserPlanBean> getPlanDetail(int planId){
		ArrayList<UserPlanBean> list=new ArrayList<UserPlanBean>();
		Query query=Query.getInstance();
			try {
				ResultSet result=query.getPlanDetail(planId);
				while(result.next()){
					UserPlanBean ob=new UserPlanBean();
					ob.setPlan_id(result.getInt(1));
					ob.setPlan(result.getString(2));
					ob.setDuration(result.getString(3));
					ob.setAmount(result.getInt(4));
					ob.setPeriod(result.getString(5));
					ob.setStatus(result.getString(6));
					ob.setRole_name(result.getString(7));
					ob.setRole(result.getInt(8));
					ob.setStatus_id(result.getInt(9));
					ob.setPeriod_id(result.getInt(10));
					list.add(ob);
				}
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	public ArrayList<UserPlanBean> getAllPlanDetail(){
		ArrayList<UserPlanBean> list=new ArrayList<UserPlanBean>();
		Query query=Query.getInstance();
			try {
				ResultSet result=query.getAllPlanDetail();
				while(result.next()){
					UserPlanBean ob=new UserPlanBean();
					ob.setPlan_id(result.getInt(1));
					ob.setPlan(result.getString(2));
					ob.setDuration(result.getString(3));
					ob.setAmount(result.getInt(4));
					ob.setPeriod(result.getString(5));
					ob.setStatus(result.getString(6));
					ob.setRole_name(result.getString(7));
					list.add(ob);
				}
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public ArrayList<CategoryBean> getCategory() throws SQLException{
		ArrayList<CategoryBean> list=new ArrayList<CategoryBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getCategoryList();
		while(result.next()){
			CategoryBean ob=new CategoryBean();
			ob.setCategory_id(result.getInt(1));
			ob.setCategory(result.getString(2));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<UserPlanBean> getUserPlan(int role) throws SQLException{
		ArrayList<UserPlanBean> list=new ArrayList<UserPlanBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getUserPlan(role);
		while(result.next()){
			UserPlanBean ob=new UserPlanBean();
			ob.setPlan_id(result.getInt(1));
			ob.setPlan(result.getString(2));
			ob.setDuration(result.getString(3));
			ob.setAmount(result.getInt(4));
			list.add(ob);
		}
		return list;	
	}
	
	public ArrayList<Register> getDoctorName() throws SQLException{
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		System.out.println("abovewhile");
		ResultSet result=query.getDoctorName();
		System.out.println("onwhile");
		while(result.next()){
			System.out.println("while");
			Register ob=new Register();
			ob.setId(result.getInt(1));
			System.out.println(result.getInt(1));
			ob.setName(result.getString(2));
			System.out.println(result.getString(2));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<Register> getUserNotification(int uesrId) throws SQLException {
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getUserNotification(uesrId);
		while(result.next()){
			Register r=new Register();
			r.setNotification(result.getString(1));
			list.add(r);
		}
		return list;
	}
	
	public ArrayList<Register> getUserNotificationByDate(int uesrId,String date) throws SQLException {
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getUserNotificationByDate(uesrId,date);
		
		/*System.out.println();
		System.out.println("result"+result);
		if(!result){
			Register r=new Register();
			r.setNotification("no notification");
		}*/
		while(result.next()){
			Register r=new Register();
			
			r.setNotification(result.getString(1));
			list.add(r);
			
		}
		return list;
	}
	public int setNotificationAsSeen(int userId) throws SQLException{
		Query query=Query.getInstance();
		query.setNotificationAsSeen(userId);
		return 1;
	}
	
	public int NumberOfUnreadNotification(int uesrId) throws SQLException{
		Query query=Query.getInstance();
		int flag=0;
		ResultSet result=query.getUnreadNotification(uesrId);
		while(result.next()) flag++;
		return flag;
	}
public List<HealthGuidelineBean> getGuideline( int cat) throws SQLException{
		
		Query query=Query.getInstance();
	
	List<HealthGuidelineBean> s = new ArrayList<HealthGuidelineBean>();
	ResultSet rs=query.getDoctorGuideline(cat);
	
		while(rs.next()){
			
			HealthGuidelineBean h=new HealthGuidelineBean();
			h.setHealthguideline_id(rs.getInt("healthguideline_id"));
		    h.setGuideline(rs.getString("guideline"));
            h.setDate(rs.getDate("date"));
            h.setDoctor(rs.getString("name"));
            h.setCategory("category_name");
			s.add(h);
			
			
			
		}
		
		return s;
	
	}
public List<HealthGuidelineBean> getLatestGuideline() throws SQLException{
	
	
	Query query=Query.getInstance();

List<HealthGuidelineBean> s = new ArrayList<HealthGuidelineBean>();
ResultSet rs=query.getHomeGuideline();

	while(rs.next()){
		System.out.println("guideline");
		System.out.println("guideline");
		HealthGuidelineBean h=new HealthGuidelineBean();
		h.setHealthguideline_id(rs.getInt("healthguideline_id"));
	    h.setGuideline(rs.getString("guideline"));
        h.setDate(rs.getDate("date"));
        h.setDoctor(rs.getString("name"));
        h.setCategory("category_name");
		s.add(h);
		
		
		
	}
	
	return s;

}
	public ArrayList<Register> getPatientname() throws SQLException{
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatients();
		while(result.next()){
			Register r=new Register();
			System.out.print(result.getString("name"));
			r.setName(result.getString("name"));
			System.out.print(r.getName());
			System.out.print(result.getInt("user_id"));
			r.setId(result.getInt("user_id"));
			System.out.print(r.getId());
			r.setCategory(result.getString("category_name"));
			System.out.print(r.getCategory());
			list.add(r);
			
		}
		return list;
	}
	public ArrayList<Register> getAllDoctor() throws SQLException{
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getAllDoctors();
		
			while(result.next()){
				Register s=new Register();
			s.setDid(result.getInt("user_id"));
				s.setName(result.getString("name"));
				
				list.add(s);
				
	
			
		}
		return list;
	}

	public ArrayList<Register> getDoctorInfo(int id) {
		// TODO Auto-generated method stub
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getDrInfo(id);
		System.out.println("iiiiiidddddd"+id);
			try {
				while(result.next()){
					Register s=new Register();
					 s.setId(id);
					 System.out.println("iiiiiidddddd"+id);
					s.setName(result.getString("name"));
					System.out.println(result.getString("name"));
					s.setAddress(result.getString("address"));
					s.setCity(result.getString("city"));
					s.setState(result.getString("state"));
					s.setGender(result.getString("gender"));
					s.setMobile(result.getString("mobile"));
					s.setEmail(result.getString("email"));
					s.setBdate(result.getString("bdate"));
					s.setRegDate(result.getString("reg_date"));
					s.setBloodGroup(result.getString("blood_group"));
					s.setCategory(result.getString("category_name"));
					s.setDegree(result.getString("degree"));
					s.setCertificateNumber(result.getString("cert_no"));
					s.setRegPlanName(result.getString("plan_name"));
					list.add(s);
				
}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	public ArrayList<Register> getPatientInfo(int id) {
		// TODO Auto-generated method stub
		ArrayList<Register> list=new ArrayList<Register>();
		Query query=Query.getInstance();
		ResultSet result=query.getPInfo(id);
		
			try {
				while(result.next()){
					Register s=new Register();
				    s.setId(result.getInt("user_id"));
					s.setName(result.getString("name"));
					System.out.println(result.getString("name"));
					s.setAddress(result.getString("address"));
					s.setCity(result.getString("city"));
					s.setState(result.getString("state"));
					s.setGender(result.getString("gender"));
					s.setMobile(result.getString("mobile"));
					s.setEmail(result.getString("email"));
					s.setBdate(result.getString("bdate"));
					s.setRegDate(result.getString("reg_date"));
					s.setBloodGroup(result.getString("blood_group"));
					s.setCategory(result.getString("category_name"));
					
					s.setRegPlanName(result.getString("plan_name"));
					list.add(s);
				
}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
		
	}
	
	public List<AdminInfo> getNews() throws SQLException{
		
		
		Query query=Query.getInstance();

	List<AdminInfo> s = new ArrayList<AdminInfo>();
	ResultSet rs=query.getNews();

		while(rs.next()){
			System.out.println("news");
		
			AdminInfo a=new AdminInfo();
			a.setNewsId(rs.getInt("id"));
		    a.setNews(rs.getString("text"));
	       
			s.add(a);
			
			
			
		}
		
		return s;

	}
	public ArrayList<UserPlanBean> getPlanByRole(){
		ArrayList<UserPlanBean> list=new ArrayList<UserPlanBean>();
		Query query=Query.getInstance();
			try {
				ResultSet result=query.getUserPlan(3);
				while(result.next()){
					UserPlanBean ob=new UserPlanBean();
					ob.setPlan_id(result.getInt(1));
					ob.setPlan(result.getString(2));
					ob.setDuration(result.getString(3));
					ob.setAmount(result.getInt(4));
					list.add(ob);
				}
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public ArrayList<MessageBean> getUserMessage(int uid) throws SQLException {
		ArrayList<MessageBean> list=new ArrayList<MessageBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getUserMessage(uid);
		while(result.next()){
			MessageBean ob=new MessageBean();
			ob.setMessage_id(result.getInt(1));
			System.out.println("1111111111111"+ob.getMessage_id());
			ob.setMessage(result.getString(2));
			System.out.println(ob.getMessage());
			ob.setSender(result.getInt(3));
			ob.setReceiver(result.getInt(4));
			ob.setDate(result.getString(5));
			ob.setName(result.getString(6));
			list.add(ob);
		}
		result.close();
		return list;
	}
	

public ArrayList<Register> getAllUser() throws SQLException {
	ArrayList<Register> list=new ArrayList<Register>();
	Query query=Query.getInstance();
	ResultSet result=query.getAllUser();
	while(result.next()){
		Register ob=new Register();
		ob.setName(result.getString(1));
		//System.out.println("1111111111111"+ob.getMessage_id());
		ob.setEmail(result.getString(2));
		
		list.add(ob);
	}
	result.close();
	return list;
}
public ArrayList<HealthGuidelineBean> getSpecificGuideline(String []words, int j) throws SQLException {
	ArrayList<HealthGuidelineBean> list=new ArrayList<HealthGuidelineBean>();
	Query query=Query.getInstance();
	ResultSet result=query.getSpecificGuideline(words,j);
	
	while(result.next()){
		HealthGuidelineBean ob=new HealthGuidelineBean();
		ob.setHealthguideline_id(result.getInt(1));
		ob.setGuideline(result.getString(2));
		ob.setDate(result.getDate(3));
		ob.setDoctor(result.getString(4));
		
		list.add(ob);
	}
	
	result.close();
	return list;
}

}

