package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.List;

import br.com.usicamp.nfe.core.chaveacesso.ChaveAcessoV2;
import br.com.usicamp.nfe.core.util.FormatNfe;


public class NFe implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer versao;
	/**
	 * informar a chave de acesso da NF-e precedida do literal �NFe�, acrescentada a valida��o do formato (v2.0).
	 */
	private String id;
	private String numProtocoloAutorizacao;
	
	/**
	 * Usado para emiss�o da NF-e em Conting�ncia com Impress�o do DANFE em Formul�rio de Seguran�a
	 */
	private String codBarraAdicional;
	private Identificacao identificacao;
	private List<DetProduto> detProduto;
	private Emitente emitente;
	private Destinatario destinatario;
	private ValoresTotais valoresTotais;
	private Cobranca cobranca;
	private InfAdic infAdic;
	private Pessoa localRetirada;
	private Pessoa localEntrega;
	private Transporte transporte;
	
	
	public NFe(Identificacao identificacao, List<DetProduto> detProduto,
			Emitente emitente, Destinatario destinatario,
			ValoresTotais valoresTotais, Cobranca cobranca, InfAdic infAdic,
			Pessoa localRetirada, Pessoa localEntrega, Transporte transporte) {
		
		if(identificacao == null){
			throw new IllegalArgumentException("O parametro Identificacao n�o pode ser nulo.");
		}
		if(detProduto == null){
			throw new IllegalArgumentException("O parametro Identificacao n�o pode ser nulo.");
		}
		if(emitente == null){
			throw new IllegalArgumentException("O parametro Emitente n�o pode ser nulo.");
		}
		if(destinatario == null){
			throw new IllegalArgumentException("O parametro Destinatario n�o pode ser nulo.");
		}
		if(valoresTotais == null){
			throw new IllegalArgumentException("O parametro ValoresTotais n�o pode ser nulo.");
		}
		if(cobranca == null){
			throw new IllegalArgumentException("O parametro Cobranca n�o pode ser nulo.");
		}
		
		this.identificacao = identificacao;
		this.detProduto = detProduto;
		this.emitente = emitente;
		this.destinatario = destinatario;
		this.valoresTotais = valoresTotais;
		this.cobranca = cobranca;
		this.infAdic = infAdic;
		this.localRetirada = localRetirada;
		this.localEntrega = localEntrega;
		this.transporte = transporte;
		
		String ChaveAcesso =  ChaveAcessoV2.getChaveAcesso(this);
		
		identificacao.setcDV(getDigitoVerificador(ChaveAcesso));  	
		
		this.id = "NFe" + ChaveAcesso + identificacao.getcDV().toString();
	}
	
	public Integer getVersao() {
		return versao;
	}
	public String getId() {
		return id;
	}
	public String getNumProtocoloAutorizacao() {
		return numProtocoloAutorizacao;
	}
	public void setNumProtocoloAutorizacao(String numProtocoloAutorizacao) {
		this.numProtocoloAutorizacao = numProtocoloAutorizacao;
	}
	public Identificacao getIdentificacao() {
		return identificacao;
	}
	public List<DetProduto> getDetProduto() {
		return detProduto;
	}
	public Emitente getEmitente() {
		return emitente;
	}
	public Destinatario getDestinatario() {
		return destinatario;
	}
	public ValoresTotais getValoresTotais() {
		return valoresTotais;
	}
	public Cobranca getCobranca() {
		return cobranca;
	}
	public InfAdic getInfAdic() {
		return infAdic;
	}
	public Pessoa getLocalRetirada() {
		return localRetirada;
	}
	public Pessoa getLocalEntrega() {
		return localEntrega;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public String getCodBarraAdicional() {
		return codBarraAdicional;
	}
	public void setCodBarraAdicional(String codBarraAdicional) {
		this.codBarraAdicional = codBarraAdicional;
	}
	
	private int getDigitoVerificador(String chaveAceeso){
		int peso = 1;
        int soma = 0;
        int tam = chaveAceeso.length();
        for (int i = 0; i < tam; i++) {
            peso++;
            if (peso > 9) {
                peso = 2;
            }
            soma = soma + (peso * Integer.parseInt(String.valueOf(chaveAceeso.charAt(tam - i - 1))));
        }
        int resto = (soma % 11);
        int dv;
        if ((resto == 0) || (resto == 1)) {
            dv = 0;
        } else {
            dv = 11 - resto;
        }
		return dv;
	}
	
	public String getChaveAcesso(){
		
		String cUF   = this.getIdentificacao().getcUF().toString();
        String AAMM  = this.getIdentificacao().getdEmi().substring(2, 4).concat(this.getIdentificacao().getdEmi().substring(5, 7));
        String CNPJ  = this.getEmitente().getCNPJ();
        String mod   = this.getIdentificacao().getMod();
        String serie = FormatNfe.getZeroEsqStr(this.getIdentificacao().getSerie().toString(), 3);
        String nNF   = FormatNfe.getZeroEsqStr(this.getIdentificacao().getnNF().toString(), 9);
        String tpEmis = this.getIdentificacao().getTpEmis().toString();
        String cNF   =  FormatNfe.getZeroEsqStr(this.getIdentificacao().getcNF(), 8);
            
        String chaveAcessoSemDv = cUF + AAMM + CNPJ + mod + serie + nNF + tpEmis + cNF;
        
		return chaveAcessoSemDv.concat(String.valueOf(getDigitoVerificador(chaveAcessoSemDv)))  ;
	}
 
}
 
