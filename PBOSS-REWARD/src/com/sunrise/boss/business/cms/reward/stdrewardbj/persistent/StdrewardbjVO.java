package com.sunrise.boss.business.cms.reward.stdrewardbj.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardbjVO implements OperationLog {
	public Class logVOClass() {
		return StdrewardbjlogVO.class;
	}

	/** identifier field */
	private String region; //����

	/** identifier field */
	private Long rewardid; //����ʶ

	/** persistent field */
	private String opnid; //ҵ�����

	/** nullable persistent field */
	private Short acctype; //�Ƴ귽ʽ

	/** nullable persistent field */
	private Double rewardstd; //����׼

	/** nullable persistent field */
	private Integer intvmonth; //����·�

	/** nullable persistent field */
	private String ruleid; //У������ʶ
	
	//extend fields
	private String rewardname; //�������
	private Short rewardtype; //�������
	private java.util.Date startdate; //��������
	private java.util.Date stopdate; //ͣ������
    private Short rewardproj; // �����Ŀ
    private boolean deletefalg; //ɾ����ʶ
    private Long temprewardid; //��ʱ����ʶ
    
    private boolean isProvincial; //�����洢ʡ����֮ǰ������

	public boolean isProvincial() {
		return isProvincial;
	}

	public void setProvincial(boolean isProvincial) {
		this.isProvincial = isProvincial;
	}

	/** full constructor */
	public StdrewardbjVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid, java.lang.Short acctype,
			java.lang.Double rewardstd, java.lang.Integer intvmonth,
			java.lang.String ruleid) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
		this.acctype = acctype;
		this.rewardstd = rewardstd;
		this.intvmonth = intvmonth;
		this.ruleid = ruleid;
	}

	/** default constructor */
	public StdrewardbjVO() {
	}

	/** minimal constructor */
	public StdrewardbjVO(java.lang.String region, java.lang.Long rewardid,
			java.lang.String opnid) {
		this.region = region;
		this.rewardid = rewardid;
		this.opnid = opnid;
	}

	public java.lang.String getRegion() {
		return this.region;
	}

	public void setRegion(java.lang.String region) {
		this.region = region;
	}

	public java.lang.Long getRewardid() {
		return this.rewardid;
	}

	public void setRewardid(java.lang.Long rewardid) {
		this.rewardid = rewardid;
	}

	public java.lang.String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(java.lang.String opnid) {
		this.opnid = opnid;
	}

	public java.lang.Short getAcctype() {
		return this.acctype;
	}

	public void setAcctype(java.lang.Short acctype) {
		this.acctype = acctype;
	}

	public java.lang.Double getRewardstd() {
		return this.rewardstd;
	}

	public void setRewardstd(java.lang.Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public java.lang.Integer getIntvmonth() {
		return this.intvmonth;
	}

	public void setIntvmonth(java.lang.Integer intvmonth) {
		this.intvmonth = intvmonth;
	}

	public java.lang.String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(java.lang.String ruleid) {
		this.ruleid = ruleid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("region", getRegion()).append(
				"rewardid", getRewardid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof StdrewardbjVO))
			return false;
		StdrewardbjVO castOther = (StdrewardbjVO) other;
		return new EqualsBuilder().append(this.getRegion(),
				castOther.getRegion()).append(this.getRewardid(),
				castOther.getRewardid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRegion()).append(getRewardid())
				.toHashCode();
	}

	public String getRewardname() {
		return rewardname;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
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

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public boolean isDeletefalg() {
		return deletefalg;
	}

	public void setDeletefalg(boolean deletefalg) {
		this.deletefalg = deletefalg;
	}

	public Long getTemprewardid() {
		return temprewardid;
	}

	public void setTemprewardid(Long temprewardid) {
		this.temprewardid = temprewardid;
	}
}
