<%@taglib uri="HealthOnlineTagLibrary" prefix="HealthOnline" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="PatientHeader.jsp"></jsp:include>

	<div class="content">
    <div class="content_resize">
    <!-- <div class="searchform">
        <form id="formsearch" name="formsearch" method="post" action="#">
          <span>
          <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80" value="Search our ste:" type="text" />
          </span>
          <input name="button_search" src="/HealthOnlineProject/images/search.gif" class="button_search" type="image" />
        </form>
      </div> -->
      <div class="mainbar">
       
       <div class="article">
          <button align="right" id="post_button">POST YOUR QUESTION</button>
          <div class="clr"></div>
         <div class="post_content" id="post_content" hidden>
         <%User user=new User();
			ArrayList<CategoryBean> list = user.getCategory();
			request.setAttribute("s", list);
			%>
         
         <form method="post" action="/HealthOnlineProject/Post.question">
         	Select Category 
         	<select name="category">
				 
				<c:forEach var="cat" items="${s}">
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select><br />
			<textarea rows="4" cols="70" name="question" placeholder="Type your question here..."></textarea><br />
            <input type="submit" value="Post" class="button"/>
		 </form>
		 </div>
          <div class="clr"></div>
        </div>
        
        
		<%
		Questions q=new Questions();
		int pId=(Integer)session.getAttribute("user_id");
		ArrayList<QuestionBean> list1=q.getUnansweredPatientQuestion(pId);
		request.setAttribute("s1", list1);
		ArrayList<QuestionBean> list2= q.getPatientAnsweredQuestion(pId);
		request.setAttribute("s2", list2);
		%>
		<c:forEach var="question" items="${s1 }">
			<div class="article">  
         		 <h2>${question.question} <span style="font-size:10px;color:#1A1A44">[<a href="/HealthOnlineProject/delete.question?id=${question.question_id}">DELETE</a>]</span></h2>
			     <div class="clr"></div>
			</div>
        </c:forEach>
        <c:forEach var="question" items="${s2 }">
			<div class="article">  
         		 <h2><span style="font-size: large; ">${question.question }</span></h2>
			          <div class="clr"></div>
			          <c:set var="qid" value="${question.question_id }"></c:set>
			          <%
			          ArrayList<AnswerBean> list3;
				      
				      System.out.println("ggggggggggggg"+pageContext.getAttribute("qid"));
				      int qId=(Integer)(pageContext.getAttribute("qid")); 
				      
				      list3=q.getAnswer(qId);
						request.setAttribute("s3", list3);
			          %>
			          <div class="post_content">
			         <c:forEach var="ans" items="${s3 }">  
		          		<div class="post_content">
		          		 <p>${ans.answer }</p>
		          		 <p class="infopost">Posted on <span class="date">${ans.date }</span> by <span class="date"> ${ans.name}</span>
		          		 <a href="#" class="com"><span>${ans.like }</span></a>
		          		 <c:set var="aid" value="${ans.answer_id }"></c:set>
		          		 <%
		          		int aId=(Integer)(pageContext.getAttribute("aid")); 
		          		
		          		int uId=(Integer)session.getAttribute("user_id");
		          		
		          		 boolean b;
		          		 b=q.isAnswereLiked(uId,aId);
		          		 request.setAttribute("b",b);
		          		 %>
		          		 <c:choose>
		          		 	<c:when test="${b }">
		          		 		<a class="like" href="/HealthOnlineProject/unlike.it?id=${ans.answer_id }" >UNLIKE</a>
		          		 	</c:when>
		          		 	<c:otherwise>
		          		 		<a  class="like" href="/HealthOnlineProject/like.it?id=${ans.answer_id }" >LIKE</a>
		          		 	</c:otherwise>
		          		 </c:choose>
		          		 </p>
		          		</div>
		         	<div class="clr"></div>
		      	</c:forEach> 
			         	 </div>
			          <div class="clr"></div>
			</div>
        </c:forEach> 
         
      </div>
<jsp:include page="PatientSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>