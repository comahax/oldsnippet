/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import com.gmcc.pboss.service.result.RetResult;

/**
 * ��Ʒ��Ϣ
 * 
 * @author hbm
 */
public class GoodsInfo extends RetResult {
	private double price;// �ۼۣ���λԪ��
	private int radix; // ��������������0ʱ��ʾû�ж���������

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
