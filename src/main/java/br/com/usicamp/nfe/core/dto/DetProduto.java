package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

public class DetProduto implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numeroItem;
	 
	private Tributo tributo;
	
	private Produto produto;
	
	private InfAdProd infAdProd;
	
	

	public DetProduto(Integer numeroItem, Tributo tributo, Produto produto,InfAdProd infAdProd) {
		this.numeroItem = numeroItem;
		this.tributo = tributo;
		this.produto = produto;
		this.infAdProd = infAdProd;
	}

	public Integer getNumeroItem() {
		return numeroItem;
	}

	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	public Tributo getTributo() {
		return tributo;
	}

	public void setTributo(Tributo tributo) {
		this.tributo = tributo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public InfAdProd getInfAdProd() {
		return infAdProd;
	}
	
	
	 
}
 
