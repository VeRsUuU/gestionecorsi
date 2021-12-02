package com.milano.businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import com.milano.architecture.dao.DAOException;


import com.milano.businesscomponent.AdminFacade;
import com.milano.businesscomponent.model.Admin;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;
import com.milano.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade istanza;

	//singleton pattern
	public static AdminFacade getIstance() {
		if (istanza == null) {
			istanza = new AdminFacade();
		}
		return istanza;
	}
	
	
	//metodi facade
	
	//metodo admin
	public Admin getByIdAdmin(Admin admin)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		AdminBC adminBC = new AdminBC();

		return adminBC.getById(admin);

	}

	//metodi corsi
	public Corso getByIdCorsi(long id)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC();

		return corsoBC.getById(id);

	}
	

	public ArrayList<Corso> getAllCorso() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		return corsoBC.getAll();

	}
	public ArrayList<Corso> getCorsoPiuFrequentato() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		return corsoBC.getCorsoPiuFrequentato();

	}
	
	//metodi corsista
	
	public void createCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		corsistaBC.create(corsista);

	}
	public Corsista getByIdCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();

		return corsistaBC.getById(corsista);

	}
	
	public void deleteCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		
		corsistaBC.delete(corsista);

	}
	
	public Corsista[] getAllCorsista() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		return corsistaBC.getAll();

	}
	
	//metodi Corso_Corsista
	
	public HashMap<Corso,Integer> getIscritti() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
	CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
		return ccBC.getMap();
	}
	
	public void createCorsoCorsista(long idcorso, long idcorsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
		ccBC.create(idcorso, idcorsista);;

	}
	public void deleteCorsoCorsista(long idcorso, long idcorsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
		ccBC.delete(idcorso, idcorsista);;

	}
	
	public ArrayList<CorsoCorsista> getAllCorsoCorsista() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoCorsistaBC ccBC=new CorsoCorsistaBC();
		return ccBC.getAll();

	}
	
	//metodi docente
	
	public Docente getByIdDocente(long codDocente)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		DocenteBC dBC=new DocenteBC();

		return  dBC.getById(codDocente);

	}
	public Docente getMaxCorsi()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		DocenteBC dBC=new DocenteBC();

		return  dBC.getDocenteMaxCorsi();

	}
	
	

	
}