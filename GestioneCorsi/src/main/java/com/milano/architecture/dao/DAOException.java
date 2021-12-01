package com.milano.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {

	private static final long serialVersionUID = -4782527654320984047L;
	
	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;
 
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if (sql != null) {
			switch (sql.getErrorCode()) {
			case ORA1017:
				chiave = "Username / password errati";
				log(sql);
				break;
			case ORA17002:
				chiave = "I/O Exception di Oracle DB";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;

			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
				break;
			}
		}
		
		message = chiave;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: "+sql.getMessage());
		System.err.println("Stato dell'app: "+sql.getSQLState());	
		System.err.println("Error code: "+sql.getErrorCode());
		System.err.println("Causa dell'eccezione: "+sql.getCause());
	}
	
	

}
