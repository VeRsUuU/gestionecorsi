package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.AdminBC;
import com.milano.businesscomponent.model.Admin;
/*
 * create by
 * Danilo Cordova 
 * 
 * */

@TestMethodOrder(OrderAnnotation.class)
class TestDAOeBC {


	@Test
	@Order(1)
	void testDAOeBC(){
		
		try {
			
			AdminBC admin=new AdminBC();
			Admin adminn=new Admin();
			adminn.setUsername("max");
			admin.getById(adminn);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		
	}

}
