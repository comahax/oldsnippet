package com.sunrise.boss.business.zifee.yxplansplitscale.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogVO;
/** @author Hibernate CodeGenerator */
public class YxPlanSplitScaleVO implements Serializable ,OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return YxPlanSplitScalelogVO.class;
    }
	/** identifier field */
    private Long yxplanid;

    /** identifier field */
    private String yxplanitemid;

    /** identifier field */
    private Long yxplankindid;

    /** identifier field */
    private Long yxplantypeid;

    /** persistent field */
    private Float scale;

    /** full constructor */
    public YxPlanSplitScaleVO(java.lang.Long yxplanid, java.lang.String yxplanitemid, java.lang.Long yxplankindid, java.lang.Long yxplantypeid, java.lang.Float scale) {
        this.yxplanid = yxplanid;
        this.yxplanitemid = yxplanitemid;
        this.yxplankindid = yxplankindid;
        this.yxplantypeid = yxplantypeid;
        this.scale = scale;
    }

    /** default constructor */
    public YxPlanSplitScaleVO() {
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.String getYxplanitemid() {
        return this.yxplanitemid;
    }

    public void setYxplanitemid(java.lang.String yxplanitemid) {
        this.yxplanitemid = yxplanitemid;
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

    public java.lang.Float getScale() {
        return this.scale;
    }

    public void setScale(java.lang.Float scale) {
        this.scale = scale;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("yxplanid", getYxplanid())
            .append("yxplanitemid", getYxplanitemid())
            .append("yxplankindid", getYxplankindid())
            .append("yxplantypeid", getYxplantypeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanSplitScaleVO) ) return false;
        YxPlanSplitScaleVO castOther = (YxPlanSplitScaleVO) other;
        return new EqualsBuilder()
            .append(this.getYxplanid(), castOther.getYxplanid())
            .append(this.getYxplanitemid(), castOther.getYxplanitemid())
            .append(this.getYxplankindid(), castOther.getYxplankindid())
            .append(this.getYxplantypeid(), castOther.getYxplantypeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getYxplanid())
            .append(getYxplanitemid())
            .append(getYxplankindid())
            .append(getYxplantypeid())
            .toHashCode();
    }

}
