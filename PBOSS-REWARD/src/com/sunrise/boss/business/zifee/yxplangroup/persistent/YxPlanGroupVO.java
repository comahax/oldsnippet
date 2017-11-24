package com.sunrise.boss.business.zifee.yxplangroup.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogVO;

/** @author Hibernate CodeGenerator */
public class YxPlanGroupVO implements Serializable,OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return YxPlanGrouplogVO.class;
    }
	
	/** identifier field */
    private Long memyxplan;

    /** nullable persistent field */
    private Long groupyxplan;

    /** full constructor */
    public YxPlanGroupVO(java.lang.Long memyxplan, java.lang.Long groupyxplan) {
        this.memyxplan = memyxplan;
        this.groupyxplan = groupyxplan;
    }

    /** default constructor */
    public YxPlanGroupVO() {
    }

    public Long getGroupyxplan() {
		return groupyxplan;
	}

	public void setGroupyxplan(Long groupyxplan) {
		this.groupyxplan = groupyxplan;
	}

	public Long getMemyxplan() {
		return memyxplan;
	}

	public void setMemyxplan(Long memyxplan) {
		this.memyxplan = memyxplan;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("groupyxplan", getGroupyxplan())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanGroupVO) ) return false;
        YxPlanGroupVO castOther = (YxPlanGroupVO) other;
        return new EqualsBuilder()
            .append(this.getGroupyxplan(), castOther.getGroupyxplan())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupyxplan())
            .toHashCode();
    }

}
