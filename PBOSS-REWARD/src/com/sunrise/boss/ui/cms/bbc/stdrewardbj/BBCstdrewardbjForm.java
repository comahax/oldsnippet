package com.sunrise.boss.ui.cms.bbc.stdrewardbj;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.CMSUtils;

/**
 * <p>
 * Title: StdrewardbjForm
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
 * @author Linli modify 1.1
 * @version 1.1
 */
public class BBCstdrewardbjForm extends BaseActionForm {
	// 省公司上限
	private Double max_rewardstd;
	private Integer max_intvmonth;
	
	private Double max_city_rewardstd;
	private Integer max_city_intvmonth;

	private Long rewardid; // 酬金标识
	private String region; // 区域
	private String opnid; // 业务代码
	private Short acctype; // 计酬方式
	private Double rewardstd; // 酬金标准
	private Integer intvmonth; // 间隔月份
	private String ruleid; // 校验规则标识
	private String opnname; // 业务名称
	private Short opnstate; // 业务状态
	private String busibelong; // 业务类型 即业务归属
	private Short ossrc;
	
	
	private boolean basicflag;
	private boolean encourageflag;

	// 基本酬金
	private Long rewardid_basic; // 酬金标识
	private String rewardname_basic; // 酬金名称
	private Short rewardtype_basic; // 酬金类型
	private String startdate_basic; // 启用日期
	private String stopdate_basic; // 停用日期
	private Double rewardstd_basic; // 酬金上限
	private String ruleid_basic; // 校验规则标识
	private Short acctype_basic; // 计酬方式

	// 奖励酬金
	private Long rewardid_encourage; // 酬金标识
	private String rewardname_encourage; // 酬金名称
	private Short rewardtype_encourage; // 酬金类型
	private String startdate_encourage; // 启用日期
	private String stopdate_encourage; // 停用日期
	private Double rewardstd_encourage; // 酬金上限
	private String ruleid_encourage; // 校验规则标识
	private Integer intvmonth_encourage; // 间隔月份

	// 奖励酬金列表 存放类
	// com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO
	private List oldencouragelist = new ArrayList();
	private List newencouragelist = new ArrayList();

	// 当用于编辑状态时候存入奖励酬金时候,临时存入酬金名称,以免重复
	private String rewardname_encourage_temp;

	// 酬金大类型
	private Short rewardproj;
	
	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public Integer getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Integer intvmonth) {
		this.intvmonth = intvmonth;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public Short getAcctype_basic() {
		return acctype_basic;
	}

	public void setAcctype_basic(Short acctype_basic) {
		this.acctype_basic = acctype_basic;
	}

	public Integer getIntvmonth_encourage() {
		return intvmonth_encourage;
	}

	public void setIntvmonth_encourage(Integer intvmonth_encourage) {
		this.intvmonth_encourage = intvmonth_encourage;
	}

	public Long getRewardid_basic() {
		return rewardid_basic;
	}

	public void setRewardid_basic(Long rewardid_basic) {
		this.rewardid_basic = rewardid_basic;
	}

	public Long getRewardid_encourage() {
		return rewardid_encourage;
	}

	public void setRewardid_encourage(Long rewardid_encourage) {
		this.rewardid_encourage = rewardid_encourage;
	}

	public String getRewardname_basic() {
		return rewardname_basic;
	}

	public void setRewardname_basic(String rewardname_basic) {
		this.rewardname_basic = rewardname_basic;
	}

	public String getRewardname_encourage() {
		return rewardname_encourage;
	}

	public void setRewardname_encourage(String rewardname_encourage) {
		this.rewardname_encourage = rewardname_encourage;
	}

	public Double getRewardstd_basic() {
		return rewardstd_basic;
	}

	public void setRewardstd_basic(Double rewardstd_basic) {
		this.rewardstd_basic = rewardstd_basic;
	}

	public Double getRewardstd_encourage() {
		return rewardstd_encourage;
	}

	public void setRewardstd_encourage(Double rewardstd_encourage) {
		this.rewardstd_encourage = rewardstd_encourage;
	}

	public Short getRewardtype_basic() {
		return rewardtype_basic;
	}

	public void setRewardtype_basic(Short rewardtype_basic) {
		this.rewardtype_basic = rewardtype_basic;
	}

	public Short getRewardtype_encourage() {
		return rewardtype_encourage;
	}

	public void setRewardtype_encourage(Short rewardtype_encourage) {
		this.rewardtype_encourage = rewardtype_encourage;
	}

	public String getRuleid_basic() {
		return ruleid_basic;
	}

	public void setRuleid_basic(String ruleid_basic) {
		this.ruleid_basic = ruleid_basic;
	}

	public String getRuleid_encourage() {
		return ruleid_encourage;
	}

	public void setRuleid_encourage(String ruleid_encourage) {
		this.ruleid_encourage = ruleid_encourage;
	}

	public String getStartdate_basic() {
		return startdate_basic;
	}

	public void setStartdate_basic(String startdate_basic) {
		this.startdate_basic = startdate_basic;
	}

	public String getStartdate_encourage() {
		return startdate_encourage;
	}

	public void setStartdate_encourage(String startdate_encourage) {
		this.startdate_encourage = startdate_encourage;
	}

	public String getStopdate_basic() {
		return stopdate_basic;
	}

	public void setStopdate_basic(String stopdate_basic) {
		this.stopdate_basic = stopdate_basic;
	}

	public String getStopdate_encourage() {
		return stopdate_encourage;
	}

	public void setStopdate_encourage(String stopdate_encourage) {
		this.stopdate_encourage = stopdate_encourage;
	}

	public boolean isBasicflag() {
		return basicflag;
	}

	public void setBasicflag(boolean basicflag) {
		this.basicflag = basicflag;
	}

	public boolean isEncourageflag() {
		return encourageflag;
	}

	public void setEncourageflag(boolean encourageflag) {
		this.encourageflag = encourageflag;
	}

	public List getOldencouragelist() {
		return oldencouragelist;
	}

	public void setOldencouragelist(List oldencouragelist) {
		this.oldencouragelist = oldencouragelist;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public List getNewencouragelist() {
		return newencouragelist;
	}

	public void setNewencouragelist(List newencouragelist) {
		this.newencouragelist = newencouragelist;
	}

	public String getBusibelong() {
		return busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	public Short getOpnstate() {
		return opnstate;
	}

	public void setOpnstate(Short opnstate) {
		this.opnstate = opnstate;
	}

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public String getRewardname_encourage_temp() {
		return rewardname_encourage_temp;
	}

	public void setRewardname_encourage_temp(String rewardname_encourage_temp) {
		this.rewardname_encourage_temp = rewardname_encourage_temp;
	}

	public Integer getMax_intvmonth() {
		return max_intvmonth;
	}

	public void setMax_intvmonth(Integer max_intvmonth) {
		this.max_intvmonth = max_intvmonth;
	}

	public Double getMax_rewardstd() {
		return max_rewardstd;
	}

	public void setMax_rewardstd(Double max_rewardstd) {
		this.max_rewardstd = max_rewardstd;
	}

	public Double getMax_city_rewardstd() {
		return max_city_rewardstd;
	}

	public void setMax_city_rewardstd(Double max_city_rewardstd) {
		this.max_city_rewardstd = max_city_rewardstd;
	}

	public Integer getMax_city_intvmonth() {
		return max_city_intvmonth;
	}

	public void setMax_city_intvmonth(Integer max_city_intvmonth) {
		this.max_city_intvmonth = max_city_intvmonth;
	}

	public Short getOssrc() {
		return ossrc;
	}

	public void setOssrc(Short ossrc) {
		this.ossrc = ossrc;
	}
}
