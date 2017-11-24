package com.gmcc.pboss.model.communi;

/**
 * ChPwAdvaffix entity. @author MyEclipse Persistence Tools
 */

public class ChPwAdvaffix extends com.gmcc.pboss.common.bean.BaseModel
		implements java.io.Serializable {

	// Fields

	private Long affixid;
	private Long advinfoid;
	private String affixname;
	private String affixpath;
	
	/**
	 * 所属公告信息
	 */
//	private ChPwAdvinfo advinfo;

	// Constructors

	/** default constructor */
	public ChPwAdvaffix() {
	}

	/** full constructor */
	public ChPwAdvaffix(Long advinfoid, String affixname, String affixpath) {
		this.advinfoid = advinfoid;
		this.affixname = affixname;
		this.affixpath = affixpath;
	}

	// Property accessors

	public Long getAffixid() {
		return this.affixid;
	}

	public void setAffixid(Long affixid) {
		this.affixid = affixid;
	}

	public Long getAdvinfoid() {
		return this.advinfoid;
	}

	public void setAdvinfoid(Long advinfoid) {
		this.advinfoid = advinfoid;
	}

	public String getAffixname() {
		return this.affixname;
	}

	public void setAffixname(String affixname) {
		this.affixname = affixname;
	}

	public String getAffixpath() {
		return this.affixpath;
	}

	public void setAffixpath(String affixpath) {
		this.affixpath = affixpath;
	}

//	public ChPwAdvinfo getAdvinfo() {
//		return advinfo;
//	}
//
//	public void setAdvinfo(ChPwAdvinfo advinfo) {
//		this.advinfo = advinfo;
//	}

}