package com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 
 *  Class Name: IbDataBusiinfoVO.java
 *  @Description: 业务信息表实体对象 由IB_DATA_BUSIINFO变更为IB_INF_BUSIINFO
 *  
 *  @author YinGP  DateTime 2015-10-10 上午10:29:51    
 *  @version 1.0
 */
public class IbDataBusiinfoVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4347432609415285538L;

	/** identifier field */
    private Integer billcycle;

    /** identifier field */
    private Short chargingtype;

    /** identifier field */
    private String filetype;

    /** identifier field */
    private String opCode;

    /** identifier field */
    private String port;

    /** identifier field */
    private String spCode;

    /** persistent field */
    private Double fee;

    /** persistent field */
    private Long acctitemIdlv1;

    /** persistent field */
    private Long acctitemIdlv2;

    /** full constructor */
    public IbDataBusiinfoVO(java.lang.Integer billcycle, java.lang.Short chargingtype, java.lang.String filetype, java.lang.String opCode, java.lang.String port, java.lang.String spCode, java.lang.Double fee, java.lang.Long acctitemIdlv1, java.lang.Long acctitemIdlv2) {
        this.billcycle = billcycle;
        this.chargingtype = chargingtype;
        this.filetype = filetype;
        this.opCode = opCode;
        this.port = port;
        this.spCode = spCode;
        this.fee = fee;
        this.acctitemIdlv1 = acctitemIdlv1;
        this.acctitemIdlv2 = acctitemIdlv2;
    }

    /** default constructor */
    public IbDataBusiinfoVO() {
    }

    public java.lang.Integer getBillcycle() {
        return this.billcycle;
    }

    public void setBillcycle(java.lang.Integer billcycle) {
        this.billcycle = billcycle;
    }

    public java.lang.Short getChargingtype() {
        return this.chargingtype;
    }

    public void setChargingtype(java.lang.Short chargingtype) {
        this.chargingtype = chargingtype;
    }

    public java.lang.String getFiletype() {
        return this.filetype;
    }

    public void setFiletype(java.lang.String filetype) {
        this.filetype = filetype;
    }

    public java.lang.String getOpCode() {
        return this.opCode;
    }

    public void setOpCode(java.lang.String opCode) {
        this.opCode = opCode;
    }

    public java.lang.String getPort() {
        return this.port;
    }

    public void setPort(java.lang.String port) {
        this.port = port;
    }

    public java.lang.String getSpCode() {
        return this.spCode;
    }

    public void setSpCode(java.lang.String spCode) {
        this.spCode = spCode;
    }

    public java.lang.Double getFee() {
        return this.fee;
    }

    public void setFee(java.lang.Double fee) {
        this.fee = fee;
    }

    public java.lang.Long getAcctitemIdlv1() {
        return this.acctitemIdlv1;
    }

    public void setAcctitemIdlv1(java.lang.Long acctitemIdlv1) {
        this.acctitemIdlv1 = acctitemIdlv1;
    }

    public java.lang.Long getAcctitemIdlv2() {
        return this.acctitemIdlv2;
    }

    public void setAcctitemIdlv2(java.lang.Long acctitemIdlv2) {
        this.acctitemIdlv2 = acctitemIdlv2;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billcycle", getBillcycle())
            .append("chargingtype", getChargingtype())
            .append("filetype", getFiletype())
            .append("opCode", getOpCode())
            .append("port", getPort())
            .append("spCode", getSpCode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof IbDataBusiinfoVO) ) return false;
        IbDataBusiinfoVO castOther = (IbDataBusiinfoVO) other;
        return new EqualsBuilder()
            .append(this.getBillcycle(), castOther.getBillcycle())
            .append(this.getChargingtype(), castOther.getChargingtype())
            .append(this.getFiletype(), castOther.getFiletype())
            .append(this.getOpCode(), castOther.getOpCode())
            .append(this.getPort(), castOther.getPort())
            .append(this.getSpCode(), castOther.getSpCode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillcycle())
            .append(getChargingtype())
            .append(getFiletype())
            .append(getOpCode())
            .append(getPort())
            .append(getSpCode())
            .toHashCode();
    }

}
