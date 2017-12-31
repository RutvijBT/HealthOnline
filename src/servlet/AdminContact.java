package servlet;


import java.io.IOException;
import java.util.Properties;

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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AdminContact")
public class AdminContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminContact() {
        super();
        // TODO Auto-generated constructor stub
    }
    
        protected void processRequest(HttpServletRequest request, 
                HttpServletResponse response)
    throws IOException, ServletException {

    //final String err = "/error.jsp";
    //final String succ = "/success.jsp";
    String email=request.getParameter("name");
    System.out.println(email);
    String to = email;

    //String to = "rutvij1027@gmail.com";
    String subject = request.getParameter("subject");
    String message = request.getParameter("message");
    String login = "manishapln92@gmail.com";
    String password ="manisha1992";
    /*System.out.println(subject);
    System.out.println(message);
    System.out.println(login);
    System.out.println(password);*/

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
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
    /*MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

    String f = request.getParameter("file");//change accordingly  
    String filename="C:\\cjava\\"+f;
    System.out.print(filename);
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  

    msg.setContent(multipart );*/



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
    /*RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
    dispatcher.forward(request, response);*/
    System.out.println("done");
    response.sendRedirect("jsp/AdminContact.jsp");
    }

    public class SMTPAuthenticator extends Authenticator {

    private PasswordAuthentication authentication;

    public SMTPAuthenticator(String login, String password) {
    authentication = new PasswordAuthentication(login, password);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
    return authentication;
    }
    }

    protected void doGet(HttpServletRequest request, 
       HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
    }
    

}
