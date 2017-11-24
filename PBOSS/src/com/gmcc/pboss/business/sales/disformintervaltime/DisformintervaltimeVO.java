package com.gmcc.pboss.business.sales.disformintervaltime;

import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisformintervaltimeVO extends BaseVO  implements BusinessLog  {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private Long intervaltime;

    /** full constructor */
    public DisformintervaltimeVO(java.lang.Long recid, java.lang.String countyid, java.lang.String mareacode, java.lang.Short starlevel, java.lang.Long intervaltime) {
        this.recid = recid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
        this.intervaltime = intervaltime;
    }

    /** default constructor */
    public DisformintervaltimeVO() {
    }

    /** minimal constructor */
    public DisformintervaltimeVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.Long getIntervaltime() {
        return this.intervaltime;
    }

    public void setIntervaltime(java.lang.Long intervaltime) {
        this.intervaltime = intervaltime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisformintervaltimeVO) ) return false;
        DisformintervaltimeVO castOther = (DisformintervaltimeVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return DisformintervaltimelogVO.class;
    }

}
