package br.com.usicamp.nfe.core.dto;

import java.io.Serializable;

import br.com.usicamp.nfe.core.util.FormatNfe;

public class Endereco implements Serializable{
 
	private static final long serialVersionUID = 6407579611141238195L;
	private String xLgr;
	private String nro;	 
	private String xCpl;	 
	private String xBairro;	 
	private String cMun;	 
	private String xMun;	 
	private String UF;	 
	private String CEP;	 
	private Integer cPais;	 
	private String xPais;	 
	private String fone;	
	private String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getxLgr() {
		return xLgr;
	}
	public void setxLgr(String xLgr) {
		this.xLgr = xLgr;
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		if(nro == null){
			this.nro = "S/N";
		}else{
			this.nro = nro;
		}
	}
	public String getxCpl() {
		return xCpl;
	}
	public void setxCpl(String xCpl) {
		this.xCpl = xCpl;
	}
	public String getxBairro() {
		return xBairro;
	}
	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}
	public String getcMun() {
		return cMun;
	}
	public void setcMun(Integer cMun) {
		if(cMun!=null){
			this.cMun = cMun.toString();
		}
	}
	public String getxMun() {
		return xMun;
	}
	public void setxMun(String xMun) {
		this.xMun = xMun;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		if(cEP != null){
			this.CEP = cEP.replace("-", "");
			this.CEP = FormatNfe.getZeroEsqStr(cEP, 8);
			this.CEP = FormatNfe.getZeroEsqStr(this.CEP, 8);
		}
	}
	public Integer getcPais() {
		return cPais;
	}
	public void setcPais(Integer cPais) {
		this.cPais = cPais;
	}
	public String getxPais() {
		return xPais;
	}
	public void setxPais(String xPais) {
		this.xPais = xPais;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	} 
}
 
