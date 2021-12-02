<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	String admin = (String)session.getAttribute("username");
		if(admin != null) {
%>
	
<!DOCTYPE html>
<html>

	<head>
		<%@include file="CDN/bootstrap4CDN.html"%>
		<meta charset="ISO-8859-1">
	</head>
<body>
	<jsp:include page="pageformat/nav.jsp"/>
	<div class="container" style="align: center;">
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
 				String username = (String)session.getAttribute("username");
  				Admin amministratore = AdminFacade.getIstance().getByIdUsername(username);
 			%>
   			 <tr>
     		 <th scope="row"><%=amministratore.getUsername()%></th>
     			 <td><%=amministratore.getNomeAdmin()%></td>
     			 <td><%=amministratore.getCognomeAdmin()%></td>
   			 </tr>
  		</tbody>
</table>
<br>
<br>

<!-- CORSISTI -->
<h3 align="center">Riepilogo corsisti</h3>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
  <thead>
    <tr align="center">
      <th class="th-sm">Numero matricola</th>
      <th class="th-sm">Nome</th>
      <th class="th-sm">Cognome</th>
      <th class="th-sm">Precedenti formativi </th>
    </tr>
  </thead>
  <tbody>
  	<%
 		Corsista[] corsista = AdminFacade.getIstance().getAllCorsista();
 		for(Corsista c : corsista) {			
 	%>
    <tr align="center">
      <td><%=c.getCodCorsista()%></td>
      <td><%=c.getNomeCorsista()%></td>
      <td><%=c.getCognomeCorsista()%></td>
      <%
     	 	if(c.getPrecedentiFormativi() == 1){
      %>
     	 <td>SI</td>
      <%
     	 	} else {
      %>
         <td>NO</td>
      <%
     	 	}
      %>
    </tr>
    <%
 		}
    %>
  </tbody>
</table>
	
   <!-- PULSANTI -->
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
			<tr align="center">
				<th>
					<form action="/<%=application.getServletContextName()%>/inserisci" method="post">
						<input type="hidden" name="codice" value="">
						<input type="hidden" name="nome" value="">
						<input type="hidden" name="cognome" value="">
						<input type="hidden" name="precedentiformativi" value="">
						<button type="submit" class="btn btn-primary">inserisci corsista
							<i class="bi bi-chevron-double-right"></i>
						</button>
					</form>
				</th>
				<th>
					<form action="/<%=application.getServletContextName()%>/statistiche" method="post">
					<button type="submit" class="btn btn-success">visualizza statistiche
						<i class="bi bi-bar-chart-fill"></i>
					</button>
					</form>
				</th>
				<th>
					<form action="/<%=application.getServletContextName()%>/inserisci" method="post">
					<button type="submit" class="btn btn-danger">elimina corsi
						<i class="bi bi-trash"></i>
					</button>
					</form>
				</th>
			</tr>
			</thead>
		</table>
	</div>
</div>
<%@include file="pageformat/footer.html"%>
</body>
</html>
<%
	} else { 
		response.sendRedirect("accessonegato.jsp");
	}
%>