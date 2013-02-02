package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class ValoresTotais implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double vBC;
	 
	private Double vICMS;
	 
	private Double vBCST;
	 
	private Double vST;
	 
	private Double vProd;
	 
	private Double vFrete;
	 
	private Double vSeg;
	 
	private Double vDesc;
	 
	private Double vII;
	 
	private Double vIPI;
	 
	private Double vPIS;
	 
	private Double vCOFINS;
	 
	private Double vOutro;
	
	private Double vNF;
	 	
	private ISSQNtot issqNtot;
	
	private RetTrib retTrib;
	
	

	public String getvBC() {
		return (vBC==null)?null:FormatNfe.getDuasCasasDecimal(vBC);
	}

	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}

	public String getvICMS() {
		return (vICMS==null)?null:FormatNfe.getDuasCasasDecimal(vICMS);
	}
	
	public Double getvICMSDouble() {
		return vICMS;
	}

	public void setvICMS(Double vICMS) {
		this.vICMS = vICMS;
	}

	public String getvBCST() {
		return (vBCST==null)?null:FormatNfe.getDuasCasasDecimal(vBCST);
	}

	public void setvBCST(Double vBCST) {
		this.vBCST = vBCST;
	}

	public String getvST() {
		return (vST==null)?null:FormatNfe.getDuasCasasDecimal(vST);
	}
	
	public Double getvSTDouble() {
		return vST;
	}

	public void setvST(Double vST) {
		this.vST = vST;
	}

	public String getvProd() {
		return (vProd==null)?null:FormatNfe.getDuasCasasDecimal(vProd);
	}

	public void setvProd(Double vProd) {
		this.vProd = vProd;
	}

	public String getvFrete() {
		return (vFrete==null)?FormatNfe.getDuasCasasDecimal((double)0):FormatNfe.getDuasCasasDecimal(vFrete);
	}

	public void setvFrete(Double vFrete) {
		this.vFrete = vFrete;
	}

	public String getvSeg() {
		return (vSeg==null)?FormatNfe.getDuasCasasDecimal((double)0):FormatNfe.getDuasCasasDecimal(vSeg);
	}

	public void setvSeg(Double vSeg) {
		this.vSeg = vSeg;
	}

	public String getvDesc() {
		return (vDesc==null)?FormatNfe.getDuasCasasDecimal((double)0):FormatNfe.getDuasCasasDecimal(vDesc);
	}

	public void setvDesc(Double vDesc) {
		this.vDesc = vDesc;
	}

	public String getvII() {
		return (vII==null)?FormatNfe.getDuasCasasDecimal((double)0):FormatNfe.getDuasCasasDecimal(vII);
	}

	public void setvII(Double vII) {
		this.vII = vII;
	}

	public String getvIPI() {
		return (vIPI==null)?null:FormatNfe.getDuasCasasDecimal(vIPI);
	}

	public void setvIPI(Double vIPI) {
		this.vIPI = vIPI;
	}

	public String getvPIS() {
		return (vPIS==null)?null:FormatNfe.getDuasCasasDecimal(vPIS);
	}

	public void setvPIS(Double vPIS) {
		this.vPIS = vPIS;
	}

	public String getvCOFINS() {
		return (vCOFINS==null)?null:FormatNfe.getDuasCasasDecimal(vCOFINS);
	}

	public void setvCOFINS(Double vCOFINS) {
		this.vCOFINS = vCOFINS;
	}

	public String getvOutro() {
		return (vOutro==null)?FormatNfe.getDuasCasasDecimal((double)0):FormatNfe.getDuasCasasDecimal(vOutro);
	}

	public void setvOutro(Double vOutro) {
		this.vOutro = vOutro;
	}

	public String getvNF() {
		return (vNF==null)?null:FormatNfe.getDuasCasasDecimal(vNF);
	}

	public void setvNF(Double vNF) {
		this.vNF = vNF;
	}

	public ISSQNtot getIssqNtot() {
		return issqNtot;
	}

	public void setIssqNtot(ISSQNtot issqNtot) {
		this.issqNtot = issqNtot;
	}

	public RetTrib getRetTrib() {
		return retTrib;
	}

	public void setRetTrib(RetTrib retTrib) {
		this.retTrib = retTrib;
	}
	
	
	 
}
 
