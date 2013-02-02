package br.com.usicamp.nfe.core.certificado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class CertificadoA1 extends Certificado {
	
	public CertificadoA1(String trustStoreType,String enderecoKeyStore,String senhaKeyStore,String aliasPfx) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {
	
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");    
		System.setProperty("javax.net.ssl.trustStore", "jssecacerts");//caminho do arquivo criado pelo o InstallCert no caso o jssecacerts      
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");	
		
		ks = KeyStore.getInstance(trustStoreType);
		ks.load(new FileInputStream(enderecoKeyStore), senhaKeyStore.toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasPfx,new KeyStore.PasswordProtection(senhaKeyStore.toCharArray()));

		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        System.setProperty("javax.net.ssl.keyStore", enderecoKeyStore);
        System.setProperty("javax.net.ssl.keyStoreType", ks.getType());
        System.setProperty("javax.net.ssl.keyStorePassword", senhaKeyStore);
		
		Enumeration aliasesEnum = ks.aliases();

		while(aliasesEnum.hasMoreElements()){
			String alias = (String) aliasesEnum.nextElement();
			if(ks.isKeyEntry(alias)){
				pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senhaKeyStore.toCharArray()));
				privateKey = pkEntry.getPrivateKey();
				break;
			}
		}
		

		this.certificate = (X509Certificate) pkEntry.getCertificate();
	}
	
}
