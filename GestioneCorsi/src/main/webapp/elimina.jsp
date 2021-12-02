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
			Corso[] corsi = AdminFacade.getIstance().getCorsiCorsistaById(Long.parseLong(request.getParameter("id")));
			for (int i = 0; i < corsi.length; i++) {
			%>

			<tr>
				<td><%=corsi[i].getCod()%></td>
				<td><%=corsi[i].getNome()%></td>
				<td><%=corsi[i].getDataInizio()%></td>
				<td><%=corsi[i].getDataFine()%></td>
				<td><form
						action="/<%=application.getServletContextName()%>/elimina"
						method="post">
						<input type="hidden" name="idCorso" value="<%=corsi[i].getCod()%>">
						<input type="hidden" name="idCorsista"
							value="<%=request.getParameter("id")%>">
					</form></td>
			</tr>


			<%
			}
			%>
		</tbody>
	</table>




	<%@include file="pageformat/footer.html"%>
</body>
</html>