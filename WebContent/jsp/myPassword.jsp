<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send me password</title>
<style type="text/css">
</style>
</head>
<body style="background-image:url(../images/bg.png);">
	<div align="center" style="margin:280px 500px;background-color: black;color:white;display: block;width: 400px;height: 120px;">
		<fieldset  align="center"  >
			<legend >Fill Detail</legend>
			<form method="post" action="../mail.me">
				Email &nbsp;&nbsp;:<input type="text" name="email"><br />
				Mobile :<input type="text" name="mobile"><br />
				<input type="submit" value="send me">
			</form>
		</fieldset>
	</div>
</body>
</html>