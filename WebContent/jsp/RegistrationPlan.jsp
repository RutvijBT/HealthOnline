<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="GuestHeader.jsp" />
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Registration Plan</span> for Doctors</h2>
           <div class="clr"></div>
          
          <div class="post_content"><center>
            <table width="90%" border="1" class="tablecontent"><tr>
            <th width="40">No</th><th width="103">Plan Name</th><th width="79">Duration</th><th width="76">Amount</th>
            </tr>
            <jsp:useBean id="User" class="userdata.User"></jsp:useBean>
            <c:set var="number">1</c:set>
            <c:forEach var="p" items="${s1}">
            	<tr>
            		<td>${number }</td>
            		<td>${p.plan }</td>
            		<td>${p.duration }</td>
            		<td>${p.amount}</td>
            	</tr>
            	<c:set var="number" value="${number+1 }"></c:set>
            
            </c:forEach>
            </table>
            </center>
          </div>
          <div class="clr"></div>
        </div>
        <div class="article">
          <h2><span>Registration Plan</span> for Patients</h2>
          <div class="clr"></div>
          
          <div class="post_content">
            <center>
            <table width="90%" border="1" class="tablecontent"><tr>
            <th width="40">No</th><th width="103">Plan Name</th><th width="79">Duration</th><th width="76">Amount</th></tr>
             <c:set var="number">1</c:set>
            <c:forEach var="plan" items="${s2 }">
            	<tr>
            		<td>${number }</td>
            		<td>${plan.plan}</td>
            		<td>${plan.duration}</td>
            		<td>${plan.amount}</td>
            	</tr>
            	<c:set var="number" value="${number+1 }"></c:set>
            
            </c:forEach>
            </table></center>
          
               <br/><br/>
               <center>
         <p class="spec"><a href="jsp/DoctorRegistration.jsp"><button>Registration As a Doctor</button></a>
         &nbsp; &nbsp; &nbsp; &nbsp;
        <a href="jsp/PatientRegistration.jsp"><button>Registration As a Patient</button></a></p></center>
          </div>
          <div class="clr"></div>
        </div>
        
      </div>
         <jsp:include page="Sidebar.jsp"/>
 
 <jsp:include page="Footer.jsp"/>