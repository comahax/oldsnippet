package com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChgHisVO implements Serializable {

    /** identifier field */
    private Long reqid;

    /** nullable persistent field */
    private String tabname;

    /** nullable persistent field */
    private Byte tabtype;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String mainkey;

    /** nullable persistent field */
    private String mainvalue;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Short oprstate;

    /** nullable persistent field */
    private String oldvalue;

    /** nullable persistent field */
    private String newvalue;
    
    private Short chgtype;
	private Long matchid;
	private String chgreason;
	private String chkinfo;
	private Long logid;

    public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getChgreason() {
		return chgreason;
	}

	public void setChgreason(String chgreason) {
		this.chgreason = chgreason;
	}

	public Short getChgtype() {
		return chgtype;
	}

	public void setChgtype(Short chgtype) {
		this.chgtype = chgtype;
	}

	public String getChkinfo() {
		return chkinfo;
	}

	public void setChkinfo(String chkinfo) {
		this.chkinfo = chkinfo;
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	/** full constructor */
    public ChgHisVO(java.lang.Long reqid,java.lang.String tabname, java.lang.Byte tabtype, java.lang.String oprtype, java.lang.String mainkey, java.lang.String mainvalue, java.util.Date oprtime, java.lang.String oprcode, java.lang.Short oprstate, java.lang.String oldvalue, java.lang.String newvalue) {
        this.reqid = reqid;
        this.reqid = reqid;
        this.tabname = tabname;
        this.tabtype = tabtype;
        this.oprtype = oprtype;
        this.mainkey = mainkey;
        this.mainvalue = mainvalue;
        this.oprtime = oprtime;
        this.oprcode = oprcode;
        this.oprstate = oprstate;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
    }

    /** default constructor */
    public ChgHisVO() {
    }

    /** minimal constructor */
    public ChgHisVO(java.lang.Long reqid) {
        this.reqid = reqid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("reqid", getReqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChgHisVO) ) return false;
        ChgHisVO castOther = (ChgHisVO) other;
        return new EqualsBuilder()
            .append(this.getReqid(), castOther.getReqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getReqid())
            .toHashCode();
    }

	public String getMainkey() {
		return mainkey;
	}

	public void setMainkey(String mainkey) {
		this.mainkey = mainkey;
	}

	public String getMainvalue() {
		return mainvalue;
	}

	public void setMainvalue(String mainvalue) {
		this.mainvalue = mainvalue;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getOldvalue() {
		return oldvalue;
	}

	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Short getOprstate() {
		return oprstate;
	}

	public void setOprstate(Short oprstate) {
		this.oprstate = oprstate;
	}

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public Long getReqid() {
		return reqid;
	}

	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}

	public String getTabname() {
		return tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

	public Byte getTabtype() {
		return tabtype;
	}

	public void setTabtype(Byte tabtype) {
		this.tabtype = tabtype;
	}

}
