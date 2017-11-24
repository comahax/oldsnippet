package net.gmcc.pboss.domain.model.dictitem;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DictitemVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "SA_DB_DICTITEM")
public class DictitemVO implements java.io.Serializable {

	// Fields

	private DictitemVOId id;
	private String dictname;
	private Short sortorder;
	private Boolean status;
	private Date statusdate;
	private String description;

	// Constructors

	/** default constructor */
	public DictitemVO() {
	}

	/** minimal constructor */
	public DictitemVO(DictitemVOId id) {
		this.id = id;
	}

	/** full constructor */
	public DictitemVO(DictitemVOId id, String dictname, Short sortorder,
			Boolean status, Date statusdate, String description) {
		this.id = id;
		this.dictname = dictname;
		this.sortorder = sortorder;
		this.status = status;
		this.statusdate = statusdate;
		this.description = description;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "dictid", column = @Column(name = "DICTID", nullable = false, length = 32)),
			@AttributeOverride(name = "groupid", column = @Column(name = "GROUPID", nullable = false, length = 32)) })
	public DictitemVOId getId() {
		return this.id;
	}

	public void setId(DictitemVOId id) {
		this.id = id;
	}

	@Column(name = "DICTNAME", length = 64)
	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	@Column(name = "SORTORDER", precision = 3, scale = 0)
	public Short getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}

	@Column(name = "STATUS", precision = 1, scale = 0)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STATUSDATE", length = 7)
	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	@Column(name = "DESCRIPTION", length = 128)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}