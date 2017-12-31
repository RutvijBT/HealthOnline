package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Properties;

import javaBean.Register;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.EmailServlet.SMTPAuthenticator;
import DAO.Query;

@WebServlet("/mail.me")
public class SendPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}
protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
throws IOException, ServletException {
	Register bean=new Register();
	PrintWriter out=response.getWriter();
	bean.setEmail(request.getParameter("email"));
	bean.setMobile(request.getParameter("mobile"));
	try{
		Query query=Query.getInstance();
		ResultSet rs=query.getPassword(bean);
		if(rs.next()){
			String password="";
			//System.out.println("arg0");
			
			bean.setName(rs.getString(1));
				bean.setPassword(rs.getString(2));
				//System.out.println(rs.getString(1));
			
		}
		else{
			out.print("<script>alert('Invalid Email and mobile Combination');</script>");
			out.print("<script>window.location.href='myPassword.jsp'</script>");
			
		}
		
	}catch(Exception e){
		
		
	}
String to =bean.getEmail();
String subject ="Yuor Password For HealthOnline";
String message ="Dear "+bean.getName()+" \n Please note your password for HealthOnline System, and do not tell to any other person kepp it secret\n"
		+ "Password : "+bean.getPassword()+ "\n\n\nThanks\n \nAdmin Of HealthOnline";
String login = "manishapln92@gmail.com";
String password = "manisha1992";

try {
Properties props = new Properties();
props.setProperty("mail.smtp.host", "smtp.gmail.com");
props.setProperty("mail.smtp.port", "587");
props.setProperty("mail.smtp.auth", "true");
props.setProperty("mail.smtp.starttls.enable", "true");

Authenticator auth = new SMTPAuthenticator(login, password);

Session session = Session.getInstance(props,auth);

MimeMessage msg = new MimeMessage(session);
msg.setText(message);
msg.setSubject(subject);
msg.setFrom(new InternetAddress(login));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


BodyPart messageBodyPart1 = new MimeBodyPart();  
messageBodyPart1.setText("This is message body");  


Transport.send(msg);

} catch (AuthenticationFailedException ex) {
request.setAttribute("ErrorMessage", "Authentication failed");
System.out.println(ex);
//RequestDispatcher dispatcher = request.getRequestDispatcher(err);
//dispatcher.forward(request, response);

} catch (AddressException ex) {
request.setAttribute("ErrorMessage", "Wrong email address");
System.out.println(ex);


} catch (MessagingException ex) {
request.setAttribute("ErrorMessage", ex.getMessage());
System.out.println(ex);
}
System.out.println("done");
response.sendRedirect("/HealthOnlineProject/HomePage.jsp");
}

private class SMTPAuthenticator extends Authenticator {

private PasswordAuthentication authentication;

public SMTPAuthenticator(String login, String password) {
authentication = new PasswordAuthentication(login, password);
}

protected PasswordAuthentication getPasswordAuthentication() {
return authentication;
}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
