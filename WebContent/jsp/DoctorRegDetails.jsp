<jsp:include page="DoctorHeader.jsp"></jsp:include>
<%@page import= "java.util.ArrayList" %>
<%@page import= "javaBean.Register" %>
<jsp:include page="/ViewRegDetails" flush="true" ></jsp:include>
<jsp:useBean id="link1" scope="application" class="userdata.TopRegPlan"></jsp:useBean>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
		<div class="article">
          <h2>Your current plan detail</h2>
          <div class="clr"></div>
          <div class="post_content">
<table align="center" width="50%" class="profile" >
<% ArrayList<Register>list=(ArrayList<Register>)request.getAttribute("List");
				for(int i = 0; i < list.size(); i++) {Register d1=list.get(i);%>
					<tr>
						<td>Plan :- </td>
						<td> <%= d1.getRegPlanName()%></td>
					</tr>
					<tr>
						<td>Duration :- </td>
						<td> <%= d1.getRegPlanDuration()%></td>
					</tr>
					<tr>
						<td>Amount :-</td>
						<td> <%= d1.getRegPlanAmount()%></td>
					</tr>
					<tr>
						<td>Expiry date of Your Plan :-</td>
						<td> <%= d1.getRegExpDate()%></td>
					</tr>
					<% }%>  
				</table>            </div>
          <div class="clr"></div>
        </div>
		<div class="article">
          <h2>Suggested plan for you</h2>
          <div class="clr"></div>
          <div class="post_content">
				<br />
				<table align="center" width="90%">
						<tr>
							<%ArrayList<Register> list1=link1.DoctorPlans();
						for(Register object: list1) { %>
							<td class="reg" align="center">Plan:<%=object.getRegPlanName()%><br />Duration:<%=object.getRegPlanDuration()%><br />Amount:<%=object.getRegPlanAmount()%></td>
							<td width="5%"></td>
							<% }%>
						</tr>


					</table>
		  </div>
          <div class="clr"></div>
        </div>
      </div>
<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>