package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CNPJ;
	private String CPF;
	private String xNome;
	private String xFant;
	private String IE;
	private Endereco endereco;

	public Pessoa() {
		setEndereco(new Endereco());
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		if (cNPJ != null) {
			this.CNPJ = FormatNfe.getZeroEsqStr(cNPJ, 14);
		}else{
			this.CNPJ = null;
		}
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		if (cPF != null) {
			this.CPF = FormatNfe.getZeroEsqStr(cPF, 11);
		}
	}

	public String getxFant() {
		return xFant;
	}

	public void setxFant(String xFant) {
		this.xFant = xFant;
	}

	public String getIE() {
		return IE;
	}

	/**
	 *  Informar a IE quando a pessoa for contribuinte do ICMS.
	 *  Informar ISENTO quando o destinatário for contribuinte do ICMS, mas não estiver obrigado à inscrição no cadastro de contribuintes do ICMS.
	 *  Não informar o conteúdo da TAG se o destinatário não for contribuinte do ICMS.
	 *  Esta tag aceita apenas:
	 *		. ausência de conteúdo (<IE></IE> ou <IE/>) para destinatários não contribuintes do ICMS;
	 *		. algarismos para destinatários contribuintes do ICMS, sem caracteres de formatação (ponto, barra, hífen, etc.);
	 *		. literal “ISENTO” para destinatários contribuintes do ICMS que são isentos de inscrição no cadastro de contribuintes do ICMS;
	 * @param iE
	 */
	public void setIE(String iE) {

		if (iE != null) {
			this.IE = iE.replace("-", "");
			this.IE = this.IE.replace(".", "");

			if(!this.IE.equals("ISENTO")){

				Pattern p = Pattern.compile( "([0-9]*)" );
				Matcher m = p.matcher(this.IE);

				if(!m.matches())
					if(this instanceof Destinatario)
						throw new IllegalArgumentException("Inscrição Estadual do Destinatario é invalida");
					else if(this instanceof Emitente)
						throw new IllegalArgumentException("Inscrição Estadual do Emitente  é invalida");
					else
						throw new IllegalArgumentException("Inscrição Estadual invalida");
			}
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setXnome(String xnome) {
		this.xNome = xnome;
	}
	public String getxNome() {
		if((xNome!=null)&&(xNome.length()>60)){
			return xNome.substring(0,60);
		}
		return xNome;
	}
	public void setxNome(String xNome) {
		this.xNome = xNome;
	}
	
	//private NFe nFe;
	//private Transporte transporte;

}

