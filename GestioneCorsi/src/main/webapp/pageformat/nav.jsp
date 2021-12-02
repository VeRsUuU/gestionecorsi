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
   				<div class="btn-group">
					<button style="background-color: rgba(0, 0, 0, 0.2);" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="bi bi-person-circle"></i>&nbsp; <%= username %>
					</button>
				  <div class="dropdown-menu dropdown-menu-right">
					 <a class="dropdown-item" href="logout.jsp">
	                    <i class="bi bi-box-arrow-in-right"></i>&nbsp; Logout
	                </a>
				  </div>
				</div>
                
                </li>
                <li>
                
            	</li>
	            	
	        	
	        </ul>
	        <%
	        	} 
	        %>
	    </div>
	</div>
</nav>