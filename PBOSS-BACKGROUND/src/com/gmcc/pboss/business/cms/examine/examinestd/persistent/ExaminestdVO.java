package com.gmcc.pboss.business.cms.examine.examinestd.persistent;


import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;



/** @author Hibernate CodeGenerator */
public class ExaminestdVO  extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long exmnstdid;

    /** nullable persistent field */
    private String exmnstdname;

    /** nullable persistent field */
    private String markmode;

    /** nullable persistent field */
    private String syslogic;

    /** full constructor */
    public ExaminestdVO(java.lang.Long exmnstdid, java.lang.String exmnstdname, java.lang.String markmode, java.lang.String syslogic) {
        this.exmnstdid = exmnstdid;
        this.exmnstdname = exmnstdname;
        this.markmode = markmode;
        this.syslogic = syslogic;
    }

    /** default constructor */
    public ExaminestdVO() {
    }

    /** minimal constructor */
    public ExaminestdVO(java.lang.Long exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.Long getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Long exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getExmnstdname() {
        return this.exmnstdname;
    }

    public void setExmnstdname(java.lang.String exmnstdname) {
        this.exmnstdname = exmnstdname;
    }

    public java.lang.String getMarkmode() {
        return this.markmode;
    }

    public void setMarkmode(java.lang.String markmode) {
        this.markmode = markmode;
    }

    public java.lang.String getSyslogic() {
        return this.syslogic;
    }

    public void setSyslogic(java.lang.String syslogic) {
        this.syslogic = syslogic;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnstdid", getExmnstdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExaminestdVO) ) return false;
        ExaminestdVO castOther = (ExaminestdVO) other;
        return new EqualsBuilder()
            .append(this.getExmnstdid(), castOther.getExmnstdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnstdid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ExaminestdlogVO.class;
	}

}
