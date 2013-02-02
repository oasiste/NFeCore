package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class ICMS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoICMS tipoICMS;
	private Integer origemMercadoria;
	private String cst;
	private String csosn;
	private BC bc;
	private BCST bcst;

	/**
	 * Sigla da UF para qual � devido o ICMS ST da opera?�o (v2.0)
	 */
	private String UFST; 

	/**
	 * Motivo da desonera��o do ICMS.Este campo ser� preenchido quando o campo anterior estiver preenchido.
	 * Informar o motivo da desonera��o:
	 * 1 � T�xi;
	 * 2 � Deficiente F�sico;
	 * 3 � Produtor Agropecu�rio;
	 * 4 � Frotista/Locadora;
	 * 5 � Diplom�tico/Consular;
	 * 6 � Utilit�rios e Motocicletas da Amaz�nia Ocidental e �reas de Livre Com�rcio (Resolu��o 714/88 e 790/94 � CONTRAN e  suas altera��es);
	 * 7 � SUFRAMA;
	 * 9 � outros. (v2.0)
	 */
	private Integer motDesICMS;
	private STRet stRet;


	private Double pCredSN;
	private Double vCredICMSSN;
	
	private Double vBCSTDest;
	private Double vICMSSTDest;



	public ICMS(TipoICMS tipoICMS) {
		this.tipoICMS = tipoICMS;
		this.bc = new BC();
		this.bcst = new BCST();
		this.stRet = new STRet();
	}


	public Integer getOrigemMercadoria() {
		return origemMercadoria;
	}

	public String getOrigemMercadoriaString() {
		return origemMercadoria!=null?origemMercadoria.toString():null;
	}

	public void setOrigemMercadoria(Integer origemMercadoria) {
		this.origemMercadoria = origemMercadoria;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	public BC getBc() {
		return bc;
	}

	public void setBc(BC bc) {
		this.bc = bc;
	}

	public BCST getBcst() {
		return bcst;
	}

	public void setBcst(BCST bcst) {
		this.bcst = bcst;
	}

	public Integer getMotDesICMS() {
		return motDesICMS;
	}

	public void setMotDesICMS(Integer motDesICMS) {
		this.motDesICMS = motDesICMS;
	}

	public STRet getStRet() {
		return stRet;
	}

	public void setStRet(STRet stRet) {
		this.stRet = stRet;
	}

	public void setTipoICMS(TipoICMS tipoICMS) {
		this.tipoICMS = tipoICMS;
	}

	public TipoICMS getTipoICMS() {
		return tipoICMS;
	}


	public void setUFST(String uFST) {
		UFST = uFST;
	}


	public String getUFST() {
		return UFST;
	}


	public String getCsosn() {
		return csosn;
	}

	public void setCsosn(String csosn) {
		this.csosn = csosn;
	}


	/**
	 * 	  
	 * Aliquota aplicavel de calculo do credito (Simples Nacional). 
	 * @param vCredICMSSN
	 */
	public void setpCredSN(Double pCredSN) {
		this.pCredSN = pCredSN;
	}


	/**
	 * 
	 * @return Aliquota aplicavel de calculo do credito (Simples Nacional). 
	 */
	public String getpCredSN() {
		return FormatNfe.getDuasCasasDecimal(pCredSN);
	}


	/**
	 * Valor credito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (Simples Nacional)
	 */
	public void setvCredICMSSN(Double vCredICMSSN) {
		this.vCredICMSSN = vCredICMSSN;
	}


	public String getvCredICMSSN() {
		return FormatNfe.getDuasCasasDecimal(vCredICMSSN);
	}


	public void setvBCSTDest(Double vBCSTDest) {
		this.vBCSTDest = vBCSTDest;
	}


	public String getvBCSTDest() {
		return FormatNfe.getDuasCasasDecimal(vBCSTDest);
	}


	public void setvICMSSTDest(Double vICMSSTDest) {
		this.vICMSSTDest = vICMSSTDest;
	}


	public String getvICMSSTDest() {
		return FormatNfe.getDuasCasasDecimal(vICMSSTDest);
	}
}
