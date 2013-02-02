package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Fatura implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nFat;	 
	private Double vOrig;	 
	private Double vDesc;	 
	private Double vLiq;

	public String getnFat() {
		return nFat;
	}

	public void setnFat(String nFat) {
		this.nFat = nFat;
	}

	public Double getvOrig() {
		return vOrig;
	}

	public void setvOrig(Double vOrig) {
		this.vOrig = vOrig;
	}

	public Double getvDesc() {
		return vDesc;
	}

	public void setvDesc(Double vDesc) {
		this.vDesc = vDesc;
	}

	public Double getvLiq() {
		return vLiq;
	}

	public void setvLiq(Double vLiq) {
		this.vLiq = vLiq;
	}
	 
}
 
