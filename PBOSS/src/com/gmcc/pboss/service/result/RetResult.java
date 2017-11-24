/**
 * 
 */
package com.gmcc.pboss.service.result;

import java.io.Serializable;

/**
 * ������ػ���
 * 
 * @author hbm
 */
public class RetResult implements Serializable {
	
	static final public int SUCCESS = 0;  //�ɹ�
	static final public int FAILURE = 1;  //ʧ��
	static final public int ERROR = 2;    //ϵͳ����
	
	private int retCode; // ������
	private String message; // ������Ϣ

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
