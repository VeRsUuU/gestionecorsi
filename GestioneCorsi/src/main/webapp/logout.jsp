<%
	String user = (String)session.getAttribute("username");
	
	if(user != null){
		
		Cookie cookie = new Cookie("username", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>