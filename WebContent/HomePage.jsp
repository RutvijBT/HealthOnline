<%@page import="javaBean.AdminInfo"%>
<%@page import="userdata.User"%>
<%@page import="javaBean.HealthGuidelineBean"%>
<%@page import="java.util.List;"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.getSession().removeAttribute("user_id");
request.getSession().removeAttribute("name");
request.getSession().removeAttribute("role");

%>
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
<script type="text/javascript" src="/HealthOnlineProject/js/ScriptFunction.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/script.js"></script>
<script type="text/javascript" src="/HealthOnlineProject/js/coin-slider.min.js"></script>
</head>
<body>

	<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="HomePage.jsp"><i>HEALTH ONLINE</i><small> Be careful about your health</small></a></h1>
      </div>  
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> 
        <!-- <a href="#"><img src="/HealthOnlineProject/images/images40.jpg"  width="850px" height="150" alt="" /> </a> -->
         <a href="#"><img src="/HealthOnlineProject/images/slide2.jpg" width="868" height="150" alt="" /> </a> 
         <a href="#"><img src="/HealthOnlineProject/images/slide3.jpg" width="874" height="150" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="HomePage.jsp"><span>Home</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/About.jsp"><span>About Us</span></a></li>
          <li><a href="/HealthOnlineProject/jsp/Contact.jsp"><span>Contact Us</span></a></li>
          <li><a href="/HealthOnlineProject/RegPlan"><span>Registration</span></a></li>
          <li><a href="jsp/Work.jsp"><span>How It Works</span></a></li>
          <!--li><a href="contact.html"><span></span></a></li-->
        </ul>
      </div>
      <div class="clr"></div>
    </div>
    
  </div>
  <div class="content">
  
    <div class="content_resize">
    <form action="/HealthOnlineProject/login.me" method="post" name="myForm" onsubmit="return validEmail();">
      	<center><fieldset style="border-color: rgb(180,180,180); border-style:double; "><legend id="login"><b>Login:</b></legend>
			<table align="center" class="plain_text" width="100%"><tr><td>Username:</td>
			<td><input type="text" name="username" size="20" class="txt" id="emailtxt" required="required"></td>
			<td>Password:</td>
			<td><input type="password" name="password" size="20" class="txt" required="required"></td><td>
			<input type="submit" name="submit" value="Login"  class="button" ></td><td>
			<input type="reset" name="reset" value="Reset" class="button"></td>
			</tr>
			</table>
			<% 
							if(request.getAttribute("message2")!=null){		
						%>
							<span style="color:red;font-weight: bold;"><%=request.getAttribute("message2") %></span>
						<%} %>
					&nbsp;&nbsp;&nbsp;
			<a href="/HealthOnlineProject/jsp/ForgotPassword.jsp">forgot password?</a>
		</fieldset></center>
	</form><br>
      <div class="mainbar">
        <div class="article">
          <h2><span>Excellent Solution For</span> Health Online</h2>
          
          <div class="clr"></div>
          <div class="img"><img src="images/img1.jpg" width="650" height="196" alt="" class="fl" /></div>
          <div class="post_content">
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. <a href="#">Suspendisse bibendum. Cras id urna.</a> Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum, dui pede condimentum odio, ac blandit ante orci ut diam. Cras fringilla magna. Phasellus suscipit, leo a pharetra condimentum, lorem tellus eleifend magna, eget fringilla velit magna id neque. Curabitur vel urna. In tristique orci porttitor ipsum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo.</p>
            <p><strong>Aenean consequat porttitor adipiscing. Nam pellentesque justo ut tortor congue lobortis. Donec venenatis sagittis fringilla.</strong> Etiam nec libero magna, et dictum velit. Proin mauris mauris, mattis eu elementum eget, commodo in nulla. </p>
            
          </div>
          <div class="clr"></div>
        </div>
        <%User u=new User();
        List<HealthGuidelineBean> l;
        l=u.getLatestGuideline();
        request.setAttribute("l",l);
        List<AdminInfo> n;
        n=u.getNews();
        request.setAttribute("n",n);
        %>
        <div class="article">
        <!--   <h2><span>Health Guideline</span></h2>
     <br/> -->
    <!--   <div style="color: rgb(36,120,180); font-size: large;font-weight: bold;">
         
         
        <form name="health">
        
         Search For Health Guideline
          <input  maxlength="80" type="text" name="guideline"/>
          <input type="button" value="search" class="button" onclick="sendWord()"/> 
          <input src="/HealthOnlineProject/images/search.gif"  type="image" />
        </form></div><br/>
	          <span id="ami"> </span>
      <br/><br/> -->
          <c:forEach var="a" items="${l }">
          
          <h2>Latest Health Guideline</h2>
          <p class="infopost">Posted on <span class="date"><c:out value="${a.date}"/> </span> by <a href="/HealthOnlineProject/DoctorList" ><span class="date">Dr. <c:out value="${a.doctor}"/></span></a> <!--a href="#" class="com"><span>7</span></a--></p>
          <div class="clr"></div>
          
          <div class="post_content">
      
            <c:out value="${a.guideline}"/>
            </c:forEach>
            <p class="spec"><a href="/HealthOnlineProject/HealthGuideline" class="rm">Read more &raquo;</a></p>
          </div>
          <div class="clr"></div>
        </div>
        
      </div>
     <br/>
<div class="sidebar">
        <div class="gadget">
          <!-- h2 class="star"><span class="side_header">Sidebar Menu</span></h2>
          <div class="clr"></div-->
          <ul class="sb_menu">
          <div id="my_sidebar">
            <li><a href="HomePage.jsp">Home</a></li>
            <li><a href="RegPlan">Registration</a></li>
            <li><a href="DoctorList">Available Doctors</a></li>
            <li><a href="HealthGuideline">Health Guideline</a></li>
            </div>
          </ul>
        </div>
       
		<div class="gadget">
          <h2 class="star"><span class="side_header">NEWS</span></h2>
          <div class="clr"></div>
          <ul  class="sb_menu" >
            <marquee onmouseover="stop()" onmouseout="start()" direction="up">
            <c:forEach var="n" items="${ n }">
           <li><img src="/HealthOnlineProject/images/finger_arrow.jpg"/> &nbsp;&nbsp;&nbsp;<c:out value="${n.news }"></c:out> </li>
           </c:forEach>
            </marquee>
          </ul>
        </div>
     
         <div class="gadget">
          <h2 class="star"><span  class="side_header">Find Hospital</span></h2>
          <div class="clr"></div>
          <!-- ul class="sb_menu">
            <li>Rutvij</li>
            <li>Manisha</li>
            <li>Chandan</li>
            <li class="spec"><a href="#" class="rm" >See all &raquo;</a></li>
          </ul-->
          <a href="http://maps.google.co.in/maps?bav=on.2,or.r_qf.&bvm=bv.60444564,d.bmk,pv.xjs.s.en_US.j4JTBSG9WkM.O&biw=1366&bih=610&dpr=1&um=1&ie=UTF-8&q=find+nearest+hospital+google+maps&fb=1&gl=in&hq=hospital&hnear=0x395e848aba5bd449:0x4fcedd11614f6516,Ahmedabad,+Gujarat&sa=X&ei=eIbqUvLoEcjJrAewt4DgAQ&ved=0CJUBELYD" target="_blank">
          <img src="images/map.jpg" width="220px"></img>
          </a>
        </div>
        <script>
var request;
function bmiInfo()
{

var h=document.bmiform.ht.value;
var w=document.bmiform.wt.value;
var bmi;

if(h!=null && w!=null && h!="" && w!=""){

	h/=100;
	 bmi=w/(h*h);
	 
	 }
else{
bmi=0;
}

var url="/HealthOnlineProject/jsp/BMI.jsp?val="+bmi;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getInfo;
request.open("GET",url,true);
request.send();
}
catch(e)
{
alert("Unable to connect to server");
}
}

function getInfo(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('amit').innerHTML=val;
}
}

</script>
        <div class="gadget">
          <h2 class="star" ><span  class="side_header">KNow your bmi</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
          
	          <form name=bmiform>  
	            <center> <table>
	             <tr>
	             	<td>Height:&nbsp;&nbsp;&nbsp; 
	             	</td><td><input type="text" name="ht"size="10" id="num" required="required"   onkeypress="return event.charCode >= 48 && event.charCode <= 57"/>cm</td>
	             </tr><tr>
	             <td>Weight:&nbsp;&nbsp;&nbsp;</td><td><input type="text"  id="num" name="wt" size="10"  required="required" onkeypress="return event.charCode >= 48 && event.charCode <= 57"/>kg</td>
	             </tr>
	             
	             	
	            </table></center><br/><center><td colspan="2" align="center">
	            <input type="button" value="search" class="button" onclick="bmiInfo()"/></center>
	          </form> <br/>
	          <span id="amit"> </span>
	     
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <!-- %@include file="Footer.jsp" %-->
 <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Image</span> Gallery</h2>
        <a href="#"><img src="/HealthOnlineProject/images/25.jpg" width="79" height="81" alt="" class="gal" /></a> 
        <!-- a href="#"><img src="images/images3.jpg" width="80" height="83" alt="" class="gal" /></a> 
        <a href="#"><img src="images/images2.jpg" width="77" height="82" alt="" class="gal" /></a-->
         <a href="#"><img src="/HealthOnlineProject/images/images55.jpg" width="80" height="86" alt="" class="gal" /></a> 
         <a href="#"><img src="/HealthOnlineProject/images/images49.jpg" width="79" height="86" alt="" class="gal" /></a> 
         <a href="#"><img src="/HealthOnlineProject/images/images28.jpg" width="77" height="87" alt="" class="gal" /></a> 
         </div>
      <div class="col c2">
        <h2><span>Services</span> Overview</h2>
        <p>Curabitur sed urna id nunc pulvinar semper. Nunc sit amet tortor sit amet lacus sagittis posuere cursus vitae nunc.Etiam venenatis, turpis at eleifend porta, nisl nulla bibendum justo.</p>
        <ul class="fbg_ul">
          <li><a href="#">Lorem ipsum dolor labore et dolore.</a></li>
          <li><a href="#">Excepteur officia deserunt.</a></li>
          <li><a href="#">Integer tellus ipsum tempor sed.</a></li>
        </ul>
      </div>
      <div class="col c3">
        <h2><span>Contact</span> Us</h2>
        <p>Nullam quam lorem, tristique non vestibulum nec, consectetur in risus. Aliquam a quam vel leo gravida gravida eu porttitor dui.</p>
        <p class="contact_info"> <span>Address:</span> 1458 TemplateAccess, USA<br />
          <span>Telephone:</span> +123-1234-5678<br />
          <span>FAX:</span> +458-4578<br />
          <span>Others:</span> +301 - 0125 - 01258<br />
          <span>E-mail:</span> <a href="#">mail@healthonline.com</a> </p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; Copyright <a href="#">MyWebSite</a>.</p>
      <p class="rf">Design by Dream <a href="http://www.dreamtemplate.com/">Web Templates</a></p>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
<!--div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div--></body>
</html>

<!--div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div--></body>

