
<%@page import="javaBean.PaymentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.Admin"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div class="content">
    <div class="content_resize">
      <div class="AdminMainbar">
       <div class="article">
          <h2 align="center">List of Doctors</h2>
          <div class="clr"></div>
         <div class="post_content">
        		<br />
        	<%
        	Admin a=new Admin();
        	ArrayList<PaymentBean> list=a.getTransactionDetails();
        	request.setAttribute("list",list);
        	
        	%><center><table align="center" width="85%" border="1" class="tablecontent">
        	<tr>
        	<th>No</th>
        	<th>User Name</th>
        	<th>Transaction Id</th>
        	<th>Plan</th>
        	<th>Duration</th>
        	<th>Amount</th>
        	<th>Date</th>
        	<th>Plan Status</th>
        	
        	</tr>
        	<c:set var="i">1</c:set>
        	<c:forEach var="t" items="${list }">
        	<tr><td><c:out value="${i }"></c:out></td>
        	
        	 <td><c:out value="${t.name }"></c:out></td>
        	<td><c:out value="${t.transactionid }"></c:out></td>
        	<td><c:out value="${t.plan }"></c:out></td>
        	<td><c:out value="${t.duration}"></c:out></td>
        	<td><c:out value="${t.amount }"></c:out></td>
        	<td><c:out value="${t.date }"></c:out></td> 
        	<c:set var="s" value="${t.status }"></c:set>
		          		 <%
		          		int status=(Integer)(pageContext.getAttribute("s")); 
		          		if(status==1){
		          		 %>
        	<td><c:out value="Active"></c:out></td>
        	<%}
		          		else{%>
		          		<td><c:out value="Deative"></c:out></td>
		          		<%} %> </tr>
		          		<c:set var="i" value="${i+1}"></c:set>
        	</c:forEach>
	        	</table></center>
</div></div>
		      
       </div>
			         	
			          <div class="clr"></div>		  
		 
      </div> </div>
<%-- <jsp:include page="AdminSidebar.jsp"></jsp:include> --%>
<jsp:include page="Footer.jsp"></jsp:include>