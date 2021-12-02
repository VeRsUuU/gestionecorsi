<%
	String user = (String)session.getAttribute("username");

	if(user != null ){
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>