<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<c:choose>
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorHeader.jsp"></jsp:include>
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientHeader.jsp"></jsp:include>
	</c:when>
</c:choose>
<div class="content">
	<jsp:useBean id="user" class="userdata.User"></jsp:useBean>
	<div class="content_resize">
		<div class="mainbar">
			<div class="article">
				<h2 style="float: left">Messages</h2>
				<h2 style="float: right">Online Users</h2>

				<div class="clr"></div>
				
				<div class="post_content">
					<hr />
					<div>
					
					<%
					User u=new User();
					ArrayList<Register> list=u.getPatientname();
					request.setAttribute("list",list);

					ArrayList<Register> list1=u.getDoctorName();
					request.setAttribute("list1",list1);
					%>
					
						<div id="message" style="float: left; width: 69.5%; " >
							<div style="background-color: rgb(36,120,170);" align="center">
								<form action="../send.message" method="post">
									<br />
									<h3 style="color: white;height: 4px; " >New message:</h3><span style=" color: white;">To:</span>
									<select name="sendTo">
										<c:choose>
											<c:when test="${sessionScope.role==2 }">
												<c:forEach var="user" items="${list }">
													<option value="${user.id }">${user.name }</option>
												</c:forEach>
											</c:when>
											<c:when test="${sessionScope.role==3 }">
												<c:forEach var="user" items="${list1 }">
													<option value="${user.id }">${user.name}</option>
												</c:forEach>
											</c:when>
										</c:choose>
									</select>
									<button type="submit" value="SEND">SEND</button>
									<br />
									<textarea rows="4" name="message" cols="52" required="required"
										placeholder="Type your message here..."></textarea>
								</form>
							</div>
							
							<%
							int uid=(Integer)session.getAttribute("user_id");
							ArrayList<MessageBean> list2=u.getUserMessage(uid);
							System.out.println(uid);
							Iterator i=list2.iterator();
							while(i.hasNext()){
								System.out.println("123456789"+i.next());
							}
							request.setAttribute("list2",list2);
							
							System.out.println(list2);
							%><br/><center>
							<div class="msg" align="center">
							<!-- <p class="sent">
										message111111111111111111111111111111111111111111</p> -->
								<table>
								<c:forEach var="message1" items="${list2}">
									<!-- <p class="sent">
										message111111111111111111111111111111111111111111</p> -->
									 <c:choose>
								<c:when test="${message1.sender==sessionScope.user_id }">	
				        			<tr>
				        			<td class="user">
				        				<c:out value="${message1.name }"></c:out>
				        			</td>
				        			<td class="sent">
				        			
	        							<c:out value="${message1.message }"></c:out>
	        						</td>
	        						</tr>
								</c:when>
								<c:otherwise>
									<tr>
									<td class="user">
				        				<c:out value="${message1.name }"></c:out>
				        			</td>
									<td class="received">
	        							<c:out value="${message1.message }"></c:out>
	        						</td>
	        						</tr>
								</c:otherwise>
							</c:choose>		
								</c:forEach>
								</table>
							</div></center>
						</div>
						<div
							style="float: right; background-color: #D2D2D2; height: 1000px; width: 30%;">
							<div
								style="background-color: rgb(36,120,170); color: white; font-weight: bold; height: 50px; padding-left: 10px">Please
								note that, We are not maintaining your chat history</div>
							<br />
							<div id="members"
								style="background-color: #D2D2D2; padding-left: 10px"></div>
						</div>
					</div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<c:choose>
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