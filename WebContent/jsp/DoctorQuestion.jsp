<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
      	<jsp:useBean id="object" class="userdata.Questions"></jsp:useBean>
		<jsp:useBean id="User" class="userdata.User"></jsp:useBean>
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
		<c:choose>
			<c:when test="${param.category==null }">
				<c:set value="1" var="category"></c:set>
			</c:when>
			<c:otherwise>
				<c:set value="${param.category }" var="category"></c:set>
			</c:otherwise>
		</c:choose>
		<c:set var="i">1</c:set>
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
		 <c:forEach var="question" items="${s1 }">
			<div class="article">
	          <h2>${question.question }</h2>
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
		          	<div class="post_content">
		          		 <p>${ans.answer }</p>
		          		 <p class="infopost">Posted on <span class="date">${ans.date}</span> by ${ans.name}
		          		 	<%-- <c:if test="${ans.getUser_id()==sessionScope.user_id }">
		          		 	<a href="../delete.question?id=${ans.getAnswer_id() }"><button>Delete</button></a></c:if>
		          		 	<a href="#" class="com"><span>${ans.getLike() }</span></a>
		          		 <c:choose>
		          		 	<c:when test="${object.isAnswereLiked(sessionScope.user_id,ans.getAnswer_id()) }">
		          		 		<a href="../unlike.it?id=${ans.getAnswer_id() }" ><button>Unlike</button></a>
		          		 	</c:when>
		          		 	<c:otherwise>
		          		 		<a href="../like.it?id=${ans.getAnswer_id() }" ><button>Like</button></a>
		          		 	</c:otherwise>
		          		 </c:choose> --%>
		          		 
		          		<c:if test="${ans.user_id==sessionScope.user_id }">
		          		 	<a href="/HealthOnlineProject/delete.question?id=${ans.answer_id }"><span style="background-color:#0055FF;color:white">DELETE</span></a></c:if>
		          		 	<a href="#" class="com"><span>${ans.getLike() }</span></a>
		          		 <c:set var="aid" value="${ans.answer_id }"></c:set>
		          		 <%-- <c:set var="user_id" value="sessionScope.user_id"></c:set> --%>
		          		 <%
		          		int aId=(Integer)(pageContext.getAttribute("aid")); 
		          		
		          		int uId=(Integer)session.getAttribute("user_id");
		          		
		          		 boolean b;
		          		 b=q.isAnswereLiked(uId,aId);
		          		 request.setAttribute("b",b);
		          		 %>
		          		 <c:choose>
		          		 
		          		 	<c:when test="${b}">
		          		 		<a href="../unlike.it?id=${ans.answer_id }" style="background-color:#0055FF;color:white">UNLIKE</a>
		          		 	</c:when>
		          		 	<c:otherwise>
		          		 		<a href="/HealthOnlineProject/like.it?id=${ans.answer_id }" style="background-color:#0055FF;color:white">LIKE</a>
		          		 	</c:otherwise>
		          		 </c:choose> 
		          		 
		          	</div>
		          	
		          		 </p>
		          	</div>
		         <div class="clr"></div>
		     </c:forEach>  
		  <%--     <button align="right" id="post_button${i }">POST YOUR ANSWER</button>
		          		<div class="clr"></div>
		         	<div class="post_content" id="post_ans${i }" hidden>
		         	<form method="post" action="../post.answer">
						<input type="text" name="question_id"value="${question.getQuestion_id() }" hidden/>
						<textarea rows="4" cols="70" name="answer" placeholder="Type your answer here..."></textarea><br />
		            	<input type="submit" value="Post" class="button"/>
				 	</form>
				 	</div>
	        </div>
	        <c:set var="i" value="${i+1 }"></c:set> --%>
	           <button align="right" id="post_button${que.question_id }">POST YOUR ANSWER</button>
		          		<div class="clr"></div>
		         	<div class="post_content" id="post_ans${que.question_id }" hidden>
		         		<form method="get" action="/HealthOnlineProject/post.answer?id=${que.question_id }">
		         				<input type="text" name="id"value="${que.question_id }" hidden/>
		         		
		         		         		
								<textarea rows="4" cols="70" placeholder="Type your answer here..." name=answer></textarea><br />
		          			 	 <input type="submit" value="Post" class="button"/>
					 	</form>
				 	</div></div>
        </c:forEach> 
      </div> 
<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>