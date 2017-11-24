package com.sunrise.boss.business.zifee.yxplancplog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxplancplogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date createtime;

    /** persistent field */
    private java.util.Date modifytime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** persistent field */
    private Long orgyxplanid;

    /** persistent field */
    private Long newyxplanid;

    /** persistent field */
    private String copyitem;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String oprresulte;

    /** persistent field */
    private String oprstate;

    /** nullable persistent field */
    private String oprobject;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public YxplancplogVO(java.lang.Long logid, java.util.Date createtime, java.util.Date modifytime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long orgyxplanid, java.lang.Long newyxplanid, java.lang.String copyitem, java.lang.String batchno, java.lang.String oprresulte, java.lang.String oprstate, java.lang.String oprobject, java.lang.String remark) {
        this.logid = logid;
        this.createtime = createtime;
        this.modifytime = modifytime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.orgyxplanid = orgyxplanid;
        this.newyxplanid = newyxplanid;
        this.copyitem = copyitem;
        this.batchno = batchno;
        this.oprresulte = oprresulte;
        this.oprstate = oprstate;
        this.oprobject = oprobject;
        this.remark = remark;
    }

    /** default constructor */
    public YxplancplogVO() {
    }

    /** minimal constructor */
    public YxplancplogVO(java.lang.Long logid, java.util.Date createtime, java.util.Date modifytime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long orgyxplanid, java.lang.Long newyxplanid, java.lang.String copyitem, java.lang.String oprstate) {
        this.logid = logid;
        this.createtime = createtime;
        this.modifytime = modifytime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.orgyxplanid = orgyxplanid;
        this.newyxplanid = newyxplanid;
        this.copyitem = copyitem;
        this.oprstate = oprstate;
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.Long getOrgyxplanid() {
        return this.orgyxplanid;
    }

    public void setOrgyxplanid(java.lang.Long orgyxplanid) {
        this.orgyxplanid = orgyxplanid;
    }

    public java.lang.Long getNewyxplanid() {
        return this.newyxplanid;
    }

    public void setNewyxplanid(java.lang.Long newyxplanid) {
        this.newyxplanid = newyxplanid;
    }

    public java.lang.String getCopyitem() {
        return this.copyitem;
    }

    public void setCopyitem(java.lang.String copyitem) {
        this.copyitem = copyitem;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getOprresulte() {
        return this.oprresulte;
    }

    public void setOprresulte(java.lang.String oprresulte) {
        this.oprresulte = oprresulte;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxplancplogVO) ) return false;
        YxplancplogVO castOther = (YxplancplogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
