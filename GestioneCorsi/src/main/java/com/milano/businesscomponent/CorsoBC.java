package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;

public class CorsoBC {

	public Corso getById(long id) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getById(DBAccess.getConnection(), id);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DBAccess.closeConnection();
		}

	}

	public ArrayList<Corso> getAll() throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getAll(DBAccess.getConnection());
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DBAccess.closeConnection();
		}

	}

	public ArrayList<Corso> getCorsoPiuFrequentato() throws DAOException, ClassNotFoundException, IOException {

		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			Connection conn = DBAccess.getConnection();
			ArrayList<Integer> codCorsi = corsoDAO.getCodCorsoPiuFrequentato(conn);
			ArrayList<Corso> corsi = new ArrayList<Corso>(codCorsi.size());
			for (int i = 0; i < codCorsi.size(); i++) {
				corsi.add(corsoDAO.getById(conn, codCorsi.get(i)));
			}
			return corsi;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	//metodod data inzio ultimo corso()
	public Corso dataInizioUltimoCorso() throws ClassNotFoundException, IOException, DAOException {
		
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			Connection conn = DBAccess.getConnection();
			return corsoDAO.getinizioUltimo(conn);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DBAccess.closeConnection();
		}
		

		
	}

}
