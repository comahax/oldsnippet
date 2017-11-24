package com.gmcc.pboss.menu.model;

import java.util.Date;

import com.gmcc.pboss.common.bean.BaseModel;

/**
 * SaDbWebfunctionitem entity. @author MyEclipse Persistence Tools
 */
public class SaDbWebfunctionitem extends BaseModel implements java.io.Serializable {

	// Fields
	private String funcid;
	private String funcname;
	private String parentid;
	private String guiobject;
	private String tiptext;
	private Short sortorder;
	private Date createdate;
	private Boolean status;
	private Date statusdate;
	private Short type;

	// Constructors

	/** default constructor */
	public SaDbWebfunctionitem() {
	}

	/** minimal constructor */
	public SaDbWebfunctionitem(String funcid) {
		this.funcid = funcid;
	}

	/** full constructor */
	public SaDbWebfunctionitem(String funcid, String funcname, String parentid,
			String guiobject, String tiptext, Short sortorder, Date createdate,
			Boolean status, Date statusdate, Short type) {
		this.funcid = funcid;
		this.funcname = funcname;
		this.parentid = parentid;
		this.guiobject = guiobject;
		this.tiptext = tiptext;
		this.sortorder = sortorder;
		this.createdate = createdate;
		this.status = status;
		this.statusdate = statusdate;
		this.type = type;
	}
	// Property accessors

	public String getFuncid() {
		return this.funcid;
	}

	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}

	public String getFuncname() {
		return this.funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getGuiobject() {
		return this.guiobject;
	}

	public void setGuiobject(String guiobject) {
		this.guiobject = guiobject;
	}

	public String getTiptext() {
		return this.tiptext;
	}

	public void setTiptext(String tiptext) {
		this.tiptext = tiptext;
	}

	public Short getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}
	
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}
