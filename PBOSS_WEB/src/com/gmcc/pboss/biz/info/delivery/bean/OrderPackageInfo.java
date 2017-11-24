package com.gmcc.pboss.biz.info.delivery.bean;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * ���˹�˾Ӫ�˲�
 * @author yuwenjun
 * @date 2009-10-3
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������������Ʒ��Ʒ��Ϣ
 */
public class OrderPackageInfo extends CodeReverse {
	/**
	 * ��Ʒ����
	 */
	private String comcategory;
	/**
	 * �� ��
	 */
	private String batchno;
	/**
	 * ����
	 */
	private String boxnum;
	/**
	 * ������������
	 */
	private String ordercomtype;
	/**
	 * ����
	 */
	private Integer count = new Integer(0);
	
	/**
	 * ��С����
	 */
	private String minres;
	
	/**
	 * ������
	 */
	private String maxres;
	
	
	/**
	 * @return the comcategory
	 */
	public String getComcategory() {
		return comcategory;
	}
	/**
	 * @param comcategory the comcategory to set
	 */
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	/**
	 * @return the batchno
	 */
	public String getBatchno() {
		return batchno;
	}
	/**
	 * @param batchno the batchno to set
	 */
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	/**
	 * @return the boxnum
	 */
	public String getBoxnum() {
		return boxnum;
	}
	/**
	 * @param boxnum the boxnum to set
	 */
	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}
	/**
	 * @return the ordercomtype
	 */
	public String getOrdercomtype() {
		return ordercomtype;
	}
	/**
	 * @param ordercomtype the ordercomtype to set
	 */
	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}
	/**
	 * @return the minres
	 */
	public String getMinres() {
		return minres;
	}
	/**
	 * @param minres the minres to set
	 */
	public void setMinres(String minres) {
		this.minres = minres;
	}
	/**
	 * @return the maxres
	 */
	public String getMaxres() {
		return maxres;
	}
	/**
	 * @param maxres the maxres to set
	 */
	public void setMaxres(String maxres) {
		this.maxres = maxres;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	

}
