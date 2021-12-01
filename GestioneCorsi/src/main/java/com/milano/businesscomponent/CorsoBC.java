package com.milano.businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;

public class CorsoBC {

	private Connection conn;

	public CorsoBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void getById(Corso corso) throws DAOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			corsoDAO.getById(conn, corso);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public ArrayList<Corso> getAll() throws DAOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getAll(conn);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public ArrayList<Corso> getCorsoPiuFrequentato() throws DAOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getCorsoPiuFrequentato(conn);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
