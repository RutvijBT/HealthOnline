
<%@page import="javaBean.Register"%>
<%@page import="servlet.UserInfo"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div class="content">
    <div class="content_resize">
      <div class="AdminMainbar">
       <div class="article">
       <% int role=Integer.parseInt(request.getParameter("role"));
       System.out.println();
       System.out.println("in jsp"+role);
      
       %>
          <h2 align="center">Information</h2>
          <div class="clr"></div>
         <div class="post_content" align="center">
        		<div class="plain_text" align="center">
	        	<table align="center" width="70%" class="profile">
				<c:forEach var="a" items="${list}">
				<%-- <tr>
						<td>No :</td>
						<td> <c:out value="${a.id}"  /></td>
					</tr> --%>
					<tr>
						<td>Name :</td>
						<td> <c:out value="${a.name}"  /></td>
					</tr>
					<tr>
						<td>Address : </td>
						<td><c:out value="${a.address}"/></td>
					</tr>
					<tr>
						<td>City :</td>
						<td><c:out value="${a.city }" /></td>
					</tr>
					<tr>
						<td>State :</td>
						<td><c:out value="${a.state}" /></td>
					</tr>
					<tr>
						<td>Mobile :</td>
						<td><c:out value="${a.mobile }" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><c:out value="${a.email}" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><c:out value="${a.gender }" /></td>
					</tr>
					<tr>
						<td>Birth Date :</td>
						<td><c:out value="${a.bdate }" /></td>
					</tr>
					<tr>
						<td>Blood Group :</td>
						<td><c:out value="${a.bloodGroup }" /></td>
					</tr>
					<tr>
						<td>Registration Date :</td>
						<td><c:out value="${a.regDate}" /></td>
					</tr>
					<tr>
						<td>Plan Name :</td>
						<td><c:out value="${a.regPlanName }" /></td>
					</tr>
					<tr>
						<td>Category :</td>
					<td><c:out value="${a.category}" /></td>
					</tr>
					<% if(role==2){  %>
					<tr>
						<td>Certificate No. :</td>
						<td><c:out value="${a.certificateNumber }" /></td>
					</tr>
					<tr>
						<td>Degree :</td>
						<td><c:out value="${a.degree }" /></td>
					</tr>
					
					
					<tr>
						<td>Available Days:- </td>
						<td><c:out value="${ l}"/></td>
					</tr><% } %>
					
					
					<tr><td>
					<a href="/HealthOnlineProject/DeleteUser?id=${a.id}">
						<button class="button">DELETE</button></a>
				</td>
					</c:forEach><td><a href="/HealthOnlineProject/UserList">
						<button class="button">BACK</button></a>
					</td></tr>
				</table>

</div></div>
		      <div class="clr"></div>
       
			         	 </div>
			          
		
		 <div class="clr"></div>
      </div></div>
<%-- <jsp:include page="AdminSidebar.jsp"></jsp:include> --%>
<jsp:include page="Footer.jsp"></jsp:include>