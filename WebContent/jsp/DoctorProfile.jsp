<jsp:include page="DoctorHeader.jsp"></jsp:include>
<%@page import= "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import= "javaBean.Register" %>
<jsp:include page="/ViewProfile"></jsp:include>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
			<div class="article" id="display_profile">
			<h2 id="profile_header" class="local_header">Profile</h2>
			<div id="profile">
			  <div class="clr"></div>
			  <div class="post_content" >
			   <br />
				<table align="center" width="70%" class="profile" >
				<c:forEach var="d1" items="${List }">
					<tr>
						<td>Name :- </td>
						<td><c:out value="${d1.name}"/></td>
					</tr>
					<tr>
						<td>Address :- </td>
						<td> <c:out value="${d1.address}"/></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><c:out value="${d1.city}"/> </td>
					</tr>
					<tr>
						<td>State</td>
						<td><c:out value="${d1.state}"/></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><c:out value="${d1.mobile}"/></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><c:out value="${d1.email}"/></td>
					</tr></c:forEach>
					<tr>
						<td colspan="2" align="center" id="update_profile_button"><button>UPDATE</button></td>
					</tr>
				
				</table>
				</div>
			  <div class="clr"></div>
			</div>
			</div>
			<div class="article" id="update_profile" hidden>
			  <h2 id="profile_header" class="local_header" >Update Your Profile</h2>
			  <div class="clr"></div>
			  <div class="post_content">
				<br />
				<form  action="../UpdateProfile" method="post" >
					<table align="center" width="70%" class="profile">
					<c:forEach var="d1" items="${List }">
					<tr>
						<td>Name<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="name" value="<c:out value="${d1.name}"/>" required="required"/></td>
					</tr>
					<tr>
						<td>Address<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="address" value="<c:out value="${d1.address}"/>" required="required"/></td>
					</tr>
					<tr>
						<td>City<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="city" value="<c:out value="${ d1.city}"/>"required="required"/></td>
					</tr>
					<tr>
						<td>State<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="state" value="<c:out value="${d1.state}"/>" required="required" /></td>
					</tr>
					<tr>
						<td>Mobile<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" id="num" name="mobile" value="<c:out value="${ d1.mobile}"  />" required="required"/></td>
					</tr>
					<tr>
						<td>Password<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" value="<c:out value="${ d1.password}"  />" id="password" name="password" " required="required"/></td>
					</tr>
					<tr>
						<td>Email<span style=" font-size:larger; color: red;">*</span></td>
						<td><c:out value="${d1.email}"/></td>
					</tr></c:forEach>
					<tr>
						<td align="right"><input type="submit" id="validation" value="SAVE" class="button"/></td>
						<td id="cancel_profile_button"><button>CANCEL</button></td>
					</tr>
					
				</table>
				</form>
				<br/>
         <div style="color: red;" >Fields which have * all are Mandatory.</div>
			   </div>
			  <div class="clr"></div>
			
			</div>
		
			<div class="article" id="display_schedule">
			<h2 id="profile_header" class="local_header">Schedule</h2>
			<div id="profile">
			  <div class="clr"></div>
			  <div class="post_content" >
			   <br />
				<table align="center" width="60%" class="profile" >
				<c:forEach var="d1" items="${List }">
					<tr>
						<td style="font-size: medium;">Available Days:- </td>
						<td><c:out value="${ d1.schedule}"/></td>
					</tr>
					
					</c:forEach>
					<tr>
						<td colspan="2" align="center" id="update_schedule_button"><button>UPDATE</button></td>
					</tr>
				</table>
				</div>
			  <div class="clr"></div>
			</div>
			</div>
			<div class="article" id="update_schedule" hidden>
			  <h2 id="profile_header" class="local_header" >Update Your Schedule</h2>
			  <div class="clr"></div>
			  <div class="post_content">
				<br />
					<table align="center" width="40%" class="profile">
					<form  action="../UpdateSchedule" method="post" >
					<tr>
						<td style="font-size: medium;">Available Days:- </td>
						<td><input type="checkbox" name="op" size="20" class="txt" value="sunday">Sunday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="monday">Monday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="tuesday">Tuesday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="wednesday">Wednesday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="thursday">Thursday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="friday">Friday<br/>
<input type="checkbox" name="op" size="20" class="txt" value="saturday">Saturday<br/></td>
					</tr>
					
					<tr>
						<td align="right"><input type="submit" value="SAVE" class="button"/></td>
						<td id="cancel_schedule_button"><button>CANCEL</button></td>
					</tr>
				</table>
				</form>
			   </div>
			  <div class="clr"></div>
			
			</div>
		
		
			
				</div>
			
		
      


<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>