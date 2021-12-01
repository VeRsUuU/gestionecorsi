package com.milano.architecture.dao;

public interface DAOConstants {
	
	//CORSOCORSISTA
	String SELECT_CORSO_CORSISTA = "select * from corso_corsista";
	String SELECT_MAP_POSTI_RIMANENTI = "select cod_corso, count(cod_corso) from corso_corsista group by cod_corso order by cod_corso";
}
