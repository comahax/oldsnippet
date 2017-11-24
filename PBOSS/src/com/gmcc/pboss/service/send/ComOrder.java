/**
 * 
 */
package com.gmcc.pboss.service.send;

import java.io.Serializable;

/**
 * 商品订购类
 * 
 * @author hbm
 */
public class ComOrder implements Serializable {
	private String comType;// 商品种类
	private int orderCount;// 订购套数
	private String batchNo;// 批次号
	private String packageNo; // 包号

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
