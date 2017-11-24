package com.gmcc.pboss.model.reward.rewardlocal;

/**
 * ChPwRewardlocaltitle entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocaltitle extends
		com.gmcc.pboss.common.bean.CodeReverse implements java.io.Serializable {

	// Fields

	private ChPwRewardlocaltitleId id;
	private Integer titleno;
	private Integer subno;
	private String titlename;
	private String subtitlename;

	// Constructors

	/** default constructor */
	public ChPwRewardlocaltitle() {
	}

	/** minimal constructor */
	public ChPwRewardlocaltitle(ChPwRewardlocaltitleId id) {
		this.id = id;
	}

	/** full constructor */
	public ChPwRewardlocaltitle(ChPwRewardlocaltitleId id, Integer titleno,
			Integer subno, String titlename, String subtitlename) {
		this.id = id;
		this.titleno = titleno;
		this.subno = subno;
		this.titlename = titlename;
		this.subtitlename = subtitlename;
	}

	// Property accessors

	public ChPwRewardlocaltitleId getId() {
		return this.id;
	}

	public void setId(ChPwRewardlocaltitleId id) {
		this.id = id;
	}

	public Integer getTitleno() {
		return this.titleno;
	}

	public void setTitleno(Integer titleno) {
		this.titleno = titleno;
	}

	public Integer getSubno() {
		return this.subno;
	}

	public void setSubno(Integer subno) {
		this.subno = subno;
	}

	public String getTitlename() {
		return this.titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public String getSubtitlename() {
		return this.subtitlename;
	}

	public void setSubtitlename(String subtitlename) {
		this.subtitlename = subtitlename;
	}

}