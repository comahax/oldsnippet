package com.gmcc.pboss.model.auditWork;

import java.util.Date;

/**
 * ChPwAuditwork entity. @author MyEclipse Persistence Tools
 */

public class ChPwAuditwork implements java.io.Serializable {

	// Fields

	private Long seqid;
	private String worktype;
	private Long applyno;
	private String stepid;
	private Date createtime;
	private String oprcode;
	private Date optime;
	private String content;
	private Byte auditstatus;

	// Constructors

	/** default constructor */
	public ChPwAuditwork() {
	}

	/** full constructor */
	public ChPwAuditwork(String worktype, Long applyno, String stepid,
			Date createtime, String oprcode, Date optime, String content,
			Byte auditstatus) {
		this.worktype = worktype;
		this.applyno = applyno;
		this.stepid = stepid;
		this.createtime = createtime;
		this.oprcode = oprcode;
		this.optime = optime;
		this.content = content;
		this.auditstatus = auditstatus;
	}

	// Property accessors

	public Long getSeqid() {
		return this.seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public String getWorktype() {
		return this.worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public Long getApplyno() {
		return this.applyno;
	}

	public void setApplyno(Long applyno) {
		this.applyno = applyno;
	}

	public String getStepid() {
		return this.stepid;
	}

	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getAuditstatus() {
		return this.auditstatus;
	}

	public void setAuditstatus(Byte auditstatus) {
		this.auditstatus = auditstatus;
	}

}