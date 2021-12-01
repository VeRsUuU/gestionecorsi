package com.milano.businesscomponent.model;

public class Corsista {
	
	private String nome_corsista;
	private String cognome_corsista;
	private long cod_corsista;
	private byte precedenti_formativi;
	
	public String getNome_corsista() {
		return nome_corsista;
	}
	public void setNome_corsista(String nome_corsista) {
		this.nome_corsista = nome_corsista;
	}
	public String getCognome_corsista() {
		return cognome_corsista;
	}
	public void setCognome_corsista(String cognome_corsista) {
		this.cognome_corsista = cognome_corsista;
	}
	public long getCod_corsista() {
		return cod_corsista;
	}
	public void setCod_corsista(long cod_corsista) {
		this.cod_corsista = cod_corsista;
	}
	public byte getPrecedenti_formativi() {
		return precedenti_formativi;
	}
	public void setPrecedenti_formativi(byte precedenti_formativi) {
		this.precedenti_formativi = precedenti_formativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [nome_corsista=" + nome_corsista + ", cognome_corsista=" + cognome_corsista + ", cod_corsista="
				+ cod_corsista + ", precedenti_formativi=" + precedenti_formativi + "]";
	}
}
