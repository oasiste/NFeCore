package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Reboque implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String placa;
	 
	private String UF;
	 
	private String RNTC;
	 
	private String vagao;
	 
	private String balsa;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getRNTC() {
		return RNTC;
	}

	public void setRNTC(String rNTC) {
		RNTC = rNTC;
	}

	public String getVagao() {
		return vagao;
	}

	public void setVagao(String vagao) {
		this.vagao = vagao;
	}

	public String getBalsa() {
		return balsa;
	}

	public void setBalsa(String balsa) {
		this.balsa = balsa;
	}
	 
	
	 
}
 
