
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="content">
	<div class="content_resize">
		<div class="mainbar">
			<div class="article">
				<h2>
					<span>Contact</span>
				</h2>
					<% 
						if(request.getAttribute("message")!=null){		
					%>
				<span style="color:red;font-weight: bold;"><%=request.getAttribute("message") %></span>
				<%} %>
				<div class="clr"></div>
				<p>Nullapede laorem velit curabitudin enim in nibh ero leo in
					pede. Semperpurus nibh elit et convallis eu trices congue males
					monterdum elit.</p>
			</div>
			<div class="article">
				<h2>
					<span>Send us</span> mail
				</h2>
				<div class="clr"></div>
				<!-- <form action="../mail.me" method="post" enctype="text/plain" id="sendemail"> -->
				<form action="../EmailServlet" >
					<ol>
						<li><label for="name">Subject <span
								style="font-size: larger; color: red;">*</span></label> <input id="name"
							name="subject" class="text" required="required" /></li>

						<li><label for="message">Your Message</label> <textarea
								id="message" name="message" rows="8" cols="50"
								required="required"></textarea></li>
						<li><label for="email">Your Email-id<span
								style="font-size: larger; color: red;">*</span></label> <input
							id="email" name="email" class="text" required="required" /></li>
						<!-- <li><label for="email">Password : <span
								style="font-size: larger; color: red;">*</span></label> <input
							id="email" name="password" type="password" class="text"
							required="required" /></li> -->
					</ol>
					<br />
					<div style="padding-left: 180px;">
						<input type="submit" class="button" value="Send" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="button" value="Reset" />
					</div>
					<div class="clr"></div>
				</form>
				<br /> <br /> <br />
				<div style="color: red;">Fields which have * all are
					Mandatory.</div>
			</div>
		</div>
		<c:choose>
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
		<jsp:include page="Footer.jsp"></jsp:include>