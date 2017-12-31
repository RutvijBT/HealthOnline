<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <script>
var request;
function sendDoctor()
{
var v=document.vinform.category.value;
var url="DoctorList?val="+v;
//document.vinform.category.nll=disabled;
if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getDoctor;
request.open("POST",url,true);
request.send();
}
catch(e)
{
alert("Unable to connect to server");
}
}

function getDoctor(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('amitdoctor').innerHTML=val;
}
}

</script>
<c:choose>
	<%-- <c:when test="${sessionScope.role==1 }">
		<jsp:include page="AdminHeader.jsp"></jsp:include> 
	</c:when> --%>
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorHeader.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientHeader.jsp"></jsp:include> 
	</c:when>
	<c:otherwise>
		<jsp:include page="GuestHeader.jsp"></jsp:include> 
	</c:otherwise>
</c:choose>
      <div class="clr"></div>
    </div>
  </div>
   
      
	<div class="content" >
    <div class="content_resize">
      <div class="mainbar">
       <div class="article">
          <h2>Doctors</h2>
          <div class="clr"></div>
          <div class="clr"></div><div class="plain_text">
         <div class="post_content">
        		<br />
        		 
	        	<form name="vinform" >
	        		Search By specialist&nbsp;&nbsp;&nbsp;
	        		<select name="category"  onchange="sendDoctor()">
				
				<c:forEach var="cat" items="${s2 }" >
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<!-- <input type="submit" value="search" class="button"/> -->
	        		<!-- <input type="button" value="ShowTable" > -->
	        		
	        	</form>
	        	<br />
	        	
<span id="amitdoctor"> </span>
</div></div>
          <div class="clr"></div>
        </div>
      </div><c:choose>
	<%-- <c:when test="${sessionScope.role==1 }">
		<jsp:include page="AdminSidebar.jsp"></jsp:include> 
	</c:when> --%>
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorSidebar.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientSidebar.jsp"></jsp:include> 
	</c:when>
	<c:otherwise>
		<jsp:include page="Sidebar.jsp"></jsp:include> 
	</c:otherwise>
</c:choose>
 <jsp:include page="Footer.jsp"/>