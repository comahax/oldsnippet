package com.gmcc.pboss.business.reward.paydetaillog;

import java.io.Serializable;
import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class PaydetaillogVO extends BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7419746397924013550L;

	private Long seq;
	
	private String wayid;
	
	//主键
	private Long logid;
	
	//操作时间
	private Date optime;
	
	//操作员工号
	private String oprcode;
	
	private String oprtype;
	
	private String success;
	 
	
	private String mobile;
	
	private String opmonth;
	
	private String calcmonth;
	
	private String type;

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

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOpmonth() {
		return opmonth;
	}

	public void setOpmonth(String opmonth) {
		this.opmonth = opmonth;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
