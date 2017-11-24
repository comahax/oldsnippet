package com.gmcc.pboss.BgProcess.sales.notice;

import java.util.List;

public class DeliverInfo {

	private String discomcode;	//配送商编码
	private Long totalCount;	//总量
	private Double sumPrice;	//总价
	private List<ComcategoryInfo> orders;//定购的商品
	public String getDiscomcode() {
		return discomcode;
	}
	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public List<ComcategoryInfo> getOrders() {
		return orders;
	}
	public void setOrders(List<ComcategoryInfo> orders) {
		this.orders = orders;
	}
	
	
}
