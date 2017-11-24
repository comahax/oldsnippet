package com.gmcc.pboss.business.promotion.spproposal;

import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SpproposalVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long pid;

    /** persistent field */
    private String pname;

    /** persistent field */
    private String ptype;

    /** persistent field */
    private java.util.Date pstarttime;

    /** persistent field */
    private java.util.Date pendtime;

    /** nullable persistent field */
    private String pfrtmode;

    /** nullable persistent field */
    private String memo;
    
    private String isDeletable;

	public String getIsDeletable() {
		return isDeletable;
	}

	public void setIsDeletable(String isDeletable) {
		this.isDeletable = isDeletable;
	}

	/** full constructor */
    public SpproposalVO(java.lang.Long pid, java.lang.String pname, java.lang.String ptype, java.util.Date pstarttime, java.util.Date pendtime, java.lang.String pfrtmode, java.lang.String memo) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pstarttime = pstarttime;
        this.pendtime = pendtime;
        this.pfrtmode = pfrtmode;
        this.memo = memo;
    }

    /** default constructor */
    public SpproposalVO() {
    }

    /** minimal constructor */
    public SpproposalVO(java.lang.Long pid, java.lang.String pname, java.lang.String ptype, java.util.Date pstarttime, java.util.Date pendtime) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pstarttime = pstarttime;
        this.pendtime = pendtime;
    }

    public java.lang.Long getPid() {
        return this.pid;
    }

    public void setPid(java.lang.Long pid) {
        this.pid = pid;
    }

    public java.lang.String getPname() {
        return this.pname;
    }

    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }

    public java.lang.String getPtype() {
        return this.ptype;
    }

    public void setPtype(java.lang.String ptype) {
        this.ptype = ptype;
    }

    public java.util.Date getPstarttime() {
        return this.pstarttime;
    }

    public void setPstarttime(java.util.Date pstarttime) {
        this.pstarttime = pstarttime;
    }

    public java.util.Date getPendtime() {
        return this.pendtime;
    }

    public void setPendtime(java.util.Date pendtime) {
        this.pendtime = pendtime;
    }

    public java.lang.String getPfrtmode() {
        return this.pfrtmode;
    }

    public void setPfrtmode(java.lang.String pfrtmode) {
        this.pfrtmode = pfrtmode;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pid", getPid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SpproposalVO) ) return false;
        SpproposalVO castOther = (SpproposalVO) other;
        return new EqualsBuilder()
            .append(this.getPid(), castOther.getPid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return SpproposallogVO.class;
	}

}
