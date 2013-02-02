package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.usicamp.nfe.core.util.FormatNfe;

public class Duplicata implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String nDup;
	private Date dVenc;
	private Double vDup;
	private String sTipoOrigem;

	public String getnDup() {
		return nDup;
	}
	public void setnDup(String nDup) {
		this.nDup = nDup;
	}
	public String getdVenc() {
		return (dVenc == null) ? null : new SimpleDateFormat("yyyy-MM-dd").format(dVenc);
	}
	public void setdVenc(Date dVenc) {
		this.dVenc = dVenc;
	}
	public String getvDup() {
		return FormatNfe.getDuasCasasDecimal(vDup);
	}
	public void setvDup(Double vDup) {
		this.vDup = vDup;
	}
	public String getsTipoOrigem() {
		return sTipoOrigem;
	}
	public void setsTipoOrigem(String sTipoOrigem) {
		this.sTipoOrigem = sTipoOrigem;
	}
}
 
