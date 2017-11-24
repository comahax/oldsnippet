/**
 * 
 */
package com.gmcc.pboss.service.result;

import java.io.Serializable;

/**
 * 结果返回基类
 * 
 * @author hbm
 */
public class RetResult implements Serializable {
	
	static final public int SUCCESS = 0;  //成功
	static final public int FAILURE = 1;  //失败
	static final public int ERROR = 2;    //系统错误
	
	private int retCode; // 返回码
	private String message; // 返回信息

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
