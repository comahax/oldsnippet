package com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent;

import java.util.Date;

public class DgEboxChgLogVO  implements java.io.Serializable {

    

     private Long logid;
     private Long eboxid;
     private Long eboxunitid;
     private Long eboxunitdetid;
     private Long beforechgamt;
     private Long afterchgamt;
     private String opercode;
     private String reason;
     private String reason2;
     private Date chgtime;
     private String memo;
     private Long yxplanid;
     private Long genbillcyc;
     private Long baseamt;
     private Long presentamt;
     private Long invalidamt;
     private Short billflag;
     private Long chgamt;
     
     
	public Long getChgamt() {
		return chgamt;
	}
	public void setChgamt(Long chgamt) {
		this.chgamt = chgamt;
	}
	public Long getAfterchgamt() {
		return afterchgamt;
	}
	public void setAfterchgamt(Long afterchgamt) {
		this.afterchgamt = afterchgamt;
	}
	public Long getBaseamt() {
		return baseamt;
	}
	public void setBaseamt(Long baseamt) {
		this.baseamt = baseamt;
	}
	public Long getBeforechgamt() {
		return beforechgamt;
	}
	public void setBeforechgamt(Long beforechgamt) {
		this.beforechgamt = beforechgamt;
	}
	public Short getBillflag() {
		return billflag;
	}
	public void setBillflag(Short billflag) {
		this.billflag = billflag;
	}
	public Date getChgtime() {
		return chgtime;
	}
	public void setChgtime(Date chgtime) {
		this.chgtime = chgtime;
	}
	public Long getEboxid() {
		return eboxid;
	}
	public void setEboxid(Long eboxid) {
		this.eboxid = eboxid;
	}
	public Long getEboxunitdetid() {
		return eboxunitdetid;
	}
	public void setEboxunitdetid(Long eboxunitdetid) {
		this.eboxunitdetid = eboxunitdetid;
	}
	public Long getEboxunitid() {
		return eboxunitid;
	}
	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}
	public Long getGenbillcyc() {
		return genbillcyc;
	}
	public void setGenbillcyc(Long genbillcyc) {
		this.genbillcyc = genbillcyc;
	}
	public Long getInvalidamt() {
		return invalidamt;
	}
	public void setInvalidamt(Long invalidamt) {
		this.invalidamt = invalidamt;
	}
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getOpercode() {
		return opercode;
	}
	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}
	public Long getPresentamt() {
		return presentamt;
	}
	public void setPresentamt(Long presentamt) {
		this.presentamt = presentamt;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReason2() {
		return reason2;
	}
	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}
	public Long getYxplanid() {
		return yxplanid;
	}
	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

  

}