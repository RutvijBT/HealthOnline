<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
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
</c:choose>
<div class="content">
    <div class="content_resize">
      <div class="mainbar">
       <div class="article">
          <h2>Messages</h2>
          <div class="clr"></div>
          <div class="clr"></div>
         <div class="post_content">
         <br />
         	<div class="msg">
        		
        		
        		<table >
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="sent">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="received">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="sent">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="received">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="sent">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			<tr>
        				<td class="user">Chandan Rajput</td>
        				<td class="received">
        					Lorem ipsum dolor sit amet, consectetuer adipiscing elitDTDT20142138652DT2014213865220142138652DT20142138652
        				</td>
        			</tr>
        			
        		</table>
        	</div>
        	<div align="right" style="padding-right: 70px"><button>More</button></div> 
		 </div>
          <div class="clr"></div>
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