package test.com.milano.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;


class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("connessione non funzionante");
		} finally {
			try {
				DBAccess.closeConnection();
			} catch(DAOException e) {
				e.printStackTrace();
				fail("impossibile chiudere la connessione");
			}
		}
	}

}
