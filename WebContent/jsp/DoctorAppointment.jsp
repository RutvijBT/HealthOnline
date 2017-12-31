<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="DoctorHeader.jsp"></jsp:include>
  <!--Header End -->
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
       
            <div class="article">
          <h2><span>Today's Appointment</span></h2>
          <div class="clr"></div>
          <div class="post_content">
          <br/>
          <table width="80%" align="center" border="1" class="tablecontent">
          	<tr>
	          	<th>No.</th>
	          	<th>Patient Name</th>
	           	<th>Time</th>
	           	<th>Comment</th>
	           
	        </tr>	       <c:set var="number">1</c:set>
           	<c:forEach var="ap" items="${appointmen}">
				<tr>
				
					<td><c:out value="${number }"></c:out></td>
					<td><c:out value="${ap.name }"></c:out></td>
					<td><c:out value="${ap.time }"></c:out></td>
					<td><c:out value="${ap.comment }"></c:out></td>
					
				</tr>
				<c:set var="number" value="${number+1 }"></c:set>
			</c:forEach>
            </table>
            </div>
          <div class="clr"></div>
        </div>
        <div class="article">
          <h2>Your Appointments</h2>
          <div class="clr"></div>
          <div class="post_content">
			<br />
			<table  width="100%" align="center" border="1" class="tablecontent">
		        <tr >
		          <th>No</th>
		          <th>Patient Name</th>
		          <th>Date</th>
		          <th>Time</th>
		        </tr>
		           <%--  <jsp:useBean id="appointment" class="userdata.Appointment"></jsp:useBean> --%>
		            <c:set var="number">1</c:set>
		            <c:forEach var="appo" items="${appointment}">
					<tr>
						<td><c:out value="${number }"></c:out></td>
						<td><c:out value="${appo.name }"></c:out></td>
						<td><c:out value="${appo.date}"></c:out></td>
						<td><c:out value="${appo.time }"></c:out></td>	
					</tr>
				
					<c:set var="number" value="${number+1 }"></c:set>
				</c:forEach>	
            </table>
            <br/>
         <!-- <div style="color: red;" >Fields which have * all are Mandatory.</div> -->
		   </div>
          <div class="clr"></div></div>
        </div>

<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>