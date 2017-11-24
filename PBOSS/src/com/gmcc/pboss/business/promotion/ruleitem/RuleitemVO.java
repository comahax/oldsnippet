package com.gmcc.pboss.business.promotion.ruleitem;

import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleitemVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private Long itemid;

	/** persistent field */
	private Long ruleid;

	/** persistent field */
	private String optexpression;

	/** persistent field */
	private String datatype;

	/** nullable persistent field */
	private String filtermode;

	/** nullable persistent field */
	private String matching;

	/** nullable persistent field */
	private String columnsinfo;

	/** full constructor */
	public RuleitemVO(java.lang.Long itemid, java.lang.Long ruleid,
			java.lang.String optexpression, java.lang.String datatype,
			java.lang.String filtermode, java.lang.String matching,
			java.lang.String columnsinfo) {
		this.itemid = itemid;
		this.ruleid = ruleid;
		this.optexpression = optexpression;
		this.datatype = datatype;
		this.filtermode = filtermode;
		this.matching = matching;
		this.columnsinfo = columnsinfo;
	}

	/** default constructor */
	public RuleitemVO() {
	}

	/** minimal constructor */
	public RuleitemVO(java.lang.Long itemid, java.lang.Long ruleid,
			java.lang.String optexpression, java.lang.String datatype) {
		this.itemid = itemid;
		this.ruleid = ruleid;
		this.optexpression = optexpression;
		this.datatype = datatype;
	}

	public java.lang.Long getItemid() {
		return this.itemid;
	}

	public void setItemid(java.lang.Long itemid) {
		this.itemid = itemid;
	}

	public java.lang.Long getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.Long ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getOptexpression() {
		return this.optexpression;
	}

	public void setOptexpression(java.lang.String optexpression) {
		this.optexpression = optexpression;
	}

	public java.lang.String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(java.lang.String datatype) {
		this.datatype = datatype;
	}

	public java.lang.String getFiltermode() {
		return this.filtermode;
	}

	public void setFiltermode(java.lang.String filtermode) {
		this.filtermode = filtermode;
	}

	public java.lang.String getMatching() {
		return this.matching;
	}

	public void setMatching(java.lang.String matching) {
		this.matching = matching;
	}

	public java.lang.String getColumnsinfo() {
		return this.columnsinfo;
	}

	public void setColumnsinfo(java.lang.String columnsinfo) {
		this.columnsinfo = columnsinfo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("itemid", getItemid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof RuleitemVO))
			return false;
		RuleitemVO castOther = (RuleitemVO) other;
		return new EqualsBuilder().append(this.getItemid(),
				castOther.getItemid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getItemid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RuleitemlogVO.class;
	}

}
