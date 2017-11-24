package com.sunrise.boss.business.cms.provincialright.persistent;

/**
 * ChAdtProvincialrightId entity.
 * 
 * @author xy
 */

public class ProvincialrightVO implements java.io.Serializable {

	// Fields

	private String proopr;
	private String rightid;

	// Constructors

	/** default constructor */
	public ProvincialrightVO() {
	}

	/** full constructor */
	public ProvincialrightVO(String proopr, String rightid) {
		this.proopr = proopr;
		this.rightid = rightid;
	}

	// Property accessors

	public String getProopr() {
		return this.proopr;
	}

	public void setProopr(String proopr) {
		this.proopr = proopr;
	}

	public String getRightid() {
		return this.rightid;
	}

	public void setRightid(String rightid) {
		this.rightid = rightid;
	}
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProopr() == null ? 0 : this.getProopr().hashCode());
		result = 37 * result
				+ (getRightid() == null ? 0 : this.getRightid().hashCode());
		return result;
	}

}