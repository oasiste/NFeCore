package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class ISSQNtot implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vServ;
	 
	private Double vBC;
	 
	private Double vISS;
	 
	private Double vPIS;
	 
	private Double vCOFINS;

	public Double getvServ() {
		return vServ;
	}

	public void setvServ(Double vServ) {
		this.vServ = vServ;
	}

	public Double getvBC() {
		return vBC;
	}

	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}

	public Double getvISS() {
		return vISS;
	}

	public void setvISS(Double vISS) {
		this.vISS = vISS;
	}

	public Double getvPIS() {
		return vPIS;
	}

	public void setvPIS(Double vPIS) {
		this.vPIS = vPIS;
	}

	public Double getvCOFINS() {
		return vCOFINS;
	}

	public void setvCOFINS(Double vCOFINS) {
		this.vCOFINS = vCOFINS;
	}
	
}
 
