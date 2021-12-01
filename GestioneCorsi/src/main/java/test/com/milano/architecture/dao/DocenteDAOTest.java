//creato da Zoia Simone

package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
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
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	@Order(1)
	void testGetById() {
		try {
			DocenteDAO dao = new DocenteDAO();
			Docente doc = dao.getById(conn, 8);
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
	void testGetDocenteMaxCorsi() {
		try {
			DocenteDAO dao = new DocenteDAO();
			Docente doc = dao.getDocenteMaxCorsi(conn);
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
			conn.close();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
	}
}
