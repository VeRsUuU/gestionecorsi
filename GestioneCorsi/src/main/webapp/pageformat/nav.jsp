
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="index.jsp">Betacom
		Milano</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav">
			<%
			if (session.getAttribute("username") != null) {
			%>
			<li class="nav-item"><a class="nav-link" href="#">Gestione
					corsi&nbsp;<i class="bi bi-pencil-square"></i>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="profile.jsp"><%=session.getAttribute("username")%>&nbsp;<i
					class="bi bi-person-circle"></i></a></li>
			<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout&nbsp;<i
					class="bi bi-box-arrow-in-left"></i></a></li>

			<%
			} else {
			%>
			<li class="nav-item"><a class="nav-link" href="login.jsp">Login&nbsp;<i
					class="bi bi-box-arrow-in-right"></i></a></li>

			<%
			}
			%>
		</ul>
	</div>
</nav>