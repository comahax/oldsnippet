package com.gmcc.pboss.business.sales.process;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ProcessVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long processid;

    /** persistent field */
    private String processname;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String uipath;

    /** nullable persistent field */
    private String classpath;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ProcessVO(java.lang.String processname, java.lang.String cityid, java.lang.String uipath, java.lang.String classpath, java.lang.String memo) {
        this.processname = processname;
        this.cityid = cityid;
        this.uipath = uipath;
        this.classpath = classpath;
        this.memo = memo;
    }

    /** default constructor */
    public ProcessVO() {
    }

    /** minimal constructor */
    public ProcessVO(java.lang.String processname, java.lang.String cityid) {
        this.processname = processname;
        this.cityid = cityid;
    }

    public java.lang.Long getProcessid() {
        return this.processid;
    }

    public void setProcessid(java.lang.Long processid) {
        this.processid = processid;
    }

    public java.lang.String getProcessname() {
        return this.processname;
    }

    public void setProcessname(java.lang.String processname) {
        this.processname = processname;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getUipath() {
        return this.uipath;
    }

    public void setUipath(java.lang.String uipath) {
        this.uipath = uipath;
    }

    public java.lang.String getClasspath() {
        return this.classpath;
    }

    public void setClasspath(java.lang.String classpath) {
        this.classpath = classpath;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("processid", getProcessid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ProcessVO) ) return false;
        ProcessVO castOther = (ProcessVO) other;
        return new EqualsBuilder()
            .append(this.getProcessid(), castOther.getProcessid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getProcessid())
            .toHashCode();
    }

}
