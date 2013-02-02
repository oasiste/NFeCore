package br.com.usicamp.nfe.core.dto;

import java.util.Date;

/**
 * @author Otavio
 *
 */
public class RetDPEC extends Retorno {
	private Date dhRegDPEC;
	private Integer nRegDPEC;
	
	public Date getDhRegDPEC() {
		return dhRegDPEC;
	}
	public void setDhRegDPEC(Date dhRegDPEC) {
		this.dhRegDPEC = dhRegDPEC;
	}
	public Integer getnRegDPEC() {
		return nRegDPEC;
	}
	public void setnRegDPEC(Integer nRegDPEC) {
		this.nRegDPEC = nRegDPEC;
	}
}
