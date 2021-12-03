
<%
long id;
ArrayList<Corso> corsiCorsista;
if (request.getParameter("id") != null) {
%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%
id = Long.parseLong(request.getParameter("id"));
corsiCorsista = AdminFacade.getIstance().getCorsiCorsistaById(id);
%>
<div class="modal fade " id="recapModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg ">
		<div class="modal-content bg-dark">
			<div class="modal-header text-white">
				<h5 class="modal-title" id="exampleModalLabel">
					Recap corsi del corsista
					<%=id%></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">Aula</th>
							<th scope="col">Nome</th>
							<th scope="col">Data Inzio</th>
							<th scope="col">Data Fine</th>
							<th scope="col">Costo</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Corso corso : corsiCorsista) {
						%>
						<tr>
							<td><%=corso.getAula()%></td>
							<td><%=corso.getNome()%></td>
							<td><%=corso.getDataInizio()%></td>
							<td><%=corso.getDataFine()%></td>
							<td><%=corso.getCosto()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" data-dismiss="modal">Chiudi</button>
			</div>
		</div>
	</div>
</div>
<%
}
%>