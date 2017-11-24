package com.sunrise.jop.common.spring;

import java.util.*;

import org.apache.commons.logging.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

/**
 * Spring �����Ĺ�������ContextManager
 * 
 * @author He Kun
 * 
 */
public class SpringContextManager {

	
	public static final String CONFIG_NAME = "applicationContext.xml";
	public static final String CONFIG_NAME2 = "applicationContext2.xml";
	public static final String CONFIG_NAME3 = "applicationContext3.xml";
	
	public static final String HIBERNATE_SESSION_FACTORY_NAME = "sessionFactory"; // ע�뵽spring�����ڵ�hibernate��beanName
	public static final String HIBERNATE_SESSION_DATASOURCE = "dataSource"; // ע�뵽spring�����ڵ�hibernate������Դ��
	
	public static final Log log = LogFactory.getLog(SpringContextManager.class);

	private static AbstractXmlApplicationContext context;

	static {
		init();
	}

	public static void init() {
		context = new ClassPathXmlApplicationContext(CONFIG_NAME);
	}

	public static void init2() {
		context = new ClassPathXmlApplicationContext(new String[] { CONFIG_NAME2 }, context);
	}
	
	public static void init3() {
		context = new ClassPathXmlApplicationContext(new String[] { CONFIG_NAME3 }, context);
	}

	/**
	 * ��ȡȱʡ���ã���һ�����ã���Ӧ��context
	 * 
	 * @return
	 */
	public static DefaultListableBeanFactory getDefaultBeanFactory() {
		return (DefaultListableBeanFactory) context.getBeanFactory();
	}

	/**
	 * ��ȱʡ��bean�����л�ȡָ�����Ƶ�beanʵ��
	 * 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getBean(name, null);
	}

	/**
	 * �ж�ȱʡbean�������Ƿ����ָ����Bean
	 * 
	 * @param beanName
	 * @return
	 */
	public static boolean containsBean(String beanName) {
		return getDefaultBeanFactory().containsBean(beanName);
	}

	/**
	 * ��ȱʡ��bean�����л�ȡָ�����Ƶ�beanʵ��
	 * 
	 * @param name
	 * @param args
	 * @return
	 */
	public static Object getBean(String name, Object[] args) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if (args == null)
			return beanFactory.getBean(name, args);
		else
			return beanFactory.getBean(name, args); // ������������⣬Spring��֧�ֹ��캯�����Σ������޸�
	}

	/**
	 * ע��bean����,ʹ��protype
	 * 
	 * @param idOrName
	 * @param beanClass
	 */
	public static void registerBean(String idOrName, Class beanClass) {
		registerBean(idOrName, beanClass, false);
	}

	/**
	 * ע��bean����
	 * 
	 * @param idOrName
	 * @param beanClass
	 * @param isSingleton
	 */
	public static void registerBean(String idOrName, Class beanClass, boolean isSingleton) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if (!beanFactory.containsBean(idOrName)) {

			RootBeanDefinition beanDefinition = new RootBeanDefinition();
			beanDefinition.setBeanClassName(beanClass.getName());
			beanDefinition.setSingleton(isSingleton); // Ĭ��Ϊtrue, ��Ҫ���ӿ�������
			beanFactory.registerBeanDefinition(idOrName, beanDefinition);

			if (log.isDebugEnabled())
				log.debug("ע��bean: " + idOrName + " singleton?:" + isSingleton);
		}

	}

	/**
	 * ��ȡbean����
	 * 
	 * @param beanName
	 */
	public static BeanDefinition getBeanDefinition(String beanName) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		BeanDefinition def = beanFactory.getBeanDefinition(beanName);
		return def;
	}

	/**
	 * demo
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringContextManager.registerBean(HashMap.class.getName(), HashMap.class);
		Map hashMap = (Map) SpringContextManager.getBean(HashMap.class.getName());
		System.out.println("bean:" + hashMap);
	}
}
