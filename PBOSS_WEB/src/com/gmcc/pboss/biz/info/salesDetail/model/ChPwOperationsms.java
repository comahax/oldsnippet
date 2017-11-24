package com.gmcc.pboss.biz.info.salesDetail.model;

/**
 * ChPwOperationsms entity. @author MyEclipse Persistence Tools
 */
public class ChPwOperationsms implements java.io.Serializable {

	// Fields
	private ChPwOperationsmsId id;
	private String opnname;
	private Short state;
	private String remark;
	
	// Constructors

	/** default constructor */
	public ChPwOperationsms() {
	}

	/** minimal constructor */
	public ChPwOperationsms(ChPwOperationsmsId id) {
		this.id = id;
	}

	/** full constructor */
	public ChPwOperationsms(ChPwOperationsmsId id, String opnname, Short state,
			String remark) {
		this.id = id;
		this.opnname = opnname;
		this.state = state;
		this.remark = remark;
	}
	
	// Property accessors

	public ChPwOperationsmsId getId() {
		return this.id;
	}

	public void setId(ChPwOperationsmsId id) {
		this.id = id;
	}

	public String getOpnname() {
		return this.opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
