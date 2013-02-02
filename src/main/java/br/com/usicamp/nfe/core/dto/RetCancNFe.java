package br.com.usicamp.nfe.core.dto;

import java.util.Date;

//import v2.br.inf.portalfiscal.nfe.RetCancNFeDocument;


public class RetCancNFe extends Retorno {
 
	private String chNFe;
	 
	private Date dhRecbto;
	 
	private String nProtCancelamento;

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public Date getDhRecbto() {
		return dhRecbto;
	}

	public void setDhRecbto(Date dhRecbto) {
		this.dhRecbto = dhRecbto;
	}

	public String getnProtCancelamento() {
		return nProtCancelamento;
	}

	public void setnProtCancelamento(String nProtCancelamento) {
		this.nProtCancelamento = nProtCancelamento;
	}

	/*public void setRetCancNFeDocument(RetCancNFeDocument retCancNFeDocument){
		this.setVersao(retCancNFeDocument.getRetCancNFe().getVersao().toString());
		this.setTpAmb(retCancNFeDocument.getRetCancNFe().getInfCanc().getTpAmb().intValue());
		this.setVerAplic(retCancNFeDocument.getRetCancNFe().getInfCanc().getVerAplic());        
		this.setcStat(Integer.parseInt(retCancNFeDocument.getRetCancNFe().getInfCanc().getCStat()));
		this.setxMotivo(retCancNFeDocument.getRetCancNFe().getInfCanc().getXMotivo());
		this.setcUF(retCancNFeDocument.getRetCancNFe().getInfCanc().getCUF().intValue());
	}*/
	
	
	
	 
}
 
