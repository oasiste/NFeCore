package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class BC implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modBC;
	private Double vBC;
	private Double pICMS;
	private Double vICMS;
	private Double pRedBC;
	private Double pBCOp;

	public String getModBC() {
		return modBC;
	}
	public void setModBC(Integer modBC) {
		if(modBC!=null){
			this.modBC = modBC.toString();
		}
	}
	public String getvBC() {
		return (vBC==null)?null:FormatNfe.getDuasCasasDecimal(vBC);
	}
	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}
	public String getpICMS() {
		return (pICMS==null)?null:FormatNfe.getDuasCasasDecimal(pICMS);
	}
	public void setpICMS(Double pICMS) {
		this.pICMS = pICMS;
	}
	public String getvICMS() {
		return (vICMS==null)?null:FormatNfe.getDuasCasasDecimal(vICMS);
	}
	public void setvICMS(Double vICMS) {
		this.vICMS = vICMS;
	}
	public String getpRedBC() {
		return (pRedBC==null)?null:FormatNfe.getDuasCasasDecimal(pRedBC);
	}
	public void setpRedBC(Double pRedBC) {
		this.pRedBC = pRedBC;
	}
	public void setpBCOp(Double pBCOp) {
		this.pBCOp = pBCOp;
	}
	public String getpBCOp() {
		return FormatNfe.getDuasCasasDecimal(pBCOp);
	}
}
 
