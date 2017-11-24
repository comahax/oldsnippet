/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.ui.zifee.yxplanlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;

/**
 * <p>Title: YxplanlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class YxplanlogForm extends BaseActionForm {
	private String _dnl_optime;
	
	private String _dnm_optime;
	
	private String _sk_oprcode;
	
	private String _se_oprtype;
	
	private String _se_success;
	
	private String _sql_areacode;
	
	private String _se_yxplanid;
	
	private String _sk_yxplanname;
	
	  private Long logid;

	    /** persistent field */
	    private java.sql.Timestamp optime;

	    /** persistent field */
	    private String oprcode;

	    /** persistent field */
	    private String oprtype;

	    /** nullable persistent field */
	    private String success;

	    /** nullable persistent field */
	    private Long yxplanid;

	    /** nullable persistent field */
	    private String yxplanname;

	    /** nullable persistent field */
	    private String yxplancode;

	    /** nullable persistent field */
	    private java.util.Date startdate;

	    /** nullable persistent field */
	    private java.util.Date stopdate;

	    /** nullable persistent field */
	    private String checkercode;

	    /** nullable persistent field */
	    private String operatorcode;

	    /** nullable persistent field */
	    private Long prio;

	    /** nullable persistent field */
	    private Double minconsume;

	    /** nullable persistent field */
	    private Long consumecycle;

	    /** nullable persistent field */
	    private Byte bindpackageflag;

	    /** nullable persistent field */
	    private Long bindmonths;

	    /** nullable persistent field */
	    private Byte bookflag;

	    /** nullable persistent field */
	    private Byte rcprepayflag;

	    /** nullable persistent field */
	    private Long couldusetimes;

	    /** nullable persistent field */
	    private Long mindisccycle;

	    /** nullable persistent field */
	    private Long discoffset;

	    /** nullable persistent field */
	    private String timeunit;

	    /** nullable persistent field */
	    private Byte starttimetype;

	    /** nullable persistent field */
	    private Byte groupflag;

	    /** nullable persistent field */
	    private Byte backupflag;

	    /** nullable persistent field */
	    private Byte printflag;

	    /** nullable persistent field */
	    private Byte feecalcprivflag;

	    /** nullable persistent field */
	    private Byte recfeeprivflag;

	    /** nullable persistent field */
	    private Byte stopuserrentflag;

	    /** nullable persistent field */
	    private Byte isoutmemberpriv;

	    /** nullable persistent field */
	    private String source;

	    /** nullable persistent field */
	    private String billingcode;

	    /** nullable persistent field */
	    private String disccondition;

	    /** nullable persistent field */
	    private Long salestype;

	    /** nullable persistent field */
	    private String channelcode;

	    /** nullable persistent field */
	    private String plankind;

	    /** nullable persistent field */
	    private String specialflag;

	    /** nullable persistent field */
	    private String discscope;

	    /** nullable persistent field */
	    private String feecomment;

	    /** nullable persistent field */
	    private String remark;

		public String get_dnl_optime() {
			return _dnl_optime;
		}

		public void set_dnl_optime(String _dnl_optime) {
			this._dnl_optime = _dnl_optime;
		}

		public String get_dnm_optime() {
			return _dnm_optime;
		}

		public void set_dnm_optime(String _dnm_optime) {
			this._dnm_optime = _dnm_optime;
		}

		public String get_se_oprtype() {
			return _se_oprtype;
		}

		public void set_se_oprtype(String _se_oprtype) {
			this._se_oprtype = _se_oprtype;
		}

		public String get_se_success() {
			return _se_success;
		}

		public void set_se_success(String _se_success) {
			this._se_success = _se_success;
		}

		public String get_sk_oprcode() {
			return _sk_oprcode;
		}

		public void set_sk_oprcode(String _sk_oprcode) {
			this._sk_oprcode = _sk_oprcode;
		}
		
		public String get_sql_areacode() {
			return _sql_areacode;
		}
		public void set_sql_areacode(String _sql_areacode) {
			this._sql_areacode = _sql_areacode;
		}

		public Byte getBackupflag() {
			return backupflag;
		}

		public void setBackupflag(Byte backupflag) {
			this.backupflag = backupflag;
		}

		public String getBillingcode() {
			return billingcode;
		}

		public void setBillingcode(String billingcode) {
			this.billingcode = billingcode;
		}

		public Long getBindmonths() {
			return bindmonths;
		}

		public void setBindmonths(Long bindmonths) {
			this.bindmonths = bindmonths;
		}

		public Byte getBindpackageflag() {
			return bindpackageflag;
		}

		public void setBindpackageflag(Byte bindpackageflag) {
			this.bindpackageflag = bindpackageflag;
		}

		public Byte getBookflag() {
			return bookflag;
		}

		public void setBookflag(Byte bookflag) {
			this.bookflag = bookflag;
		}

		public String getChannelcode() {
			return channelcode;
		}

		public void setChannelcode(String channelcode) {
			this.channelcode = channelcode;
		}

		public String getCheckercode() {
			return checkercode;
		}

		public void setCheckercode(String checkercode) {
			this.checkercode = checkercode;
		}

		public Long getConsumecycle() {
			return consumecycle;
		}

		public void setConsumecycle(Long consumecycle) {
			this.consumecycle = consumecycle;
		}

		public Long getCouldusetimes() {
			return couldusetimes;
		}

		public void setCouldusetimes(Long couldusetimes) {
			this.couldusetimes = couldusetimes;
		}

		public String getDisccondition() {
			return disccondition;
		}

		public void setDisccondition(String disccondition) {
			this.disccondition = disccondition;
		}

		public Long getDiscoffset() {
			return discoffset;
		}

		public void setDiscoffset(Long discoffset) {
			this.discoffset = discoffset;
		}

		public String getDiscscope() {
			return discscope;
		}

		public void setDiscscope(String discscope) {
			this.discscope = discscope;
		}

		public Byte getFeecalcprivflag() {
			return feecalcprivflag;
		}

		public void setFeecalcprivflag(Byte feecalcprivflag) {
			this.feecalcprivflag = feecalcprivflag;
		}

		public String getFeecomment() {
			return feecomment;
		}

		public void setFeecomment(String feecomment) {
			this.feecomment = feecomment;
		}

		public Byte getGroupflag() {
			return groupflag;
		}

		public void setGroupflag(Byte groupflag) {
			this.groupflag = groupflag;
		}

		public Byte getIsoutmemberpriv() {
			return isoutmemberpriv;
		}

		public void setIsoutmemberpriv(Byte isoutmemberpriv) {
			this.isoutmemberpriv = isoutmemberpriv;
		}

		public Long getLogid() {
			return logid;
		}

		public void setLogid(Long logid) {
			this.logid = logid;
		}

		public Double getMinconsume() {
			return minconsume;
		}

		public void setMinconsume(Double minconsume) {
			this.minconsume = minconsume;
		}

		public Long getMindisccycle() {
			return mindisccycle;
		}

		public void setMindisccycle(Long mindisccycle) {
			this.mindisccycle = mindisccycle;
		}

		public String getOperatorcode() {
			return operatorcode;
		}

		public void setOperatorcode(String operatorcode) {
			this.operatorcode = operatorcode;
		}

		public String getOprcode() {
			return oprcode;
		}

		public void setOprcode(String oprcode) {
			this.oprcode = oprcode;
		}

		public String getOprtype() {
			return oprtype;
		}

		public void setOprtype(String oprtype) {
			this.oprtype = oprtype;
		}

		public java.sql.Timestamp getOptime() {
			return optime;
		}

		public void setOptime(java.sql.Timestamp optime) {
			this.optime = optime;
		}

		public String getPlankind() {
			return plankind;
		}

		public void setPlankind(String plankind) {
			this.plankind = plankind;
		}

		public Byte getPrintflag() {
			return printflag;
		}

		public void setPrintflag(Byte printflag) {
			this.printflag = printflag;
		}

		public Long getPrio() {
			return prio;
		}

		public void setPrio(Long prio) {
			this.prio = prio;
		}

		public Byte getRcprepayflag() {
			return rcprepayflag;
		}

		public void setRcprepayflag(Byte rcprepayflag) {
			this.rcprepayflag = rcprepayflag;
		}

		public Byte getRecfeeprivflag() {
			return recfeeprivflag;
		}

		public void setRecfeeprivflag(Byte recfeeprivflag) {
			this.recfeeprivflag = recfeeprivflag;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public Long getSalestype() {
			return salestype;
		}

		public void setSalestype(Long salestype) {
			this.salestype = salestype;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getSpecialflag() {
			return specialflag;
		}

		public void setSpecialflag(String specialflag) {
			this.specialflag = specialflag;
		}

		public java.util.Date getStartdate() {
			return startdate;
		}

		public void setStartdate(java.util.Date startdate) {
			this.startdate = startdate;
		}

		public Byte getStarttimetype() {
			return starttimetype;
		}

		public void setStarttimetype(Byte starttimetype) {
			this.starttimetype = starttimetype;
		}

		public java.util.Date getStopdate() {
			return stopdate;
		}

		public void setStopdate(java.util.Date stopdate) {
			this.stopdate = stopdate;
		}

		public Byte getStopuserrentflag() {
			return stopuserrentflag;
		}

		public void setStopuserrentflag(Byte stopuserrentflag) {
			this.stopuserrentflag = stopuserrentflag;
		}

		public String getSuccess() {
			return success;
		}

		public void setSuccess(String success) {
			this.success = success;
		}

		public String getTimeunit() {
			return timeunit;
		}

		public void setTimeunit(String timeunit) {
			this.timeunit = timeunit;
		}

		public String getYxplancode() {
			return yxplancode;
		}

		public void setYxplancode(String yxplancode) {
			this.yxplancode = yxplancode;
		}

		public Long getYxplanid() {
			return yxplanid;
		}

		public void setYxplanid(Long yxplanid) {
			this.yxplanid = yxplanid;
		}

		public String getYxplanname() {
			return yxplanname;
		}

		public void setYxplanname(String yxplanname) {
			this.yxplanname = yxplanname;
		}

		public String get_se_yxplanid() {
			return _se_yxplanid;
		}

		public void set_se_yxplanid(String _se_yxplanid) {
			this._se_yxplanid = _se_yxplanid;
		}

		public String get_sk_yxplanname() {
			return _sk_yxplanname;
		}

		public void set_sk_yxplanname(String _sk_yxplanname) {
			this._sk_yxplanname = _sk_yxplanname;
		}
		
		
}
