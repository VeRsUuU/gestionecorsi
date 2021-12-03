<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%

Cookie[] cookies = request.getCookies();

for(Cookie aCookie : cookies) {
	if(aCookie.getName().equals("username")) {
		System.out.println("cookie esiste");
		if(aCookie.getValue() != null)
			session.setAttribute("username", aCookie.getValue());
			System.out.println("username impostato dal cookie" + aCookie.getValue());
	}
}

String admin = (String) session.getAttribute("username");
if (admin != null) {
	
%>

<!DOCTYPE html>
<html>

<head>
<%@include file="CDN/bootstrap4CDN.html"%>
<link rel="stylesheet" href="css/main-style.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="pageformat/nav.jsp" />
	<div class="container" style="align: center;">
		<br> <br>
		<div class="page-header">
			<h2 align="center">Dati amministratore</h2>
		</div>

		<!-- AMMINISTRATORE -->
		<table class="table table-striped">
			<thead align="center">
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
				</tr>
			</thead>
			<tbody align="center">
				<%
				if(session.getAttribute("username") != null) {
					String username = (String) session.getAttribute("username");
					Admin amministratore = AdminFacade.getIstance().getByIdUsername(username);
				%>
				<tr>
					<th scope="row"><%=amministratore.getUsername()%></th>
					<td><%=amministratore.getNomeAdmin()%></td>
					<td><%=amministratore.getCognomeAdmin()%></td>
				</tr>
				<%
				
					}
				
				%>
			</tbody>
		</table>
		<br> <br>
	</div>
	
		<!-- CORSISTI -->
	<div class="container">
		<h3 align="center">Riepilogo corsisti</h3>
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr align="center">
					<th class="th-sm">Numero matricola</th>
					<th class="th-sm">Nome</th>
					<th class="th-sm">Cognome</th>
					<th class="th-sm">Precedenti formativi</th>
				</tr>
			</thead>
			<tbody>
				<%
				Corsista[] corsista = AdminFacade.getIstance().getAllCorsista();
				for (Corsista c : corsista) {
				%>
				<tr align="center">
					<td><%=c.getCodCorsista()%></td>
					<td><%=c.getNomeCorsista()%></td>
					<td><%=c.getCognomeCorsista()%></td>
					<%
					if (c.getPrecedentiFormativi() == 1) {
					%>
					<td>SI</td>
					<%
					} else {
					%>
					<td>NO</td>
					<%
					}
					%>
						<td><a href="elimina.jsp?id=<%=c.getCodCorsista()%>"
							class="btn btn-danger">Elimina corsi <i class="bi bi-trash"></i></a></td>
					<%
					}
					%>
				</tr>
			</tbody>
		</table>
	</div>

		<!-- PULSANTI -->
		<table class="table table-striped">
			<tbody align="center">
				<tr>
					<td><a class="btn btn-primary" href="inserisciCorsista.jsp">Inserisci
							corsista</a></td>
					<td>
						<form
							action="/<%=application.getServletContextName()%>/statistiche"
							method="post">
							<button type="submit" class="btn btn-success">
								Visualizza statistiche <i class="bi bi-bar-chart-fill"></i>
							</button>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	<br>
	<br>
	<%@include file="pageformat/footer.html"%>
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>