package com.gmcc.pboss.business.channel.checkedapplydetail;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CheckedapplydetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Long applyno;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date aptime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String applytype;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String chktype;

    /** nullable persistent field */
    private String chgtype;
    
    
    private String wtype; 
    
	private String address;
	
	private String wayname;
	
	private Short buztypecode;
	
	private Long starlevel;
	
    private String chainhead;
   
    private Short waystatus;
    private Short isflag;
    private java.util.Date oprtime;
    
	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	/** full constructor */
    public CheckedapplydetailVO(java.lang.Long seq, java.lang.Long applyno, java.lang.String cityid, java.util.Date aptime, java.lang.String oprcode, java.lang.String applytype, java.lang.String wayid, java.lang.String chktype, java.lang.String chgtype,java.lang.String wtype) {
        this.seq = seq;
        this.applyno = applyno;
        this.cityid = cityid;
        this.aptime = aptime;
        this.oprcode = oprcode;
        this.applytype = applytype;
        this.wayid = wayid;
        this.chktype = chktype;
        this.chgtype = chgtype;
        this.wtype = wtype;
    }

    /** default constructor */
    public CheckedapplydetailVO() {
    }

    /** minimal constructor */
    public CheckedapplydetailVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getApplyno() {
        return this.applyno;
    }

    public void setApplyno(java.lang.Long applyno) {
        this.applyno = applyno;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.util.Date getAptime() {
        return this.aptime;
    }

    public void setAptime(java.util.Date aptime) {
        this.aptime = aptime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getApplytype() {
        return this.applytype;
    }

    public void setApplytype(java.lang.String applytype) {
        this.applytype = applytype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getChktype() {
        return this.chktype;
    }

    public void setChktype(java.lang.String chktype) {
        this.chktype = chktype;
    }

    public java.lang.String getChgtype() {
        return this.chgtype;
    }

    public void setChgtype(java.lang.String chgtype) {
        this.chgtype = chgtype;
    }
   
    public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CheckedapplydetailVO) ) return false;
        CheckedapplydetailVO castOther = (CheckedapplydetailVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Short getBuztypecode() {
		return buztypecode;
	}

	public void setBuztypecode(Short buztypecode) {
		this.buztypecode = buztypecode;
	}

	public Long getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public Short getWaystatus() {
		return waystatus;
	}

	public void setWaystatus(Short waystatus) {
		this.waystatus = waystatus;
	}

	public Short getIsflag() {
		return isflag;
	}

	public void setIsflag(Short isflag) {
		this.isflag = isflag;
	}

}
