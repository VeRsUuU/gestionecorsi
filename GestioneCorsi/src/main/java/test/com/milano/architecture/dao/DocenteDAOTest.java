//creato da Zoia Simone

package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class DocenteDAOTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DBAccess.getConnection();
	}

	@Test
	@Order(1)
	void testGetById() throws ClassNotFoundException, IOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			Docente doc = dao.getById(DBAccess.getConnection(), 8);
			System.out.println("<--------Docente richiamato-------->");
			System.out.println(doc.getCodDocente());
			System.out.println(doc.getNomeDocente());
			System.out.println(doc.getCognomeDocente());
			System.out.println(doc.getCvDocente());
		} catch (NullPointerException | DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testGetDocenteMaxCorsi() throws ClassNotFoundException, IOException {
		try {
			DocenteDAO dao = new DocenteDAO();
			Docente doc = dao.getDocenteMaxCorsi(DBAccess.getConnection());
			System.out.println("<--------Docente max corsi-------->");
			System.out.println(doc.getCodDocente());
			System.out.println(doc.getNomeDocente());
			System.out.println(doc.getCognomeDocente());
			System.out.println(doc.getCvDocente());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
	}
}
