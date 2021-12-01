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
			<h3>Accedi all'area amministratori</h3>
		</div>
		<div class="card card-outline-secondary">
            <div class="card-header">
                <h3 class="mb-0">Inserisci i dati di accesso</h3>
            </div>
            <div class="card-body">
                <form class="form" role="form" autocomplete="off" id="loginForm" method="POST">
                    <div class="form-group">
                        <label for="uname1">Username</label>
                        <input type="text" class="form-control" name="uname1" id="uname1">
                        <div class="invalid-feedback">Username...</div>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" id="pwd1" autocomplete="new-password">
                        <div class="invalid-feedback">Password...</div>
                    </div>
                    <div class="form-check small">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input"> <span>Ricordami</span>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Accedi</button>
                </form>
            </div>
    	</div>
	</div>
	<footer style="position: absolute; height: 25px; bottom: 0px;"><%@include file="pageformat/footer.html" %></footer>
</body>
</html>