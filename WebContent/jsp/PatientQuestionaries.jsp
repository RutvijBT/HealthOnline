<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="PatientHeader.jsp"></jsp:include>
 
  <!--Header End -->
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <jsp:useBean id="object" class="userdata.Questions"></jsp:useBean>
		<jsp:useBean id="User" class="userdata.User"></jsp:useBean>
		 <div class="article">
		<%User user=new User();
			ArrayList<CategoryBean> list = user.getCategory();
			request.setAttribute("s", list);
			%>
			<form mehtod="get" action="/HealthOnlineProject/DoctorQues">
			<span style="color: rgb(36,131,200); font-weight: bold; font-size: medium;padding-left:25 px">Search By Category:</span>
			
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
		      <c:forEach var="ans" items="${s2}">  
		          	<div class="post_content">
		          		 <p>${ans.answer}</p>
		          		 <p class="infopost">Posted on <span class="date">${ans.date }</span> by <span class="date">${ans.name}</span>
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
		          		 	<c:when test="${b}">
		          		 		<a href="/HealthOnlineProject/unlike.it?id=${ans.answer_id} " style="background-color:#0055FF;color:white">UNLIKE</a>
		          		 	</c:when>
		          		 	<c:otherwise>
		          		 		<a href="/HealthOnlineProject/like.it?id=${ans.answer_id } " style="background-color:#0055FF;color:white">LIKE</a>
		          		 	</c:otherwise>
		          		 </c:choose>
		          		 </p>
		          	
		         <div class="clr"></div></div>
		      </c:forEach> 
	       
        </c:forEach>
         
      </div>
	  </div>
<jsp:include page="PatientSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>