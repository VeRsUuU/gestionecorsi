//creato da Zoia Simone

package com.milano.businesscomponent.model;

public class Docente {
	private long codDocente;
	private String nome;
	private String cognome;
	private String cvDocente;

	public long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}

	public String getNomeDocente() {
		return nome;
	}

	public void setNomeDocente(String nome) {
		this.nome = nome;
	}

	public String getCognomeDocente() {
		return cognome;
	}

	public void setCognomeDocente(String cognome) {
		this.cognome = cognome;
	}

	public String getCvDocente() {
		return cvDocente;
	}

	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}

}
