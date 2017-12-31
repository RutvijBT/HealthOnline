package userdata;

import java.sql.SQLException;

import DAO.Query;

public class CheckExpiredate implements Runnable{
	public CheckExpiredate() {
		Thread t=new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		//System.out.print("\nint CheckExpiredate run");
		while(true){
			try {
				System.out.print("\n Checking expire date");
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
