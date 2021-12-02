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
<title>Inserisci Corsista</title>
</head>
<body>
	<%
	HashMap<Integer, Integer> map =  AdminFacade.getIstance().getIscritti();
	ArrayList<Corso> corsi =  AdminFacade.getIstance().getAllCorso();
	
	HashMap<String,String> errori = new HashMap<String,String>();
	
	if(null != request.getAttribute("erroriServlet")){
		errori = (HashMap<String,String>) request.getAttribute("erroriServlet");
	}


%>
	<form action="/inserisciCorsista" method="get">
		<label for="nome">Nome <input type="text" name="nome">
		</label> 
		<% if(errori.containsKey("errorNome")){%>
		<p><%= errori.get("errorNome") %></p>
		<%} %>
		
		
		<br> <label for="nome">Cognome <input type="text"
			name="cognome">
		</label>
		<% if(errori.containsKey("errorCognome")){%>
		<p><%= errori.get("errorCognome") %>
		<% } %>
		 <br>

		<%
		for(Corso corso : corsi){
			System.out.println(corso);
			Integer i = new Integer((int) corso.getCod());
	%>
		<div>
			<input type="checkbox" id="<%= corso.getCod() %>" name="numeroCorso"
			
			<% if(map.containsKey(i)){
					if(map.get(i) == 12){
						out.print("disabled");
					}
				}
			%>
			> 
			<label
				for="<%=corso.getCod()%>"><%= corso.getNome() %></label>
				
				<% if(map.containsKey(i)){
					out.print("Disponibili "+(12-map.get(i))+"/12");
				}
					else {
						out.print("Disponibili 12/12"); 
						}%>
				
				
				<div>
					<label>Data inizio</label>
					<input type="text" placeholder="DD/MM/YYYY">
					<label>Data inizio</label>
					<input type="text" placeholder="DD/MM/YYYY">
				</div>
				<div>
					<%
						
					
					
					%>
				
				
				</div>
				
		</div>
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<% } %>
 		<label for="precedenti">Precedenti Formativi <input
				type="radio" name="precedenti" value="1" checked="checked">Si
			<input type="radio" name="precedenti" value="0">No
		</label> <br> <input type="submit" value="invia">

	</form>

</body>
</html>