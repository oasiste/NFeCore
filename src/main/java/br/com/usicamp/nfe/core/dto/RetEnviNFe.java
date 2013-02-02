package br.com.usicamp.nfe.core.dto;

import java.util.Date;


public class RetEnviNFe extends Retorno {
	
	
 
	private Date dhRecbto;
	private String nRec;
	
	public RetEnviNFe(String versao, Integer tpAmb, String verAplic,
			Integer cStat, String xMotivo, Integer cUF, String xmlRetorno,Date dhRecbto, String nRec) {
		super();
		this.setVersao(versao);
		this.setTpAmb(tpAmb);
		this.setVerAplic(verAplic);
		this.setcStat(cStat);
		this.setxMotivo(xMotivo);
		this.setcUF(cUF);
		this.setXmlRetorno(xmlRetorno);
	}
	
	public RetEnviNFe() {
		// TODO Auto-generated constructor stub
	}

	public void setDhRecbto(Date dhRecbto) {
		this.dhRecbto = dhRecbto;
	}

	public Date getDhRecbto() {
		return dhRecbto;
	}
	
	public String getnRec() {
		return nRec;
	}

	public void setnRec(String nRec) {
		this.nRec = nRec;
	}
	 
}
 
