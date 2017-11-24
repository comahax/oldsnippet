package com.sunrise.boss.common.base.control;

import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import javax.ejb.EJBLocalHome;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.common.base.locator.ServiceLocator;

/**
 * <p>Title: Control制造工厂</p>
 *
 * <p>
 *     Description: 根据配置生成一个AbstractControl对象
 *     当WHAT_TYPE＝1时，返回Bean对象，当WHAT_TYPE＝2时，返回Local EJB。
 * </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author HuangBaiming && DuHuazheng
 *
 * @version 1.0
 */
public class ControlFactory {
	/**
	 * 工厂核心,构造一个control
	 * 
	 * @param controlBeanClass
	 *            Class ControlBean类
	 */
	public static AbstractControl build(Class controlBeanClass) throws Exception {
		SpringContextManager.registerBean(controlBeanClass.getName(), controlBeanClass);
		AbstractControl control = (AbstractControl) SpringContextManager.getBean(controlBeanClass.getName());
		return control;
	}
 
}
