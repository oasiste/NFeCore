package br.com.usicamp.nfe.core;

import org.junit.Test;

import br.com.usicamp.nfe.core.dto.Emitente;

public class EmitenteTest {

	@Test(expected=IllegalArgumentException.class)
	public void doCRTTeste(){
		Emitente emitente = new Emitente();
		emitente.setCRT(0);
	}
	
}
