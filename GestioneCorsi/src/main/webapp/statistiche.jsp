<%@page import="com.milano.businesscomponent.model.Docente"%>
<%@page import="com.milano.businesscomponent.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
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
if(piuF.isEmpty()){
%>
<p>non stampa niente</p>
<%
}else{
	for(Corso corso: piuF){
%>
<p>corso piu frequentato <%=corso.getNome()%></p>
<%
}
}
Integer tot=AdminFacade.getIstance().getotCorsisti();
Corso corsodt=new Corso();
corsodt=AdminFacade.getIstance().getDataUltimoCorso();
Integer totCommenti=AdminFacade.getIstance().getTotCommenti();
Docente doc = new Docente();
doc = AdminFacade.getIstance().getMaxCorsi();
%>
<p>numero totali corsisti <%= tot %></p>
<p>nome dell'ultimo corso : <%= corsodt.getNome() %>, data inizio dell'ultimo corso : <%= corsodt.getDataInizio() %> </p>
<p>numero totali commenti presenti : <%= totCommenti %></p>
<p>nome e cognome docente max corsi : <%=doc.getNomeDocente()+"   " %><%= doc.getCognomeDocente() %> 







<%@include file="pageformat/footer.html"%>
</body>
</html>