package com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class EboxChgLogHisVO  implements java.io.Serializable {

    // Fields    

     private Long logid;
     private Long eboxid;
     private Long eboxunitid;
     private Long eboxunitdetid;
     private Double beforechgamt;
     private Double afterchgamt;
     private String opercode;
     private String reason;
     private String reason2;
     private Date chgtime;
     private String source;
     private Long yxplanid;


    // Constructors

    /** default constructor */
    public EboxChgLogHisVO() {
    }

	/** minimal constructor */
    public EboxChgLogHisVO(Long eboxid, Long eboxunitid, Long eboxunitdetid) {
        this.eboxid = eboxid;
        this.eboxunitid = eboxunitid;
        this.eboxunitdetid = eboxunitdetid;
    }
    
  

   
    // Property accessors

    public EboxChgLogHisVO(Long logid, Long eboxid, Long eboxunitid, Long eboxunitdetid, Double beforechgamt, Double afterchgamt, String opercode, String reason, String reason2, Date chgtime, String source, Long yxplanid) {
		super();
		// TODO Auto-generated constructor stub
		this.logid = logid;
		this.eboxid = eboxid;
		this.eboxunitid = eboxunitid;
		this.eboxunitdetid = eboxunitdetid;
		this.beforechgamt = beforechgamt;
		this.afterchgamt = afterchgamt;
		this.opercode = opercode;
		this.reason = reason;
		this.reason2 = reason2;
		this.chgtime = chgtime;
		this.source = source;
		this.yxplanid = yxplanid;
	}

	public Long getLogid() {
        return this.logid;
    }
    
    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public Long getEboxid() {
        return this.eboxid;
    }
    
    public void setEboxid(Long eboxid) {
        this.eboxid = eboxid;
    }

    public Long getEboxunitid() {
        return this.eboxunitid;
    }
    
    public void setEboxunitid(Long eboxunitid) {
        this.eboxunitid = eboxunitid;
    }

    public Long getEboxunitdetid() {
        return this.eboxunitdetid;
    }
    
    public void setEboxunitdetid(Long eboxunitdetid) {
        this.eboxunitdetid = eboxunitdetid;
    }

    public Double getBeforechgamt() {
        return this.beforechgamt;
    }
    
    public void setBeforechgamt(Double beforechgamt) {
        this.beforechgamt = beforechgamt;
    }

    public Double getAfterchgamt() {
        return this.afterchgamt;
    }
    
    public void setAfterchgamt(Double afterchgamt) {
        this.afterchgamt = afterchgamt;
    }

    public String getOpercode() {
        return this.opercode;
    }
    
    public void setOpercode(String opercode) {
        this.opercode = opercode;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getChgtime() {
        return this.chgtime;
    }
    
    public void setChgtime(Date chgtime) {
        this.chgtime = chgtime;
    }

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }

    public Long getYxplanid() {
        return this.yxplanid;
    }
    
    public void setYxplanid(Long yxplanid) {
        this.yxplanid = yxplanid;
    }

	public String getReason2() {
		return reason2;
	}

	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}
	public boolean equals(Object other) {
		if (!(other instanceof EboxChgLogHisVO))
			return false;
		EboxChgLogHisVO castOther = (EboxChgLogHisVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}


}