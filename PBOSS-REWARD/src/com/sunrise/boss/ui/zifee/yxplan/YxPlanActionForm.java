package com.sunrise.boss.ui.zifee.yxplan;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.CMSUtils;

public class YxPlanActionForm extends BaseActionForm {
	// TODO Auto-generated constructor stub
	// 原始营销方案标识（营销方案单个复制）
	private Long orgyxplanid;

	private String copyitem;

	private FormFile inputFile; // 批量上传文件

	private String reInfo; // 批量处理返回信息，包括出错记录和出错原因

	private String _ne_yxplanid;

	private String _nnm_yxplanid; // 营销方案<=

	private String _nnl_yxplanid; // 营销方案>=

	private String _sk_yxplanname;

	private String _se_checkercode;

	private String _se_operatorcode;

	private String _sk_discscope;

	private String _sk_feecomment;

	private String _sk_remark;

	private String _se_plankind;

	private String _se_areacode;

	private String _ne_groupflag;

	private String _dnl_startdate;
	
	private String _dnm_startdate;
	
	private String _dnl_stopdate;

	private String _dnm_stopdate;

	private String _ne_checkus;

	private String privelgepro;
	
	private String _ne_plankind;
	
	/** identifier field */
	private Long yxplanid;

	/** nullable persistent field */
	private String areacode;

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

	private String[] specialflagName;

	private String[] selectSpecialflag = {};

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

	private Byte uploadcalcfeekind;

	/** nullable persistent field */
	private Byte stopuserrentflag;

	/** nullable persistent field */
	private Byte isoutmemberpriv;

	private Short checkus;

	private String userstausflag;

	private String[] userstausflagName = CMSUtils.getIDorname("US", "name");

	private String[] userstausflagValue = CMSUtils.getIDorname("US", "id");

	private String[] selectuserstausflag;

	private Short planbigkind;

	private String _ne_planbigkind;
	
	private String yxplanshortname;
	
	private Long usedbillcyc;
	
	// private String fixfeespecflag;
	private String fixfeespecflags[] = { "是否减免基本月租", "是否预收方案", "是否停机照收月租",
			"是否集团网用户方案", "是否集群网用户方案", "是否包含GPRS资费", "是否全网被叫包月", "是否强制送ILOG算费",
			"是否功能费套餐" };

	private String[] seletefixfees = {};

	private String feeprio;

	private String plantype;

	private String batchaction;

	public String getPlantype() {
		return plantype;
	}

	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}

	public String get_nnl_yxplanid() {
		return _nnl_yxplanid;
	}

	public void set_nnl_yxplanid(String _nnl_yxplanid) {
		this._nnl_yxplanid = _nnl_yxplanid;
	}

	public String get_nnm_yxplanid() {
		return _nnm_yxplanid;
	}

	public void set_nnm_yxplanid(String _nnm_yxplanid) {
		this._nnm_yxplanid = _nnm_yxplanid;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_se_checkercode() {
		return _se_checkercode;
	}

	public void set_se_checkercode(String _se_checkercode) {
		this._se_checkercode = _se_checkercode;
	}

	public String get_sk_discscope() {
		return _sk_discscope;
	}

	public void set_sk_discscope(String _sk_discscope) {
		this._sk_discscope = _sk_discscope;
	}

	public String get_se_operatorcode() {
		return _se_operatorcode;
	}

	public void set_se_operatorcode(String _se_operatorcode) {
		this._se_operatorcode = _se_operatorcode;
	}

	public String get_se_plankind() {
		return _se_plankind;
	}

	public void set_se_plankind(String _se_plankind) {
		this._se_plankind = _se_plankind;
	}

	public String get_sk_feecomment() {
		return _sk_feecomment;
	}

	public void set_sk_feecomment(String _sk_feecomment) {
		this._sk_feecomment = _sk_feecomment;
	}

	public String get_sk_remark() {
		return _sk_remark;
	}

	public void set_sk_remark(String _sk_remark) {
		this._sk_remark = _sk_remark;
	}

	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}

	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
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

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
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

	public Byte getStarttimetype() {
		return starttimetype;
	}

	public void setStarttimetype(Byte starttimetype) {
		this.starttimetype = starttimetype;
	}

	public Byte getStopuserrentflag() {
		return stopuserrentflag;
	}

	public void setStopuserrentflag(Byte stopuserrentflag) {
		this.stopuserrentflag = stopuserrentflag;
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

	public Long getYxplangroupid() {
		return yxplangroupid;
	}

	public void setYxplangroupid(Long yxplangroupid) {
		this.yxplangroupid = yxplangroupid;
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

	public String get_se_areacode() {
		return _se_areacode;
	}

	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String get_ne_groupflag() {
		return _ne_groupflag;
	}

	public void set_ne_groupflag(String _ne_groupflag) {
		this._ne_groupflag = _ne_groupflag;
	}

	public FormFile getInputFile() {
		return inputFile;
	}

	public void setInputFile(FormFile inputFile) {
		this.inputFile = inputFile;
	}

	public String getReInfo() {
		return reInfo;
	}

	public void setReInfo(String reInfo) {
		this.reInfo = reInfo;
	}

	public Long getOrgyxplanid() {
		return orgyxplanid;
	}

	public void setOrgyxplanid(Long orgyxplanid) {
		this.orgyxplanid = orgyxplanid;
	}

	public String getCopyitem() {
		return copyitem;
	}

	public void setCopyitem(String copyitem) {
		this.copyitem = copyitem;
	}

	public void setFixfeespecflag(String fixfeespecflag) {
		if (fixfeespecflag != null && fixfeespecflag.length() != 0) {
			seletefixfees = new String[9];
			for (int i = 0; i < 9; i++) {
				if (i >= fixfeespecflag.length())
					return;
				seletefixfees[i] = fixfeespecflag.substring(i, i + 1).equals(
						"0") ? "" : fixfeespecflags[i];
			}
		}

	}

	public String getFixfeespecflag() {
		String[] fixfeespecflags = getFixfeespecflags();
		String[] seletefixfees = getSeletefixfees();
		StringBuffer fixfeespecflag = new StringBuffer();
		for (int i = 0; i < fixfeespecflags.length; i++) {
			boolean equal = false;
			for (int j = 0; j < seletefixfees.length; j++) {
				if (fixfeespecflags[i].equals(seletefixfees[j])) {
					fixfeespecflag.append("1");
					equal = true;
					break;
				}
			}
			if (!equal)
				fixfeespecflag.append("0");
		}
		return fixfeespecflag.toString();
	}

	public String[] getSeletefixfees() {
		return seletefixfees;
	}

	public void setSeletefixfees(String[] seletefixfees) {
		this.seletefixfees = seletefixfees;
	}

	public String[] getFixfeespecflags() {
		return fixfeespecflags;
	}

	public Byte getUploadcalcfeekind() {
		return uploadcalcfeekind;
	}

	public void setUploadcalcfeekind(Byte uploadcalcfeekind) {
		this.uploadcalcfeekind = uploadcalcfeekind;
	}

	public String getFeeprio() {
		return feeprio;
	}

	public void setFeeprio(String feeprio) {
		this.feeprio = feeprio;
	}

	public String[] getSpecialflagName() {
		return specialflagName;
	}

	public void setSpecialflagName(String[] specialflagName) {
		this.specialflagName = specialflagName;
	}

	public String[] getSelectSpecialflag() {
		return selectSpecialflag;
	}

	public void setSelectSpecialflag(String[] selectSpecialflag) {
		this.selectSpecialflag = selectSpecialflag;
	}

	public String getBatchaction() {
		return batchaction;
	}

	public void setBatchaction(String batchaction) {
		this.batchaction = batchaction;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_ne_checkus() {
		return _ne_checkus;
	}

	public void set_ne_checkus(String _ne_checkus) {
		this._ne_checkus = _ne_checkus;
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

	public String[] getSelectuserstausflag() {

		return selectuserstausflag;
	}

	public void setSelectuserstausflag(String[] selectuserstausflag) {
		this.selectuserstausflag = selectuserstausflag;
	}

	public String[] getUserstausflagName() {
		return userstausflagName;
	}

	public void setUserstausflagName(String[] userstausflagName) {
		this.userstausflagName = userstausflagName;
	}

	public String[] getUserstausflagValue() {
		return userstausflagValue;
	}

	public void setUserstausflagValue(String[] userstausflagValue) {
		this.userstausflagValue = userstausflagValue;
	}

	public String get_ne_planbigkind() {
		return _ne_planbigkind;
	}

	public void set_ne_planbigkind(String _ne_planbigkind) {
		this._ne_planbigkind = _ne_planbigkind;
	}

	public Short getPlanbigkind() {
		return planbigkind;
	}

	public void setPlanbigkind(Short planbigkind) {
		this.planbigkind = planbigkind;
	}

	public String getPrivelgepro() {
		return privelgepro;
	}

	public void setPrivelgepro(String privelgepro) {
		this.privelgepro = privelgepro;
	}

	public String get_ne_plankind() {
		return _ne_plankind;
	}

	public void set_ne_plankind(String _ne_plankind) {
		this._ne_plankind = _ne_plankind;
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

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_dnl_stopdate() {
		return _dnl_stopdate;
	}

	public void set_dnl_stopdate(String _dnl_stopdate) {
		this._dnl_stopdate = _dnl_stopdate;
	}
	
}
