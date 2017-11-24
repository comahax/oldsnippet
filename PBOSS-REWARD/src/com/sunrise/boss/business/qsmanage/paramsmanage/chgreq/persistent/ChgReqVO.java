package com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.pub.tools.PublicUtils;

/** @author Hibernate CodeGenerator */
public class ChgReqVO implements Serializable {

//	 Fields

	private Long reqid;
	private String tabname;
	private Long tabtype;
	private String oprtype;
	private String mainkey;
	private String mainvalue;
	private Date oprtime;
	private String oprcode; 
	private Long oprstate;
	private Short chgtype;
	private Long matchid;
	private String chgreason;
	private String chkinfo;

	// Constructors

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

	/** default constructor */
	public ChgReqVO() {
	}

	/** minimal constructor */
	public ChgReqVO(Long reqid) {
		this.reqid = reqid;
	}

	/** full constructor */
	public ChgReqVO(Long reqid, String tabname, Long tabtype, String oprtype,
			String mainkey, String mainvalue, Date oprtime, String oprcode,
			Long oprstate) {
		this.reqid = reqid;
		this.tabname = tabname;
		this.tabtype = tabtype;
		this.oprtype = oprtype;
		this.mainkey = mainkey;
		this.mainvalue = mainvalue;
		this.oprtime = oprtime;
		this.oprcode = oprcode;
		this.oprstate = oprstate;

	}

	// Property accessors

	public Long getReqid() {
		return this.reqid;
	}

	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}

	public String getTabname() {
		return this.tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

	public Long getTabtype() {
		return this.tabtype;
	}

	public void setTabtype(Long tabtype) {
		this.tabtype = tabtype;
	}

	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getMainkey() {
		return this.mainkey;
	}

	public void setMainkey(String mainkey) {
		this.mainkey = mainkey;
	}

	public String getMainvalue() {
		return this.mainvalue;
	}

	public void setMainvalue(String mainvalue) {
		this.mainvalue = mainvalue;
	}

	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Long getOprstate() {
		return this.oprstate;
	}

	public void setOprstate(Long oprstate) {
		this.oprstate = oprstate;
	}
    
	public String getAllValue() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	/*	Field[] field = getClass().getDeclaredFields();
		String newValue = ""; 
			for (int i = 0; i < field.length; i++) {
				Object s = BeanUtils.getProperty(this, field[i].getName());
				
		         if(newValue.length()==0){ 
		        	 newValue+=s;
		        	 }
		         else{
		        	 newValue+="~"+s;
		         }
		         }*/
		
		StringBuffer buf = new StringBuffer();
		buf.append(this.getReqid()).append("~").append(this.getTabname()).append("~")
		.append(this.getTabtype()).append("~").append(this.getOprtype()).append("~")
		.append(PublicUtils.utilDateToStr(this.getOprtime())).append("~").append(this.getOprcode()).append("~")
		.append(this.getOprstate());
		return buf.toString();
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("reqid", getReqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChgReqVO) ) return false;
        ChgReqVO castOther = (ChgReqVO) other;
        return new EqualsBuilder()
            .append(this.getReqid(), castOther.getReqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getReqid())
            .toHashCode();
    }

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

}
