package com.milano.businesscomponent.utilities;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corso;

public class Validazione {

	public static HashMap<String, String> valida(String nomeCorsista, 
			String cognomeCorsista,
			HashMap<Integer, Date[]> mappa) 
					throws DAOException {
		HashMap<String, String> errori = new HashMap<String, String>();
		try {
			Pattern pattern = Pattern.compile("[a-zA-Z]{3,30}");
			Matcher matcher = pattern.matcher(nomeCorsista);

			if (matcher.matches() == false) {
				errori.put("errorNome", "Il campo nome non è valido");
			}

			pattern = Pattern.compile("[a-zA-Z]{3,30}");
			matcher = pattern.matcher(cognomeCorsista);

			if (matcher.matches() == false) {
				errori.put("errorCognome", "Il campo cognome non è valido");
			}

			Set<Integer> keys = mappa.keySet();

			for (Integer key : keys) {
				Date[] date = mappa.get(key);

				if (date[0] != null && date[1] != null) {

					CorsoBC cBC = new CorsoBC();

					Corso c = cBC.getById((long) key);
					if (date[0] != null && date[1] != null) {
						if (date[0].before(c.getDataInizio()) || date[1].after(c.getDataFine())) {
							errori.put("errorData_" + c.getNome(),
									"Errore nell'inserimento della data relativa al corso: " + c.getNome());
						}
					} else {
						errori.put("errorDataMancante" + c.getNome(),
								"Errore data mancante relativa al corso: " + c.getNome());
					}

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
