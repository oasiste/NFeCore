package br.com.usicamp.nfe.core.dto;

import java.util.List;

import br.com.usicamp.nfe.core.dto.InfAdProd;

public class InfAdProdUsicamp extends InfAdProd{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> msgFisco;
	private List<String> msgComplementar;

	public InfAdProdUsicamp(String infAdProd) {
		super(infAdProd);
	}
	
	public InfAdProdUsicamp(String infAdProd,List<String> msgFisco,List<String> msgComplementar) {
		this(infAdProd);
		setMsgFisco(msgFisco);
		setMsgComplementar(msgComplementar);
	}

	public List<String> getMsgFisco() {
		return msgFisco;
	}

	public void setMsgFisco(List<String> msgFisco) {
		this.msgFisco = msgFisco;
	}

	public List<String> getMsgComplementar() {
		return msgComplementar;
	}

	public void setMsgComplementar(List<String> msgComplementar) {
		this.msgComplementar = msgComplementar;
	}

}
