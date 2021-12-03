package com.milano.architecture.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.milano.businesscomponent.model.Corso;

public class CorsoDAO {

	private final String SELECT_CORSI = "select * from corso";
	private final String SELECT_CORSI_BYID = "select * from corso where cod_corso = ?";
	
	private final String SELECT_DURATA_CORSI="select data_inizio, data_fine\r\n"
			+ "from corso\r\n"
			+ "order by data_inizio desc";

	public ArrayList<Corso> getAll(Connection conn) throws DAOException {
		ArrayList<Corso> corsi = null;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_CORSI);
			corsi = new ArrayList<Corso>();

			while (rs.next()) {
				Corso c = new Corso();
				c.setCod(rs.getLong(1));
				c.setNome(rs.getString(3));
				c.setDataInizio(new Date(rs.getDate(4).getTime()));
				c.setDataFine(new Date(rs.getDate(5).getTime()));
				c.setCommenti(rs.getString(6));
				c.setAula(rs.getString(7));
				c.setCosto(rs.getDouble(8));
				corsi.add(c);
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;

	}

	public Corso getById(Connection conn, long id) throws DAOException {
		Corso corso = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CORSI_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corso = new Corso();
				corso.setCod(rs.getLong(1));
				corso.setNome(rs.getString(3));
				corso.setDataInizio(new Date(rs.getDate(4).getTime()));
				corso.setDataFine(new Date(rs.getDate(5).getTime()));
				corso.setCommenti(rs.getString(6));
				corso.setAula(rs.getString(7));
				corso.setCosto(rs.getDouble(8));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	public ArrayList<Integer> getCodCorsoPiuFrequentato(Connection conn) throws DAOException {
		ArrayList<Integer> corsi = null;
		try {
			CorsoCorsistaDAO ccDao = new CorsoCorsistaDAO();
			HashMap<Integer, Integer> prenotazioni = ccDao.getMap(conn);
			int max = Collections.max(prenotazioni.values());
			corsi = new ArrayList<Integer>();
			for (Entry<Integer, Integer> entry : prenotazioni.entrySet()) {
				if (entry.getValue() == max) {
					corsi.add(entry.getKey());
				}
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public Corso getinizioUltimo(Connection conn) throws DAOException {
		String SELECT_ULTIMO_INIZIO="select nome_corso, data_inizio  from(select nome_corso, data_inizio from corso order by data_inizio desc )where ROWNUM = 1";
		Corso corso = null;
		try {
			corso=new Corso();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ULTIMO_INIZIO);
			rs.next();
			corso.setNome(rs.getString(1));
			corso.setDataInizio(new Date(rs.getDate(2).getTime()));
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	public Integer getotCommenti(Connection conn) throws DAOException {
		String TOT_COMENTI="select count(commento) from corso";
		Integer a;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(TOT_COMENTI);
			rs.next();
			a=rs.getInt(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return a;
	}
	
	public ArrayList<Long> durataCorsi(Connection conn) throws DAOException {
		ArrayList<Long>durata = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_DURATA_CORSI);
			Date dtInizio;
			Date dtFine;
			durata=new ArrayList<Long>();
			while(rs.next()) {
				dtInizio=rs.getDate(1);
				dtFine=rs.getDate(2);
				long in=dtInizio.getTime();
				long fi=dtFine.getTime();
				long d=(long)(fi-in);
				long days = TimeUnit.MILLISECONDS.toDays(d);
				durata.add(days);
			}
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return durata;
	}

}
