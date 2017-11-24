package com.sunrise.boss.common.base.control;



/**
 * <p>Title: 抽象ControlBean类</p>
 *
 * <p>Description: 封装了SessionBean、EJBLocalObject接口必须实现的方法</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 *
 * @version 1.0
 */
public class AbstractControlBean implements AbstractControl {
	
	//遗留代码
    public SessionContext sessionContext = new SessionContext();

}
