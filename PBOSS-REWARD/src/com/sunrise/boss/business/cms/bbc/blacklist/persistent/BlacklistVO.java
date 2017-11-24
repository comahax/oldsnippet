package com.sunrise.boss.business.cms.bbc.blacklist.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BlacklistVO implements OperationLog {

    /** identifier field */
    private String mobile;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String filtertype;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** full constructor */
    public BlacklistVO(java.lang.String mobile, java.lang.String name, java.lang.String filtertype, java.util.Date starttime, java.util.Date endtime) {
        this.mobile = mobile;
        this.name = name;
        this.filtertype = filtertype;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    /** default constructor */
    public BlacklistVO() {
    }

    /** minimal constructor */
    public BlacklistVO(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getFiltertype() {
        return this.filtertype;
    }

    public void setFiltertype(java.lang.String filtertype) {
        this.filtertype = filtertype;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mobile", getMobile())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BlacklistVO) ) return false;
        BlacklistVO castOther = (BlacklistVO) other;
        return new EqualsBuilder()
            .append(this.getMobile(), castOther.getMobile())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMobile())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BlacklistlogVO.class;
	}

}
