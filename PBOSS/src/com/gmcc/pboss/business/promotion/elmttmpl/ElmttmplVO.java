package com.gmcc.pboss.business.promotion.elmttmpl;

import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ElmttmplVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long tmplid;

    /** persistent field */
    private String tmplname;

    /** persistent field */
    private String gatheringmode;

    /** persistent field */
    private String columnsinfo;

    /** persistent field */
    private String gatheringlogic;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ElmttmplVO(java.lang.Long tmplid, java.lang.String tmplname, java.lang.String gatheringmode, java.lang.String columnsinfo, java.lang.String gatheringlogic, java.lang.String state, java.lang.String memo) {
        this.tmplid = tmplid;
        this.tmplname = tmplname;
        this.gatheringmode = gatheringmode;
        this.columnsinfo = columnsinfo;
        this.gatheringlogic = gatheringlogic;
        this.state = state;
        this.memo = memo;
    }

    /** default constructor */
    public ElmttmplVO() {
    }

    /** minimal constructor */
    public ElmttmplVO(java.lang.Long tmplid, java.lang.String tmplname, java.lang.String gatheringmode, java.lang.String columnsinfo, java.lang.String gatheringlogic) {
        this.tmplid = tmplid;
        this.tmplname = tmplname;
        this.gatheringmode = gatheringmode;
        this.columnsinfo = columnsinfo;
        this.gatheringlogic = gatheringlogic;
    }

    public java.lang.Long getTmplid() {
        return this.tmplid;
    }

    public void setTmplid(java.lang.Long tmplid) {
        this.tmplid = tmplid;
    }

    public java.lang.String getTmplname() {
        return this.tmplname;
    }

    public void setTmplname(java.lang.String tmplname) {
        this.tmplname = tmplname;
    }

    public java.lang.String getGatheringmode() {
        return this.gatheringmode;
    }

    public void setGatheringmode(java.lang.String gatheringmode) {
        this.gatheringmode = gatheringmode;
    }

    public java.lang.String getColumnsinfo() {
        return this.columnsinfo;
    }

    public void setColumnsinfo(java.lang.String columnsinfo) {
        this.columnsinfo = columnsinfo;
    }

    public java.lang.String getGatheringlogic() {
        return this.gatheringlogic;
    }

    public void setGatheringlogic(java.lang.String gatheringlogic) {
        this.gatheringlogic = gatheringlogic;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("tmplid", getTmplid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ElmttmplVO) ) return false;
        ElmttmplVO castOther = (ElmttmplVO) other;
        return new EqualsBuilder()
            .append(this.getTmplid(), castOther.getTmplid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTmplid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ElmttmpllogVO.class;
	}

}
