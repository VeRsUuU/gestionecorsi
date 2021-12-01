package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO {
	
	private ArrayList<CorsoCorsista> getAll(Connection conn) throws SQLException{
		ArrayList<CorsoCorsista> lista = new ArrayList<CorsoCorsista>();
		
		Statement stmt = conn.createStatement();
		
		
		return lista;
	}
}
