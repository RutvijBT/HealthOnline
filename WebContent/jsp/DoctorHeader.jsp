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
<!-- 
<script type="text/javascript" src="${pageContext.request.contextPath}/org/cometd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/org/cometd/AckExtension.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/org/cometd/ReloadExtension.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.8.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.cometd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.cometd-reload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/chat.window.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/comet.chat.js"></script>
<script type="text/javascript">
    var chatWindowArray = [];
    
    var config = {
        contextPath: '${pageContext.request.contextPath}'
    };
	
	function getChatWindowByUserPair(loginUserName, peerUserName) {
		
		var chatWindow;
		
		for(var i = 0; i < chatWindowArray.length; i++) {
			var windowInfo = chatWindowArray[i];
			if (windowInfo.loginUserName == loginUserName && windowInfo.peerUserName == peerUserName) {
				chatWindow =  windowInfo.windowObj;
			}
		}
		return chatWindow;
	}
	
	function createWindow(loginUserName, peerUserName) {
		
		var chatWindow = getChatWindowByUserPair(loginUserName, peerUserName);
		
		if (chatWindow == null) { //Not chat window created before for this user pair.
			chatWindow = new ChatWindow(); //Create new chat window.
			chatWindow.initWindow({
				loginUserName:loginUserName, 
				peerUserName:peerUserName,
				windowArray:chatWindowArray});
			
			//collect all chat windows opended so far.
			var chatWindowInfo = { peerUserName:peerUserName, 
					               loginUserName:loginUserName,
					               windowObj:chatWindow 
					             };
			
			chatWindowArray.push(chatWindowInfo);
    	}
		chatWindow.show();
		return chatWindow;
	}

	function join(userName){
		$.cometChat.join(userName);
	}
</script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/comet.chat.css"/>
<script type="text/javascript">
 -->
//	var userName = '<%=request.getParameter("username")%>';
	<%
		String userName =request.getSession().getAttribute("name").toString();
		userName=userName.replace(' ', '_');
		userName=userName.replace('.', '_');
	%>
	var userName='<%=userName%>';
	$(document).ready(function(){ 
		$.cometChat.onLoad({memberListContainerID:'members'});
		join(userName);
	});
</script>
</head>
<body onload="noBack()" nopageshow="if(event.persisted) noBack();">

<%
	if(request.getSession().getAttribute("name")==null  || Integer.parseInt(request.getSession().getAttribute("role").toString())!=2){
		//response.sendRedirect("//jsp/DoctorHome.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
		rd.forward(request, response);
	} %>
	<div class="main">
  <div class="header" onmousemove="sendDoctor()">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="/HealthOnlineProject/HomePage.jsp"><i>HEALTH ONLINE</i><small> Be careful about your health</small></a></h1>
      </div>
      <div class="searchform" id="logout">
        <br /><br />
        <span style="font-size:16px;padding-right:30px"><input type="text" id="headerId" value="<%=session.getAttribute("user_id") %>" hidden />Dr. <%=session.getAttribute("name") %></span>
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
      	   <div class="menu_nav">
       <jsp:useBean id="User" class="userdata.User"></jsp:useBean>
		<%-- <c:set var="number" value="${User.NumberOfUnreadNotification(sessionScope.user_id) }"></c:set> --%>
		<%
      

       int userId=(Integer)request.getSession().getAttribute("user_id");
		  User user=new User();
		  int n=user.NumberOfUnreadNotification(userId);
			request.setAttribute("n", n);
			
       %>
		<c:set var="number" value="${n }"></c:set>
       <ul>
          <li class="active"><a href="/HealthOnlineProject/DoctorHome"><span>Home</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/About.jsp"><span>About Us</span></a></li>
          <li id="nav"><a href="/HealthOnlineProject/jsp/Contact.jsp"><span>Contact us</span></a></li>
          <c:choose>
          	<c:when test="${number==0 }">
          		<!-- <li><a href="Notification.jsp"><span>Notification</span></a></li> -->
          		<li><a href="/HealthOnlineProject/Notification">Notification</a></li>
         	
          	</c:when>
          	<c:otherwise>
         		 <li><a href="/HealthOnlineProject/Notification">Notification <span style="color:red;font-size:30px">${number }</span></a></li>
         	</c:otherwise>
          </c:choose>
          <li><a href="/HealthOnlineProject/jsp/chat.jsp"><span>Message</span></a></li> </li>
           <!-- <li><a href="Message.jsp"><span>Message</span></a></li>
           <li><a href="chat.jsp"><span>Chat Room</span></a></li> -->
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>