package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class Produto implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cProd;
	private String cEAN;
	private String xProd;
	private String NCM;
	private String EXTIPI;
	private Integer genero;
	private String CFOP;
	private String uCom;
	private Double qCom;
	private Double vUnCom;
	private Double vProd;
	private String cEANTrib;
	private String uTrib;
	private Double qTrib;
	private Double vUnTrib;
	private Double vFrete;
	private Double vSeg;
	private Double vDesc;
	private Double vOutro;
	 
	/**
	 * Este campo dever· ser preenchido com:
	 * 0 ñ o valor do item (vProd) n„o compıe o valor total da NF-e(vProd)
	 * 1 ñ o valor do item (vProd) compıe o valor total da NF-e (vProd) (v2.0)
	 */
	private Integer indTot;
	 
	private InfAdProd infAdProd;

	public String getcProd() {
		return cProd;
	}

	public void setcProd(String cProd) {
		this.cProd = cProd;
	}

	public String getCEAN() {
		return cEAN;
	}

	public void setCEAN(String cEAN) {
		this.cEAN = cEAN;
	}

	public String getxProd() {
		return xProd;
	}

	public void setxProd(String xProd) {
		if (xProd != null) {
			if (xProd.length() > 120) {
				this.xProd = xProd.substring(0, 120);
			} else {
				this.xProd = xProd;
			}
			this.xProd = FormatNfe.retiraAcentuacao(this.xProd);
			this.xProd = this.xProd.replaceAll("\"", "");
			this.xProd = this.xProd.replaceAll("," , "");
		}
	}

	public String getNCM() {
		return this.NCM;
	}

	public void setNCM(String nCM) {
		if(nCM != null){
			this.NCM = nCM.replaceAll("[.]", "");
		}
	}

	public String getEXTIPI() {
		return EXTIPI;
	}

	public void setEXTIPI(String eXTIPI) {
		EXTIPI = eXTIPI;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}
	
	public String getCFOP() {
		return CFOP;
	}

	public void setCFOP(String cFOP) {
		CFOP = cFOP;
	}

	public String getuCom() {
		return uCom;
	}
	
	/**
	 * Unidade Comercial
	 * @param uCom
	 */
	public void setuCom(String uCom) {
		this.uCom = uCom;
	}

	public String getqCom() {
		return FormatNfe.getQuatroCasasDecimal(qCom);
	}

	/**
	 * Quantidade Comercial
	 * @param qCom
	 */
	public void setqCom(Double qCom) {
		this.qCom = qCom;
	}

	public String getvUnCom() {
		return FormatNfe.getQuatroCasasDecimal(vUnCom);// vUnCom.toString();
	}

	/**
	 * Valor Unita�?rio de Comercialização <br>
	 * Informar o valor unita�?rio de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais). Para efeitos de ca�?lculo, o valor unita�?rio sera�? obtido pela divisão do valor do produto pela quantidade comercial. (v2.0)
	 * @param vUnCom
	 */
	public void setvUnCom(Double vUnCom) {
		this.vUnCom = vUnCom;
	}

	public String getvProd() {
		return FormatNfe.getDuasCasasDecimal(vProd);
	}

	public void setvProd(Double vProd) {
		this.vProd = vProd;
	}

	public String getcEANTrib() {
		return cEANTrib;
	}

	public void setcEANTrib(String cEANTrib) {
		this.cEANTrib = cEANTrib;
	}

	public String getuTrib() {
		return uTrib;
	}
	
	/**
	 * Unidade Tributa�?vel
	 * @param uTrib
	 */
	public void setuTrib(String uTrib) {
		this.uTrib = uTrib;
	}

	public String getqTrib() {
		return FormatNfe.getQuatroCasasDecimal(qTrib);// .toString();
	}

	/**
	 * Quantidade Tributa�?vel
	 * @param qTrib
	 */
	public void setqTrib(Double qTrib) {
		this.qTrib = qTrib;
	}

	public String getvUnTrib() {
		return FormatNfe.getQuatroCasasDecimal(vUnTrib);
	}

	/**
	 * Valor Unita�?rio de tributação
	 * @param vUnTrib
	 */
	public void setvUnTrib(Double vUnTrib) {
		this.vUnTrib = vUnTrib;
	}

	public String getvFrete() {
		if(vFrete!=null){
			return FormatNfe.getDuasCasasDecimal(vFrete);
		}else{
			return null;
		}
		
	}

	public void setvFrete(Double vFrete) {
		this.vFrete = vFrete;
	}

	public String getvSeg() {
		if(vSeg!=null){
			return FormatNfe.getDuasCasasDecimal(vFrete);
		}else{
			return null;
		}
	}

	public void setvSeg(Double vSeg) {
		this.vSeg = vSeg;
	}

	public String getvDesc() {
		if(vDesc!=null){
			return FormatNfe.getDuasCasasDecimal(vDesc);
		}else{
			return null;
		}
	}

	public void setvDesc(Double vDesc) {
		this.vDesc = vDesc;
	}

	public String getvOutro() {
		if(vOutro !=null)
			return FormatNfe.getDuasCasasDecimal(vOutro);
		else
			return null;
	}

	public void setvOutro(Double vOutro) {
		this.vOutro = vOutro;
	}

	public Integer getIndTot() {
		return indTot;
	}

	public void setIndTot(Integer indTot) {
		this.indTot = indTot;
	}

	public InfAdProd getInfAdProd() {
		return infAdProd;
	}

	public void setInfAdProd(InfAdProd infAdProd) {
		this.infAdProd = infAdProd;
	}
	
	public static boolean isGeneroNCM(String ncm){
		if(ncm == null)
			return false;
		
		if(ncm.length()==2)
			return true;
		else
			return false;
	}
}
 
