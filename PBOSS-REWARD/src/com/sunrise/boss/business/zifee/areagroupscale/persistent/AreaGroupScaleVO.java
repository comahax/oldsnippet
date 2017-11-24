package com.sunrise.boss.business.zifee.areagroupscale.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogVO;

/** @author Hibernate CodeGenerator */
public class AreaGroupScaleVO implements Serializable, OperationLog  {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return AreaGroupScalelogVO.class;
    }
	/** identifier field */
    private String areacode;

    /** identifier field */
    private Long areagroupid;

    /** persistent field */
    private java.util.Date effdate;

    /** persistent field */
    private java.util.Date expdate;

    /** full constructor */
    public AreaGroupScaleVO(java.lang.String areacode, java.lang.Long areagroupid, java.util.Date effdate, java.util.Date expdate) {
        this.areacode = areacode;
        this.areagroupid = areagroupid;
        this.effdate = effdate;
        this.expdate = expdate;
    }

    /** default constructor */
    public AreaGroupScaleVO() {
    }

    public java.lang.String getAreacode() {
        return this.areacode;
    }

    public void setAreacode(java.lang.String areacode) {
        this.areacode = areacode;
    }

    public java.lang.Long getAreagroupid() {
        return this.areagroupid;
    }

    public void setAreagroupid(java.lang.Long areagroupid) {
        this.areagroupid = areagroupid;
    }

    public java.util.Date getEffdate() {
        return this.effdate;
    }

    public void setEffdate(java.util.Date effdate) {
        this.effdate = effdate;
    }

    public java.util.Date getExpdate() {
        return this.expdate;
    }

    public void setExpdate(java.util.Date expdate) {
        this.expdate = expdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("areacode", getAreacode())
            .append("areagroupid", getAreagroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AreaGroupScaleVO) ) return false;
        AreaGroupScaleVO castOther = (AreaGroupScaleVO) other;
        return new EqualsBuilder()
            .append(this.getAreacode(), castOther.getAreacode())
            .append(this.getAreagroupid(), castOther.getAreagroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAreacode())
            .append(getAreagroupid())
            .toHashCode();
    }

}
