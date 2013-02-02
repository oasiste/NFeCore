package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Cobranca implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fatura fatura;
	private Collection<Duplicata> duplicata;
	
	public Cobranca() {
	}
	
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	public Collection<Duplicata> getDuplicata() {
		return duplicata;
	}
	public void setDuplicata(List<Duplicata> duplicata) {
		this.duplicata = duplicata;
	}	 
	
}
 
