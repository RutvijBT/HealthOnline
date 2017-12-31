<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:useBean id="object" class="userdata.Questions"></jsp:useBean>
<jsp:useBean id="User" class="userdata.User"></jsp:useBean>
<div class="content">
	<div class="content_resize">
		<div class="AdminMainbar">
		<%
		Questions q=new Questions();
		User u=new User();
	ArrayList<QuestionBean> list= q.getAllUnansweredQuestion() ;
	ArrayList<QuestionBean> list1= q.getAllAnsweredQuestion() ;
	request.setAttribute("list",list);
	request.setAttribute("list1",list1);
		%>
			<c:forEach var="question1"
				items="${list }">
				<div class="article">
					<h2>${question1.question }
						<span style="font-size: 10px; color: #1A1A44">[<a
							href="../delete.question?id=${question1.question_id }">DELETE</a>]
						</span>
					</h2>
					Posted on <span class="date">${question1.date }</span> by
					${question1.name }
					<div class="clr"></div>
				</div>
			</c:forEach>


			<c:set var="n" value="1"></c:set>
			<c:forEach var="question" items="${list1}">
				<div class="article">
					<h2>${question.question}
						<span style="font-size: 10px; color: #1A1A44">[<a
							href="../delete.question?id=${question.question_id }">DELETE</a>]
						</span> <img alt="" src="../images/arrow.jpg" align="right"
							id="slide${n }"></img>
					</h2>
					Posted on <span class="date">${question.date }</span> by
					${question.name }
					<div class="clr"></div>
					 <c:set var="qid" value="${question.question_id }"></c:set>
		 <%
		      ArrayList<AnswerBean> list2;
		      
		      //System.out.println("ggggggggggggg"+pageContext.getAttribute("qid"));
		      
		      int qId=(Integer)pageContext.getAttribute("qid");
		      
		      list2=q.getAnswer(qId);
				request.setAttribute("list2", list2);
				
		 %>
					<div id="answer${n }">
						<c:forEach var="ans"
							items="${list2}">
							<div class="post_content">
								<p>${ans.answer }</p>
								<p class="infopost">
									Posted on <span class="date">${ans.date }</span> by
									${ans.name } <a
										href="../delete.question?id=${ans.answer_id }"><button>Delete</button></a>
									<a href="#" class="com"><span>${ans.like}</span></a>
								</p>
							</div>
							<div class="clr"></div>
						</c:forEach>
					</div>
				</div>
				<c:set var="n" value="${n+1 }"></c:set><br/>
			</c:forEach>
		</div>
		<!-- delete -->
	</div>
	<div class="clr"></div>
</div>
</div>
<%-- <jsp:include page="DoctorSidebar.jsp"></jsp:include> --%>
<jsp:include page="Footer.jsp"></jsp:include>