package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transporte implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int MOD_FRETE_POR_CONTA_EMITENTE = 0; 
	public static final int MOD_FRETE_POR_CONTA_DESTINATARIO_REMETENTE = 1; 
	public static final int MOD_FRETE_POR_CONTA_TERCEIRO= 2; 
	public static final int MOD_FRETE_SEM_FRETE = 9; 

	private Integer modFrete;
	private Pessoa transportadora;
	private List<Lacres>lacres;
	private Reboque[] reboque;
	private RetTransp retTransp;
	private List<Volumes> volumes;
	private VeicTransp veicTransp;
	
	public Transporte() {
		this.volumes = new ArrayList<Volumes>();
	}

	public Integer getModFrete() {
		return modFrete;
	}
	
	public Pessoa getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Pessoa pessoa) {
		this.transportadora = pessoa;
	}

	public void setModFrete(Integer modFrete) {
		this.modFrete = modFrete;
	}

	public List<Lacres> getLacres() {
		return lacres;
	}

	public void setLacres(List<Lacres> lacres) {
		this.lacres = lacres;
	}

	public Reboque[] getReboque() {
		return reboque;
	}

	public void setReboque(Reboque[] reboque) {
		this.reboque = reboque;
	}

	public RetTransp getRetTransp() {
		return retTransp;
	}

	public void setRetTransp(RetTransp retTransp) {
		this.retTransp = retTransp;
	}

	public List<Volumes> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<Volumes> volumes) {
		this.volumes = volumes;
	}

	public VeicTransp getVeicTransp() {
		return veicTransp;
	}

	public void setVeicTransp(VeicTransp veicTransp) {
		this.veicTransp = veicTransp;
	}
	
	
	 
}
 
