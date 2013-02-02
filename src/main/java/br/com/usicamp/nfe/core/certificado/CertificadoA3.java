package br.com.usicamp.nfe.core.certificado;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CertificadoA3 extends Certificado {
	
	public CertificadoA3(String tokenPath,String senhaCertificado) {
		
        Provider p = new sun.security.pkcs11.SunPKCS11(tokenPath);
        Security.addProvider(p);

        try {
            this.ks = KeyStore.getInstance("pkcs11");
            try {
                this.ks.load(null, senhaCertificado.toCharArray());
            } catch (IOException ex) {
                Logger.getLogger(IOException.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(NoSuchAlgorithmException.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CertificateException ex) {
                Logger.getLogger(CertificateException.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (KeyStoreException ex) {
            Logger.getLogger(KeyStoreException.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        System.setProperty("javax.net.ssl.keyStoreType", ks.getType());
        System.setProperty("javax.net.ssl.keyStorePassword", senhaCertificado);


        Enumeration aliasesEnum = null;
        try {
            aliasesEnum = ks.aliases();
        } catch (KeyStoreException ex) {
            Logger.getLogger(KeyStoreException.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrivateKeyEntry pkEntry = null;
		while (aliasesEnum.hasMoreElements()) {
            String alias = (String) aliasesEnum.nextElement();
            System.out.println(alias);
            try {
                if (ks.isKeyEntry(alias)) {
                    try {
                         pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection("141186".toCharArray()));
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(NoSuchAlgorithmException.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnrecoverableEntryException ex) {
                        Logger.getLogger(UnrecoverableEntryException.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (KeyStoreException ex) {
                        Logger.getLogger(KeyStoreException.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.privateKey = pkEntry.getPrivateKey();
                    break;
                }
            } catch (KeyStoreException ex) {
                Logger.getLogger(KeyStoreException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
		
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "jssecacerts"); //Aqui vem o arquivo criado atrav�s do comando keytool no passo 3
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        

        this.certificate = (X509Certificate) pkEntry.getCertificate();
	}
}
