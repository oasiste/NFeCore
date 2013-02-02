package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class CredSN implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double pCredSN;
	private Double vCredICMSSN;

	public Double getpCredSN() {
		return pCredSN;
	}

	public void setpCredSN(Double pCredSN) {
		this.pCredSN = pCredSN;
	}

	public Double getvCredICMSSN() {
		return vCredICMSSN;
	}

	public void setvCredICMSSN(Double vCredICMSSN) {
		this.vCredICMSSN = vCredICMSSN;
	}
	 
	
}
 
