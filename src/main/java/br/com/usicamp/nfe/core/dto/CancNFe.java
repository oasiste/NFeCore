package br.com.usicamp.nfe.core.dto;

import br.com.usicamp.nfe.core.certificado.Certificado;

@Deprecated
public class CancNFe {
 

	public CancNFe(String xmlCanc,String chNFe,Certificado certificado) throws Exception {
		super();

		xmlCanc = certificado.assinarRaizCancelamento(xmlCanc,chNFe);
		xmlCanc = xmlCanc
		.replaceAll("\n", "")  
        .replaceAll("\r", "")  
        .replaceAll("\t", "")
        .replaceAll( System.getProperty("line.separator"), "" );
		
	}
	 
}
 
