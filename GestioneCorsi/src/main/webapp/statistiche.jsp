
<%@page import="java.util.HashMap"%>
<%
if (session.getAttribute("username") == null)
	response.sendRedirect("accessonegato.jsp");
%>

<%@page import="java.util.Map.Entry"%>
<%@page import="com.milano.businesscomponent.model.Docente"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@page import="java.util.ArrayList"%>
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
	<jsp:include page="pageformat/nav.jsp" />

	<div class="container" style="align: center;">
		<div class="page-header">
			<br>
			<h2>Statistiche</h2>
			<br> <br>
		</div>



		<%
		int days = AdminFacade.getIstance().getDurataCorsi();
		Integer tot = AdminFacade.getIstance().getotCorsisti();
		Corso corsodt = new Corso();
		corsodt = AdminFacade.getIstance().getDataUltimoCorso();
		Integer totCommenti = AdminFacade.getIstance().getTotCommenti();
		Docente doc = new Docente();
		doc = AdminFacade.getIstance().getMaxCorsi();
		%>
		<div class="row row-cols-1 row-cols-md-2">
			<div class="col mb-4">
				<div class="card text-white bg-dark mb-4" style="max-width: 18rem;">
					<div class="card-header">Corsisti</div>
					<div class="card-body">
						<h5 class="card-title">Numero totali corsisti</h5>
						<p class="card-text">
							Totale:
							<%=tot%></p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<div class="card-header">Corsi</div>
					<div class="card-body">
						<h5 class="card-title">Durata media di tutti i corsi</h5>
						<p class="card-text">
							Media:
							<%=days%></p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<div class="card-header">Corsi</div>
					<div class="card-body">
						<h5 class="card-title">Ultimo corso</h5>
						<p class="card-text">
							Nome:
							<%=corsodt.getNome()%></p>
						<div class="card-footer">
							Data inizio:
							<%=corsodt.getDataInizio()%></div>

					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<div class="card-header">Corsi</div>
					<div class="card-body">
						<h5 class="card-title">Commenti presenti</h5>
						<p class="card-text">
							Totale commenti:
							<%=totCommenti%></p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<div class="card-header">Docenti</div>
					<div class="card-body">
						<h5 class="card-title">Docente con più corsi</h5>
						<p class="card-text">
							Nome:
							<%=doc.getNomeDocente() + " "%><%=doc.getCognomeDocente()%>
							<%=totCommenti%></p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
					<div class="card-header">Corsi</div>
					<div class="card-body">
						<h5 class="card-title">Corso/i più frequentato/i</h5>
						<p class="card-text">
							<%
							ArrayList<Corso> piuF = new ArrayList<Corso>();
							piuF = AdminFacade.getIstance().getCorsoPiuFrequentato();
							if (!piuF.isEmpty()) {
								for (Corso corso : piuF) {
							%>

							Corso:
							<%=corso.getNome()%><br>
							<%
							}
							} else {
							%>
							Nessun corso frequentato
							<%
							}
							%>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card text-center text-white bg-dark mb-5">
			<div class="card-header">Riepilogo Corsisti</div>
			<div class="card-body">
				<h5 class="card-title">Seleziona un corsista per controllarne i
					corsi frequentati</h5>
		
		
		
				<%
				HashMap<String,Integer> posti=new HashMap<String,Integer>();
				posti= AdminFacade.getIstance().getPostiDisponibili();
				if (posti.keySet() !=null) {
				%>

				<table class="table table-hover table-dark ">
					<thead class="thead-light">
						<tr>
							<th scope="col">Corso</th>
							<th scope="col">Posto</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Entry<String,Integer>entry  : posti.entrySet()) {
						%>

						<tr >
							<td><%=entry.getKey()%></td>
							<td><%=entry.getValue()%></td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>
				<%
				} else {
				%>
				<p class="card-text">Al momento non sono presenti dei corsisti
					:(</p>
				<%
				}
				%>


			</div>
			<div class="card-footer text-white">Design by geppo</div>
		</div>
		
		
		

		
		
		
		
		
		<div class="card text-center text-white bg-dark mb-5">
			<div class="card-header">Riepilogo Corsisti</div>
			<div class="card-body">
				<h5 class="card-title">Seleziona un corsista per controllarne i
					corsi frequentati</h5>

				<%
				Corsista[] elenco;
				elenco = AdminFacade.getIstance().getAllCorsista();
				if (elenco.length != 0) {
				%>

				<table class="table table-hover table-dark ">
					<thead class="thead-light">
						<tr>
							<th scope="col">Nome</th>
							<th scope="col">Cognome</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Corsista corsista : elenco) {
						%>

						<tr onclick="cambiaURL('<%=corsista.getCodCorsista()%>')"
							data-id="<%=corsista.getCodCorsista()%>"
							id="corsista<%=corsista.getCodCorsista()%>">
							<td><%=corsista.getNomeCorsista()%></td>
							<td><%=corsista.getCognomeCorsista()%></td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>
				<%
				} else {
				%>
				<p class="card-text">Al momento non sono presenti dei corsisti
					:(</p>
				<%
				}
				%>


			</div>
			<div class="card-footer text-white">Design by geppo</div>
		</div>



	</div>
	<%@include file="pageformat/footer.html"%>
	<%@include file="pageformat/modalCorsiCorsista.jsp"%>
	<script>
		setTimeout(function toggle() {

			$('#recapModal').modal(
					'toggle',
					function(event) {

						var button = $(event.relatedTarget)
						var recipient = button.data('id')
						var modal = $(this)
						modal.find('.modal-title').text(
								'Corsi del corsista ' + recipient)

					})
		}, 100);

		function cambiaURL(idCorsista) {
			window.location.href = "statistiche.jsp?id=" + idCorsista;
			toggle();
		}
	</script>
</body>
</html>