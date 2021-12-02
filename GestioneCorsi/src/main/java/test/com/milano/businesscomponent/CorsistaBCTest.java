package test.com.milano.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {
	
	private static Corsista corsista;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setCodCorsista(39);
		corsista.setNomeCorsista("Luca");
		corsista.setCognomeCorsista("Lo Piccolo");
		corsista.setPrecedentiFormativi((byte)1);
	}
	
	@Test
	@Order(1)
	void testCreate() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			CorsistaBC bc = new CorsistaBC();
			bc.create(corsista);
			System.out.println("Corsista creato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(5)
	void testDelete() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			CorsistaBC bc = new CorsistaBC();
			bc.delete(corsista);
			System.out.println("Corsista eliminato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testGetAll() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			CorsistaBC bc = new CorsistaBC();
			Corsista[] corsisti = bc.getAll();
			assertNotNull(corsisti);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetById() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			CorsistaBC bc = new CorsistaBC();
			assertNotNull(bc.getById(corsista));
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(4)
	void testtotCorsista() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			CorsistaBC bc = new CorsistaBC();
			System.out.println("tot "+ bc.getTotCorsisti());
			assertNotNull(bc.getTotCorsisti());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
