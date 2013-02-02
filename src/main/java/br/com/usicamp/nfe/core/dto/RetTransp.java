package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class RetTransp implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vServ;
	 
	private Double vBCRet;
	 
	private Double pICMSRet;
	 
	private Double vICMSRet;
	 
	private Integer CFOP;
	 
	private Integer cMunFG;

	public Double getvServ() {
		return vServ;
	}

	public void setvServ(Double vServ) {
		this.vServ = vServ;
	}

	public Double getvBCRet() {
		return vBCRet;
	}

	public void setvBCRet(Double vBCRet) {
		this.vBCRet = vBCRet;
	}

	public Double getpICMSRet() {
		return pICMSRet;
	}

	public void setpICMSRet(Double pICMSRet) {
		this.pICMSRet = pICMSRet;
	}

	public Double getvICMSRet() {
		return vICMSRet;
	}

	public void setvICMSRet(Double vICMSRet) {
		this.vICMSRet = vICMSRet;
	}

	public Integer getCFOP() {
		return CFOP;
	}

	public void setCFOP(Integer cFOP) {
		CFOP = cFOP;
	}

	public Integer getcMunFG() {
		return cMunFG;
	}

	public void setcMunFG(Integer cMunFG) {
		this.cMunFG = cMunFG;
	}
	  
}
 
