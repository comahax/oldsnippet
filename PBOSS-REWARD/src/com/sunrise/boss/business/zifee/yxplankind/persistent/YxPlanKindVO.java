package com.sunrise.boss.business.zifee.yxplankind.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogVO;

/** @author Hibernate CodeGenerator */
public class YxPlanKindVO implements Serializable,OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return YxPlanKindlogVO.class;
    }
	/** identifier field */
    private Long yxplankindid;

    /** nullable persistent field */
    private String yxplankindname;

    /** full constructor */
    public YxPlanKindVO(java.lang.String yxplankindname) {
        this.yxplankindname = yxplankindname;
    }

    /** default constructor */
    public YxPlanKindVO() {
    }

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.String getYxplankindname() {
        return this.yxplankindname;
    }

    public void setYxplankindname(java.lang.String yxplankindname) {
        this.yxplankindname = yxplankindname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("yxplankindid", getYxplankindid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanKindVO) ) return false;
        YxPlanKindVO castOther = (YxPlanKindVO) other;
        return new EqualsBuilder()
            .append(this.getYxplankindid(), castOther.getYxplankindid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getYxplankindid())
            .toHashCode();
    }

}
