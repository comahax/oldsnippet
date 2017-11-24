package com.gmcc.pboss.model.sms;

/**
 * ChSmsSmstmpl entity. @author MyEclipse Persistence Tools
 */

public class ChSmsSmstmpl extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String stype;
	private String sstate;
	private String scontent;
	private String smemo;

	// Constructors

	/** default constructor */
	public ChSmsSmstmpl() {
	}

	/** full constructor */
	public ChSmsSmstmpl(String sname, String stype, String sstate,
			String scontent, String smemo) {
		this.sname = sname;
		this.stype = stype;
		this.sstate = sstate;
		this.scontent = scontent;
		this.smemo = smemo;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStype() {
		return this.stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSstate() {
		return this.sstate;
	}

	public void setSstate(String sstate) {
		this.sstate = sstate;
	}

	public String getScontent() {
		return this.scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSmemo() {
		return this.smemo;
	}

	public void setSmemo(String smemo) {
		this.smemo = smemo;
	}

}