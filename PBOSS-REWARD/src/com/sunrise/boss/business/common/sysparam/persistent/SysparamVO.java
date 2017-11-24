package com.sunrise.boss.business.common.sysparam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.pub.tools.PublicUtils;

/** @author Hibernate CodeGenerator */
public class SysparamVO implements Serializable {

    /** identifier field */
    private Long systemid;

    /** persistent field */
    private String paramtype;

    /** persistent field */
    private java.util.Date begintime;

    /** persistent field */
    private java.util.Date endtime;

    /** persistent field */
    private String paramname;

    /** persistent field */
    private String paramvalue;

    /** nullable persistent field */
    private String memo;    
    /** full constructor */
    public SysparamVO(java.lang.Long systemid, java.lang.String paramtype, java.util.Date begintime, java.util.Date endtime, 
    				  java.lang.String paramname, java.lang.String paramvalue, java.lang.String memo) {
        this.systemid = systemid;
        this.paramtype = paramtype;
        this.begintime = begintime;
        this.endtime = endtime;
        this.paramname = paramname;
        this.paramvalue = paramvalue;
        this.memo = memo;        
    }

    /** default constructor */
    public SysparamVO() {
    }

    public java.lang.Long getSystemid() {
        return this.systemid;
    }

    public void setSystemid(java.lang.Long systemid) {
        this.systemid = systemid;
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

    public java.lang.String getParamname() {
        return this.paramname;
    }

    public void setParamname(java.lang.String paramname) {
        this.paramname = paramname;
    }

    public java.lang.String getParamvalue() {
        return this.paramvalue;
    }

    public void setParamvalue(java.lang.String paramvalue) {
        this.paramvalue = paramvalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("systemid", getSystemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SysparamVO) ) return false;
        SysparamVO castOther = (SysparamVO) other;
        return new EqualsBuilder()
            .append(this.getSystemid(), castOther.getSystemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSystemid())
            .toHashCode();
    }
	private String strBegintime;
	private String strEndtime;

	public String getStrBegintime() {
		return PublicUtils.utilDateToStr(begintime);
	}

	public void setStrBegintime(String strBegintime) throws Exception {
		this.begintime = PublicUtils.UtilStrToDate(strBegintime);
	}
	public String getStrEndtime() {
		return PublicUtils.utilDateToStr(endtime);
	}

	public void setStrEndtime(String strEndtime) throws Exception {
		this.endtime = PublicUtils.UtilStrToDate(strEndtime);
	}

	public String getParamtype() {
		return paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
