package com.gmcc.pboss.common.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.common.support.QueryResult;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class ServiceResult {
	/**
	 * 是否成功
	 */
	protected boolean isSuccess;
	/**
	 * 返回码
	 */
	protected int retCode;
	/**
	 * 描述信息
	 */
	protected String message;
	/**
	 * 返回列表
	 */
	protected QueryResult retResult;
	
	/**
	 * 返回对象
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
