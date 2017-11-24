package com.sunrise.boss.business.zifee.yxplan.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;

/** @author Hibernate CodeGenerator */
public class YxPlanVO implements Serializable, OperationLog {

	/** identifier field */
	private Long yxplanid;

	/** nullable persistent field */
	private Long yxplangroupid;

	/** nullable persistent field */
	private String yxplanname;

	/** nullable persistent field */
	private String yxplancode;

	/** persistent field */
	private java.util.Date startdate;

	/** persistent field */
	private java.util.Date stopdate;

	/** nullable persistent field */
	private String areacode;

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
	private Byte printflag;

	/** nullable persistent field */
	private Byte recfeeprivflag;

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

	/** nullable persistent field */
	private Byte backupflag;

	/** nullable persistent field */
	private Byte feecalcprivflag;

	/** nullable persistent field */
	private Byte isoutmemberpriv;

	private Byte uploadcalcfeekind;

	/** nullable persistent field */
	private Byte stopuserrentflag;

	private String fixfeespecflag;

	private String plantype;

	private Byte feeprio;

	private Short checkus;

	private String userstausflag;

	private Short planbigkind;

	private String privelgepro;
	
	private Long usedbillcyc;
	
	public Short getPlanbigkind() {
		return planbigkind;
	}

	public void setPlanbigkind(Short planbigkind) {
		this.planbigkind = planbigkind;
	}
	
	private String yxplanshortname;
	
	/** full constructor */
	public YxPlanVO(java.lang.Long yxplangroupid, java.lang.String yxplanname,
			java.lang.String yxplancode, java.util.Date startdate,
			java.util.Date stopdate, java.lang.String areacode,
			java.lang.String checkercode, java.lang.String operatorcode,
			java.lang.Long prio, java.lang.Double minconsume,
			java.lang.Long consumecycle, java.lang.Byte bindpackageflag,
			java.lang.Long bindmonths, java.lang.Byte bookflag,
			java.lang.Byte rcprepayflag, java.lang.Long couldusetimes,
			java.lang.Long mindisccycle, java.lang.Long discoffset,
			java.lang.String timeunit, java.lang.Byte starttimetype,
			java.lang.Byte groupflag, java.lang.Byte printflag,
			java.lang.Byte recfeeprivflag, java.lang.String source,
			java.lang.String billingcode, java.lang.String disccondition,
			java.lang.Long salestype, java.lang.String channelcode,
			java.lang.String plankind, java.lang.String specialflag,
			java.lang.String discscope, java.lang.String feecomment,
			java.lang.String remark, java.lang.Byte backupflag,
			java.lang.Byte feecalcprivflag, java.lang.Byte isoutmemberpriv,
			java.lang.Byte stopuserrentflag, java.lang.Short checkus,
			java.lang.String userstausflag,String yxplanshortname) {
		this.yxplangroupid = yxplangroupid;
		this.yxplanname = yxplanname;
		this.yxplancode = yxplancode;
		this.startdate = startdate;
		this.stopdate = stopdate;
		this.areacode = areacode;
		this.checkercode = checkercode;
		this.operatorcode = operatorcode;
		this.prio = prio;
		this.minconsume = minconsume;
		this.consumecycle = consumecycle;
		this.bindpackageflag = bindpackageflag;
		this.bindmonths = bindmonths;
		this.bookflag = bookflag;
		this.rcprepayflag = rcprepayflag;
		this.couldusetimes = couldusetimes;
		this.mindisccycle = mindisccycle;
		this.discoffset = discoffset;
		this.timeunit = timeunit;
		this.starttimetype = starttimetype;
		this.groupflag = groupflag;
		this.printflag = printflag;
		this.recfeeprivflag = recfeeprivflag;
		this.source = source;
		this.billingcode = billingcode;
		this.disccondition = disccondition;
		this.salestype = salestype;
		this.channelcode = channelcode;
		this.plankind = plankind;
		this.specialflag = specialflag;
		this.discscope = discscope;
		this.feecomment = feecomment;
		this.remark = remark;
		this.backupflag = backupflag;
		this.feecalcprivflag = feecalcprivflag;
		this.isoutmemberpriv = isoutmemberpriv;
		this.stopuserrentflag = stopuserrentflag;
		this.checkus = checkus;
		this.userstausflag = userstausflag;
		this.yxplanshortname=yxplanshortname;
	}

	/** default constructor */
	public YxPlanVO() {
	}

	/** minimal constructor */
	public YxPlanVO(java.sql.Timestamp startdate, java.sql.Timestamp stopdate) {
		this.startdate = startdate;
		this.stopdate = stopdate;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.Long getYxplangroupid() {
		return this.yxplangroupid;
	}

	public void setYxplangroupid(java.lang.Long yxplangroupid) {
		this.yxplangroupid = yxplangroupid;
	}

	public java.lang.String getYxplanname() {
		return this.yxplanname;
	}

	public void setYxplanname(java.lang.String yxplanname) {
		this.yxplanname = yxplanname;
	}

	public java.lang.String getYxplancode() {
		return this.yxplancode;
	}

	public void setYxplancode(java.lang.String yxplancode) {
		this.yxplancode = yxplancode;
	}

	public java.util.Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return this.stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
	}

	public java.lang.String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(java.lang.String areacode) {
		this.areacode = areacode;
	}

	public java.lang.String getCheckercode() {
		return this.checkercode;
	}

	public void setCheckercode(java.lang.String checkercode) {
		this.checkercode = checkercode;
	}

	public java.lang.String getOperatorcode() {
		return this.operatorcode;
	}

	public void setOperatorcode(java.lang.String operatorcode) {
		this.operatorcode = operatorcode;
	}

	public java.lang.Long getPrio() {
		return this.prio;
	}

	public void setPrio(java.lang.Long prio) {
		this.prio = prio;
	}

	public java.lang.Double getMinconsume() {
		return this.minconsume;
	}

	public void setMinconsume(java.lang.Double minconsume) {
		this.minconsume = minconsume;
	}

	public java.lang.Long getConsumecycle() {
		return this.consumecycle;
	}

	public void setConsumecycle(java.lang.Long consumecycle) {
		this.consumecycle = consumecycle;
	}

	public java.lang.Byte getBindpackageflag() {
		return this.bindpackageflag;
	}

	public void setBindpackageflag(java.lang.Byte bindpackageflag) {
		this.bindpackageflag = bindpackageflag;
	}

	public java.lang.Long getBindmonths() {
		return this.bindmonths;
	}

	public void setBindmonths(java.lang.Long bindmonths) {
		this.bindmonths = bindmonths;
	}

	public java.lang.Byte getBookflag() {
		return this.bookflag;
	}

	public void setBookflag(java.lang.Byte bookflag) {
		this.bookflag = bookflag;
	}

	public java.lang.Byte getRcprepayflag() {
		return this.rcprepayflag;
	}

	public void setRcprepayflag(java.lang.Byte rcprepayflag) {
		this.rcprepayflag = rcprepayflag;
	}

	public java.lang.Long getCouldusetimes() {
		return this.couldusetimes;
	}

	public void setCouldusetimes(java.lang.Long couldusetimes) {
		this.couldusetimes = couldusetimes;
	}

	public java.lang.Long getMindisccycle() {
		return this.mindisccycle;
	}

	public void setMindisccycle(java.lang.Long mindisccycle) {
		this.mindisccycle = mindisccycle;
	}

	public java.lang.Long getDiscoffset() {
		return this.discoffset;
	}

	public void setDiscoffset(java.lang.Long discoffset) {
		this.discoffset = discoffset;
	}

	public java.lang.String getTimeunit() {
		return this.timeunit;
	}

	public void setTimeunit(java.lang.String timeunit) {
		this.timeunit = timeunit;
	}

	public java.lang.Byte getStarttimetype() {
		return this.starttimetype;
	}

	public void setStarttimetype(java.lang.Byte starttimetype) {
		this.starttimetype = starttimetype;
	}

	public java.lang.Byte getGroupflag() {
		return this.groupflag;
	}

	public void setGroupflag(java.lang.Byte groupflag) {
		this.groupflag = groupflag;
	}

	public java.lang.Byte getPrintflag() {
		return this.printflag;
	}

	public void setPrintflag(java.lang.Byte printflag) {
		this.printflag = printflag;
	}

	public java.lang.Byte getRecfeeprivflag() {
		return this.recfeeprivflag;
	}

	public void setRecfeeprivflag(java.lang.Byte recfeeprivflag) {
		this.recfeeprivflag = recfeeprivflag;
	}

	public java.lang.String getSource() {
		return this.source;
	}

	public void setSource(java.lang.String source) {
		this.source = source;
	}

	public java.lang.String getBillingcode() {
		return this.billingcode;
	}

	public void setBillingcode(java.lang.String billingcode) {
		this.billingcode = billingcode;
	}

	public java.lang.String getDisccondition() {
		return this.disccondition;
	}

	public void setDisccondition(java.lang.String disccondition) {
		this.disccondition = disccondition;
	}

	public java.lang.Long getSalestype() {
		return this.salestype;
	}

	public void setSalestype(java.lang.Long salestype) {
		this.salestype = salestype;
	}

	public java.lang.String getChannelcode() {
		return this.channelcode;
	}

	public void setChannelcode(java.lang.String channelcode) {
		this.channelcode = channelcode;
	}

	public java.lang.String getPlankind() {
		return this.plankind;
	}

	public void setPlankind(java.lang.String plankind) {
		this.plankind = plankind;
	}

	public java.lang.String getSpecialflag() {
		return this.specialflag;
	}

	public void setSpecialflag(java.lang.String specialflag) {
		this.specialflag = specialflag;
	}

	public java.lang.String getDiscscope() {
		return this.discscope;
	}

	public void setDiscscope(java.lang.String discscope) {
		this.discscope = discscope;
	}

	public java.lang.String getFeecomment() {
		return this.feecomment;
	}

	public void setFeecomment(java.lang.String feecomment) {
		this.feecomment = feecomment;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.Byte getBackupflag() {
		return this.backupflag;
	}

	public void setBackupflag(java.lang.Byte backupflag) {
		this.backupflag = backupflag;
	}

	public java.lang.Byte getFeecalcprivflag() {
		return this.feecalcprivflag;
	}

	public void setFeecalcprivflag(java.lang.Byte feecalcprivflag) {
		this.feecalcprivflag = feecalcprivflag;
	}

	public java.lang.Byte getIsoutmemberpriv() {
		return this.isoutmemberpriv;
	}

	public void setIsoutmemberpriv(java.lang.Byte isoutmemberpriv) {
		this.isoutmemberpriv = isoutmemberpriv;
	}

	public java.lang.Byte getStopuserrentflag() {
		return this.stopuserrentflag;
	}

	public void setStopuserrentflag(java.lang.Byte stopuserrentflag) {
		this.stopuserrentflag = stopuserrentflag;
	}

	public String toString() {
		return new ToStringBuilder(this).append("yxplanid", getYxplanid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof YxPlanVO))
			return false;
		YxPlanVO castOther = (YxPlanVO) other;
		return new EqualsBuilder().append(this.getYxplanid(),
				castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getYxplanid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return YxplanlogVO.class;
	}

	public String getFixfeespecflag() {
		return fixfeespecflag;
	}

	public void setFixfeespecflag(String fixfeespecflag) {
		this.fixfeespecflag = fixfeespecflag;
	}

	public Byte getUploadcalcfeekind() {
		return uploadcalcfeekind;
	}

	public void setUploadcalcfeekind(Byte uploadcalcfeekind) {
		this.uploadcalcfeekind = uploadcalcfeekind;
	}

	public Byte getFeeprio() {
		return feeprio;
	}

	public void setFeeprio(Byte feeprio) {
		this.feeprio = feeprio;
	}

	public String getPlantype() {
		return plantype;
	}

	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}

	public Short getCheckus() {
		return checkus;
	}

	public void setCheckus(Short checkus) {
		this.checkus = checkus;
	}

	public String getUserstausflag() {
		return userstausflag;
	}

	public void setUserstausflag(String userstausflag) {
		this.userstausflag = userstausflag;
	}

	public String getPrivelgepro() {
		return privelgepro;
	}

	public void setPrivelgepro(String privelgepro) {
		this.privelgepro = privelgepro;
	}

	public String getYxplanshortname() {
		return yxplanshortname;
	}

	public void setYxplanshortname(String yxplanshortname) {
		this.yxplanshortname = yxplanshortname;
	}

	public Long getUsedbillcyc() {
		return usedbillcyc;
	}

	public void setUsedbillcyc(Long usedbillcyc) {
		this.usedbillcyc = usedbillcyc;
	}
	
}
