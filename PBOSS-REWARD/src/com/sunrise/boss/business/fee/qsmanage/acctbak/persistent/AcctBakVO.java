package com.sunrise.boss.business.fee.qsmanage.acctbak.persistent;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.pub.tools.PublicUtils;

/**
 * @author mys
 * @version 1.0
 */

public class AcctBakVO implements Serializable{
	
	// Fields    

    private Long acctid;
    private String acctname;
    private Integer accttype;
    private Integer acctstate;
    private Date starttime;
    private Date stoptime;
    private Integer acctlevel;
    private String limitflag;
    private Integer woffpri;
    private String acctcode;
    private String printname;
    

    
    
   public AcctBakVO() {
   }
   
   public Date getStarttime() {
       return this.starttime;
   }
   
   public void setStarttime(Date starttime) {
       this.starttime = starttime;
   }

   public Date getStoptime() {
       return this.stoptime;
   }
   
   public void setStoptime( Date stoptime ) {
       this.stoptime = stoptime;
   }

   public Long getAcctid() {
       return this.acctid;
   }
   
   public void setAcctid(Long acctid) {
       this.acctid = acctid;
   }

   public String getAcctname() {
       return this.acctname;
   }
   
   public void setAcctname(String acctname) {
       this.acctname = acctname;
   }

   public Integer getAccttype() {
       return this.accttype;
   }
   
   public void setAccttype(Integer accttype) {
       this.accttype = accttype;
   }

   public Integer getAcctstate() {
       return this.acctstate;
   }
   
   public void setAcctstate(Integer acctstate) {
       this.acctstate = acctstate;
   }

   public Integer getAcctlevel() {
       return this.acctlevel;
   }
   
   public void setAcctlevel(Integer acctlevel) {
       this.acctlevel = acctlevel;
   }

   public String getLimitflag() {
       return this.limitflag;
   }
   
   public void setLimitflag(String limitflag) {
       this.limitflag = limitflag;
   }

   public Integer getWoffpri() {
       return this.woffpri;
   }
   
   public void setWoffpri(Integer woffpri) {
       this.woffpri = woffpri;
   }

   public String getAcctcode() {
       return this.acctcode;
   }
   
   public void setAcctcode(String acctcode) {
       this.acctcode = acctcode;
   }

   public String getPrintname() {
       return this.printname;
   }
   
   public void setPrintname(String printname) {
       this.printname = printname;
   }
   
   public String toString() {
	   StringBuffer buf = new StringBuffer();
		buf.append(this.getAcctid()).append("~").append(this.getAcctname()).append("~").append(this.getAccttype()).append("~")
		.append(this.getAcctstate()).append("~").append(PublicUtils.sqlDateToStr(this.getStarttime())).append("~")
		.append(PublicUtils.sqlDateToStr(this.getStoptime())).append("~").append(this.getAcctlevel()).append("~")
		.append(this.getLimitflag()).append("~").append(this.getWoffpri()).append("~")
		.append(this.getAcctcode()).append("~").append(this.getPrintname()).append("~");
		return buf.toString();
   }

   public boolean equals(Object other) {
       if ( !(other instanceof AcctBakVO) ) return false;
       AcctBakVO castOther = (AcctBakVO) other;
       return new EqualsBuilder()
           .append(this.getAcctid(), castOther.getAcctid())
           .isEquals();
   }

   public int hashCode() {
       return new HashCodeBuilder()
           .append(getAcctid())
           .toHashCode();
   }
}
