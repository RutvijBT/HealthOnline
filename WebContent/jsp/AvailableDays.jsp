<%@page import="java.sql.ResultSet"%>

<%@page import="DAO.*"%>
<%
Query query=Query.getInstance();
int v=Integer.parseInt(request.getParameter("v"));
ResultSet res=query.viewShedule(v);

String schedule="";
while(res.next()){
	int i=res.getInt(2);
	
	
	if(res.getInt(2)==1) schedule=" Monday";
	if(res.getInt(3)==1) schedule+=" Tuesday";
	if(res.getInt(4)==1) schedule+=" Wednesday";
	if(res.getInt(5)==1) schedule+=" Thursday";
	if(res.getInt(6)==1) schedule+="  Friday";
	if(res.getInt(7)==1) schedule+="  Saturday";
	if(res.getInt(8)==1) schedule+="  Sunday";
	
}


out.print("Available Days: "+schedule);
%>