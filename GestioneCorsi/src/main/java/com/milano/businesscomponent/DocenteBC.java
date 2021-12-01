//creato da Zoia Simone

package com.milano.businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Docente;

public class DocenteBC {

	private Connection conn;

	public DocenteBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docente getById(long codDocente) throws DAOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			return dao.getById(conn, codDocente);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Docente getDocenteMaxCorsi() throws DAOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			return dao.getDocenteMaxCorsi(conn);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
