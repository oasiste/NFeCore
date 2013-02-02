package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Tributo implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ICMS iCMS;
	 
	private IPI IPI;
	 
	private PIS pIS;
	 
	private PISST pISST;
	 
	private Cofins cofins;
	 
	private CofinsST cofinsST;
	
	

	public Tributo(ICMS iCMS, IPI iPI, PIS pIS, PISST pISST, Cofins cofins,CofinsST cofinsST) {
		this.iCMS = iCMS;
		IPI = iPI;
		this.pIS = pIS;
		this.pISST = pISST;
		this.cofins = cofins;
		this.cofinsST = cofinsST;
	}

	public ICMS getiCMS() {
		return iCMS;
	}

	public IPI getIPI() {
		return IPI;
	}

	public PIS getpIS() {
		return pIS;
	}

	public PISST getpISST() {
		return pISST;
	}

	public Cofins getCofins() {
		return cofins;
	}

	public CofinsST getCofinsST() {
		return cofinsST;
	}
	
	

	
 
}
 
