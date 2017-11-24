/**
* auto-generated code
* 2006.08.08
*/
package com.sunrise.boss.business.fee.integral.custinte.persistent;

import java.util.Date;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CustInteListVO</p>
 * <p>Description: Query Params Object for CustInteDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author mys 
 * @version 1.0
 */
public class CustInteListVO extends BaseListVO {
	
	private String _ne_custid;
	private String _ne_integralcyc;

	//	查询字段
	private String mobilenum;
	
	//处理积分转移字段	
	private String mobileno;
	
	private Long transferinte;
	
	private Long intecyc;	
	
	private String datas;

	private Date stoptime;

	
	


	public Date getStoptime() {
		return stoptime;
	}

	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}

	public String get_ne_custid() {
		return _ne_custid;
	}

	public void set_ne_custid(String _ne_custid) {
		this._ne_custid = _ne_custid;
	}



	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public Long getIntecyc() {
		return intecyc;
	}

	public void setIntecyc(Long intecyc) {
		this.intecyc = intecyc;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getTransferinte() {
		return transferinte;
	}

	public void setTransferinte(Long transferinte) {
		this.transferinte = transferinte;
	}

	public String get_ne_integralcyc() {
		return _ne_integralcyc;
	}

	public void set_ne_integralcyc(String _ne_integralcyc) {
		this._ne_integralcyc = _ne_integralcyc;
	}

    
}
