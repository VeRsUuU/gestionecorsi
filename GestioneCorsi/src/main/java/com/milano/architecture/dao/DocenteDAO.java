//creato da Zoia Simone

package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.businesscomponent.model.Docente;

public class DocenteDAO {
	String SELECT_DOCENTE_BYID = "Select * from docente where cod_docente = ?";
	String SELECT_DOCENTE_MAX_CORSI = "select cod_docente, count(cod_docente) from docente inner join corso using (cod_docente) group by cod_docente";

	public Docente getById(Connection conn, long codDocente) throws DAOException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYID);
			ps.setLong(1, codDocente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				docente = new Docente();
				docente.setCodDocente(rs.getLong(1));
				docente.setNomeDocente(rs.getString(2));
				docente.setCognomeDocente(rs.getString(3));
				docente.setCvDocente(rs.getString(4));
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return docente;
	}

	public Docente getDocenteMaxCorsi(Connection conn) throws DAOException {
		Docente docente = null;
		DocenteDAO dao = new DocenteDAO();
		int max = 0;
		int cod = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_MAX_CORSI);

			while (rs.next()) {
				if (max < rs.getInt(2)) {
					cod = rs.getInt(1);
					max = rs.getInt(2);
				}
			}
			docente = dao.getById(conn, cod);
		} catch (SQLException exc) {
			exc.printStackTrace();
			throw new DAOException(exc);
		}
		return docente;
	}
}
