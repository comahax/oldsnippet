/**
 * 
 */
package com.sunrise.jop.common.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author He Kun
 *
 */
public class BeanFactory {
	
	private static Log log = LogFactory.getLog(BeanFactory.class);
	/**
	 * ��Spring�����л�ȡbean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		
		if(SpringContextManager.containsBean(name))
			return SpringContextManager.getBean(name);
		else {
			throw new BeanNotFoundException(name);
		}
	}
	
	public static Object getBean(Class beanClass) {
		return getBean(beanClass.getName());
	}
	
	/**
	 * ͨ��Spring��������bean
	 * ���л���bean��scope �������ͻ��bean��scopeȡ�����һ�δ���ʱ�����scope��
	 * @param name
	 * @param beanClass
	 * @param isSingleton
	 * @return
	 */
	public static Object createBean(String name,Class beanClass,boolean isSingleton ) {
		
		if(!SpringContextManager.containsBean(name)) {
			
//			if(log.isDebugEnabled())
//				log.debug("bean dynamic register " + name +",class:" + beanClass +",scope(singleton?)" + isSingleton );
			SpringContextManager.registerBean(name, beanClass, isSingleton);
		}else {  //���bean��scope �������ͻ��bean��scopeȡ�����һ�δ���ʱ�����scope��
			BeanDefinition def = SpringContextManager.getBeanDefinition(name);
			if(isSingleton != def.isSingleton()) {
				throw new IllegalArgumentException("bean with name '" + name +"' already registered as "
							+ (def.isSingleton() ? "singleton" : "prototype") +", but a prototype scope when create it this time.");
			}
		}
		return getBean(name);	
	}
	
	/**
	 * ͨ��Spring��������bean��bean����prototype
	 * @param name
	 * @param beanClass
	 * @return
	 */
	public static Object createBean(String name,Class beanClass ) {

		return createBean(name, beanClass,false);

		
	}
	
	/**
	 * ͨ��Spring��������bean��bean����prototype
	 * @param name
	 * @param beanClass
	 * @return
	 */
	public static Object createBean(Class beanClass ) {
		return createBean(beanClass.getName(), beanClass);
		
	}
	
	

	/**
	 * ͨ��Spring��������bean��bean����prototype
	 * @param name
	 * @param beanClass
	 * @param isSingleton
	 * @return
	 */
	public static Object createBean(Class beanClass,boolean isSingleton ) {
		return createBean(beanClass.getName(), beanClass, isSingleton);
		
	}
}
