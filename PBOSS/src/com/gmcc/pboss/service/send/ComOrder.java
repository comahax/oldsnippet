/**
 * 
 */
package com.gmcc.pboss.service.send;

import java.io.Serializable;

/**
 * ��Ʒ������
 * 
 * @author hbm
 */
public class ComOrder implements Serializable {
	private String comType;// ��Ʒ����
	private int orderCount;// ��������
	private String batchNo;// ���κ�
	private String packageNo; // ����

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

}
