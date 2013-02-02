package br.com.usicamp.nfe.core;

import org.junit.Test;

import br.com.usicamp.nfe.core.dto.Identificacao;

public class IdentificacaoTest {
	
	
	@Test
	public void doTest1(){
		Identificacao identificacao = new Identificacao();
		identificacao.setIndPag(0);
		identificacao.setIndPag(1);
		identificacao.setIndPag(2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void doTest2(){
		Identificacao identificacao = new Identificacao();
		identificacao.setIndPag(3);
	}
	
}
