package com.gmcc.pboss.model.reward.rewardlocal;

/**
 * ChPwRewardlocalvalueId entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocalvalueId extends
		com.gmcc.pboss.common.bean.CodeReverse implements java.io.Serializable {

	// Fields

	private Long mstid;
	private Integer seq;

	// Constructors

	/** default constructor */
	public ChPwRewardlocalvalueId() {
	}

	/** full constructor */
	public ChPwRewardlocalvalueId(Long mstid, Integer seq) {
		this.mstid = mstid;
		this.seq = seq;
	}

	// Property accessors

	public Long getMstid() {
		return this.mstid;
	}

	public void setMstid(Long mstid) {
		this.mstid = mstid;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChPwRewardlocalvalueId))
			return false;
		ChPwRewardlocalvalueId castOther = (ChPwRewardlocalvalueId) other;

		return ((this.getMstid() == castOther.getMstid()) || (this.getMstid() != null
				&& castOther.getMstid() != null && this.getMstid().equals(
				castOther.getMstid())))
				&& ((this.getSeq() == castOther.getSeq()) || (this.getSeq() != null
						&& castOther.getSeq() != null && this.getSeq().equals(
						castOther.getSeq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMstid() == null ? 0 : this.getMstid().hashCode());
		result = 37 * result
				+ (getSeq() == null ? 0 : this.getSeq().hashCode());
		return result;
	}

}