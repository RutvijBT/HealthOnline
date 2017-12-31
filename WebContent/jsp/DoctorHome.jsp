<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="DoctorHeader.jsp"></jsp:include>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
      <jsp:useBean id="appointment" class="userdata.Appointment"></jsp:useBean>
      <jsp:useBean id="object" class="userdata.Questions"></jsp:useBean>
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
           	<c:forEach var="ap" items="${today}">
				<tr>
				
					<td><c:out value="${number }"></c:out></td>
					<td><c:out value="${ap.name }"></c:out></td>
					<td><c:out value="${ap.time }"></c:out></td>
					<td><c:out value="${ap.comment }"></c:out></td>
					
				</tr>
				<c:set var="number" value="${number+1 }"></c:set>
			</c:forEach>
            </table>
           
          <div class="clr"></div>
        </div>
           <div class="article">
          <h2><span>Confirm these Appointments</span></h2>
          
          <div class="clr"></div>
          
          <div class="post_content">
          <br/>
	          <table  width="100%" align="center" border="1" class="tablecontent">
	          	<tr >
	          		<th>No.</th>
	          		<th>Patient Name</th>
	           	 	<th>Date</th>
	           	 	<th>Comment</th>
	           	 	<th>Time</th>
	            	<th colspan="2">ACTION</th>
	            </tr>
	          <c:set var="number">1</c:set>
	            <c:forEach var="appo" items="${pending }">
					<form action="/HealthOnlineProject/confirm.appointment" method="get" >		
						<tr>
							<td>
								<input type="text" value="${appo.appointment }" name="appintment_id" hidden/>
								<input type="text" value="${appo.patient }" name="patient_id" hidden/>
								${number }
							</td>
							<td>${appo.name }</td>
							<td>${appo.date }</td>
							<td>${appo.comment }</td>
							<td><input type="text" name="time" PLACEHOLDER="10:10 PM / 22:10" required="required"/></td>	
							
							<td><input type="submit" value="CONFIRM" /></td>
							
							<td><a href="/HealthOnlineProject/DeleteAppoinment?id=${appo.appointment}">DELETE</a></td>	
						</tr>
					</form>
					<c:set var="number" value="${number+1 }"></c:set>
				</c:forEach>
            	</table>
            <div class="clr"></div>
            <br/>
         <div style="color: red;" >Fields which have * all are Mandatory.</div>
            <p class="spec"><a href="/HealthOnlineProject/Appointment" class="rm">See all appointments &raquo;</a></p>
          </div>
          
          <div class="clr"></div>
        </div>
        <div class="article">
          <h2><span>Give Answers of Questions</span></h2>
          <div class="clr"></div>
          	 <c:set var="i">1</c:set>
          	<c:forEach var="que" items="${questions}">
          
	          <div class="post_content">
	            <p>${que.question }</p>
	            <p class="infopost">Posted on <span class="date">${que.date}</span> by <a href="#">${que.name}</a></p>
	          	<button align="right" id="post_button${i }">Give Answer</button>
	         	<div class="post_content" id="post_ans${i }" hidden>
		         	<form method="post" action="/HealthOnlineProject/post.answer">
						<input type="text" name="id"value="${que.question_id }" hidden/>
						<textarea rows="4" cols="70" name="answer" placeholder="Type your answer here..."></textarea><br />
		            	<input type="submit" value="Post" class="button"/>
				 	</form>
				 </div>
	         </div>
	         <c:set var="i" value="${i+1 }"></c:set>
         	</c:forEach> 
            <div class="clr"></div>
            <p class="spec"><a href="/HealthOnlineProject/jsp/DoctorQuestionaries.jsp" class="rm">See All Questions &raquo;</a></p>
          </div>
          <div class="clr"></div>
        </div>
        
      
	  </div>
	  
<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>