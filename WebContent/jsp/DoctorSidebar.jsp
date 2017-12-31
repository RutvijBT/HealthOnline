  <%@page import="javaBean.AdminInfo"%>
<%@page import="java.util.List"%>
<%@page import="userdata.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/>  
  <script>
var request;
function cancelReg()
{
	
	var reason;
	var url;
	if(confirm("Are you sure to cancel membership?")){
		
		window.location="/HealthOnlineProject/CancelRegn";
	}
	/* if(confirm("Are you sure to cancel membership?")){
		reason=prompt("Enter Reason(Not compulsary):");
		window.location="/HealthOnlineProject/CancelRegn?val="+reason;
		//var url="/HealthOnlineProject/CancelRegn?val="+reason;
	} */
	
	
}
	 </script>
    <div class="sidebar" onmousemove="sendInfo()">
        <div class="gadget">
          <!--h2 class="star" ><span class="side_header">Sidebar Menu</span></h2-->
          <div class="clr"></div>
          <ul class="sb_menu" id="my_sidebar" >
            <li><a href="/HealthOnlineProject/DoctorHome">Home</a></li>
            <li><a href="/HealthOnlineProject/jsp/DoctorProfile.jsp">Profile</a></li>
             <li><a href="/HealthOnlineProject/Appointment">Appointment</a></li>
              <li><a href="/HealthOnlineProject/jsp/DoctorQuestionaries.jsp">Questionaries</a></li>
              <li><a href="/HealthOnlineProject/HealthGuideline">Health Guideline</a></li>
               <li><a href="/HealthOnlineProject/DoctorList">List of Doctors</a></li>
            <li><a href="/HealthOnlineProject/jsp/DoctorRegDetails.jsp">Registration Details</a></li>
           
            <li><a href="/HealthOnlineProject/DoctorPrescription">Patient Prescription</a></li>
            
            <li><a  id="cancel_membership" onclick="cancelReg()" >Cancel Membership</a></li>
            
          </ul>
        </div>
         <div class="clr"></div>
        <%
		User u=new User();
		List<AdminInfo> n;
        n=u.getNews();
        request.setAttribute("n",n);
        %>
        <div class="gadget">
          <h2 class="star"><span class="side_header">News</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <marquee direction="up" onmouseover="stop()" onmouseout="start()"> 
             <c:forEach var="n" items="${ n }">
           <li><img src="/HealthOnlineProject/images/finger_arrow.jpg"/> &nbsp;&nbsp;&nbsp;<c:out value="${n.news }"></c:out> </li>
           </c:forEach> 
            </marquee>
          </ul>
        </div>
        
     
      <div class="clr"></div>
   
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
          <img src="/HealthOnlineProject/images/map.jpg" width="220px"></img>
          </a>
        </div>
  </div>
        
      </div>
      <div class="clr"></div>
    </div>
  </div>