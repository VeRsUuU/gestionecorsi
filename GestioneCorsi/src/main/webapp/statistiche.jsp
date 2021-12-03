<%
String admin = (String) session.getAttribute("username");
if (admin == null)
	response.sendRedirect("accessonegato.jsp");
%>

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
<jsp:include page="pageformat/nav.jsp"/>

<%
ArrayList<Corso>piuF= new ArrayList<Corso>();
piuF=AdminFacade.getIstance().getCorsoPiuFrequentato();
Corsista[] elenco;
elenco=AdminFacade.getIstance().getAllCorsista();
if(piuF.isEmpty() && elenco.length==0){
%>
<p>non stampa niente l'arrayList</p>
<p>non stampa niente l'array</p>
<%
}else{
	for(Corso corso: piuF){
%>
<p>corso piu frequentato <%=corso.getNome()%></p>
<%
}
	for(Corsista corsista:elenco){
		%>
		<p>elenco dei corsisti : <%=corsista.getNomeCorsista()+"  "%> <%=corsista.getCognomeCorsista()%></p>
		<%
		} 
}

int days = AdminFacade.getIstance().getDurataCorsi();
Integer tot=AdminFacade.getIstance().getotCorsisti();
Corso corsodt=new Corso();
corsodt=AdminFacade.getIstance().getDataUltimoCorso();
Integer totCommenti=AdminFacade.getIstance().getTotCommenti();
Docente doc = new Docente();
doc = AdminFacade.getIstance().getMaxCorsi();
%>
<p>numero totali corsisti : <%= tot %></p>
<p>durata media di tutti i corsi : <%= days %></p>
<p>nome dell'ultimo corso : <%= corsodt.getNome() %>, data inizio dell'ultimo corso : <%= corsodt.getDataInizio() %> </p>
<p>numero totali commenti presenti : <%= totCommenti %></p>
<p>nome e cognome docente max corsi : <%=doc.getNomeDocente()+"   " %><%= doc.getCognomeDocente() %> 







<%@include file="pageformat/footer.html"%>
</body>
</html>