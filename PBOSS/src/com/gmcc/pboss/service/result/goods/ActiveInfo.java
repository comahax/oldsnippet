/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * ������Ϣ
 * 
 * @author hbm
 */
public class ActiveInfo implements Serializable {
	private String brandName; // Ʒ������
	private double actRate; // �����ʣ���λ��%
	private boolean isFulfilStandard; // �Ƿ��꣺���true��δ���false
	private int filStandardGap; // ����࣬��λ����

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public double getActRate() {
		return actRate;
	}

	public void setActRate(double actRate) {
		this.actRate = actRate;
	}

	public boolean isFulfilStandard() {
		return isFulfilStandard;
	}

	public void setFulfilStandard(boolean isFulfilStandard) {
		this.isFulfilStandard = isFulfilStandard;
	}

	public int getFilStandardGap() {
		return filStandardGap;
	}

	public void setFilStandardGap(int filStandardGap) {
		this.filStandardGap = filStandardGap;
	}

}
