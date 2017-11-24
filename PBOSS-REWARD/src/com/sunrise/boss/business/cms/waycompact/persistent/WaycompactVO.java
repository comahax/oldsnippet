package com.sunrise.boss.business.cms.waycompact.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.waycompctlog.persistent.*;
import com.sunrise.boss.business.common.dblog.*;

/** @author Hibernate CodeGenerator */
public class WaycompactVO implements OperationLog {

    /** identifier field */
    private String wayid;

    /** persistent field */
    private String compactno;

    /** persistent field */
    private String compactname;

    /** persistent field */
    private java.sql.Date begintime;

    /** persistent field */
    private java.sql.Date endtime;

    /** persistent field */
    private java.sql.Date signtime;

    /** nullable persistent field */
    private Short coptype;

    /** nullable persistent field */
    private String copbound;

    /** nullable persistent field */
    private String recomrule;

    /** nullable persistent field */
    private String compact;
    
    private String licenceno;
    
    private String compactpath;
    
    private String licencepath;
    
    private Short runareatype;
    
    private String principal;
    
    private Double bail;
    
    private Short bailstatus;
    
    private Short compacttype;
    
    private Short isb2m;
    
    private Short isunpb;
    
    private Short calcumode;
    
    private String uniformtime;
    
    public Short getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Short isunpb) {
		this.isunpb = isunpb;
	}

	public Double getBail() {
		return bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public Short getBailstatus() {
		return bailstatus;
	}

	public void setBailstatus(Short bailstatus) {
		this.bailstatus = bailstatus;
	}

	public String getCompactpath() {
		return compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	public Short getCompacttype() {
		return compacttype;
	}

	public void setCompacttype(Short compacttype) {
		this.compacttype = compacttype;
	}

	public String getLicenceno() {
		return licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	public String getLicencepath() {
		return licencepath;
	}

	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Short getRunareatype() {
		return runareatype;
	}

	public void setRunareatype(Short runareatype) {
		this.runareatype = runareatype;
	}

	/** full constructor */
    public WaycompactVO(java.lang.String wayid, java.lang.String compactno, java.lang.String compactname, java.sql.Date begintime,java.sql.Date endtime, java.sql.Date signtime, java.lang.Short coptype, java.lang.String copbound, java.lang.String recomrule, java.lang.String compact, String licenceno, String compactpath, String licencepath, Short runareatype, String principal, Double bail, Short bailstatus, Short compacttype, Short isb2m, Short isunpb) {
        this.wayid = wayid;
        this.compactno = compactno;
        this.compactname = compactname;
        this.begintime = begintime;
        this.endtime = endtime;
        this.signtime = signtime;
        this.coptype = coptype;
        this.copbound = copbound;
        this.recomrule = recomrule;
        this.compact = compact;
        this.licenceno = licenceno;
        this.licencepath = licencepath;
        this.compactpath = compactpath;
        this.runareatype = runareatype;
        this.principal = principal;
        this.bail = bail;
        this.bailstatus = bailstatus;
        this.compacttype = compacttype;
        this.isb2m = isb2m;
        this.isunpb = isunpb;
    }

    /** default constructor */
    public WaycompactVO() {
    }

    /** minimal constructor */
    public WaycompactVO(java.lang.String wayid, java.lang.String compactno, java.lang.String compactname, java.sql.Date begintime, java.sql.Date endtime, java.sql.Date signtime) {
        this.wayid = wayid;
        this.compactno = compactno;
        this.compactname = compactname;
        this.begintime = begintime;
        this.endtime = endtime;
        this.signtime = signtime;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCompactno() {
        return this.compactno;
    }

    public void setCompactno(java.lang.String compactno) {
        this.compactno = compactno;
    }

    public java.lang.String getCompactname() {
        return this.compactname;
    }

    public void setCompactname(java.lang.String compactname) {
        this.compactname = compactname;
    }

    public java.sql.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.sql.Date begintime) {
		this.begintime = begintime;
	}

	public java.sql.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.sql.Date endtime) {
		this.endtime = endtime;
	}

	public java.sql.Date getSigntime() {
		return signtime;
	}

	public void setSigntime(java.sql.Date signtime) {
		this.signtime = signtime;
	}

	public java.lang.Short getCoptype() {
        return this.coptype;
    }

    public void setCoptype(java.lang.Short coptype) {
        this.coptype = coptype;
    }

    public java.lang.String getCopbound() {
        return this.copbound;
    }

    public void setCopbound(java.lang.String copbound) {
        this.copbound = copbound;
    }

    public java.lang.String getRecomrule() {
        return this.recomrule;
    }

    public void setRecomrule(java.lang.String recomrule) {
        this.recomrule = recomrule;
    }

    public java.lang.String getCompact() {
        return this.compact;
    }

    public void setCompact(java.lang.String compact) {
        this.compact = compact;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaycompactVO) ) return false;
        WaycompactVO castOther = (WaycompactVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return WaycompctlogVO.class;
    }

	public Short getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(Short isb2m) {
		this.isb2m = isb2m;
	}

	public Short getCalcumode() {
		return calcumode;
	}

	public void setCalcumode(Short calcumode) {
		this.calcumode = calcumode;
	}

	public String getUniformtime() {
		return uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}
}
