<%@page import="com.milano.architecture.dbaccess.DBAccess"%>
<%@page import="com.milano.architecture.dao.CorsistaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main-style.css">
<%@include file="CDN/bootstrap4CDN.html"%>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="pageformat/nav.jsp"/>

<%
CorsistaDAO a=new CorsistaDAO();
Integer tot=a.getot(DBAccess.getConnection());
%>
<p>numero totali corsisti <%= tot %></p>













<%@include file="pageformat/footer.html"%>
</body>
</html>