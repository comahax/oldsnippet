/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import com.gmcc.pboss.service.result.RetResult;

/**
 * 商品信息
 * 
 * @author hbm
 */
public class GoodsInfo extends RetResult {
	private double price;// 售价，单位元。
	private int radix; // 订购基数。返回0时表示没有订购基数。

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRadix() {
		return radix;
	}

	public void setRadix(int radix) {
		this.radix = radix;
	}
}
