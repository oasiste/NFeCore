package br.com.usicamp.nfe.core.danfe;

import java.util.ArrayList;
import java.util.List;

import br.com.usicamp.nfe.core.dto.DetProduto;
import br.com.usicamp.nfe.core.dto.InfAdProdUsicamp;
import br.com.usicamp.nfe.core.dto.InfAdic;

public class DanfeUtil {

	

	public static String formatar(String valor, String mascara) {

		String dado = "";
		// remove caracteres nao numericos
		for (int i = 0; i < valor.length(); i++) {
			char c = valor.charAt(i);
			// dado += c;
			if (Character.isDigit(c)) {
				dado += c;
			}
		}

		int indMascara = mascara.length();
		int indCampo = dado.length();

		for (; indCampo > 0 && indMascara > 0;) {
			if (mascara.charAt(--indMascara) == '#') {
				indCampo--;
			}
		}

		String saida = "";
		for (; indMascara < mascara.length(); indMascara++) {
			saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
		}
		return saida;
	}

	public String formatarCpf(String cpf) {
		while (cpf.length() < 11) {
			cpf = "0" + cpf;
		}
		return formatar(cpf, "###.###.###-##");
	}

	public String formatarCnpj(String cnpj) {
		while (cnpj.length() < 14) {
			cnpj = "0" + cnpj;
		}
		return formatar(cnpj, "##.###.###/####-##");
	}

	public String formatarCep(String cep) {
		while (cep.length() < 8) {
			cep = "0" + cep;
		}
		return formatar(cep, "#####-###");
	}

	public String formatarTelefone(String telefone) {
		if (telefone.length() == 10) {
			return "(" + formatar(telefone, "(##)####-####");
		} else {
			if (telefone.length() == 8) {
				return formatar(telefone, "####-####");
			} else {
				return telefone;
			}
		}
	}

	public String formataNumeroNota(String numero) {
		while (numero.length() < 9) {
			numero = "0" + numero;
		}
		return formatar(numero, "###.###.###");
	}

	public String formatarChaveAcesso(String chaveAcesso) {
		if (chaveAcesso.length() == 44) {
			return formatar(chaveAcesso, "#### #### #### #### #### #### #### #### #### #### ####");
		} else {
			return chaveAcesso;
		}
	}

	public String formatarCodBarraAdicional(String chaveAcesso) {
		if (chaveAcesso.length() == 36) {
			return formatar(chaveAcesso, "#### #### #### #### #### #### #### #### ####");
		} else {
			return chaveAcesso;
		}
	}

	/**
	 * Fun��o criada para retirar as mensagens inseridas nos dados adicinais da danfe
	 * 
	 * @param collInfClp
	 * @param collInfFisco
	 * @param collItem
	 * @return
	 */
	public String formataInfoCpl(InfAdic infAdic, List<DetProduto> detProdutos) {

		String infoItem = null;
		String infoCpl = null;
		String infFisco = null;




		final String quebralinha = "\n";

		ArrayList<String> mensagens = new ArrayList<String>();

		if(detProdutos != null){
			for (DetProduto detProduto : detProdutos) {
				if(detProduto.getInfAdProd() != null) {

					List<String> itemMsgFiscoList = ((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgFisco();
					List<String> itemMsgCompList = ((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgComplementar();

					if(!mensagens.contains(detProduto.getInfAdProd())){
						infoItem = (infoItem==null) ? detProduto.getInfAdProd().getInfAdProd() + quebralinha : infoItem.concat(detProduto.getInfAdProd().getInfAdProd()) + quebralinha;
						mensagens.add(detProduto.getInfAdProd().getInfAdProd());
					}
				}
			}
		}

		if(infAdic.getInfCplList()!=null){
			for(String infCplString : infAdic.getInfCplList()){
				if(!mensagens.contains(infCplString)){
					infoCpl = (infoCpl==null) ? infCplString + quebralinha : infoCpl + infCplString + quebralinha;
					mensagens.add(infCplString);
				}
			}
		}

		if(infAdic.getInfAdFiscoList()!=null){
			for(String infAdicFisco : infAdic.getInfAdFiscoList()){
				if(!mensagens.contains(infAdicFisco)){
					infFisco = (infFisco==null) ? infAdicFisco + quebralinha : infFisco + infAdicFisco + quebralinha;
					mensagens.add(infAdicFisco);

				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if(infoCpl != null)
			sb.append(infoCpl);
		if(infoItem != null)
			sb.append(infoItem);
		if(infFisco != null){
			sb.append("Informa��es Adicionais de Interesse do Fisco: \n");
			sb.append(infFisco);
		}	
		return sb.toString();
	}

	public String formataIE(String IE) {
		if (IE != null) {
			if (IE.length() == 10) {
				return formatar(IE, "###.#####-##");
			} else {
				if (IE.length() == 12) {
					return formatar(IE, "###.###.###.###");
				} else {
					return IE;
				}
			}
		} else {
			return IE;
		}
	}
	public static String getMsgAdicFisco(InfAdic infAdic, List<DetProduto> detProdutos){
		
		StringBuilder msgAdicFiscoBuilder = new StringBuilder();
		List<String> mensagemFiscoList = new ArrayList<String>();

		for(DetProduto detProduto: detProdutos)
			if(detProduto.getInfAdProd() instanceof InfAdProdUsicamp )
				if(((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgFisco()!=null)
					for(String msg:((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgFisco())
						if(!mensagemFiscoList.contains(msg)){
							msgAdicFiscoBuilder.append(msg.concat("\n"));
							mensagemFiscoList.add(msg);
						}
							

		if(infAdic!=null && infAdic.getInfAdFiscoList()!=null)
			for(String msg:infAdic.getInfAdFiscoList())
				if(!mensagemFiscoList.contains(msg)){
					msgAdicFiscoBuilder.append(msg.concat("\n"));
					mensagemFiscoList.add(msg);
				}

		return msgAdicFiscoBuilder.toString();
	}
	public static String getMsgAdicComplementar(InfAdic infAdic, List<DetProduto> detProdutos){
		
		StringBuilder msgAdicComplementarBuilder = new StringBuilder();
		List<String> mensagemCplList = new ArrayList<String>();

		for(DetProduto detProduto: detProdutos)
			if(detProduto.getInfAdProd() instanceof InfAdProdUsicamp )
				if(((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgComplementar()!=null)
					for(String msg:((InfAdProdUsicamp)detProduto.getInfAdProd()).getMsgComplementar())
						if(!mensagemCplList.contains(msg)){
							msgAdicComplementarBuilder.append(msg.concat("\n"));
							mensagemCplList.add(msg);
						}
							
			

		if(infAdic!=null && infAdic.getInfCplList()!=null)
			for(String msg:infAdic.getInfCplList())
				if(!mensagemCplList.contains(msg)){
					msgAdicComplementarBuilder.append(msg.concat("\n"));
					mensagemCplList.add(msg);
				}
		
		return msgAdicComplementarBuilder.toString();
	}
}
