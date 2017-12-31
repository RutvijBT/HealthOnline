<%@ page %>
<%
float bmi=Float.parseFloat(request.getParameter("val"));

if(bmi==0){
	out.print("please enter height or weight");

}
else{
	String msg="";
  	if(bmi<18) msg+="You are thin";
  	else if(bmi>=18 && bmi<=24) msg+="You are normal";
  	else msg+="You are fat";
  	out.println("BMI: "+bmi);
  	out.print("<br/>");
  	out.print(msg);
} 	

%>