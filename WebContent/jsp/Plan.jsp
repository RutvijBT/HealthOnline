<%@page import="javaBean.UserPlanBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<c:otherwise>
		<jsp:include page="AdminHeader.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
<div class="content">
	<div class="content_resize">
		<div class="AdminMainbar">
			<div class="article">
				<h2 align="center">
					<span>Plan detail for all type of user</span>
				</h2>
				<div class="clr"></div>
				<!--  <p>Nullapede laorem velit curabitudin enim in nibh ero leo in pede. Semperpurus nibh elit et convallis eu trices congue males monterdum elit.</p>
         -->
			</div>
			<div class="article">
				<input type="button" id="new_plan_click" value="ADD NEW PLAN"
					class="button" />
				<div id="newPlan" hidden>
					<h3 align="center">Fill Plan Detail</h3>
					<form action="../save.plan" method="post">
						<input type="text" name="operation" value="insert" hidden="Hidden" />
						<table align="center">
							<tr>
								<td>Name :</td>
								<td><input type="text" name="plan" required="required"
									placeholder="plan name" /></td>
								<td>Period :</td>
								<td><select name="period">
										<option value="1">2013-2014</option>
										<option value="2">2014-2015</option>
										<option value="3">2014-2016</option>
										<option value="4">2015-2016</option>
										<option value="5">2015-2018</option>
										<option value="6">2013-2017</option>
								</select></td>
							</tr>
							<tr>
								<td>Duration :</td>
								<td><input type="text" name="duration" required="required"
									placeholder="duration" /></td>
								<td>Role :</td>
								<td><select name="role">
										<option value="2">Doctor</option>
										<option value="3">Patient</option>
								</select></td>
							</tr>
							<tr>
								<td>Amount(Rs.) :</td>
								<td><input type="text" name="amount" required="required"
									placeholder="amount"
									onkeypress='return event.charCode >= 48 && event.charCode <= 57' />
								</td>
								<td>Status :</td>
								<td><select name="status">
										<option value="1">Active</option>
										<option value="2">Inactive</option>
								</select></td>
							</tr>
							<tr>
								<td colspan="4" align="center"><input type="submit"
									value="Save" class="button" /> <input type="button"
									value="Cancel" id="new_plan_cancel" class="button" /></td>
							</tr>
						</table>
					</form>
				</div>
				<jsp:useBean id="user" class="userdata.User"></jsp:useBean>
				

				<div id="update_plan">
					<c:if test="${param.id!=null }">
					<c:set var="planId" value="${param.id }"></c:set>
					<%
					String str=request.getParameter("id");
					int pId=Integer.parseInt(str);
					/* int pId=(Integer)(pageContext.getAttribute("planId")); */
ArrayList<UserPlanBean> list=user.getPlanDetail(pId);
request.setAttribute("list",list);
%>
						<h2>EDIT PLAN DETAIL for plan no. ${param.id }</h2>
						<form action="/HealthOnlineProject/save.plan" method="post">
							<input type="text" name="plan_id" value="${param.id }"
								hidden="hidden" /> <input type="text" name="operation"
								value="update" hidden="Hidden" />
							<c:forEach var="plan" items="${list}">
								<table align="center">
									<tr>
										<td>Name :</td>
										<td><input type="text" name="plan"
											value="${plan.getPlan() }" required="required" "/></td>
										<td>Period :</td>
										<td><select name="period">
												<option value="${plan.getPeriod_id() }">${plan.getPeriod() }</option>
												<option value="1">2013-2014</option>
												<option value="2">2014-2015</option>
												<option value="3">2014-2016</option>
												<option value="4">2015-2016</option>
												<option value="5">2015-2018</option>
												<option value="6">2013-2017</option>
										</select></td>
									</tr>
									<tr>

										<td>Amount(Rs.) :</td>
										<td><input type="text" name="amount"
											value="${plan.getAmount() }" required="required"
											onkeypress='return event.charCode >= 48 && event.charCode <= 57' />
										</td>
										<td>Role :</td>
										<td><select name="role">
												<%-- <option value="${plan.getRole() }">${plan.getRole_name() }</option> --%>
												<option value="2">Doctor</option>
												<option value="3">Patient</option>
										</select></td>
										<td>
									</tr>
									<tr>
										<td>Duration :</td>
										<td><input type="text" name="duration"
											value="${plan.getDuration() }" required="required" /></td>
										<td>Status :</td>
										<td><select name="status">
												<option value="${plan.getStatus_id() }">${plan.getStatus() }</option>
												<option value="1">Active</option>
												<option value="2">Inactive</option>
										</select></td>
									</tr>
									<tr>
										<td colspan="4" align="center"><input type="submit"
											value="Save" class="button" /> <a href="Plan.jsp"><input
												type="submit" value="Cancel" class="button" /></a></td>

									</tr>
								</table>
							</c:forEach>
						</form>
						<h2></h2>
					</c:if>
				</div>
				<c:set var="number">1</c:set>
				<table width="100%" align="center" class="tablecontent">
					<tr>
						<th>No.</th>
						<th>Plan</th>
						<th>Duration</th>
						<th>Amount (Rs.)</th>
						<th>Period</th>
						<th>UserRole</th>
						<th>Status</th>
						<th colspan="2">Action</th>
					</tr>
					<c:set var="n" value="1"></c:set>
					<c:forEach var="plan" items="${user.getAllPlanDetail() }">
						<tr>
							<td>${n }</td>
							<td>${plan.getPlan() }</td>
							<td>${plan.getDuration() }</td>
							<td>${plan.getAmount() }</td>
							<td>${plan.getPeriod() }</td>
							<td>${plan.getRole_name() }</td>
							<td>${plan.getStatus() }</td>
							<td><a href="Plan.jsp?id=${plan.getPlan_id() }">EDIT</a></td>
							<td><a href="../delete.plan?id=${plan.getPlan_id() }">DELETE</a></td>

						</tr>
						<c:set var="n" value="${n+1 }"></c:set>
					</c:forEach>
				</table>

			</div>
		</div>
		<br />
		<%-- <div class="sidebar">
        <div class="gadget">
          <!-- h2 class="star"><span class="side_header">Sidebar Menu</span></h2>
          <div class="clr"></div-->
          <ul class="sb_menu">
          <div id="my_sidebar">
            <li><a href="/HealthOnlineProject/HomePage.jsp">Home</a></li>
            <li><a href="/HealthOnlineProject/jsp/RegistrationPlan.jsp">Registration</a></li>
            <li><a href="/HealthOnlineProject/jsp/AvailableDoctors.jsp">Available Doctors</a></li>
            <li><a href="/HealthOnlineProject/jsp/HealthGuideline.jsp">Health Guideline</a></li>
            
            </div>
          </ul>
        </div>
		<div class="gadget">
          <h2 class="star"><span class="side_header">NEWS</span></h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <marquee onmouseover="stop()" onmouseout="start()" direction="up">
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmm jhu h houi yaa chandan</li>
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmmmmmmmmmlmo</li>
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmmmmmmmmmlmo</li>
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmmmmmmmmmlmo</li>
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmmmmmmmmmlmo</li>
           <li>Welome tojkhgyuhgicuv jhhjjh gplk,omlmmmmmmmmmmmmmmmmlmo</li>
           
            </marquee>
          </ul>
        </div>
          <div class="gadget">
          <h2 class="star"><span  class="side_header">Find Hospital</span></h2>
          <div class="clr"></div>
          <!-- ul class="sb_menu">
            <li>Rutvij</li>
            <li>Manisha</li>
            <li>Chandan</li>
            <li class="spec"><a href="#" class="rm" >See all &raquo;</a></li>
          </ul-->
          <a href="http://maps.google.co.in/maps?bav=on.2,or.r_qf.&bvm=bv.60444564,d.bmk,pv.xjs.s.en_US.j4JTBSG9WkM.O&biw=1366&bih=610&dpr=1&um=1&ie=UTF-8&q=find+nearest+hospital+google+maps&fb=1&gl=in&hq=hospital&hnear=0x395e848aba5bd449:0x4fcedd11614f6516,Ahmedabad,+Gujarat&sa=X&ei=eIbqUvLoEcjJrAewt4DgAQ&ved=0CJUBELYD" target="_blank">
          <img src="/HealthOnlineProject/images/map.jpg" width="220px"></img>
          </a>
        </div>
        <div class="gadget">
          <h2 class="star" ><span  class="side_header">KNow your bmi</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
	          <form method="get">  
	            <center> <table>
	             <tr>
	             	<td>Height:&nbsp;&nbsp;&nbsp; </td><td><input type="text" name="ht"size="10"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>cm</td>
	             </tr><tr>
	             <td>Weight:&nbsp;&nbsp;&nbsp;</td><td><input type="text" name="wt" size="10" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>kg</td>
	             </tr>
	             
	             	
	            </table></center><br/><center><td colspan="2" align="center"><input type="submit" value="search" class="button"/></center>
	          </form> <br/>
	          <%
		          	String ht=request.getParameter("ht");
		          	String wt=request.getParameter("wt");
					if(ht!=null && wt!=null && ht!="" && wt!=""){
						double h =Double.parseDouble(ht);
			          	double w =Double.parseDouble(wt);
		          		h/=100;
		          		double bmi=w/(h*h);
	          %>
	          BMI : <%=bmi %>
	          <br />
	          <%
	            String msg="";
	          	if(bmi<18) msg+="You are thin";
	          	else if(bmi>=18 && bmi<=24) msg+="You are normal";
	          	else msg+="You are fat";
	          	%>
	          	<%=msg %>
				<%} %>
          </ul>
        </div>
      </div> --%>
		<div class="clr"></div>
	</div>
</div>
<%-- <c:choose>
	<c:when test="${sessionScope.role==1 }">
		<jsp:include page="AdminSidebar.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==2 }">
		<jsp:include page="DoctorSidebar.jsp"></jsp:include> 
	</c:when>
	<c:when test="${sessionScope.role==3 }">
		<jsp:include page="PatientSidebar.jsp"></jsp:include> 
	</c:when>
	<c:otherwise>
		<jsp:include page="Sidebar.jsp"></jsp:include> 
	</c:otherwise>
</c:choose> --%>
<jsp:include page="Footer.jsp"></jsp:include>