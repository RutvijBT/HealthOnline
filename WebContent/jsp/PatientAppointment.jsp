<%@taglib uri="HealthOnlineTagLibrary" prefix="HealthOnline" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
 <script>
var request;
function days()
{
var v=document.day.doctor.value;
if(v!=null && v!=""){
	var url="/HealthOnlineProject/jsp/AvailableDays.jsp?v="+v;
	 }
else{
	history.back();
}

//var url="/HealthOnlineProject/jsp/AvailableDays.jsp?v="+v;
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
<jsp:include page="PatientHeader.jsp"></jsp:include>
  <!--Header End -->
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2>Make Appointment</h2>
          <div class="clr"></div>
          
		  <div class="post_content">
           <br />
			<%-- <jsp:useBean id="user" class="userdata.User"></jsp:useBean> --%>
			<form action="/HealthOnlineProject/my.appointment" method="post" name="day"><center><table cellpadding="8px">
				<tr>
				
				   <td style="color: rgb(36,131,200); font-weight: bold;">	Doctor:<span style=" font-size:larger; color: red;">*</span></td>
					<td><select name="doctor" required="required" onchange="days()">
					<option></option>
						<c:forEach var="doctor" items="${list}">
						
							<option value="${doctor.id }">${doctor.name }</option>
						</c:forEach>
						
					</select></td><td style="color: rgb(36,131,200); font-weight: bold;">
				Date<span style=" font-size:larger; color: red;">*</span></td><td><input type="date" name="date" placeholder="dd - mm - yyyy" required="required"/></td>
				
				</tr><tr>
				<td colspan="4" style="color: rgb(36,131,200); font-size: 12px;">
						<span id="amit"> </span>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="color: rgb(36,131,200); font-weight: bold;">
						Comment (optional) :<br /><textarea name="comment" cols="50" rows="3" class="txt" ></textarea>
					</td>
				</tr>
				</table></center><center>
				<div style="color: red;" >Fields which have * all are Mandatory.</div></center><br/>
				<center><input type="submit" value="Submit" class="button"/></center>
				</form>
				 <br/>
		</div>
          <div class="clr"></div>
        </div>
      <%--   <jsp:useBean id="appointment" class="userdata.Appointment"></jsp:useBean> --%>
        <div class="article">
          <h2>Pending Appointments</h2>
          <div class="clr"></div>
          <div class="post_content">
			<br />
			<table align="center" width="85%" border="1" class="tablecontent">
				<tr>
					<th>No.</th>
					<th>Doctor</th>
					<th>Date</th>
					<th>Comment</th>
					<th>Action</th>
										
				</tr>
				<c:set var="number">1</c:set>
				<c:forEach var="appo" items="${list1}">
					<tr>
						<td>${number }</td>
						<td>${appo. name }</td>
						<td>${appo.date }</td>
						<td>${appo.comment }</td>
						<td><a href="/HealthOnlineProject/DeleteAppoinment?id=${appo.appointment }">DELETE</a></td>	
					</tr>
				<c:set var="number" value="${number+1 }"></c:set>
				</c:forEach>
			</table>
		   </div>
          <div class="clr"></div></div>
		<div class="article">
          <h2>Your previous appointment</h2>
          <div class="clr"></div>
          <div class="post_content">
			<br />
			<table align="center" width="85%" border="1" class="tablecontent">
				<tr>
					<th>No.</th>
					<th>Doctor</th>
					<th>Date</th>
					<th>Time</th>
										
				</tr>
				<c:set var="number">1</c:set>
				<c:forEach var="appo" items="${list2 }">
					<tr>
						<td>${number }</td>
						<td>${appo. name }</td>
						<td>${appo.date}</td>
						<td>${appo.time }</td>	
					</tr>
					<c:set var="number" value="${number+1 }"></c:set>
				</c:forEach>			
			</table>
		   </div></div>
          <div class="clr"></div>
        </div>
      
<jsp:include page="PatientSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>