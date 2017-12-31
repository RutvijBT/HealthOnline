package SimpleTag;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import DAO.Query;

public class PatientQuestion extends SimpleTagSupport {	
	
	private int user;
	public void setUser(int user) {
		this.user = user;
	}
	public void doTag() throws JspException, IOException { 
		Query obj=Query.getInstance();
		try {
			ResultSet rs=obj.getPatientQuestion(user);
			while(rs.next()) {
				getJspContext().setAttribute("content_id", rs.getInt(1));
				getJspContext().setAttribute("qusetion", rs.getString(2));
				getJspBody().invoke(null);
			}
		}
		catch (Exception e) {
			throw new SkipPageException("There are some error <br />So, some data skipped");
		}	
	}
}
