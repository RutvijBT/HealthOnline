<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="DoctorHeader.jsp"></jsp:include>
	
      <div class="clr"></div>
    </div>
  </div>
  <!--Header End -->
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
      <div class="article">
          <h2>Post Health Guideline</h2>
          <div class="clr"></div>
          <br/>
          <button align="right" id="post_button">POST Health Guideline</button>
          <div class="clr"></div>
         <div class="post_content" id="post_content" hidden>
         <form method="post" action="/HealthOnlineProject/HealthGuideline">
         <center><table cellpadding="8px">
				<tr><td style="color: rgb(36,131,200); font-weight: bold; font-size: medium;">Select Category:</td>
				   <td><select name="category">
				 
				<c:forEach var="cat" items="${s2 }">
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select></td></tr></table></center><br/>
			<textarea rows="4" cols="70" placeholder="Type your question here..." name="content" required="required" ></textarea><br />
            <input type="submit" value="Post" class="button"/>
		 </form>
		 </div>
          <div class="clr"></div>
        </div>
        <br/>
		
<jsp:include page="HealthGuideline.jsp"></jsp:include>
<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>