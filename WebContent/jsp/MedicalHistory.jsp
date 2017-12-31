<%@page import="javaBean.PrescriptionBean"%>
<%@page import="javaBean.PatientSelfDescriptionBean"%>
<%@page import="javaBean.MedicalHistoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.Patient"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="PatientHeader.jsp"></jsp:include>
 
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
			<%-- <jsp:useBean id="patient" class="userdata.Patient"></jsp:useBean> --%>
			<% Patient patient=new Patient(); %>
			<div class="article">
			  <h2 id="medical_history_header" class="local_header">Medical History </h2>
			 <div class="clr"></div><br/>
			  <div id="medical_history" > 
				  <button id="new_history_button" align="center">Add New</button>
				  <div id="new_history_div" align="center" hidden>
					  	<form action="/HealthOnlineProject/SaveMedicalHistory" method="post">
					  		File Description: <input type="text" name="file_desc" required="required" size="50" maxlength="100" placeholder="Limit 100 char"/>
					  		Date: <input type="date" name="date" required="required"/><br />
					  		<br/>
					  		<input type="button" value="Cancel" id="new_history_cancel" class="button">
					  		<input type="submit" value="Click To Upload file" class="button" > 
					  	</form>
				  </div><br/>
				  <div class="post_content">
					<table align="center" width="97%" border="1" class="tablecontent">
						<tr>
							<th>No.</th>
							<th>File</th>
							<th>Description</th>
							<th>Date given by You</th>
							<th>Date of Upload</th>	
							<th>Action</th>						
						</tr>
						<% int id=(Integer)session.getAttribute("user_id");
						System.out.println();
						System.out.println(id);
						ArrayList<MedicalHistoryBean> list=patient.getMedicalHiostory(id); 
						request.setAttribute("list",list);
						%>
						<c:set var="i" >1</c:set>
						<c:forEach var="medical" items="${list }">
							<tr>
								<td><c:out value="${i }"></c:out></td>
								<td><c:out value="${medical.fileName}"></c:out></td>
								<td><c:out value="${medical.description }"></c:out></td>
								<td><c:out value="${medical.dateByPatient }"></c:out></td>
								<td><c:out value="${medical.dateOfUpload }"></c:out></td>	
								<td><a href="../medical.delete?id=${medical.id }">DELETE</a></td>
							</tr>
								<c:set var="i" value="${i+1}"></c:set>
						</c:forEach>
					</table>
					<!-- <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. <a href="#">Suspendisse bibendum. Cras id urna.</a> Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum, dui pede condimentum odio, ac blandit ante orci ut diam. Cras fringilla magna. Phasellus suscipit, leo a pharetra condimentum, lorem tellus eleifend magna, eget fringilla velit magna id neque. Curabitur vel urna. In tristique orci porttitor ipsum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo.</p>
					<p class="infopost">Posted on <span class="date">29 aug 2016</span> by <a href="#">Admin</a> &nbsp;&nbsp;|&nbsp;&nbsp; Filed under <a href="#">templates</a>, <a href="#">internet</a> <a href="#" class="com"><span>7</span></a></p>
				   -->
				  </div>
				  <div class="clr"></div>
			  </div>
			</div>
			<div class="article">
			  <h2 id="patient_prescription_header" class="local_header">Doctor'S prescription </h2>
			  <div class="clr"></div>
			  <%
			  Patient p=new Patient();
			  int uid=(Integer)session.getAttribute("user_id");
			  ArrayList<PrescriptionBean> pre=p.getPrscription(uid);
			  request.setAttribute("pre",pre);
			  %>
			    
				   <div id="patient_prescription" hidden>
						<div class="post_content"><br/>
						 <div style="color: rgb(36,120,180); font-size: large;font-weight: bold;">
         
         
        <form name="health">
        
         Search Prescription<span style="color: rgb(36,120,180); font-size:small;">
         (By date or symptom or diagnosis):</span>
          <input  maxlength="80" type="text" name="search"/>
          <input type="button" value="search" class="button" onclick="sendPre()"/> 
         
        </form></div><br/>
	          
      <br/>
    <span id="prescription"></span> <br/>
    <h2>All Prescription Data</h2>
      <table align="center" width="100%" border="1" class="tablecontent">
									<tr>
									<th>Doctor Name And Date</th>
										<th>Symptom And Diagnosis</th>
										<th>Medicine ( Dosages )</th>
									
									</tr>
							 <c:forEach var="prescription" items="${pre}">
								<!-- <div align="left" class="tablecontent"> -->
								
										<tr style="text-align: left;" ><td >Dr. <span style="font-weight: bold;">
										${prescription.name }</span>	<br/>
										on ${prescription.date}</td>
										<td > <span style="font-weight: bold;">Symptom: </span>${prescription.sympton } <br/>
										<span style="font-weight: bold;">Diagnosis: </span>${prescription.diagnosis }	</td>
									
																
									
		          		 <%
		          		int prid=(Integer)(pageContext.getAttribute("preid")); 
		          		ArrayList<PrescriptionBean> m=p.getMedicine(prid);
		          		request.setAttribute("m",m);
									%><td rowspan="*">
									 <c:forEach var="medicine" items="${m }">
									
											${medicine.medicine } (<span style="font-weight: bold;">Dosage:</span> ${medicine.dosage } )
											<br/>
										
									</c:forEach></td>
								</tr>
							</c:forEach></table><br/>
						</div>
					  <div class="clr"></div>
				  </div>
			  
			</div>
			<div class="article">
			  <h2 id="self_description_header" class="local_header">self description </h2>
			  <div class="clr"></div>
				<div id="self_description" hidden><br/>
				<button align="right" id="post_button">Enter Self Description </button>
				<div class="clr"></div>
				  <div class="post_content">
				  <div class="post_content" id="post_content" hidden>
         <form method="post" action="../description.post">
			<textarea rows="4" cols="70" name="description" placeholder="Type your description here..."></textarea><br />
            <input type="submit" value="Submit" class="button"/>
		 </form>
		 </div><br/>
		 <%
		
		 
		 ArrayList<PatientSelfDescriptionBean> list1=p.getSelfDescription(uid);
		 request.setAttribute("s1",list1);
		 %>
			<div id="profile">
			  <div class="clr"></div>
			   <c:forEach var="description" items="${s1}">
				  <div class="post_content"  >
					<span>${description.description }</span>
					<p class="infopost">Posted on <span class="date">${description.date }</span></p>
				  </div>
				</c:forEach>
			  <div class="clr"></div>
			</div>
			</div>
			</div>
				  <div class="clr"></div>
				</div>
			</div>
<jsp:include page="PatientSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>