package com.milano.architecture.dao;

// CorsistaDAO - Luca Lo Piccolo

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;

public class CorsistaDAO {

	private CachedRowSet rowSet;

	public CorsistaDAO() throws DAOException {

		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public void create(Connection conn, Corsista model) throws DAOException {

		try {
			rowSet.setCommand("select * from corsista");
			rowSet.execute(conn);
			rowSet.moveToInsertRow();

			rowSet.updateLong(3, model.getCodCorsista());
			rowSet.updateString(1, model.getNomeCorsista());
			rowSet.updateString(2, model.getCognomeCorsista());
			rowSet.updateByte(4, model.getPrecedentiFormativi());
			rowSet.insertRow();

			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public void delete(Connection conn, Corsista model) throws DAOException {

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("delete from corsista where cod_corsista = ?");
			ps.setLong(1, model.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public Corsista[] getAll(Connection conn) throws DAOException {

		Corsista[] corsisti = null;

		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from corsista");
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();

			for (int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setCodCorsista(rs.getLong(3));
				c.setNomeCorsista(rs.getString(1));
				c.setCognomeCorsista(rs.getString(2));
				c.setPrecedentiFormativi(rs.getByte(4));
				corsisti[i] = c;
			}

			rs.close();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

		return corsisti;

	}

	public Corsista getById(Connection conn, Corsista model) throws DAOException {

		Corsista corsista = null;

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("select * from corsista where cod_corsista = ?");
			ps.setLong(1, model.getCodCorsista());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				corsista = new Corsista();
				corsista.setCodCorsista(rs.getLong(3));
				corsista.setNomeCorsista(rs.getString(1));
				corsista.setCognomeCorsista(rs.getString(2));
				corsista.setPrecedentiFormativi(rs.getByte(4));
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

		return corsista;
	}

	public ArrayList<Corso> getCorsiByIdCorsista(Connection conn, long id) throws DAOException {
		ArrayList<Corso> corsi = null;
		PreparedStatement ps;
		CorsoDAO cdao = new CorsoDAO();

		try {
			ps = conn.prepareStatement("select cod_corso from corso_corsista where cod_corsista = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				corsi = new ArrayList<Corso>();
				Corso corso = new Corso();
				corso = cdao.getById(conn, rs.getLong(1));
				corsi.add(corso);
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return corsi;
	}

}
