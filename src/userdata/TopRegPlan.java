package userdata;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaBean.Register;
import DAO.Query;
public class TopRegPlan {
	public ArrayList<Register> PatientPlans() throws SQLException{
		ArrayList<Register> list1=new ArrayList<Register>();
		ResultSet rs = null;
     try{
 	     
	     Query query=Query.getInstance();
 	      rs=query.getTopRegPlanP();
 	    
 	     while(rs.next()){
 	    	 Register vo=new Register();
 	    	 vo.setRegPlanName(rs.getString(1));// string
 	    	 vo.setRegPlanDuration(rs.getString(2));
 	    	vo.setRegPlanAmount(rs.getString(3));
 	    	list1.add(vo);
 	     }
 	    
     }

    catch (Exception e) {
	  System.out.print(e);
     }
     finally
     {
    	 rs.close();
     }
     return list1;
	}
	
	public ArrayList<Register> DoctorPlans() throws SQLException{
		ArrayList<Register> list1=new ArrayList<Register>();
		ResultSet rs = null;
     try{
 	     
	     Query query=Query.getInstance();
	     rs=query.getTopRegPlanD();
 	    
 	     while(rs.next()){
 	    	 Register vo=new Register();
 	    	vo.setRegPlanName(rs.getString(1));// string
	    	 vo.setRegPlanDuration(rs.getString(2));
	    	vo.setRegPlanAmount(rs.getString(3));
 	    	list1.add(vo);
 	     }
 	    
     }

    catch (Exception e) {
	  System.out.print(e);
     }
     finally
     {
    	 rs.close();
     }
     return list1;
	}

}