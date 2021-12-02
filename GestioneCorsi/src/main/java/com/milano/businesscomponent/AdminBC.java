package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.SQLException;

import com.milano.architecture.dao.AdminDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Admin;

public class AdminBC {
	/*
	 * create by Raijon bida
	 * 
	 */

	public Admin getById(Admin admin) throws DAOException, ClassNotFoundException, IOException {
		AdminDAO a = new AdminDAO();
		try {
			return a.getById(DBAccess.getConnection(), admin);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Admin getById(String username) throws DAOException, ClassNotFoundException, IOException {
		AdminDAO a = new AdminDAO();
		try {
			return a.getById(DBAccess.getConnection(), username);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}

}
