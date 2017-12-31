package userdata;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DAO.Query;

public class CheckExpiredDtaeInBackgroundThread implements ServletContextListener,Runnable {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Thread t=new Thread(this);
			t.start();
		} catch (Exception e) {
			System.out.print(e);
		}	
	}

	@Override
	public void run() {
		while(true){
			try {
				System.out.print("\nBackground thread : Checking expire date");
				Query query=Query.getInstance();
				query.checkPlanValidity();
				Thread.sleep(30000);
			//	Thread.sleep(86400000);
			} catch (SQLException e) {
				System.out.print(e);
			}
			catch (InterruptedException e) {
				System.out.print(e);
			}
			
		}
		
		
	}

}
