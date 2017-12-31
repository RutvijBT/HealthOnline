package SimpleTag;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import DAO.Query;

public class Answer extends SimpleTagSupport {
	
	private int question;
	public void setQuestion(int question) {
		this.question = question;
	}
	public void doTag() throws JspException, IOException { 
		Query obj=Query.getInstance();
		try {
			ResultSet rs=obj.getAnswer(question);
			while(rs.next()) {
				getJspContext().setAttribute("answer", rs.getString(1));
				getJspContext().setAttribute("date", rs.getString(2));
				getJspContext().setAttribute("doctor", rs.getString(3));
				getJspBody().invoke(null);
			}
		}
		catch (Exception e) {
			throw new SkipPageException("There are some error <br />So, some data skipped");
		}	
	}
	
	/*public static void main(String a[]){
		
		System.out.print("chandna");
	}*/
}
