package com.sunrise.boss.business.cms.postinfo.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class PostinfoVO implements OperationLog {

    /** identifier field */
    private Long postid;

    /** nullable persistent field */
    private String postname;

    /** nullable persistent field */
    private Short postkind;

    /** nullable persistent field */
    private Long parentpost;

    /** nullable persistent field */
    private String way;

    /** nullable persistent field */
    private String waykind;

    /** nullable persistent field */
    private java.sql.Date startime;

    /** nullable persistent field */
    private java.sql.Date overtime;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private Short workkind;

    /** nullable persistent field */
    private String purviewmemo;


    /** full constructor */
    public PostinfoVO(java.lang.Long postid,java.lang.String postname, java.lang.Short postkind, java.lang.Long parentpost, java.lang.String way, java.lang.String waykind, java.sql.Date startime, java.sql.Date overtime, java.lang.Short status, java.lang.Short workkind, java.lang.String purviewmemo) {
        this.postid = postid;
        this.postid = postid;
        this.postname = postname;
        this.postkind = postkind;
        this.parentpost = parentpost;
        this.way = way;
        this.waykind = waykind;
        this.startime = startime;
        this.overtime = overtime;
        this.status = status;
        this.workkind = workkind;
        this.purviewmemo = purviewmemo;
    }

    /** default constructor */
    public PostinfoVO() {
    }

    public java.sql.Date getOvertime() {
		return overtime;
	}

	public void setOvertime(java.sql.Date overtime) {
		this.overtime = overtime;
	}

	public Long getParentpost() {
		return parentpost;
	}

	public void setParentpost(Long parentpost) {
		this.parentpost = parentpost;
	}

	public Long getPostid() {
		return postid;
	}

	public void setPostid(Long postid) {
		this.postid = postid;
	}

	public Short getPostkind() {
		return postkind;
	}

	public void setPostkind(Short postkind) {
		this.postkind = postkind;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getPurviewmemo() {
		return purviewmemo;
	}

	public void setPurviewmemo(String purviewmemo) {
		this.purviewmemo = purviewmemo;
	}

	public java.sql.Date getStartime() {
		return startime;
	}

	public void setStartime(java.sql.Date startime) {
		this.startime = startime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getWaykind() {
		return waykind;
	}

	public void setWaykind(String waykind) {
		this.waykind = waykind;
	}

	public Short getWorkkind() {
		return workkind;
	}

	public void setWorkkind(Short workkind) {
		this.workkind = workkind;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("postid", getPostid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PostinfoVO) ) return false;
        PostinfoVO castOther = (PostinfoVO) other;
        return new EqualsBuilder()
            .append(this.getPostid(), castOther.getPostid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPostid())
            .toHashCode();
    }
    
	public Class logVOClass() {
		return PostinfologVO.class;
	}

}
