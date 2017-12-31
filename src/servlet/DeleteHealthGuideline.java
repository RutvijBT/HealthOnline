package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Query;

@WebServlet("/DeleteHealthGuideline")
public class DeleteHealthGuideline extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteHealthGuideline() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		try{
			Query query=Query.getInstance();
			query.deleteHealthGuideline(id);
			request.getRequestDispatcher("AHealthGuideline").forward(request, response);
				
		}catch(Exception e){
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
