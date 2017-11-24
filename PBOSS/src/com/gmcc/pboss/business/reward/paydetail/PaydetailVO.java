package com.gmcc.pboss.business.reward.paydetail;


import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

public class PaydetailVO extends BaseVO  implements BusinessLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6673051707596731247L;

	//主键
	private Long seq;

	
	private String wayid;
	
	
	
	// MEI/号码
	private String mobile;
	
	//业务月
	private String opmonth;
	
	//结算月
	private String calcmonth;
	
	//酬金类型
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

	@SuppressWarnings("rawtypes")
	public Class logVOClass() {
		
		return PaydetaillogVO.class;
	}

	
	
	
}
