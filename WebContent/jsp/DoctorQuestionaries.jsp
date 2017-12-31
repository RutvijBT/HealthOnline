<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="DoctorHeader.jsp"></jsp:include>

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
      	 <div class="article">
      	 <br/>
		<form mehtod="get" action="/HealthOnlineProject/DoctorQues">
			<span style="color: rgb(36,131,200); font-weight: bold; font-size: medium;padding-left:25 px">Search By Category:</span>
			
			<%User user=new User();
			ArrayList<CategoryBean> list = user.getCategory();
			request.setAttribute("s", list);
			%>
			<select name="category">
				<c:forEach var="cat" items="${s }">
					<option value="${cat.category_id }">${cat.category }</option>
				</c:forEach>
			</select>
			<input type="submit" value="SEARCH"/>
		</form>
	
		<div class="clr"></div>
        </div>
		<%
		  String cId=(request.getParameter("val"));
		int cat;
		System.out.println(cId);
		if(cId==null)
			 cat=1;
		else{
			cat=Integer.parseInt(cId); 
		}
		Questions q=new Questions();
		ArrayList<QuestionBean> list1 = q.getCategoryQuestion(cat);
		request.setAttribute("s1", list1);
		%>
		<div class="article">
		<c:set var="i" >1</c:set>
		 <c:forEach var="question" items="${s1 }">
			
	          <h2><span style="font-size: large; ;">${question.question }</span></h2>
		      <div class="clr"></div>
		      <c:set var="qid" value="${question.question_id }"></c:set>
		 <%
		      ArrayList<AnswerBean> list2;
		      
		      System.out.println("ggggggggggggg"+pageContext.getAttribute("qid"));
		      int qId=(Integer)(pageContext.getAttribute("qid")); 
		      
		      list2=q.getAnswer(qId);
				request.setAttribute("s2", list2);
				
		 %>
			     <c:forEach var="ans" items="${s2 }">  
			     <c:set var="aid" value="${ans.answer_id }"></c:set>
		          	<div class="post_content">
		          		 <p>${ans.answer }</p>
		          		 <p class="infopost">Posted on <span class="date">${ans.date}</span> by<span class="date"> 
		          		 
		          		 
		          		 <c:choose>
									<c:when test="${ans.user_id==sessionScope.user_id }">
		          		 		You
		          		 		<a href="/HealthOnlineProject/delete.question?id=${ans.answer_id }">
		          		 	<span class="like">DELETE</span></a>
									</c:when>
									<c:otherwise>
		          		 		${ans.name }
		          		 		<%
		          		 		System.out.println("ggggggggggggg"+pageContext.getAttribute("aid"));
		          		      int aId=(Integer)(pageContext.getAttribute("aid")); 
		          		      
		          		 		int uid=(Integer)session.getAttribute("user_id");
		          		 		Boolean b=q.isAnswereReported(uid,aId);
		          		 		request.setAttribute("b",b);
		          		 		%>
		          		 		<c:if
											test="${b}">
											<a href="/HealthOnlineProject/report.it?id=${ans.answer_id }">REPORT
												TO ADMIN</a>
										</c:if>
									</c:otherwise>
								</c:choose>
		          		 
		          		 
		          		 
		          		 <a href="#" class="com"> <span >${ans.like }</span></a>
		          		 <c:set var="aid" value="${ans.answer_id }"></c:set>
		          		 <%
		          		int aId=(Integer)(pageContext.getAttribute("aid")); 
		          		
		          		int uId=(Integer)session.getAttribute("user_id");
		          		
		          		 boolean b;
		          		 b=q.isAnswereLiked(uId,aId);
		          		 request.setAttribute("b",b);
		          		 %>
		          		 <c:choose>
		          		 
		          		 	<c:when test="${b}">
		          		 		<a href="/HealthOnlineProject/unlike.it?id=${ans.answer_id }" class="like">UNLIKE</a>
		          		 	</c:when>
		          		 	<c:otherwise>
		          		 		<a href="/HealthOnlineProject/like.it?id=${ans.answer_id }" class="like">LIKE</a>
		          		 	</c:otherwise>
		          		 </c:choose> </p>
		          		 
		          	</div>
		          	</c:forEach>
		          	       	
		     <div class="clr"></div>
		  <br/>
	           <button align="right" id="post_button${i}">POST YOUR ANSWER</button>
		          		<div class="clr"></div>
		         	<div class="post_content" id="post_ans${i }" hidden>
		         		<form method="get" action="/HealthOnlineProject/post.answer?id=${question.question_id }">
		         			<input type="text" name="id"value="${question.question_id }" hidden/>
		         		
		         		         		
							<textarea rows="4" cols="70" placeholder="Type your answer here..." name=answer></textarea><br />
		          			<input type="submit" value="Post" class="button"/>
					 	</form>
				 	</div>
				 	<c:set var="i" value="${i+1}"></c:set><br/><br/>
        </c:forEach> 
        <div class="clr"></div>
        </div>
		         <div class="clr"></div>
      </div> 
<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>