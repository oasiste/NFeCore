package br.com.usicamp.nfe.core.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class FormatNfe {

	private static DecimalFormat twoDForm = new DecimalFormat("#0.00");
	private static DecimalFormat fourDForm = new DecimalFormat("#0.0000");

	public static String getZeroEsqStr(String numero, int qtde) {
		while (numero.length() < qtde) {
			numero = "0" + numero;
		}
		return numero;
	}

	public static String getDuasCasasDecimal(Double numero) {
		return (numero == null) ? null : twoDForm.format(numero).replaceAll(",", ".");
	}

	public static String getQuatroCasasDecimal(Double numero) {
		return (numero == null) ? null : fourDForm.format(numero).replaceAll(",", ".");
	}

	public static String getTresCasasDecimal(Double numero) {
		return (numero == null) ? null : new DecimalFormat("#0.000").format(numero).replaceAll(",", ".");
	}

	public static String retiraAcentuacao(String entrada) {

		entrada = entrada.replaceAll("[ÂÀÁÄÃ]", "A");
		entrada = entrada.replaceAll("[âãàáä]", "a");
		entrada = entrada.replaceAll("[ÊÈÉË]", "E");
		entrada = entrada.replaceAll("[êèéë]", "e");
		entrada = entrada.replaceAll("[ÎÍÌÏ]", "I");
		entrada = entrada.replaceAll("[îíìï]", "i");
		entrada = entrada.replaceAll("[ÔÕÒÓÖ]", "O");
		entrada = entrada.replaceAll("[ôõòóö]", "o");
		entrada = entrada.replaceAll("[ÛÙÚÜ]", "U");
		entrada = entrada.replaceAll("[ûúùü]", "u");
		entrada = entrada.replaceAll("Ç", "C");
		entrada = entrada.replaceAll("ç", "c");
		entrada = entrada.replaceAll("[ýÿ]", "y");
		entrada = entrada.replaceAll("Ý", "Y");
		entrada = entrada.replaceAll("ñ", "n");
		entrada = entrada.replaceAll("Ñ", "N");
		entrada = entrada.replaceAll("º", "");
		entrada = entrada.replaceAll("´", "");
		entrada = entrada.replaceAll("ª", "");
		entrada = entrada.replaceAll("~", "");
		entrada = entrada.replaceAll("\\*", "");
		entrada = entrada.replaceAll("Ø", "");

		return trocaAcentuacao(entrada); 
	}

	public static String trocaAcentuacao(String acentuada) {

		char[] acentuados = new char[]{'ç', 'á', 'à', 'ã', 'â', 'ä', 'é', 'è', 'ê', 'ë', 'í', 'ì', 'î', 'ï', 'ó', 'ò', 'õ', 'ô', 'ö', 'ú', 'ù', 'û', 'ü'};

		char[] naoAcentuados = new char[]{'c', 'a', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'e', 'i', 'i', 'i', 'i', 'o', 'o', 'o', 'o', 'o', 'u', 'u', 'u', 'u'};

		for (int i = 0; i < acentuados.length; i++) {
			acentuada = acentuada.replace(acentuados[i], naoAcentuados[i]);
			acentuada = acentuada.replace(Character.toUpperCase(acentuados[i]), Character.toUpperCase(naoAcentuados[i]));
		}
		return acentuada;
	}

	public static String retiraEspacoEntreTagXML(String XMLString) {

		StringBuffer buffer = new StringBuffer(XMLString);

		for (int i = 0; i < buffer.length(); i++) 
			if (buffer.charAt(i) == ' ') 
				if ((buffer.charAt(i - 1) == ' ') || ((buffer.charAt(i - 1) == '>'))) 
					while (buffer.charAt(i) == ' ') 
						buffer.deleteCharAt(i);
		

		return buffer.toString();
	}

	public static String formataMoeda(double vlr){
		java.text.DecimalFormat df = new java.text.DecimalFormat("R$ ###,###,##0.00");
		return df.format( vlr );
	}

	public static String toByteBuffer(String content, String encode) {  
		Charset charset = Charset.forName(encode);  
		ByteBuffer bb = charset.encode(content);  
		return bb.toString();   
	}

}
