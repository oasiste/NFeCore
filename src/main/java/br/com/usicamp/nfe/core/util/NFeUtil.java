package br.com.usicamp.nfe.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NFeUtil {
	
	private static Matcher matcher;
	private static final Pattern pattern;

	static{
		pattern = Pattern.compile("([^\\s]+(\\.(?i)(xml))$)");
	}

	public static boolean isArquivoComExtensaoXml(String filename){
		filename = filename.trim().replaceAll(" ", "");
		matcher = pattern.matcher(filename);
		return matcher.matches();
	}
	
}
