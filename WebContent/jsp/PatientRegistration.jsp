<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="userdata.*"%>
<%@page import="javaBean.*"%>
<jsp:include page="GuestHeader.jsp" />
 <script type="text/javascript">
 function checkEmail()
 {
   var xmlhttp;
   var config=document.getElementById('email').value;
   var url="/HealthOnlineProject/isEmailExist?id="+config;
  // var InputValue = Element.value ;
	var Pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;/*/^[\w\.]+@\w+\.\w+$/;*/
	answer = Pattern.test(config);
	if(!answer)
	{
		document.getElementById("emailAlert").innerHTML=config+ "is invalid Email";
		document.getElementById('email').value="";
	}
	else{
	   if (window.XMLHttpRequest)
	   {
	       xmlhttp=new XMLHttpRequest();
	   }
	   else
	   {
	       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	   }
	   xmlhttp.onreadystatechange=function()
	   {
	       if (xmlhttp.readyState==4 && xmlhttp.status==200)
	       {
	           document.getElementById("emailAlert").innerHTML=xmlhttp.responseText;
	           if(xmlhttp.responseText.length!=0){
	        	   document.getElementById('email').value="";
	           }
	       }
	   }
	
	   xmlhttp.open("GET", url, true);
	   xmlhttp.send();
	}
}
</script>     
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2>Registration form</h2>
          <div class="clr"></div>
          <div class="post_content"><br/>
           <form action="../register" name="myForm" method="post" onsubmit="return validateEmail()">
           <center><fieldset style="border-color: rgb(180,180,180); border-style:double; "><legend id="legend"><b>Personal Detail</b></legend>
<table align="center" class="plain_text" >
<input type="text" name="role" value="patient" hidden/>
<br/>
<tr><td>First Name</td>
<td><input type="text" name="fname" size="30px" class="txt" required="required"></td></tr>
<tr>
<td>Middle Name</td>
<td><input type="text" name="mname" class="txt" size="30px" required="required"></td></tr>
<tr><td>Last Name</td>
<td><input type="text" name="lname" class="txt" size="30px"></td></tr>
<tr><td valign="top">Address</td>
<td><textarea name="address" cols="24" rows="4" class="txt" required="required"></textarea></td></tr>
<tr><td>city</td>
<td><input type="text" name="city" class="txt" size="30px" required="required"></td></tr>

<tr><td>State</td>
<td><input type="text" name="state" class="txt" size="30px" required="required"></td></tr>
<tr>
<tr><td width="150px">mobile</td>
<td><input type="text" name="mobile" class="txt" size="30px" id="num" required="required" maxlength="10"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"></td></tr>
<tr>
<td>Gender</td>
<td class="radio"><input type="radio" name="gen" value="M" size="30px" required="required">M
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="gen" value="F" size="30px">F

</td></tr>
<tr><td>Date of Birth<span class="date"><br />(mm / dd / yyyy)</span></td>
<td><input type="date" name="bdate" class="txt" size="10" placeholder=" yyyy / mm / dd" required="required"></td></tr>

<tr><td>Blood Group</td>
<td><select name="bgroup" class="txt" required="required">

<option value="A+"  >A+ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<option value="A-" >A-</option>
<option value="B+" >B+</option>
<option value="B-" >B-</option>
<option value="AB+" >AB+</option>
<option value="AB-" >AB-</option>
<option value="O+" >O+</option>
<option value="O-" >O-</option>
</select>
</td></tr>
</tr>
<tr><td>Category<span class="date"></span></td>
<jsp:useBean id="User" class="userdata.User"></jsp:useBean>
					<td><select name="category" class="txt" >
						<c:forEach var="cat" items="${User.getCategory() }">
							<option value="${cat.getCategory_id() }">${cat.getCategory() }&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
						</c:forEach>
					</select></td>
</tr></table></fieldset></center><br/>
<center><fieldset style="border-color: rgb(180,180,180); border-style:double; "><legend id="legend"><b>Login Detail</b></legend>
<table align="center" class="plain_text" >
<tr><td width="150px">Email Id &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
<td><input type="text" name="email" id="email"
									onblur="checkEmail()"		class="txt" size="30px" required="required"><br />
										<span id="emailAlert" style="color: red"></span></td></tr>
<tr><td>Password</td>
<td><input type="password" name="password" size="30px" class="txt" required="required"></td></tr>
</table>
</fieldset></center><br>
<center><input type="submit" value="Submit" class="button" > <input type="reset" value="Reset" class="button"></center>
</form>
          </div>
          <div class="clr"></div>
        </div>
  </div>
   <jsp:include page="Sidebar.jsp"/>
 
 <jsp:include page="Footer.jsp"/>