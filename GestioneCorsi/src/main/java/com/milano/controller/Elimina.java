package com.milano.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.AdminFacade;

@WebServlet("/elimina")
public class Elimina extends HttpServlet {

	private static final long serialVersionUID = -9067885775343917660L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			AdminFacade.getIstance().disiscrivi(Long.parseLong(request.getParameter("idCorso")),
					Long.parseLong(request.getParameter("idCorsista")));
			response.sendRedirect("elimina.jsp?id=" + request.getParameter("idCorsista"));
		} catch (NumberFormatException | ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
		}

	}

}
