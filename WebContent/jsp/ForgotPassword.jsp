<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="GuestHeader.jsp" />


<div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Getting Password</span> via Email</h2>
           <div class="clr"></div><br/><br/><center>
<form action="/HealthOnlineProject/mail.me" name="myForm" onsubmit="return validateEmail();">
<table class="profile"><tr>
<td>Email: </td><td><input type="text" name="email" id="mail" required="required"></td></tr>
<tr><td>Mobile No: </td><td><input type="text" name="mobile"  required="required" maxlength="10"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"></td></tr></table>
<br/>
<center><input type="submit" class="button" value="Submit"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" class="button"/></center>

</form></center>
     </div>
        
      </div>
        <jsp:include page="Sidebar.jsp"/>
 
 <jsp:include page="Footer.jsp"/>