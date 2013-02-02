package br.com.usicamp.nfe.core.dto;

import java.util.Calendar;

public class ProtNfe extends Retorno{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id;
	private String chNFe;
	private Calendar dhRecbto;
	private String nProt;
	private byte[] digVal;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public Calendar getDhRecbto() {
		return dhRecbto;
	}

	public void setDhRecbto(Calendar dhRecbto) {
		this.dhRecbto = dhRecbto;
	}

	public String getnProt() {
		return nProt;
	}

	public void setnProt(String nProt) {
		this.nProt = nProt;
	}

	public void setDigVal(byte[] digVal) {
		this.digVal = digVal;
	}

	public byte[] getDigVal() {
		return digVal;
	}
}
 
