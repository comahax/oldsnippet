package com.sunrise.boss.business.zifee.prodservsetlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ProdservsetlogVO implements Serializable {

    /** persistent field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Short modeltype;

    /** nullable persistent field */
    private Short servelevel;

    /** nullable persistent field */
    private String servername;

    /** nullable persistent field */
    private Long flowcontrol;

    /** nullable persistent field */
    private Long lowflow;

    /** nullable persistent field */
    private Short busitype;

    /** nullable persistent field */
    private Double feeamt;

    /** nullable persistent field */
    private String acctid;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ProdservsetlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplanid, java.lang.Short modeltype, java.lang.Short servelevel, java.lang.String servername, java.lang.Long flowcontrol, java.lang.Long lowflow, java.lang.Short busitype, java.lang.Double feeamt, java.lang.String acctid, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplanid = yxplanid;
        this.modeltype = modeltype;
        this.servelevel = servelevel;
        this.servername = servername;
        this.flowcontrol = flowcontrol;
        this.lowflow = lowflow;
        this.busitype = busitype;
        this.feeamt = feeamt;
        this.acctid = acctid;
        this.memo = memo;
    }

    /** default constructor */
    public ProdservsetlogVO() {
    }

    /** minimal constructor */
    public ProdservsetlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long yxplanid) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Short getModeltype() {
        return this.modeltype;
    }

    public void setModeltype(java.lang.Short modeltype) {
        this.modeltype = modeltype;
    }

    public java.lang.Short getServelevel() {
        return this.servelevel;
    }

    public void setServelevel(java.lang.Short servelevel) {
        this.servelevel = servelevel;
    }

    public java.lang.String getServername() {
        return this.servername;
    }

    public void setServername(java.lang.String servername) {
        this.servername = servername;
    }

    public java.lang.Long getFlowcontrol() {
        return this.flowcontrol;
    }

    public void setFlowcontrol(java.lang.Long flowcontrol) {
        this.flowcontrol = flowcontrol;
    }

    public java.lang.Long getLowflow() {
        return this.lowflow;
    }

    public void setLowflow(java.lang.Long lowflow) {
        this.lowflow = lowflow;
    }

    public java.lang.Short getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.Short busitype) {
        this.busitype = busitype;
    }

    public java.lang.Double getFeeamt() {
        return this.feeamt;
    }

    public void setFeeamt(java.lang.Double feeamt) {
        this.feeamt = feeamt;
    }

    public java.lang.String getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.String acctid) {
        this.acctid = acctid;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
