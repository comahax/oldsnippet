package com.sunrise.boss.business.cms.reward.faildataquery.persistent;

import java.io.Serializable;
import java.util.Date;



public class FaildataqueryVO implements Serializable {
	private Long seq;
	private String calcmonth;
	private String opnid;
	private String name;//“业务名称”取CH_PW_OPERATION（公共库）的name字段，通过opnid关联；
	private String wayid;
	private String wayname;//“渠道名称”取CH_PW_WAY（公共库）的wayname字段，通过wayid关联；
	private String oprcode;
	private String mobile;
	private Date oprtime;
	private Date creattime;
	private String ruleid;
	private Short adtflag;
	private String adtcode;
	private String adtremark;//“失败原因”取CH_ADT_ADTCODE（公共库）的ADTREMARK字段，通过adtcode关联；
	private String rewardtype;
	private Short rewardflag;
	private String repairmonth;
	private String batchno;
	private String bakinfo;
	private String bakinfo2;
	private Short bakinfo3;
	private Double wrapfee;
	private String prodid;
	private Double bakinfo4;
	private Double bakinfo5;
	private String bakinfo6;
	private String bakinfo7;
	private String bakinfo8;
	private String bakinfo9;
	private String bakinfo10;  
    
	
//	public FaildataqueryVO(Long seq, String calcmonth, String opnid,
//			String name, String wayid, String wayname, String oprcode,
//			String mobile, Date oprtime, Date creattime, String ruleid,
//			Short adtflag, String adtcode, String adtremark, String rewardtype,
//			Short rewardflag, String repairmonth, String batchno, String bakinfo) {
//		super();
//		this.seq = seq;
//		this.calcmonth = calcmonth;
//		this.opnid = opnid;
//		this.name = name;
//		this.wayid = wayid;
//		this.wayname = wayname;
//		this.oprcode = oprcode;
//		this.mobile = mobile;
//		this.oprtime = oprtime;
//		this.creattime = creattime;
//		this.ruleid = ruleid;
//		this.adtflag = adtflag;
//		this.adtcode = adtcode;
//		this.adtremark = adtremark;
//		this.rewardtype = rewardtype;
//		this.rewardflag = rewardflag;
//		this.repairmonth = repairmonth;
//		this.batchno = batchno;
//		this.bakinfo = bakinfo;
//	}
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getAdtcode() {
		return adtcode;
	}
	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}
	public Short getAdtflag() {
		return adtflag;
	}
	public void setAdtflag(Short adtflag) {
		this.adtflag = adtflag;
	}
	public String getAdtremark() {
		return adtremark;
	}
	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}
	public String getCalcmonth() {
		return calcmonth;
	}
	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getWayname() {
		return wayname;
	}
	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	public Short getRewardflag() {
		return rewardflag;
	}
	public void setRewardflag(Short rewardflag) {
		this.rewardflag = rewardflag;
	}
	public String getRepairmonth() {
		return repairmonth;
	}
	public void setRepairmonth(String repairmonth) {
		this.repairmonth = repairmonth;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public String getBakinfo() {
		return bakinfo;
	}
	public void setBakinfo(String bakinfo) {
		this.bakinfo = bakinfo;
	}
	public String getBakinfo2() {
		return bakinfo2;
	}
	public void setBakinfo2(String bakinfo2) {
		this.bakinfo2 = bakinfo2;
	} 
//	public FaildataqueryVO(Long seq, String calcmonth, String opnid,
//			String name, String wayid, String wayname, String oprcode,
//			String mobile, Date oprtime, Date creattime, String ruleid,
//			Short adtflag, String adtcode, String adtremark, String rewardtype,
//			Short rewardflag, String repairmonth, String batchno,
//			String bakinfo, String bakinfo2, Double bakinfo3) {
//		super();
//		this.seq = seq;
//		this.calcmonth = calcmonth;
//		this.opnid = opnid;
//		this.name = name;
//		this.wayid = wayid;
//		this.wayname = wayname;
//		this.oprcode = oprcode;
//		this.mobile = mobile;
//		this.oprtime = oprtime;
//		this.creattime = creattime;
//		this.ruleid = ruleid;
//		this.adtflag = adtflag;
//		this.adtcode = adtcode;
//		this.adtremark = adtremark;
//		this.rewardtype = rewardtype;
//		this.rewardflag = rewardflag;
//		this.repairmonth = repairmonth;
//		this.batchno = batchno;
//		this.bakinfo = bakinfo;
//		this.bakinfo2 = bakinfo2;
//		this.bakinfo3 = bakinfo3;
//	}
	public Short getBakinfo3() {
		return bakinfo3;
	}
	public void setBakinfo3(Short bakinfo3) {
		this.bakinfo3 = bakinfo3;
	}

    public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public Double getBakinfo4() {
		return bakinfo4;
	}
	public void setBakinfo4(Double bakinfo4) {
		this.bakinfo4 = bakinfo4;
	}
	public Double getBakinfo5() {
		return bakinfo5;
	}
	public void setBakinfo5(Double bakinfo5) {
		this.bakinfo5 = bakinfo5;
	}
	public String getBakinfo6() {
		return bakinfo6;
	}
	public void setBakinfo6(String bakinfo6) {
		this.bakinfo6 = bakinfo6;
	}
	public String getBakinfo7() {
		return bakinfo7;
	}
	public void setBakinfo7(String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}
	public String getBakinfo8() {
		return bakinfo8;
	}
	public void setBakinfo8(String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}
	public String getBakinfo9() {
		return bakinfo9;
	}
	public void setBakinfo9(String bakinfo9) {
		this.bakinfo9 = bakinfo9;
	}
	public String getBakinfo10() {
		return bakinfo10;
	}
	public void setBakinfo10(String bakinfo10) {
		this.bakinfo10 = bakinfo10;
	}
}
