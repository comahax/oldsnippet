package com.sunrise.boss.business.cms.chadtdictidname.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtDictidnameVO implements Serializable {

    /** identifier field */
    private String dictid;

    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String dictname;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    private String dictitemname;
    
    //dictitem  table

    /** nullable persistent field */
    private String description;
    
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


   

	public ChAdtDictidnameVO(String dictid, String groupid, String dictname,
			Date optime, String oprcode, String dictitemname, String description) {
		super();
		this.dictid = dictid;
		this.groupid = groupid;
		this.dictname = dictname;
		this.optime = optime;
		this.oprcode = oprcode;
		this.dictitemname = dictitemname;
		this.description = description;
	}

	/** default constructor */
    public ChAdtDictidnameVO() {
    }

    /** minimal constructor */
    public ChAdtDictidnameVO(java.lang.String dictid, java.lang.String groupid) {
        this.dictid = dictid;
        this.groupid = groupid;
    }

    public java.lang.String getDictid() {
        return this.dictid;
    }

    public void setDictid(java.lang.String dictid) {
        this.dictid = dictid;
    }

    public java.lang.String getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.String groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getDictname() {
        return this.dictname;
    }

    public void setDictname(java.lang.String dictname) {
        this.dictname = dictname;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("dictid", getDictid())
            .append("groupid", getGroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtDictidnameVO) ) return false;
        ChAdtDictidnameVO castOther = (ChAdtDictidnameVO) other;
        return new EqualsBuilder()
            .append(this.getDictid(), castOther.getDictid())
            .append(this.getGroupid(), castOther.getGroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDictid())
            .append(getGroupid())
            .toHashCode();
    }

	public String getDictitemname() {
		return dictitemname;
	}

	public void setDictitemname(String dictitemname) {
		this.dictitemname = dictitemname;
	}

}
