package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class RetTrib implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vRetPIS;
	 
	private Double vRetCOFINS;
	 
	private Double vRetCSLL;
	 
	private Double vBCIRRF;
	 
	private Double vIRRF;
	 
	private Double vBCRetPrev;
	 
	private Double vRetPrev;

	public Double getvRetPIS() {
		return vRetPIS;
	}

	public void setvRetPIS(Double vRetPIS) {
		this.vRetPIS = vRetPIS;
	}

	public Double getvRetCOFINS() {
		return vRetCOFINS;
	}

	public void setvRetCOFINS(Double vRetCOFINS) {
		this.vRetCOFINS = vRetCOFINS;
	}

	public Double getvRetCSLL() {
		return vRetCSLL;
	}

	public void setvRetCSLL(Double vRetCSLL) {
		this.vRetCSLL = vRetCSLL;
	}

	public Double getvBCIRRF() {
		return vBCIRRF;
	}

	public void setvBCIRRF(Double vBCIRRF) {
		this.vBCIRRF = vBCIRRF;
	}

	public Double getvIRRF() {
		return vIRRF;
	}

	public void setvIRRF(Double vIRRF) {
		this.vIRRF = vIRRF;
	}

	public Double getvBCRetPrev() {
		return vBCRetPrev;
	}

	public void setvBCRetPrev(Double vBCRetPrev) {
		this.vBCRetPrev = vBCRetPrev;
	}

	public Double getvRetPrev() {
		return vRetPrev;
	}

	public void setvRetPrev(Double vRetPrev) {
		this.vRetPrev = vRetPrev;
	}
	  
}
 
