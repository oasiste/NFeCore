package br.com.usicamp.nfe.core.certificado;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Certificado {
	
	protected KeyStore ks;
	protected PrivateKey privateKey;
	protected X509Certificate certificate;
	
	public  String assinarLoteEvento(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = factory.newDocumentBuilder().parse(
                new ByteArrayInputStream(xml.getBytes()));

        doc.getDocumentElement().removeAttribute("xmlns:xsi");

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        ArrayList transformList = new ArrayList();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED,
                tps);
        Transform c14NTransform = fac.newTransform(
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(this.certificate);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        for (int i = 0; i < doc.getDocumentElement().getElementsByTagName("evento").getLength(); i++) {
        	assinarEvento(fac, transformList, privateKey, ki, doc, i);
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
        return os.toString();
    } 
	
	
	private  void assinarEvento(XMLSignatureFactory fac,
            ArrayList transformList, PrivateKey privateKey, KeyInfo ki,
            Document doc, int i) throws Exception {

        NodeList elements = doc.getElementsByTagName("infEvento");
        Element el = (Element) elements.item(i);
        String id = el.getAttribute("Id");

        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                DigestMethod.SHA1, null), transformList, null, null);

        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement().getElementsByTagName("evento").item(i));
        signature.sign(dsc);

    }
	
	
	public  String assinarEnviNFe(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = factory.newDocumentBuilder().parse(
                new ByteArrayInputStream(xml.getBytes()));

        doc.getDocumentElement().removeAttribute("xmlns:xsi");

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // Create a Reference to the enveloped document (in this case,
        // you are signing the whole document, so a URI of "" signifies
        // that, and also specify the SHA1 digest algorithm and
        // the ENVELOPED Transform.
        ArrayList transformList = new ArrayList();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED,
                tps);
        Transform c14NTransform = fac.newTransform(
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);

        

        //cert.get

        // Create the KeyInfo containing the X509Data.
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        // x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(this.certificate);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));


        for (int i = 0; i < doc.getDocumentElement().getElementsByTagName("NFe").getLength(); i++) {
            assinarNFE(fac, transformList, privateKey, ki, doc, i);
        }
        // Output the resulting document.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
        return os.toString();
    } 
	
    private  void assinarNFE(XMLSignatureFactory fac,
            ArrayList transformList, PrivateKey privateKey, KeyInfo ki,
            Document doc, int i) throws Exception {




        // Obtem elemento do documento a ser assinado, ser� criado uma
        // REFERENCE para o mesmo
        NodeList elements = doc.getElementsByTagName("infNFe");
        Element el = (Element) elements.item(i);
        String id = el.getAttribute("Id");

        // doc.getDocumentElement().removeAttribute("xmlns:ns2");
        // ((Element)
        // doc.getDocumentElement().getElementsByTagName("NFe").item(0))
        // .setAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe");

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.

        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                DigestMethod.SHA1, null), transformList, null, null);

        // Create the SignedInfo.
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        // Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, ki);

        // Marshal, generate, and sign the enveloped signature.
        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element..item(i)
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement().getElementsByTagName("NFe").item(i));
        signature.sign(dsc);

    }
    
    public String assinarRaiz(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        // "c:/xml/430802017886010001735500000000010000030371-nfe.xml"));
        Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

        doc.getDocumentElement().removeAttribute("xmlns:ns2");

        // NodeList elements = doc.getElementsByTagName("infNFe");
        Node element = doc.getDocumentElement().getFirstChild().getNextSibling();
        // elements.getLength();
        Element el = (Element) element;
        // Element el =
        // doc.getDocumentElement().getFirstChild().getChildNodes();
        String id = el.getAttribute("Id");

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // Create a Reference to the enveloped document (in this case,
        // you are signing the whole document, so a URI of "" signifies
        // that, and also specify the SHA1 digest algorithm and
        // the ENVELOPED Transform.
        ArrayList transformList = new ArrayList();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED,
                tps);
        Transform c14NTransform = fac.newTransform(
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);

        // Load the KeyStore and get the signing key and certificate.


        // Create the KeyInfo containing the X509Data.
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        // x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(certificate);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        // doc.getDocumentElement().removeAttribute("xmlns:ns2");
        // ((Element)
        // doc.getDocumentElement().getElementsByTagName("NFe").item(0))
        // .setAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe");

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.

        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                DigestMethod.SHA1, null), transformList, null, null);

        // Create the SignedInfo.
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        // Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, ki);

        // Marshal, generate, and sign the enveloped signature.
        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element.
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
        signature.sign(dsc);

        // Output the resulting document.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "no");
        trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        trans.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        	
        trans.transform(new DOMSource(doc), new StreamResult(os));
        return new String(os.toByteArray(),Charset.forName("UTF-8")).trim();//  os.toString();
    }
    
    
    public String assinarRaizCancelamento(String xml,String chaveAcesso) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

        //doc.getDocumentElement().removeAttribute("xmlns:ns2");

        // NodeList elements = doc.getElementsByTagName("infNFe");
      //  Node element = Element elem = document.getDocumentElement();
        // elements.getLength();
        Element el = doc.getDocumentElement();
        // Element el =
        // doc.getDocumentElement().getFirstChild().getChildNodes();
        String id = el.getAttribute("Id");

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // Create a Reference to the enveloped document (in this case,
        // you are signing the whole document, so a URI of "" signifies
        // that, and also specify the SHA1 digest algorithm and
        // the ENVELOPED Transform.
        ArrayList transformList = new ArrayList();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED,
                tps);
        Transform c14NTransform = fac.newTransform(
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);

        // Load the KeyStore and get the signing key and certificate.

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(certificate);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));


        Reference ref = fac.newReference("#" + "ID".concat(chaveAcesso), fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);

        // Create the SignedInfo.
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        // Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, ki);

        // Marshal, generate, and sign the enveloped signature.
        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element.
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
        signature.sign(dsc);

        // Output the resulting document.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "no");
        trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        trans.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        	
        trans.transform(new DOMSource(doc), new StreamResult(os));
        return new String(os.toByteArray(),Charset.forName("UTF-8")).trim();//  os.toString();
    }
	
}
