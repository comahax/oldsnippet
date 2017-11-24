package com.sunrise.boss.common.base.control;

/**
 * <p>
 * Title: SessionContext实现类 J2EE1.3
 * </p>
 * 
 * <p>
 * Description: 模拟EJB容器生成的SessionContext实例
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
	private boolean isRollbackOnly; // 回滚标志位

	public SessionContext() {
		isRollbackOnly = false;
	}

	public void setRollbackOnly() throws IllegalStateException {
		isRollbackOnly = true;
	}

}
