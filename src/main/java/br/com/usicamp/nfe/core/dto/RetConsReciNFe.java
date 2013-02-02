package br.com.usicamp.nfe.core.dto;

import java.util.ArrayList;
import java.util.List;


public class RetConsReciNFe extends Retorno {
 	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nRec;
	private Integer cMsg;
	private String xMsg;
	private List<ProtNfe> protNfe;
	
	public RetConsReciNFe() {
		protNfe = new ArrayList<ProtNfe>();
	}
	
	public void addProtNFe(ProtNfe protNfe){
		this.protNfe.add(protNfe);
	}
	
	public List<ProtNfe> getProtNfe() {
		return protNfe;
	}

	public String getnRec() {
		return nRec;
	}

	public void setnRec(String nRec) {
		this.nRec = nRec;
	}

	public Integer getcMsg() {
		return cMsg;
	}

	public void setcMsg(Integer cMsg) {
		this.cMsg = cMsg;
	}
	
	public void setcMsg(String cMsg) {
		if(cMsg != null){
			this.cMsg = Integer.parseInt(cMsg);
		}
		
	}

	public String getxMsg() {
		return xMsg;
	}

	public void setxMsg(String xMsg) {
		this.xMsg = xMsg;
	}
	
	/*public void setRetConsReciNFeDocument(v2.br.inf.portalfiscal.nfe.RetConsReciNFeDocument retConsReciNFeDocument){
		
		this.setVersao(retConsReciNFeDocument.getRetConsReciNFe().getVersao());
        this.setTpAmb(null);
        this.setVerAplic(retConsReciNFeDocument.getRetConsReciNFe().getVerAplic());
        
        this.setcStat(Integer.parseInt(retConsReciNFeDocument.getRetConsReciNFe().getCStat()));
        this.setxMotivo(retConsReciNFeDocument.getRetConsReciNFe().getXMotivo());
        this.setcUF(retConsReciNFeDocument.getRetConsReciNFe().getCUF().intValue());
        this.setnRec(retConsReciNFeDocument.getRetConsReciNFe().getNRec());
        
        if (retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray() != null) {
            for (int i = 0; i < retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray().length; i++) {
                ProtNfe protNFe = new ProtNfe();
                protNFe.setXmlString(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].xmlText());
                protNFe.setVersao(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getVersao());
                protNFe.setId(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getId());
                protNFe.setTpAmb(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getTpAmb().intValue());
                protNFe.setVerAplic(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getVerAplic());
                protNFe.setChNFe(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getChNFe());
               // SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                //protNFe.setDhRecbto(formato.format(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getDhRecbto().getTime()));
                protNFe.setDhRecbto(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getDhRecbto().getTime());
                protNFe.setnProt(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getNProt());
               // protNFe.setDigValue(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getDigVal().toString());
                protNFe.setcStat(Integer.parseInt(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getCStat()));
                protNFe.setxMotivo(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].getInfProt().getXMotivo());
                //protNFe.setXmlProtNFe(retConsReciNFeDocument.getRetConsReciNFe().getProtNFeArray()[i].xmlText());
                this.addProtNFe(protNFe);
            }
        }
	}*/
	

}
 
