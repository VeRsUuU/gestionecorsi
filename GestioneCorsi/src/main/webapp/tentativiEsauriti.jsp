<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN/bootstrap4CDN.html" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Accesso negato!</title>
</head>
<body>
	<jsp:include page="pageformat/nav.jsp"/>
	<div class="container" style="background-color: #FFBABA; color: red; border: 1px solid; padding: 20px 10px 15px 20px; background-repeat: no-repeat; background-position: 10px center;">
		<div class="page-header">
			<h3>Hai esaurito i tentativi di accesso.</h3>
			<br>
		</div>
		<div class="page-body">
			<%
				int err;
			%>
			<h4 style="padding-top: 10px;">Riavvia il browser oppure <a href="index.jsp?param=<%=err=0%>">torna alla schermata di accesso</a></h4>
		</div>
	</div>
	<%@include file="pageformat/footer.html"%>
</body>
</html>