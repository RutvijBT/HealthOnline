package userdata;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaBean.AdminInfo;
import javaBean.PaymentBean;
import DAO.Query;
public class Admin {
	
	/*
	public ArrayList<AdminInfo> GetNewsById(int newsId) throws SQLException{
		ArrayList<AdminInfo> list1=new ArrayList<AdminInfo>();
		ResultSet rs = null;
     try{
 	     
	     Query query=Query.getInstance();
 	      rs=query.getNewsById(newsId);
 	    
 	     while(rs.next()){
 	    	 AdminInfo vo=new AdminInfo();
 	    	 vo.setNews(rs.getString(1));// string
 	    	 System.out.print(rs.getString(1));
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

	public ArrayList<AdminInfo> GetNews() throws SQLException{
		ArrayList<AdminInfo> list1=new ArrayList<AdminInfo>();
		ResultSet rs = null;
     try{
 	     
	     Query query=Query.getInstance();
 	      rs=query.getNews();
 	    
 	     while(rs.next()){
 	    	 AdminInfo vo=new AdminInfo();
 	    	 vo.setNewsId(rs.getInt(1));// string
 	    	 vo.setNews(rs.getString(2));
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
	}*/
	
	public ArrayList<PaymentBean> getTransactionDetails()throws SQLException{
		ArrayList<PaymentBean> list1=new ArrayList<PaymentBean>();
		try{
			Query query=Query.getInstance();
			  System.out.println("11111111111111");
	 	     ResultSet rs=query.getTransactionDetails();
	 	    System.out.println("11111111111111"+rs);
	 	    while(rs.next()){
	 	    	System.out.println("11111111111111"+rs);
	 	    	 PaymentBean vo=new PaymentBean();
	 	    	 vo.setUserid(rs.getInt(1));
	 	    	 System.out.println();
	 	    	System.out.println("11111111111111"+rs.getInt(1));
	 	    	 vo.setName(rs.getString(2));
	 	    	 vo.setTransactionid(rs.getString(3));
	 	    	 vo.setPlan(rs.getString(4));// string
	 	    	 vo.setDuration(rs.getString(5));
	 	    	 vo.setAmount(rs.getFloat(6));
	 	    	 vo.setDate(rs.getString(7));
	 	    	vo.setStatus(rs.getInt(8));
	 	    	list1.add(vo);
	 	     }
	 	   return list1;
		}
	
		 catch (Exception e) {
			  System.out.print(e);
			  return null;
		     }
	}
	
	public ArrayList<AdminInfo> GetNews() throws SQLException {
		ArrayList<AdminInfo> list1 = new ArrayList<AdminInfo>();
		ResultSet rs = null;
		try {

			Query query = Query.getInstance();
			rs = query.getNews();

			while (rs.next()) {
				AdminInfo vo = new AdminInfo();
				vo.setNewsId(rs.getInt(1));// string
				vo.setNews(rs.getString(2));
				list1.add(vo);
			}

		}

		catch (Exception e) {
			System.out.print(e);
		} finally {
			rs.close();
		}
		return list1;
	}

	public ArrayList<AdminInfo> GetNewsById(int newsId) throws SQLException {
		ArrayList<AdminInfo> list1 = new ArrayList<AdminInfo>();
		ResultSet rs = null;
		try {

			Query query = Query.getInstance();
			rs = query.getNewsById(newsId);

			while (rs.next()) {
				AdminInfo vo = new AdminInfo();
				vo.setNews(rs.getString(1));// string
				System.out.print(rs.getString(1));
				list1.add(vo);
			}

		}

		catch (Exception e) {
			System.out.print(e);
		} finally {
			rs.close();
		}
		return list1;
	}

	public ArrayList<AdminInfo> GetReportedCoontent() throws SQLException {
		ArrayList<AdminInfo> list = new ArrayList<AdminInfo>();
//		ResultSet rs = null;
	//	ResultSet rs1 = null;
		try {
		
			Query query = Query.getInstance();
			ResultSet rs = query.getReportedAns();
			while (rs.next()) {
				
			    int ansId=rs.getInt(1);
				AdminInfo VO = new AdminInfo();
				VO.setAns_id(rs.getInt(1));
				VO.setReported_ans(rs.getString(2));
				Query query1 = Query.getInstance();
				ResultSet rs1=query1.getReportedQue(ansId);
				 while(rs1.next()){
				 VO.setQue(rs1.getString(1));
				 }
				list.add(VO);
			}

		}

		catch (Exception e) {
			System.out.print(e);
		} /*finally {
			rs.close();
			rs1.close();
		}*/
		return list;
	}
}