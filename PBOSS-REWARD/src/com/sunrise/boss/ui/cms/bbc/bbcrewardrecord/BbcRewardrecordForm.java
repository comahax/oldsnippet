/**
 * auto-generated code
 * Mon Dec 08 10:50:04 CST 2008
 */
package com.sunrise.boss.ui.cms.bbc.bbcrewardrecord;

import java.util.Date;
import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: WayintegraltransruleForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardrecordForm extends BaseActionForm {

	private Long rewardlistid;

	private String operseq;

	private String datasrc;

	private String opnid;

	private String wayid;

	private String wayoprcode;

	private Long rewardid;

	private Long rewardtype;

	private Double rewardstd;

	private String rewardmonth;

	private Double totalsum;

	private Double paysum;

	private Date runtime;

	private String wayname;

	private String countycompname;

	private Long noncyc;

	private Date oprtime;

	private Long starlevel;

	private Integer ossrc;

	private String mobile;
	
	private String batchno;

	private String _se_wayid;
	
	private String _se_batchno;

	private String _ne_rewardid;

	private String _ne_rewardtype;

	private String _se_rewardmonth;

	private String _se_wayoprcode;

	private String _se_opnid;

	private String _se_ossrc;

	private String _sql_ossrc = "ossrc in ('0','1','2')";
	
	private List _sin_batchno;

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String get_sql_ossrc() {
		return _sql_ossrc;
	}

	public void set_sql_ossrc(String _sql_ossrc) {
		this._sql_ossrc = _sql_ossrc;
	}

	public String get_se_ossrc() {
		return _se_ossrc;
	}

	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}

	public Long getRewardlistid() {
		return rewardlistid;
	}

	public void setRewardlistid(Long rewardlistid) {
		this.rewardlistid = rewardlistid;
	}

	public String getOperseq() {
		return operseq;
	}

	public void setOperseq(String operseq) {
		this.operseq = operseq;
	}

	public String getDatasrc() {
		return datasrc;
	}

	public void setDatasrc(String datasrc) {
		this.datasrc = datasrc;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayoprcode() {
		return wayoprcode;
	}

	public void setWayoprcode(String wayoprcode) {
		this.wayoprcode = wayoprcode;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Long getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public Double getTotalsum() {
		return totalsum;
	}

	public void setTotalsum(Double totalsum) {
		this.totalsum = totalsum;
	}

	public Double getPaysum() {
		return paysum;
	}

	public void setPaysum(Double paysum) {
		this.paysum = paysum;
	}

	public Date getRuntime() {
		return runtime;
	}

	public void setRuntime(Date runtime) {
		this.runtime = runtime;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public String get_se_wayoprcode() {
		return _se_wayoprcode;
	}

	public void set_se_wayoprcode(String _se_wayoprcode) {
		this._se_wayoprcode = _se_wayoprcode;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String getCountycompname() {
		return countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public Long getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Integer getOssrc() {
		return ossrc;
	}

	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public List get_sin_batchno() {
		return _sin_batchno;
	}

	public void set_sin_batchno(List _sin_batchno) {
		this._sin_batchno = _sin_batchno;
	}

}
