package com.gmcc.pboss.business.reward.stypelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StypelogVO extends BaseVO implements Serializable {

    /** nullable persistent field */
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
    private String stype;

    /** nullable persistent field */
    private String ltype;

    /** nullable persistent field */
    private String cityid;
    /** nullable persistent field */
    private Long seq;
    /** full constructor */
    public StypelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String stype, java.lang.String ltype, java.lang.String cityid, java.lang.Long seq) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.stype = stype;
        this.ltype = ltype;
        this.cityid = cityid;
        this.seq = seq;
    }

    /** default constructor */
    public StypelogVO() {
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

    public java.lang.String getStype() {
        return this.stype;
    }

    public void setStype(java.lang.String stype) {
        this.stype = stype;
    }

    public java.lang.String getLtype() {
        return this.ltype;
    }

    public void setLtype(java.lang.String ltype) {
        this.ltype = ltype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
