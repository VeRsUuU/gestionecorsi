<!-- creata da Zoia Simone -->

<%@page import="com.milano.businesscomponent.model.Admin"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie aCookie : cookies) {
		if(aCookie.getName().equals("username")) {
			System.out.println("cookie esiste");
			if(aCookie.getValue() != null)
				session.setAttribute("username", aCookie.getValue());
				System.out.println("username impostato dal cookie" + aCookie.getValue());
		}
	}
}
String admin = (String) session.getAttribute("username");
if (admin != null) {

%>

<!DOCTYPE html>
<html>
<head>
<%@include file="CDN/bootstrap4CDN.html" %>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="tabledesign/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="tabledesign/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="tabledesign/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="tabledesign/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="tabledesign/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="tabledesign/css2/util.css">
<link rel="stylesheet" type="text/css" href="tabledesign/css2/main.css">
<title>Riepilogo corsisti</title>
</head>
<body>
<jsp:include page="pageformat/nav.jsp" />
		<br> <br>
	<!-- AMMINISTRATORE -->
		<div class="wrap-table100" style="margin: auto;">
			<h3 align="center">Dati amministratore</h3><br>
				<div class="table100 ver3 m-b-110">
									<div class="table100-head">
										<table>
											<thead>
												<tr class="row100 head">
													<th class="cell100 column1">Username</th>
													<th class="cell100 column2">Nome</th>
													<th class="cell100 column3">Cognome</th>
													<th class="cell100 column4">Stato</th>
												</tr>
											</thead>
										</table>
									</div>

									<div class="table100-body js-pscroll">
										<table>
											<tbody>
												<%
													if(session.getAttribute("username") != null) {
														String username = (String) session.getAttribute("username");
														Admin amministratore = AdminFacade.getIstance().getByIdUsername(username);
												%>
												<tr class="row100 body">
													<td class="cell100 column1"><%=amministratore.getUsername()%></td>
													<td class="cell100 column2"><%=amministratore.getNomeAdmin()%></td>
													<td class="cell100 column3"><%=amministratore.getCognomeAdmin()%></td>
													<td class="cell100 column4"><i class="bi bi-circle-fill" style="color: green;"></i> Online</td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>

<!-- RIEPILOGO CORSISTI -->
		<div class="wrap-table100" style="margin: auto;">
			<h3 align="center">Riepilogo corsisti</h3><br>
				<div class="table100 ver3 m-b-110">
									<div class="table100-head">
										<table>
											<thead>
												<tr class="row100 head">
													<th class="cell100 column1">Numero matricola</th>
													<th class="cell100 column2">Nome</th>
													<th class="cell100 column3">Cognome</th>
													<th class="cell100 column4">Precedenti formativi</th>
													<th class="cell100 column4"></th>
												</tr>
											</thead>
										</table>
									</div>
				
									<div class="table100-body js-pscroll">
										<table>
											<tbody>
											<%
												Corsista[] corsista = AdminFacade.getIstance().getAllCorsista();
												for (Corsista c : corsista) {
											%>
												<tr class="row100 body">
													<td class="cell100 column1"><%=c.getCodCorsista()%></td>
													<td class="cell100 column2"><%=c.getNomeCorsista()%></td>
													<td class="cell100 column3"><%=c.getCognomeCorsista()%></td>
													<%
														if (c.getPrecedentiFormativi() == 1) {
													%>
														<td class="cell100 column4">SI</td>
													<%
														} else {
													%>
														<td class="cell100 column4">NO</td>
													<%
														}
													%>
														<td class="cell100 column5"><a href="elimina.jsp?id=<%=c.getCodCorsista()%>"
															class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
													<%
														}
													%>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>

	<!-- PULSANTI -->
		<table class="table table-striped" style="margin: auto;">
			<tbody align="center">
				<tr>
					<td><a class="btn btn-primary" href="inserisciCorsista.jsp">Inserisci
							corsista <i class="bi bi-plus-lg"></i></a></td>
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
		
<script src="tabledesign/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="tabledesign/vendor/bootstrap/js/popper.js"></script>
<script src="tabledesign/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="tabledesign/vendor/select2/select2.min.js"></script>
<script src="tabledesign/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
	$('.js-pscroll').each(function(){
		var ps = new PerfectScrollbar(this);
			$(window).on('resize', function(){
				ps.update();
			})
		});
</script>
<script src="tabledesign/js2/main.js"></script>
<%@include file="pageformat/footer.html"%>
</body>
</html>

<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>