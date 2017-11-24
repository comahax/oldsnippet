package com.gmcc.pboss.biz.info.salescnt.support;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Salescnt {

	// 业务类型
	private String opntype;
	// 销售数量
	private int cnt;
	
	public Salescnt() {
		super();
	}
	
	/**
	 * 
	 * @param opntype 业务类型
	 * @param cnt 数量
	 */
	public Salescnt(String opntype, int cnt) {
		super();
		this.opntype = opntype;
		this.cnt = cnt;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
