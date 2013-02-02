package br.com.usicamp.nfe.core.dto;

public class RetInutNFe extends Retorno {

	private String ano;
	private String cnpj;
	private String id;
	private String mod;
	private String NNFIni;
	private String NNFFin;
	private String NProt;
	private String serie;

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAno() {
		return ano;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getNNFIni() {
		return NNFIni;
	}

	public void setNNFIni(String nNFIni) {
		NNFIni = nNFIni;
	}

	public String getNNFFin() {
		return NNFFin;
	}

	public void setNNFFin(String nNFFin) {
		NNFFin = nNFFin;
	}

	public String getNProt() {
		return NProt;
	}

	public void setNProt(String nProt) {
		NProt = nProt;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	

	
}
