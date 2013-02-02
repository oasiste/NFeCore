package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Cofins extends CofinsST implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CST;

	public String getCST() {
		return CST;
	}

	public void setCST(String cST) {
		CST = cST;
	}
	 
}
 
