package br.com.usicamp.nfe.core;

import junit.framework.Assert;
import org.junit.Test;
import br.com.usicamp.nfe.core.dto.Ambiente;

public class AmbienteTest {
	
	@Test
	public void doAmbienteTeste(){
		Assert.assertEquals(Ambiente.PRODUCAO              , Ambiente.fotInt(1));
		Assert.assertEquals(Ambiente.HOMOLOGACAO           , Ambiente.fotInt(2));
		Assert.assertEquals(Ambiente.PRODUCAO.intValue()   , Integer.valueOf(1));
		Assert.assertEquals(Ambiente.HOMOLOGACAO.intValue(), Integer.valueOf(2));
		Assert.assertNull(Ambiente.fotInt(3));
	}
}
