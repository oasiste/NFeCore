package br.com.usicamp.nfe.core.certificado;


public class CertificadoFactory {

	private static Certificado certificado;

	public static Certificado getInstance(){
		if(certificado == null)
			certificado = new CertificadoA3("token.cfg", "PR141186");
		
		return certificado;
	}
}
