package com.gmcc.pboss.business.promotion.ruleitemlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RuleitemlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long itemid;

    /** nullable persistent field */
    private Integer ruleid;

    /** nullable persistent field */
    private String optexpression;

    /** nullable persistent field */
    private String datatype;

    /** nullable persistent field */
    private String filtermode;

    /** nullable persistent field */
    private String matching;

    /** full constructor */
    public RuleitemlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long itemid, java.lang.Integer ruleid, java.lang.String optexpression, java.lang.String datatype, java.lang.String filtermode, java.lang.String matching) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.itemid = itemid;
        this.ruleid = ruleid;
        this.optexpression = optexpression;
        this.datatype = datatype;
        this.filtermode = filtermode;
        this.matching = matching;
    }

    /** default constructor */
    public RuleitemlogVO() {
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

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.Integer getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Integer ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getOptexpression() {
        return this.optexpression;
    }

    public void setOptexpression(java.lang.String optexpression) {
        this.optexpression = optexpression;
    }

    public java.lang.String getDatatype() {
        return this.datatype;
    }

    public void setDatatype(java.lang.String datatype) {
        this.datatype = datatype;
    }

    public java.lang.String getFiltermode() {
        return this.filtermode;
    }

    public void setFiltermode(java.lang.String filtermode) {
        this.filtermode = filtermode;
    }

    public java.lang.String getMatching() {
        return this.matching;
    }

    public void setMatching(java.lang.String matching) {
        this.matching = matching;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RuleitemlogVO) ) return false;
        RuleitemlogVO castOther = (RuleitemlogVO) other;
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
