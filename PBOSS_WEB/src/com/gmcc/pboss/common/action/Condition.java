/**
 * 
 */
package com.gmcc.pboss.common.action;

import java.io.Serializable;
import java.util.Date;

/**
 * ��װ���ò�ѯ����
 */
public class Condition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 105344397438518109L;
	/**
	 * ���
	 */
	private String code;
	/**
	 * ��ʼʱ��
	 */
	private Date startDate;
	/**
	 * ����ʱ��
	 */
	private Date endDate;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
