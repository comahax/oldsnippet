package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

public class MondaystockInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String brandName;				//Ʒ������
	private int  canBookNonceMonth;			//���¿ɶ���������λ����
	private int bookedNonceMonth; 			//�����Ѷ���������λ����
	private int surBookNonceMonth;			//����ʣ�ඩ��������λ����
	private int canBookToday;				//����ɶ���������λ����
	private int bookedToday;				//�����Ѷ���������λ����
	private int surBookToday;				//����ʣ�ඩ��������λ����
	private int basicStock;					//��׼��棬��λ����
	private int nonceStock;					//��ǰ��棬��λ����
	private int nonceMaxStock;				//��ǰ�����������λ����
	private int refMaxStock;				//��󶩹����ο�����λ����
	
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
	public int getRefMaxStock() {
		return refMaxStock;
	}
	public void setRefMaxStock(int refMaxStock) {
		this.refMaxStock = refMaxStock;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	

}
