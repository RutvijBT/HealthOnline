<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Health Online</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/HealthOnlineProject/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/HealthOnlineProject/css/coin-slider.css" />
<link rel="stylesheet" type="text/css" href="/HealthOnlineProject/css/my.css" />
<script type="text/javascript" src="/HealthOnlineProject/js/cufon-yui.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/cufon-titillium-600.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/my.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/script.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/coin-slider.min.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/ScriptFunction.js"></script>
<script type="text/javascript"></script>
</head>
<body>
	<div class="main">
	 
  <div class="header" onmousemove="sendDoctor()">
    <div class="header_resize">
    
      <div class="logo">
      
        <h1><a href="/HealthOnlineProject/HomePage.jsp"><i>HEALTH ONLINE  </i> <small> Be careful about your health</small></a></h1>
     
     
      </div>
       <div class="searchform1">
					<form action="/HealthOnlineProject/login.me" method="post">
						Email :<input type="text" name="username" size="20" class="txt" required="required" id="gemail" />
						Password :<input type="password" name="password" size="20" class="txt" required="required" />
						<input type="submit" value="Login" /><br>
						<% 
							if(request.getAttribute("message2")!=null){		
						%>
							<span style="color:red;font-weight: bold;background-color:#C3C3C3;"><%=request.getAttribute("message2") %></span>
						<%} %>
						<a href="/HealthOnlineProject/jsp/ForgotPassword.jsp"><span style="color: white;font-weight: bold;"> Forgot password?</span></a>
					</form>
					
				</div>
       <!-- <div>
        <br />
        <fieldset style="border-width:medium;">
        	<legend style="color: white; font-weight: bold; font-size: large;">Login</legend>
        
           <form action="/HealthOnlineProject/login.me" method="post" name="myForm" onsubmit="return validEmail();">
        <table align="center" ><tr><td style="color: white;font-weight: bold;font-size: small;"> Username:</td>
			<td><input type="text" name="username" size="15" class="txt" id="emailtxt" required="required"></td>
			<td style="color: white;font-weight: bold;font-size: small;">Password:</td>
			<td><input type="password" name="password" size="15" class="txt" required="required"></td><td>
			<input type="submit" name="submit" value="Login"  class="button1" ></td><td>
			<input type="reset" name="reset" value="Reset" class="button1"></td>
			<td style="color: white;"><a href="ForgotPassword.jsp" style="color: white;font-weight: bold;font-size: small;">forgot password?</a></td></tr>
			</table>
			
            </form></fieldset>
        </div> -->
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="/HealthOnlineProject/images/slide1.jpg" width="850px" height="150" alt="" /> </a> <a href="#"><img src="/HealthOnlineProject/images/slide2.jpg" width="868" height="150" alt="" /> </a> <a href="#"><img src="/HealthOnlineProject/images/slide3.jpg" width="874" height="150" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
        <div class="menu_nav">
        <ul>
          <li class="active"><a href="/HealthOnlineProject/HomePage.jsp"><span>Home</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/About.jsp"><span>About Us</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/Contact.jsp"><span>Contact Us</span></a></li>
          <li><a href="/HealthOnlineProject/RegPlan"><span>Registration</span></a></li>
           <li><a href="/HealthOnlineProject/jsp/Work.jsp"><span>How It Works</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>