package com.sunrise.boss.common.base.control;

import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import javax.ejb.EJBLocalHome;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.common.base.locator.ServiceLocator;

/**
 * <p>Title: Control���칤��</p>
 *
 * <p>
 *     Description: ������������һ��AbstractControl����
 *     ��WHAT_TYPE��1ʱ������Bean���󣬵�WHAT_TYPE��2ʱ������Local EJB��
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
	 * ��������,����һ��control
	 * 
	 * @param controlBeanClass
	 *            Class ControlBean��
	 */
	public static AbstractControl build(Class controlBeanClass) throws Exception {
		SpringContextManager.registerBean(controlBeanClass.getName(), controlBeanClass);
		AbstractControl control = (AbstractControl) SpringContextManager.getBean(controlBeanClass.getName());
		return control;
	}
 
}
