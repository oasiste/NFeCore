package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class InfAdProd implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String infAdProd;
	 
	public InfAdProd(String infAdProd) {
		super();
		if(infAdProd!=null){
			if(infAdProd.length()>500){
				setInfAdProd(infAdProd.substring(0, 500));
			}else{
				setInfAdProd(infAdProd);
			}
			
		}
	}

	public String getInfAdProd() {
		return infAdProd;
	}

	public void setInfAdProd(String infAdProd) {
		this.infAdProd = infAdProd;
	}
	 
}
 
