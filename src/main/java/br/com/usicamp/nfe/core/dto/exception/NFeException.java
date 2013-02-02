package br.com.usicamp.nfe.core.dto.exception;

import java.util.List;

public class NFeException extends Exception {
	
	private List<String> erroList;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NFeException(List<String> errosList) {
		super();
		this.erroList = errosList;
	}
	
	public List<String> getErroList() {
		return erroList;
	}
	
}
