package br.com.usicamp.nfe.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileNFe {

	public static void salvarArquivo(String diretorio, String nomeArquivo, String conteudoArquivo) {
		FileWriter writer = null;

		File dir = new File(diretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arqNfe = new File(dir, nomeArquivo);
		if (arqNfe.exists()) {
			FileNFe.renameFileNomeIncremental(diretorio, nomeArquivo);
			arqNfe = new File(dir, nomeArquivo);
		}

		try {
			arqNfe.createNewFile();
			writer = new FileWriter(arqNfe);
			PrintWriter saida = new PrintWriter(writer);
			saida.print(conteudoArquivo);
			saida.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void renameFileNomeIncremental(String diretorio, String nomeArquivo){
		File arqNfe = new File(diretorio, nomeArquivo);
		if(arqNfe.exists()){
			int i = 0;
			File newFile;
			do{
				newFile= new File(diretorio,nomeArquivo.concat(String.valueOf(++i)));
			}while(newFile.exists());
			arqNfe.renameTo(newFile);
		}
	}

	public static String readFileAsString(File file) throws java.io.IOException {
		byte[] buffer = new byte[(int) file.length()];
		FileInputStream f = new FileInputStream(file);
		f.read(buffer);
		return new String(buffer);
	}

}
