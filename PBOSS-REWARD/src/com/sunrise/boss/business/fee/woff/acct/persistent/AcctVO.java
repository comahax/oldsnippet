package com.sunrise.boss.business.fee.woff.acct.persistent;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.boss.business.common.dblog.ManageLog;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: BillItemMagVO</p>
 * <p>Description: Bill item management VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctVO implements Serializable,ManageLog{
	
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
    
   // Constructors

   /** default constructor */
   public AcctVO() {
   }

   
   /** full constructor */
   public AcctVO(String acctname, Integer accttype, Integer acctstate, Date starttime, Date stoptime, Integer acctlevel, String limitflag, Integer woffpri, String acctcode, String printname) {
       this.acctname = acctname;
       this.accttype = accttype;
       this.acctstate = acctstate;
       this.starttime = starttime;
       this.stoptime = stoptime;
       this.acctlevel = acctlevel;
       this.limitflag = limitflag;
       this.woffpri = woffpri;
       this.acctcode = acctcode;
       this.printname = printname;
   }

  
   // Property accessors
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
       if ( !(other instanceof AcctVO) ) return false;
       AcctVO castOther = (AcctVO) other;
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
