package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

// Test CorsistaDAO - Luca Lo Piccolo

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	
	private static Connection conn;
	private static Corsista corsista;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(39);
		corsista.setNomeCorsista("Luca");
		corsista.setCognomeCorsista("Lo Piccolo");
		corsista.setPrecedentiFormativi((byte)1);
		
	}

	@Test
	@Order(1)
	void testCreate() {

		try {
			CorsistaDAO dao = new CorsistaDAO();
			dao.create(conn, corsista);
			System.out.println("Corsista creato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
		
	}

	@Test
	@Order(4)
	void testDelete() {
		
		try {
			CorsistaDAO dao = new CorsistaDAO();
			dao.delete(conn, corsista);
			System.out.println("Corsista eliminato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
		
	}

	@Test
	@Order(2)
	void testGetAll() {
		
		try {
			CorsistaDAO dao = new CorsistaDAO();
			Corsista[] corsisti = dao.getAll(conn);
			assertNotNull(corsisti);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
		
	}

	@Test
	@Order(3)
	void testGetById() {
		
		try {
			CorsistaDAO dao = new CorsistaDAO();
			assertNotNull(dao.getById(conn, corsista));
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
		
	}
	
	@AfterEach
	void TearDownAfterClass() throws DAOException {
		
		try {
			conn.close();
			corsista = null;
		} catch(SQLException exc) {
			throw new DAOException(exc);
		}
		
	}

}
