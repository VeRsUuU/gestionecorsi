package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;

public class CorsistaBC {
	
	public void create (Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsistaDAO.create(DBAccess.getConnection(), corsista);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Corsista getById(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			return corsistaDAO.getById(DBAccess.getConnection(), corsista);
		}catch(SQLException exc) {
			throw new DAOException(exc);
		} finally {
			DBAccess.closeConnection();
		}
	}

	
	public void delete(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsistaDAO.delete(DBAccess.getConnection(), corsista);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Corsista[] getAll() throws DAOException, ClassNotFoundException, IOException{
		Corsista[] corsisti = null;
		try {
			CorsistaDAO corsistaDAO = new CorsistaDAO();
			corsisti = corsistaDAO.getAll(DBAccess.getConnection());
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		} finally {
			DBAccess.closeConnection();
		}
		return corsisti;
	}
	
	
	
}
