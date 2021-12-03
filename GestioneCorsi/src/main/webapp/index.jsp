<%
if (session.getAttribute("errori") == null) {
	session.setAttribute("errori", 0);
}

int err;
err = (int) session.getAttribute("errori");

if (err == 5){
	
	if(request.getParameter("param") != null) {
		
		err = Integer.parseInt(request.getParameter("param"));
		session.setAttribute("errori", err);
	} else {
		
		response.sendRedirect("tentativiEsauriti.jsp");
	
	}
	
}

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie aCookie : cookies) {
		if(aCookie.getName().equals("username")) {
			if(aCookie.getValue() != null)
				session.setAttribute("username", aCookie.getValue());
		}
	}
}
if(session.getAttribute("username")!=null) { 
	response.sendRedirect("recapCorsisti.jsp");
}

if (err < 5) {
	
%>

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
			<h3>Accedi all'area amministratori</h3>
			<br>
		</div>
		<div class="card card-outline-secondary">
			<div class="card-header">
				<h3 class="mb-0">Inserisci i dati di accesso</h3>
			</div>
			<div class="card-body">
				<form class="form"
					action="/<%=application.getServletContextName()%>/login"
					id="loginForm" method="POST">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" name="username" id="username">
						<div class="invalid-feedback">Inserisci l'username</div>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" name="password" id="password">
						<div class="invalid-feedback">Inserisci la password</div>
					</div>
					<div class="form-check small">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" name="cookie" id="cookie" value="1"> <span>Ricordami</span>
						</label>
					</div>
					<button type="submit" class="btn btn-primary btn-m float-right"
						id="login">Accedi</button>
				</form>
			</div>

			<%
			if (err >= 1) {
			%>
			<div class="form-group"
				style="background-color: #FFBABA; color: red; border: 1px solid; margin: 10px 0px; padding: 20px 10px 15px 20px; background-repeat: no-repeat; background-position: 10px center;">
				<h5>Username o password errati</h5>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<%@include file="pageformat/footer.html"%>
</body>
</html>
<%
}
%>