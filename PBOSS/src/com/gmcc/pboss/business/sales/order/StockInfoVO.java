package com.gmcc.pboss.business.sales.order;

public class StockInfoVO {
	private String countyid;
	private String svccode;
	private String ordercomtype;
	private String comcategory;
	private long stocks;
	private long assignStocks;
	private long orderamt;
	
	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public long getStocks() {
		return stocks;
	}

	public void setStocks(long stocks) {
		this.stocks = stocks;
	}

	public long getAssignStocks() {
		return assignStocks;
	}

	public void setAssignStocks(long assignStocks) {
		this.assignStocks = assignStocks;
	}

	public long getOrderamt() {
		return orderamt;
	}

	public void setOrderamt(long orderamt) {
		this.orderamt = orderamt;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getOrdercomtype() {
		return ordercomtype;
	}

	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}

}
