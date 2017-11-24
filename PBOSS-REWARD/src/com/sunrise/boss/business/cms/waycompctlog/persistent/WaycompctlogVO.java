package com.sunrise.boss.business.cms.waycompctlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaycompctlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String compactno;

    /** nullable persistent field */
    private String compactname;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private java.util.Date signtime;

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

    /** full constructor */
    public WaycompctlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.String compactno, java.lang.String compactname, java.util.Date begintime, java.util.Date endtime, java.util.Date signtime, java.lang.Short coptype, java.lang.String copbound, java.lang.String recomrule, java.lang.String compact, String licenceno, String compactpath, String licencepath, Short runareatype, String principal, Double bail, Short bailstatus, Short compacttype, Short isb2m) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
    }

    /** default constructor */
    public WaycompctlogVO() {
    }

    /** minimal constructor */
    public WaycompctlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.util.Date getSigntime() {
        return this.signtime;
    }

    public void setSigntime(java.util.Date signtime) {
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaycompctlogVO) ) return false;
        WaycompctlogVO castOther = (WaycompctlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
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

	public Short getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(Short isb2m) {
		this.isb2m = isb2m;
	}

}
