package br.com.usicamp.nfe.core.dto;

import br.com.usicamp.nfe.core.certificado.Certificado;


public class EnvNFe {
	
//	private Lote lote;
	private String xmlEnvNFeString;
	private Integer ambiente;
	private String uf;

//	public EnvNFe(Integer ambiente,String uf,String XmlLoteNFe) throws Exception {
//
////		if(lote == null){
////			throw new IllegalArgumentException("O pametro Lote n�o pode ser nulo");
////		}
//
//		this.ambiente = ambiente;
//		this.uf = uf;
//
//		this.xmlEnvNFeString = XmlLoteNFe;//XMLv2.getXMLLoteNFe(lote);
////		this.xmlEnvNFeString = certificado.assinarEnviNFe(this.xmlEnvNFeString);
//		this.xmlEnvNFeString = this.xmlEnvNFeString.replace("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
//
//	}

	/**
	 * Constroi EnvNFe sem assinatura
	 * 
	 * @param ambiente
	 * @param uf
	 * @param lote
	 * @throws Exception
	 */
	public EnvNFe(Integer ambiente,String uf,String XmlLoteNFe) throws Exception {

//		if(lote == null){
//			throw new IllegalArgumentException("O pametro Lote n�o pode ser nulo");
//		}

		this.ambiente = ambiente;
		this.uf = uf;

		this.xmlEnvNFeString = XmlLoteNFe;//XMLv2.getXMLLoteNFe(lote);
		//this.xmlEnvNFeString = certificado.assinarEnviNFe(this.xmlEnvNFeString);
		this.xmlEnvNFeString = this.xmlEnvNFeString.replace("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");

	}

//	public Lote getLote() {
//		return lote;
//	}
//
//	public void setLote(Lote lote) {
//		this.lote = lote;
//	}

	public String getXmlEnvNFeString() {
		return xmlEnvNFeString;
	}

	public Integer getAmbiente() {
		return ambiente;
	}

	public String getUf() {
		return uf;
	}

}
