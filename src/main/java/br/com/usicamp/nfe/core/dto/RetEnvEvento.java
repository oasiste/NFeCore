package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RetEnvEvento extends Retorno{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5423618487693798041L;
	/**
	 * 
	 */

	private String idLote;
	private List<RetEnvEvento.RetEvento> retEventos;
	
	public RetEnvEvento() {
		setRetEventos(new ArrayList<RetEnvEvento.RetEvento>());
	}
	
	public String getIdLote() {
		return idLote;
	}
	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	public List<RetEnvEvento.RetEvento> getRetEventos() {
		return retEventos;
	}
	public void setRetEventos(List<RetEnvEvento.RetEvento> retEventos) {
		this.retEventos = retEventos;
	}
	
	public class RetEvento implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1817359800223632627L;
		private String versao;
		private RetEnvEvento.RetEvento.InfEvento infEvento;
		
		
		public RetEvento() {
			setInfEvento(new InfEvento());
		}
		
		public class InfEvento extends Retorno{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -7213866404062341479L;
			private String id;
//			private Integer tpAmb;
//			private String verAplic;
			private Integer cOrgao;
//			private Integer cStat;
		//	private String xMotivo;
			private String chNFe;
			private Integer tpEvento;
			private String xEvento;
			private Integer nSeqEvento;
			private String CNPJDest;
			private String CPFDest;
			private String nProt;
			private String emailDest;
			private String dhRegEvento;
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
//			public Integer getTpAmb() {
//				return tpAmb;
//			}
//			public void setTpAmb(Integer tpAmb) {
//				this.tpAmb = tpAmb;
//			}
//			public String getVerAplic() {
//				return verAplic;
//			}
//			public void setVerAplic(String verAplic) {
//				this.verAplic = verAplic;
//			}
			public Integer getcOrgao() {
				return cOrgao;
			}
			public void setcOrgao(Integer cOrgao) {
				this.cOrgao = cOrgao;
			}
//			public Integer getcStat() {
//				return cStat;
//			}
//			public void setcStat(Integer cStat) {
//				this.cStat = cStat;
//			}
//			public String getxMotivo() {
//				return xMotivo;
//			}
//			public void setxMotivo(String xMotivo) {
//				this.xMotivo = xMotivo;
//			}
			public String getChNFe() {
				return chNFe;
			}
			public void setChNFe(String chNFe) {
				this.chNFe = chNFe;
			}
			public Integer getTpEvento() {
				return tpEvento;
			}
			public void setTpEvento(Integer tpEvento) {
				this.tpEvento = tpEvento;
			}
			public String getxEvento() {
				return xEvento;
			}
			public void setxEvento(String xEvento) {
				this.xEvento = xEvento;
			}
			public Integer getnSeqEvento() {
				return nSeqEvento;
			}
			public void setnSeqEvento(Integer nSeqEvento) {
				this.nSeqEvento = nSeqEvento;
			}
			public String getCNPJDest() {
				return CNPJDest;
			}
			public void setCNPJDest(String cNPJDest) {
				CNPJDest = cNPJDest;
			}
			public String getCPFDest() {
				return CPFDest;
			}
			public void setCPFDest(String cPFDest) {
				CPFDest = cPFDest;
			}
			public String getnProt() {
				return nProt;
			}
			public void setnProt(String nProt) {
				this.nProt = nProt;
			}
			public String getEmailDest() {
				return emailDest;
			}
			public void setEmailDest(String emailDest) {
				this.emailDest = emailDest;
			}
			public String getDhRegEvento() {
				return dhRegEvento;
			}
			public void setDhRegEvento(String dhRegEvento) {
				this.dhRegEvento = dhRegEvento;
			}
			
		}

		public String getVersao() {
			return versao;
		}

		public void setVersao(String versao) {
			this.versao = versao;
		}

		public RetEnvEvento.RetEvento.InfEvento getInfEvento() {
			return infEvento;
		}

		public void setInfEvento(RetEnvEvento.RetEvento.InfEvento infEvento) {
			this.infEvento = infEvento;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getIdLote());
		stringBuilder.append("/");
		stringBuilder.append(this.getVerAplic());
		stringBuilder.append("/");
		stringBuilder.append(this.getVersao());
		stringBuilder.append("/");
		stringBuilder.append(this.getXmlRetorno());
		stringBuilder.append("/");
		stringBuilder.append(this.getxMotivo());
		stringBuilder.append("/");
		stringBuilder.append(this.getcStat());
		stringBuilder.append("/");
		stringBuilder.append(this.getcUF());
		stringBuilder.append("/");

		return stringBuilder.toString();
	}
	
}
