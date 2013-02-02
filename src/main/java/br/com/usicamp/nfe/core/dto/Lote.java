package br.com.usicamp.nfe.core.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.usicamp.nfe.core.util.ValidaNFeV2;




/**
 * enviNFe
 */
public class Lote {

	private String idLote;

	private List<NFe> listNFe = new ArrayList<NFe>();


	
	public Lote(String idLote){
		if(idLote == null){
			throw new IllegalArgumentException("O parametro idLote não pode ser nulo");
		}
		setIdLote(idLote);
	}

	public List<NFe> getListNFe() {
		return listNFe;
	}

	public void addNFe(NFe nfe) throws IllegalArgumentException {
		ValidaNFeV2.validaNFe(nfe);
		listNFe.add(nfe);
	}

	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}


}

