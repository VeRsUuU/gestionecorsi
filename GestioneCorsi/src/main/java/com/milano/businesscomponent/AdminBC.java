package com.milano.businesscomponent;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.milano.architecture.dao.AdminDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Admin;



public class AdminBC {
	/*
	 * create by
	 * Raijon bida
	 * 
	 * */
	private Connection conn;
	
	public AdminBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Admin getById(Admin admin) throws DAOException {
		try {
			return AdminDAO.getFactory().getById(conn, admin);
		}catch(SQLException exc) {
			throw new DAOException(exc);
		}finally {
			DBAccess.closeConnection();
		}
	}
	
	
	
	
	
}
