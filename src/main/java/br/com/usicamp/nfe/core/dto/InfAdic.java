package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.List;

public class InfAdic implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String infAdFisco;
	private String infCpl;
	private String infAdFiscoFormatado;
	private String infCplFormatado;
	
	private List<String> infAdFiscoList;
	private List<String>  infCplList;
	
	public InfAdic(List<String> infAdFiscoList, List<String> infCplList) {
		
		this.infAdFiscoList = infAdFiscoList;
		this.infCplList = infCplList;
			
		if(infAdFiscoList!=null){
			for(String inf:infAdFiscoList){
	     		this.infAdFisco = (this.infAdFisco==null)?inf:this.infAdFisco  +inf;
	     		this.setInfAdFiscoFormatado((this.infAdFiscoFormatado==null)?inf:this.infAdFisco  +inf + "\n"); 
	     	}
		}
     	
		if(infCplList!=null){
			for(String inf: infCplList){
	     		this.infCpl =  (this.infCpl==null)?inf:this.infCpl +inf;
	     		this.setInfCplFormatado((this.infCplFormatado==null)?inf:this.infCpl +inf+"\n");
	     	}
		}
	}

	public InfAdic(String infAdFisco,String infCpl) {
		this.infAdFisco = infAdFisco;
		this.infCpl = infCpl;
	}
	
	public String getInfAdFisco() {
		return infAdFisco;
	}
	
	public String getInfCpl() {
		return infCpl;
	}

	public void setInfAdFiscoFormatado(String infAdFiscoFormatado) {
		this.infAdFiscoFormatado = infAdFiscoFormatado;
	}

	public String getInfAdFiscoFormatado() {
		return infAdFiscoFormatado;
	}

	public void setInfCplFormatado(String infCplFormatado) {
		this.infCplFormatado = infCplFormatado;
	}

	public String getInfCplFormatado() {
		return infCplFormatado;
	}

	public void setInfAdFiscoList(List<String> infAdFiscoList) {
		this.infAdFiscoList = infAdFiscoList;
	}

	public List<String> getInfAdFiscoList() {
		return infAdFiscoList;
	}

	public void setInfCplList(List<String> infCplList) {
		this.infCplList = infCplList;
	}

	public List<String> getInfCplList() {
		return infCplList;
	}
}
 
