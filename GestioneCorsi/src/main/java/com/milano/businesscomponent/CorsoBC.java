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

	public void getById(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			corsoDAO.getById(DBAccess.getConnection(), corso);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		DBAccess.closeConnection();
	}

	public ArrayList<Corso> getAll() throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getAll(DBAccess.getConnection());
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public ArrayList<Corso> getCorsoPiuFrequentato() throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoDAO corsoDAO = new CorsoDAO();
			return corsoDAO.getCorsoPiuFrequentato(DBAccess.getConnection());
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
