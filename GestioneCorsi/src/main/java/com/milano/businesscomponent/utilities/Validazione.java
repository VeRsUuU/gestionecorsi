package com.milano.businesscomponent.utilities;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corso;

public class Validazione { 

	public static HashMap<String, String> valida(String nomeCorsista, String cognomeCorsista,
			HashMap<Integer, Date[]> mappa) throws DAOException {
		HashMap<String, String> errori = new HashMap<String, String>();
		try {
			Pattern pattern = Pattern.compile("[a-zA-Z .']{3,30}");
			Matcher matcher = pattern.matcher(nomeCorsista);

			if (matcher.matches() == false) {
				errori.put("errorNome", "Il campo nome non è valido");
			}

			Pattern pattern2 = Pattern.compile("[a-zA-Z .']{3,30}");
			Matcher matcher2 = pattern2.matcher(cognomeCorsista);

			if (matcher2.matches() == false) {
				errori.put("errorCognome", "Il campo cognome non è valido");
			}

			Set<Integer> keys = mappa.keySet();

			for (Integer key : keys) {
				Date[] date = mappa.get(key);
				CorsoBC cBC = new CorsoBC();
				Corso c = cBC.getById((long) key);


				


				if (date[0] != null && date[1] != null) {
					
					Calendar dataInizioPiu2 = Calendar.getInstance();
					dataInizioPiu2.setTime(date[0]);
					dataInizioPiu2.add(Calendar.DAY_OF_YEAR, 1);

					Calendar dataFine = Calendar.getInstance();
					dataFine.setTime(date[1]);
  
					if (date[0].before(c.getDataInizio()) || date[1].after(c.getDataFine()))
						errori.put("errorData_" + c.getCod(), "Il corso " + c.getNome() + " deve essere compreso tra : "
								+ c.getDataInizio() + " e " + c.getDataFine());

					if (date[0].after(date[1])) {
						errori.put("errorDataInvertita_" + c.getCod(),
								"Impossibile inserire una data di inizio minore della data di fine: " + c.getNome());
					} else if (dataInizioPiu2.after(dataFine)) {
						errori.put("errorDataInterval_" + c.getCod(),
								"Il corso deve durare almeno 2 gg: " + c.getNome());
					}

				} else {
					errori.put("errorDataMancante_" + c.getCod(),
							"Errore data mancante relativa al corso: " + c.getNome());
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return errori;
	}

}
