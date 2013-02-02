package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Destinatario extends Pessoa implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISUF;
	private String email;

	public String getISUF() {
		return ISUF;
	}

	public void setISUF(String iSUF) {
		ISUF = iSUF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
//	private NFe nFe;
	 
}
 
