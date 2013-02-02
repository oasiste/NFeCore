package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class IPI implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CST;
	 
	private String clEnq;
	 
	private String CNPJProd;
	 
	private String cSelo;
	 
	private Integer qSelo;
	 
	private String cEnq;
	
	private Double vBC;
	 
	private Double pIPI;
	
	private Double vIPI;
	 
	private Double qUnid;
	 
	private Double vUnid;

	public String getvBC() {
		return (vBC==null)?null:FormatNfe.getDuasCasasDecimal(vBC);
	}

	public void setvBC(Double vBC) {
		this.vBC = vBC;
	}

	public String getpIPI() {
		return (pIPI==null)?null:FormatNfe.getDuasCasasDecimal(pIPI);
	}

	public void setpIPI(Double pIPI) {
		this.pIPI = pIPI;
	}
	
	public String getvIPI() {
		return (vIPI==null)?null:FormatNfe.getDuasCasasDecimal(vIPI);
	}

	public void setvIPI(Double vIPI) {
		this.vIPI = vIPI;
	}

	public String getqUnid() {
		return (qUnid==null)?null:FormatNfe.getQuatroCasasDecimal(qUnid);
	}

	public void setqUnid(Double qUnid) {
		this.qUnid = qUnid;
	}

	public String getvUnid() {
		return (vUnid==null)?null:FormatNfe.getQuatroCasasDecimal(vUnid);
	}

	public void setvUnid(Double vUnid) {
		this.vUnid = vUnid;
	}

	public String getCST() {
		return CST;
	}

	public void setCST(String cST) {
		CST = cST;
	}

	public String getClEnq() {
		return clEnq;
	}

	public void setClEnq(String clEnq) {
		this.clEnq = clEnq;
	}

	public String getCNPJProd() {
		return CNPJProd;
	}

	public void setCNPJProd(String cNPJProd) {
		CNPJProd = cNPJProd;
	}

	public String getcSelo() {
		return cSelo;
	}

	public void setcSelo(String cSelo) {
		this.cSelo = cSelo;
	}

	public Integer getqSelo() {
		return qSelo;
	}

	public void setqSelo(Integer qSelo) {
		this.qSelo = qSelo;
	}

	public String getcEnq() {
		return cEnq;
	}

	public void setcEnq(String cEnq) {
		this.cEnq = cEnq;
	}
	
	
	
	 
}
 
