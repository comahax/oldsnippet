package com.gmcc.pboss.model.reward.rewardlocal;

/**
 * ChPwRewardlocaltitleId entity. @author MyEclipse Persistence Tools
 */

public class ChPwRewardlocaltitleId extends
		com.gmcc.pboss.common.bean.CodeReverse implements java.io.Serializable {

	// Fields

	private String rewardmonth;
	private String rpttype;
	private Integer seq;

	// Constructors

	/** default constructor */
	public ChPwRewardlocaltitleId() {
	}

	/** full constructor */
	public ChPwRewardlocaltitleId(String rewardmonth, String rpttype,
			Integer seq) {
		this.rewardmonth = rewardmonth;
		this.rpttype = rpttype;
		this.seq = seq;
	}

	// Property accessors

	public String getRewardmonth() {
		return this.rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getRpttype() {
		return this.rpttype;
	}

	public void setRpttype(String rpttype) {
		this.rpttype = rpttype;
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
		if (!(other instanceof ChPwRewardlocaltitleId))
			return false;
		ChPwRewardlocaltitleId castOther = (ChPwRewardlocaltitleId) other;

		return ((this.getRewardmonth() == castOther.getRewardmonth()) || (this
				.getRewardmonth() != null
				&& castOther.getRewardmonth() != null && this.getRewardmonth()
				.equals(castOther.getRewardmonth())))
				&& ((this.getRpttype() == castOther.getRpttype()) || (this
						.getRpttype() != null
						&& castOther.getRpttype() != null && this.getRpttype()
						.equals(castOther.getRpttype())))
				&& ((this.getSeq() == castOther.getSeq()) || (this.getSeq() != null
						&& castOther.getSeq() != null && this.getSeq().equals(
						castOther.getSeq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getRewardmonth() == null ? 0 : this.getRewardmonth()
						.hashCode());
		result = 37 * result
				+ (getRpttype() == null ? 0 : this.getRpttype().hashCode());
		result = 37 * result
				+ (getSeq() == null ? 0 : this.getSeq().hashCode());
		return result;
	}

}