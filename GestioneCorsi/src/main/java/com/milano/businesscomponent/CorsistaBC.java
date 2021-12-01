package com.milano.businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;

public class CorsistaBC {

	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create (Corsista corsista) throws DAOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsistaDAO.create(conn, corsista);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista getById(Corsista corsista) throws DAOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			return corsistaDAO.getById(conn, corsista);
		}catch(SQLException exc) {
			throw new DAOException(exc);
		}finally {
			DBAccess.closeConnection();
		}
	}

	
	public void delete(Corsista corsista) throws DAOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsistaDAO.delete(conn, corsista);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista[] getAll() throws DAOException{
		Corsista[] corsisti = null;
		
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsisti = corsistaDAO.getAll(conn);
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsisti;
	}
	
	
	
}
