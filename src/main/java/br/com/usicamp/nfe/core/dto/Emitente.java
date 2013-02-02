package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class Emitente extends Pessoa implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Informar a IE do ST da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino.
	 */
	private String IEST;
	 
	/**
	 * Este campo deve ser informado,quando ocorrer a emiss�o de NF-e conjugada, com presta��o de servi�os sujeitos ao ISSQN e fornecimento de pe�as sujeitos ao ICMS.
	 */
	private String IM;
	 
	/**
	 * Este campo deve ser informado quando o campo IM (C19) for informado.
	 */
	private String CNAE;
	 
	/**
	 * Este campo ser� obrigatoriamente preenchido com:
	 * 1 � Simples Nacional;
	 * 2 � Simples Nacional � excesso de sublimite de receita bruta;
	 * 3 � Regime Normal. (v2.0).
	 */
	private Integer CRT;
	
	public Emitente() {
//		setEndereco(new Endereco());
	}
	public String getIEST() {
		return IEST;
	}
	public void setIEST(String iEST) {
		if (iEST != null) {
            this.IEST = iEST.replace("/", "");
            this.IEST = iEST.replaceAll("[.]", "");
            this.IEST = iEST.replace("-", "");
        }
	}
	public String getIM() {
		return IM;
	}
	public void setIM(String iM) {
		IM = iM;
	}
	public String getCNAE() {
		return CNAE;
	}
	public void setCNAE(String cNAE) {
		CNAE = cNAE;
	}
	public Integer getCRT() {
		return CRT;
	}
	public void setCRT(Integer cRT) {
		if(cRT==null)
			return;
		if(cRT.intValue()>=1 && cRT.intValue()<=3)
			CRT = cRT;
		else
			throw new IllegalArgumentException("Parâmetro CRT invalido");
	}
}
 
