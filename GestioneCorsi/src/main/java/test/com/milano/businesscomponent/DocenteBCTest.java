package test.com.milano.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.DocenteBC;
import com.milano.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class DocenteBCTest {
	
	@Test
	@Order(1)
	void testGetById() throws ClassNotFoundException, IOException {
		try {
			Docente doc = new Docente();
			DocenteBC bc = new DocenteBC();
			doc = bc.getById(8);
			System.out.println("<--------Docente richiamato-------->");
			System.out.println(doc.getCodDocente());
			System.out.println(doc.getNomeDocente());
			System.out.println(doc.getCognomeDocente());
			System.out.println(doc.getCvDocente());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetDocenteMaxCorsi() throws ClassNotFoundException, IOException {
		try {
			Docente doc = new Docente();
			DocenteBC bc = new DocenteBC();
			doc = bc.getDocenteMaxCorsi();
			System.out.println("<--------Docente max corsi-------->");
			System.out.println(doc.getCodDocente());
			System.out.println(doc.getNomeDocente());
			System.out.println(doc.getCognomeDocente());
			System.out.println(doc.getCvDocente());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
