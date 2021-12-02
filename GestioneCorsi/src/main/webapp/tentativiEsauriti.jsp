<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi tentativi sono esauriti</title>
</head>
<body>
	<div style="padding: 20px 15px 15px 20px;">
		
		<%
			int err;
		%>
		<h1>sei su questa pagina perchè hai finito i tuoi tentativi di accesso.</h1>
		<h2 style="padding-top: 10px;">per riprovare<a href="index.jsp?param=<%=err=0%>"> clicca qui</a></h2>
		
	</div>

</body></html>