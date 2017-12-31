package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javaBean.PrescriptionBean;
import javaBean.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import userdata.User;

import DAO.Query;



@WebServlet("/DoctorPrescription")
public class DoctorPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user=new User();
		ArrayList<Register> list;
		try {
			list = user.getPatientname();
			request.setAttribute("p", list);
			  RequestDispatcher view = request.getRequestDispatcher("jsp/DoctorPrescription.jsp");
		        //request.setAttribute("users", dao.getAllUsers());
		      view.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Query query=Query.getInstance();
		PrescriptionBean p=new PrescriptionBean();
		int patientid=Integer.parseInt(request.getParameter("pname"));
		p.setDiagnosis(request.getParameter("diagnosis"));
		p.setSympton(request.getParameter("symptom"));
		p.setComment(request.getParameter("comment"));
		 Date date = new Date();
         System.out.println("rrrrrrrrrrr"+ date);
         p.setDat(date);
         p.setPatient(patientid);
        
 		 System.out.println(p.getPatient());   
 		 HttpSession s=request.getSession();
 			
 			Integer id=(Integer)s.getAttribute("user_id");
 			
 			System.out.println(id);
 			p.setDoctor(id);
 			

 			
 		
         int pid=query.addPrescription(p);
         String a ;
	for(int i=1;i<8;i++){
		
		a = request.getParameter("medicine"+i);
		if((a) == null || (a).equals("")){
			    //break;
		}
		else
		{

			System.out.println("test ::: " + request.getParameter("medicine"+i));
			
			System.out.println("a " + a);
			
			
			PrescriptionBean p1=new PrescriptionBean();
			p1.setId(pid);
			p1.setMedicine(request.getParameter("medicine"+i));
			p1.setDosage(request.getParameter("dosage"+i));
			query.addMedicine(p1);
    
		}
	}
          
		
		
		
		
          //  query.addPrescription(p);
     
      doGet(request, response);
		
	}

}
