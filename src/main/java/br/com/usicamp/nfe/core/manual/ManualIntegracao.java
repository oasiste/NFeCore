package br.com.usicamp.nfe.core.manual;

public class ManualIntegracao {
	
	public final static int LOTE_RECEBIDO_COM_SUCESSO = 103;
	public static final int LOTE_EM_PROCESSAMENTO = 105;
	
	public static final int REJEICAO_FALHA_SCHEMA_XML = 215;
	public static final int REJEICAO_FALHA_SCHEMA_XML_DO_LOTE_NFE = 225;
	
	public final static int CANCELAMENTO_NFE_HOMOLOGADO = 101;
	public static final int LOTE_PROCESSADO = 104;
	public static final int LOTE_NAO_LOCALIZADO = 106;
	public static final int COD_ATORIZADO_USO_NFE = 100;
	
	
	public static boolean isCodStatusRejeitado(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus > 400 && codStatus <= 568;
	}
	
	public static boolean isCodStatusDenegado(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus == 301 || codStatus == 302 || codStatus == 999|| codStatus == 110;
	}
	
	public static boolean isCodStatusAutorizado(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus.equals(COD_ATORIZADO_USO_NFE);
	}
	
	public static boolean isCodStatusLoteRecebidoComSucesso(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus.equals(103);
	}
	
	/**
	 * Se cStatus = 105 significa Lote em processamento.
	 */
	public static boolean isCodStatusLoteEmProcessamento(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus.equals(105);
	}
	/**
	 * Se cStatus = 215, 516, 517 ou 545 significa que a mensagem de consulta � inv�lida.
	 * Se cStatus = 225, 565. 567 ou , significa que o lote de NF-e consultado � inv�lido
	 */

	public static boolean isCodStatusRetConsReciNFeValido(Integer codStatus){
		if(codStatus == null) 
			return false;
		if(codStatus.equals(215) ||
				codStatus.equals(516)  ||
				codStatus.equals(517)  ||
				codStatus.equals(545)  ||
				codStatus.equals(225)  ||
				codStatus.equals(565)  ||
				codStatus.equals(567)  ||
				codStatus.equals(568) ) 
				{
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isCodStatusCancelamentoNFeHomologado(Integer codStatus){
		if(codStatus == null) 
			return false;
		return codStatus.equals(101);
	}

}
