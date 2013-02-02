package br.com.usicamp.nfe.core.chaveacesso;

import br.com.usicamp.nfe.core.dto.NFe;
import br.com.usicamp.nfe.core.util.FormatNfe;

public class ChaveAcessoV2{

	public static String getChaveAcesso(NFe nfe) {
		
		String cUF   = nfe.getIdentificacao().getcUF().toString();
        String AAMM  = nfe.getIdentificacao().getdEmi().substring(2, 4).concat(nfe.getIdentificacao().getdEmi().substring(5, 7));
        String CNPJ  = nfe.getEmitente().getCNPJ();
        String mod   = nfe.getIdentificacao().getMod();
        String serie = FormatNfe.getZeroEsqStr(nfe.getIdentificacao().getSerie().toString(), 3);
        String nNF   = FormatNfe.getZeroEsqStr(nfe.getIdentificacao().getnNF().toString(), 9);
        String tpEmis = nfe.getIdentificacao().getTpEmis().toString();
        String cNF   =  FormatNfe.getZeroEsqStr(nfe.getIdentificacao().getcNF(), 8);
              		
		return cUF + AAMM + CNPJ + mod + serie + nNF + tpEmis + cNF;
	}
	


}
