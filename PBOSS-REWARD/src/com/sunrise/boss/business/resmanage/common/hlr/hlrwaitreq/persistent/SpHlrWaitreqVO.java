package com.sunrise.boss.business.resmanage.common.hlr.hlrwaitreq.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SpHlrWaitreqVO implements Serializable {

	private Long streamno;

	private String mobileno;

	private String areacode;

	private Long netcellid;

	private Long backnetcellid;

	private Date creattime;

	private Date dealtime;

	private Long dealcount;

	private Long issuccess;

	private Long backissuccess;

	private String datas1;

	private String datas2;

	public Long getStreamno() {
		return this.streamno;
	}

	public void setStreamno(Long streamno) {
		this.streamno = streamno;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Long getNetcellid() {
		return this.netcellid;
	}

	public void setNetcellid(Long netcellid) {
		this.netcellid = netcellid;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public Long getDealcount() {
		return this.dealcount;
	}

	public void setDealcount(Long dealcount) {
		this.dealcount = dealcount;
	}

	public Long getIssuccess() {
		return this.issuccess;
	}

	public void setIssuccess(Long issuccess) {
		this.issuccess = issuccess;
	}

	public String getDatas1() {
		return this.datas1;
	}

	public void setDatas1(String datas1) {
		this.datas1 = datas1;
	}

	public String getDatas2() {
		return this.datas2;
	}

	public void setDatas2(String datas2) {
		this.datas2 = datas2;
	}

	public String toString() {
		return new ToStringBuilder(this).append("streamno", getStreamno())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof SpHlrWaitreqVO))
			return false;
		SpHlrWaitreqVO castOther = (SpHlrWaitreqVO) other;
		return new EqualsBuilder().append(this.getStreamno(),
				castOther.getStreamno()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getStreamno()).toHashCode();
	}

	public Long getBacknetcellid() {
		return backnetcellid;
	}

	public void setBacknetcellid(Long backcellid) {
		this.backnetcellid = backcellid;
	}

	public Long getBackissuccess() {
		return backissuccess;
	}

	public void setBackissuccess(Long backissuccess) {
		this.backissuccess = backissuccess;
	}
}
