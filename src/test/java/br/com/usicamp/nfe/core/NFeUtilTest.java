package br.com.usicamp.nfe.core;

import junit.framework.Assert;

import org.junit.Test;

import br.com.usicamp.nfe.core.util.NFeUtil;

public class NFeUtilTest {
	
	@Test
	public void isArquivoComExtensaoXmlTest(){
		
		Assert.assertEquals(true, NFeUtil.isArquivoComExtensaoXml("1 -1 - 1.xml"));
		Assert.assertEquals(false, NFeUtil.isArquivoComExtensaoXml("1 -1 - 1.xml1"));
		
	}

}
