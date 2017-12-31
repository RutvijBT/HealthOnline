package userdata;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import DAO.Query;

public class Category  {
	
	public HashMap<Integer, String> getCategory() throws IOException { 
		Query obj=Query.getInstance();
		HashMap<Integer, String> hash=new HashMap<Integer, String>();
		try {
			ResultSet rs=obj.getCategoryList();
			while(rs.next()) {
				hash.put(rs.getInt(1), rs.getString(2));
			//	getJspContext().setAttribute("category_id", rs.getInt(1));
			//	getJspContext().setAttribute("category", rs.getString(2));
			//	getJspBody().invoke(null);
			}
		}
		catch (Exception e) {
			
		}	
		return hash;
	}
	
	/*public void main(String ags[]) throws IOException{
		Category ob=new Category();
		HashMap<Integer, String> hash=ob.getCategory();
		System.out.print(hash.get(1));
	}*/
}
