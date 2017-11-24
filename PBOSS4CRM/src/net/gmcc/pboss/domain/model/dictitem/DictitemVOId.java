package net.gmcc.pboss.domain.model.dictitem;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DictitemVOId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DictitemVOId implements java.io.Serializable {

	// Fields

	private String dictid;
	private String groupid;

	// Constructors

	/** default constructor */
	public DictitemVOId() {
	}

	/** full constructor */
	public DictitemVOId(String dictid, String groupid) {
		this.dictid = dictid;
		this.groupid = groupid;
	}

	// Property accessors

	@Column(name = "DICTID", nullable = false, length = 32)
	public String getDictid() {
		return this.dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	@Column(name = "GROUPID", nullable = false, length = 32)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DictitemVOId))
			return false;
		DictitemVOId castOther = (DictitemVOId) other;

		return ((this.getDictid() == castOther.getDictid()) || (this
				.getDictid() != null
				&& castOther.getDictid() != null && this.getDictid().equals(
				castOther.getDictid())))
				&& ((this.getGroupid() == castOther.getGroupid()) || (this
						.getGroupid() != null
						&& castOther.getGroupid() != null && this.getGroupid()
						.equals(castOther.getGroupid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDictid() == null ? 0 : this.getDictid().hashCode());
		result = 37 * result
				+ (getGroupid() == null ? 0 : this.getGroupid().hashCode());
		return result;
	}

}