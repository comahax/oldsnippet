package com.gmcc.pboss.model.sms;

import java.util.Date;

/**
 * FxSwSmsconfirm entity. @author MyEclipse Persistence Tools
 */

public class FxSwSmsconfirm extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long recid;
	private String type;
	private String stream;
	private String mobileno;
	private String orderid;
	private String state;
	private Date sendtime;
	private Date reptime;
	private String repdesc;

	// Constructors

	/** default constructor */
	public FxSwSmsconfirm() {
	}

	/** full constructor */
	public FxSwSmsconfirm(String type, String stream, String mobileno,
			String orderid, String state, Date sendtime, Date reptime,
			String repdesc) {
		this.type = type;
		this.stream = stream;
		this.mobileno = mobileno;
		this.orderid = orderid;
		this.state = state;
		this.sendtime = sendtime;
		this.reptime = reptime;
		this.repdesc = repdesc;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStream() {
		return this.stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Date getReptime() {
		return this.reptime;
	}

	public void setReptime(Date reptime) {
		this.reptime = reptime;
	}

	public String getRepdesc() {
		return this.repdesc;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

}