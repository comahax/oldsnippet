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
public class BookInfo implements Serializable {
	private String brandName;// Ʒ������
	private int canBookNonceMonth;// ���¿ɶ���������λ����
	private int bookedNonceMonth;// �����Ѷ���������λ����
	private int surBookNonceMonth;// ����ʣ�ඩ��������λ����
	private int canBookToday;// ����ɶ���������λ����
	private int bookedToday;// �����Ѷ���������λ����
	private int surBookToday;// ����ʣ�ඩ��������λ����

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getCanBookNonceMonth() {
		return canBookNonceMonth;
	}

	public void setCanBookNonceMonth(int canBookNonceMonth) {
		this.canBookNonceMonth = canBookNonceMonth;
	}

	public int getBookedNonceMonth() {
		return bookedNonceMonth;
	}

	public void setBookedNonceMonth(int bookedNonceMonth) {
		this.bookedNonceMonth = bookedNonceMonth;
	}

	public int getSurBookNonceMonth() {
		return surBookNonceMonth;
	}

	public void setSurBookNonceMonth(int surBookNonceMonth) {
		this.surBookNonceMonth = surBookNonceMonth;
	}

	public int getCanBookToday() {
		return canBookToday;
	}

	public void setCanBookToday(int canBookToday) {
		this.canBookToday = canBookToday;
	}

	public int getBookedToday() {
		return bookedToday;
	}

	public void setBookedToday(int bookedToday) {
		this.bookedToday = bookedToday;
	}

	public int getSurBookToday() {
		return surBookToday;
	}

	public void setSurBookToday(int surBookToday) {
		this.surBookToday = surBookToday;
	}

}
