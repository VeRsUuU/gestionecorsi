package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;



import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoCorsistaBC;

@TestMethodOrder(OrderAnnotation.class)
class TestCorsoCorsistaDAO {

	@Test
	@Order(1)
	void testMappaPosti() throws ClassNotFoundException, IOException {
		try {
			CorsoCorsistaBC dao = new CorsoCorsistaBC();
			HashMap<String, Integer> mappa  = dao.getMapPosti();
			System.out.println(mappa);
			assertNotNull(mappa);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
