package test.com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {

	private static Connection conn;
	private static Corsista corsista1, corsista2, corsista3, corsista4, corsista5, corsista6, corsista7;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		conn = DBAccess.getConnection();

		corsista1 = new Corsista();
		corsista1.setNome_corsista("Danilo");
		corsista1.setCognome_corsista("Cordova");
		corsista1.setCod_corsista(1);
		corsista1.setPrecedenti_formativi((byte) 1);

		corsista2 = new Corsista();
		corsista2.setNome_corsista("Mario");
		corsista2.setCognome_corsista("Cordova");
		corsista2.setCod_corsista(2);
		corsista2.setPrecedenti_formativi((byte) 1);

		corsista3 = new Corsista();
		corsista3.setNome_corsista("Giuseppe");
		corsista3.setCognome_corsista("Cordova");
		corsista3.setCod_corsista(3);
		corsista3.setPrecedenti_formativi((byte) 1);

		corsista4 = new Corsista();
		corsista4.setNome_corsista("Raijon");
		corsista4.setCognome_corsista("Cordova");
		corsista4.setCod_corsista(4);
		corsista4.setPrecedenti_formativi((byte) 1);

		corsista5 = new Corsista();
		corsista5.setNome_corsista("Franco");
		corsista5.setCognome_corsista("Cordova");
		corsista5.setCod_corsista(5);
		corsista5.setPrecedenti_formativi((byte) 1);

		corsista6 = new Corsista();
		corsista6.setNome_corsista("Gianni");
		corsista6.setCognome_corsista("Cordova");
		corsista6.setCod_corsista(6);
		corsista6.setPrecedenti_formativi((byte) 1);

		corsista7 = new Corsista();
		corsista7.setNome_corsista("Anna");
		corsista7.setCognome_corsista("Cordova");
		corsista7.setCod_corsista(7);
		corsista7.setPrecedenti_formativi((byte) 1);

	}

	@Test
	@Order(1)
	void testGetAll() {
		
		System.out.println("GetAll");

		try {
			CorsoDAO daoCorso = new CorsoDAO();
			ArrayList<Corso> corsi = daoCorso.getAll(conn);
			for (int i = 0; i < corsi.size(); i++) {
				System.out.println(corsi.get(i).toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(2)
	void testGetById() {

		System.out.println("\nGet by ID");
		
		try {
			CorsoDAO daoCorso = new CorsoDAO();
			Corso corso = daoCorso.getById(conn, 1);
			System.out.println(corso.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Order(3)
	void testCorsoPiuFrequentato() {

		System.out.println("\nCorsi più frequentati");
		try {
			CorsistaDAO daoCorsisti = new CorsistaDAO();
			daoCorsisti.create(conn, corsista1);
			daoCorsisti.create(conn, corsista2);
			daoCorsisti.create(conn, corsista3);
			daoCorsisti.create(conn, corsista4);
			daoCorsisti.create(conn, corsista5);
			daoCorsisti.create(conn, corsista6);
			daoCorsisti.create(conn, corsista7);

			CorsoCorsistaDAO ccDao = new CorsoCorsistaDAO();
			ccDao.create(conn, 1, 1);
			ccDao.create(conn, 1, 2);
			ccDao.create(conn, 2, 3);
			ccDao.create(conn, 2, 4);
			ccDao.create(conn, 3, 5);
			ccDao.create(conn, 3, 6);
			ccDao.create(conn, 3, 7);

			CorsoDAO daoCorso = new CorsoDAO();
			ArrayList<Corso> corsi2 = daoCorso.getCorsoPiuFrequentato(conn);
			for (int i = 0; i < corsi2.size(); i++) {
				System.out.println(corsi2.get(i).toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		CorsistaDAO daoCorsisti = new CorsistaDAO();
		daoCorsisti.delete(conn, corsista1);
		daoCorsisti.delete(conn, corsista2);
		daoCorsisti.delete(conn, corsista3);
		daoCorsisti.delete(conn, corsista4);
		daoCorsisti.delete(conn, corsista5);
		daoCorsisti.delete(conn, corsista6);
		daoCorsisti.delete(conn, corsista7);
		conn.close();
	}

}
