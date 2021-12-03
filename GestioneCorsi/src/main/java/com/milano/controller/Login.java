package com.milano.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 2094656142566166734L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int check = 0;
		
		if(request.getParameter("cookie") != null)
			check = Integer.parseInt(request.getParameter("cookie"));

		String userpass;
		
		HttpSession session = request.getSession();

		int err = (int)session.getAttribute("errori");
		
		if (username != null && password != null) {
			try {
				userpass = getPassword(username);
				if (userpass != null) {
					if (userpass.equals(password)) {
						session.setAttribute("username", username);
						
						if(check == 1) {
							Cookie cookie = new Cookie("username", (String) request.getParameter("username"));
							cookie.setMaxAge(60*60);
							response.addCookie(cookie);
						}
							
						response.sendRedirect("recapCorsisti.jsp");
					} else {
						session.setAttribute("errori", err+1);
						response.sendRedirect("index.jsp");
					}
				} else {
					session.setAttribute("errori", err+1);
					response.sendRedirect("index.jsp");
				}
			} catch (DAOException | ClassNotFoundException exc) {
				response.sendRedirect("accessonegato.jsp");
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}

	}

	private String getPassword(String username) throws ClassNotFoundException, IOException, DAOException {

		Connection conn = DBAccess.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("select password from amministratore where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} 
			conn.close();
			return null;
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
	}
}
