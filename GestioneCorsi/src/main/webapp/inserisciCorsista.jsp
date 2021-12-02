<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.milano.businesscomponent.model.Admin"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/main-style.css">
		<%@include file="CDN/bootstrap4CDN.html"%>
<title>Inserisci Corsista</title>
</head>
<body>
<jsp:include page="pageformat/nav.jsp"/>
	<%
	HashMap<Integer, Integer> map = AdminFacade.getIstance().getIscritti();
	ArrayList<Corso> corsi = AdminFacade.getIstance().getAllCorso();
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	List<String> listaCorsi = (List<String>) request.getAttribute("corsi");

	HashMap<String, String> errori = new HashMap<String, String>();

	if (null != request.getAttribute("erroriServlet")) {
		errori = (HashMap<String, String>) request.getAttribute("erroriServlet");
	}
	%>
	<div class="container" style="align: center;">
	<div class="pb-2 mt-4 mb-2 border-bottom">
    <h1>Inserisci corsista</h1>      
  </div>
	<form action="/<%=application.getServletContextName()%>/inserisciCorsista"
		method="post">
		<div class="row" style="margin-top: 10px">
		<div class="form-group col-md-6">
			<label for="nome">Nome 
			<input class="form-control" type="text" name="nome" <% if(request.getAttribute("nome") != null) {%> value="<%= request.getAttribute("nome") %> <% }%>">
		</label>
		</div>
		<div class="col-md-4" style="padding-top: 30px; color: red; margin-left: 30px">
		<%
		if (errori.containsKey("errorNome")) {
		%>
		<p><%=errori.get("errorNome")%></p>
		<%}%>
		</div>
		</div>


		<div class="row">
		<div class="form-group col-md-6" >
			<label for="cognome">Cognome 
			<input class="form-control" type="text" name="cognome" <% if(request.getAttribute("cognome") != null) {%> value="<%= request.getAttribute("cognome") %> <% }%>">
		</label>
		</div>
		<div class="col-md-4" style="padding-top: 30px;color: red; margin-left: 30px">
		<%
		if (errori.containsKey("errorCognome")) {
		%>
		<%=errori.get("errorCognome")%>
			<%}%>
		</div>
		</div>
		<h3 style="margin-left: 80px">Corsi disponibili</h3>
		<hr>
		
		<div class="row">
		<%
		if (errori.containsKey("nullPointerException")) {
		%>
		<p style="color: red; margin-bottom: 50px;"><%=errori.get("nullPointerException")%></p>
			<%}%>
		</div>
		
		
			<%
			for (Corso corso : corsi) {
				System.out.println(corso);
				Integer i = new Integer((int) corso.getCod());
			%>
		
		<div class="row">
		<div class="form-check col-md-3" style="margin-left: 30px"> 

			<input type="checkbox"
				onclick="ShowHideDiv('divToHide<%=corso.getCod()%>')"
				name="numeroCorso" class="form-check-input" value="<%=corso.getCod()%>"
				
				<% 
				
				if(listaCorsi != null && listaCorsi.contains(Long.toString(corso.getCod()))){
					out.print("checked");
				}
				%>
				
				<%if (map.containsKey(i)) {
					if (map.get(i) == 12) {
						out.print("disabled");
					}
				}%>>	
			<label for="<%=corso.getCod()%>"><%=corso.getNome()%></label>
		</div>
		<div class="col-md-3">
			<%
			if (map.containsKey(i)) {
				out.print("Disponibili " + (12 - map.get(i)) + "/12");
			} else {
				out.print("Disponibili 12/12");
			}
			%>
			</div>
			
			<div class="col-md-5" style="color: red">
				<%
					if (errori.containsKey("errorData_" + corso.getCod())) {
				%>
				<%=errori.get("errorData_" + corso.getCod())%>
				<%}%>
				<%
					if (errori.containsKey("errorDataInvertita_" + corso.getCod())) {
				%>

				<%=errori.get("errorDataInvertita_" + corso.getCod())%>
				<%}%>
				<%
				if (errori.containsKey("errorDataInterval_" + corso.getCod())) {
				%>

				<%=errori.get("errorDataInterval_" + corso.getCod())%>
				<%
				}
				%>
				<%
				if (errori.containsKey("errorDataMancante_" + corso.getCod())) {
				%>

				<%=errori.get("errorDataMancante_" + corso.getCod())%>
				<%
				}
				%>
				</div>

				</div>
			
			
			<div id="divToHide<%=corso.getCod()%>" class="col-md-10" 
			<% if(listaCorsi != null && listaCorsi.contains(Long.toString(corso.getCod()))){ %>
					style = "display: block;"
					
				<% } else{ %>
					style = "display: none;"
				
				<% } %>
				>
			<div class="row" style="margin-bottom: 40px; margin-top: 30px">
			<div class="col-md-4">
				<label  for="dataInizio<%=corso.getCod()%>">Data inizio</label> 
				<input type="text"
					value="<%=formato.format(corso.getDataInizio())%>"
					name="dataInizio<%=corso.getCod()%>" class="form-control-inline">
			</div>
			<div class="col-md-4">
				<label for="dataFine<%=corso.getCod()%>">Data fine
				</label> 
				<input type="text" value="<%=formato.format(corso.getDataFine())%>"
					name="dataFine<%=corso.getCod()%>" class="form-control-inline">
			</div>
			<div class="col-md-4">
				<p>Costo: <%= corso.getCosto() %>&euro;</p><hr>
				<p>Aula di svolgimento: <%= corso.getAula() %></p><hr>
				<p>Commenti: <%= corso.getCommenti() %></p><hr>
			</div>
			</div> 
			</div>
			

		<%}%>
		<div class="row" style="margin: 10px 0 0 20px">
		<div class="form-check form-check-inline">
			<label for="precedenti">Precedenti Formativi 
				<input class="form-check-input" type="radio"  name="precedenti" value="1" checked="checked">Si
				<input class="form-check-input" type="radio"  name="precedenti" value="0">No
			</label> 
		</div>
		</div> 
		<button type="submit" class="btn btn-success" style="margin: 30px">Invia</button>
	</form>
	<script type="text/javascript">
		function ShowHideDiv(corso) {
			var el = document.getElementById(corso);
			if (el.style.display == "none")
				el.style.display = "block";
			else
				el.style.display = "none";
		}
	</script>
	</div>
	<%@include file="pageformat/footer.html"%>
</body>
</html>