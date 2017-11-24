package com.gmcc.pboss.model.sales;

import java.io.Serializable;

import com.gmcc.pboss.common.bean.CodeReverse;

public class FxSwOrdertimes extends CodeReverse implements Serializable {

	// Fields

	private Long recid;
	private String objtype;
	private String objectcode;
	private Short maxtimes;
	
	// Constructors

	/** default constructor */
	public FxSwOrdertimes() {
	}

	/** full constructor */
	public FxSwOrdertimes(Long recid, String objtype,
			String objectcode, Short maxtimes) {
		this.recid = recid;
		this.objtype = objtype;
		this.objectcode = objectcode;
		this.maxtimes = maxtimes;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getObjtype() {
		return this.objtype;
	}

	public void setObjtype(String objtype) {
		this.objtype = objtype;
	}

	public String getObjectcode() {
		return this.objectcode;
	}

	public void setObjectcode(String objectcode) {
		this.objectcode = objectcode;
	}

	public Short getMaxtimes() {
		return this.maxtimes;
	}

	public void setMaxtimes(Short maxtimes) {
		this.maxtimes = maxtimes;
	}

}
