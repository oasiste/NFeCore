package br.com.usicamp.nfe.core.dto;

import java.util.HashMap;
import java.util.Map;

public enum Ambiente {

	PRODUCAO(1),
	HOMOLOGACAO(2);
	
	private final int amb;
	private static final Map<Integer, Ambiente> intToEnum = new HashMap<Integer, Ambiente>();
	
	static { 
		for (Ambiente op : values())
			intToEnum.put(op.amb, op);
	}

	Ambiente(Integer ambiente){
		this.amb = ambiente;
	}
	
	public static Ambiente fotInt(int ambiente){
		return intToEnum.get(Integer.valueOf(ambiente));
	}
	
	public Integer intValue(){
		return Integer.valueOf(amb);
	}
}
