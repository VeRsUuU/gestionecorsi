package test.com.milano.businesscomponent;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@Test
	@Order(1)
	void testGetAll() throws ClassNotFoundException, IOException {

		System.out.println("GetAll");

		try {
			CorsoBC bcCorso = new CorsoBC();
			ArrayList<Corso> corsi = bcCorso.getAll();
			for (int i = 0; i < corsi.size(); i++) {
				System.out.println(corsi.get(i).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testGetById() throws ClassNotFoundException, IOException {

		System.out.println("\nGet by ID");

		try {
			CorsoBC bcCorso = new CorsoBC();
			Corso corso = bcCorso.getById(1);
			System.out.println(corso.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(3)
	void testCorsoPiuFrequentato() throws ClassNotFoundException, IOException {

		System.out.println("\nCorsi più frequentati");
		try {

			CorsoBC cbc = new CorsoBC();
			try {
				ArrayList<Corso> corsi = cbc.getCorsoPiuFrequentato();
				for (int i = 0; i < corsi.size(); i++) {
					System.out.println(corsi.get(i).toString());
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Order(4)
	void testdtInizioUltimo() throws ClassNotFoundException, IOException {

		System.out.println("dsadasdasdasdasdasda");

		try {
			CorsoBC bcCorso = new CorsoBC();
			Corso corso = bcCorso.dataInizioUltimoCorso();
			System.out.println(corso.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Order(5)
	void testTotCommeti() throws ClassNotFoundException, IOException {

		System.out.println("commentiiiiiiiiii");

		try {
			CorsoBC bcCorso = new CorsoBC();
			Integer com= bcCorso.getotCommenti();
			System.out.println(com);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

}
