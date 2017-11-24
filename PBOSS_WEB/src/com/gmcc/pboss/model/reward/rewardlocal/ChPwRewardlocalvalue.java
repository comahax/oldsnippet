package com.gmcc.pboss.model.reward.rewardlocal;

/**
 * ChPwRewardlocalvalue entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocalvalue extends
		com.gmcc.pboss.common.bean.CodeReverse implements java.io.Serializable {

	// Fields

	private ChPwRewardlocalvalueId id;
	private String content;
	private String type;

	// Constructors

	/** default constructor */
	public ChPwRewardlocalvalue() {
	}

	/** minimal constructor */
	public ChPwRewardlocalvalue(ChPwRewardlocalvalueId id) {
		this.id = id;
	}

	/** full constructor */
	public ChPwRewardlocalvalue(ChPwRewardlocalvalueId id, String content) {
		this.id = id;
		this.content = content;
	}

	// Property accessors

	public ChPwRewardlocalvalueId getId() {
		return this.id;
	}

	public void setId(ChPwRewardlocalvalueId id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}