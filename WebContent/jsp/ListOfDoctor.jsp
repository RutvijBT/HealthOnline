 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%
 System.out.println("manisha manish");
 %>
<br/>
<div class="d_list">
        			<table width="85%">
        			<c:forEach var="a" items="${s1}">
        				<tr>
        					<td><c:out value="${a.name}"  /><br /><c:out value="${a.address}"  />
        					<br /><c:out value="${a.city}"  />,<c:out value="${a.state}"  />
        					<br /><c:out value="${a.email}"  /><br />(Degree:<c:out value="${a.degree}"  />)
        					<br />Available Days:<c:out value="${a.schedule}"  /><br />
        					</td>
        				</tr>
        				</c:forEach>          				
        			</table>
        			
        		</div>
        		
		 
	  
	