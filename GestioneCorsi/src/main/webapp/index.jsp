<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<br>
			<h3>Accedi all'area amministratori</h3>
			<br>
			<br>
		</div>
		<div class="card card-outline-secondary">
            <div class="card-header">
                <h3 class="mb-0">Inserisci i dati di accesso</h3>
            </div>
            <div class="card-body">
                <form class="form" action="/<%=application.getServletContextName()%>/login" id="loginForm" method="POST">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username">
                        <div class="invalid-feedback">Inserisci l'username</div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password">
                        <div class="invalid-feedback">Inserisci la password</div>
                    </div>
                    <div class="form-check small">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input"> <span>Ricordami</span>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary btn-m float-right" id="login">Accedi</button>
                </form>
            </div>
    	</div>
	</div>
	<footer style="position: absolute; height: 25px; bottom: 0px;"><%@include file="pageformat/footer.html" %></footer>
</body>
</html>