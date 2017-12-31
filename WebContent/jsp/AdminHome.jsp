
<jsp:include page="/ViewPendingReq" flush="true"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="servlet.ViewPendingReq"%>
<%@page import="javaBean.AdminInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaBean.Register"%>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:useBean id="link" scope="application" class="userdata.Admin" />
<div class="content">
	<div class="content_resize">
		<div class="AdminMainbar">
		
		
		
		<div class="article">
			<h2 align="center">Reported Answers</h2>
				<% 
		       ArrayList<AdminInfo> list3=link.GetReportedCoontent();
						for(AdminInfo object: list3) {%>
				
				<h2><%=object.getQue()%></h2>
				<div class="clr"></div>
				<div class="post_content">

					<p>
						<%= object.getReported_ans() %></p>
					<a href="../DeleteReportedAns?id1=<%=object.getAns_id() %>"  align="center"><button>Delete</button></a>
                    <a href="../NoAction?id1=<%=object.getAns_id() %>"  align="center"><button>Cancel</button></a>
					<% }%>
				</div>
				<div class="clr"></div>
			</div>
			<!--  <h2 align="center">
					<span>Reported </span>Answers
				</h2>
				<div class="clr"></div>

				<div class="post_content">
					<center>
						<table width="100%" align="center" class="tablecontent">
							<tr>
								<th width="10">No</th>
								<th width="103">Answer</th>
								<th width="103">Question</th>
								<th width="65">Action</th>
							</tr>
							<%-- <% int j=1;
		       ArrayList<AdminInfo> list2=link.GetReportedCoontent();
						for(AdminInfo object: list2) {%> --%>

							<%-- <tr>
								<td><%= j %></td>
								<td><%= object.getReported_ans() %></td>
								<td><%=object.getQue() %></td>
								<td><a
									href="../DeleteReportedAns?id1=<%=object.getAns_id() %>"><button>Delete</button></a></td>

							</tr>
							<% }%> --%>


						</table>
					</center>
				</div>
				<div class="clr"></div>
			</div> -->
		
		
		
			<div class="article">
				<h2 align="center">
					<span>Pending </span>Doctor Requests
				</h2>
				<div class="clr"></div>

				<div class="post_content">
					<center>
						<table width="100%" align="center" class="tablecontent">
							<tr>
								<th width="70">Doctor Name</th>
								<th width="103">Certificate NO.</th>
								<th width="79">Certificate File</th>
								<th width="79">Authority Name</th>
								<th width="76">Action</th>
							</tr>
							<% ArrayList<Register>list=(ArrayList<Register>)request.getAttribute("List");
				for(int i = 0; i < list.size(); i++) {Register d1=list.get(i);%>
							<tr>
								<td><%= d1.getName() %></td>
								<td><%= d1.getCertificateNumber() %></td>
								<td><a href="D:/study/Adv Java/HealthOnlineProject/files/<%= d1.getCertificateFile() %>"> <%= d1.getCertificateFile() %> </a></td>
								<td><%= d1.getAuthority() %></td>
								<td><a href="../ConfirmReq?id=<%=d1.getUserid() %>"><button>Confirm</button></a></td>

							</tr>
							<% }%>
						</table>
					</center>
				</div>
				<div class="clr"></div>
			</div>
			<div class="article">
				

				<div id="update_plan">
					<c:if test="${param.id!=null }">
						<h2>Update News</h2>
						<form action="../UpdateNEWS" method="post">
							<input type="text" name="news_id" value="${param.id }"
								hidden="hidden" /> <input type="text" name="operation"
								value="update" hidden="Hidden" />
							<%-- <c:forEach var="news" items="<%=link.GetNewsById(Integer.parseInt(request.getParameter(\"id\"))) %>">
							 --%>	<table align="center">
							<%--  <%=Integer.parseInt(request.getParameter("id")) %> --%>
									<% ArrayList<AdminInfo> list1=link.GetNewsById(Integer.parseInt(request.getParameter("id")));
						for(AdminInfo object: list1) {%>
									<tr>
										<td>News:</td>
										<td><textarea name="news" cols="46" rows="2"
												 class="txt"
												required="required"><%=object.getNews() %></textarea></td>
									</tr>
									<% }%>
									<tr>
										<td colspan="2" align="center"><input type="submit"
											value="Save" class="button" /> <input type="button"
											value="Cancel" id="new_plan_cancel" class="button" /></td>
									</tr>
									
								</table>

							<%-- </c:forEach> --%>
						</form>
						<h2></h2>
					</c:if>
				</div>

<br/>
				<h2 align="center">
					<span>NEWS</span>
				</h2>
				<input type="button" id="new_plan_click" value="ADD NEWS" class="button"
					style=" font-weight: bold;" />
				<div id="newPlan" hidden>
					<h3 align="center">EnterNews</h3>
					<form action="../InsertNEWS" method="post">
						<input type="text" name="operation" value="insert" hidden="Hidden" />
						<table align="center">
							<tr>
								<td>News:</td>
								<td><textarea name="news" cols="46" rows="2" class="txt"
										required="required"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Save" class="button" /> <input type="button"
									value="Cancel" id="new_plan_cancel" class="button" /></td>
							</tr>
						</table>
					</form>
				</div>
				<table width="100%" align="center" class="tablecontent">
					<tr>
						<th>No.</th>
						<th>NEWS</th>
						<th colspan="2">Action</th>
					</tr>

					<% int i=1;
		       ArrayList<AdminInfo> list1=link.GetNews();
						for(AdminInfo object: list1) {%>
					<tr>
						<td><%= i%></td>
						<td><%=object.getNews() %></td>
						<td><a href="AdminHome.jsp?id=<%=object.getNewsId()%>">&nbsp;&nbsp;&nbsp;EDIT&nbsp;&nbsp;&nbsp; </a>
						</td>
						<td><a href="../DeleteNEWS?id=<%=object.getNewsId()%>">DELETE</a></td>
					</tr>
					<%i++; } %>
				</table>

			</div>
		</div>
		<div class="clr"></div>
	</div>
</div>


<jsp:include page="Footer.jsp" />