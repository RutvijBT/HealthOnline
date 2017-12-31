package DAO;

import java.sql.*;

public final class Connect {
	
	private Connect(){}
	Connection con=null;
	private volatile static Connect connect=null;
	public static Connect getinstance(){
		if(connect==null){
			synchronized (Connect.class) {
				connect=new Connect();
			}
		}
		return connect;
	}	
	
	public Connection getConnection(){
		try{
			if(con==null){
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/healthonline";
				con=DriverManager.getConnection(url,"root","root");
			}
		}
		catch(Exception e){
			System.out.print(e);
			
		}
		return con;
	}
	
		public void closeConnection(){
		try {
			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		
	}
		
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		System.out.print("Creat object1 :\n");
		Connect ob1=Connect.getinstance();
		Connection con1=ob1.getConnection();
		System.out.print("con1 "+con1);
		
		System.out.print("\nCreat object2 :\n");
		Connect ob2=Connect.getinstance();
	//	Connection con2=ob2.getConnection();
		System.out.print(ob2);
		
		
		
	}
	
}
