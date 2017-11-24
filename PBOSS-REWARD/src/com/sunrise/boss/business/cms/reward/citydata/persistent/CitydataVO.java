package com.sunrise.boss.business.cms.reward.citydata.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CitydataVO implements Serializable {

	private Long seq;
	private String calcmonth;
	private String opnid;
	private String wayid;
	private Date oprtime;
	private String oprcode;
	private String mobile;
	private Double busivalue;
	private Short brand;
	private String datasource;
	private Short validflag;
	private String remark;
	private Short rewardtype;
	private String cityid;
	private Date createtime;
	private String createcode;
	private String batchno;
	private String fileinfo;
	private String adtcode;
	private String adtremark;
	private Short state;
	
    /** full constructor */
    public CitydataVO() {
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Short getBrand() {
		return brand;
	}

	public void setBrand(Short brand) {
		this.brand = brand;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCreatecode() {
		return createcode;
	}

	public void setCreatecode(String createcode) {
		this.createcode = createcode;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getFileinfo() {
		return fileinfo;
	}

	public void setFileinfo(String fileinfo) {
		this.fileinfo = fileinfo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getValidflag() {
		return validflag;
	}

	public void setValidflag(Short validflag) {
		this.validflag = validflag;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getAdtcode() {
		return adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public String getAdtremark() {
		return adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

}
