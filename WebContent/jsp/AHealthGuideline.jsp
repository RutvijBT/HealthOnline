
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div class="content">
    <div class="content_resize">
      <div class="mainbar">
       <div class="article">
         <h2>Health Guideline</h2>
          <br/><br/><form method="get" action="/HealthOnlineProject/AHealthGuideline">
          <center><table cellpadding="8px">
				<tr><td style="color: rgb(36,131,200); font-weight: bold; font-size: medium;">Select Category:</td>
				   <td><select name="category">
				 
				<c:forEach var="cat" items="${s2 }">
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select></td><td>
					<input type="submit" value="submit" class="button"></td></tr></table></center></form>
					
          <div class="clr"></div><br/>
        <div class="post_content">
        <c:forEach var="a" items="${s}">               
            <div style="font-size: 14px;"> <c:out value="${a.guideline}" /> </div>         
               
            <p class="infopost" >Posted on <span class="date"><c:out value="${a.date}"  />  
             </span> by Dr.<c:out value="${a.doctor}"  />  about <c:out value="${a.category}"  />   </p>
          
        
					<a href="/HealthOnlineProject/DeleteHealthGuideline?id=${a.healthguideline_id}"><span style="background-color:#0055FF;color:white">DELETE</span></a>
					
          <br/><br/>
           </c:forEach>
          
          </div>
        
          <div class="clr"></div>
			          <div class="clr"></div>
		  </div>
		
      </div>
<jsp:include page="AdminSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>