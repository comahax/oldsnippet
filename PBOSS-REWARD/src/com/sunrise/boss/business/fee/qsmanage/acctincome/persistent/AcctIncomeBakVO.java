package com.sunrise.boss.business.fee.qsmanage.acctincome.persistent;

import java.io.Serializable;
/**
 * 
 * @author wangguangying 20080910
 *
 */
public class AcctIncomeBakVO implements Serializable {
	private Long acctid;
	private String acctcode;
	private String acctcodename;
	private Short type;
	private Short isresolution;
	private String descri;
	public String getAcctcode() {
		return acctcode;
	}
	public void setAcctcode(String acctcode) {
		this.acctcode = acctcode;
	}
	public String getAcctcodename() {
		return acctcodename;
	}
	public void setAcctcodename(String acctcodename) {
		this.acctcodename = acctcodename;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public Long getAcctid() {
		return acctid;
	}
	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}
	public Short getIsresolution() {
		return isresolution;
	}
	public void setIsresolution(Short isresolution) {
		this.isresolution = isresolution;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}

	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(this.getAcctid().toString()).append("~").append(this.getAcctcode()).append("~")
			.append(this.getAcctcodename()).append("~").append(this.getType().toString()).append("~")
			.append(this.getIsresolution().toString()).append("~").append(this.getDescri()).append("~");
		return buf.toString();
	}
}
