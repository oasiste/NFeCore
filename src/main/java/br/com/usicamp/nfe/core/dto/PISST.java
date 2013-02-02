package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class PISST implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vBC;
	 
	private Double pPIS;
	 
	private Double vPIS;
	 
	private Double qBCProd;
	 
	private Double vAliqProd;

	public String getvBC() {
		return FormatNfe.getDuasCasasDecimal(vBC);
	}

	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}

	public String getpPIS() {
		return FormatNfe.getDuasCasasDecimal(pPIS);
	}

	public void setpPIS(Double pPIS) {
		this.pPIS = pPIS;
	}

	public String getvPIS() {
		return FormatNfe.getDuasCasasDecimal(vPIS);
	}

	public void setvPIS(Double vPIS) {
		this.vPIS = vPIS;
	}

	public String getqBCProd() {
		return FormatNfe.getQuatroCasasDecimal(qBCProd);
	}

	public void setqBCProd(Double qBCProd) {
		this.qBCProd = qBCProd;
	}

	public String getvAliqProd() {
		return FormatNfe.getQuatroCasasDecimal(vAliqProd);
	}

	public void setvAliqProd(Double vAliqProd) {
		this.vAliqProd = vAliqProd;
	}
	 
	
	 
}
 
