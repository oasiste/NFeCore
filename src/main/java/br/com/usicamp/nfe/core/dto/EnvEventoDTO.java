package br.com.usicamp.nfe.core.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvEventoDTO {
	
	private Integer idLote;
	private List<EnvEventoDTO.Evento> eventos;

	public EnvEventoDTO() {
		setEventos(new ArrayList<EnvEventoDTO.Evento>());
	}
	
	public Integer getIdLote() {
		return idLote;
	}
	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}
	public List<EnvEventoDTO.Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<EnvEventoDTO.Evento> eventos) {
		this.eventos = eventos;
	}
	
	public class Evento{
		private String versao;
		private EnvEventoDTO.Evento.InfEvento infEvento;
		
		public Evento(){
			setInfEvento(new EnvEventoDTO.Evento.InfEvento());
		}
		
		public String getVersao() {
			return versao;
		}

		public void setVersao(String versao) {
			this.versao = versao;
		}

		public EnvEventoDTO.Evento.InfEvento getInfEvento() {
			return infEvento;
		}

		public void setInfEvento(EnvEventoDTO.Evento.InfEvento infEvento) {
			this.infEvento = infEvento;
		}

		public class InfEvento{
			private Integer cOrgao;
			private Integer tpAmb;
			private String CNPJ;
			private String chNFe;
			private String dhEvento;
			private String tpEvento;
			private String nSeqEvento;
			private String verEvento;
			private DetEvento detEvento;
			
			public InfEvento() {
				setTpEvento("110110");
				setDetEvento(new InfEvento.DetEvento());
			}
			
			public String getId() {
				
				StringBuilder idBuilder = new StringBuilder("ID");
				idBuilder.append(getTpEvento());
				idBuilder.append(getChNFe());
				String nSeqEvento = getnSeqEvento();
				while(nSeqEvento!=null&&nSeqEvento.length() < 2)
					nSeqEvento = "0".concat(nSeqEvento);
				idBuilder.append(nSeqEvento);
				
				return idBuilder.toString();
			}
			
			public Integer getcOrgao() {
				return cOrgao;
			}
			public void setcOrgao(Integer cOrgao) {
				this.cOrgao = cOrgao;
			}
			public Integer getTpAmb() {
				return tpAmb;
			}
			public void setTpAmb(Integer tpAmb) {
				this.tpAmb = tpAmb;
			}
			public String getCNPJ() {
				return CNPJ;
			}
			public void setCNPJ(String cNPJ) {
				CNPJ = cNPJ;
			}
			public String getChNFe() {
				return chNFe;
			}
			public void setChNFe(String chNFe) {
				this.chNFe = chNFe;
			}
			public String getDhEvento() {
				return dhEvento;
			}
			public void setDhEvento(Date date) {
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss-03:00");
				
				this.dhEvento = format.format(date);
			}
			public void setDhEvento(String dateString) {
				
				
				this.dhEvento = dateString;
			}
			
			public String getTpEvento() {
				return tpEvento;
			}
			void setTpEvento(String tpEvento) {
				this.tpEvento = tpEvento;
			}

			public String getnSeqEvento() {
				return nSeqEvento;
			}

			public void setnSeqEvento(String nSeqEvento) {
				this.nSeqEvento = nSeqEvento;
			}

			public String getVerEvento() {
				return verEvento;
			}

			public void setVerEvento(String verEvento) {
				this.verEvento = verEvento;
			}
			
			public DetEvento getDetEvento() {
				return detEvento;
			}

			public void setDetEvento(DetEvento detEvento) {
				this.detEvento = detEvento;
			}

			public class DetEvento{
				private String versao;
				private String descEvento;
				private String xCorrecao;
				private String xCondUso;
				
				public DetEvento() {
					setDescEvento("Carta de Correcao");
					
					StringBuilder condUsoBuilder = new StringBuilder("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do ");
					condUsoBuilder.append("art. 7o do Convenio S/N, de 15 de dezembro de 1970 e ");
					condUsoBuilder.append("pode ser utilizada para regularizacao de erro ocorrido na ");
					condUsoBuilder.append("emissao de documento fiscal, desde que o erro nao esteja ");
					condUsoBuilder.append("relacionado com: I - as variaveis que determinam o valor ");
					condUsoBuilder.append("do imposto tais como: base de calculo, aliquota, diferenca ");
					condUsoBuilder.append("de preco, quantidade, valor da operacao ou da prestacao; ");
					condUsoBuilder.append("II - a correcao de dados cadastrais que implique mudanca ");
					condUsoBuilder.append("do remetente ou do destinatario; III - a data de emissao ou de saida.");
					
					setxCondUso(condUsoBuilder.toString());
				}
				
				public String getVersao() {
					return versao;
				}
				public void setVersao(String versao) {
					this.versao = versao;
				}
				public String getDescEvento() {
					return descEvento;
				}
				protected void setDescEvento(String descEvento) {
					this.descEvento = descEvento;
				}

				public String getxCorrecao() {
					return xCorrecao;
				}

				public void setxCorrecao(String xCorrecao) {
					this.xCorrecao = xCorrecao;
				}

				public String getxCondUso() {
					return xCondUso;
				}

				 void setxCondUso(String xCondUso) {
					this.xCondUso = xCondUso;
				}
			}
		}
	}
}
