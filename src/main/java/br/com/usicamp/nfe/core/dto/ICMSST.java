package br.com.usicamp.nfe.core.dto;

public class ICMSST extends ICMS {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private STDest stDest;
	  
	private STRet stRet;
	
	public ICMSST(TipoICMS tipoICMS) {
		super(tipoICMS);
		this.stDest = new STDest();
		this.stRet = new STRet();
	}

	public STDest getStDest() {
		return stDest;
	}
	
	public void setStDest(STDest stDest) {
		this.stDest = stDest;
	}
	
	public STRet getStRet() {
		return stRet;
	}
	
	public void setStRet(STRet stRet) {
		this.stRet = stRet;
	}
	  
}
 
