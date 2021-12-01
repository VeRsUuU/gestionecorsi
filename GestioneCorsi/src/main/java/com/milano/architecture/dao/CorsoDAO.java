package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.businesscomponent.model.Corso;

public class CorsoDAO {

	private final String SELECT_CORSI = "select * from corso";
	private final String SELECT_CORSI_BYID = "select * from corso where cod_corso = ?";
	private final String SELECT_CORSO_PIU_FREQUENTATO = "select t.*\r\n"
			+ "from (select corso.*, count(corso_corsista.cod_corso) as iscritti\r\n"
			+ "from corso, corso_corsista, docente, corsista\r\n"
			+ "where corso.cod_corso = corso_corsista.cod_corso and corso.cod_docente = docente.cod_docente and corsista.cod_corsista = corso_corsista.cod_corsista\r\n"
			+ "group by corso.cod_corso,corso.cod_docente,corso.nome_corso,corso.data_inizio,corso.data_fine,corso.commento,corso.aula_corso,corso.costo_corso) t";

	private CachedRowSet rowSet;

	public CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

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

	public Corso getById(Connection conn, Corso model) throws DAOException {
		Corso corso = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CORSI_BYID);
			ps.setLong(1, model.getCod());
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

	public ArrayList<Corso> getCorsoPiuFrequentato(Connection conn) throws DAOException {
		ArrayList<Corso> corsi = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_CORSO_PIU_FREQUENTATO);
			while (rs.next()) {
				corsi = new ArrayList<Corso>();
				Corso corso = new Corso();
				corso.setCod(rs.getLong(1));
				corso.setNome(rs.getString(3));
				corso.setDataInizio(new Date(rs.getDate(4).getTime()));
				corso.setDataFine(new Date(rs.getDate(5).getTime()));
				corso.setCommenti(rs.getString(6));
				corso.setAula(rs.getString(7));
				corso.setCosto(rs.getDouble(8));
				corsi.add(corso);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

}
