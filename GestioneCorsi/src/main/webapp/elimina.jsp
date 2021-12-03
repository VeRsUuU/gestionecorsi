
<%
String admin = (String) session.getAttribute("username");
if (admin == null)
	response.sendRedirect("accessonegato.jsp");
%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disicrizione corsi</title>
<link rel="stylesheet" href="css/main-style.css">
<%@include file="CDN/bootstrap4CDN.html"%>
</head>
<body>
	<%@include file="pageformat/nav.jsp"%>
	<div class="container">
		<%
		ArrayList<Corso> corsi = AdminFacade.getIstance().getCorsiCorsistaById(Long.parseLong(request.getParameter("id")));
		if (request.getParameter("id") != null && corsi.size() != 0) {
		%>
		<table class="table table-striped">
			<thead align="center">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Data Inzio</th>
					<th scope="col">Data Fine</th>
					<th scope="col">Disicrivi</th>
				</tr>
			</thead>
			<tbody align="center">
				<%
				for (int i = 0; i < corsi.size(); i++) {
				%>

				<tr>
					<td><%=corsi.get(i).getCod()%></td>
					<td><%=corsi.get(i).getNome()%></td>
					<td><%=corsi.get(i).getDataInizio()%></td>
					<td><%=corsi.get(i).getDataFine()%></td>
					<td><form
							action="/<%=application.getServletContextName()%>/elimina"
							method="post">
							<input type="hidden" name="idCorso"
								value="<%=corsi.get(i).getCod()%>"> <input type="hidden"
								name="idCorsista" value="<%=request.getParameter("id")%>">
							<button type="submit" class="btn btn-danger">Disiscrivi</button>
						</form></td>
				</tr>


				<%
				}
				%>
			</tbody>
		</table>

		<%
		} else {
		%>
		<div class="alert alert-warning" role="alert">
			<h4 class="alert-heading">Attenzione</h4>
			<p>Questo corsista non &egrave; iscritto a nessun corso!</p>
		</div>
		<%
		}
		%>
	</div>
	<br>
	<br>
	<div class="container" align="center">
		<a href="recapCorsisti.jsp">
			<button type="button" class="btn btn-primary">
				Torna al riepilogo <i class="bi bi-box-arrow-left"></i>
			</button>
		</a>
	</div>
	<%@include file="pageformat/footer.html"%>
</body>
</html>