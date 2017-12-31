<%@page import="javaBean.Register"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

User user=new User();
int uId=(Integer)session.getAttribute("user_id");
ArrayList<Register> list2;
String date=request.getParameter("val");
System.out.println("ddddddddddddddddddddddd"+date);

	list2=user.getUserNotificationByDate(uId, date);

	request.setAttribute("und", list2);

%>
<c:forEach var="n" items="${und }">
	<img src="/HealthOnlineProject/images/finger_arrow.jpg"/>&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${n.notification }"></c:out>
	<br/>
</c:forEach>