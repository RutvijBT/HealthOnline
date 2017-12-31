<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javaBean.Register"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div class="content">
    <div class="content_resize">
      <div class="AdminMainbar">
  
   <div class="article">
				<h2 align="center" >
					<span>Send</span> Mail
				</h2>
				<div align="center" >
				<%
				User u=new User();
				ArrayList<Register> list=u.getAllUser();
				request.setAttribute("list",list);
				%>
				<div class="clr"></div>
				<!-- <form action="../mail.me" method="post" enctype="text/plain" id="sendemail"> -->
				<form action="../AdminContact" >
					<table class="tablecontent" width="60%">
					<tr><td><label for="email"  >Your Email-id<span
								style="font-size: larger; color: red;">*</span></label></td>
								
								<td><select name="name" style="border-style:solid; border-color: black;border-width: thin;" >
				
				<c:forEach var="n" items="${list }" >
					<option value="${n.email}"><c:out value="${n.name}"  /> </option>
				</c:forEach>
			</select></td></tr>
								<tr><td><label for="name">Subject <span style="font-size: larger; color: red;" >*</span></label> </td>
								<td width="100px" ><input style="border-color: black;border-style:solid;border-width: thin;" width="100px" id="name"name="subject" class="text" required="required" size="53"/></td></tr>
								</tr><tr><td><label for="message">Your Message</label> </td>
								<td><textarea style="border-color: black;border-style:solid;border-width: thin;" id="message" name="message" rows="5" cols="40"required="required">
								</textarea></td></tr>
						
						<!-- <li><label for="email">Password : <span
								style="font-size: larger; color: red;">*</span></label> <input
							id="email" name="password" type="password" class="text"
							required="required" /></li> -->
					</table>
					<br />
					<div  align="center">
						<input type="submit" class="button" value="Send" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="button" value="Reset" />
					</div>
					<div class="clr"></div>
				</form></div>
				<br /> <br /> <br />
				<div style="color: red;" align="center">Fields which have * all are
					Mandatory.</div>
			</div></div>
   
		      </div>
		 <div class="clr"></div>
		
      </div></div>
<%-- <jsp:include page="AdminSidebar.jsp"></jsp:include> --%>
<jsp:include page="Footer.jsp"></jsp:include>