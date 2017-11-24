package com.sunrise.boss.ui.cms.zjty.zjtystdrewardbj;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtyStdrewardbjForm extends BaseActionForm {
	
	private Long rewardid; //酬金标识
	private String region; //区域
	private String opnid; //业务代码
	private Short acctype; //计酬方式
	private Double rewardstd; //酬金标准
	private Integer intvmonth; //间隔月份
	private String ruleid; //校验规则标识
	private String wayid; //渠道代码
	
	private String opnname; //业务名称
    private Short opnstate; //业务状态
    private String busibelong; //业务类型 即业务归属
	
	//酬金存在标识
	private boolean fixedflag;
	private boolean integralflag;
	private boolean allowanceflag;
	private boolean basicflag;
	private boolean encourageflag;
	
	//固定酬金
	private Long rewardid_fixed; //酬金标识
	private String rewardname_fixed; //酬金名称
	private Short rewardtype_fixed; //酬金类型
	private String startdate_fixed; //启用日期
	private String stopdate_fixed; //停用日期
	private Double rewardstd_fixed; //酬金上限
	private String ruleid_fixed; //校验规则标识
	private Integer intvmonth_fixed; //间隔月份
	
	private Double rewardstd_fixed_limited;//市公司页面的时候使用,将省公司的酬金上限放到客户端验证
	private Integer intvmonth_fixed_limited; //市公司页面的时候使用,将省公司的间隔月份放到客户端验证
	
	//积分酬金
	private Long rewardid_integral; //酬金标识
	private String rewardname_integral; //酬金名称
	private Short rewardtype_integral; //酬金类型
	private String startdate_integral; //启用日期
	private String stopdate_integral; //停用日期
	private Double rewardstd_integral; //酬金上限
	private String ruleid_integral; //校验规则标识
	private Integer intvmonth_integral; //间隔月份
	
	private Double rewardstd_integral_limited;//市公司页面的时候使用,将省公司的酬金上限放到客户端验证
	private Integer intvmonth_integral_limited; //市公司页面的时候使用,将省公司的间隔月份放到客户端验证
	
	//专门津贴
	private Long rewardid_allowance; //酬金标识
	private String rewardname_allowance; //酬金名称
	private Short rewardtype_allowance; //酬金类型
	private String startdate_allowance; //启用日期
	private String stopdate_allowance; //停用日期
	private Double rewardstd_allowance; //酬金上限
	private String ruleid_allowance; //校验规则标识
	private Integer intvmonth_allowance; //间隔月份
	
	private Double rewardstd_allowance_limited;//市公司页面的时候使用,将省公司的酬金上限放到客户端验证
	private Integer intvmonth_allowance_limited; //市公司页面的时候使用,将省公司的间隔月份放到客户端验证
	
	//基本酬金
	private Long rewardid_basic; //酬金标识
	private String rewardname_basic; //酬金名称
	private Short rewardtype_basic; //酬金类型
	private String startdate_basic; //启用日期
	private String stopdate_basic; //停用日期
	private Double rewardstd_basic; //酬金上限
	private String ruleid_basic; //校验规则标识
	private Short acctype_basic; //计酬方式
	private Integer intvmonth_basic; //间隔月份
	
	private Double rewardstd_basic_limited;//市公司页面的时候使用,将省公司的酬金上限放到客户端验证
	private Integer intvmonth_basic_limited; //市公司页面的时候使用,将省公司的间隔月份放到客户端验证
	
	//奖励酬金
	private Long rewardid_encourage; //酬金标识
	private String rewardname_encourage; //酬金名称
	private Short rewardtype_encourage; //酬金类型
	private String startdate_encourage; //启用日期
	private String stopdate_encourage; //停用日期
	private Double rewardstd_encourage; //酬金上限
	private String ruleid_encourage; //校验规则标识
	private Integer intvmonth_encourage; //间隔月份
	
	private Double rewardstd_encourage_limited;//市公司页面的时候使用,将省公司的酬金上限放到客户端验证
	private Integer intvmonth_encourage_limited; //市公司页面的时候使用,将省公司的间隔月份放到客户端验证
	
	private List oldencouragelist = new ArrayList();
	private List newencouragelist = new ArrayList();
	
	//当用于编辑状态时候存入奖励酬金时候,临时存入酬金名称,以免重复
	private String rewardname_encourage_temp;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		rewardid = null; //酬金标识
		region = null; //区域
		acctype = null; //计酬方式
		rewardstd = null; //酬金标准
		intvmonth = null; //间隔月份
		ruleid = null; //校验规则标识

		fixedflag = false;
		integralflag = false;
		allowanceflag = false;
		basicflag = false;
		encourageflag = false;

		rewardid_fixed = null; //酬金标识
		rewardname_fixed = null; //酬金名称
		rewardtype_fixed = null; //酬金类型
		startdate_fixed = null; //启用日期
		stopdate_fixed = null; //停用日期
		rewardstd_fixed = null; //酬金上限
		ruleid_fixed = null; //校验规则标识
		intvmonth_fixed = null; //间隔月份

		rewardid_integral = null; //酬金标识
		rewardname_integral = null; //酬金名称
		rewardtype_integral = null; //酬金类型
		startdate_integral = null; //启用日期
		stopdate_integral = null; //停用日期
		rewardstd_integral = null; //酬金上限
		ruleid_integral = null; //校验规则标识
		intvmonth_integral = null; //间隔月份

		rewardid_allowance = null; //酬金标识
		rewardname_allowance = null; //酬金名称
		rewardtype_allowance = null; //酬金类型
		startdate_allowance = null; //启用日期
		stopdate_allowance = null; //停用日期
		rewardstd_allowance = null; //酬金上限
		ruleid_allowance = null; //校验规则标识
		intvmonth_allowance = null; //间隔月份

		rewardid_basic = null; //酬金标识
		rewardname_basic = null; //酬金名称
		rewardtype_basic = null; //酬金类型
		startdate_basic = null; //启用日期
		stopdate_basic = null; //停用日期
		rewardstd_basic = null; //酬金上限
		ruleid_basic = null; //校验规则标识
		acctype_basic = null; //计酬方式
		intvmonth_basic = null; //间隔月份

		rewardid_encourage = null; //酬金标识
		rewardname_encourage = null; //酬金名称
		rewardtype_encourage = null; //酬金类型
		startdate_encourage = null; //启用日期
		stopdate_encourage = null; //停用日期
		rewardstd_encourage = null; //酬金上限
		ruleid_encourage = null; //校验规则标识
		intvmonth_encourage = null; //间隔月份

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
