package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.*;

public final class Query {
	
	public static void main(String a[]){
		Query ob=Query.getInstance();
		try {
			ResultSet result=ob.getTodayAppintment(7, 2);
			while(result.next()){
				System.out.println("essss");
				System.out.println(result.getInt(1));
			}
		} catch (SQLException e) {
			System.out.print(e);
		}
	}
	
	private Query(){}
	private volatile static Query query=null;
	
	public static Query getInstance(){
		if(query==null){
			synchronized (Query.class) {
				query=new Query();
			}
		}
		return query;
	}
	
	private String sql;
	private PreparedStatement pr;
	private ResultSet result;
	private Connection con;
	private int row;
	
//yes=====================================================================================================================//
	public boolean isUserWithSameEmailExist(String email) throws SQLException{
		boolean flag=false;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select name from user_master where email=? ";
		pr=con.prepareStatement(sql);
		pr.setString(1,email);
		result=pr.executeQuery();
		while(result.next()) flag=true;
		return flag;
	}
	
	public int registerUser(Register obj,int role) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		sql="insert into healthonline.user_master (name, address,city,state,mobile,email,gender,bdate,reg_date,category_id,blood_group,role_id) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		pr=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pr.setString(1, obj.getName());
		pr.setString(2, obj.getAddress());
		pr.setString(3, obj.getCity());
		pr.setString(4, obj.getState());
		pr.setString(5, obj.getMobile());
		pr.setString(6, obj.getEmail());
		pr.setString(7, obj.getGender());
		pr.setString(8, obj.getBdate());
		pr.setString(9, date);
		pr.setString(10,obj.getCategory());
		pr.setString(11, obj.getBloodGroup());
		pr.setInt(12, role);
		row=pr.executeUpdate();
		int user_id=0;
		ResultSet rs=pr.getGeneratedKeys();
		while(rs.next()){
			user_id=rs.getInt(1);
		//	System.out.print(i+" iiiiiiiiiii\n");
		}
		
		sql="insert into healthonline.login (email,password,status_id,role_id,login_user_id) values(?,?,?,?,?)";
		pr=con.prepareStatement(sql);
		pr.setString(1, obj.getEmail());
		pr.setString(2, obj.getPassword());
		pr.setInt(3, 11);
		pr.setInt(4, 3);
		pr.setInt(5, user_id);
		pr.executeUpdate();
		pr.close();
		return user_id;
	}
	
	
	public void regiserDoctor(int  user_id,Register obj) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="insert into healthonline.doctor_detail (cert_no,cert_file,authority_name,user_id,degree) values(?,?,?,?,?)";
		pr=con.prepareStatement(sql);
		pr.setString(1, obj.getCertificateNumber());
		pr.setString(2, obj.getCertificateFile());
		pr.setString(3, obj.getAuthority());
		pr.setInt(4, user_id);
		pr.setString(5, obj.getDegree());
		pr.executeUpdate();
		
		sql="UPDATE login l SET status_id=? where login_user_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1, 3);
		pr.setInt(2, user_id);
		pr.executeUpdate();
		pr.close();
	}
public void changeStatus(int status,int userId) throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="update login set status_id=? where login_user_id=?";
	pr=con.prepareStatement(sql);
	pr.setInt(1, status);
	pr.setInt(2, userId);
	pr.executeUpdate();
	pr.close();
}
//yes=====================================================================================================================//
	//for login
	
	public int authenticateUser(LoginBean obj) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT login_user_id FROM healthonline.login where email=? and password=?";
		pr=con.prepareStatement(sql);
		pr.setString(1, obj.getUsername());
		pr.setString(2, obj.getPassword());
		ResultSet rs=pr.executeQuery();
		int userId=0;
		while(rs.next()){
			userId=rs.getInt(1);
		}
		rs.close();
		return userId;
	}
	
	public ResultSet getUserSessionDetail(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT user_id,name,category_id,login.role_id,status_id FROM user_master join login on user_master.user_id=login.login_user_id where user_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1, userId);
		ResultSet rs=pr.executeQuery();
		return rs;
	
	}
	
	public ResultSet getPassword(Register ob) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select name,password from login join user_master on login.login_user_id=user_master.user_id "
				+ "where user_master.email=? and mobile=?";
		pr=con.prepareStatement(sql);
		pr.setString(1, ob.getEmail());
		pr.setString(2, ob.getMobile());
		ResultSet rs=pr.executeQuery();
		return rs;
	}
//yes=====================================================================================================================//
//for question and answer	
	public void postQuestion(HttpServletRequest request, HttpServletResponse response, int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		sql="insert into healthonline.content (content,category_id,status_id,content_master_id,content_user_id,date) values(?,?,?,?,?,?)";
		pr=con.prepareStatement(sql);
		pr.setString(1, request.getParameter("question"));
		pr.setInt(2, Integer.parseInt(request.getParameter("category")));
		pr.setInt(3, 7);
		pr.setInt(4, 1);
		pr.setInt(5,userId);
		pr.setString(6,date);
		pr.executeUpdate();
	}
	
	public ResultSet getPatientQuestion(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content from healthonline.content where content_master_id=? and status_id=? and content_user_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		pr.setInt(2,6);
		pr.setInt(3,userId);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getLastTenQuestion() throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content from healthonline.content where content_master_id=? and status_id=?  ORDER BY content_id DESC limit 10;";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		pr.setInt(2,6);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getAllQuestion() throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content,name,date  from content left join user_master on content.content_user_id=user_master.user_id where content_master_id=?  ORDER BY content_id DESC;";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getAllUnansweredQuestion() throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content,name,date  from content left join user_master on content.content_user_id=user_master.user_id where content_master_id=? and status_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		pr.setInt(2,7);
		result=pr.executeQuery();
		return result;
	}
	
	
	public ResultSet getAllAnsweredQuestion() throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content,name,date  from content left join user_master on content.content_user_id=user_master.user_id where content_master_id=? and status_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		pr.setInt(2,6);
		result=pr.executeQuery();
		return result;
	}
	public ResultSet getCategoryQuestion(int categoryId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select content_id,content from healthonline.content where content_master_id=? and category_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,1);
		pr.setInt(2,categoryId);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getUnansweredCategoryQuestion(int categoryId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT content_id,content,date,name from content left join user_master on content.content_user_id=user_master.user_id "
					+ "where content.category_id=? and content_master_id=? and status_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,categoryId);
		pr.setInt(2,1);
		pr.setInt(3,7);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getUnansweredPatientQuestion(int patientId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT content_id,content,date,name from content left join user_master on content.content_user_id=user_master.user_id "
					+ "where content_user_id=? and content_master_id=? and status_id=? ORDER BY content_id DESC";
		pr=con.prepareStatement(sql);
		pr.setInt(1,patientId);
		pr.setInt(2,1);
		pr.setInt(3,7);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getAnswer(int questionId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT content_id,content,date,name,content_user_id,likes from healthonline.content  join user_master  join healthonline.question_answer_mapping on "
				+ "healthonline.user_master.user_id=content_user_id and healthonline.content.content_id=healthonline.question_answer_mapping.a_content_id "
						+ "where question_answer_mapping.q_content_id=? ";
		pr=con.prepareStatement(sql);
		pr.setInt(1,questionId);
		result=pr.executeQuery();
		return result;
	}
	
	public void postAnswer(AnswerBean ans) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		sql="Insert into content (content,category_id,status_id,content_master_id,content_user_id,date) values(?,?,?,?,?,?)";
		pr=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pr.setString(1, ans.getAnswer());
		pr.setInt(2, 2);
		pr.setInt(3, 12);
		pr.setInt(4, 2);
		pr.setInt(5, ans.getDoctor());
		pr.setString(6, date);
		pr.executeUpdate();
		int content_id=0;
		ResultSet rs=pr.getGeneratedKeys();
		while(rs.next()){
			content_id=rs.getInt(1);
		}
		sql="UPDATE content SET status_id=? where content_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1,6);
		pr.setInt(2, ans.getQuestion_id());
		pr.executeUpdate();	
		
		sql="insert into healthonline.question_answer_mapping (q_content_id,a_content_id) values(?,?)";
		pr=con.prepareStatement(sql);
		pr.setInt(1, ans.getQuestion_id());
		pr.setInt(2, content_id);
		pr.executeUpdate();		
	}
	
	public void deleteContent(int questionId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="DELETE FROM content WHERE content_id=?";
		pr=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);	
		pr.setInt(1, questionId);
		pr.executeUpdate();
	}
	
	public void deleteQuestion(int questionId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="DELETE FROM content WHERE content_id=?";
		pr=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);	
		pr.setInt(1, questionId);
		pr.executeUpdate();
	}
	
//yes=====================================================================================================================//
	//general
		public ResultSet getCategoryList() throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="Select * from healthonline.category";
			pr= con.prepareStatement(sql);
			result=pr.executeQuery();
			return result;
		}
//yes=====================================================================================================================//
		public void makeAppintment(AppointmentBean app) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			sql="INSERT INTO healthonline.appointment (patient, doctor, date,status_id,comment) VALUES(?,?,?,?,?)";
			pr= con.prepareStatement(sql);
			pr.setInt(1,app.getPatient());
			pr.setInt(2,app.getDoctor());
			pr.setString(3,app.getDate());
			pr.setInt(4,3);
			pr.setString(5,app.getComment());
			pr.executeUpdate();
			
			sql="SELECT name FROM user_master where user_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,app.getPatient());
			result= pr.executeQuery();
			String patient=null;
			while(result.next()){
				patient=result.getString(1);
			}
			if(patient!=null){
				sql="Insert into notification (notification,date,user_id) values(?,?,?)";
				pr= con.prepareStatement(sql);
				pr.setString(1, "You have appointment from "+patient+" on the date "+app.getDate());
				pr.setString(2,date);
				pr.setInt(3,app.getDoctor());
				pr.executeUpdate();
			}
			
		}
		
		public ResultSet getPendingAppintment(int userId,int role) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="select appointment_id,name, date,time,user_id,comment from appointment join user_master "
					+ "on appointment.patient=user_master.user_id or appointment.doctor=user_master.user_id"
						+ " where status_id=? and role_id !=? and (patient=? or doctor=?) ORDER BY date DESC";
			pr= con.prepareStatement(sql);
			pr.setInt(1,3);
			pr.setInt(2,role);
			pr.setInt(3,userId);
			pr.setInt(4,userId);
			result= pr.executeQuery();
			return result;
		}
		
		public ResultSet getConfirmedAppintment(int userId,int role) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="select appointment_id,name, date,time from appointment join user_master "
					+ "on appointment.patient=user_master.user_id or appointment.doctor=user_master.user_id"
						+ " where status_id=? and role_id !=? and (patient=? or doctor=?) ORDER BY date DESC";
			pr= con.prepareStatement(sql);
			pr.setInt(1,4);
			pr.setInt(2,role);
			pr.setInt(3,userId);
			pr.setInt(4,userId);
			result= pr.executeQuery();
			return result;
		}
		
		public ResultSet getTodayAppintment(int userId,int role) throws SQLException{
			Connect connect=Connect.getinstance();
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			con=connect.getConnection();
			sql="select appointment_id,name, date,time,comment from appointment join user_master "
					+ "on appointment.patient=user_master.user_id or appointment.doctor=user_master.user_id"
						+ " where status_id=? and role_id !=? and (patient=? or doctor=?) and date=? and status_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,3);
			pr.setInt(2,role);
			pr.setInt(3,userId);
			pr.setInt(4,userId);
			pr.setString(5,date);
			pr.setInt(6,4);
			result= pr.executeQuery();
			return result;
		}
		
		public void deleteAppointment(int appointmentId) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="DELETE FROM appointment WHERE appointment_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,appointmentId);
			pr.executeUpdate();
		}
		
		public void confirmAppointment(AppointmentBean ob) throws SQLException{
			Connect connect=Connect.getinstance();
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			con=connect.getConnection();
			sql="UPDATE appointment SET status_id=?,time=? where appointment_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,4);
			pr.setString(2, ob.getTime());
			pr.setInt(3,ob.getAppointment());
			pr.executeUpdate();
			String doctor=getUserNameById(ob.getDoctor());
			if(doctor!=null){
				sql="Insert into notification (notification,date,user_id) values(?,?,?)";
				pr= con.prepareStatement(sql);
				pr.setString(1, "Your appointment has been confirmed by "+doctor);
				pr.setString(2,date);
				pr.setInt(3,ob.getPatient());
				pr.executeUpdate();
			}
		}
		
		
//yesss=====================================================================================================================//
		public ResultSet getPatientMedicalHistory(int userId) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="Select * from medical_history where user_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1, userId);
			result=pr.executeQuery();
			return result;
		}
		
		public void savePatientMedicalHistory(MedicalHistoryBean ob) throws SQLException{
			Connect connect=Connect.getinstance();
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			con=connect.getConnection();
			sql="INSERT INTO medical_history (medical_file_name,file_description,date_by_patient,date_of_file_upload,user_id) VALUES(?,?,?,?,?);";
			pr= con.prepareStatement(sql);
			pr.setString(1, ob.getFileName());
			pr.setString(2, ob.getDescription());
			pr.setString(3, ob.getDateByPatient());
			pr.setString(4, date);
			pr.setInt(5, ob.getId());
			pr.executeUpdate();
		}
		
		public ResultSet getPatientPrescription(int patientId) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="SELECT prescription_id,name,symptom, diagnosis,date FROM prescription left join user_master on "
								+ "prescription.doctor_id=user_master.user_id where patient_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1, patientId);
			result=pr.executeQuery();
			return result;
		}
		
		public ResultSet getMedicine(int prescriptionId) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="SELECT medicine,dosage FROM medicine where prescription_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1, prescriptionId);
			result=pr.executeQuery();
			return result;
		}
		
		public void savePatientDescription(PatientSelfDescriptionBean ob) throws SQLException{
			Connect connect=Connect.getinstance();
			String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			con=connect.getConnection();
			sql="insert into self_description (description,date,user_id) values(?,?,?)";
			pr= con.prepareStatement(sql);
			pr.setString(1,ob.getDescription());
			pr.setString(2, date);
			pr.setInt(3, ob.getUser());
			pr.executeUpdate();
			
		}
		
		public ResultSet getPatientDescription(int userId) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="SELECT description,date FROM self_description where user_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,userId);
			result=pr.executeQuery();
			return result;
		}
		
		public int deleteMedicalHistory(int id) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="DELETE FROM medical_history where pm_history_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,id);
			row=pr.executeUpdate();
			return row;
		}
//yes=====================================================================================================================//
		public ResultSet getUserPlan(int role) throws SQLException{
			Connect connect=Connect.getinstance();
			con=connect.getConnection();
			sql="SELECT plan_id, plan_name,duration,amount FROM plan where role_id=? and status_id=?";
			pr= con.prepareStatement(sql);
			pr.setInt(1,role);
			pr.setInt(2,1);
			result=pr.executeQuery();
			return result;
		}
	
//yy=====================================================================================================================//
	
	public ResultSet getUserNameByRole(int role) throws SQLException {
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT user_id, name FROM user_master where role_id=?");
		pr.setInt(1, role);
		result=pr.executeQuery();
		return result;
	}
	
	public String getUserNameById(int UserId) throws SQLException{
		sql="SELECT name FROM user_master where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1,UserId);
		result= pr.executeQuery();
		String user=null;
		while(result.next()){
			user=result.getString(1);
		}
		return user;
		
	}
//yy=====================================================================================================================//

	public ResultSet getUserNotification(int uesrId) throws SQLException {
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT notification FROM notification where user_id=?");
		pr.setInt(1,uesrId);
		result=pr.executeQuery();
		return result;
	}
	
	public ResultSet getUserNotificationByDate(int uesrId,String date) throws SQLException {
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT notification FROM notification where user_id=? and date=?");
		pr.setInt(1,uesrId);
		pr.setString(2, date);
		result=pr.executeQuery();
		return result;
	}
	
	public void setNotificationAsSeen(int userId) throws SQLException {
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("UPDATE notification SET status_id=? where user_id=?");
		pr.setInt(1,8);
		pr.setInt(2,userId);
		pr.executeUpdate();
	}
	
	public ResultSet getUnreadNotification(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT * FROM notification where user_id=? and status_id=?");
		pr.setInt(1,userId);
		pr.setInt(2,9);
		result=pr.executeQuery();
		return result;
	}
	public void addNotificatonAboutDeleteContent(int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		sql="SELECT content_user_id FROM content where content_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, contentId);
		result=pr.executeQuery();
		int userId=0;
		while(result.next())
			userId=result.getInt(1);
		System.out.print(userId);
		sql="Insert into notification (notification,date,user_id) values(?,?,?)";
		pr= con.prepareStatement(sql);
		pr.setString(1, "Your some content is deleted by Admin due to some non-relevent words or statements");
		pr.setString(2,date);
		pr.setInt(3, userId);
		pr.executeUpdate();
	}
//yes============================================================================================================	
	public ResultSet getLikes(int userId,int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT * FROM likes where user_id=? and content_id=?");
		pr.setInt(1,userId);
		pr.setInt(2,contentId);
		result=pr.executeQuery();
		return result;
	}
	
	public void likeAnswer(int userId,int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="INSERT INTO likes (user_id,content_id)  VALUES(?,?);";
		pr=con.prepareStatement(sql);
		pr.setInt(1,userId);
		pr.setInt(2,contentId);
		pr.executeUpdate();
		
		sql="UPDATE question_answer_mapping SET likes=likes+1 where a_content_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1,contentId);
		pr.executeUpdate();
	}
	
	public void unLikeAnswer(int userId,int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="DELETE FROM likes WHERE user_id=? and content_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1,userId);
		pr.setInt(2,contentId);
		pr.executeUpdate();
		
		sql="UPDATE question_answer_mapping SET likes=likes-1 where a_content_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1,contentId);
		pr.executeUpdate();
	}
	
	
	public ResultSet getReportOfAnswer(int userId,int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("SELECT * FROM answer_report where user_id=? and content_id=?");
		pr.setInt(1,userId);
		pr.setInt(2,contentId);
		result=pr.executeQuery();
		return result;
	}
	
	public void reportAnswerToAdmin(int userId,int contentId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="INSERT INTO answer_report (user_id,content_id)  VALUES(?,?);";
		pr=con.prepareStatement(sql);
		pr.setInt(1,userId);
		pr.setInt(2,contentId);
		pr.executeUpdate();
		
		sql="UPDATE content SET status_id=? where content_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1,10);
		pr.setInt(2,contentId);
		pr.executeUpdate();
	}
	
//yes=====================================================================================================================//

	public void sendMessage(MessageBean msg) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		sql="INSERT INTO message (message,sender,receiver,date) VALUES(?,?,?,?)";
		pr=con.prepareStatement(sql);
		pr.setString(1,msg.getMessage());
		pr.setInt(2,msg.getSender());
		pr.setInt(3,msg.getReceiver());
		pr.setString(4,date);
		pr.executeUpdate();
		
		String user=getUserNameById(msg.getSender());
		sql="Insert into notification (notification,date,user_id) values(?,?,?)";
		pr= con.prepareStatement(sql);
		pr.setString(1, "You have new message from "+user);
		pr.setString(2,date);
		pr.setInt(3,msg.getReceiver());
		pr.executeUpdate();
	}
	
	public ResultSet getUserMessage(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT message_id,message,sender,receiver,date,name FROM message left join user_master on message.sender=user_master.user_id where sender=? or receiver=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		pr.setInt(2, userId);
		result=pr.executeQuery();
        return result;	
	}
//Query For plan==============================================================================================================	
	public ResultSet getAllPlanDetail() throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT plan_id,plan_name,duration,amount,period_name,status,role_name FROM plan join period join status join "
				+ "role on plan.period_id=period.period_id and plan.status_id=status.status_id and plan.role_id=role.role_id";
		pr= con.prepareStatement(sql);
		result=pr.executeQuery();
        return result;	
	}
	
	public ResultSet getPlanDetail(int planId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT plan_id,plan_name,duration,amount,period_name,status,role_name,role.role_id,status.status_id,period.period_id FROM plan join period join status join "
				+ "role on plan.period_id=period.period_id and plan.status_id=status.status_id and plan.role_id=role.role_id where plan_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, planId);
		result=pr.executeQuery();
        return result;	
	}
	
	public void deletePlan(int planId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="DELETE FROM plan WHERE plan_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, planId);
		pr.executeUpdate();
	}
	
	public void insertPlan(UserPlanBean plan) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="INSERT INTO healthonline.plan (plan_name,duration,amount,period_id,status_id,role_id) VALUES(?,?,?,?,?,?)";
		pr= con.prepareStatement(sql);
		pr.setString(1, plan.getPlan());
		pr.setString(2, plan.getDuration());
		pr.setInt(3, plan.getAmount());
		pr.setInt(4, plan.getPeriod_id());
		pr.setInt(5, plan.getStatus_id());
		pr.setInt(6, plan.getRole());
		pr.executeUpdate();
	}
	
	public void updatePlan(UserPlanBean plan) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.plan SET plan_name=?,duration=?,amount=?, period_id=?,status_id=?,role_id=? where plan_id=?";
		pr= con.prepareStatement(sql);
		pr.setString(1, plan.getPlan());
		pr.setString(2, plan.getDuration());
		pr.setInt(3, plan.getAmount());
		pr.setInt(4, plan.getPeriod_id());
		pr.setInt(5, plan.getStatus_id());
		pr.setInt(6, plan.getRole());
		pr.setInt(7, plan.getPlan_id());
		pr.executeUpdate();
	}
	
	public int getAmoutByPlanId(int planId) throws SQLException{
		int amount=0;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT amount FROM plan where plan_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1,planId);
		ResultSet rs=pr.executeQuery();
		while(rs.next()) amount=rs.getInt(1);
		
		return amount;
		
	} 
	
	public void addNewPlan(int planId,PaymentBean pay) throws SQLException{
		ResultSet rs;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.user_plan SET status_id=2 WHERE user_id=?";
		pr= con.prepareStatement(sql);		
		pr.setInt(1, pay.getUserid());
		pr.executeUpdate();	
		int duration = 0;
		sql="SELECT duration FROM healthonline.plan WHERE plan_id=?";
		pr=con.prepareStatement(sql);
		pr.setInt(1, planId);
		rs=pr.executeQuery();
		while(rs.next()){
			duration=rs.getInt(1);
		}
		Date current=getCurerentDate();
		Date exp=getCurerentDate();
		exp.setMonth(exp.getMonth()+duration);
		sql="INSERT INTO healthonline.user_plan(user_id,plan_id,status_id,start_date,expiry_date) VALUES(?,?,1,?,?) ";
		pr= con.prepareStatement(sql);
		pr.setInt(1,pay.getUserid());
		pr.setInt(2,planId);
		pr.setDate(3,current);
		pr.setDate(4,exp);
		pr.executeUpdate();
		
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		String sql="INSERT INTO payment (amount,user_id,transaction_id,date) VALUES(?,?,?,?)";
		pr= con.prepareStatement(sql);
		pr.setFloat(1, pay.getAmount());
		pr.setInt(2, pay.getUserid());
		pr.setString(3, pay.getTransactionid());
		pr.setString(4, date);
		pr.executeUpdate();
		
		sql="UPDATE healthonline.login SET status_id=1 WHERE login_user_id=?";
		pr= con.prepareStatement(sql);		
		pr.setInt(1, pay.getUserid());
		pr.executeUpdate();
	}
	
	public void checkPlanValidity() throws SQLException{
	//	System.out.print("in plan validity");
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		Date dt=getCurerentDate();
		sql="SELECT expiry_date,user_id FROM user_plan where status_id=1";
		pr=con.prepareStatement(sql);
		ResultSet rs=pr.executeQuery();
		while(rs.next()){
		//	System.out.print("dt= "+dt+"  expiry="+rs.getDate(1)+"\n");
			if(rs.getDate(1).before(dt)){
			//	System.out.print("userid= "+rs.getInt(2)+"\n");
					planExpired(rs.getInt(2));
			}
			
		}
	}
	public void planExpired(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.user_plan SET status_id=2 WHERE user_id=?";
		pr= con.prepareStatement(sql);		
		pr.setInt(1,userId);
		pr.executeUpdate();
		sql="UPDATE healthonline.login SET status_id=11 WHERE login_user_id=?";
		pr= con.prepareStatement(sql);		
		pr.setInt(1,userId);
		pr.executeUpdate();
	}
	
	public Date getCurerentDate() throws SQLException{
		Date dt=null;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT CURDATE()";
		pr=con.prepareStatement(sql);
		ResultSet rs=pr.executeQuery();
		while(rs.next()){
			dt=rs.getDate(1);
		}
		return dt;
	}
//payment====================================================================================================
	
	public void savePaymentDetail(PaymentBean pay) throws SQLException{
		Connect connect=Connect.getinstance();
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		con=connect.getConnection();
		String sql="INSERT INTO payment (amount,user_id,transaction_id,date) VALUES(?,?,?,?)";
		pr= con.prepareStatement(sql);
		pr.setFloat(1, pay.getAmount());
		pr.setInt(2, pay.getUserid());
		pr.setString(3, pay.getTransactionid());
		pr.setString(4, date);
		pr.executeUpdate();   
	}
	

//Rutvij=====================================================================================================================//
	public ResultSet getUserProfile(int userId) throws SQLException{
		ResultSet result;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT user_master.name,user_master.address,user_master.city,user_master.state,user_master.mobile,user_master.email,login.password FROM healthonline.user_master INNER JOIN healthonline.login ON user_master.user_id=login.login_user_id where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		result=pr.executeQuery();
        return result;	
	}

	public void updateUserProfile(int userId,Register reg) throws SQLException{
		//Register reg=new Register();
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.user_master INNER JOIN healthonline.login ON user_master.user_id=login.login_user_id SET user_master.name=?,user_master.address=?,user_master.city=?,user_master.state=?,user_master.mobile=?,login.password=? WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setString(1, reg.getName());
		pr.setString(2, reg.getAddress());
		pr.setString(3, reg.getCity());
		pr.setString(4, reg.getState());
		pr.setString(5, reg.getMobile());
		pr.setString(6, reg.getPassword());
		pr.setInt(7, userId);
		pr.executeUpdate();	
	}
		
		
	public ResultSet getUserRegDetail(int userId) throws SQLException{
		ResultSet result;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT plan.plan_name,plan.duration,plan.amount,user_plan.expiry_date FROM healthonline.plan INNER JOIN healthonline.user_plan ON plan.plan_id=user_plan.plan_id WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		result=pr.executeQuery();
		return result;
	}
	public void resetShedule(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.doctor_availability set monday=0,tuesday=0,wednesday=0,thursday=0,friday=0,saturday=0,sunday=0 where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		pr.executeUpdate();
		
	}
	public void updateShedule(int userId, String day) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.doctor_availability set "+day+"=? where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, 1);
		pr.setInt(2, userId);
		pr.executeUpdate();
	}

	public ResultSet viewShedule(int userId) throws SQLException{
		ResultSet rs;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT * FROM healthonline.doctor_availability WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		rs=pr.executeQuery();
		return rs;
	}
	
	public ResultSet getPendingUserReq() throws SQLException{
		ResultSet rs;
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="SELECT user_master.name,doctor_detail.cert_no,doctor_detail.cert_file,doctor_detail.authority_name,doctor_detail.user_id FROM healthonline.user_master INNER JOIN healthonline.login ON user_master.user_id=login.login_user_id INNER JOIN healthonline.doctor_detail ON login.login_user_id=doctor_detail.user_id WHERE status_id=3";
		pr= con.prepareStatement(sql);
		rs=pr.executeQuery();
        return rs;	
	}
	
	public void confirmReq(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.user_master INNER JOIN healthonline.login ON user_master.user_id=login.login_user_id SET login.status_id=1 WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);

		pr.executeUpdate();
	}

	public void deleteReq(int userId) throws SQLException{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.user_master INNER JOIN healthonline.login ON user_master.user_id=login.login_user_id SET login.status_id=2 WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		pr.setInt(2, userId);
		pr.executeUpdate();
	}
	
	
	
	
	
public ResultSet getTopRegPlan()throws SQLException{
	    Connect connect=Connect.getinstance();
	    con=connect.getConnection();
		ResultSet  resultSet ;
		sql="select plan_name,duration,amount from healthonline.plan where role_id=2 limit 3";
		resultSet=pr.executeQuery();
        return resultSet;	
	}


public void insertNews(String txt)throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="INSERT INTO healthonline.news(text) VALUES(?)";
	pr= con.prepareStatement(sql);
	pr.setString(1, txt);
	pr.executeUpdate();
}
public void updateNews(AdminInfo obj)throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="UPDATE healthonline.news n SET text=? WHERE id=?";
	pr= con.prepareStatement(sql);
	pr.setString(1,obj.getNews());
	pr.setInt(2,obj.getNewsId() );
	pr.executeUpdate();
}
public void deleteNews(int newsId) throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="DELETE FROM healthonline.news WHERE id=?";
	pr=con.prepareStatement(sql);
	pr.setInt(1, newsId);
	pr.executeUpdate();
}

public ResultSet getNews()throws SQLException{
	
	ResultSet  resultSet ;
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT * FROM healthonline.news";
	pr= con.prepareStatement(sql);
	resultSet=pr.executeQuery();
    return resultSet;	
}

public ResultSet getNewsById(int newsId)throws SQLException{
	
	ResultSet  resultSet ;
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT text FROM healthonline.news WHERE id=?";
	pr= con.prepareStatement(sql);
	pr.setInt(1, newsId);
	resultSet=pr.executeQuery();
    return resultSet;	
}


public ResultSet getReportedAns() throws SQLException{
	ResultSet rs;
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT content_id,content FROM healthonline.content WHERE status_id=10";
	pr=con.prepareStatement(sql);
	rs=pr.executeQuery();
	return rs;
}
public ResultSet getReportedQue(int ansId) throws SQLException{
	ResultSet rs;
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT content.content FROM healthonline.content INNER JOIN healthonline.question_answer_mapping ON content.content_id=question_answer_mapping.q_content_id WHERE question_answer_mapping.a_content_id=?";
	pr=con.prepareStatement(sql);
	pr.setInt(1,ansId);
	rs=pr.executeQuery();
	return rs;
	
}
public void deleteAns(int ansId) throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="DELETE FROM healthonline.content WHERE content_id=?";
	pr=con.prepareStatement(sql);
	pr.setInt(1, ansId);
	pr.executeUpdate();
}
public void doNothing(int ansId) throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="UPDATE healthonline.content SET status_id=12 WHERE content_id=?";
	pr=con.prepareStatement(sql);
	pr.setInt(1, ansId);
	pr.executeUpdate();
}


public ResultSet getTopRegPlanP()throws SQLException{
Connect connect=Connect.getinstance();
con=connect.getConnection();
ResultSet  resultSet ;
sql="select plan_name,duration,amount from healthonline.plan where role_id=3 order by plan_id DESC limit 3";
pr= con.prepareStatement(sql);
resultSet=pr.executeQuery();
return resultSet;	
}

public ResultSet getTopRegPlanD()throws SQLException{
Connect connect=Connect.getinstance();
con=connect.getConnection();
ResultSet  resultSet ;
sql="select plan_name,duration,amount from healthonline.plan where role_id=2 order by plan_id DESC limit 3";
pr= con.prepareStatement(sql);
resultSet=pr.executeQuery();
return resultSet;	
}



//MANISHA=====================================================================================================================//
		public ResultSet getDoctorlist(int cat) {
			try{
				Connect connect=Connect.getinstance();
				con=connect.getConnection();
				pr=con.prepareStatement("select user_master.user_id,degree,category_name,name,address,city,state, user_master.email from login join user_master join category join doctor_detail " +
						"on user_master.category_id=category.category_id and user_master.user_id=doctor_detail.user_id and user_master.user_id=login.login_user_id" +
						" where user_master.role_id=2 and user_master.category_id=? and login.status_id=1");
				pr.setInt(1, cat);
				ResultSet rs=pr.executeQuery();
				System.out.println("manisha");
				
				return rs;
				
			}catch(Exception ex){System.out.print(ex);}
			return null;
			
			
			
		}
		
		public ResultSet getAllDoctors() {
			try{
				Connect connect=Connect.getinstance();
				con=connect.getConnection();
				pr=con.prepareStatement("select user_id,name from user_master where user_master.role_id=2 ");
				
				ResultSet rs=pr.executeQuery();
				System.out.println("manisha");
				
				return rs;
				
			}catch(Exception ex){System.out.print(ex);}
			return null;
			
			
			
		}
		
public ResultSet getCategory() {
	
	try{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("select category_name from category ");
		ResultSet rs=pr.executeQuery();
		
		System.out.println("manisha");
		return rs;
		
	}catch(Exception ex){System.out.print(ex);}
	return null;	
}	

	public int getRoleid(int id) throws SQLException{
		try{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="select role_id from user_master where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1,id);
		result=pr.executeQuery();
		int role=0;
		while(result.next()){
			role=result.getInt(1);
		}
		return role;
		
		}catch(Exception ex){System.out.print(ex);}
		return 0;	
	}


public int addPrescription(PrescriptionBean user) {
    try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	
    	
    	
	    pr= con.prepareStatement("insert into prescription(patient_id,doctor_id, symptom, diagnosis,date,comment) values (?,?, ?, ?, ? ,?)");
        // Parameters start with 1
        pr.setInt(1, user.getPatient());
        pr.setInt(2, user.getDoctor());
        pr.setString(3, user.getSympton());   
        pr.setString(4, user.getDiagnosis());   
        
        pr.setDate(5, new java.sql.Date(user.getDat().getTime()));
        pr.setString(6, user.getComment());   
        pr.executeUpdate();
       

    } catch (SQLException e) {
        e.printStackTrace();
        
    }int i=0;
    try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	
    	
    	
	    pr= con.prepareStatement("select prescription_id from prescription order by prescription_id DESC LIMIT 1");
        // Parameters start with 1
        
	    ResultSet rs= pr.executeQuery();
        
	    while(rs.next()){
        	i=rs.getInt("prescription_id");
        }
        return i;

    } catch (SQLException e) {
        e.printStackTrace();
    }
	return i;}
    public void addMedicine(PrescriptionBean user){
    try {
    	
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	
	    pr= con.prepareStatement("insert into medicine(prescription_id,medicine, dosage) values (?, ?, ?)");
        // Parameters start with 1
      
       System.out.println(user.getId());
    		
    	pr.setInt(1,user.getId());
        pr.setString(2, user.getMedicine());   
        pr.setString(3, user.getDosage());   
        pr.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    
}
public void addGuideline(HealthGuidelineBean h) {
	try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	
	pr= con.prepareStatement("select category_id from category where category_name=?");
        // Parameters start with 1
        pr.setString(1, h.getCategory());
       
        ResultSet rs=pr.executeQuery();
        while(rs.next()){
        	h.setCategory_id(rs.getInt("category_id"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	
	pr= con.prepareStatement("insert into healthguideline(doctor_id, guideline, date,category_id) values (?, ?, ?,? )");
        // Parameters start with 1
        pr.setInt(1, h.getDoctorid());
        pr.setString(2, h.getGuideline());
        pr.setDate(3, new java.sql.Date(h.getDate().getTime()));
        pr.setInt(4, h.getCategory_id());
        pr.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

}




	

public ResultSet getDoctorGuideline(int cat) {
	try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    	System.out.println(cat);
    	pr=con.prepareStatement("select healthguideline_id,guideline,date,name from user_master join healthguideline on user_master.user_id=healthguideline.doctor_id where healthguideline.category_id=?");
		
    	pr.setInt(1, cat);
		ResultSet rs=pr.executeQuery();
		
		
		return rs;
    	
	}catch(Exception e){
		 e.printStackTrace();
		 return null;
	}
}
public ResultSet getHomeGuideline() {
	try {
    	Connect connect=Connect.getinstance();
    	con=connect.getConnection();
    
    	pr=con.prepareStatement("select healthguideline_id,guideline,date,name from user_master join healthguideline " +
    			"on user_master.user_id=healthguideline.doctor_id order by healthguideline.date DESC LIMIT 1");
		
    	ResultSet rs=pr.executeQuery();	
		
		return rs;
    	
	}catch(Exception e){
		 e.printStackTrace();
		 return null;
	}
}

public ResultSet getPatients() {
	
	try{
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("select name,user_id,category_name from login join user_master join category on user_master.category_id=category.category_id and user_master.user_id=login.login_user_id where user_master.role_id=3 and status_id=1 ");
		ResultSet rs=pr.executeQuery();
		
		//System.out.println("manisha");
		return rs;
		
	}catch(Exception ex){System.out.print(ex);}
	return null;	
}
/*public static void main(String a[]) throws SQLException{
	
	Query ob1=Query.getInstance();
	System.out.print(ob1);
	System.out.print(ob1.getStudentList());
	
}*/

public ResultSet getDrInfo(int id) {
	try{System.out.print("");
		System.out.print("doctor"+id);
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("select name,address,city,state,mobile,email,gender,bdate,reg_date,blood_group,category_name,degree,cert_no,plan_name " +
				"from user_master join doctor_detail join category join user_plan join plan " +
				"on user_master.user_id=doctor_detail.user_id and user_plan.plan_id=plan.plan_id and  user_master.user_id=user_plan.user_id and user_master.category_id=category.category_id " +
				"where user_master.user_id=?");
		pr.setInt(1, id);
		ResultSet rs=pr.executeQuery();
		
		//System.out.println("manisha");
		return rs;
		
	}catch(Exception ex){
		System.out.print(ex);
		return null;
	}
	
}

public ResultSet getPInfo(int id) {
	// TODO Auto-generated method stub
	try{
		System.out.println("");
		System.out.println("user id"+id);
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("select user_master.user_id,name,address,city,state,mobile,email,gender,bdate,reg_date,blood_group,category_name,plan_name " +
				"from user_master join category join user_plan join plan " +
				"on user_plan.plan_id=plan.plan_id and  user_master.user_id=user_plan.user_id and user_master.category_id=category.category_id " +
				"where user_master.user_id=?");
		pr.setInt(1, id);
		ResultSet rs=pr.executeQuery();
		
		//System.out.println("manisha");
		return rs;
		
	}catch(Exception ex){
		System.out.print(ex);
		return null;
	}
}

public void deleteUser(int id) {
	// TODO Auto-generated method stub
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="UPDATE login SET status_id=2 WHERE login_user_id=?";
	try {
		pr= con.prepareStatement(sql);
		pr.setInt(1,id);
		pr.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void deleteHealthGuideline(int id) {
	// TODO Auto-generated method stub
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="DELETE FROM healthguideline WHERE healthguideline_id=?";
	try {
		pr= con.prepareStatement(sql);
		pr.setInt(1,id);
		pr.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public ResultSet getDoctorName() {
	try{
		
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		pr=con.prepareStatement("select user_id , name from user_master join login on user_master.user_id=login.login_user_id where user_master.role_id=2 and status_id=1");
		
		
		ResultSet rs=pr.executeQuery();
		
		System.out.println("aaaaaaaaaaaaaaaaamanisha");
		return rs;
		
	}catch(Exception ex){
		System.out.print(ex);
		return null;
	}
}

public void cancelMembership(int userId)throws SQLException {
	
		Connect connect=Connect.getinstance();
		con=connect.getConnection();
		sql="UPDATE healthonline.login join healthonline.user_master  ON user_master.user_id=login.login_user_id  SET login.status_id=2 WHERE user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1, userId);
		
		pr.executeUpdate();
		
		
		sql="SELECT name,role_id FROM user_master where user_id=?";
		pr= con.prepareStatement(sql);
		pr.setInt(1,userId);
		result= pr.executeQuery();
		String patient=null;
		int role = 0;
		while(result.next()){
			patient=result.getString(1);
			role=result.getInt(2);
			
		}
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		if(patient!=null){
			sql="Insert into notification (notification,date,user_id) values(?,?,?)";
			pr= con.prepareStatement(sql);
			if(role==2)
			pr.setString(1,"Dr. "+ patient+"Cacelled Membership on the date "+date);
			else
				pr.setString(1, patient+"Cacelled Membership on the date "+date);
			pr.setString(2,date);
			pr.setInt(3,1);
			pr.executeUpdate();
	
	
}		
			
			
		}


		
		
		

public ResultSet getTransactionDetails() throws SQLException{
	// TODO Auto-generated method stub
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT payment.user_id,user_master.name,payment.transaction_id,plan.plan_name,plan.duration,payment.amount,payment.date,user_plan.status_id from healthonline.payment join healthonline.user_master join  healthonline.user_plan join  healthonline.plan " +
			"ON user_master.user_id=payment.user_id and user_master.user_id=user_plan.user_id and plan.plan_id=user_plan.plan_id";
	pr= con.prepareStatement(sql);
	ResultSet rs=pr.executeQuery();
	return rs;
	
}

public ResultSet getAllUser() throws SQLException{
	Connect connect=Connect.getinstance();
	con=connect.getConnection();
	sql="SELECT name,email from user_master" ;
	pr= con.prepareStatement(sql);
	ResultSet rs=pr.executeQuery();
	return rs;
}




}

