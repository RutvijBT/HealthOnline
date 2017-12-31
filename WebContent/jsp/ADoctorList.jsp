 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<br/>
<div class="ad_list"><center>
        			<table width="50%">
        			<c:forEach var="a" items="${s1}">
        				<tr>
        					<td><a href="/HealthOnlineProject/UserInfo?id=${a.did} " style="color:white;"><c:out value="${a.name}"  /></a><br />
        					</td>
        				</tr>
        				</c:forEach>          				
        			</table></center>
        			
        		</div>
        		
		 
	  
	