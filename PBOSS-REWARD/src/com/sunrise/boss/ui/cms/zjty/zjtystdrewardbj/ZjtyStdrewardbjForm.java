package com.sunrise.boss.ui.cms.zjty.zjtystdrewardbj;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtyStdrewardbjForm extends BaseActionForm {
	
	private Long rewardid; //����ʶ
	private String region; //����
	private String opnid; //ҵ�����
	private Short acctype; //�Ƴ귽ʽ
	private Double rewardstd; //����׼
	private Integer intvmonth; //����·�
	private String ruleid; //У������ʶ
	private String wayid; //��������
	
	private String opnname; //ҵ������
    private Short opnstate; //ҵ��״̬
    private String busibelong; //ҵ������ ��ҵ�����
	
	//�����ڱ�ʶ
	private boolean fixedflag;
	private boolean integralflag;
	private boolean allowanceflag;
	private boolean basicflag;
	private boolean encourageflag;
	
	//�̶����
	private Long rewardid_fixed; //����ʶ
	private String rewardname_fixed; //�������
	private Short rewardtype_fixed; //�������
	private String startdate_fixed; //��������
	private String stopdate_fixed; //ͣ������
	private Double rewardstd_fixed; //�������
	private String ruleid_fixed; //У������ʶ
	private Integer intvmonth_fixed; //����·�
	
	private Double rewardstd_fixed_limited;//�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ĳ�����޷ŵ��ͻ�����֤
	private Integer intvmonth_fixed_limited; //�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ļ���·ݷŵ��ͻ�����֤
	
	//���ֳ��
	private Long rewardid_integral; //����ʶ
	private String rewardname_integral; //�������
	private Short rewardtype_integral; //�������
	private String startdate_integral; //��������
	private String stopdate_integral; //ͣ������
	private Double rewardstd_integral; //�������
	private String ruleid_integral; //У������ʶ
	private Integer intvmonth_integral; //����·�
	
	private Double rewardstd_integral_limited;//�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ĳ�����޷ŵ��ͻ�����֤
	private Integer intvmonth_integral_limited; //�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ļ���·ݷŵ��ͻ�����֤
	
	//ר�Ž���
	private Long rewardid_allowance; //����ʶ
	private String rewardname_allowance; //�������
	private Short rewardtype_allowance; //�������
	private String startdate_allowance; //��������
	private String stopdate_allowance; //ͣ������
	private Double rewardstd_allowance; //�������
	private String ruleid_allowance; //У������ʶ
	private Integer intvmonth_allowance; //����·�
	
	private Double rewardstd_allowance_limited;//�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ĳ�����޷ŵ��ͻ�����֤
	private Integer intvmonth_allowance_limited; //�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ļ���·ݷŵ��ͻ�����֤
	
	//�������
	private Long rewardid_basic; //����ʶ
	private String rewardname_basic; //�������
	private Short rewardtype_basic; //�������
	private String startdate_basic; //��������
	private String stopdate_basic; //ͣ������
	private Double rewardstd_basic; //�������
	private String ruleid_basic; //У������ʶ
	private Short acctype_basic; //�Ƴ귽ʽ
	private Integer intvmonth_basic; //����·�
	
	private Double rewardstd_basic_limited;//�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ĳ�����޷ŵ��ͻ�����֤
	private Integer intvmonth_basic_limited; //�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ļ���·ݷŵ��ͻ�����֤
	
	//�������
	private Long rewardid_encourage; //����ʶ
	private String rewardname_encourage; //�������
	private Short rewardtype_encourage; //�������
	private String startdate_encourage; //��������
	private String stopdate_encourage; //ͣ������
	private Double rewardstd_encourage; //�������
	private String ruleid_encourage; //У������ʶ
	private Integer intvmonth_encourage; //����·�
	
	private Double rewardstd_encourage_limited;//�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ĳ�����޷ŵ��ͻ�����֤
	private Integer intvmonth_encourage_limited; //�й�˾ҳ���ʱ��ʹ��,��ʡ��˾�ļ���·ݷŵ��ͻ�����֤
	
	private List oldencouragelist = new ArrayList();
	private List newencouragelist = new ArrayList();
	
	//�����ڱ༭״̬ʱ����뽱�����ʱ��,��ʱ����������,�����ظ�
	private String rewardname_encourage_temp;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		rewardid = null; //����ʶ
		region = null; //����
		acctype = null; //�Ƴ귽ʽ
		rewardstd = null; //����׼
		intvmonth = null; //����·�
		ruleid = null; //У������ʶ

		fixedflag = false;
		integralflag = false;
		allowanceflag = false;
		basicflag = false;
		encourageflag = false;

		rewardid_fixed = null; //����ʶ
		rewardname_fixed = null; //�������
		rewardtype_fixed = null; //�������
		startdate_fixed = null; //��������
		stopdate_fixed = null; //ͣ������
		rewardstd_fixed = null; //�������
		ruleid_fixed = null; //У������ʶ
		intvmonth_fixed = null; //����·�

		rewardid_integral = null; //����ʶ
		rewardname_integral = null; //�������
		rewardtype_integral = null; //�������
		startdate_integral = null; //��������
		stopdate_integral = null; //ͣ������
		rewardstd_integral = null; //�������
		ruleid_integral = null; //У������ʶ
		intvmonth_integral = null; //����·�

		rewardid_allowance = null; //����ʶ
		rewardname_allowance = null; //�������
		rewardtype_allowance = null; //�������
		startdate_allowance = null; //��������
		stopdate_allowance = null; //ͣ������
		rewardstd_allowance = null; //�������
		ruleid_allowance = null; //У������ʶ
		intvmonth_allowance = null; //����·�

		rewardid_basic = null; //����ʶ
		rewardname_basic = null; //�������
		rewardtype_basic = null; //�������
		startdate_basic = null; //��������
		stopdate_basic = null; //ͣ������
		rewardstd_basic = null; //�������
		ruleid_basic = null; //У������ʶ
		acctype_basic = null; //�Ƴ귽ʽ
		intvmonth_basic = null; //����·�

		rewardid_encourage = null; //����ʶ
		rewardname_encourage = null; //�������
		rewardtype_encourage = null; //�������
		startdate_encourage = null; //��������
		stopdate_encourage = null; //ͣ������
		rewardstd_encourage = null; //�������
		ruleid_encourage = null; //У������ʶ
		intvmonth_encourage = null; //����·�

		oldencouragelist = new ArrayList();
		newencouragelist = new ArrayList();
	}

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

	public Long getRewardid_allowance() {
		return rewardid_allowance;
	}

	public void setRewardid_allowance(Long rewardid_allowance) {
		this.rewardid_allowance = rewardid_allowance;
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

	public Long getRewardid_fixed() {
		return rewardid_fixed;
	}

	public void setRewardid_fixed(Long rewardid_fixed) {
		this.rewardid_fixed = rewardid_fixed;
	}

	public Long getRewardid_integral() {
		return rewardid_integral;
	}

	public void setRewardid_integral(Long rewardid_integral) {
		this.rewardid_integral = rewardid_integral;
	}

	public String getRewardname_allowance() {
		return rewardname_allowance;
	}

	public void setRewardname_allowance(String rewardname_allowance) {
		this.rewardname_allowance = rewardname_allowance;
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

	public String getRewardname_fixed() {
		return rewardname_fixed;
	}

	public void setRewardname_fixed(String rewardname_fixed) {
		this.rewardname_fixed = rewardname_fixed;
	}

	public String getRewardname_integral() {
		return rewardname_integral;
	}

	public void setRewardname_integral(String rewardname_integral) {
		this.rewardname_integral = rewardname_integral;
	}

	public Double getRewardstd_allowance() {
		return rewardstd_allowance;
	}

	public void setRewardstd_allowance(Double rewardstd_allowance) {
		this.rewardstd_allowance = rewardstd_allowance;
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

	public Double getRewardstd_fixed() {
		return rewardstd_fixed;
	}

	public void setRewardstd_fixed(Double rewardstd_fixed) {
		this.rewardstd_fixed = rewardstd_fixed;
	}

	public Double getRewardstd_integral() {
		return rewardstd_integral;
	}

	public void setRewardstd_integral(Double rewardstd_integral) {
		this.rewardstd_integral = rewardstd_integral;
	}

	public Short getRewardtype_allowance() {
		return rewardtype_allowance;
	}

	public void setRewardtype_allowance(Short rewardtype_allowance) {
		this.rewardtype_allowance = rewardtype_allowance;
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

	public Short getRewardtype_fixed() {
		return rewardtype_fixed;
	}

	public void setRewardtype_fixed(Short rewardtype_fixed) {
		this.rewardtype_fixed = rewardtype_fixed;
	}

	public Short getRewardtype_integral() {
		return rewardtype_integral;
	}

	public void setRewardtype_integral(Short rewardtype_integral) {
		this.rewardtype_integral = rewardtype_integral;
	}

	public String getRuleid_allowance() {
		return ruleid_allowance;
	}

	public void setRuleid_allowance(String ruleid_allowance) {
		this.ruleid_allowance = ruleid_allowance;
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

	public String getRuleid_fixed() {
		return ruleid_fixed;
	}

	public void setRuleid_fixed(String ruleid_fixed) {
		this.ruleid_fixed = ruleid_fixed;
	}

	public String getRuleid_integral() {
		return ruleid_integral;
	}

	public void setRuleid_integral(String ruleid_integral) {
		this.ruleid_integral = ruleid_integral;
	}

	public String getStartdate_allowance() {
		return startdate_allowance;
	}

	public void setStartdate_allowance(String startdate_allowance) {
		this.startdate_allowance = startdate_allowance;
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

	public String getStartdate_fixed() {
		return startdate_fixed;
	}

	public void setStartdate_fixed(String startdate_fixed) {
		this.startdate_fixed = startdate_fixed;
	}

	public String getStartdate_integral() {
		return startdate_integral;
	}

	public void setStartdate_integral(String startdate_integral) {
		this.startdate_integral = startdate_integral;
	}

	public String getStopdate_allowance() {
		return stopdate_allowance;
	}

	public void setStopdate_allowance(String stopdate_allowance) {
		this.stopdate_allowance = stopdate_allowance;
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

	public String getStopdate_fixed() {
		return stopdate_fixed;
	}

	public void setStopdate_fixed(String stopdate_fixed) {
		this.stopdate_fixed = stopdate_fixed;
	}

	public String getStopdate_integral() {
		return stopdate_integral;
	}

	public void setStopdate_integral(String stopdate_integral) {
		this.stopdate_integral = stopdate_integral;
	}

	public boolean isAllowanceflag() {
		return allowanceflag;
	}

	public void setAllowanceflag(boolean allowanceflag) {
		this.allowanceflag = allowanceflag;
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

	public boolean isFixedflag() {
		return fixedflag;
	}

	public void setFixedflag(boolean fixedflag) {
		this.fixedflag = fixedflag;
	}

	public boolean isIntegralflag() {
		return integralflag;
	}

	public void setIntegralflag(boolean integralflag) {
		this.integralflag = integralflag;
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

	public Integer getIntvmonth_allowance() {
		return intvmonth_allowance;
	}

	public void setIntvmonth_allowance(Integer intvmonth_allowance) {
		this.intvmonth_allowance = intvmonth_allowance;
	}

	public Integer getIntvmonth_basic() {
		return intvmonth_basic;
	}

	public void setIntvmonth_basic(Integer intvmonth_basic) {
		this.intvmonth_basic = intvmonth_basic;
	}

	public Integer getIntvmonth_fixed() {
		return intvmonth_fixed;
	}

	public void setIntvmonth_fixed(Integer intvmonth_fixed) {
		this.intvmonth_fixed = intvmonth_fixed;
	}

	public Integer getIntvmonth_integral() {
		return intvmonth_integral;
	}

	public void setIntvmonth_integral(Integer intvmonth_integral) {
		this.intvmonth_integral = intvmonth_integral;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getRewardname_encourage_temp() {
		return rewardname_encourage_temp;
	}

	public void setRewardname_encourage_temp(String rewardname_encourage_temp) {
		this.rewardname_encourage_temp = rewardname_encourage_temp;
	}

	public Double getRewardstd_fixed_limited() {
		return rewardstd_fixed_limited;
	}

	public void setRewardstd_fixed_limited(Double rewardstd_fixed_limited) {
		this.rewardstd_fixed_limited = rewardstd_fixed_limited;
	}

	public Integer getIntvmonth_fixed_limited() {
		return intvmonth_fixed_limited;
	}

	public void setIntvmonth_fixed_limited(Integer intvmonth_fixed_limited) {
		this.intvmonth_fixed_limited = intvmonth_fixed_limited;
	}

	public Double getRewardstd_integral_limited() {
		return rewardstd_integral_limited;
	}

	public void setRewardstd_integral_limited(Double rewardstd_integral_limited) {
		this.rewardstd_integral_limited = rewardstd_integral_limited;
	}

	public Integer getIntvmonth_integral_limited() {
		return intvmonth_integral_limited;
	}

	public void setIntvmonth_integral_limited(Integer intvmonth_integral_limited) {
		this.intvmonth_integral_limited = intvmonth_integral_limited;
	}

	public Double getRewardstd_allowance_limited() {
		return rewardstd_allowance_limited;
	}

	public void setRewardstd_allowance_limited(Double rewardstd_allowance_limited) {
		this.rewardstd_allowance_limited = rewardstd_allowance_limited;
	}

	public Integer getIntvmonth_allowance_limited() {
		return intvmonth_allowance_limited;
	}

	public void setIntvmonth_allowance_limited(Integer intvmonth_allowance_limited) {
		this.intvmonth_allowance_limited = intvmonth_allowance_limited;
	}

	public Double getRewardstd_basic_limited() {
		return rewardstd_basic_limited;
	}

	public void setRewardstd_basic_limited(Double rewardstd_basic_limited) {
		this.rewardstd_basic_limited = rewardstd_basic_limited;
	}

	public Integer getIntvmonth_basic_limited() {
		return intvmonth_basic_limited;
	}

	public void setIntvmonth_basic_limited(Integer intvmonth_basic_limited) {
		this.intvmonth_basic_limited = intvmonth_basic_limited;
	}

	public Double getRewardstd_encourage_limited() {
		return rewardstd_encourage_limited;
	}

	public void setRewardstd_encourage_limited(Double rewardstd_encourage_limited) {
		this.rewardstd_encourage_limited = rewardstd_encourage_limited;
	}

	public Integer getIntvmonth_encourage_limited() {
		return intvmonth_encourage_limited;
	}

	public void setIntvmonth_encourage_limited(Integer intvmonth_encourage_limited) {
		this.intvmonth_encourage_limited = intvmonth_encourage_limited;
	}
}
