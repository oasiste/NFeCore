package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class InutNFeDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8672403681757800621L;
	
	private String ano;
	private String cnpj;
	private String cUf;
	private String serie;
	private String NNFIni;
	private String NNFFin;
	private Integer tpAmb;
	private String xJustificativa;

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAno() {
		return ano;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setcUf(String cUf) {
		this.cUf = cUf;
	}

	public String getcUf() {
		return cUf;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return serie;
	}

	public void setNNFIni(String nNFIni) {
		NNFIni = nNFIni;
	}

	public String getNNFIni() {
		return NNFIni;
	}

	public void setNNFFin(String nNFFin) {
		NNFFin = nNFFin;
	}

	public String getNNFFin() {
		return NNFFin;
	}

	public void setTpAmb(Integer tpAmb) {
		this.tpAmb = tpAmb;
	}

	public Integer getTpAmb() {
		return tpAmb;
	}

	public void setxJustificativa(String xJustificativa) {
		this.xJustificativa = xJustificativa;
	}

	public String getxJustificativa() {
		return xJustificativa;
	}
	
	
	
}
