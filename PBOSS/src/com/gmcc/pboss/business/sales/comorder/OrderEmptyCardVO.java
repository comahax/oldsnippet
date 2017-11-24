package com.gmcc.pboss.business.sales.comorder;

import java.io.Serializable;
import com.sunrise.jop.infrastructure.db.BaseVO;

public class OrderEmptyCardVO extends BaseVO implements Serializable {

	private String restype; // 商品种类
	private String curmaxstock; // 当前最大订购量
	private String maxstock; // 最高库存
	private String curstock; // 已领用量
	private String usecount; // 已使用量
	private String badcount; // 坏卡数量
	private String orderedMonth; // 当月已订购
	private String alarmvalue; // 预警阀值

	public OrderEmptyCardVO(String restype, String curmaxstock,
			String maxstock, String curstock, String usecount, String badcount,
			String orderedMonth, String alarmvalue) {
		super();
		this.restype = restype;
		this.curmaxstock = curmaxstock;
		this.maxstock = maxstock;
		this.curstock = curstock;
		this.usecount = usecount;
		this.badcount = badcount;
		this.orderedMonth = orderedMonth;
		this.alarmvalue = alarmvalue;
	}

	public OrderEmptyCardVO() {
		super();
	}

	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public String getAlarmvalue() {
		return alarmvalue;
	}

	public void setAlarmvalue(String alarmvalue) {
		this.alarmvalue = alarmvalue;
	}

	public String getMaxstock() {
		if (this.maxstock == null) {
			this.maxstock = "0";
		}
		return maxstock;
	}

	public void setMaxstock(String maxstock) {
		this.maxstock = maxstock;
	}

	public String getCurstock() {
		if (this.curstock == null) {
			this.curstock = "0";
		}
		return curstock;
	}

	public void setCurstock(String curstock) {
		this.curstock = curstock;
	}

	public String getCurmaxstock() {
		if (this.curmaxstock == null) {
			this.curmaxstock = "0";
		}
		return curmaxstock;
	}

	public void setCurmaxstock(String curmaxstock) {
		this.curmaxstock = curmaxstock;
	}

	public String getUsecount() {
		if (this.usecount == null) {
			this.usecount = "0";
		}
		return usecount;
	}

	public void setUsecount(String usecount) {
		this.usecount = usecount;
	}

	public String getBadcount() {
		if (this.badcount == null) {
			this.badcount = "0";
		}
		return badcount;
	}

	public void setBadcount(String badcount) {
		this.badcount = badcount;
	}

	public String getOrderedMonth() {
		if (this.orderedMonth == null) {
			this.orderedMonth = "0";
		}
		return orderedMonth;
	}

	public void setOrderedMonth(String orderedMonth) {
		this.orderedMonth = orderedMonth;
	}

}
