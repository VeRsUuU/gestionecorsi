package com.milano.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;


public class CorsistaIdGenerator implements DAOConstants{
	private static CorsistaIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator()
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsistaIdGenerator getInstance()
			throws ClassNotFoundException, DAOException, IOException {
		if(istanza == null) 
			istanza = new CorsistaIdGenerator();
		return istanza;
	}
	
	public long getNextId() throws DAOException, ClassNotFoundException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select corsista_seq.nextval from dual");
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		
		return id;
	}

}
