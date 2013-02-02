package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class Volumes implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer qVol;
	 
	private String especie;
	 
	private String marca;
	 
	private String nVol;
	 
	private Double pesoL;
	 
	private Double pesoB;

	public String getqVol() {
		if(qVol!=null){
			return qVol.toString();
		}
		return null;
	}

	public void setqVol(Integer qVol) {
		this.qVol = qVol;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getnVol() {
		return nVol;
	}

	public void setnVol(String nVol) {
		this.nVol = nVol;
	}

	public String getPesoL() {
		return FormatNfe.getTresCasasDecimal(pesoL);
	}

	public void setPesoL(Double pesoL) {
		this.pesoL = pesoL;
	}

	public String getPesoB() {
		return FormatNfe.getTresCasasDecimal(pesoB);
	}

	public void setPesoB(Double pesoB) {
		this.pesoB = pesoB;
	}

	
}
 
