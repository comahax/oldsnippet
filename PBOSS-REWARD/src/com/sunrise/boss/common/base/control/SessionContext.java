package com.sunrise.boss.common.base.control;

/**
 * <p>
 * Title: SessionContextʵ���� J2EE1.3
 * </p>
 * 
 * <p>
 * Description: ģ��EJB�������ɵ�SessionContextʵ��
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise
 * </p>
 * 
 * @author HuangBaiming
 * 
 * @version 1.0
 */
public class SessionContext {
	private boolean isRollbackOnly; // �ع���־λ

	public SessionContext() {
		isRollbackOnly = false;
	}

	public void setRollbackOnly() throws IllegalStateException {
		isRollbackOnly = true;
	}

}
