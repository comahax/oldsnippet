package com.gmcc.pboss.control.service.sms.queryordercount;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 【订购上限查询】短厅接口逻辑
 * @author yangdaren
 *
 */
public class Ordercom extends BaseVO implements Serializable {

	private Long orderMax;
	private String cityrescode;
	private String comcategory;
	
    /** default constructor */
    public Ordercom() {
    }
    
	public Long getOrderMax() {
		return orderMax;
	}
	public void setOrderMax(Long orderMax) {
		this.orderMax = orderMax;
	}
	public String getCityrescode() {
		return cityrescode;
	}
	public void setCityrescode(String cityrescode) {
		this.cityrescode = cityrescode;
	}
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	
}
