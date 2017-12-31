<%@page import="javaBean.Register"%>
<%@page import="DAO.Query"%>
<%@ page
	import="java.io.*,java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat"%>
<html>
<%
int val=0;
String saveFile="";
String contentType = request.getContentType();
if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
DataInputStream in = new DataInputStream(request.getInputStream());
int formDataLength = request.getContentLength();
byte dataBytes[] = new byte[formDataLength];
int byteRead = 0;
int totalBytesRead = 0;
while (totalBytesRead < formDataLength) {
	byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
	totalBytesRead += byteRead;
}
String file = new String(dataBytes);
saveFile = file.substring(file.indexOf("filename=\"") + 10);
//System.out.println("saveFile=" + saveFile);
saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
//System.out.println("saveFile" + saveFile);
saveFile = file.substring(file.indexOf("filename=\"") + 10);
saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
int lastIndex = contentType.lastIndexOf("=");
String boundary = contentType.substring(lastIndex + 1,contentType.length());
int pos;
pos = file.indexOf("filename=\"");
pos = file.indexOf("\n", pos) + 1;
pos = file.indexOf("\n", pos) + 1;
pos = file.indexOf("\n", pos) + 1;
int boundaryLocation = file.indexOf(boundary, pos) - 4;
int startPos = ((file.substring(0, pos)).getBytes()).length;
int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
String myFile=saveFile;
saveFile="C:/cjava/"+saveFile;
File ff = new File(saveFile);
FileOutputStream fileOut = new FileOutputStream(ff);
fileOut.write(dataBytes, startPos, (endPos - startPos));
fileOut.flush();
fileOut.close();
Query query=Query.getInstance();
//int userId=Integer.parseInt(request.getSession().getAttribute("user").toString());
Register ob=(Register)getServletContext().getAttribute("doctor");
ob.setCertificateFile(myFile);
//System.out.print(myFile);
int i=query.registerUser(ob,2);
query.regiserDoctor(i, ob);
request.getSession().setAttribute("user_id", i);
response.sendRedirect("pay.jsp");
//out.print("<script>alert('Registration successfully, You will get confirmation mail from admin shortly');</script>");
//out.print("<script>window.location.href='../HomePage.jsp'</script>");
}
%>
</html>