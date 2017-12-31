<jsp:include page="/ViewProfile" flush="true" ></jsp:include>
<jsp:include page="PatientHeader.jsp"></jsp:include>
<%@page import= "java.util.ArrayList" %>
<%@page import= "javaBean.Register" %>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
			<div class="article" id="display_profile">
			<h2 id="profile_header" class="local_header">Profile</h2>
			<div id="profile" >
			  <div class="clr"></div>
			  <div class="post_content" >
			   <br />
				<table align="center" width="70%" class="profile">
				<% ArrayList<Register>list=(ArrayList<Register>)request.getAttribute("List");
				for(int i = 0; i < list.size(); i++) {Register d1=list.get(i);%>
					<tr>
						<td>Name :- </td>
						<td> <%= d1.getName() %></td>
					</tr>
					<tr>
						<td>Address :- </td>
						<td> <%= d1.getAddress() %></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><%= d1.getCity() %></td>
					</tr>
					<tr>
						<td>State</td>
						<td><%= d1.getState() %></td>
					</tr>
					<tr>
						<td>Mobiel</td>
						<td><%= d1.getMobile() %></td>
					</tr>
					
					<tr>
						<td>Email</td>
						<td><%= d1.getEmail() %></td>
					</tr>
					<tr>
						<td colspan="2" align="center" id="update_profile_button"><button>UPDATE</button></td>
					</tr>
					<% }%>  
				</table>
				</div>
			  <div class="clr"></div>
			</div>
			</div>
			<div class="article" id="update_profile" hidden>
			  <h2 id="profile_header" class="local_header" >Edit and Update profile</h2>
			  <div class="clr"></div>
			  <div class="post_content">
				<br />
				<form  action="../UpdateProfile" method="post" >
					<table align="center" width="70%" class="profile">
					<% ArrayList<Register>list2=(ArrayList<Register>)request.getAttribute("List");
				for(int i = 0; i < list.size(); i++) {Register d1=list.get(i);%>
					<tr>
						<td>Name<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="name" value="<%= d1.getName() %>" required="required"/></td>
					</tr>
					<tr>
						<td>Address<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="address" value="<%= d1.getAddress() %>" required="required"/></td>
					</tr>
					<tr>
						<td>City<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="city" value="<%= d1.getCity() %>" required="required"/></td>
					</tr>
					<tr>
						<td>State<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" name="state" value="<%= d1.getState() %>" required="required"/></td>
					</tr>
					<tr>
						<td>Mobile<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text"  id="num" name="mobile" value="<%= d1.getMobile() %>" required="required"/></td>
					</tr>
					<tr>
						<td>Password<span style=" font-size:larger; color: red;">*</span></td>
						<td><input type="text" value="<%= d1.getPassword() %>"  id="password" name="password" " required="required"/></td>
					</tr>
					<tr>
						<td>Email<span style=" font-size:larger; color: red;">*</span></td>
						<td><%= d1.getEmail() %></td>
					</tr>
					<tr>
						<td align="right"><input type="submit" id="validation" value="SAVE" class="button"/></td>
						<td id="cancel_profile_button"><button>CANCEL</button></td>
					</tr>
				<% }%>		  
				</table>
				</form>
				<br/>
        <div style="color: red;" >Fields which have * all are Mandatory.</div>
			   </div>
			  <div class="clr"></div>
			
			</div>
			

      </div>
	  
<jsp:include page="PatientSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>