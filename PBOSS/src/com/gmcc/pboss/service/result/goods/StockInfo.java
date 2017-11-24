/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * 库存信息
 * 
 * @author hbm
 */
public class StockInfo implements Serializable {
	private String brandName;// 品牌名称
	private int orderStock; // 在订库存
	private int basicStock;// 基准库存
	private int nonceStock;// 当前库存
	private int nonceMaxStock;// 当前最大库存量

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
