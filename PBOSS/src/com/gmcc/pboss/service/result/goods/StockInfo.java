/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * �����Ϣ
 * 
 * @author hbm
 */
public class StockInfo implements Serializable {
	private String brandName;// Ʒ������
	private int orderStock; // �ڶ����
	private int basicStock;// ��׼���
	private int nonceStock;// ��ǰ���
	private int nonceMaxStock;// ��ǰ�������

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getOrderStock() {
		return orderStock;
	}

	public void setOrderStock(int orderStock) {
		this.orderStock = orderStock;
	}

	public int getBasicStock() {
		return basicStock;
	}

	public void setBasicStock(int basicStock) {
		this.basicStock = basicStock;
	}

	public int getNonceStock() {
		return nonceStock;
	}

	public void setNonceStock(int nonceStock) {
		this.nonceStock = nonceStock;
	}

	public int getNonceMaxStock() {
		return nonceMaxStock;
	}

	public void setNonceMaxStock(int nonceMaxStock) {
		this.nonceMaxStock = nonceMaxStock;
	}

}
