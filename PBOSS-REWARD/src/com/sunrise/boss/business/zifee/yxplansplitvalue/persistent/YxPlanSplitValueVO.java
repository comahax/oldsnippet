package com.sunrise.boss.business.zifee.yxplansplitvalue.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogVO;

/** @author Hibernate CodeGenerator */
public class YxPlanSplitValueVO implements Serializable ,OperationLog{

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {    	
    	return YxplanSplitValuelogVO.class;
    }
	/** identifier field */
    private Long billcycle;

    /** identifier field */
    private String brandid;

    /** identifier field */
    private String itemid;

    /** persistent field */
    private Double splitfee;

    /** full constructor */
    public YxPlanSplitValueVO(java.lang.Long billcycle, java.lang.String brandid, java.lang.String itemid, java.lang.Double splitfee) {
        this.billcycle = billcycle;
        this.brandid = brandid;
        this.itemid = itemid;
        this.splitfee = splitfee;
    }

    /** default constructor */
    public YxPlanSplitValueVO() {
    }

    public java.lang.Long getBillcycle() {
        return this.billcycle;
    }

    public void setBillcycle(java.lang.Long billcycle) {
        this.billcycle = billcycle;
    }

    public java.lang.String getBrandid() {
        return this.brandid;
    }

    public void setBrandid(java.lang.String brandid) {
        this.brandid = brandid;
    }

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.Double getSplitfee() {
        return this.splitfee;
    }

    public void setSplitfee(java.lang.Double splitfee) {
        this.splitfee = splitfee;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billcycle", getBillcycle())
            .append("brandid", getBrandid())
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanSplitValueVO) ) return false;
        YxPlanSplitValueVO castOther = (YxPlanSplitValueVO) other;
        return new EqualsBuilder()
            .append(this.getBillcycle(), castOther.getBillcycle())
            .append(this.getBrandid(), castOther.getBrandid())
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillcycle())
            .append(getBrandid())
            .append(getItemid())
            .toHashCode();
    }

}
