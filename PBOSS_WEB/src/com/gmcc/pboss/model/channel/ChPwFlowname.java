package com.gmcc.pboss.model.channel;

/**
 * ChPwFlowname entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ChPwFlowname implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4046558044190593693L;
	private String stepid;
	private String stepname;
	private String oprcode;
	private Long issms;
	private String sendtime;
	private String nextstepid;

	// Constructors

	/** default constructor */
	public ChPwFlowname() {
	}

	/** minimal constructor */
	public ChPwFlowname(String stepid) {
		this.stepid = stepid;
	}

	/** full constructor */
	public ChPwFlowname(String stepid, String stepname, String oprcode,
			Long issms, String sendtime, String nextstepid) {
		this.stepid = stepid;
		this.stepname = stepname;
		this.oprcode = oprcode;
		this.issms = issms;
		this.sendtime = sendtime;
		this.nextstepid = nextstepid;
	}

	// Property accessors

	public String getStepid() {
		return this.stepid;
	}

	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	public String getStepname() {
		return this.stepname;
	}

	public void setStepname(String stepname) {
		this.stepname = stepname;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Long getIssms() {
		return this.issms;
	}

	public void setIssms(Long issms) {
		this.issms = issms;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getNextstepid() {
		return this.nextstepid;
	}

	public void setNextstepid(String nextstepid) {
		this.nextstepid = nextstepid;
	}

}