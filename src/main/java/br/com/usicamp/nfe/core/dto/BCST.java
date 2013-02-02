package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class BCST implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer modBCST;
	 
	private Double pMVAST;
	 
	private Double pRedBCST;
	 
	private Double vBCST;
	 
	private Double pICMSST;
	 
	private Double vICMSST;

	public Integer getModBCST() {
		return modBCST;
	}

	public void setModBCST(Integer modBCST) {
		this.modBCST = modBCST;
	}

	public String getpMVAST() {
		return (pMVAST==null)?null:FormatNfe.getDuasCasasDecimal(pMVAST); 
	}

	public void setpMVAST(Double pMVAST) {
		this.pMVAST = pMVAST;
	}

	public String getpRedBCST() {
		return (pRedBCST==null)?null:FormatNfe.getDuasCasasDecimal(pRedBCST);
	}

	public void setpRedBCST(Double pRedBCST) {
		this.pRedBCST = pRedBCST;
	}

	public String getvBCST() {
		return (vBCST==null)?null:FormatNfe.getDuasCasasDecimal(vBCST);
	}

	public void setvBCST(Double vBCST) {
		this.vBCST = vBCST;
	}

	public String getpICMSST() {
		return (pICMSST==null)?null:FormatNfe.getDuasCasasDecimal(pICMSST);
	}

	public void setpICMSST(Double pICMSST) {
		this.pICMSST = pICMSST;
	}
	
	public String getvICMSST() {
		return (vICMSST==null)?null:FormatNfe.getDuasCasasDecimal(vICMSST);
	}

	public void setvICMSST(Double vICMSST) {
		this.vICMSST = vICMSST;
	}
	  	 
}
 
