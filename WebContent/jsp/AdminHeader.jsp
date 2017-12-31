<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Health Online</title>
<meta http-equiv="Content-Type" content="0;text/html; charset=utf-8" />
<link href="/HealthOnlineProject/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/HealthOnlineProject/css/coin-slider.css" />
<link rel="stylesheet" type="text/css" href="/HealthOnlineProject/css/my.css" />
<script type="text/javascript" src="/HealthOnlineProject/js/cufon-yui.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/cufon-titillium-600.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/my.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/script.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/myscript.js"></script>

<script type="text/javascript" src="/HealthOnlineProject/js/coin-slider.min.js"></script>

<script>
	function go(){
		window.location.replace('/HealthOnlineProject/Logout.me','window','toolbar=1,location=1,derictories=1,status=1,menubar=1,scrollbars=1,resizable=1,');
		self.close();
	}
	window.history.forward();
	function noBack(){
		window.history.forward();
	}
</script>
</head>
<body onload="noBack()" nopageshow="if(event.persisted) noBack();">

<%
	if(request.getSession().getAttribute("name")==null  || Integer.parseInt(request.getSession().getAttribute("role").toString())!=1){
		//response.sendRedirect("//jsp/DoctorHome.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
		rd.forward(request, response);
	} %>
	<div class="main">
  <div class="header" onmousemove="sendInfo()">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="/HealthOnlineProject/HomePage.jsp"><i>HEALTH ONLINE</i><small> Be careful about your health</small></a></h1>
      </div>
      <div class="searchform" id="logout">
        <br /><br />
        <span style="font-size:16px;padding-right:30px"><input type="text" id="headerId" value="<%=session.getAttribute("user_id") %>" hidden /><%=session.getAttribute("name") %></span>
        <a href="javascript:go()" style="padding-right:40px">
        	<button>Logout</button>
        </a>
        <br /> <br />
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="/HealthOnlineProject/images/slide1.jpg" width="850px" height="150" alt="" /> </a> <a href="#"><img src="/HealthOnlineProject/images/slide2.jpg" width="868" height="150" alt="" /> </a> <a href="#"><img src="/HealthOnlineProject/images/slide3.jpg" width="874" height="150" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
       <jsp:useBean id="User" class="userdata.User"></jsp:useBean>
       <%
      

       int userId=(Integer)request.getSession().getAttribute("user_id");
		  User user=new User();
		  int n=user.NumberOfUnreadNotification(userId);
			request.setAttribute("n", n);
			
       %>
		<c:set var="number" value="${n }"></c:set>
		
       <div class="menu_nav">
        <ul  >
          <li  class="active"><a href="/HealthOnlineProject/jsp/AdminHome.jsp"><span>Home</span></a></li>
          <li><a href="/HealthOnlineProject/UserList"><span>User List</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/Plan.jsp"><span>Reg Plan</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/AdminQuestionaries.jsp"><span>Questionaries</span></a></li>
           <c:choose>
          	<c:when test="${number==0 }">
          		<li><a href="/HealthOnlineProject/Notification"><span>Notification</span></a></li>
         	</c:when>
          	<c:otherwise>
         		 <li><a href="/HealthOnlineProject/Notification">Notification <span style="color:red;font-size:30px">${number }</span></a></li>
         	</c:otherwise>
          </c:choose>
          <li><a href="/HealthOnlineProject/jsp/TransactionInfo.jsp"><span>Transaction Details</span></a></li> 
          <li><a href="/HealthOnlineProject/jsp/AdminContact.jsp"><span>Mail</span></a></li> 
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>