package com.gmcc.pboss.model.sales;

/**
 * FxRuOrderproce entity. @author MyEclipse Persistence Tools
 */

public class FxRuOrderproce extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long recid;
	private Long flowid;
	private Long processid;
	private String dismode;
	private String instate;
	private String outstate;

	// Constructors

	/** default constructor */
	public FxRuOrderproce() {
	}

	/** minimal constructor */
	public FxRuOrderproce(Long flowid, Long processid, String dismode) {
		this.flowid = flowid;
		this.processid = processid;
		this.dismode = dismode;
	}

	/** full constructor */
	public FxRuOrderproce(Long flowid, Long processid, String dismode,
			String instate, String outstate) {
		this.flowid = flowid;
		this.processid = processid;
		this.dismode = dismode;
		this.instate = instate;
		this.outstate = outstate;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Long getFlowid() {
		return this.flowid;
	}

	public void setFlowid(Long flowid) {
		this.flowid = flowid;
	}

	public Long getProcessid() {
		return this.processid;
	}

	public void setProcessid(Long processid) {
		this.processid = processid;
	}

	public String getDismode() {
		return this.dismode;
	}

	public void setDismode(String dismode) {
		this.dismode = dismode;
	}

	public String getInstate() {
		return this.instate;
	}

	public void setInstate(String instate) {
		this.instate = instate;
	}

	public String getOutstate() {
		return this.outstate;
	}

	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}

}