package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.model.Admin;

public class AdminDAO implements DAOConstants{
	
	public static AdminDAO getFactory() throws DAOException {
		return new AdminDAO();
	}
	
	
	
	private String SELECT_ADMIN_BYID="select * from amministratore where username=?";
	
	@Override// per implemento GEnerciDAO
	public Admin getById(Connection conn, Admin model) throws DAOException {
		Admin admin=null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ADMIN_BYID);
			ps.setString(1, model.getUsername());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setNomeAdmin(rs.getString(1));
				admin.setCognomeAdmin(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setUsername(rs.getString(4));				
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return admin;
	}

}
