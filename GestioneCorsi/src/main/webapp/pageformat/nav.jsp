<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
	    <div class="navbar-header">
	        
	        <a class="navbar-brand" href="#.jsp">Betacom Milano</a>
	        
	    </div>
	    <div id ="menu">
	        <%
	            String username = (String) session.getAttribute("username");
	            if(username != null) {
	        %>
	        
	        <ul class="nav navbar-nav navbar-right">
	       		<li>
	       			<a class="nav-link" href="riepilogocorsisti.jsp"><i class="bi bi-pencil-square"></i>&nbsp;Gestione corsisti</a>
	       		</li>
	       		<li>
	                <a class="nav-link" href="#.jsp">
	                    <i class="bi bi-person-circle"></i>&nbsp; <%= username %>
	                </a>
	            </li>
	        	<li>
	                <a class="nav-link" href="logout.jsp">
	                    <i class="bi bi-box-arrow-in-right"></i>&nbsp; Logout
	                </a>
	            </li>
	        </ul>
	        <%
	        	} 
	        %>
	    </div>
	</div>
</nav>