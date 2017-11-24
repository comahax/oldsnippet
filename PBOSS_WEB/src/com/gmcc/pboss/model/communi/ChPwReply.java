package com.gmcc.pboss.model.communi;

import java.util.Date;

/**
 * ChPwReply entity. @author MyEclipse Persistence Tools
 */

public class ChPwReply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Long replyid;
	private Long advinfoid;
	private Date replytime;
	private String replycontent;
	private String affix;
	private String oid;

	// Constructors

	/** default constructor */
	public ChPwReply() {
	}

	/** full constructor */
	public ChPwReply(Long advinfoid, Date replytime, String replycontent,
			String affix, String oid) {
		this.advinfoid = advinfoid;
		this.replytime = replytime;
		this.replycontent = replycontent;
		this.affix = affix;
		this.oid = oid;
	}

	// Property accessors

	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	public Long getAdvinfoid() {
		return this.advinfoid;
	}

	public void setAdvinfoid(Long advinfoid) {
		this.advinfoid = advinfoid;
	}

	public Date getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public String getReplycontent() {
		return this.replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public String getAffix() {
		return this.affix;
	}

	public void setAffix(String affix) {
		this.affix = affix;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

}