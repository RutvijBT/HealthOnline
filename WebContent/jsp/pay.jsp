<%@page import="javaBean.UserPlanBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="GuestHeader.jsp"></jsp:include>
<div class="content">
	<jsp:useBean id="user" class="userdata.User"></jsp:useBean>
	<div class="content_resize">
		<div class="mainbar">
			<div class="article">
				<h2>
					<span>Fill FORM FOR Payment </span>
				</h2>
				<% 		
				if(request.getSession().getAttribute("user_id")==null  || request.getSession().getAttribute("user_id")==""){
						response.sendRedirect("/HealthOnlineProject/HomePage.jsp");
					/* RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
					rd.forward(request, response); */
				}
						if(request.getAttribute("message1")!=null){		
					%>
				<span style="color:red;font-weight: bold;"><%=request.getAttribute("message1") %></span>
				<%} %>
				<div class="clr"></div>
				<form action="/HealthOnlineProject/jsp/Payment.jsp" method="post">
					<table>
						<tr>
							<td>FirstName</td><td><input type="text" name="firstname" required="required" size="32"/></td>
						</tr><tr>
							<td>LastName</td><td><input type="text" name="lastname" required="required" size="32"/></td>
						</tr><tr>
							<td>Credit Card No.</td><td><input type="text" name="" required="required" size="32"/></td>
						</tr><tr>
							<td>Plan</td><td>
								<select name="planId" id="planId" required="required" onchange="getAmount()">
									<option></option>
									<%
									User u=new User();
									ArrayList<UserPlanBean> list;
									int role_id=Integer.parseInt(request.getSession(false).getAttribute("role_id").toString());
									/* if(role_id==2){
										list=u.getAllPlanDetail();
									}
									else{ */
										list=u.getUserPlan(role_id);
									/* } */
									request.setAttribute("list",list);
									%>
									<c:forEach var="plan" items="${list }">
										<option value="${plan.plan_id }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${plan.plan } <%-- [ ${plan.getDuration() } ] [Rs. ${plan.getAmount() } ] --%></option>
									</c:forEach>
								</select>
								</td>
								</tr><tr>
								<td>Amount :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs.</td>
								<td><input type="text" name="amount" id="amount" size="14" readonly="readonly"></td>
							
							<!-- <input type="text" name="amount" required="required"/> -->
							</tr>
							<tr>
							<td colspan="2" align="center"><button type="submit" >Pay</button><button type="reset">Reset</button></td>	
						</tr>
					</table>
				</form><br />
			</div>
			<div class="article">
          <h2><span>You should refer following plans :</span></h2>
           <div class="clr"></div>
          
          <div class="post_content"><center>
            <table width="90%" border="1" class="tablecontent"><tr>
            <th width="40">No</th><th width="103">Plan Name</th><th width="79">Duration</th><th width="76">Amount</th>
            </tr>
            <jsp:useBean id="User" class="userdata.User"></jsp:useBean>
            <c:set var="number">1</c:set>
            <c:forEach var="p" items="${list}">
            	<tr>
            		<td>${number }</td>
            		<td>${p.plan }</td>
            		<td>${p.duration }</td>
            		<td>${p.amount}</td>
            	</tr>
            	<c:set var="number" value="${number+1 }"></c:set>
            
            </c:forEach>
            </table>
            </center>
          </div>
          <div class="clr"></div>
        </div>
			<%-- <div class="article">
				<h2>
					<span>You should prefer Following plan</span>
				</h2>
				<table width="90%" border="1" class="tablecontent">
							<tr>
								<th width="40">No</th>
								<th width="103">Plan Name</th>
								<th width="79">Duration</th>
								<th width="76">Amount</th>
							</tr>
							<jsp:useBean id="user" class="userdata.User"></jsp:useBean>
							<c:set var="number">1</c:set>
							<c:forEach var="plan" items="${user.getUserPlan() }">
								<tr>
									<td>${number }</td>
									<td>${plan.getPlan() }</td>
									<td>${plan.getDuration() }</td>
									<td>${plan.getAmount() }</td>
								</tr>
								<c:set var="number" value="${number+1 }"></c:set>

							</c:forEach>
				</table>
			
			</div> --%>
		</div>
<jsp:include page="Sidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>