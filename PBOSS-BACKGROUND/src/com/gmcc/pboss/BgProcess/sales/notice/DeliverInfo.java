package com.gmcc.pboss.BgProcess.sales.notice;

import java.util.List;

public class DeliverInfo {

	private String discomcode;	//�����̱���
	private Long totalCount;	//����
	private Double sumPrice;	//�ܼ�
	private List<ComcategoryInfo> orders;//��������Ʒ
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
