<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>

<script>
var request;
function sendInfo()
{
var v=document.vinform.date.value;
var url="/HealthOnlineProject/jsp/DateNoti.jsp?val="+v;
//document.vinform.category.nll=disabled;
if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getInfo;
request.open("POST",url,true);
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

<c:choose>
	<%-- <c:when test="${sessionScope.role==1 }">
		<jsp:include page="AdminHeader.jsp"></jsp:include> 
	</c:when> --%>
	<c:when test="${sessionScope.role==1 }">
		<jsp:include page="AdminHeader.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorHeader.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientHeader.jsp"></jsp:include> 
	</c:when>
</c:choose>
	<div class="content">
    <div class="content_resize">
    <c:choose>
	 <c:when test="${sessionScope.role==1 }">
		<div class="adminMainbar">
	</c:when>
	<c:otherwise>
	<div class="mainbar">
	</c:otherwise>
	</c:choose>
      
       <div class="article">
          <!-- <h2>NotiFication</h2> -->
          <div class="clr"></div>
          <div class="clr"></div>
         <div class="post_content">
        		<br />
        		<h2>All NotiFication</h2>
        		<br />
        			<c:forEach var="n" items="${un}">
								<img src="/HealthOnlineProject/images/finger_arrow.jpg"/> &nbsp;&nbsp;&nbsp; <c:out value="${n.notification }"></c:out>
							<br/></c:forEach>
							<br /><br />
							<h2>NotiFication of Date</h2><br />
        		<form name="vinform">
        			<div style="color: rgb(36,151,200); font-size: medium;">Search by date :&nbsp;&nbsp;
        			<input type="date" name="date"/>&nbsp;&nbsp;&nbsp; 
        			<input type="button" value="search" class="button" onclick="sendInfo()"/><br /><br />
        		</form>
        	</div>	
        		<jsp:useBean id="User" class="userdata.User"></jsp:useBean>
        		<%-- <c:set value="${User.setNotificationAsSeen(sessionScope.user_id) }" var="nothing"></c:set> --%>
        		<ul id="notification">
        		<span id="amit"> </span>
        			
        		</ul>        	
		 </div>
          <div class="clr"></div>
        </div>
      </div>
<c:choose>
	 <c:when test="${sessionScope.role==1 }">
		</div>
	</c:when> 
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorSidebar.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientSidebar.jsp"></jsp:include> 
	</c:when>
	
</c:choose>
<jsp:include page="Footer.jsp"></jsp:include>