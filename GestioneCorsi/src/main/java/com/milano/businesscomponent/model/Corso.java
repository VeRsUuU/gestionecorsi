package com.milano.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long CodCorso;
	private String NomeCorso;
	private Date DataInizioCorso;
	private Date DataFineCorso;
	private double CostoCorso;
	private String CommentiCorso;
	private String AulaCorso;
	
	public long getCodCorso() {
		return CodCorso;
	}
	public void setCodCorso(long codCorso) {
		CodCorso = codCorso;
	}
	public String getNomeCorso() {
		return NomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		NomeCorso = nomeCorso;
	}
	public Date getDataInizioCorso() {
		return DataInizioCorso;
	}
	public void setDataInizioCorso(Date dataInizioCorso) {
		DataInizioCorso = dataInizioCorso;
	}
	public Date getDataFineCorso() {
		return DataFineCorso;
	}
	public void setDataFineCorso(Date dataFineCorso) {
		DataFineCorso = dataFineCorso;
	}
	public double getCostoCorso() {
		return CostoCorso;
	}
	public void setCostoCorso(double costoCorso) {
		CostoCorso = costoCorso;
	}
	public String getCommentiCorso() {
		return CommentiCorso;
	}
	public void setCommentiCorso(String commentiCorso) {
		CommentiCorso = commentiCorso;
	}
	public String getAulaCorso() {
		return AulaCorso;
	}
	public void setAulaCorso(String aulaCorso) {
		AulaCorso = aulaCorso;
	}
	

}
