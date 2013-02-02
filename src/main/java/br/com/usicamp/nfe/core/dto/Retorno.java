package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Retorno implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String versao;
	private Integer tpAmb;
	private String verAplic;
	private Integer cStat;
	private String xMotivo;
	private Integer cUF;
	private String xmlRetorno;

	public String getXmlRetorno() {
		return xmlRetorno;
	}

	public void setXmlRetorno(String xmlRetorno) {
		this.xmlRetorno = xmlRetorno;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Integer getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(Integer tpAmb) {
		this.tpAmb = tpAmb;
	}
	
	public void setTpAmb(String tpAmb) {
		if(tpAmb!=null){
			this.tpAmb = Integer.parseInt(tpAmb);
		}
	}

	public String getVerAplic() {
		return verAplic;
	}

	public void setVerAplic(String verAplic) {
		this.verAplic = verAplic;
	}

	public Integer getcStat() {
		return cStat;
	}

	public void setcStat(Integer cStat) {
		this.cStat = cStat;
	}
	
	public void setcStat(String cStat) {
		if(cStat != null){
			this.cStat = Integer.parseInt(cStat);
		}
	}

	public String getxMotivo() {
		return xMotivo;
	}

	public void setxMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}

	public Integer getcUF() {
		return cUF;
	}

	public void setcUF(Integer cUF) {
		this.cUF = cUF;
	}
	
	public void setcUF(String cUF) {
		if(cUF != null){
			this.cUF = Integer.parseInt(cUF);
		}
	}
}
 
