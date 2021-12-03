package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants{
	
	public ArrayList<CorsoCorsista> getAll(Connection conn) throws DAOException{
		try {
		
		ArrayList<CorsoCorsista> lista = new ArrayList<CorsoCorsista>();
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSO_CORSISTA);
		rs.beforeFirst();
		
		CorsoCorsista cc =null;
		
		while(rs.next()) {
			cc = new CorsoCorsista();
			cc.setCodCorso(rs.getLong(1));
			cc.setCodCorsista(rs.getLong(2));
			lista.add(cc);
		}

		return lista;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	public void create(Connection conn, long idCorso, long idCorsista) throws DAOException {
		try {
		PreparedStatement ps = conn.prepareStatement("insert into corso_corsista values(?,?)");
		ps.setLong(1,idCorso);
		ps.setLong(2,idCorsista);
		ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	public HashMap<Integer, Integer> getMap(Connection conn) throws DAOException{
		try {
		
		HashMap<Integer, Integer> mappa = new HashMap<Integer, Integer>();
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select cod_corso,nome_corso,data_inizio, data_fine, commento,aula_corso,costo_corso,count(cod_corso) "
				+ "from corso inner join corso_corsista using(cod_corso)"
				+ "group by cod_corso,nome_corso,data_inizio,data_fine,commento,aula_corso,costo_corso");
		
		rs.beforeFirst();
		int count = 0;
		
		while(rs.next()) {
			Integer c = (int) rs.getLong(1);
			
			count = rs.getInt(8);
			
			mappa.put(c, count);
		}

		return mappa;

		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	/////
	public HashMap<String, Integer> getMapPosti(Connection conn) throws DAOException{
		String SELECT_POSTI_D="select nome_corso ,count(corso_corsista.cod_corso)as postioccupati\r\n"
				+ "	from corso\r\n"
				+ "	left join corso_corsista \r\n"
				+ "	on corso_corsista.cod_corso = corso.cod_corso\r\n"
				+ "	group by nome_corso\r\n";
		
		
		try {	
			HashMap<String, Integer> mappa = new HashMap<String, Integer>();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_POSTI_D);
			rs.beforeFirst();
			int posti = 0;
			while(rs.next()) {
				String nome = rs.getString(1);
				
				posti = rs.getInt(2);
				
				mappa.put(nome,posti);
			}

			return mappa;
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		
		
		
		
	}
	
	

	public void delete(Connection conn, long idCorso, long idCorsista) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from corso_corsista where cod_corso = ? and cod_corsista = ?");
			ps.setLong(1,idCorso);
			ps.setLong(2,idCorsista);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	} 
}
