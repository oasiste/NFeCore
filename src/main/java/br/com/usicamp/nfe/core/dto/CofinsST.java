package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class CofinsST implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vBC;
	private Double pCOFINS;
	private Double qBCProd;
	private Double vAliqProd;
	private Double vCOFINS;

	public String getvBC() {
		return (vBC==null)?null:FormatNfe.getDuasCasasDecimal(vBC);
	}

	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}

	public String getpCOFINS() {
		return (pCOFINS==null)?null:FormatNfe.getDuasCasasDecimal(pCOFINS);
	}

	public void setpCOFINS(Double pCOFINS) {
		this.pCOFINS = pCOFINS;
	}

	public String getqBCProd() {
		return (qBCProd==null)?null:FormatNfe.getQuatroCasasDecimal(qBCProd);
	}

	public void setqBCProd(Double qBCProd) {
		this.qBCProd = qBCProd;
	}

	public String getvAliqProd() {
		return (vAliqProd==null)?null:FormatNfe.getQuatroCasasDecimal(vAliqProd);
	}

	public void setvAliqProd(Double vAliqProd) {
		this.vAliqProd = vAliqProd;
	}

	public String getvCOFINS() {
		return (vCOFINS==null)?null:FormatNfe.getDuasCasasDecimal(vCOFINS);
	}

	public void setvCOFINS(Double vCOFINS) {
		this.vCOFINS = vCOFINS;
	}
	  
}
 
