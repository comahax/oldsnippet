package com.sunrise.boss.business.zifee.yxplansynlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxplansynlogVO implements Serializable {

    /** persistent field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private java.util.Date modifytime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String yxplanid;

    /** nullable persistent field */
    private String syntype;

    /** nullable persistent field */
    private String oprresult;

    /** nullable persistent field */
    private String oprstate;

    /** nullable persistent field */
    private String oprobject;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public YxplansynlogVO(java.lang.Long logid, java.util.Date createtime, java.util.Date modifytime, java.lang.String oprcode, java.lang.String yxplanid, java.lang.String syntype, java.lang.String oprresult, java.lang.String oprstate, java.lang.String oprobject, java.lang.String remark) {
        this.logid = logid;
        this.createtime = createtime;
        this.modifytime = modifytime;
        this.oprcode = oprcode;
        this.yxplanid = yxplanid;
        this.syntype = syntype;
        this.oprresult = oprresult;
        this.oprstate = oprstate;
        this.oprobject = oprobject;
        this.remark = remark;
    }

    /** default constructor */
    public YxplansynlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getModifytime() {
        return this.modifytime;
    }

    public void setModifytime(java.util.Date modifytime) {
        this.modifytime = modifytime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.String yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.String getSyntype() {
        return this.syntype;
    }

    public void setSyntype(java.lang.String syntype) {
        this.syntype = syntype;
    }

    public java.lang.String getOprresult() {
        return this.oprresult;
    }

    public void setOprresult(java.lang.String oprresult) {
        this.oprresult = oprresult;
    }

    public java.lang.String getOprstate() {
        return this.oprstate;
    }

    public void setOprstate(java.lang.String oprstate) {
        this.oprstate = oprstate;
    }

    public java.lang.String getOprobject() {
        return this.oprobject;
    }

    public void setOprobject(java.lang.String oprobject) {
        this.oprobject = oprobject;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
