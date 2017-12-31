<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	<!-- <FORM ENCTYPE="multipart/form-data" ACTION="../file" METHOD="post"> -->
	<FORM ENCTYPE="multipart/form-data" ACTION="upload.jsp" METHOD="post">
		<br> <br> <br>
		<center>
			<table border="0" bgcolor=#E1E1E1>
				<tr>
					<center>
						<td colspan="2" align="center"><B>UPLOAD THE CERTIFICATE
								FILE</B>
					</center>
				</tr>
				<tr>
					<td colspan="2" align="center">&nbsp;</td>
				</tr>
				<tr>
					<td><b></b></td>
					<td><input name="file" type="file" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save File"></td>
				</tr>
			</table>
		</center>
	</FORM>
</body>
</html>