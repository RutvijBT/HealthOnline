package userdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaBean.AppointmentBean;

import DAO.Query;

public class Appointment {

	public ArrayList<AppointmentBean> getPendingAppintment(int userId, int role) throws SQLException{
		ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPendingAppintment(userId,role);
		while(result.next()){
			AppointmentBean ob=new AppointmentBean();
			ob.setAppointment(result.getInt(1));
			ob.setName(result.getString(2));
			ob.setDate(result.getString(3));
			ob.setTime(result.getString(4));
			ob.setPatient(result.getInt(5));
			ob.setComment(result.getString(6));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<AppointmentBean> getConfirmedAppintment(int userId, int role) throws SQLException{
		ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getConfirmedAppintment(userId,role);
		while(result.next()){
			AppointmentBean ob=new AppointmentBean();
			ob.setAppointment(result.getInt(1));
			
			ob.setName(result.getString(2));
			System.out.print(ob.getName());
			ob.setDate(result.getString(3));
			ob.setTime(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<AppointmentBean> getTodayAppintment(int userId, int role) throws SQLException{
		ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getTodayAppintment(userId,role);
		while(result.next()){
			AppointmentBean ob=new AppointmentBean();
			ob.setAppointment(result.getInt(1));
			System.out.print(ob.getAppointment());
			ob.setName(result.getString(2));
			System.out.print(ob.getName());
			ob.setDate(result.getString(3));
			ob.setTime(result.getString(4));
			ob.setComment(result.getString(5));
		
			list.add(ob);
			System.out.print("g");
		}
		System.out.print("g");
		return list;
	}
	
	/*public void main(String a[]) throws SQLException{
		Appointment ob=new Appointment();
		
		ob.getTodayAppintment(7, 2);
	}*/
}
