package com.milano.businesscomponent.model;

import java.util.Date;

public class Corso {

	private long cod;
	private String nome;
	private Date dataInizio;
	private Date dataFine;
	private double costo;
	private String commenti;
	private String aula;

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getCommenti() {
		return commenti;
	}

	public void setCommenti(String commenti) {
		this.commenti = commenti;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Corso [cod=" + cod + ", nome=" + nome + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ ", costo=" + costo + ", commenti=" + commenti + ", aula=" + aula + "]";
	}

}
