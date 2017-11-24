/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * 激活信息
 * 
 * @author hbm
 */
public class ActiveInfo implements Serializable {
	private String brandName; // 品牌名称
	private double actRate; // 激活率，单位：%
	private boolean isFulfilStandard; // 是否达标：达标true，未达标false
	private int filStandardGap; // 达标差距，单位：套

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
