package com.gmcc.pboss.common.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.support.QueryResult;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-29
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public class ServiceResult {
	/**
	 * �Ƿ�ɹ�
	 */
	protected boolean isSuccess;
	/**
	 * ������
	 */
	protected int retCode;
	/**
	 * ������Ϣ
	 */
	protected String message;
	/**
	 * �����б�
	 */
	protected QueryResult retResult;
	
	/**
	 * ���ض���
	 */
	protected Object retObject;

	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the retCode
	 */
	public int getRetCode() {
		return retCode;
	}

	/**
	 * @param retCode the retCode to set
	 */
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the retResult
	 */
	public QueryResult getRetResult() {
		return retResult;
	}

	/**
	 * @param retResult the retResult to set
	 */
	public void setRetResult(QueryResult retResult) {
		this.retResult = retResult;
	}

	/**
	 * @return the retObject
	 */
	public Object getRetObject() {
		return retObject;
	}

	/**
	 * @param retObject the retObject to set
	 */
	public void setRetObject(Object retObject) {
		this.retObject = retObject;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
