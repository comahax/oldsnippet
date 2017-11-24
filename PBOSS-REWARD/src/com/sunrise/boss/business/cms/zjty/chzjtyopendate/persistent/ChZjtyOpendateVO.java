package com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChZjtyOpendateVO implements Serializable ,OperationLog{

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date opendate;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ChZjtyOpendateVO(java.lang.String wayid, java.util.Date opendate, java.lang.String memo) {
        this.wayid = wayid;
        this.opendate = opendate;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyOpendateVO() {
    }

    /** minimal constructor */
    public ChZjtyOpendateVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getOpendate() {
        return this.opendate;
    }

    public void setOpendate(java.util.Date opendate) {
        this.opendate = opendate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyOpendateVO) ) return false;
        ChZjtyOpendateVO castOther = (ChZjtyOpendateVO) other;
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
    	// TODO Auto-generated method stub
    	return ChZjtyOpendatelogVO.class;
    }

}
