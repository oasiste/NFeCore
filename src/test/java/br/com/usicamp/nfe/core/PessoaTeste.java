package br.com.usicamp.nfe.core;

import org.junit.Test;
import br.com.usicamp.nfe.core.dto.Destinatario;

public class PessoaTeste {

	@Test(expected=IllegalArgumentException.class)
	public void doTestIE(){
		Destinatario destinatario = new Destinatario();
		destinatario.setIE("9999/99");
	}

	@Test
	public void doTestIE2(){
		Destinatario destinatario = new Destinatario();
		destinatario.setIE("ISENTO");
		destinatario.setIE("123456");
		destinatario.setIE(null);
	}
}

