package com.gmcc.pboss.model.constant;

import java.util.Date;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * SaDbDictitem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SaDbDictitem extends CodeReverse implements java.io.Serializable {

	// Fields

	private SaDbDictitemId id;
	private String dictname;
	private Long sortorder;
	private Long status;
	private Date statusdate;
	private String description;

	// Constructors

	/** default constructor */
	public SaDbDictitem() {
	}

	/** minimal constructor */
	public SaDbDictitem(SaDbDictitemId id) {
		this.id = id;
	}

	/** full constructor */
	public SaDbDictitem(SaDbDictitemId id, String dictname, Long sortorder,
			Long status, Date statusdate, String description) {
		this.id = id;
		this.dictname = dictname;
		this.sortorder = sortorder;
		this.status = status;
		this.statusdate = statusdate;
		this.description = description;
	}

	// Property accessors

	public SaDbDictitemId getId() {
		return this.id;
	}

	public void setId(SaDbDictitemId id) {
		this.id = id;
	}

	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public Long getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Long sortorder) {
		this.sortorder = sortorder;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}