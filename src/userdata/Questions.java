package userdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBean.AnswerBean;
import javaBean.QuestionBean;
import DAO.Query;

public class Questions {
	
	public ArrayList<QuestionBean> getUnansweredPatientQuestion(int patientId) throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getUnansweredPatientQuestion(patientId);
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			ob.setDate(result.getString(3));
			ob.setName(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<QuestionBean> getAllQuestion() throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getAllQuestion();
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			ob.setName(result.getString(3));
			ob.setDate(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<QuestionBean> getAllUnansweredQuestion() throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getAllUnansweredQuestion();
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			ob.setName(result.getString(3));
			ob.setDate(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	
	
	public ArrayList<QuestionBean> getAllAnsweredQuestion() throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getAllAnsweredQuestion();
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			ob.setName(result.getString(3));
			ob.setDate(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	
	public ArrayList<QuestionBean> getPatientAnsweredQuestion(int userId) throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatientQuestion(userId);
		System.out.print("result"+result);
		if(result.next()) result=query.getPatientQuestion(userId);
		else result=query.getLastTenQuestion();
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<QuestionBean> getCategoryQuestion(int categoryId) throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getCategoryQuestion(categoryId);
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<AnswerBean> getAnswer(int questionId) throws SQLException{
		ArrayList<AnswerBean> list=new ArrayList<AnswerBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getAnswer(questionId);
		while(result.next()){
			AnswerBean ob=new AnswerBean();
			ob.setAnswer_id(result.getInt(1));
			ob.setAnswer(result.getString(2));
			ob.setDate(result.getString(3));
			ob.setName(result.getString(4));
			ob.setUser_id(result.getInt(5));
			ob.setLike(result.getInt(6));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<QuestionBean> getUnansweredCategoryQuestion(int categoryId) throws SQLException{
		ArrayList<QuestionBean> list=new ArrayList<QuestionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getUnansweredCategoryQuestion(categoryId);
		while(result.next()){
			QuestionBean ob=new QuestionBean();
			ob.setQuestion_id(result.getInt(1));
			ob.setQuestion(result.getString(2));
			ob.setDate(result.getString(3));
			ob.setName(result.getString(4));
			list.add(ob);
		}
		return list;
	}
	
	public boolean isAnswereLiked(int userId,int contentId) throws SQLException{
		boolean flag=false;
		Query query=Query.getInstance();
		ResultSet result=query.getLikes(userId, contentId);
		while(result.next()) flag=true;
		return flag;
	}
	public boolean isAnswereReported(int userId,int contentId) throws SQLException{
		boolean flag=true;
		Query query=Query.getInstance();
		ResultSet result=query.getReportOfAnswer(userId, contentId);
		while(result.next()) flag=false;
		return flag;
	}
	
	
}
