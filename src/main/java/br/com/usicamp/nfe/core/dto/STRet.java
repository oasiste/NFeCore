package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class STRet implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vBCSTRet;
	 
	private Double vICMSSTRet;

	
	public STRet() {
		// TODO Auto-generated constructor stub
	}
	
	public String getvBCSTRet() {
		return vBCSTRet.toString();
	}

	public void setvBCSTRet(Double vBCSTRet) {
		this.vBCSTRet = vBCSTRet;
	}

	public String getvICMSSTRet() {
		return vICMSSTRet.toString();
	}

	public void setvICMSSTRet(Double vICMSSTRet) {
		this.vICMSSTRet = vICMSSTRet;
	}
	 
}
 
