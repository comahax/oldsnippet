package com.sunrise.boss.business.zifee.areagroupinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologVO;

/** @author Hibernate CodeGenerator */
public class AreaGroupInfoVO implements Serializable, OperationLog  {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return AreaGroupInfologVO.class;
    }
	
	/** identifier field */
    private Long areagroupid;

    /** nullable persistent field */
    private String remark;
    
    private String areatype;
    
    private Byte state;

    /** full constructor */
    public AreaGroupInfoVO(java.lang.String remark) {
        this.remark = remark;
    }

    /** default constructor */
    public AreaGroupInfoVO() {
    }

    public java.lang.Long getAreagroupid() {
        return this.areagroupid;
    }

    public void setAreagroupid(java.lang.Long areagroupid) {
        this.areagroupid = areagroupid;
    }
    
    public java.lang.Byte getState(){
    	return this.state;
    }
    
    public void setState(java.lang.Byte state){
    	this.state = state;
    }
    
    public java.lang.String getAreatype(){
    	return this.areatype;
    }
    
    public void setAreatype(java.lang.String areatype){
    	this.areatype = areatype;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("areagroupid", getAreagroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AreaGroupInfoVO) ) return false;
        AreaGroupInfoVO castOther = (AreaGroupInfoVO) other;
        return new EqualsBuilder()
            .append(this.getAreagroupid(), castOther.getAreagroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAreagroupid())
            .toHashCode();
    }

}
