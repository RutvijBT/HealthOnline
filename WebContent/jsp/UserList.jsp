
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>

 <script>
var request;
function sendInfo()
{
var v=document.vinform.category.value;
var url="UserList?val="+v;

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

	<div class="content">
    <div class="content_resize">
      <div class="AdminMainbar">
      <div class="article">
          <!-- <h2 align="center">List of Patients</h2> -->
          <h2 id="PatientList_header" class="local_header" align="center">List of Patients</h2>
          <div class="clr"></div>
          <div id="PatientList" > 
         <div class="post_content">
        		<br />
        		
        		<!-- <div class="ad_list"> -->
        		<center>
        			<table align="center"  border="1" class="tablelist" width="60%">
        			<tr>
        					
        					<th>Patient Name
        					</th>
        					<th>Category</th>
        				</tr>
        			<c:forEach var="a" items="${s3}">
        				<tr>
        					
        					<td ><a href="/HealthOnlineProject/UserInfo?id=${a.id}" ><c:out value="${a.name}"  /></a><br />
        					</td>
        					<td><a href="/HealthOnlineProject/UserInfo?id=${a.id}" ><c:out value="${a.category}"  /></a><br />
        					</td>
        				</tr>
        				</c:forEach>          				
        			</table></center>
        			
        		<!-- </div> -->
        		
        		</div></div>
        		</div>
   
		      
       <br>
            <div class="article">
       <h2 id="DoctorList_header" class="local_header" align="center" onclick="sendInfo()">List of Doctors</h2>
          <!-- <h2 align="center">List of Doctors</h2> -->
          <div class="clr"></div>
          <div id="DoctorList" hidden> 
         <div class="post_content">
        		<br />
        		<center>
	        	<form name="vinform">
	        		Search By specialist&nbsp;&nbsp;&nbsp;
	        		<select name="category" onchange="sendInfo()">
				 <option value="0">all</option>
				<c:forEach var="cat" items="${s2 }">
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<!-- <input type="submit" value="search" class="button"/> -->
	        	
	        	</form>
	        	<br />
	        	</center>
<span id="amit"> </span>
</div></div><div class="clr"></div> </div>
		      </div>
		 <div class="clr"></div>
		
      </div></div>
<%-- <jsp:include page="AdminSidebar.jsp"></jsp:include> --%>
<jsp:include page="Footer.jsp"></jsp:include>