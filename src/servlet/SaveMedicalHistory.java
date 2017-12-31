package servlet;

import java.io.IOException;
import javaBean.MedicalHistoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveMedicalHistory")
public class SaveMedicalHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicalHistoryBean bean=new MedicalHistoryBean();
		bean.setDescription(request.getParameter("file_desc"));
		bean.setDateByPatient(request.getParameter("date"));
		getServletConfig().getServletContext().setAttribute("medical", bean);
		response.sendRedirect("jsp/MedicalFile.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
