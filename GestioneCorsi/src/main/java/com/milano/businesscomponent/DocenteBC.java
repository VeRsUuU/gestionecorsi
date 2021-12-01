//creato da Zoia Simone

package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.SQLException;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Docente;

public class DocenteBC {

	public Docente getById(long codDocente) throws DAOException, ClassNotFoundException, IOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			return dao.getById(DBAccess.getConnection(), codDocente);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Docente getDocenteMaxCorsi() throws DAOException, ClassNotFoundException, IOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			return dao.getDocenteMaxCorsi(DBAccess.getConnection());
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
