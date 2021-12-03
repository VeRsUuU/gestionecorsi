package test.com.milano.businesscomponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaBCTest {


	
	@Test
	void test() {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		try {

			ccBC.create(7,1);
			ccBC.create(7,3);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		try {
			HashMap<Integer, Integer> mappa = ccBC.getMap();
			
			for (Map.Entry<Integer, Integer> entry : mappa.entrySet()) {
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
			System.out.println();
		} catch (ClassNotFoundException | DAOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test3() {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		try {

			ccBC.delete(7,1);
			ccBC.delete(7,3);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test4() {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		try {
			HashMap<Integer, Integer> mappa = ccBC.getMap();
			 
			for (Map.Entry<Integer, Integer> entry : mappa.entrySet()) {
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		} catch (ClassNotFoundException | DAOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test5() {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		
			
			try {
				ArrayList<CorsoCorsista> lista = ccBC.getAll();
				for(CorsoCorsista cc : lista) {
					System.out.println(cc.getCodCorso()+"  "+cc.getCodCorsista());
				}
				
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
