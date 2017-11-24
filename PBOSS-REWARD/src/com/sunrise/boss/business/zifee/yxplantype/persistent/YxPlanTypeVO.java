package com.sunrise.boss.business.zifee.yxplantype.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogVO;

/** @author Hibernate CodeGenerator */
public class YxPlanTypeVO implements Serializable,OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return YxPlanTypelogVO.class;
    }
	/** identifier field */
    private Long yxplankindid;

    /** identifier field */
    private Long yxplantypeid;

    /** persistent field */
    private String yxplantypename;

    /** full constructor */
    public YxPlanTypeVO(java.lang.Long yxplankindid, java.lang.Long yxplantypeid, java.lang.String yxplantypename) {
        this.yxplankindid = yxplankindid;
        this.yxplantypeid = yxplantypeid;
        this.yxplantypename = yxplantypename;
    }

    /** default constructor */
    public YxPlanTypeVO() {
    }

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.Long getYxplantypeid() {
        return this.yxplantypeid;
    }

    public void setYxplantypeid(java.lang.Long yxplantypeid) {
        this.yxplantypeid = yxplantypeid;
    }

    public java.lang.String getYxplantypename() {
        return this.yxplantypename;
    }

    public void setYxplantypename(java.lang.String yxplantypename) {
        this.yxplantypename = yxplantypename;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("yxplankindid", getYxplankindid())
            .append("yxplantypeid", getYxplantypeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanTypeVO) ) return false;
        YxPlanTypeVO castOther = (YxPlanTypeVO) other;
        return new EqualsBuilder()
            .append(this.getYxplankindid(), castOther.getYxplankindid())
            .append(this.getYxplantypeid(), castOther.getYxplantypeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getYxplankindid())
            .append(getYxplantypeid())
            .toHashCode();
    }

}
