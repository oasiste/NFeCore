package br.com.usicamp.nfe.core.dto;

public class ProcNFe {
	
	private ProtNfe protNfe;
	private NFe nfe;
	private String xmlProcNFe;
	
	public ProtNfe getProtNfe() {
		return protNfe;
	}
	public void setProtNfe(ProtNfe protNfe) {
		this.protNfe = protNfe;
	}
	public NFe getNfe() {
		return nfe;
	}
	public void setNfe(NFe nfe) {
		this.nfe = nfe;
	}
	public String getXmlProcNFe() {
		return xmlProcNFe;
	}
	public void setXmlProcNFe(String xmlProcNFe) {
		this.xmlProcNFe = xmlProcNFe;
	}
	
}
