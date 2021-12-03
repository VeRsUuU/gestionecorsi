<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN/bootstrap4CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso Negato!</title>
</head>
<body>
<jsp:include page="pageformat/nav.jsp"/>
<div class="container" style="background-color: #FFBABA; color: red; border: 1px solid; padding: 20px 10px 15px 20px; background-repeat: no-repeat; background-position: 10px center;">
	<div class="page-header">
		<h3>Area riservata.</h3>
		<br>
	</div>
	<div class="page-body">
		<h4>Per accedere alla pagina effettua il <a href="index.jsp">login</a></h4>
	</div>
</div>
<%@include file="pageformat/footer.html"%>
</body>
</html>