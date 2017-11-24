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
	// ʡ��˾����
	private Double max_rewardstd;
	private Integer max_intvmonth;
	
	private Double max_city_rewardstd;
	private Integer max_city_intvmonth;

	private Long rewardid; // ����ʶ
	private String region; // ����
	private String opnid; // ҵ�����
	private Short acctype; // �Ƴ귽ʽ
	private Double rewardstd; // ����׼
	private Integer intvmonth; // ����·�
	private String ruleid; // У������ʶ
	private String opnname; // ҵ������
	private Short opnstate; // ҵ��״̬
	private String busibelong; // ҵ������ ��ҵ�����
	private Short ossrc;
	
	
	private boolean basicflag;
	private boolean encourageflag;

	// �������
	private Long rewardid_basic; // ����ʶ
	private String rewardname_basic; // �������
	private Short rewardtype_basic; // �������
	private String startdate_basic; // ��������
	private String stopdate_basic; // ͣ������
	private Double rewardstd_basic; // �������
	private String ruleid_basic; // У������ʶ
	private Short acctype_basic; // �Ƴ귽ʽ

	// �������
	private Long rewardid_encourage; // ����ʶ
	private String rewardname_encourage; // �������
	private Short rewardtype_encourage; // �������
	private String startdate_encourage; // ��������
	private String stopdate_encourage; // ͣ������
	private Double rewardstd_encourage; // �������
	private String ruleid_encourage; // У������ʶ
	private Integer intvmonth_encourage; // ����·�

	// ��������б� �����
	// com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO
	private List oldencouragelist = new ArrayList();
	private List newencouragelist = new ArrayList();

	// �����ڱ༭״̬ʱ����뽱�����ʱ��,��ʱ����������,�����ظ�
	private String rewardname_encourage_temp;

	// ��������
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
