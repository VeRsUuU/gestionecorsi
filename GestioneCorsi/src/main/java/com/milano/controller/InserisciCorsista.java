package com.milano.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.AdminFacade;
import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.utilities.Validazione;

/**
 * Servlet implementation class InserisciCorsista
 */
@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {

	
	private static final long serialVersionUID = -5152112999725060676L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		String[] corsi = request.getParameterValues("numeroCorso");
		List<String> list = Arrays.asList(corsi);
		
		byte radio = Byte.parseByte(request.getParameter("precedenti"));
		
		HashMap<Integer, Date[]> mappa = new HashMap<Integer, Date[]>();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		for(String id : list) {
			
			Date[] date = new Date[2];
			try {
				date[0] = formato.parse(request.getParameter("dataInizio"+id));
				date[1] = formato.parse(request.getParameter("dataFine"+id));
			} catch (ParseException e) {
				date[0] = null;
				date[1] = null;
			}
			
			mappa.put(Integer.parseInt(id), date);
		}
		
		
		HashMap<String, String> errori = new HashMap<String, String>();
		try {
			errori = Validazione.valida(nome, cognome, mappa);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(errori.isEmpty()) {
			
			try {
				Corsista corsista = new Corsista();
				corsista.setCodCorsista(CorsistaIdGenerator.getInstance().getNextId());
				corsista.setNomeCorsista(nome);
				corsista.setCognomeCorsista(cognome);
				corsista.setPrecedentiFormativi(radio);
				AdminFacade.getIstance().createCorsista(corsista);
				
				for(String id : list) {
					AdminFacade.getIstance().createCorsoCorsista(Long.parseLong(id), corsista.getCodCorsista());
				}
				
				response.sendRedirect("validazioneriuscita.jsp");
				
			} catch (DAOException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			request.setAttribute("erroriServlet", errori);
			for(Map.Entry m : errori.entrySet())
			    System.out.println(m.getKey()+" "+m.getValue());
			RequestDispatcher rd = request.getRequestDispatcher("inserisciCorsista.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
