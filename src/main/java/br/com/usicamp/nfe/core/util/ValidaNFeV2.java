package br.com.usicamp.nfe.core.util;

import java.util.ArrayList;
import java.util.List;

import br.com.usicamp.nfe.core.dto.DetProduto;
import br.com.usicamp.nfe.core.dto.Emitente;
import br.com.usicamp.nfe.core.dto.Endereco;
import br.com.usicamp.nfe.core.dto.Identificacao;
import br.com.usicamp.nfe.core.dto.NFe;


public class ValidaNFeV2{
	
	
	public static void validaIdentificacao(Identificacao identificacao) throws IllegalArgumentException{
		if(identificacao.getcUF()==null){
			throw new IllegalArgumentException("C�digo da UF do emitente do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getcNF() ==null){
			throw new IllegalArgumentException("C�digo Num�rico que compõe a Chave de Acesso n�o foi informado"); 
		}
		if(identificacao.getcNF()==null){
			throw new IllegalArgumentException("Descri��o da Natureza da Opera��o n�o foi informado");
		}
		if(identificacao.getIndPag()==null){
			throw new IllegalArgumentException("Indicador da forma de pagamento n�o foi informado");
		}
		if(identificacao.getMod()==null){
			throw new IllegalArgumentException("C�digo do Modelo do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getSerie()==null){
			throw new IllegalArgumentException("S�rie do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getnNF()==null){
			throw new IllegalArgumentException("Nu�?mero do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getdEmi()==null){
			throw new IllegalArgumentException("Data de emiss�o do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getTpNF()==null){
			throw new IllegalArgumentException("Tipo do Documento Fiscal n�o foi informado");
		}
		if(identificacao.getcMunFG()==null){
			throw new IllegalArgumentException("C�digo do Munic�pio de Ocorr�ncia do Fato Gerador n�o foi informado");
		}
		if(identificacao.getcUF()==null){
			throw new IllegalArgumentException("C�digo da UF do emitente do Documento Fiscaln�o foi informado");
		}
		if(identificacao.getTpImp()==null){
			throw new IllegalArgumentException("Formato de Impress�o do DANFE n�o foi informado");
		}
		if(identificacao.getTpEmis()==null){
			throw new IllegalArgumentException("Forma de Emiss�o da NF-e n�o foi informado");
		}
		if(identificacao.getcDV()==null){
			throw new IllegalArgumentException("D�gito Verificador da Chave de	Acesso da NF-en�o foi informado");
		}
		if(identificacao.getTpAmb()==null){
			throw new IllegalArgumentException("Identifica��o do Ambiente n�o foi informado");
		}
		if(identificacao.getFinNFe()==null){
			throw new IllegalArgumentException("Finalidade de emissão da NF-e n�o foi informado");
		}
		if(identificacao.getProcEmi()==null){
			throw new IllegalArgumentException("Processo de emiss�o da NF-e n�o foi informado");
		}
		if(identificacao.getVerProc()==null){
			throw new IllegalArgumentException("Vers�o do Processo de emiss�o da NF-e n�o foi informado");
		}
	}
	
	public static void validaEmitente(Emitente emitente)throws IllegalArgumentException{
		if((emitente.getCNPJ()==null)&&(emitente.getCPF()==null)){
			throw new IllegalArgumentException("CNPJ/CPF do emitente n�o foi informado");
		}
		if(emitente.getxNome()==null){
			throw new IllegalArgumentException("Raz�o Social ou Nome do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getxLgr()==null){
			throw new IllegalArgumentException("Logradouro do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getNro()==null){
			throw new IllegalArgumentException("Número do endereco do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getxBairro()==null){
			throw new IllegalArgumentException("Bairro do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getcMun()==null){
			throw new IllegalArgumentException("C�digo do munic�pio do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getxMun()==null){
			throw new IllegalArgumentException("Nome do munic�pio do emitente n�o foi informado");
		}
		if(emitente.getEndereco().getUF()==null){
			throw new IllegalArgumentException("Sigla da UF do emitente n�o foi informado");
		}
		if( ( emitente.getEndereco().getCEP() != null ) && (emitente.getEndereco().getCEP().length()!=8)){
			throw new IllegalArgumentException("CEP do emitente é invalido ");
		}
		if(emitente.getIE()==null){
			throw new IllegalArgumentException("IE do emitente n�o foi informado");
		}
	}

	public static void validaNFe(NFe nfe) throws IllegalArgumentException {
		
		validaIdentificacao(nfe.getIdentificacao());
		validaEmitente(nfe.getEmitente());
		
		/**
		 * Destinatario
		 */
		
		if((nfe.getDestinatario().getCNPJ()==null)&&(nfe.getDestinatario().getCPF()==null)){
			throw new IllegalArgumentException("CNPJ/CPF do destinatario n�o foi informado");
		}
		if(nfe.getDestinatario().getxNome()==null){
			throw new IllegalArgumentException("Raz�o Social ou nome do destinat�rio n�o foi informado");
		}
		
		validaEndereco(nfe.getDestinatario().getEndereco(), "destinatario");
		
		if(nfe.getDestinatario().getIE()==null){
			throw new IllegalArgumentException("IE do destinatario n�o foi informado");
		}
		
		/**
		 * Itens
		 */
		
		for(DetProduto detProduto : nfe.getDetProduto()){
			validaItem(detProduto);
		}
		
		/**
		 * Informações do Transporte da NF-e
		 */
		
		if(nfe.getTransporte().getModFrete()==null){
			throw new IllegalArgumentException("Modalidade do frete n�o foi informado");
		}
		
		/**
		 * Valores totais da NFe
		 */
		
		if(nfe.getValoresTotais().getvBC()==null){
			throw new IllegalArgumentException("Base de C�lculo do ICMS da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvICMS()==null){
			throw new IllegalArgumentException("Valor Total do ICMS");
		}
		if(nfe.getValoresTotais().getvBCST() ==null){
			throw new IllegalArgumentException("Base de C�lculo do ICMS ST da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvST() ==null){
			throw new IllegalArgumentException("Valor Total do ICMS ST da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvProd() == null){
			throw new IllegalArgumentException("Valor Total dos produtos e serviços da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvFrete() == null){
			throw new IllegalArgumentException("Valor Total do Frete da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvSeg() == null){
			throw new IllegalArgumentException("Valor Total do Seguro da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvDesc() == null){
			throw new IllegalArgumentException("Valor Total do Desconto da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvII() == null){
			throw new IllegalArgumentException("Valor Total do II da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvIPI() == null){
			throw new IllegalArgumentException("Valor Total do IPI da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvPIS() == null){
			throw new IllegalArgumentException("Valor do PIS	 da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvCOFINS() == null){
			throw new IllegalArgumentException("Valor do COFINS da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvOutro() == null){
			throw new IllegalArgumentException("Outras Despesas acess�rias da nota n�o foi informado");
		}
		if(nfe.getValoresTotais().getvNF() == null){
			throw new IllegalArgumentException("Valor Total da NF-e da nota n�o foi informado");
		}
		
	}
	
	private static void validaEndereco(Endereco endereco, String pessoa){
		
		
		if(endereco.getxLgr()==null){
			throw new IllegalArgumentException("Logradouro do "+pessoa+" n�o foi informado");
		}
		if(endereco.getNro()==null){
			throw new IllegalArgumentException("Número do "+pessoa+" n�o foi informado");
		}
		if(endereco.getxBairro()==null){
			throw new IllegalArgumentException("Bairro do "+pessoa+" n�o foi informado");
		}
		if(endereco.getcMun()==null){
			throw new IllegalArgumentException("C�digo do munic�pio do "+pessoa+" n�o foi informado");
		}
		if(endereco.getxMun()==null){
			throw new IllegalArgumentException("Nome do munic�pio do "+pessoa+" n�o foi informado");
		}
		if(endereco.getUF()==null){
			throw new IllegalArgumentException("Sigla da UF do "+pessoa+" n�o foi informado");
		}
		
	}
	
	private static void validaItem(DetProduto detProduto){
		List<String> erros = new ArrayList<String>();
		
		/*if(detProduto.getProduto().get){
			throw new IllegalArgumentException(" do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}*/
		
		if(detProduto.getProduto().getcProd() == null){
			throw new IllegalArgumentException("Codigo do produto ou serviço do item " + detProduto.getNumeroItem() + " n�o foi informado");
		}
		if(detProduto.getProduto().getxProd() == null){
			throw new IllegalArgumentException("Descri��o do produto ou serviço do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getNCM() == null){
			throw new IllegalArgumentException("C�digo NCM do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if((detProduto.getProduto().getCFOP() == null)&&(detProduto.getProduto().getCFOP().length()!=4)){
			throw new IllegalArgumentException("C�digo Fiscal de Operações e Prestações (CFOP) do item " + detProduto.getNumeroItem() +" n�o foi informado ou é invalido.");
		}
		if(detProduto.getProduto().getuCom() == null){
			throw new IllegalArgumentException("Unidade Comercial do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getqCom() == null){
			throw new IllegalArgumentException("Quantidade Comercial do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getvUnCom() == null){
			throw new IllegalArgumentException("Valor Unit�rio de Comercializa��o do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getvProd() == null){
			throw new IllegalArgumentException("Valor Total Bruto dos Produtos ou Serviços do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getuTrib() == null){
			throw new IllegalArgumentException("Unidade Tribut�vel do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getqTrib() == null){
			throw new IllegalArgumentException("Quantidade Tribut�vel do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getvUnTrib() == null){
			throw new IllegalArgumentException("Valor Unit�rio de tributa��o do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		if(detProduto.getProduto().getIndTot() == null){
			throw new IllegalArgumentException("IndTot do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		
		
		/**
		 * ICMS
		 */
		if(detProduto.getTributo().getiCMS().getOrigemMercadoria()==null){
			throw new IllegalArgumentException("Origem da mercadoria do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}
		
		if(detProduto.getTributo().getiCMS().getCst()==null){
			throw new IllegalArgumentException("Tributa��o do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
		}else{
			switch(Integer.parseInt(detProduto.getTributo().getiCMS().getCst())){
				case 0:
					if(detProduto.getTributo().getiCMS().getBc().getModBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+" Modalidade de determina��o da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
				case 10:
					if(detProduto.getTributo().getiCMS().getBc().getModBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getModBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getpICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
				case 20:
					if(detProduto.getTributo().getiCMS().getBc().getModBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpRedBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Percentual da Redu��o de BC do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
				case 30:
					if(detProduto.getTributo().getiCMS().getBcst().getModBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getpICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
				case 40:
				case 41:
				case 50:
				case 51:
					break;
			
				case 60:
					/*
					if(detProduto.getTributo().getiCMS().getBcst().getvBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getStRet().getvBCSTRet()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMSST retido do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getStRet().getvICMSSTRet()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST retido do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					*/
					break;
				case 70:
					if(detProduto.getTributo().getiCMS().getBc().getModBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpRedBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Percentual da Redu��o de BC do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvBC()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getpICMS()==null){
						throw new IllegalArgumentException("Al�quota do imposto do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getModBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getpICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
				case 90:
					if(detProduto.getTributo().getiCMS().getBc().getModBC()==null){
						throw new IllegalArgumentException("Modalidade de determina��o da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvBC()==null){
						throw new IllegalArgumentException("Valor da BC do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}		
					if(detProduto.getTributo().getiCMS().getBc().getpICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBc().getvICMS()==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getModBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Modalidade de determina��o da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvBCST() ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor da BC do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getpICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Al�quota do imposto do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					if(detProduto.getTributo().getiCMS().getBcst().getvICMSST()  ==null){
						throw new IllegalArgumentException("CST "+detProduto.getTributo().getiCMS().getCst()+"Valor do ICMS ST do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}
					break;
			}
			
			if(detProduto.getTributo().getIPI()!=null){
				if(detProduto.getTributo().getIPI().getcEnq()==null){
					throw new IllegalArgumentException("C�digo de Enquadramento Legal do IPI do item "+detProduto.getNumeroItem() +" n�o foi informado");
				}
				if(detProduto.getTributo().getIPI().getCST()==null){
					throw new IllegalArgumentException("C�digo da situa��o tribut�ria do IPI do item "+detProduto.getNumeroItem() +" n�o foi informado");
				}else{
					switch(Integer.parseInt(detProduto.getTributo().getIPI().getCST())){
					case 00:
					case 49:
					case 50:
					case 99:
						/*
						if(detProduto.getTributo().getIPI().getvBC()==null){
							throw new IllegalArgumentException("Valor da BC do IPI do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getIPI().getqUnid() ==null){
							throw new IllegalArgumentException("Quantidade total na unidade padr�o para tributa��o do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getIPI().getvUnid() ==null){
							throw new IllegalArgumentException("Valor por Unidade Tribut�vel do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getIPI().getpIPI() ==null){
							throw new IllegalArgumentException("Al�quota do IPI do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						*/
						if(detProduto.getTributo().getIPI().getvIPI() ==null){
							throw new IllegalArgumentException("CST: "+detProduto.getTributo().getIPI().getCST()+" Valor do IPI do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						break;
					case 01:
					case 02:
					case 03:
					case 04: 
					case 51: 
					case 52: 
					case 53: 
					case 54:
					case 55:
						break;
					}
				}
				
			}
			
			if(detProduto.getTributo().getpIS() == null){
				throw new IllegalArgumentException("Valor do PIS "+detProduto.getNumeroItem() +" n�o foi informado");
			}else{
				if(detProduto.getTributo().getpIS().getCST() == null){
					throw new IllegalArgumentException("C�digo de Situa��o Tribut�ria do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
				}else{
					switch(Integer.parseInt(detProduto.getTributo().getpIS().getCST())){
					case 01:
					case 02:
						if(detProduto.getTributo().getpIS().getvBC() == null){
							throw new IllegalArgumentException("Valor da Base de C�lculo do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getpIS().getpPIS() == null){
							throw new IllegalArgumentException("Al�quota do PIS (em percentual) do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getpIS().getvPIS() == null){
							throw new IllegalArgumentException("Valor do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						break;
					case 03:
						if(detProduto.getTributo().getpIS().getqBCProd() == null){
							throw new IllegalArgumentException("Quantidade Vendida do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getpIS().getvAliqProd()	 == null){
							throw new IllegalArgumentException("Al�quota do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getpIS().getvPIS()== null){
							throw new IllegalArgumentException("Valor do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						break;
					case 04:
						break;
					case 99:
						/*
						if(detProduto.getTributo().getpIS().getvBC() == null){
							throw new IllegalArgumentException("Valor da Base de C�lculo do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						if(detProduto.getTributo().getpIS().getpPIS() == null){
							throw new IllegalArgumentException("Al�quota do PIS (em percentual) do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						*/
						if(detProduto.getTributo().getpIS().getvPIS()== null){
							throw new IllegalArgumentException("Valor do PIS do item "+detProduto.getNumeroItem() +" n�o foi informado");
						}
						break;
					}
				}
				
				if(detProduto.getTributo().getCofins()==null){
					
				}else{
					if(detProduto.getTributo().getCofins()==null){
						throw new IllegalArgumentException("Valor do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
					}else{
						switch(Integer.parseInt(detProduto.getTributo().getCofins().getCST())){
						case 1:
						case 2:
							if(detProduto.getTributo().getCofins().getvBC()==null){
								throw new IllegalArgumentException("Valor da Base de C�lculo do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getpCOFINS() ==null){
								throw new IllegalArgumentException("Al�quota do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getvCOFINS() ==null){
								throw new IllegalArgumentException("Valor do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							break;
						case 3:
							if(detProduto.getTributo().getCofins().getqBCProd() ==null){
								throw new IllegalArgumentException("Quantidade Vendida do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getvAliqProd() ==null){
								throw new IllegalArgumentException("Al�quota do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getvCOFINS() ==null){
								throw new IllegalArgumentException("Valor do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							break;
						case 4:
						case 6:
						case 7:
						case 8:
						case 9:
							break;
						case 99:
							/*
							if(detProduto.getTributo().getCofins().getvBC()==null){
								throw new IllegalArgumentException("Valor da Base de C�lculo do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getpCOFINS() ==null){
								throw new IllegalArgumentException("Al�quota do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getqBCProd() ==null){
								throw new IllegalArgumentException("Quantidade Vendida do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							if(detProduto.getTributo().getCofins().getvAliqProd() ==null){
								throw new IllegalArgumentException("Al�quota do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							*/
							if(detProduto.getTributo().getCofins().getvCOFINS() ==null){
								throw new IllegalArgumentException("Valor do COFINS do item "+detProduto.getNumeroItem() +" n�o foi informado");
							}
							break;
						}
					}
				}
				
				
				
			}
			
		}
		
	}

	

}
