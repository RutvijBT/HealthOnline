 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="userdata.User"%>
<%@page import="javaBean.AdminInfo"%>
<%@page import="java.util.List;"%>
 <br/>
<div class="sidebar" onmousemove="sendInfo()">
<%User u=new User();
       
        List<AdminInfo> n;
        n=u.getNews();
        request.setAttribute("n",n);
        %>
        <div class="gadget">
          <!-- h2 class="star"><span class="side_header">Sidebar Menu</span></h2>
          <div class="clr"></div-->
          <ul class="sb_menu">
          <div id="my_sidebar">
            <li><a href="/HealthOnlineProject/HomePage.jsp">Home</a></li>
            <li><a href="/HealthOnlineProject/RegPlan">Registration</a></li>
            <li><a href="/HealthOnlineProject/DoctorList" >Available Doctors</a></li>
            <li><a href="/HealthOnlineProject/HealthGuideline">Health Guideline</a></li>
            
            </div>
          </ul>
        </div>
		<div class="gadget">
          <h2 class="star"><span class="side_header">NEWS</span></h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <marquee onmouseover="stop()" onmouseout="start()" direction="up">
           <c:forEach var="n" items="${ n }">
           <li><img src="/HealthOnlineProject/images/finger_arrow.jpg"/> &nbsp;&nbsp;&nbsp;<c:out value="${n.news }"></c:out> </li>
           </c:forEach>
            </marquee>
          </ul>
        </div>
          <div class="gadget">
          <h2 class="star"><span  class="side_header">Find Hospital</span></h2>
          <div class="clr"></div>
          <!-- ul class="sb_menu">
            <li>Rutvij</li>
            <li>Manisha</li>
            <li>Chandan</li>
            <li class="spec"><a href="#" class="rm" >See all &raquo;</a></li>
          </ul-->
          <a href="http://maps.google.co.in/maps?bav=on.2,or.r_qf.&bvm=bv.60444564,d.bmk,pv.xjs.s.en_US.j4JTBSG9WkM.O&biw=1366&bih=610&dpr=1&um=1&ie=UTF-8&q=find+nearest+hospital+google+maps&fb=1&gl=in&hq=hospital&hnear=0x395e848aba5bd449:0x4fcedd11614f6516,Ahmedabad,+Gujarat&sa=X&ei=eIbqUvLoEcjJrAewt4DgAQ&ved=0CJUBELYD" target="_blank">
          <img src="/HealthOnlineProject/images/map.jpg" width="220px"></img>
          </a>
        </div><script>
var request;
function bmiInfo()
{

var h=document.bmiform.ht.value;
var w=document.bmiform.wt.value;
var bmi;

if(h!=null && w!=null && h!="" && w!=""){

	h/=100;
	 bmi=w/(h*h);
	 
	 }
else{
bmi=0;
}

var url="/HealthOnlineProject/jsp/BMI.jsp?val="+bmi;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getInfo;
request.open("GET",url,true);
request.send();
}
catch(e)
{
alert("Unable to connect to server");
}
}

function getInfo(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('amit').innerHTML=val;
}
}

</script>
        <div class="gadget">
          <h2 class="star" ><span  class="side_header">KNow your bmi</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
          
	          <form name=bmiform>  
	            <center> <table>
	             <tr>
	             	<td>Height:&nbsp;&nbsp;&nbsp; </td><td><input type="text" name="ht"size="10"   required="required"/>cm</td>
	             </tr><tr>
	             <td>Weight:&nbsp;&nbsp;&nbsp;</td><td><input type="text" name="wt" size="10"  required="required"/>kg</td>
	             </tr>
	             
	             	
	            </table></center><br/><center><td colspan="2" align="center"><input type="button" value="search" class="button" onclick="bmiInfo()"/></center>
	          </form> <br/>
	          <span id="amit"> </span>
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>