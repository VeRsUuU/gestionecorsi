package test.com.milano.businesscomponent.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.utilities.Validazione;

class ValidazioneTest {


	@Test
	void test() throws DAOException {
		HashMap<Integer, Date[]> mappa = new HashMap<Integer, Date[]>();
		Date[] d = new Date[2];
		GregorianCalendar g = new GregorianCalendar(2021,10,10);
		d[0] = g.getTime();
		GregorianCalendar g2 = new GregorianCalendar(2021,10,15);
		d[1] = g2.getTime();
		
		mappa.put(1, d);
		
		HashMap<String, String> map = Validazione.valida("giovanni", "pierino", mappa);
		
		if(map.isEmpty()) {
			System.out.println("non ci sono errori, corsista effettuato");
		} else {
			for(Map.Entry m : map.entrySet())
		    System.out.println(m.getKey()+" "+m.getValue());
		}
		
		

		
	}

}
