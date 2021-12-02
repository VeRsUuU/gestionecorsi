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
<div class="container">
<div class="page-header">
	<h3>Non puoi accedere a questa pagina</h3>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Risorsa non disponibile</h3>
	</div>
	<div class="panel-body">
		<p>Per accedere alla pagina effettua il login:</p>
		<p><a href="index.jsp">Login >></a>	
	</div>
</div>
</div>
<footer style="position: absolute; height: 25px; bottom: 0px;"><%@include file="pageformat/footer.html" %></footer>
</body>
</html>