package com.sunrise.boss.business.zifee.yxplangpinf.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplangplog.persistent.YxplangplogVO;

/** @author Hibernate CodeGenerator */
public class YxplangpinfVO implements Serializable,OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() { 
    	return YxplangplogVO.class;
    }
	/** identifier field */
    private Long groupid;

    /** nullable persistent field */
    private String groupname;

    /** nullable persistent field */
    private String areacode;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public YxplangpinfVO(java.lang.Long groupid, java.lang.String groupname, java.lang.String areacode, java.lang.String remark) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.areacode = areacode;
        this.remark = remark;
    }

    /** default constructor */
    public YxplangpinfVO() {
    }

    /** minimal constructor */
    public YxplangpinfVO(java.lang.Long groupid) {
        this.groupid = groupid;
    }

    public java.lang.Long getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Long groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getGroupname() {
        return this.groupname;
    }

    public void setGroupname(java.lang.String groupname) {
        this.groupname = groupname;
    }

    public java.lang.String getAreacode() {
        return this.areacode;
    }

    public void setAreacode(java.lang.String areacode) {
        this.areacode = areacode;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupid", getGroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxplangpinfVO) ) return false;
        YxplangpinfVO castOther = (YxplangpinfVO) other;
        return new EqualsBuilder()
            .append(this.getGroupid(), castOther.getGroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupid())
            .toHashCode();
    }

}
