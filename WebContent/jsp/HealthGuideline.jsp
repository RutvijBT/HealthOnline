<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="article">
          <h2>Health Guideline</h2>
          <br/><form method="get" action="/HealthOnlineProject/HealthGuideline">
          <center><table cellpadding="8px">
				<tr><td style="color: rgb(36,131,200); font-weight: bold; font-size: medium;">Select Category:</td>
				   <td><select name="category">
				 
				<c:forEach var="cat" items="${s2 }">
					<option value="${cat.category_id }"><c:out value="${cat.category}"  /> </option>
				</c:forEach>
			</select></td><td>
					<input type="submit" value="submit" class="button"></td></tr></table></center></form>
					
          <div class="clr"></div>
        <div class="post_content">
        
        <c:forEach var="a" items="${s}">  
        <div class="article">  <h2></h2>           
            <div style="font-size: 14px;"> <c:out value="${a.guideline}" /> </div>  <br/>       
               
            <p class="infopost" >Posted on <span class="date"><c:out value="${a.date}"  />  
             </span> by <span class="date"> Dr. <c:out value="${a.doctor}"  /> </span>  </p>
          </div>
           </c:forEach>
          
          </div>
        
          <div class="clr"></div>
        </div>
		
		
        
      </div>
