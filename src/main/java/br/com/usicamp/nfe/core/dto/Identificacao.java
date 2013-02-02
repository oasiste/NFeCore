package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.usicamp.nfe.core.util.FormatNfe;




/**
 *  TAG de grupo das informa��es de identifica�?„o da NF-e 
 * 
 */
public class Identificacao implements Serializable{
	
	public static final int AMBIENTE_PRODUCAO = 1;
	public static final int AMBIENTE_HOMOLOGACAO = 2;
	
	public static final int FIN_NFE_NORMAL=1;
	public static final int FIN_NFE_COMPLEMENTAR=2;
	public static final int FIN_NFE_AJUSTE=3;
	
	public static final int TP_IMP_RETRATO=1;
	public static final int TP_IMP_PAISAGEM=2;
	
	public static final int IND_PAG_AVISTA = 0;
	public static final int IND_PAG_APRAZO = 1;
	public static final int IND_PAG_OUTROS = 2;
	
	public static final int TP_NF_ENTRADA  = 0;
	public static final int TP_NF_SAIDA    = 1;
	
	private static SimpleDateFormat sdfData;
	
	static{
		sdfData = new SimpleDateFormat("yyyy-MM-dd");;
	}
	
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer cUF;	 
	private  String cNF;	 
	private  String natOp;	 
	private  Integer indPag;	 
	private  String mod;	 
	private  Integer serie;	 
	private  String nNF;	 
	private  Date dEmi;	 
	private String dSaiEnt;	 
	private String hSaiEnt;	 
	private  Integer tpNF;	 
	private  Integer cMunFG;	
	private  Integer tpImp;
	private  Integer tpEmis;
	private  Integer cDV;
	private  Integer tpAmb;
	private  Integer finNFe;
	private  Integer procEmi;
	private  String verProc;
	private Date dhCont;
	private String xJust;
	private List<NFRef> nfRef;
	
	public Identificacao() {
		setNfRef(new ArrayList<NFRef>());
	}
	
	public Integer getcUF() {
		return cUF;
	}

	public void setcUF(Integer cUF) {
		this.cUF = cUF;
	}

	public String getcNF() {
		return cNF;
	}

	public void setcNF(String cNF) {
		if(cNF!=null){
			if(cNF.length()>8){
				this.cNF = cNF.substring(cNF.length()-8);
			}else{
				this.cNF = FormatNfe.getZeroEsqStr(cNF, 8);
			}
		}
		
	}

	public String getNatOp() {
		return natOp;
	}

	public void setNatOp(String natOp) {
		if(natOp != null){
			this.natOp = natOp.replace('-', ' ');
			if(this.natOp.length()>60){
				this.natOp = this.natOp.substring(0,60);
			}
		}
	}

	public Integer getIndPag() {
		return indPag;
	}

	public void setIndPag(Integer indPag) {
		if(indPag != null && (indPag < 0 || indPag > 2)){
			String msgErro = "Indicador da forma de pagamento é invalido ! Esperado 0|1|2 informado: "+indPag;
			throw new IllegalArgumentException(msgErro);
		}
		this.indPag = indPag;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public String getnNF() {
		return nNF;
	}

	public void setnNF(Integer nNF) {
		if(nNF!=null){
			this.nNF = nNF.toString();
		}
	}

	public String getdEmi() {
		if(dEmi==null)
			return null;
		else 
			return sdfData.format(dEmi);
	}
	
	public Date getdEmiAsDate() {
		return dEmi;
	}

	public void setdEmi(Date dEmi) {
		this.dEmi = dEmi;
	}

	public String getdSaiEnt() {
		return dSaiEnt;
	}

	public void setdSaiEnt(Date dSaiEnt) {
		this.dSaiEnt = sdfData.format(dSaiEnt);
	}

	public String gethSaiEnt() {
		return hSaiEnt;
	}

	public void sethSaiEnt(Date hSaiEnt) {
		this.hSaiEnt = null;//hSaiEnt;
	}

	public Integer getTpNF() {
		return tpNF;
	}

	public void setTpNF(Integer tpNF) {
		this.tpNF = tpNF;
	}

	public Integer getcMunFG() {
		return cMunFG;
	}

	public void setcMunFG(Integer cMunFG) {
		this.cMunFG = cMunFG;
	}

	public Integer getTpImp() {
		return tpImp;
	}

	public void setTpImp(Integer tpImp) {
		this.tpImp = tpImp;
	}

	public Integer getTpEmis() {
		return tpEmis;
	}

	/**
	 * 1 – Normal – emissão normal;<br> 
	 * 2 – Contingência FS – emissão em contingência com impressão do DANFE em Formula�?rio de Segurança;<br>
	 * 3 – Contingência SCAN – emissão em contingência no Sistema de Contingência do Ambiente Nacional – SCAN;<br> 
	 * 4 – Contingência DPEC - emissão em contingência com envio da Declaração Pre�?via de Emissão em Contingência – DPEC;<br> 
	 * 5 – Contingência FS-DA - emissão em contingência com impressão do DANFE em Formula�?rio de Segurança para Impressão de Documento Auxiliar de Documento Fiscal Eletrônico (FS-DA).<br>
	 * @param tpEmis
	 */
	public void setTpEmis(Integer tpEmis) {
		this.tpEmis = tpEmis;
	}

	public Integer getcDV() {
		return cDV;
	}

	public void setcDV(Integer cDV) {
		this.cDV = cDV;
	}

	public Integer getTpAmb() {
		return tpAmb;
	}
	/**
	 * 1-Produ��o/ 2-Homologa��o
	 * @param tpAmb
	 */
	public void setTpAmb(Integer tpAmb) {
		this.tpAmb = tpAmb;
	}

	public Integer getFinNFe() {
		return finNFe;
	}

	public void setFinNFe(Integer finNFe) {
		this.finNFe = finNFe;
	}

	public Integer getProcEmi() {
		return procEmi;
	}

	public void setProcEmi(Integer procEmi) {
		if(procEmi!=null && (procEmi.intValue() < 0 || procEmi.intValue() > 3))
			throw new IllegalArgumentException("Argumento ProcEmi invalido. Esperado 0|1|2|3. Informado "+procEmi.toString());
		this.procEmi = procEmi;
	}

	public String getVerProc() {
		return verProc;
	}

	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}

	public String getDhCont() {
		if(this.dhCont!=null){
			return new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(this.dhCont);//dhCont.toString();
		}else{
			return null;
		}
	}

	public void setDhCont(Date dhCont) {
		this.dhCont = null;//dhCont;
	}

	public String getxJust() {
		return xJust;
	}

	public void setxJust(String xJust) {
		this.xJust = xJust;
	}

	public List<NFRef> getNfRef() {
		return nfRef;
	}

	public void setNfRef(List<NFRef> nfRef) {
		this.nfRef = nfRef;
	}
}
 
