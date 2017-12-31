<%@page import="javaBean.PaymentBean"%>
<%@page import="DAO.Query"%>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.net.ssl.*" %>
<%@ page import="java.net.URLEncoder" %>

<jsp:include page="GuestHeader.jsp"></jsp:include>
<style>
#name span{
	color :#5C07B1;
	font-size: 15px;
}
</style>
<div class="content">
	<div class="content_resize">
		<div class="mainbar">
			<div class="article">
			<h3 style="color: blue;font-size:20px;">Your Payment Detail</h3>
<HR />


<%
if(request.getSession().getAttribute("user_id")==null  || request.getSession().getAttribute("user_id")==""){
//	response.sendRedirect("/HealthOnlineProject/HomePage.jsp");
	 RequestDispatcher rd = request.getRequestDispatcher("/pay.jsp");
		rd.forward(request, response);
}
URL post_url = new URL("https://test.authorize.net/gateway/transact.dll");

Hashtable post_values = new Hashtable();

// the API Login ID and Transaction Key must be replaced with valid values
post_values.put ("x_login", "729Ukz8MSD4");
post_values.put ("x_tran_key", "9Yq28z44HB6QCg8L");

post_values.put ("x_version", "3.1");
post_values.put ("x_delim_data", "TRUE");
post_values.put ("x_delim_char", "|");
post_values.put ("x_relay_response", "FALSE");

post_values.put ("x_type", "AUTH_CAPTURE");
post_values.put ("x_method", "CC");
post_values.put ("x_card_num", "4111111111111111");
post_values.put ("x_exp_date", "0115");

post_values.put ("x_amount", request.getParameter("amount"));
post_values.put ("x_description", "Sample Transaction");

post_values.put ("x_first_name", request.getParameter("firstname"));
post_values.put ("x_last_name", request.getParameter("lastname"));
post_values.put ("x_address", "1234 Street");
post_values.put ("x_state", "WA");
post_values.put ("x_zip", "98004");

StringBuffer post_string = new StringBuffer();
Enumeration keys = post_values.keys();
while( keys.hasMoreElements() ) {
String key = URLEncoder.encode(keys.nextElement().toString(),"UTF-8");
String value = URLEncoder.encode(post_values.get(key).toString(),"UTF-8");
post_string.append(key + "=" + value + "&");
}

// Open a URLConnection to the specified post url
URLConnection connection = post_url.openConnection();
connection.setDoOutput(true);
connection.setUseCaches(false);

// this line is not necessarily required but fixes a bug with some servers
connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

// submit the post_string and close the connection
DataOutputStream requestObject = new DataOutputStream( connection.getOutputStream() );
requestObject.write(post_string.toString().getBytes());
requestObject.flush();
requestObject.close();

// process and read the gateway response
BufferedReader rawResponse = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String line;
String responseData = rawResponse.readLine();
rawResponse.close();	 // no more data

// split the response into an array
String [] responses = responseData.split("\\|");


Iterator iter=Arrays.asList(responses).iterator();
out.println("Dear <span id='name'>"+responses[13]+" "+responses[14]+"</span>");
out.println(" Your transaction proccessed successfully <br /><br /> ");
out.println("Amount : "+responses[9]+"<br /> ");
out.println("<br />Your Transaction id is : "+responses[37]+"<br />");
out.print("<a href='../HomePage.jsp'><button>Continue to Login</button></a>");

//saving data in database
PaymentBean pay=new PaymentBean();
pay.setAmount(Float.parseFloat(responses[9]));
pay.setUserid(Integer.parseInt(session.getAttribute("user_id").toString()));
pay.setTransactionid(responses[37]);

Query query=Query.getInstance();
query.addNewPlan(Integer.parseInt(request.getParameter("planId")), pay);
query.changeStatus(1, Integer.parseInt(session.getAttribute("user_id").toString()));
//query.savePaymentDetail(pay);
 /* out.println("<OL>");
 while(iter.hasNext()){
	
	out.println("<LI>" + iter.next() + "&nbsp;</LI>");
} 
out.println("</OL>"); */
// individual elements of the array could be accessed to read certain response
// fields. For example, response_array[0] would return the Response Code,
// response_array[2] would return the Response Reason Code.
// for a list of response fields, please review the AIM Implementation Guide
%>
</div>
		</div>
		<jsp:include page="Sidebar.jsp"></jsp:include>
		<jsp:include page="Footer.jsp"></jsp:include>