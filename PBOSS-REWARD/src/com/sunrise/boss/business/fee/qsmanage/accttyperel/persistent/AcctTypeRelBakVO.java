package com.sunrise.boss.business.fee.qsmanage.accttyperel.persistent;

import java.io.Serializable;
/**
 * 
 * @author wangguangying 20080916
 *
 */
public class AcctTypeRelBakVO implements Serializable {
	private String acctid;
	private Short accttype;
	public String getAcctid() {
		return acctid;
	}
	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}
	public Short getAccttype() {
		return accttype;
	}
	public void setAccttype(Short accttype) {
		this.accttype = accttype;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(this.getAcctid().toString()).append("~").append(this.getAccttype().toString()).append("~");
		return buf.toString();
	}
}