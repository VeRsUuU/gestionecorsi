package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;
	 //provaaa
	public HashMap<Integer, Integer> getMap() throws ClassNotFoundException, IOException, DAOException{

		HashMap<Integer, Integer> mappa = null;
		
			try {
				conn = DBAccess.getConnection();
				CorsoCorsistaDAO ccDAO = new CorsoCorsistaDAO();
				mappa = ccDAO.getMap(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBAccess.closeConnection();
			}
		return mappa;
		
	}
	
	
	
	
	public void create(long idCorso, long idCorsista) throws DAOException {
		try {
			conn = DBAccess.getConnection();
			CorsoCorsistaDAO ccDAO = new CorsoCorsistaDAO();
			ccDAO.create(conn, idCorso, idCorsista);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeConnection();
		}
		
	}
	
	public void delete(long idCorso, long idCorsista) throws DAOException {
		try {
			conn = DBAccess.getConnection();
			CorsoCorsistaDAO ccDAO = new CorsoCorsistaDAO();
			ccDAO.delete(conn, idCorso, idCorsista);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeConnection();
		}
		
	}
	
	public ArrayList<CorsoCorsista> getAll() throws DAOException {
		ArrayList<CorsoCorsista> lista = null;
		try {
			conn = DBAccess.getConnection();
			CorsoCorsistaDAO ccDAO = new CorsoCorsistaDAO();
			lista = ccDAO.getAll(conn);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeConnection();
		}
		return lista;
		
	}
}
