package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.milano.businesscomponent.model.Corso;
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
	
	public HashMap<Corso, Integer> getMap(Connection conn) throws DAOException{
		try {
		
		HashMap<Corso, Integer> mappa = new HashMap<Corso, Integer>();
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select cod_corso,nome_corso,data_inizio, data_fine, commento,aula_corso,costo_corso,count(cod_corso) "
				+ "from corso inner join corso_corsista using(cod_corso) "
				+ "group by cod_corso,nome_corso,data_inizio,data_fine,commento,aula_corso,costo_corso");
		
		rs.beforeFirst();
		Corso c = null;
		int count = 0;
		
		while(rs.next()) {
			c = new Corso();
			c.setCod(rs.getLong(1));
			c.setNome(rs.getString(2));
			c.setDataInizio(new Date(rs.getDate(3).getTime()));
			c.setDataFine(new Date(rs.getDate(4).getTime()));
			c.setCommenti(rs.getString(5));
			c.setAula(rs.getString(6));
			c.setCosto(rs.getDouble(7));
			
			count = rs.getInt(8);
			
			mappa.put(c, count);
		}

		return mappa;

		}catch(SQLException e) {
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
